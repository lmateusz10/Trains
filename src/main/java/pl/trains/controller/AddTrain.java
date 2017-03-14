package pl.trains.controller;

import pl.trains.dao.TrainDao;
import pl.trains.model.Loco;
import pl.trains.model.Train;
import pl.trains.model.Wagon;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;

/**
 * Created by Mateusz on 28.02.2017.
 */
@WebServlet("/addtrain")
public class AddTrain extends HttpServlet {
    @Inject
    TrainDao trainDao;

    @PersistenceUnit(name = "myPersistenceUnit")
    private EntityManagerFactory entityManagerFactory;

    @Transactional
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException{
        Train train = new Train();
        train.setTrainName(request.getParameter("name"));
        trainDao.addTrain(train);
        response.sendRedirect(request.getContextPath());
    }
}
