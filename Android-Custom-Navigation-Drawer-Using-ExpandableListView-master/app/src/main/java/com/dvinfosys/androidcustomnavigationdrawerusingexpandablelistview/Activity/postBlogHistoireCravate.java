package com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Activity;

public class postBlogHistoireCravate {
    int img;
    String txt1;
    String txt2;
    String title;



    public postBlogHistoireCravate() {
    }

    public postBlogHistoireCravate(int img, String txt1, String txt2, String title) {
        this.img = img;
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.title = title;


    }
    public void setImg(int img) {

        this.img = img;
    }


    public int getImg() {

        return img;
    }

    public String getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }

    public String getTxt2() {
        return txt2;
    }

    public void setTxt2(String txt2) {
        this.txt2 = txt2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
