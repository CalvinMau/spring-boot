package com.auth.druid.servlet;


import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * The type Druid servlet.
 *
 * @ClassName DruidServlet
 * @Description TODO
 * @Author Calvin
 * @Date 10 /12/18
 * @Version 1.0
 */
@WebServlet(urlPatterns="/druid/*",
        initParams={
                @WebInitParam(name="allow",value=""),
                @WebInitParam(name="deny",value=""),
                @WebInitParam(name="loginUsername",value="admin"),
                @WebInitParam(name="loginPassword",value="admin")
        })
public class DruidServlet extends StatViewServlet {

}
