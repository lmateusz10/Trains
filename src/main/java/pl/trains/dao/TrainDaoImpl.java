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
    public void addTrain(Train train) {
        entityManager.persist(train);
    }

    @Override
    @Transactional
    public Train getTrainById(Long trainid) {
        Train train = null;
        try {
            train = entityManager.find(Train.class, trainid);
        } catch (Exception e) {
            System.err.println("Nie znaleziono pociągu");
        }
        return train;
    }

    @Override
    @Transactional
    public void addWagonToTrain(Train train, Wagon wagon) {
        train.getWagons().add(wagon);
        entityManager.merge(train);
    }

    @Override
    @Transactional
    public void removeTrainById(Long trainid) {
        Train train = getTrainById(trainid);
        for (Loco loco : train.getLocos()) {
            train.getLocos().remove(loco);
        }
        for (Wagon wagon : train.getWagons()) {
            train.getLocos().remove(wagon);
        }
        train = entityManager.merge(train);
        entityManager.remove(train);
    }

    public List<Train> getTrainByName(String name){
        TypedQuery<Train> query = entityManager.createQuery("select t from Train t where t.trainName like :name", Train.class);
        query.setParameter("name", "%" + name + "%");
        List<Train> trainList = query.getResultList();
        return trainList;
    }
    public List<Train> getAllTrains(){
        TypedQuery<Train> query = entityManager.createQuery("select t from Train t", Train.class);
        List<Train> trainList = query.getResultList();
        return trainList;
    }


    @Override
    @Transactional
    public void removeLocoFromTrain(Loco loco, Train train) {
        try {
            train.getLocos().remove(loco);
            entityManager.merge(train);
        }
        catch (Exception e){
            System.err.println("Dana lokomotywa nie jest przypisana do tego pociągu");
        }

    }

    @Override
    @Transactional
    public void removeWagonFromTrain(Wagon wagon, Train train) {
        try{
        train.getWagons().remove(wagon);
        entityManager.merge(train);}
        catch (Exception e){
            System.err.println("Dany wagon nie jest przypisany do tego pociągu");
        }
    }

    @Override
    @Transactional
    public void addLocoToTrain(Train train, Loco loco) {
        if (train != null && loco!=null)
        {
        train.getLocos().add(loco);
        entityManager.merge(train);
        }
    }

    @Override
    @Transactional
    public void updateTrain(Train train) {
        Train oldtrain = entityManager.find(Train.class, train);
        oldtrain = train;
        entityManager.merge(oldtrain);
    }

    //wagons
    @Override
    @Transactional
    public void addWagon(Wagon wagon) {
        entityManager.persist(wagon);
    }

    @Override
    @Transactional
    public Wagon getWagonById(Long id) {
        Wagon wagon = null;
        try {
            wagon = entityManager.find(Wagon.class, id);
        } catch (Exception e) {
            System.err.println("Nie znaleziono wagonu");
        }
        return wagon;
    }

    @Override
    @Transactional
    public List<Wagon> getWagonByAnything(String anything){
        Wagon wagon = null;

        TypedQuery<Wagon> query = entityManager.createQuery("select w from Wagon w where w.mark like :anything" +
                " or w.owner like :anything or w.type like :anything or w.producer like :anything", Wagon.class );
        query.setParameter("anything", "%" + anything + "&");
        List<Wagon> wagonList = query.getResultList();
        return  wagonList;
    }

    @Override
    @Transactional
    public List<Wagon> getAllWagons() {
        TypedQuery<Wagon> findAllQuery = entityManager.createNamedQuery("Wagons.findAll", Wagon.class);
        List<Wagon> resultList = findAllQuery.getResultList();
        return resultList;
    }

    @Override
    @Transactional
    public void removeWagon(Wagon wagon) {
        for (Train train:wagon.getTrains()){
            train.getWagons().remove(wagon);
        }
        wagon = entityManager.merge(wagon);
        entityManager.remove(wagon);
    }

    @Override
    @Transactional
    public void removeWagonById(Long id) {
        Wagon wagon = null;
        wagon = getWagonById(id);
        removeWagon(wagon);
    }

    @Override
    @Transactional
    public void addLoco(Loco loco) {
        entityManager.persist(loco);
    }


    @Override
    @Transactional
    public Loco getLocoById(Long id) {
        Loco loco = null;
        try {
            loco = entityManager.find(Loco.class, id);
            loco.getTrains().size();
        } catch (Exception e) {
            System.err.println("Nie znaleziono lokomotywy");
        } finally {
            return loco;
        }
    }

    @Override
    @Transactional
    public void removeLocoById(Long id) {
        Loco loco = getLocoById(id);
        for (Train train : loco.getTrains()) {
            loco.getTrains().remove(train);
        }
        loco = entityManager.merge(loco);
        entityManager.remove(loco);
    }

    @Override
    @Transactional
    public void removeLoco(Loco loco) {
        entityManager.remove(loco);
    }

    @Override
    @Transactional
    public List<Loco> getAllLocos() {
        TypedQuery<Loco> findAllLocos = entityManager.createNamedQuery("locos.findAll", Loco.class);
        List<Loco> locos = findAllLocos.getResultList();
        return locos;
    }

    @Override
    @Transactional
    public List<Loco> getLocoByName(String name){
        TypedQuery<Loco> findLocoByNameQuery = entityManager
                .createQuery("select l from Loco l where l.name like  :name", Loco.class);
        findLocoByNameQuery.setParameter("name", "%" + name + "%");
        List<Loco> locoList = findLocoByNameQuery.getResultList();
        System.out.println(locoList);
        return locoList;
    }
}
