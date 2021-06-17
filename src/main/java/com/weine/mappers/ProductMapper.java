package com.weine.mappers;

import com.weine.entities.Catalog;
import com.weine.entities.Category;
import com.weine.entities.Product;
import com.weine.models.dtos.CatalogDto;
import com.weine.models.dtos.CategoryDto;
import com.weine.models.dtos.ProductFullInfoDto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProductMapper {
    public ProductMapper() {
    }

    public ProductFullInfoDto toProductFullDto(Product product) {
        if (product == null) {
            return null;
        } else {
            ProductFullInfoDto productFullInfoDto = new ProductFullInfoDto();
            if (product.getId() != null) {
                productFullInfoDto.setId(product.getId());
            }

            if (product.getName() != null) {
                productFullInfoDto.setName(product.getName());
            }

            if (product.getImageLink() != null) {
                productFullInfoDto.setImageLink(product.getImageLink());
            }

            if (product.getPrice() != null) {
                productFullInfoDto.setPrice(product.getPrice());
            }

            if (product.getStock() != null) {
                productFullInfoDto.setStock(product.getStock());
            }

            if (product.getCategory() != null) {
                productFullInfoDto.setCategory(this.toCategoryDto(product.getCategory()));
            }

            return productFullInfoDto;
        }
    }

    public Product toProduct(ProductFullInfoDto productFullInfoDto) {
        if (productFullInfoDto == null) {
            return null;
        } else {
            Product product = new Product();
            if (productFullInfoDto.getId() != null) {
                product.setId(productFullInfoDto.getId());
            }

            if (productFullInfoDto.getName() != null) {
                product.setName(productFullInfoDto.getName());
            }

            if (productFullInfoDto.getImageLink() != null) {
                product.setImageLink(productFullInfoDto.getImageLink());
            }

            if (productFullInfoDto.getStock() != null) {
                product.setStock(productFullInfoDto.getStock());
            }

            if (productFullInfoDto.getPrice() != null) {
                product.setPrice(productFullInfoDto.getPrice());
            }

            if (productFullInfoDto.getCategory() != null) {
                product.setCategory(this.toCategory(productFullInfoDto.getCategory()));
            }

            return product;
        }
    }

    public List<ProductFullInfoDto> toProductDtoList(List<Product> products) {
        if (products == null) {
            return null;
        } else {
            List<ProductFullInfoDto> list = new ArrayList(products.size());
            Iterator var3 = products.iterator();

            while(var3.hasNext()) {
                Product product = (Product)var3.next();
                list.add(this.toProductFullDto(product));
            }

            return list;
        }
    }

    public CatalogDto toCatalogDto(Catalog catalog) {
        if (catalog == null) {
            return null;
        } else {
            CatalogDto catalogDto = new CatalogDto();
            if (catalog.getId() != null) {
                catalogDto.setId(catalog.getId());
            }

            if (catalog.getName() != null) {
                catalogDto.setName(catalog.getName());
            }

            return catalogDto;
        }
    }

    public Catalog catalogDtoToCatalog(CatalogDto catalogDto) {
        if (catalogDto == null) {
            return null;
        } else {
            Catalog catalog = new Catalog();
            if (catalogDto.getId() != null) {
                catalog.setId(catalogDto.getId());
            }

            if (catalogDto.getName() != null) {
                catalog.setName(catalogDto.getName());
            }

            return catalog;
        }
    }

    public List<CatalogDto> toCatalogDtoList(List<Catalog> catalogs) {
        if (catalogs == null) {
            return null;
        } else {
            List<CatalogDto> list = new ArrayList(catalogs.size());
            Iterator var3 = catalogs.iterator();

            while(var3.hasNext()) {
                Catalog catalog = (Catalog)var3.next();
                list.add(this.toCatalogDto(catalog));
            }

            return list;
        }
    }

    public List<CategoryDto> toCategoryDtoList(List<Category> categories) {
        if (categories == null) {
            return null;
        } else {
            List<CategoryDto> list = new ArrayList(categories.size());
            Iterator var3 = categories.iterator();

            while(var3.hasNext()) {
                Category category = (Category)var3.next();
                list.add(this.toCategoryDto(category));
            }

            return list;
        }
    }

    public CategoryDto toCategoryDto(Category category) {
        if (category == null) {
            return null;
        } else {
            CategoryDto categoryDto = new CategoryDto();
            if (category.getId() != null) {
                categoryDto.setId(category.getId());
            }

            if (category.getName() != null) {
                categoryDto.setName(category.getName());
            }

            if (category.getCatalog() != null) {
                categoryDto.setCatalog(this.toCatalogDto(category.getCatalog()));
            }

            return categoryDto;
        }
    }

    public Category toCategory(CategoryDto category) {
        if (category == null) {
            return null;
        } else {
            Category category1 = new Category();
            if (category.getId() != null) {
                category1.setId(category.getId());
            }

            if (category.getName() != null) {
                category1.setName(category.getName());
            }

            if (category.getCatalog() != null) {
                category1.setCatalog(this.catalogDtoToCatalog(category.getCatalog()));
            }

            return category1;
        }
    }
}
