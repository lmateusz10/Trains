package pl.trains.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 * Created by Mateusz on 16.03.2017.
 */
public class EntityManagerHelper {
    @PersistenceContext
    EntityManager entityManager;

    @Produces
    @RequestScoped
    public EntityManager createEntityManager() {
        return entityManager;
    }

}
