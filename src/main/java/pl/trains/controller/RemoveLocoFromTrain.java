package pl.trains.controller;

import pl.trains.dao.TrainDao;
import pl.trains.model.Loco;
import pl.trains.model.Train;

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
    TrainDao trainDao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        long locoid = Long.parseLong(request.getParameter("locoid"));
        long trainid = Long.parseLong(request.getParameter("trainid"));

        Loco loco = trainDao.getLoco(locoid);
        Train train = trainDao.getTrain(trainid);

        train = trainDao.removeLocoFromTrain(loco, train);

        for (Loco loco1 : train.getLocos()) {
            System.out.println("W servletcie: " + loco1.getName());
        }

        response.sendRedirect(request.getContextPath());


    }
}
