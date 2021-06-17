package com.weine.models.dtos;

/**
 * Ticket Dto to show the general <b>info of the purchases as individual item</b> as the:
 * {@link #id} to keep the product relation of the purchase.<br>
 * {@link #amount} to keep the amount of the products.<br>
 * {@link #toDelete} is used to know if the item must to be deleted when is called the method update.
 * if {@link #toDelete} is {@code true} this object is going to be deleted in the database and if
 * is {@code false} it is going to be updated. Also this field is <b>just writeable</b> so is not going to be read when this objects
 * go outside.<br>
 * @author Luis
 */
public class PurchaseItemDto {
    private Integer id;
    private Integer idProduct;
    private Integer amount;
    private boolean toDelete = false;

    public PurchaseItemDto(Integer id, Integer amount, boolean toDelete) {
        this.id = id;
        this.amount = amount;
        this.toDelete = toDelete;
    }

    public PurchaseItemDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean isToDelete() {
        return toDelete;
    }

    public void setToDelete(boolean toDelete) {
        this.toDelete = toDelete;
    }

    @Override
    public String toString() {
        return "PurchaseItemDto{" +
                "id=" + id +
                ", amount=" + amount +
                ", toDelete=" + toDelete +
                '}';
    }
}
