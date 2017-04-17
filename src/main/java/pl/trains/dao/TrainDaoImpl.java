package pl.trains.dao;

import pl.trains.model.Loco;
import pl.trains.model.Product;
import pl.trains.model.Train;
import pl.trains.model.Wagon;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.util.List;

/**
 * Created by Mateusz on 28.02.2017.
 */
@RequestScoped
@Transactional
public class TrainDaoImpl implements TrainDao {

    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    @Transactional
    public Train removeLocoFromTrain(Loco loco, Train train){
        train.getLocos().remove(loco);
        train = entityManager.merge(train);
        return train;
    }
    @Override
    @Transactional
    public Train removeWagonFromTrain(Wagon wagon, Train train){
        train.getWagons().remove(wagon);
        train = entityManager.merge(train);
        return train;
    }

    @Override
    @Transactional
    public Train addLocoToTrain(Train train, Loco loco){
        System.out.println(loco.getName());
        train.getLocos().add(loco);
        entityManager.merge(train);
        return train;
    }

    @Override
    @Transactional
    public Train addWagonToTrain(Train train, Wagon wagon){

        train.getWagons().add(wagon);
        entityManager.merge(train);
        return train;
    }
    @Override
    @Transactional
    public void update(Train train){
        entityManager.merge(train);
    }

    @Override
    @Transactional
    public List<Wagon> findAll() {
        TypedQuery<Wagon> findAllQuery = entityManager.createNamedQuery("Wagons.findAll", Wagon.class);
        List<Wagon> resultList = findAllQuery.getResultList();
        return resultList;
    }
    @Override
    @Transactional
    public void addTrain(Train train){
        entityManager.persist(train);
    }

    @Override
    @Transactional
    public boolean removeTrain(Long trainid){
        Train train = entityManager.find(Train.class, trainid);
        for (Loco loco:train.getLocos()) {
            train.getLocos().remove(loco);
        }
        train = entityManager.merge(train);
        entityManager.remove(train);
        return true;
    }
    @Override
    @Transactional
    public Train getTrain(Long id){
        Train train = entityManager.find(Train.class, id);
        return train;}


    @Override
    @Transactional
    public void addWagon(Wagon wagon){
        entityManager.persist(wagon);
    }

    @Override
    @Transactional
    public boolean removeWagon(Wagon wagon){
        entityManager.remove(wagon);
        return true;
    }
    @Override
    @Transactional
    public Wagon getWagon(Long id){
        Wagon wagon = entityManager.find(Wagon.class, id);
        return wagon;

    }

    @Override
    @Transactional
    public void addLoco(Loco loco){
        entityManager.persist(loco);
    }

    @Override
    @Transactional
    public Loco getLoco(Long id){
        Loco loco = entityManager.find(Loco.class, id);
        loco.getTrains().size();
        return loco;

    }




}
