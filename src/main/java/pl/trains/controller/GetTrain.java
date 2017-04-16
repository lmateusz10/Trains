package pl.trains.controller;

import pl.trains.dao.TrainDao;
import pl.trains.model.Loco;
import pl.trains.model.Train;
import pl.trains.model.Wagon;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by Mateusz on 18.03.2017.
 */
@WebServlet("/gettrain")
public class GetTrain extends HttpServlet {
    @Inject
    TrainDao trainDao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Long trainid=Long.parseLong(request.getParameter("trainid"));
        Train train = trainDao.getTrain(trainid);
        Set<Loco> locos=train.getLocos();
        List<Wagon> wagons = train.getWagons();
        StringBuilder sb = new StringBuilder();
        for (Loco loco:locos) {
            sb.append(loco.getName() + " ");
        }

        for (Wagon wagon:wagons) {
            sb.append(wagon.getType() + " ");
        }

        System.out.println(sb);
        response.sendRedirect(request.getContextPath());

    }
}
