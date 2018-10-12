package com.auth.security.control;


import com.auth.common.result.ResultCustomize;
import com.auth.common.tools.JsonUntilsCustomize;
import com.auth.security.bean.PersonnelBean;
import com.auth.security.dao.PersonnelDao;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Security controller.
 *
 * @ClassName SecurityController
 * @Description TODO
 * @Author Calvin
 * @Date 10 /12/18
 * @Version 1.0
 */
@RestController
@RequestMapping("/sec")
public class SecurityController {

    @Autowired
    private PersonnelDao personnelDao;

    /**
     * List user string.
     *
     * @return the string
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/all")
    public String listUser(){
        ResultCustomize customization = new ResultCustomize();
        Gson gson = new JsonUntilsCustomize().getGson();
        List<PersonnelBean> all = personnelDao.findAll();

        customization.setData(all);
        return gson.toJson(customization);

    }

}
