package controller;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import pojo.User;

@Controller
@RequestMapping("/mvc")
public class MyController {
    
    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }
    @RequestMapping("/toBye")
    public String toBye(User u) {
    	System.out.println(u);
    	return "ByeBye";
    }
    
    @RequestMapping("/mavt")
    public ModelAndView mavtest() {
    	ModelAndView m = new ModelAndView();
    	m.addObject("s", "QwQ");
    	m.setViewName("ByeBye");
    	return m;
    }
    @RequestMapping("/st")
    public String sessionText(HttpServletRequest req) {
    	req.getSession().setAttribute("t", new User("ads","111",new Date()));
    	return "ByeBye";
    }
    
    @RequestMapping("/ajax")
    public String ajaxT(PrintWriter pw) {
    	pw.write("老易这个大傻逼");
    	pw.flush();
    	pw.close();
    	return "Hello";
    }
    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public String Up(HttpServletRequest req) throws Exception {
    	MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)req;
        MultipartFile file = mreq.getFile("file");
        String fileName = file.getOriginalFilename();
        FileOutputStream fos = new FileOutputStream(req.getSession().getServletContext().getRealPath("/")+
                "upload/"+fileName);
        fos.write(file.getBytes());
        fos.flush();
        fos.close();
        return "Hello";
    }
    @RequestMapping("/json")
    @ResponseBody
    public List<User> JsonAlias() {
    	List<User> list = new ArrayList<>();
    	list.add(new User("卧槽", "shi", new Date()));
    	list.add(new User("我操", "shi", new Date()));
    	list.add(new User("我草", "shi", new Date()));
    	return list;
    }
    
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
                true));
    }
}
