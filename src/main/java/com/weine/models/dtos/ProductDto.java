package com.weine.models.dtos;

/**
 * Product Dto to show the general info of the <b>product</b> as the:
 * {@link #id} to keep the id of the product.<br>
 * {@link #name} to keep the name of the product.<br>
 * This class is the super class of {@link ProductFullInfoDto} and just has to fields to
 * been sent as brief info.
 * @author Kaleb
 * @author Luis
 */
public class ProductDto {
    protected Integer id;
    protected String name;

    public ProductDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
