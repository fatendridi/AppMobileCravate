package com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Activity;



public class ProduitCravateEnfant {

    private int id;
    private String name;
    private String price;
    private String image;

    public ProduitCravateEnfant(int id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price=price;
    }

    public ProduitCravateEnfant() {
    }

    public ProduitCravateEnfant(int id, String name, String price, String image) {
        this.id = id;
        this.name = name;
        this.price =price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
