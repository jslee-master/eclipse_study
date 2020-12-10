package myhadoop.support;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

//	Shuffling 단계에서 map 데이터를 그룹으로 묶기 위한 용도
public class GroupKeyPartitioner 
	extends Partitioner<DateKey,	//	맵 태스크에서 출력한 키
						IntWritable>{	//	맵 태스크에서 출력한 값

	@Override
	public int getPartition(DateKey key,	//	복합키
			IntWritable value, 
			int numPartitions) {	//	MR 프레임워크에서 지정한 파티션의 갯수
		int hash = key.getYear().hashCode();
		//	해당 키와 값이 들어갈 파티션의 번호 생성
		int partition = hash % numPartitions;	//	나머지 연산자
		return partition;
	}
}
