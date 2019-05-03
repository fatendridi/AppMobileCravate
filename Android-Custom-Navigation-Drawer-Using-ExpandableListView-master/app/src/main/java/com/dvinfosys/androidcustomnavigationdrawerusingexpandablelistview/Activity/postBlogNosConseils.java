package com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Activity;

public class postBlogNosConseils {
    int img;
    String titleMini;
    String phrase;

    public postBlogNosConseils() {
    }

    public postBlogNosConseils(int img, String titleMini, String phrase) {
        this.img = img;
        this.titleMini = titleMini;
        this.phrase = phrase;

    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitleMini() {
        return titleMini;
    }

    public void setTitleMini(String titleMini) {
        this.titleMini = titleMini;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
