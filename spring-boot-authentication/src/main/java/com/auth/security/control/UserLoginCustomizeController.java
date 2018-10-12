package com.auth.security.control;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type User login customize controller.
 *
 * @ClassName UserLoginCustomizeController
 * @Description TODO
 * @Author Calvin
 * @Date 10 /12/18
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/")
public class UserLoginCustomizeController {


    /**
     * Login error string.
     *
     * @param model    the model
     * @param request  the request
     * @param response the response
     * @param error    the error
     * @return the string
     */
    @RequestMapping("/login")
    public String loginError(Model model,
                             HttpServletRequest request,
                             HttpServletResponse response,
                             @RequestParam(value = "error", required = false) String error) {
        if ("true".equals(error)    ) {
            response.setContentType("text/html;charset=utf-8");
            AuthenticationException exception =
                    (AuthenticationException)request.getSession()
                            .getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
            if (exception != null){
                model.addAttribute("error","Username or Password has exception.");
            }
        }
        return "login";
    }
}
