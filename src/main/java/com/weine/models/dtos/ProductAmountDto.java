package com.weine.models.dtos;

/**
 * To contains the amount of the products.
 */
public class ProductAmountDto extends ProductDto{
    protected Integer amount;

    public ProductAmountDto(Integer id, String name, Integer amount) {
        super(id, name);
        this.amount = amount;
    }

    public ProductAmountDto(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ProductAmountDto{" +
                "amount=" + amount +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
