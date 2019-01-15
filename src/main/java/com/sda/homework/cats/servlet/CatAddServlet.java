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
import java.util.Map;

public class CatAddServlet extends HttpServlet {

    CatService catService = new CatService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Race race = new Race();
        race.setName(req.getParameter("race"));
        Owner owner = new Owner();
        owner.setName(req.getParameter("owner"));
        Cat cat = new Cat();
        cat.setName(req.getParameter("name"));
        cat.setOwner(owner);
        cat.setRace(race);
        catService.save(cat);

        session.setAttribute("race", req.getParameter("race"));
        session.setAttribute("owner", req.getParameter("owner"));
        session.setAttribute("name", req.getParameter("name"));
        resp.sendRedirect("catsAddServlet");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Race race = new Race();
        race.setName(session.getAttribute("race").toString());
        Owner owner = new Owner();
        owner.setName(session.getAttribute("owner").toString());
        Cat cat = new Cat();
        cat.setName(session.getAttribute("name").toString());
        cat.setRace(race);
        cat.setOwner(owner);

        if (catService.findAll().stream().anyMatch(c->c.equals(cat))) {
            req.getRequestDispatcher("addingSuccess.jsp").forward(req, resp);
        }else
        {
            req.getRequestDispatcher("addingFailure.jsp").forward(req, resp);
        }
    }
}
