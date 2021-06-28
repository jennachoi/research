package co.jiwon.prj.member.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberVO {
	
	/*
	이름         널        유형            
	---------- -------- ------------- 
	EMAIL      NOT NULL VARCHAR2(20)  
	NAME       NOT NULL VARCHAR2(20)  
	PASSWORD   NOT NULL VARCHAR2(20)  
	STATUS     NOT NULL VARCHAR2(2)   
	FILENAME            VARCHAR2(200) 
	DIRECTORY           VARCHAR2(200) 
	FILENUMBER          VARCHAR2(200) 
	 */
	
	private String email;
	private String name;
	private String password;
	private String status;
	private String fileName;
	private String fileUuid;
	private MultipartFile multifile;	// 폼에서 넘어오는 파일 담는 곳

}
