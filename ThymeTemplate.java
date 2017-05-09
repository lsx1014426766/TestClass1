package com.alc.core.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateModeHandler;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


public class ThymeTemplate {
	public static String process(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
    	ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        // XHTML is the default mode, but we will set it anyway for better understanding of code
        templateResolver.setTemplateMode("XHTML");
        templateResolver.setPrefix("/cms/main/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheTTLMs(3600000L);
        TemplateEngine templateEngine = new TemplateEngine();
        
        templateEngine.setTemplateResolver(templateResolver);
        //此对象由事件处理方法进行传递，经过controller后的java事件，直接转发到这个页面
       // WebContext ctx = new WebContext(req, resp, getServletConfig().getServletContext(), req.getLocale());
        // This will be prefixed with /WEB-INF/ and suffixed with .html
        
        /*  ctx.setVariable("today", Calendar.getInstance());  
        List<String> arrayList = new ArrayList<String>();  
        arrayList.add("Value Sample 1");  
        arrayList.add("Value Sample 2");  
  
        TreeSet<String> set = new TreeSet<String>();  
        set.add("Set Sample 1");  
        set.add("Set Sample 2");  
        set.add("Set Sample 3");  
  
        ctx.setVariable("contextValue", "Store Context Value");  
        ctx.setVariable("listExample", arrayList);  
        ctx.setVariable("setExample", set);  
  
        req.getSession().setAttribute("sessionValue", "Store Session Value"); */
       WebContext ctx = (WebContext)req.getAttribute("ctx");
       String page =(String) req.getAttribute("page");
       // templateEngine.process("thymeleaf", ctx, resp.getWriter());
       templateEngine.process(page, ctx, resp.getWriter());
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 1000);
        return "success";
	}
}
