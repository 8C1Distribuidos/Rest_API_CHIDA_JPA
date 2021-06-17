package com.weine.models.criteria;


/**
 * Product to contains the info of the page to be showed as the size, the page, the sort direction and the sort by
 */
public class PageProp {
    private int page = 0;
    private int size = 10;
    private Sort sortDirection = Sort.ASC;
    private String sortBy;

    public PageProp(int page, int size, Sort sortDirection, String sortBy) {
        this.page = page;
        this.size = size;
        this.sortDirection = sortDirection;
        this.sortBy = sortBy;
    }

    public PageProp() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Sort getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(Sort sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public String toString() {
        return "PageProp{" +
                "page=" + page +
                ", size=" + size +
                ", sortDirection=" + sortDirection +
                ", sortBy='" + sortBy + '\'' +
                '}';
    }
}
