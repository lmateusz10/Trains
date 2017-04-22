package pl.trains.services;

import pl.trains.model.Loco;
import pl.trains.model.Train;
import pl.trains.model.Wagon;

import java.util.List;

/**
 * Created by mateusz on 18.04.17.
 */
public interface ITrainsService {
    public void addTrain(Train train);
    public Train getTrainById(Long id);
    public void addWagonToTrain(Train train, Wagon wagon);
    public void removeWagonFromTrain(Wagon wagon, Train train);
    public void removeLocoFromTrain(Loco loco, Train train);
    public void updateTrain(Train train);
    public void addLocoToTrain(Train train, Loco loco);
    public void removeTrainById(Long trainid);

}
