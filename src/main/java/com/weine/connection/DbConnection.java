package com.weine.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnection {
    private final EntityManager entityManager;

    public DbConnection() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = managerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
