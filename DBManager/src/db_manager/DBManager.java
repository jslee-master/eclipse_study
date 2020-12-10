package db_manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import oracle.jdbc.pool.OracleDataSource;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

// 버튼, table style
// ? 조건 입력창에 입력할때마다 쿼리문 출력
// ! 쿼리문 실행 오류시 DBconn check

// Application 클래스를 상속받아 사용
public class DBManager extends Application {

	// *** 필드 ***
	// static으로 선언한 필드들은 실행 시 자동으로 생성되며, 클래스 내에서 공유되어 사용됨
	static OracleDataSource ods = null;	
	// 오라클과 연결에 필요한 기본정보를 설정하는데 사용됨. 기본정보는 오라클 접속 방법 및 주소, 사용자 계정, 사용자 비밀번호 등이 있다.

	static Connection conn = null;			
	// ods로 설정된 정보를 이용하여 오라클과 실제로 연결을 설정하는데 사용된다. ods에 설정된 오라클 접속 방법 및 주소, 
	// 사용자 계정, 비밀번호 등을 이용하여 연결하고 그 정보가 con 변수에 저장된다. con 변수를 이용하여 SQL문을 실행시킬 수 있다.

	static Statement stmt = null;
	// stmt는 연결된 오라클에 SQL문을 실행시키기 위해 사용된다.

	static ResultSet rs = null;
	// stmt 변수를 이용하여 실행시킬 수 있는 SQL문들 중에서 select문의 실행 결과는 Result-Set으로 선언된 변수인 rs에 전달되어 저장된다.
	// rs 변수를 이용하면 select 문의 실행 결과를 프로그램에서 다룰 수 있게 된다.

	Stage inputStage = new Stage(); // 사용자로부터 조건을 입력받는 추가 공간, 여러 함수에서 사용되기 때문에 클래스 내 선언

	// 접속에 필요한 정보들을 초기화함, 접속 실패 시 변경 가능
	static String url = "jdbc:oracle:thin:@localhost:1521/orcl";  // oracle developer에서 DB의 URL
	static String user = "ljs";		// DB 사용자명
	static String password = "1234";	// 비밀 번호

	String query;				// 실행 할 쿼리문, 여러 함수에서 사용되기 때문에 클래스 내 선언

	// 화면에 DB 정보를 출력하는 창, TableView
	private TableView<EmpData> outputTable = new TableView<>();

	// DB 정보를 EmpData라는 클래스에 한 개의 row씩 저장되고, 여러 EmpData를 List로 저장하기 위해
	// 다음 list형을 선언하여 사용, null로 초기화
	private ObservableList<EmpData> dataList = FXCollections.observableArrayList();

	// 1. EmpData 객체를 생성하고 DB에서 불러온 정보 한 row씩 저장
	// 2. 한 row의 정보를 Empdata 리스트인 dataList에 추가, 모든 데이터에 대하여 반복
	// TableView에 dataList를 모두 출력함

	// 테이블 뷰에 출력할 EmpData 클래스
	public static class EmpData {

		// tableview에서 사용하기 위한 타입, 단순히 name, age, salary는 String, index는 Integer형
		private SimpleStringProperty name, age, salary;
		private SimpleIntegerProperty index;

		// 기본 생성자, 설정하지 않음
		private EmpData() {}

		// 매개변수로 name, age, salary, index 값을 넘겨주어 필드에 저장하는 생성자
		private EmpData(Integer index, String name, String age, String salary) {
			this.index = new SimpleIntegerProperty(index);
			this.name = new SimpleStringProperty(name);
			this.age = new SimpleStringProperty(age);
			this.salary = new SimpleStringProperty(salary);
		}

		// getter, setter 메소드
		// 값을 매개변수로 받아서 각 필드에 저장하는 함수 get
		// 각 필드가 가진 값을 가져오는(리턴) 함수 set
		public Integer getIndex() {
			return index.get();
		}

		public void setIndex(Integer indexData) {
			index.set(indexData);
		}
		public String getName() {
			return name.get();
		}

		public void setName(String nameData) {
			name.set(nameData);
		}

		public String getAge() {
			return age.get();
		}

		public void setAge(String ageData) {
			age.set(ageData);
		}
		public String getSalary() {
			return salary.get();
		}

		public void setSalary(String salaryData) {
			salary.set(salaryData);
		}
	}

	// *** 메소드 ***
	// DB 연결 함수 dbConn()

