package com.weine.repositories;

import com.weine.connection.DbConnection;
import com.weine.entities.Product;
import com.weine.models.criteria.ProductCriteria;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductCriteriaRep extends CriteriaRep<Product, ProductCriteria>{

    public ProductCriteriaRep() {
        super(new DbConnection().getEntityManager());
    }

    @Override
    protected Predicate getPredicate(ProductCriteria searchCriteria, Root<Product> entityRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if(Objects.nonNull(searchCriteria)) {
            predicates.add(criteriaBuilder.equal(entityRoot.get("deleted"), false));
            if(Objects.nonNull(searchCriteria.getName())) {
                predicates.add(criteriaBuilder.like(entityRoot.get("name"), "%" + searchCriteria.getName() + "%"));
            }
            List<Integer> ids = searchCriteria.getIds();
            if(ids != null){
                predicates.add(entityRoot.get("id").in(ids));
            }
        }

        return  criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
