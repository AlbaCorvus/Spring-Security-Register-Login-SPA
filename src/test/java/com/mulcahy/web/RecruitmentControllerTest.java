package com.mulcahy.web;

import com.mulcahy.domain.Mail;
import com.mulcahy.model.RegisterHandler;
import com.mulcahy.model.User;
import com.mulcahy.service.RegisterService;
import org.mockito.*;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static com.mulcahy.domain.PasswordGenerator.generatePassword;

/**
 * Created by Chris on 11/4/2016.
 */
public class RecruitmentControllerTest {

    @Mock
    private RegisterService registerService;

    @InjectMocks
    private RecruitmentController recruitmentController;

    @Spy
    private Mail mailMail;



    private String pattern="^[a-zA-Z0-9]+$";
    private Pattern exp=Pattern.compile(pattern);
    private Matcher m;

    private MockMvc mockMvc;

    @BeforeTest
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(recruitmentController).build();
    }

    @Test
    public void TestuserInfo() throws Exception{


        Mockito.doNothing().when(mailMail).sendMail(anyString(),anyString(),anyString(),anyString());
        when(registerService.checkRegisterUserName("test")).thenReturn(true);
        Mockito.doNothing().when(registerService).enterRegisterUserInfo(anyString(),anyString(),anyBoolean());
        mockMvc.perform(get("/newregisterinfo").param("username","test").param("email","supa.t3d@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(view().name("Account/Lobby"))
                .andExpect(model().attribute("Accepted",instanceOf(RegisterHandler.class)));



 }

 @Test
    public void TestFalseUserInfo() throws Exception{

     when(registerService.checkRegisterUserName("test")).thenReturn(false);
     mockMvc.perform(get("/newregisterinfo").param("username","test"))
             .andExpect(status().isOk())
             .andExpect(view().name("Account/Lobby"))
             .andExpect(model().attribute("error",instanceOf(RegisterHandler.class)));

 }

    @Test
    public void loginErrorTest() throws Exception{
        mockMvc.perform(get("/error")).andExpect(status().isOk())
                .andExpect(view().name("Account/Lobby"));
    }

    @Test
    public void Test403() throws Exception{
        mockMvc.perform(get("/403"))
                .andExpect(status().isOk())
                .andExpect(view().name("Account/403"));
    }

}
