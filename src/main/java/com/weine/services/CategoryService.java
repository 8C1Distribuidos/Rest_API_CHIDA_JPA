package com.weine.services;

import com.weine.entities.Category;
import com.weine.mappers.ProductMapper;
import com.weine.models.dtos.CategoryDto;
import com.weine.repositories.GenericRepository;

import java.util.List;

/**
 * Service to get the products categories information
 * @author Kaleb
 * @author Luis
 */
public class CategoryService implements IServiceApi<CategoryDto, Object>{
    private final GenericRepository<Category, Integer> categoryRep;
    private final ProductMapper productMapper;

    public CategoryService() {
        this.categoryRep = new GenericRepository<>(Category.class);
        this.productMapper = new ProductMapper();
    }

    @Override
    public List<CategoryDto> getObjects()
    {
        return productMapper.toCategoryDtoList(categoryRep.findAll());
    }

    @Override
    public CategoryDto find(Integer id) {
        return null;
    }


    @Override
    public CategoryDto save(CategoryDto request) {
        if(request != null) {
            request.setId(null);//Just to clear the field
            Category category = productMapper.toCategory(request);
            categoryRep.create(category);
            return productMapper.toCategoryDto(category);
        }
        return null;
    }

    @Override
    public CategoryDto update(CategoryDto request) {
        if(request != null) {
            if(categoryRep.findById(request.getId()) != null) {
                Category category = productMapper.toCategory(request);
                categoryRep.edit(category);
                return productMapper.toCategoryDto(category);
            }
        }
        return null;
    }

    @Override
    public boolean delete(Integer id)  {
        if(id != null) {
            categoryRep.deleteById(id);
            return true;
        }
        return false;
    }
}
