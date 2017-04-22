package pl.trains.services;

import pl.trains.dao.TrainDao;
import pl.trains.model.Loco;
import pl.trains.model.Train;
import pl.trains.model.Wagon;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Created by mateusz on 18.04.17.
 */
@RequestScoped
public class TrainsService implements ITrainsService {

    @Inject
    TrainDao trainDao;

    @Override
    public void addTrain(Train train) {
        trainDao.addTrain(train);
    }

    @Override
    public Train getTrainById(Long id) {
        Train train = trainDao.getTrainById(id);
        return train;
    }

    @Override
    public void addWagonToTrain(Train train, Wagon wagon) {
        trainDao.addWagonToTrain(train, wagon);
    }

    @Override
    public void removeWagonFromTrain(Wagon wagon, Train train) {
        trainDao.removeWagonFromTrain(wagon, train);
    }

    @Override
    public void removeLocoFromTrain(Loco loco, Train train) {
        trainDao.removeLocoFromTrain(loco, train);
    }

    @Override
    public void updateTrain(Train train) {
        trainDao.updateTrain(train);
    }

    @Override
    public void addLocoToTrain(Train train, Loco loco) {
        trainDao.addLocoToTrain(train, loco);
    }

    @Override
    public void removeTrainById(Long trainid) {
        trainDao.removeTrainById(trainid);
    }
}
