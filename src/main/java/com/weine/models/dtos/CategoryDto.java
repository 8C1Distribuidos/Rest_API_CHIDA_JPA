package com.weine.models.dtos;

/**
 * Category Dto to show the general info of the <b>products categories</b> as the:<br>
 * {@link #id} to keep the id of the category.<br>
 * {@link #name} to keep the name of the category.<br>
 * {@link #catalog} to keep the relation of the catalog.<br>
 *  <b>Is not necessary pass the id in each insert or save of this class, but for updates all the fields is necessary</b>
 *  @author Kaleb
 *  @author Luis
 */
public class CategoryDto{
    private Integer id;
    private String name;
    private CatalogDto catalog;

    public CategoryDto(Integer id, String name, CatalogDto catalog) {
        this.id = id;
        this.name = name;
        this.catalog = catalog;
    }

    public CategoryDto() {
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

    public CatalogDto getCatalog() {
        return catalog;
    }

    public void setCatalog(CatalogDto catalog) {
        this.catalog = catalog;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", catalog=" + catalog +
                '}';
    }
}
