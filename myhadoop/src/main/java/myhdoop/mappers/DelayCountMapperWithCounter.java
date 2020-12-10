package myhdoop.mappers;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import myhadoop.support.AirlinePerformanceParser;
import myhadoop.support.DelayCounter;

public class DelayCountMapperWithCounter 
	extends Mapper<LongWritable, 
					Text, 
					Text, 
					IntWritable>{
	//	사용자 옵션 workType을 체크
	private String workType;
	//	(1987,1 1)
	private final static IntWritable outputValue = new IntWritable(1);
	//	출력 키
	private Text outputKey = new Text();

	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
		//	사용자 옵션 workType을 설정
		workType = context.getConfiguration().get("workType");
	}
	
	@Override
	protected void map(LongWritable key, 
						Text value, 
						Context context)
			throws IOException, InterruptedException {
		//	첫번째 라인은 헤더일 가능성
		if (key.get() == 0 && value.toString().contains("YEAR")) {
			return;
		}
		
		AirlinePerformanceParser parser = new AirlinePerformanceParser(value);
		
		//	workType에 따른 매핑 흐름의 분기
		if (workType.equals("departure")) {
			//	출발 관련 내용 점검
			if (parser.getDepartureDelayTime() > 0) {	//	출발 지연
				//	출력
				outputKey.set(parser.getYear() + "," + parser.getMonth());
				context.write(outputKey, outputValue);
			} else if (parser.getDepartureDelayTime() == 0) {	//	정시 출발
				//	정시 출발 카운터 1증가
				context.getCounter(DelayCounter.scheduled_departure).increment(1);
			} else if (parser.getDepartureDelayTime() < 0) {	//	일찍 출발
				//	일찍 출발 카운터 1증가
				context.getCounter(DelayCounter.early_departure).increment(1);
			}
		} else if (workType.equals("arrival")) {
			//	도착 관련 내용 점검
			if (parser.getArriveDelayTime() > 0) {
				//	출력
				outputKey.set(parser.getYear() + "," + parser.getMonth());
				context.write(outputKey, outputValue);
			} else if (parser.getArriveDelayTime() == 0) {
				//	정시 도착 카운터 증가
				context.getCounter(DelayCounter.scheduled_arrival).increment(1);
			} else if (parser.getArriveDelayTime() < 0) {
				//	일찍 도착 카운터 증가
				context.getCounter(DelayCounter.early_arrival).increment(1);
			}
		}
	}

}
