package com.weine.models.dtos;

/**
 * User Dto to show the general info of the <b>catalogs</b>
 * {@link #id} to keep the id of the catalog.<br>
 * {@link #name} to keep the name of the catalog.<br>
 * @author Luis
 */
public class CatalogDto {
    private Integer id;
    private String name;

    public CatalogDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CatalogDto() {
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
        return "CatalogDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
