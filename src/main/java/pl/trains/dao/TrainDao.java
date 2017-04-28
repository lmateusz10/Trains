package pl.trains.dao;

import pl.trains.controller.AddTrain;
import pl.trains.model.Loco;
import pl.trains.model.Train;
import pl.trains.model.Wagon;

import java.util.List;
import java.util.Set;

/**
 * Created by Mateusz on 28.02.2017.
 */
public interface TrainDao {
    //trains
    public void addTrain(Train train);
    public Train getTrainById(Long id);
    public void addWagonToTrain(Train train, Wagon wagon);
    public void removeWagonFromTrain(Wagon wagon, Train train);
    public void removeLocoFromTrain(Loco loco, Train train);
    public void updateTrain(Train train);
    public void addLocoToTrain(Train train, Loco loco);
    public void removeTrainById(Long trainid);
    public List<Train> getTrainByName(String name);
    public List<Train> getAllTrains();

    //locos
    public void addLoco(Loco loco);
    public Loco getLocoById(Long id);
    public List<Loco> getAllLocos();
    public void removeLoco(Loco loco);
    public void removeLocoById(Long id);
    public List<Loco> getLocoByName(String name);

        //wagons
    public void addWagon(Wagon wagon);
    public Wagon getWagonById(Long id);
    public List<Wagon> getAllWagons();
    public void removeWagon(Wagon wagon);
    public void removeWagonById(Long id);
    public List<Wagon> getWagonByAnything(String anything);


    }
