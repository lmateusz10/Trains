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

    @PersistenceUnit(name = "myPersistenceUnit")
    private EntityManagerFactory emf;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long trainId = Long.parseLong(request.getParameter("trainid"));
        long wagonId = Long.parseLong(request.getParameter("wagonid"));

        EntityManager em = emf.createEntityManager();
        Train train=em.find(Train.class, trainId);
        Wagon wagon=em.find(Wagon.class, wagonId);

        EntityTransaction tx=em.getTransaction();
        tx.begin();
        //System.out.println(wagon);
        train.getWagons().add(wagon);
        tx.commit();
        em.close();

        response.sendRedirect(request.getContextPath());


    }

}
