package pl.trains.controller;

import pl.trains.dao.TrainDao;
import pl.trains.model.Loco;
import pl.trains.model.Train;
import pl.trains.model.Wagon;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mateusz on 14.03.2017.
 */
@WebServlet("/addlocototrain")
public class AddLocoToTrain extends HttpServlet{
    @Inject
    TrainDao trainDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long trainId = Long.parseLong(request.getParameter("trainid"));
        long locoId = Long.parseLong(request.getParameter("locoid"));

        Train train=trainDao.getTrain(trainId);
        Loco loco=trainDao.getLoco(locoId);
        train = trainDao.addLocoToTrain(train, loco);
        response.sendRedirect(request.getContextPath());
    }

}
