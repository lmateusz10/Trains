package pl.trains.dao;

import pl.trains.controller.AddTrain;
import pl.trains.model.Loco;
import pl.trains.model.Train;
import pl.trains.model.Wagon;

/**
 * Created by Mateusz on 28.02.2017.
 */
public interface TrainDao {
    public void addTrain(Train train);
    public boolean removeTrain(Train train);
    public Train getTrain(Long id);

    public void addWagon(Wagon wagon);
    public boolean removeWagon(Wagon wagon);
    public Wagon getWagon(Long id);

    public void addLoco(Loco loco);
    public Loco getLoco(Long id);


}
