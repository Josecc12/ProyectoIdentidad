package com.proyectoidentidad;

public class SaleDetail {
    private String id,sale_id,product_id,amount,price,iva,subtotal,total,code,product;


    public SaleDetail(String amount, String price, String iva, String subtotal, String total, String product) {
        this.amount = amount;
        this.price = price;
        this.iva = iva;
        this.subtotal = subtotal;
        this.total = total;
        this.product = product;
    }

    public SaleDetail(String amount, String subtotal, String total, String code, String product) {
        this.amount = amount;
        this.subtotal = subtotal;
        this.total = total;
        this.code = code;
        this.product = product;
    }

    public SaleDetail(String id, String sale_id, String product_id, String amount, String price, String iva, String subtotal, String total, String code, String product) {
        this.id = id;
        this.sale_id = sale_id;
        this.product_id = product_id;
        this.amount = amount;
        this.price = price;
        this.iva = iva;
        this.subtotal = subtotal;
        this.total = total;
        this.code = code;
        this.product = product;
    }





    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSale_id() {
        return sale_id;
    }

    public void setSale_id(String sale_id) {
        this.sale_id = sale_id;
    }

    public String getProduct_id() {
        return product_id;
    }




    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
