package pwc.LBS.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Controller
public class HelloWorldController {
	@Autowired
    private ApplicationContext context;
	@RequestMapping("/hello")
	public String helloWorld(Model model){
		model.addAttribute("message", "helloworld");
		return "hello";
	}
	
}
