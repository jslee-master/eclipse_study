package myhdoop.mappers;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import myhadoop.support.AirlinePerformanceParser;
import myhadoop.support.DateKey;

public class DelayCountSortMapper 
	extends Mapper<LongWritable,	//	입력 키 타입
					Text,			//	입력 값 타입
					DateKey,		//	출력 키 타입 
					IntWritable>{	//	출력 값 타입

	//	출력 키
	private DateKey outputKey = new DateKey();
	//	출력 값
	private final static IntWritable outputValue = new IntWritable(1);
	
	@Override
	protected void map(LongWritable key, 
				Text value, 
				Context context)
			throws IOException, InterruptedException {
		//	MultipleOutputs로 처리
		//	분석
		AirlinePerformanceParser parser = new AirlinePerformanceParser(value);
		
		if (parser.getDepartureDelayTime() > 0) {
			//	출력 키 생성
			outputKey.setYear("D," + parser.getYear());
			outputKey.setMonth(parser.getMonth());

			context.write(outputKey, outputValue);
		}
		
		if (parser.getArriveDelayTime() > 0) {
			outputKey.setYear("A," + parser.getYear());
			outputKey.setMonth(parser.getMonth());

			context.write(outputKey, outputValue);
		}
	}
	
}
