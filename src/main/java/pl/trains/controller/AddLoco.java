package pl.trains.controller;

import pl.trains.dao.TrainDao;
import pl.trains.model.Loco;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mateusz on 12.03.2017.
 */
@WebServlet("/addloco")
public class AddLoco extends HttpServlet{

    @Inject
    TrainDao trainsService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Loco loco = new Loco();
        loco.setName(request.getParameter("name"));
        loco.setMaxSpeed(Integer.parseInt(request.getParameter("maxspeed")));
        loco.setPowerType(request.getParameter("powertype"));
        loco.setWeight(Double.parseDouble(request.getParameter("weight")));

        trainsService.addLoco(loco);

        response.sendRedirect(request.getContextPath());


    }
}
