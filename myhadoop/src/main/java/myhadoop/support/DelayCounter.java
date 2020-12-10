package myhadoop.support;

//	사용자 정의 카운터
//	MR 작업이 수행되는 도중 맵, 리듀스 작업에서 수행되는 정보를 확인하기 위한 카운트의 식별자
public enum DelayCounter {
	scheduled_arrival,	//	정시 도착 카운터
	early_arrival,	//	일찍 도착 카운터
	scheduled_departure,	//	정시 출발 카운터
	early_departure	//	일찍 출발한 카운터
}
