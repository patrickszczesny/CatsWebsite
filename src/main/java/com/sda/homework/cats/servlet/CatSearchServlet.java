package com.sda.homework.cats.servlet;

import com.sda.homework.cats.entity.Cat;
import com.sda.homework.cats.entity.Owner;
import com.sda.homework.cats.entity.Race;
import com.sda.homework.cats.service.CatService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatSearchServlet extends HttpServlet {

    CatService catService = new CatService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Race race = new Race();
        race.setName(req.getParameter("searchRace"));
        Owner owner = new Owner();
        owner.setName(req.getParameter("searchOwner"));
        Cat cat = new Cat();
        cat.setName(req.getParameter("searchName"));
        cat.setOwner(owner);
        cat.setRace(race);

        List<Cat> allCatsList= new ArrayList<>();
        allCatsList.addAll(catService.findAll());
        resp.sendRedirect("catsSearchServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("cats", Arrays.asList());
        req.getRequestDispatcher("showMeawTheCats.jsp").forward(req, resp);
    }
}