	// DB 연결 시도, 실패할수 도 있는 경우를 try, catch 구문으로 익셉션(SQLException)
	// try 구문 안을 실행하고 오류가 발생하면 catch 구문을 실행
	public void dbConn() {
		try {
			// ods를 생성하고 url, user, pw를 설정한 뒤 연결함
			// 연결에 성공하면 stmt에 쿼리문을 실행할 수 있는 statement 생성
			ods = new OracleDataSource();
			ods.setURL(url);
			ods.setUser(user);
			ods.setPassword(password);
			conn = ods.getConnection();
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// 연결에 실패했을 경우 경고 메시지 후, DB 연결 창 생성, url, user, password를 입력받아 재시도함
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setTitle("Error");
			errorAlert.setHeaderText("Error : DB 연결에 실패했습니다.");
			errorAlert.setContentText("URL, 사용자명, 비밀번호를 다시 설정합니다.");
			errorAlert.showAndWait();

			//TextInputDialog asd = new TextInputDialog();
			Stage DBConnGUI = new Stage();
			BorderPane DBCRoot = new BorderPane();
			DBCRoot.setPadding(new Insets(5));	// 바깥쪽 여백 설정, Insets(5)는 왼,오,위,아래를 모두 5로 설정
			DBCRoot.setPrefWidth(400);	// 넓이 설정
			DBCRoot.setPrefHeight(300);	// 높이 설정

			// 상단 Label (창 제목)
			Label tittleLb = new Label("DB 연결 설정");
			tittleLb.setFont(new Font(20));

			// 중단 GridPane 컨테이너 생성, GridPane은 col과 row의 인덱스로 object를 배치할 수 있음
			// ex)
			// (0,0)  (1,0)            GridPane의 객체명.add(배치할 객체명, col, row)
			// (0,1)  (1,1)
			// (0,2)  (1,2)
			GridPane inputPane = new GridPane();
			
			// Label, 텍스트 입력 공간
			Label urlLb = new Label("URL : ");
			urlLb.setFont(new Font(15));
			//중단 GridPane인 inputPane 객체에 urlLb 라벨을 col 0, row 0 위치에 추가함
			inputPane.add(urlLb, 0, 0);	

			Label userLb = new Label("User : ");
			userLb.setFont(new Font(15));
			inputPane.add(userLb, 0, 1);

			Label pwLb = new Label("PassWord : ");
			pwLb.setFont(new Font(15));
			inputPane.add(pwLb, 0, 2);

			// TextField, gridpane 두 번째 열에 한 행씩 add
			TextField urlTF = new TextField(url); //텍스트필드 추가
			urlTF.setFont(new Font(15));
			inputPane.add(urlTF, 1, 0);

			TextField userTF = new TextField(user); //텍스트필드 추가
			userTF.setFont(new Font(15));
			inputPane.add(userTF, 1, 1);

			TextField pwTF = new TextField(password); //텍스트필드 추가
			pwTF.setFont(new Font(15));
			inputPane.add(pwTF, 1, 2);

			// 데이터 연결 버튼
			Button runButton = new Button("연결");
			runButton.setPrefSize(100, 50);	// 넓이 높이 설정

			// 데이터 연결 버튼 이벤트
			runButton.setOnAction(event -> {
				url = urlTF.getText();
				user = userTF.getText();
				password = pwTF.getText();
				
				// Platform.runLater() 는 gui는 프로그램 내에서 수행되지만, DB연결이나 네트워크 연결 등은
				// 매체 간의 통신이기 때문에 시간이 걸림. 따라서, gui가 수행되기 전에 DB연결을 완전히 수행한 뒤에
				// gui를 변경하거나 다음 작업을 수행하도록 대기하게 함
				// 만약, 다음 Platform.runLater()가 없다면 연속해서 DB 연결을 여러 번 시도해서 
				// DB 연결 시도 중에 
				Platform.runLater(() -> {
					// DB 연결 창이 띄워져 있다면 닫음
					if(DBConnGUI.isShowing()) DBConnGUI.close();
				});
				
				// dbConn() 함수 내에서 dbConn()를 재귀하여 접속할 때까지 반복함
				dbConn();
			});

			// DB 연결 창 닫기 버튼 클릭 시 이벤트 재설정 : 프로그램을 완전히 종료함
			DBConnGUI.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent e) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Oracle DB Manager 종료");
					alert.setHeaderText("DB Manager를 종료하시겠습니까?");
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						Platform.exit();
					} else if (result.get() == ButtonType.CANCEL) {
						// 이벤트 처리 취소 메소드 consume, 닫기 버튼 이벤트 종료
						e.consume();
					}
				}
			});
			DBCRoot.setTop(tittleLb);
			DBCRoot.setCenter(inputPane);
			DBCRoot.setBottom(runButton);

			BorderPane.setMargin(tittleLb, new Insets(10));
			BorderPane.setMargin(runButton, new Insets(10));

			inputPane.setAlignment(Pos.CENTER);
			BorderPane.setAlignment(tittleLb, Pos.CENTER);
			BorderPane.setAlignment(runButton, Pos.CENTER);
			Scene dbConnSc = new Scene(DBCRoot, 400, 300);
			DBConnGUI.setTitle("DB 연결");
			DBConnGUI.setScene(dbConnSc);
			DBConnGUI.focusedProperty();
			DBConnGUI.showAndWait();
		}
	}
	// TableView에 row를 추가하여 출력하는 메소드 printData
	// printData는 "select * from emp" 문 뒤의 추가 조건문을 String으로 받고
	// 출력에 성공했을 때의 알림 메시지(alert)을 Alert으로 받는다
	// textArea에 데이터를 출력하는 함수
	private void printData(String condition, Alert successAlert) {
		// output 텍스트 출력 공간 지우기
		if(!dataList.isEmpty()) dataList.clear();
		try {
			// stmt로 쿼리문을 실행하고 그 결과를 rs에 저장
			rs = stmt.executeQuery("SELECT * FROM EMP" + condition);
			Integer index = 0;	// 열의 인덱스 생성

			// DB에서 불러온 데이터들을 한 행씩 읽으면서 다음 while문을 실행 
			while (rs.next()) {
				// 필드 명이 name, age, salary 순이기때문에 getString(1) 은 name을 의미
				String name = rs.getString(1);			// VARCHAR2 는 String형 name 에 저장
				String age = rs.getString(2);			// NUMBER 는 int형 age 저장
				String salary = rs.getString(3);		// NUMBER 는 int형 salary 저장
				index++;								// index 1씩 증가

				// 작성한 EmpData 객체를 생성하고 DB에서 불러온 정보를 저장
				EmpData data = new EmpData(index, name, age, salary);
				data.setIndex(index);
				data.setName(name);
				data.setAge(age);
				data.setSalary(salary);

				// Empdata 리스트인 dataList에 EmpData를 추가
				dataList.add(data);
			} 
			// TableView에 dataList를 모두 출력함
			outputTable.setItems(dataList);
			// 매개변수로 받은 alert를 보여줌
			// 검색과 전체 조회 버튼의 성공 메시지를 버튼으로부터 각각 받아서 출력함
			// 검색과 전체 조회 버튼의 메시지가 다름
			if(successAlert != null) successAlert.showAndWait();

			// 쿼리문 실행 오류 시 catch 구문을 실행
		}catch (SQLException e1) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setTitle("Error");
			errorAlert.setHeaderText("실행 오류 !");
			errorAlert.setContentText("Error : SELECT * FROM EMP" + condition);
			errorAlert.showAndWait();
		}
	}

	// 추가, INSERT 문
	private void insert(Stage primaryStage) {

		VBox root = new VBox();
		root.setPadding(new Insets(5));
		root.setPrefWidth(380);
		root.setPrefHeight(300);
		root.setAlignment(Pos.CENTER);

		Text scenetitle = new Text("추가할 데이터 입력"); //일반 텍스트 추가
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		// GridPane 객체 생성
		GridPane inputPane = new GridPane();

		// Label, gridpane 첫 열에 한 행씩 add
		Label label1 = new Label("NAME : ");
		label1.setFont(new Font(15));
		inputPane.add(label1, 0, 0);

		Label label2 = new Label("AGE : ");
		label2.setFont(new Font(15));
		inputPane.add(label2, 0, 1);

		Label label3 = new Label("SALARY : ");
		label3.setFont(new Font(15));
		inputPane.add(label3, 0, 2);

		// TextField, gridpane 두 번째 열에 한 행씩 add
		TextField TextField1 = new TextField(""); //텍스트필드 추가
		TextField1.setFont(new Font(15));
		inputPane.add(TextField1, 1, 0);

		TextField TextField2 = new TextField(""); //텍스트필드 추가
		TextField2.setFont(new Font(15));
		inputPane.add(TextField2, 1, 1);

		TextField TextField3 = new TextField(""); //텍스트필드 추가
		TextField3.setFont(new Font(15));
		inputPane.add(TextField3, 1, 2);

		// 데이터 추가 버튼
		Button insertButton = new Button("추가하기");
		insertButton.setPrefSize(200, 50);

		// 데이터 추가 버튼 이벤트
		insertButton.setOnAction(event -> {
			String v1, v2, v3;
			v1 = TextField1.getText();
			v2 = TextField2.getText();
			v3 = TextField3.getText();
			// 추가 버튼 클릭 시 쿼리문 생성
			query = String.format("INSERT INTO EMP VALUES ('%s', %s, %s)", v1, v2, v3);
			// 확인 창 생성
			Alert confirmAlert1 = new Alert(AlertType.CONFIRMATION);
			confirmAlert1.setTitle("추가");
			confirmAlert1.setHeaderText("Query 를 확인하세요.");
			confirmAlert1.setContentText(query);
			Optional<ButtonType> result = confirmAlert1.showAndWait();
			if (result.get() == ButtonType.OK) {
				// 확인 버튼, 클릭 시 쿼리문 실행
				try {
					stmt.executeQuery(query);
					Alert confirmAlert2 = new Alert(AlertType.INFORMATION);
					confirmAlert2.setTitle("추가");
					confirmAlert2.setHeaderText("데이터 추가에 성공했습니다.");
					confirmAlert2.setContentText("VALUES( " + v1 + ", "+ v2 + ", "+ v3 + ")");
					confirmAlert2.showAndWait();
				}catch (SQLException e1) {	// 쿼리문 실행 오류
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setTitle("Error !");
					errorAlert.setHeaderText("실행 오류");
					errorAlert.setContentText("Error : \"VALUES( " + v1 + ", "+ v2 + ", "+ v3 + ")\"");
					errorAlert.showAndWait();
				}
			} else if (result.get() == ButtonType.CANCEL) {
				// 취소 버튼
				event.consume();
			}

		}  );

		inputPane.setAlignment(Pos.CENTER);
		// 간격설정
		inputPane.setHgap(10);	
		inputPane.setVgap(10);
		inputPane.setPadding(new Insets(30));

		root.getChildren().addAll(scenetitle, inputPane, insertButton);
		Scene s1 = new Scene(root, 380, 300);

		inputStage.setX(primaryStage.getX() - root.getWidth() - 10);
		inputStage.setY(primaryStage.getY() + primaryStage.getHeight() - root.getHeight() - 39); // 39는 타이틀의 높이
		inputStage.setTitle("추가");
		inputStage.setScene(s1);
		inputStage.show();
	}


	// 삭제, DELETE 문
	private void delete(Stage primaryStage) {

		VBox root = new VBox();
		root.setPadding(new Insets(5));
		root.setPrefWidth(380);
		root.setPrefHeight(300);
		root.setAlignment(Pos.CENTER);

		// 제목 텍스트 추가
		Text scenetitle = new Text("삭제 조건 입력"); 
		scenetitle.setFont(Font.font("Tahoma", 20));

		// GridPane 객체 생성, Label과 TextField를 담는 컨테이너
		GridPane inputPane = new GridPane();

		// 데이터 삭제 버튼
		Button insertButton = new Button("삭제하기");
		insertButton.setPrefSize(200, 50);

		// 필드 리스트 뷰, fieldList
		ComboBox<String> fieldList = new ComboBox<String>();
		fieldList.setPromptText("Field");
		fieldList.getItems().add("NAME");
		fieldList.getItems().add("AGE");
		fieldList.getItems().add("SALARY");
		fieldList.setPadding(new Insets(3));		// 안쪽 여백
		VBox.setMargin(fieldList, new Insets(10));	// 바깥 여백

		// Label
		Label field1 = new Label("NAME = ");
		field1.setFont(new Font(15));

		Label field2 = new Label("MIN : ");
		field2.setFont(new Font(15));

		Label field3 = new Label("MAX : ");
		field3.setFont(new Font(15));

		// TextField
		TextField TextField1 = new TextField("");
		TextField1.setFont(new Font(15));

		TextField TextField2 = new TextField("");
		TextField2.setFont(new Font(15));

		TextField TextField3 = new TextField(""); 
		TextField3.setFont(new Font(15));

		// 목록에서 클릭한 필드에 대한 TextField 활성화
		fieldList.setOnAction(event -> {
			// NAME 필드를 선택하면 MIN, MAX 텍스트 필드를 비활성화, NAME은 활성화
			switch(fieldList.getValue()) {
			case "NAME":
				inputPane.getChildren().clear();
				inputPane.add(field1, 0, 0);
				inputPane.add(TextField1, 1, 0);

				break;
				// AGE나 SALARY 필드를 선택하면 NAME 텍스트 필드를 비활성화, MIN과 MAX는 활성화
			default:
				inputPane.getChildren().clear();
				inputPane.add(field2, 0, 1);
				inputPane.add(field3, 0, 2);
				inputPane.add(TextField2, 1, 1);
				inputPane.add(TextField3, 1, 2);
				break;
			}

		});

		// 데이터 삭제 버튼 이벤트
		insertButton.setOnAction(event -> {
			// 쿼리문 생성
			String condition = fieldList.getValue();
			String v1, v2, v3;
			v1 = TextField1.getText();
			v2 = TextField2.getText();
			v3 = TextField3.getText();
			// condition은 선택한 필드명이 저장되어 있음
			switch(condition) {
			case "NAME":
				query = String.format("DELETE FROM EMP WHERE NAME = '%s'", v1);
				break;

			default:
				query = String.format("DELETE FROM EMP WHERE %s BETWEEN %s AND %s", condition, v2, v3);
				break;
			}

			// 확인 창 생성
			Alert confirmAlert1 = new Alert(AlertType.CONFIRMATION);
			confirmAlert1.setTitle("삭제");
			confirmAlert1.setHeaderText("Query 를 확인하세요.");
			confirmAlert1.setContentText(query);
			Optional<ButtonType> result = confirmAlert1.showAndWait();
			if (result.get() == ButtonType.OK) {
				// 확인 버튼, 클릭 시 쿼리문 실행
				try {
					stmt.executeQuery(query);
					Alert confirmAlert2 = new Alert(AlertType.INFORMATION);
					confirmAlert2.setTitle("삭제");
					confirmAlert2.setHeaderText("데이터 삭제에 성공했습니다.");
					confirmAlert2.setContentText(query);
					confirmAlert2.showAndWait();
				}catch (SQLException e1) {	// 쿼리문 실행 오류
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setTitle("Error !");
					errorAlert.setHeaderText("쿼리문 실행 오류");
					errorAlert.setContentText("Error : " + query);
					errorAlert.showAndWait();
				}
			} else if (result.get() == ButtonType.CANCEL) {
				// 취소 버튼
				event.consume();
			}

		});

		inputPane.setAlignment(Pos.CENTER);
		// 간격 설정
		inputPane.setHgap(10);
		inputPane.setVgap(10);
		inputPane.setPadding(new Insets(10));

		root.getChildren().addAll(scenetitle, fieldList, inputPane, insertButton);
		Scene s1 = new Scene(root, 380, 300);

		inputStage.setX(primaryStage.getX() - root.getWidth() - 10);
		inputStage.setY(primaryStage.getY() + primaryStage.getHeight() - root.getHeight() - 39); // 39는 타이틀의 높이
		inputStage.setTitle("삭제");
		inputStage.setScene(s1);
		inputStage.show();
	}


	// 갱신, UPDATE 문
	private void update(Stage primaryStage) {
		VBox root = new VBox();
		root.setPadding(new Insets(5));
		root.setPrefWidth(380);
		root.setPrefHeight(300);
		root.setAlignment(Pos.CENTER);

		Text scenetitle = new Text("갱신할 데이터 입력"); //일반 텍스트 추가
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		// GridPane 객체 생성
		GridPane inputPane = new GridPane();

		// 데이터 갱신 버튼
		Button insertButton = new Button("갱신하기");
		insertButton.setPrefSize(200, 50);

		// 필드 리스트 뷰, fieldList
		ComboBox<String> fieldList = new ComboBox<String>();
		fieldList.setPromptText("Field");
		fieldList.getItems().add("NAME");
		fieldList.getItems().add("AGE");
		fieldList.getItems().add("SALARY");
		fieldList.setPadding(new Insets(3));		// 안쪽 여백
		VBox.setMargin(fieldList, new Insets(10));	// 바깥 여백

		// Label
		Label field1 = new Label("원본 = ");
		field1.setFont(new Font(15));
		inputPane.add(field1, 0, 0);

		Label field2 = new Label("수정 : ");
		field2.setFont(new Font(15));
		inputPane.add(field2, 0, 1);

		// TextField
		TextField TextField1 = new TextField(""); //텍스트필드 추가
		TextField1.setFont(new Font(15));
		inputPane.add(TextField1, 1, 0);

		TextField TextField2 = new TextField(""); //텍스트필드 추가
		TextField2.setFont(new Font(15));
		inputPane.add(TextField2, 1, 1);

		// 데이터 갱신 버튼 이벤트
		insertButton.setOnAction(event -> {
			// 쿼리문 생성
			String condition = fieldList.getValue();
			String v1, v2, v3;
			v1 = TextField1.getText();
			v2 = TextField2.getText();

			query = String.format("UPDATE EMP SET %s = '%s' WHERE %s = '%s'", condition, v2, condition, v1);

			// 확인 창 생성
			Alert confirmAlert1 = new Alert(AlertType.CONFIRMATION);
			confirmAlert1.setTitle("갱신");
			confirmAlert1.setHeaderText("Query 를 확인하세요.");
			confirmAlert1.setContentText(query);
			Optional<ButtonType> result = confirmAlert1.showAndWait();
			if (result.get() == ButtonType.OK) {
				// 확인 버튼, 클릭 시 쿼리문 실행
				try {
					stmt.executeQuery(query);
					Alert confirmAlert2 = new Alert(AlertType.INFORMATION);
					confirmAlert2.setTitle("갱신");
					confirmAlert2.setHeaderText("데이터 갱신에 성공했습니다.");
					confirmAlert2.setContentText("query");
					confirmAlert2.showAndWait();
				}catch (SQLException e1) {	// 쿼리문 실행 오류
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setTitle("Error !");
					errorAlert.setHeaderText("쿼리문 실행 오류");
					errorAlert.setContentText("Error : " + query);
					errorAlert.showAndWait();
				}
			} else if (result.get() == ButtonType.CANCEL) {
				// 취소 버튼
				event.consume();
			}

		});

		inputPane.setAlignment(Pos.CENTER);
		// 간격 설정
		inputPane.setHgap(10);
		inputPane.setVgap(10);
		inputPane.setPadding(new Insets(10));

		root.getChildren().addAll(scenetitle, fieldList, inputPane, insertButton);
		Scene s1 = new Scene(root, 380, 300);

		inputStage.setX(primaryStage.getX() - root.getWidth() - 10);
		inputStage.setY(primaryStage.getY() + primaryStage.getHeight() - root.getHeight() - 39); // 39는 타이틀의 높이
		inputStage.setTitle("갱신");
		inputStage.setScene(s1);
		inputStage.show();

	}

	// 검색
	private void search(Stage primaryStage) {

		VBox root = new VBox();
		root.setPadding(new Insets(5));
		root.setPrefWidth(380);
		root.setPrefHeight(300);
		root.setAlignment(Pos.CENTER);

		Text scenetitle = new Text("검색할 데이터 입력"); //일반 텍스트 추가
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		// GridPane 객체 생성
		GridPane inputPane = new GridPane();

		// 데이터 검색 버튼
		Button insertButton = new Button("검색하기");
		insertButton.setPrefSize(200, 50);

		// 필드 리스트 뷰, fieldList
		ComboBox<String> fieldList = new ComboBox<String>();
		fieldList.setPromptText("Field");
		fieldList.getItems().add("NAME");
		fieldList.getItems().add("AGE");
		fieldList.getItems().add("SALARY");
		fieldList.setPadding(new Insets(3));		// 안쪽 여백
		VBox.setMargin(fieldList, new Insets(10));	// 바깥 여백

		// Label
		Label field1 = new Label("NAME = ");
		field1.setFont(new Font(15));

		Label field2 = new Label("MIN : ");
		field2.setFont(new Font(15));

		Label field3 = new Label("MAX : ");
		field3.setFont(new Font(15));

		// TextField
		TextField TextField1 = new TextField(""); //텍스트필드 추가
		TextField1.setFont(new Font(15));

		TextField TextField2 = new TextField(""); //텍스트필드 추가
		TextField2.setFont(new Font(15));

		TextField TextField3 = new TextField(""); //텍스트필드 추가
		TextField3.setFont(new Font(15));


		// 목록에서 클릭한 필드에 대한 TextField 활성화
		fieldList.setOnAction(event -> {
			switch(fieldList.getValue()) {
			case "NAME":
				// NAME 필드를 선택하면 MIN, MAX 텍스트 필드를 비활성화, NAME은 활성화
				inputPane.getChildren().clear();
				inputPane.add(field1, 0, 0);
				inputPane.add(TextField1, 1, 0);

				break;
				// AGE나 SALARY 필드를 선택하면 NAME 텍스트 필드를 비활성화, MIN과 MAX는 활성화
			default:
				inputPane.getChildren().clear();
				inputPane.add(field2, 0, 1);
				inputPane.add(field3, 0, 2);
				inputPane.add(TextField2, 1, 1);
				inputPane.add(TextField3, 1, 2);
				break;
			}

		});

		// 데이터 검색 버튼 이벤트
		insertButton.setOnAction(event -> {
			// 쿼리문 생성
			String condition = fieldList.getValue();
			String v1, v2, v3;
			v1 = TextField1.getText();
			v2 = TextField2.getText();
			v3 = TextField3.getText();

			switch(condition) {
			case "NAME":
				query = String.format(" WHERE NAME = '%s'", v1);
				break;
			default:
				query = String.format(" WHERE %s BETWEEN %s AND %s", condition, v2, v3);
				break;
			}

			// 확인 창 생성
			Alert confrimAlert1 = new Alert(AlertType.CONFIRMATION);
			confrimAlert1.setTitle("검색");
			confrimAlert1.setHeaderText("Query 를 확인하세요.");
			confrimAlert1.setContentText(query);
			Optional<ButtonType> result = confrimAlert1.showAndWait();
			if (result.get() == ButtonType.OK) {
				Alert successAlert1 = new Alert(AlertType.INFORMATION);
				successAlert1.setTitle("검색");
				successAlert1.setHeaderText("데이터 검색에 성공했습니다.");
				successAlert1.setContentText(query);
				printData(query, successAlert1);
			} else if (result.get() == ButtonType.CANCEL) {
				// 취소 버튼
				event.consume();
			}

		});

		inputPane.setAlignment(Pos.CENTER);
		// 간격 설정
		inputPane.setHgap(10);
		inputPane.setVgap(10);
		inputPane.setPadding(new Insets(10));

		root.getChildren().addAll(scenetitle, fieldList, inputPane, insertButton);
		Scene s1 = new Scene(root, 380, 300);

		inputStage.setX(primaryStage.getX() - root.getWidth() - 10);
		inputStage.setY(primaryStage.getY() + primaryStage.getHeight() - root.getHeight() - 39); // 39는 타이틀의 높이
		inputStage.setTitle("검색");
		inputStage.setScene(s1);
		inputStage.show();
	}


	// Start 메소드
	@Override
	public void start(Stage primaryStage) throws Exception {

		dbConn();

		// 메인 창인 Stage 설정
		// 아이콘 추가

		primaryStage.getIcons().add(new Image("file:src/img/DB_icon.png"));
		primaryStage.setTitle("Oracle DB Manager");

		BorderPane root = new BorderPane();
		root.setPadding(new Insets(5));
		root.setPrefSize(600, 600);

		// 상단 HBox fieldHBox (필드명 라벨)
		HBox fieldHBox = new HBox();
		fieldHBox.setPadding(new Insets(5));
		fieldHBox.setSpacing(120);

		// 상단 제목 필드 Label
		Label tittleText = new Label("EMP Table");
		tittleText.setFont(new Font(30));

		// 상단 HBox에 tittleText 추가
		fieldHBox.setAlignment(Pos.CENTER);
		fieldHBox.getChildren().add(tittleText);

		// 하단 VBox buttonHBox (입력, 삭제, 갱신, 전체 조회, 조건 검색)
		VBox buttonBox = new VBox();
		buttonBox.setPadding(new Insets(5));
		buttonBox.setPrefWidth(600);
		buttonBox.setPrefHeight(100);

		// row를 화면에 출력할 표, TableView클래스 객체 outputTable
		outputTable = new TableView ();

		// outpputTable에 추가할 필드, TableColumn 객체를 생성, 필드명 설정
		TableColumn indexCol = new TableColumn("Index");
		TableColumn nameCol = new TableColumn ("Name");
		TableColumn ageCol = new TableColumn ("Age");
		TableColumn salaryCol = new TableColumn ("Salary");

		// TableColumn 객체들은 setCellValueFactory 메소드로 각 col에 들어갈 데이터 타입과 이름을 설정한다.
		indexCol.setCellValueFactory(new PropertyValueFactory<EmpData, Integer>("index"));
		nameCol.setCellValueFactory(new PropertyValueFactory<EmpData, String>("name"));
		ageCol.setCellValueFactory(new PropertyValueFactory<EmpData, String>("age"));
		salaryCol.setCellValueFactory(new PropertyValueFactory<EmpData, String>("salary"));

		// TableColumn의 메소드 setPrefWidth로 길이를 설정하고, 
		// setMinWidth/setMaxWidth 로 각 열을 줄이거나 늘릴 수 있는 길이를 설정
		indexCol.setPrefWidth(100);
		indexCol.setMinWidth(50);
		indexCol.setMaxWidth(100);

		nameCol.setPrefWidth(160);
		nameCol.setMinWidth(100);
		nameCol.setMaxWidth(200);

		ageCol.setPrefWidth(160);
		ageCol.setMinWidth(100);
		ageCol.setMaxWidth(200);

		salaryCol.setPrefWidth(170);
		salaryCol.setMinWidth(1);
		salaryCol.setMaxWidth(200);

		// 테이블 뷰에 필드명 추가 getColumns 
		outputTable.getColumns(). addAll (indexCol, nameCol, ageCol, salaryCol);

		// 입력, 삭제, 갱신, 검색, 전체 조회 버튼 생성, 사이즈와 스타일(색상) 설정
		Button insertButton = new Button("추가");
		insertButton.setPrefSize(200, 50);
		insertButton.setStyle("-fx-base: #AFEEEE;");

		Button deleteButton = new Button("삭제");
		deleteButton.setPrefSize(200, 50);
		deleteButton.setStyle("-fx-base: #AFEEEE;");

		Button updateButton = new Button("갱신");
		updateButton.setPrefSize(200, 50);
		updateButton.setStyle("-fx-base: #AFEEEE;");

		Button searchButton = new Button("검색");
		searchButton.setPrefSize(300, 50);
		searchButton.setStyle("-fx-base: #AFEEEE;");

		Button allPrintButton = new Button("전체 조회");
		allPrintButton.setPrefSize(300, 50);
		allPrintButton.setStyle("-fx-base: #AFEEEE;");

		HBox box1 = new HBox();	// 윗줄 버튼 박스
		HBox box2 = new HBox();	// 아랫줄 버튼 박스

		box1.getChildren().addAll(insertButton, deleteButton, updateButton);
		box2.getChildren().addAll(searchButton, allPrintButton);

		// buttonBox는 하단에 추가할 VBox
		buttonBox.getChildren().addAll(box1, box2);

		// 입력 버튼 액션 설정
		insertButton.setOnAction(event -> {
			// 데이터 입력 창이 띄워져 있으면 닫고 다시 띄움
			if(inputStage.isShowing()) inputStage.close();

			// CRUD 메소드에 현재 Oracle DB Mangaer 창인 primaryStage를 매개변수로 넘김
			// primaryStage에 대한 작업을 각 메소드에서 실행하기 위함
			insert(primaryStage);
		});

		// 삭제 버튼 액션 설정
		deleteButton.setOnAction(event -> {
			if(inputStage.isShowing()) inputStage.close();

			delete(primaryStage);
		});

		// 갱신 버튼 액션 설정
		updateButton.setOnAction(event -> {
			if(inputStage.isShowing()) inputStage.close();

			update(primaryStage);
		});

		// 검색 버튼 액션 설정
		searchButton.setOnAction(event -> {
			if(inputStage.isShowing()) inputStage.close();

			search(primaryStage);
		});

		// TableView에 row를 추가하여 출력하는 메소드 printData
		// printData는 "select * from emp" 문 뒤의 추가 조건문을 String으로 받고
		// 출력에 성공했을 때의 알림 메시지(alert)을 Alert으로 받는다
		// 전체 조회 버튼 액션 설정
		allPrintButton.setOnAction(event -> {
			Alert successAlert2 = new Alert(AlertType.INFORMATION);
			successAlert2.setTitle("전체 조회");
			successAlert2.setHeaderText("데이터를 불러오는데 성공했습니다.");
			successAlert2.setContentText(query);
			printData("", successAlert2);
		});


		// 윈도우창 닫기 버튼 이벤트 : 확인 메시지
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent e) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Oracle DB Manager 종료");
				alert.setHeaderText("DB Manager를 종료하시겠습니까?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					try {
						// DB 연결을 종료하고 프로그램 종료
						if(rs != null) rs.close();
						if(stmt != null) stmt.close();
						if(conn != null) conn.close();
					}catch (Exception e1) {
					}
					// 실행되고 있는 Platform(GUI)를 종료함
					// crud를 위한 입력 창과 메인 창이 모두 닫힘
					Platform.exit();
				} else if (result.get() == ButtonType.CANCEL) {
					// cancel시 닫기 버튼 이벤트 종료
					e.consume();
				}
			}
		});

		// BorderPane의 상단, 가운데, 하단에 각각 제목, 테이블, 버튼 박스를 위치함
		root.setTop(fieldHBox);
		root.setCenter(outputTable);
		root.setBottom(buttonBox);

		// Scene에 BorderPane 객체 root를 적용, 사이즈는 600x600  
		Scene scene = new Scene(root, 600, 600);
		// 메인 Stage인 primaryStage에 Scene이 출려되도록 설정
		primaryStage.setScene(scene);
		// Stage 창을 띄움
		primaryStage.show();
	}

	// main 메소드, JAVA는 실행하면 main 함수를 실행함, main에서는 위에서 정리한 필드, 메소드 등을 호출하여 실행
	public static void main(String[] args) {
		launch(args);		// start 메소드를 호출함, GUI 실행
	}
}