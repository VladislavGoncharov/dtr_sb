package com.vladgoncharov.dtr_sb.utility;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginExceptionHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(
              HttpServletRequest request
            , HttpServletResponse response
            , AuthenticationException exception) throws IOException, ServletException {

        if (exception.getMessage().equals("User account is locked")){
            response.sendRedirect("/423");
        }
        else {
            response.sendRedirect("/login?error=true");
        }
    }
}
