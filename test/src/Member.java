
public class Member {
	private String id; // 아이디
	private String name; // 회원 이름
	private int point; //포인트

	public Member() {
	}
	
	public Member(String i, String n, int p) {
		this.id = id;
		this.name = name;
		this.point = point;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	// method overloading.
	public String info(String msg) {
		return "아이디, 이름, 포인트: " + msg;
	}

}
