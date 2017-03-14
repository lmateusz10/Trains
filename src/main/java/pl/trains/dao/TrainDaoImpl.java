package pl.trains.dao;

import pl.trains.model.Loco;
import pl.trains.model.Train;
import pl.trains.model.Wagon;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

/**
 * Created by Mateusz on 28.02.2017.
 */
@RequestScoped
public class TrainDaoImpl implements TrainDao {

    @PersistenceUnit(name = "myPersistenceUnit")
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void addTrain(Train train){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(train);
        entityTransaction.commit();
        entityManager.close();
    }
    @Override
    public boolean removeTrain(Train train){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(train);
        entityTransaction.commit();
        entityManager.close();
        return true;
    }
    @Override
    public Train getTrain(Long id){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        Train train = entityManager.find(Train.class, id);
        entityTransaction.commit();
        entityManager.close();
        return train;}


    @Override
    public void addWagon(Wagon wagon){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(wagon);
        entityTransaction.commit();
        entityManager.close();
    }
    @Override
    public boolean removeWagon(Wagon wagon){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(wagon);
        entityTransaction.commit();
        entityManager.close();
        return true;
    }
    @Override
    public Wagon getWagon(Long id){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        Wagon wagon = entityManager.find(Wagon.class, id);
        entityTransaction.commit();
        entityManager.close();
        return wagon;

    }

    @Override
    public void addLoco(Loco loco){
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(loco);
        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public Loco getLoco(Long id){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        Loco loco = entityManager.find(Loco.class, id);
        loco.getTrains().size();
        entityTransaction.commit();
        entityManager.close();
        return loco;

    }


}
