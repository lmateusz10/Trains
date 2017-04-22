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

/**
 * Created by Mateusz on 18.03.2017.
 */
@WebServlet("/getloco")
public class GetLoco extends HttpServlet {
    @Inject
    TrainDao trainsService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Long locoid = Long.parseLong(request.getParameter("locoid"));
        Loco loco = trainsService.getLocoById(locoid);

        List<Train> trains = loco.getTrains();
        for (Train train:trains) {
            System.out.println(train.getTrainName());
        }
        response.sendRedirect(request.getContextPath());


    }
}
