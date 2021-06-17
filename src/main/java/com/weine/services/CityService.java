package com.weine.services;

import com.weine.entities.City;
import com.weine.mappers.TicketMapper;
import com.weine.models.dtos.CityDto;
import com.weine.repositories.GenericRepository;

import java.util.List;
/**
 * Service to get the cities of the data base
 * @author Kaleb
 * @author Luis
 */
public class CityService implements IServiceApi<CityDto, Object>{
    private final TicketMapper cityMapper;
    private final GenericRepository<City, Integer> cityRep;

    public CityService() {
        this.cityRep = new GenericRepository<>(City.class);
        this.cityMapper = new TicketMapper();
    }

    @Override
    public List<CityDto> getObjects() {
        return cityMapper.cityListToCityDtoList(cityRep.findAll());
    }

    @Override
    public CityDto find(Integer id) {
        return null;
    }


    @Override
    public CityDto save(CityDto request) throws RuntimeException {
        if(request != null){
            request.setId(null);
            City city = cityMapper.cityDtoToCity(request);
            cityRep.create(city);
            return cityMapper.toCity(city);
        }
        return null;
    }

    @Override
    public CityDto update(CityDto request) throws RuntimeException {
        if(request != null){
            City city = cityMapper.cityDtoToCity(request);
            cityRep.edit(city);
            return cityMapper.toCity(city);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) throws RuntimeException {
        if(id != null){
            cityRep.deleteById(id);
            return true;
        }
        return false;
    }
}
