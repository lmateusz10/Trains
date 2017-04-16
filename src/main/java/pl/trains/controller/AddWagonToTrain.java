package pl.trains.controller;

import pl.trains.dao.TrainDao;
import pl.trains.model.Train;
import pl.trains.model.Wagon;

import javax.inject.Inject;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mateusz on 14.03.2017.
 */
@WebServlet("/addwagontotrain")
public class AddWagonToTrain extends HttpServlet {
    @Inject
    TrainDao trainDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        long trainId = Long.parseLong(request.getParameter("trainid"));
        long wagonId = Long.parseLong(request.getParameter("wagonid"));

        Train train=trainDao.getTrain(trainId);
        Wagon wagon=trainDao.getWagon(wagonId);

        train = trainDao.addWagonToTrain(train, wagon);

        response.sendRedirect(request.getContextPath());
    }

}
