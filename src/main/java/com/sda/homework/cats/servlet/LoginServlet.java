package com.sda.homework.cats.servlet;

import com.sda.homework.cats.entity.Account;
import com.sda.homework.cats.service.AccountService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/signIn")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        AccountService accountService = new AccountService();
        Map<String, String> users= new HashMap<>();

        for (int i = 1; i < accountService.findAll().size()+1; i++) {
            users.put(accountService.findById(i).getLogin(),accountService.findById(i).getPassword());
        }

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        boolean credentialsOk = users.entrySet().stream().
                anyMatch(e -> e.getKey().equals(login)
                        && e.getValue().equals(password));
        req.getSession().setAttribute("logged", credentialsOk);

        resp.sendRedirect("app/index.jsp");
    }
}
