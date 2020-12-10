package com.bit.utils.emaillist.dao;

import java.util.List;

import com.bit.utils.emaillist.vo.EmaillistVo;

//	DAO 설계도
public interface EmaillistDao {
	//	목록 보기
	public List<EmaillistVo> getList();
	//	INSERT를 위한 메서드
	public int insert(EmaillistVo vo);
	//	UPDATE를 위한 메서드
	public int update(EmaillistVo vo, Long no);
	//	DELETE를 위한 메서드
	public int delete(Long no);

}
