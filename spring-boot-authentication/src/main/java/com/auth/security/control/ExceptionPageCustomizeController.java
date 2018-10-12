package com.auth.security.control;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Exception page customize controller.
 *
 * @ClassName ExceptionPageCustomizeController
 * @Description TODO
 * @Author Calvin
 * @Date 10 /12/18
 * @Version 1.0
 */
@Controller
@RequestMapping("/")
public class ExceptionPageCustomizeController {

    /**
     * Exception page string.
     *
     * @param model      the model
     * @param statusCode the status code
     * @return the string
     */
    @RequestMapping("/exception")
    public String exceptionPage(Model model, @Param(value = "statusCode")String statusCode){
        switch (statusCode){
            case"403":
                model.addAttribute("status_code",statusCode);
                model.addAttribute("title","Access Denied");
                model.addAttribute("forward_url","/");
                model.addAttribute("forward_name","Home Page");
                model.addAttribute("description","The requested resource requires an authentication.");
                break;
            case"500":
                model.addAttribute("status_code",statusCode);
                model.addAttribute("title","Webservice currently unavailable");
                model.addAttribute("forward_url","/login");
                model.addAttribute("forward_name","Sign In");
                model.addAttribute("description","An unexpected condition was encountered." +
                        "Our service team has been dispatched to bring it back online");
                break;
            default:
                model.addAttribute("status_code",statusCode);
                model.addAttribute("title","Page not found");
                model.addAttribute("forward_url","/");
                model.addAttribute("forward_name","Home Page");
                model.addAttribute("description","The page you are looking for might have been " +
                        "removed had its name changed or is temporarily unavailable.");
                break;
        }

        return "exception/error";
    }
}
