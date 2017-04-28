package pl.trains.controller;

import pl.trains.dao.TrainDao;
import pl.trains.model.Train;
import pl.trains.services.TrainsService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mateusz on 21.03.2017.
 */
@WebServlet("/removetrain")
public class RemoveTrain extends HttpServlet {

    @Inject
    TrainsService trainsService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        Long trainid=Long.parseLong(request.getParameter("trainid"));
        trainsService.removeTrainById(trainid);

        response.sendRedirect(request.getContextPath());

    }

    }
