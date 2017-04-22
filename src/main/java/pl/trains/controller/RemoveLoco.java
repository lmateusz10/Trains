package pl.trains.controller;

import pl.trains.dao.TrainDao;
import pl.trains.services.LocoService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mateusz on 19.04.17.
 */
@WebServlet("/removeloco")
public class RemoveLoco extends HttpServlet{

    @Inject
    LocoService locoService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        Long locoid=Long.parseLong(request.getParameter("locoid"));
        locoService.removeLocoById(locoid);

        response.sendRedirect(request.getContextPath());

    }

}
