package pwc.LBS.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import pwc.LBS.dao.JdbcTestDaoImpl;
import pwc.LBS.model.Account;

@Controller
public class HelloWorldController {
	@Autowired
    private ApplicationContext context;
	
	@Autowired
	private JdbcTestDaoImpl dao;
	@RequestMapping("/hello")
	public String helloWorld(Model model){
		List<Account> acclist=dao.getAccounts();
		model.addAttribute("message", "helloworld");
		return "hello";
	}
	
}
