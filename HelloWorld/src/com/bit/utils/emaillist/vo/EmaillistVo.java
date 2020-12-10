package com.bit.utils.emaillist.vo;

import java.util.Date;

/*
 * DTO 객체(VO 객체)
 * 	자바 객체와 객체간 데이터를 주고 받기 위한 단순히 데이터만 다루는 객체
 * 	일반적으로는 로직은 포함하지 않고 필드와 접근을 위한 getter/setter 만 가진다
 *	toString, equals 정도의 Object관련 메서드는 구현하기도 한다
 */
public class EmaillistVo {
	//	테이블 emaillist의 레코드를 저장하고 객체간 주고 받기 위한 DTO 객체
	//	필드
	private Long no;	//	VO 객체 내부의 필드 타입은 객체형인 것이 좋다
	private String lastName;
	private String firstName;
	private String email;
	private Date createdAt;

	//	VO 객체의 경우 기본생성자는 반드시 있어야 한다
	//	-> 만약에 개발자가 내부에 생성자를 하나도 안만들었다
	//	-> 컴파일러가 기본 생성자를 자동으로 추가한다
	
	//	getter/setter
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	// toString 정도는 만든다
	@Override
	public String toString() {
		return "EmaillistVo [no=" + no + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ ", createdAt=" + createdAt + "]";
	}

}
