package pwc.LBS.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
@Controller
public class SpringContrlerUtils {
	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;
	
	public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
		return requestMappingHandlerMapping;
	}

	public void setRequestMappingHandlerMapping(RequestMappingHandlerMapping requestMappingHandlerMapping) {
		this.requestMappingHandlerMapping = requestMappingHandlerMapping;
	}

	@RequestMapping("/admin/util/url2controller")  
    @ResponseBody  
    public void list(HttpServletResponse response) {  
        StringBuilder sb = new StringBuilder();  
        sb.append("URL").append("--").append("Class").append("--").append("Function").append('\n');  
  
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();  
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {  
            RequestMappingInfo info = m.getKey();  
            HandlerMethod method = m.getValue();  
            sb.append(info.getPatternsCondition()).append("--");  
            sb.append(method.getMethod().getDeclaringClass()).append("--");  
            sb.append(method.getMethod().getName()).append('\n');  
        }  
  
        PrintWriter writer = null;  
        try {  
            writer = response.getWriter();  
            writer.print(sb.toString());  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            writer.close();  
        }  
  
    }  
}
