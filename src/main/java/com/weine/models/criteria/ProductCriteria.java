package com.weine.models.criteria;

import java.util.List;

public class ProductCriteria {
    private String name;
    private List<Integer> ids;

    public ProductCriteria(String name) {
        this.name = name;
    }

    public ProductCriteria() {
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "ProductCriteria{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
