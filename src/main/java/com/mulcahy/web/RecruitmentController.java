package com.mulcahy.web;

import com.mulcahy.domain.Mail;
import com.mulcahy.model.RegisterHandler;
import com.mulcahy.service.RegisterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.mulcahy.domain.PasswordGenerator.generatePassword;

@Controller("controller")
public class RecruitmentController{

    private String pattern="^[a-zA-Z0-9]+$";
    private Pattern exp=Pattern.compile(pattern);
    private Matcher m;

    @Autowired
    private Mail mailMail;

    @Autowired
    private RegisterService registerService;

    private static final Logger LOGGER = Logger.getLogger(RecruitmentController.class);

@RequestMapping("/login")
public ModelAndView goToLogin(){
LOGGER.debug("goToLogin() mapped method successful. returning Account/login");

return new ModelAndView("Account/Login");


}

@RequestMapping("/error")
public String processError(){
    LOGGER.debug("spring security error ");
    LOGGER.error("spring security error occurred on login attempt");
    return "Account/Lobby";
}

@RequestMapping("/register")
    public String getRegisterView(){
    LOGGER.debug("angularjs requested register form view ");
    return "Account/Register";
}


@RequestMapping("/loginform")
    public String getLoginView(){
    LOGGER.debug("Angularjs requested login form view");
    return "Account/LoginForm";
    }

    @RequestMapping("/403")
    public String goToErrorPage(){
        LOGGER.debug("redirecting to error page 403");
        LOGGER.error("page 403 invoked server side error detected.");
        return "Account/403";
    }

    @RequestMapping(value="/checkName/{name}",method=RequestMethod.GET)
    @ResponseBody
    public boolean checkName(@PathVariable String name){
        return registerService.checkRegisterUserName(name);
    }

@RequestMapping(value="/newregisterinfo",method= RequestMethod.GET)
    public ModelAndView validateRegistration(HttpServletRequest request){
    Map<String,Object> model = new HashMap<String,Object>();
        m=exp.matcher(request.getParameter("username"));
    if(!m.find() || !registerService.checkRegisterUserName(request.getParameter("username"))){
        model.put("error",new RegisterHandler("RegisterError"));
        LOGGER.debug("register name contained illegal characters or name already exists in database");
        LOGGER.error("registration failed");
        return new ModelAndView("Account/Lobby",model);
    }
    model.put("Accepted",new RegisterHandler("Accepted"));
    String password=generatePassword();
    LOGGER.debug("registration complete password generated accepted message added to model");
    registerService.enterRegisterUserInfo(request.getParameter("username"),password,true);
    LOGGER.debug("Registration details added to database");
    mailMail.sendMail("supa.t3d@gmail.com",request.getParameter("email"),"Registration","Congratulations on subscribing." +
                                              "your login details are name: "+request.getParameter("username")+" password: "+password+"");
    LOGGER.debug("mail has been sent to :: "+request.getParameter("email"));
    LOGGER.debug("returning to account/lobby");
    return new ModelAndView("Account/Lobby",model);
}



}