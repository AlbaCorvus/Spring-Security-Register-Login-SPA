package com.mulcahy.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Chris on 11/3/2016.
 */

@Controller("memberController")
public class MemberController {

    private static final Logger LOGGER=Logger.getLogger(MemberController.class);

    @RequestMapping(value="/member/welcome",method= RequestMethod.GET)
    public String goToWelcome(){
        LOGGER.debug("entering members area now");
        return "Member/Welcome";
    }

}
