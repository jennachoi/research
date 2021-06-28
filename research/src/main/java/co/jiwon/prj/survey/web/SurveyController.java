package co.jiwon.prj.survey.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.jiwon.prj.survey.vo.AnsweredDataVO;

@Controller
@RequestMapping("/survey")
public class SurveyController {

	@GetMapping
	public String form() {
		return "survey/surveyForm";
	}

	@PostMapping
	public String submit(Model model, AnsweredDataVO data) { 
	//public String submit(@ModelAttribute("ansData"), AnsweredDataVO data) { 위에꺼랑 똑같은 논리임. 
		// DB 저장루틴을 처리한다. 
		model.addAttribute("ansData", data);	// 어노테이션 한다면 안적어도 됨. 
		return "survey/submitted";
	}
}
