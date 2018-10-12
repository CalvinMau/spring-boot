package com.auth.security.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * The type Web server factory customize.
 *
 * @ClassName WebServerFactoryCustomize
 * @Description TODO
 * @Author Calvin
 * @Date 10 /12/18
 * @Version 1.0
 */
@Configuration
public class WebServerFactoryCustomize implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Override
    public void customize(ConfigurableServletWebServerFactory server) {

        server.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/exception?statusCode=403"));
        server.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/exception?statusCode=404"));
        server.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/exception?statusCode=500"));
    }
}
