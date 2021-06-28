package co.jiwon.prj.member.map;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import co.jiwon.prj.member.vo.MemberVO;

public interface MemberMap {
	
	@Select("select * from member where email=#{email} and password=#{password}")
	MemberVO loginCheck(MemberVO vo);
	
	List<MemberVO> memberSelectList(String status);

	MemberVO memberSelect(MemberVO vo);
	
	int memberInsert(MemberVO vo);
	
	int memberUpdate(MemberVO vo);
	
	int memberDelete(MemberVO vo);
}
