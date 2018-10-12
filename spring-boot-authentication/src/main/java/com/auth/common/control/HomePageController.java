package com.auth.common.control;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Home page controller.
 *
 * @ClassName HomePageController
 * @Description TODO
 * @Author Calvin
 * @Date 10 /12/18
 * @Version 1.0
 */
@Controller
@RequestMapping("/")
public class HomePageController {

    /**
     * Home page string.
     *
     * @return the string
     */
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping("/home")
    public String homePage(){
        return "index";
    }
}
