package pl.trains.controller;

import pl.trains.dao.TrainDao;
import pl.trains.model.Loco;
import pl.trains.model.Train;
import pl.trains.services.LocoService;
import pl.trains.services.TrainsService;

import javax.inject.Inject;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Mateusz on 19.03.2017.
 */
@WebServlet("/removelocofromtrain")
public class RemoveLocoFromTrain extends HttpServlet {
    @Inject
    TrainsService trainsService;

    @Inject
    LocoService locoService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        long locoid = Long.parseLong(request.getParameter("locoid"));
        long trainid = Long.parseLong(request.getParameter("trainid"));

        Loco loco = locoService.getLocoById(locoid);
        Train train = trainsService.getTrainById(trainid);

        trainsService.removeLocoFromTrain(loco, train);


        response.sendRedirect(request.getContextPath());


    }
}
