package com.weine.models.dtos;

/**
 * City Dto to wrap the info of the <b>city</b> as the:
 * {@link #id} the id of the city.<br>
 * {@link #name} the name of the city.<br>
 * @author Luis
 */
public class CityDto {
    Integer id;
    String name;

    public CityDto() {
    }

    public CityDto(Integer id, String name) {
        this.id = id;
        this.name = name;
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
        return "CityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
