package pl.trains.dao;

import pl.trains.controller.AddTrain;
import pl.trains.model.Loco;
import pl.trains.model.Train;
import pl.trains.model.Wagon;

import java.util.List;

/**
 * Created by Mateusz on 28.02.2017.
 */
public interface TrainDao {
    public Train addWagonToTrain(Train train, Wagon wagon);
    public Train removeWagonFromTrain(Wagon wagon, Train train);
    public Train removeLocoFromTrain(Loco loco, Train train);
    public void update(Train train);
    public Train addLocoToTrain(Train train, Loco loco);
    public List<Wagon> findAll();
    public void addTrain(Train train);
    public boolean removeTrain(Long trainid);
    public Train getTrain(Long id);
    public void addWagon(Wagon wagon);
    public boolean removeWagon(Wagon wagon);
    public Wagon getWagon(Long id);
    public void addLoco(Loco loco);
    public Loco getLoco(Long id);


}
