package com.weine.services;

import com.weine.entities.Catalog;
import com.weine.mappers.ProductMapper;
import com.weine.models.dtos.CatalogDto;
import com.weine.repositories.GenericRepository;

import java.util.List;

/**
 * Service to get the catalog information
 * @author Luis
 */
public class CatalogService implements IServiceApi<CatalogDto, Object>{
    private final GenericRepository<Catalog, Integer> catalogRep;
    private final ProductMapper productMapper;

    public CatalogService() {
        this.catalogRep = new GenericRepository<>(Catalog.class);
        this.productMapper = new ProductMapper();
    }

    @Override
    public List<CatalogDto> getObjects() {
        return productMapper.toCatalogDtoList(catalogRep.findAll());
    }

    @Override
    public CatalogDto find(Integer id) {
        return null;
    }

    @Override
    public CatalogDto save(CatalogDto request) throws RuntimeException {
        return null;
    }

    @Override
    public CatalogDto update(CatalogDto request) throws RuntimeException {
        if(request != null){
            Catalog catalog = productMapper.catalogDtoToCatalog(request);
            catalogRep.edit(catalog);
            return productMapper.toCatalogDto(catalog);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) throws RuntimeException {
        return false;
    }
}
