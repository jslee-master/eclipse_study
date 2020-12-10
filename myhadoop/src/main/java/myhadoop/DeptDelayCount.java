package myhadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import myhadoop.reducer.DelayCountReducer;
import myhdoop.mappers.DeptDelayCountMapper;

//	DeptDelayCount <input> <output>
public class DeptDelayCount {

	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.err.println("Usage: DeptDelayCount <input> <output>");
			System.exit(2);
		}
		
		Configuration conf = new Configuration();
		//	output 경로가 이미 있으면 지워주자
		FileSystem hdfs = FileSystem.get(conf);
		//	output 경로 확인
		Path outPath = new Path(args[1]);	//	출력 경로
		if (hdfs.exists(outPath)) {
			//	있으면 지우자
			hdfs.delete(outPath, true);
		}
		
		//	Job 생성
		Job job = Job.getInstance(conf, "DeptDelayCount");
		
		//	입출력 데이터 경로 설정
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, outPath);
		
		//	실행 클래스 등록
		job.setJarByClass(DeptDelayCount.class);
		//	매퍼 클래스 설정
		job.setMapperClass(DeptDelayCountMapper.class);
		//	리듀서 클래스 등록
		job.setReducerClass(DelayCountReducer.class);
		
		//	입출력 데이터 포맷 설정
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		//	출력 키, 출력 값 타입 설정
		job.setOutputKeyClass(Text.class);	//	키: 1987,1
		job.setOutputValueClass(IntWritable.class);	//	값: 집계 수치
		
		//	실행
		job.waitForCompletion(true);
	}

}
