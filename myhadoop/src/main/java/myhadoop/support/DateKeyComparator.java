package myhadoop.support;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

//	두 개의 복합 키(DateKey)의 선후 관계를 비교하는 클래스
//	WritableComarator를 상속해야 한다
public class DateKeyComparator extends WritableComparator{
	//	생성자
	protected DateKeyComparator() {
		super(DateKey.class, true);
	}

	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		//	두 개의 WritableComparable의 선후관계를 리턴
		//	a, b를 형변환
		DateKey k1 = (DateKey)a;
		DateKey k2 = (DateKey)b;
		
		//	1차: 두 DateKey의 year의 선후 관계를 확인
		int cmp = k1.getYear().compareTo(k2.getYear());
		if (cmp != 0) {
			//	두 DateKey 객체의 년도 정보가 같지 않으니 -> 소팅 대상이 아님
			return cmp;
		}
		
		//	두 DateKey의 year가 같으니, month 정보의 선후 관계를 확인
		/*
		return k1.getMonth() == k2.getMonth() ? 0 : 
			(k1.getMonth() < k2.getMonth() ? -1 : 1);
			*/
		if (k1.getMonth() == k2.getMonth()) {
			return 0;
		} else {
			if (k1.getMonth() < k2.getMonth()) {
				return -1;
			} else {
				return 1;
			}
		}
	}

}
