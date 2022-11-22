package models;

public class CheckProduct {

    private Long id;
    private Product productId;
    private Check checkId;
    private Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Check getCheckId() {
        return checkId;
    }

    public void setCheckId(Check checkId) {
        this.checkId = checkId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
