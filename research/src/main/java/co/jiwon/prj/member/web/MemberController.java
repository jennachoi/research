package co.jiwon.prj.member.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.jiwon.prj.member.service.MemberService;
import co.jiwon.prj.member.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberDao;
	
	@RequestMapping("loginConfirm.do")
	public String loginConfirm(MemberVO vo, HttpSession session, Model model) {
		vo = memberDao.loginCheck(vo);
		if(vo.getName() != null) {
			session.setAttribute("email", vo.getEmail());
			model.addAttribute("msg", "님 환영합니다.");
			model.addAttribute("member", vo);
			
		} else {
			model.addAttribute("msg", "존재하지 않는 회원입니다.");
		}
		return "redirect:home";
	}
	
	@RequestMapping("memberList")
	public String memberList(Model model, @RequestParam(value="status", defaultValue="Y") String status) {
		model.addAttribute("members",memberDao.memberSelectList(status));
		return "member/memberList";
	}
	
	@RequestMapping("member/memberInsert")
	public String memberInsert() {	// 폼만 호출
		return "member/memberInsert";
	}

	@RequestMapping("memberRegister.do")
	public String memberRegister(MemberVO vo, Model model) throws IOException {
		
		MultipartFile file = vo.getMultifile();
		String fileName = file.getOriginalFilename();
		
		// 파일 UUID 생성
		UUID fileUuid = UUID.randomUUID();
		String aliasFileName = fileUuid.toString();
		vo.setFileUuid(aliasFileName);
		
		File target = new File("D:\\",aliasFileName); 	// 저장할 공간
		file.transferTo(target);						// 파일 업로드
		//FileCopyUtils.copy(file.getBytes(), target); // 파일업로드(위 문장이랑 같음)
		vo.setFileName(fileName);
		
		int n = memberDao.memberInsert(vo);
		
		String msg = "";
		if (n != 0)
			msg="입력 성공";
		else 
			msg="입력 실패";
		model.addAttribute("msg", msg);
		return "member/memberRegister";
	}
	
	@RequestMapping("fileDown.do")
	public void fileDown(@RequestParam("filePath") String filePath, @RequestParam("fileName") String fileName,
			HttpServletResponse rep) {

		File file = null;
		InputStream is = null;
		OutputStream os = null;

		try {
			file = new File("d:\\",filePath);	// 물리적 위치의 파일
			is = new FileInputStream(file);		// 다운로드 될 파일명
			fileName = new String(fileName.getBytes("utf-8"),"iso-8859-1");
			rep.reset();
			rep.setContentType("application/octect-stream");
			rep.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");
			rep.setHeader("Content-Length", "" + file.length());
			os = rep.getOutputStream();
			
			byte[] b = new byte[2048];	// 바이트를 블럭단위로 쪼갬
			int leng=0;
			while ((leng = is.read(b)) != -1) {
				os.write(b,0,leng);
			};
			is.close();
			os.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}