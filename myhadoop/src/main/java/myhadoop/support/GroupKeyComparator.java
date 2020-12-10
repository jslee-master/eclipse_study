package myhadoop.support;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupKeyComparator extends WritableComparator{
	//	생성자
	protected GroupKeyComparator() {
		super(DateKey.class, true);
	}

	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		//	형변환
		DateKey k1 = (DateKey)a;
		DateKey k2 = (DateKey)b;
		
		//	파티션만 할 것이라서 년도 정보의 선후관계만 비교하면 된다
		return k1.getYear().compareTo(k2.getYear());
	}

}
