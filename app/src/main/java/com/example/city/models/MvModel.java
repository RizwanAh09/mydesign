package com.example.city.models;

public class MvModel {
    int pic;
    String title,desc;

    public MvModel(int pic, String title, String desc) {
        this.pic = pic;
        this.title = title;
        this.desc = desc;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
