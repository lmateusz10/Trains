package pl.trains.controller;

import pl.trains.dao.TrainDao;
import pl.trains.model.Loco;
import pl.trains.model.Train;
import pl.trains.model.Wagon;
import pl.trains.services.LocoService;

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
@WebServlet("/getloco")
public class GetLoco extends HttpServlet {
    @Inject
    LocoService locoService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Long locoid = Long.parseLong(request.getParameter("locoid"));
        Loco loco = locoService.getLocoById(locoid);

        Set<Train> trains = loco.getTrains();
        for (Train train:trains) {
            System.out.println(train.getTrainName());
        }
        response.sendRedirect(request.getContextPath());


    }
}
