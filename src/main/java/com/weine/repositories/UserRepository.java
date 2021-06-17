package com.weine.repositories;

import com.weine.entities.User;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserRepository extends GenericRepository<User, Integer>{
    public UserRepository() {
        super(User.class);
    }

    public User findByEmailAndPassword(String email, String password) {
        if(email != null && password != null) {
            CriteriaQuery<User> criteriaQuery = this.criteriaBuilder.createQuery(entity);
            Root<User> entityRoot = criteriaQuery.from(entity);
            criteriaQuery.select(entityRoot).where(criteriaBuilder.and(criteriaBuilder.equal(entityRoot.get("email"), email) ,criteriaBuilder.equal(entityRoot.get("password"), password)));
            return this.entityManager.createQuery(criteriaQuery).getSingleResult();
        }
        return null;
    }

}
