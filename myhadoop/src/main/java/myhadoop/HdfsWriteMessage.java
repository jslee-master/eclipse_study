package myhadoop;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

//	사용법: HdfsWriteMessage <filename> <massage>
public class HdfsWriteMessage {

	public static void main(String[] args) {
		// 입력 매개 변수의 갯수
		if (args.length != 2) {
			System.err.println("Usage: HdfsWriteMessage <filename> <massage>");
			System.exit(2);
		}
		
		try {
			// HDFS 파일 시스템 객체 얻어오기
			Configuration conf = new Configuration(); //	현재 서버의 하둡 설정을 읽어온다
			FileSystem hdfs = FileSystem.get(conf);
			
			String target = args[0];	// 파일명
			String message = args[1];	// 저장할 메시지
			
			// 이미 target 파일이 있으면 지워주자
			Path path = new Path(target); // 저장할 파일, 디렉터리의 경로를 담고 있는 객체
			if (hdfs.exists(path)) {
				// 존재하면 지우자
				hdfs.delete(path, false); // delete(path, boolean recursive)
			}
			
			// 파일 저장을 위해 출력 스트림을 확보
			FSDataOutputStream os = hdfs.create(path);
			os.writeUTF(message);
			os.close(); // 시스템 자원 사용후에는 반드시 close
			
			System.out.println("메시지가 저장 되었습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
