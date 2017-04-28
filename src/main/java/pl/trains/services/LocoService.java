package pl.trains.services;

import pl.trains.dao.TrainDao;
import pl.trains.model.Loco;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by mateusz on 18.04.17.
 */
@RequestScoped
public class LocoService implements ILocoService{
    @Inject
    TrainDao trainDao;

    @Override
    public void addLoco(Loco loco) {
        trainDao.addLoco(loco);
    }

    @Override
    public Loco getLocoById(Long id) {
        Loco loco = trainDao.getLocoById(id);
        return loco;
    }

    @Override
    public void removeLoco(Loco loco) {
        trainDao.removeLoco(loco);
    }

    @Override
    public void removeLocoById(Long id) {
        trainDao.removeLocoById(id);
    }

    @Override
    public List<Loco> getAllLocos(){
        return trainDao.getAllLocos();
    }

    @Override
    public List<Loco> getLocoByName(String name){
        List<Loco> locoList = trainDao.getLocoByName(name);
        return locoList;
        }
    }
