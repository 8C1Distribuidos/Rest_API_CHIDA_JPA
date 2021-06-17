package com.weine.models.dtos;

/**
 * Product Dto to show all the info of the products
 * @author Kaleb
 */
public class ProductFullInfoDto extends ProductDto{
    protected String imageLink;
    protected Integer price;
    protected Integer stock;
    protected CategoryDto category;

    public ProductFullInfoDto(Integer id, String name, String imageLink, Integer price, Integer stock, CategoryDto category) {
        super(id, name);
        this.imageLink = imageLink;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public ProductFullInfoDto() {
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductFullInfoDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", category=" + category +
                '}';
    }
}
