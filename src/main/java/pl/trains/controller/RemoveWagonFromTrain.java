package pl.trains.controller;

import pl.trains.dao.TrainDao;
import pl.trains.model.Loco;
import pl.trains.model.Train;
import pl.trains.model.Wagon;
import pl.trains.services.TrainsService;
import pl.trains.services.WagonsService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mateusz on 19.03.2017.
 */
@WebServlet("/removewagonfromtrain")
public class RemoveWagonFromTrain extends HttpServlet{
    @Inject
    TrainsService trainsService;

    @Inject
    WagonsService wagonsService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        long trainid = Long.parseLong(request.getParameter("trainid"));
        long wagonid = Long.parseLong(request.getParameter("wagonid"));

        Train train = trainsService.getTrainById(trainid);
        Wagon wagon = wagonsService.getWagonById(wagonid);

        trainsService.removeWagonFromTrain(wagon, train);

        response.sendRedirect(request.getContextPath());
    }
}