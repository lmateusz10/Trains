package pl.trains.controller;

import pl.trains.dao.TrainDao;
import pl.trains.model.Train;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
@WebServlet("/test")
public class AddTest extends HttpServlet {

    @Inject
    TrainDao trainDao;

    @PersistenceUnit(name = "myPersistenceUnit")
    private EntityManagerFactory emf;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        EntityManager em=emf.createEntityManager();
        Train train = em.find(Train.class, new Long(2));

        System.out.println(train.getWagons().size());
    }

}
