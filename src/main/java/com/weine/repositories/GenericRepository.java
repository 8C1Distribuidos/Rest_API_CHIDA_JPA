package com.weine.repositories;

import com.weine.connection.DbConnection;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenericRepository<E, I> {
    protected final Class<E> entity;
    protected final EntityManager entityManager;
    protected final CriteriaBuilder criteriaBuilder;

    public GenericRepository(Class<E> entity) {
        this.entity = entity;
        DbConnection connection = new DbConnection();
        entityManager = connection.getEntityManager();
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public List<E> findAll(){
        CriteriaQuery<E> criteriaQuery = this.entityManager.getCriteriaBuilder().createQuery(entity);
        Root<E> entityRoot = criteriaQuery.from(entity);
        criteriaQuery.select(entityRoot);
        return this.entityManager.createQuery(criteriaQuery).getResultList();
    }

    public E findById(I id){
        if(id != null) {
            return this.entityManager.find(entity, id);
        }
        else{
            return null;
        }
    }

    public void create(E entity){
        entityManager.persist(entity);
    }

    public void edit(E entity){
        entityManager.merge(entity);
    }

    public void deleteById(I id){
        E entity = findById(id);
        entityManager.remove(entityManager.merge(entity));
    }
}
