package com.weine.repositories;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Abstract class to make personalized queries with pagination, sort and filters.
 * @param <T> The entity class
 * @param <X> The search criteria
 */
public abstract class CriteriaRep<T,X> {
    protected final EntityManager entityManager;
    protected final CriteriaBuilder criteriaBuilder;

    public CriteriaRep(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    /**
     * Function to make the query and get the data, applying the corresponding parameters
     * @param searchCriteria The filters of the query
     * @param entity The entity class path
     * @param limit The limit of the results, if does not need set null
     * @return The result list
     */
    public List<T> findAllWithFilters(X searchCriteria, Class<T> entity, Integer limit)
    {
        //Initializing the query
        CriteriaQuery<T> criteriaQuery = this.criteriaBuilder.createQuery(entity);
        Root<T> entityRoot = criteriaQuery.from(entity);

        //Adding the filters
        Predicate predicate = getPredicate(searchCriteria, entityRoot);
        criteriaQuery.select(entityRoot).where(predicate);

        if(limit != null){
            return entityManager.createQuery(criteriaQuery).setMaxResults(limit).getResultList();
        }
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    /**
     * Function to get the total amount of results of the search
     * @param predicate The predicate where is the filters
     * @param entity The entity path
     * @return The amount of rows
     */
    protected long getCount(Predicate predicate, Class<T> entity){
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<T> countRoot = countQuery.from(entity);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }

    /**
     * Function to apply the filters in a predicate
     * @param searchCriteria The filters of the query
     * @param entityRoot The entity root
     * @return The predicate of the filters
     */
    protected abstract Predicate getPredicate(X searchCriteria, Root<T> entityRoot);
}
