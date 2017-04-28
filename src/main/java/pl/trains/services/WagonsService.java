package pl.trains.services;

import pl.trains.dao.TrainDao;
import pl.trains.model.Train;
import pl.trains.model.Wagon;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by mateusz on 18.04.17.
 */
@RequestScoped
public class WagonsService implements IWagonsServices {

    @Inject
    TrainDao trainDao;

    @Override
    public boolean addWagon(Wagon wagon) {
        if(trainDao.getAllWagons().contains(wagon)) {
            return false;
        }
        else{
        trainDao.addWagon(wagon);
        return true;}
    }

    @Override
    public Wagon getWagonById(Long id) {
        Wagon wagon = trainDao.getWagonById(id);
        return wagon;
    }

    @Override
    public List<Wagon> getAllWagons() {
        List<Wagon> wagons = trainDao.getAllWagons();
        return wagons;
    }

    @Override
    public void removeWagon(Wagon wagon) {
        trainDao.removeWagon(wagon);
    }


    @Override
    public List<Wagon> getWagonByAnything(String anything){
        return trainDao.getWagonByAnything(anything);
    }


}
