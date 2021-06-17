package com.weine.services;

import com.weine.entities.Product;
import com.weine.mappers.ProductMapper;
import com.weine.models.criteria.ProductCriteria;
import com.weine.models.dtos.ProductFullInfoDto;
import com.weine.repositories.GenericRepository;
import com.weine.repositories.ProductCriteriaRep;

import java.util.List;

/**
 * Service to get the products information
 * @author Kaleb
 * @author Luis
 */
public class ProductService implements IServiceApi<ProductFullInfoDto, ProductCriteria>{
    private final GenericRepository<Product, Integer> productRep;
    private final ProductCriteriaRep productCriteriaRep;
    private final ProductMapper productMapper;

    public ProductService() {
        this.productRep = new GenericRepository<>(Product.class);
        this.productCriteriaRep = new ProductCriteriaRep();
        this.productMapper = new ProductMapper();
    }

    @Override
    public List<ProductFullInfoDto> getObjects(ProductCriteria criteria) {
        return productMapper.toProductDtoList(productCriteriaRep.findAllWithFilters(criteria, Product.class, null));
    }


    public Product getProduct(Integer id){
        if(id != null) {
            return productRep.findById(id);
        }
        return null;
    }

    @Override
    public ProductFullInfoDto find(Integer id){
        return productMapper.toProductFullDto(getProduct(id));
    }
    @Override
    public ProductFullInfoDto save(ProductFullInfoDto productFullInfoDto) throws RuntimeException{
        if(productFullInfoDto != null) {
            productFullInfoDto.setId(null);//Just to clear the field
            Product product = productMapper.toProduct(productFullInfoDto);
            productRep.create(product);
            return productMapper.toProductFullDto(product);
        }
        return null;
    }
    @Override
    public ProductFullInfoDto update(ProductFullInfoDto productFullInfoDto) throws RuntimeException{
        if(productFullInfoDto != null) {
            if(find(productFullInfoDto.getId()) != null) {//Verify the existence of the product
                Product product = productMapper.toProduct(productFullInfoDto);
                productRep.edit(product);
                return productMapper.toProductFullDto(product);
            }
        }
        return null;
    }
    @Override
    public boolean delete(Integer id)
    {
        Product product = getProduct(id);
        if(product != null)
        {
            if(product.getItems() != null && product.getItems().isEmpty()) {
                //If this product doesn't have any relation can be deleted
                productRep.deleteById(id);
            }
            else{//In the case of this product exist in one or more relations
                product.setDeleted(true);
                productRep.edit(product);
            }
            return true;
        }
        return false;
    }
}
