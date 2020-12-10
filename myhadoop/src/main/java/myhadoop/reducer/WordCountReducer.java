package myhadoop.reducer;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

// 리듀서 : 맵핑 끝낸 데이터를 집계하는 단계
// Redecer 클래스를 상속
public class WordCountReducer 
	extends Reducer<Text,	//	리듀서 입력 키 타입 = 매퍼의 출력 키 타입
					IntWritable,	//	리듀서 입력 값의 타입 = 매퍼의 출력 값 타입
					Text,	//	리듀서 출력 키 타입
					IntWritable>{	//	리듀서 출력 값의 타입

	//	입력 (word, 1), (word, 1) -> 셔플러를 통해 같은 키를 가진 객체가 묶여서 
	//	Iterable 타입으로 reduce 메서드에 전달된다
	
	private IntWritable result = new IntWritable();

	//	집계 작업을 수행하는 메서드
	@Override
	protected void reduce(Text key,	//	리듀스 입력 키 
			Iterable<IntWritable> values,	//	리듀스 입력 값의 순회가능 객체
			Context context) throws IOException, InterruptedException {
		// (word, 1) -> (word, (1, 1, 1, 1, 1))
		int sum = 0;	//	합산 변수
		for (IntWritable value: values) {
			//	값을 뽑아서 합산
			sum += value.get();
		}
		
		result.set(sum); // 출력 생성
		context.write(key, result); // (단어, 집계된합) -> 출력
	}
	
	
}
