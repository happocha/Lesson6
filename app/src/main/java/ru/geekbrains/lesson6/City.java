package ru.geekbrains.lesson6;

import java.io.Serializable;

public class City implements Serializable {

    private final String title;
    private final String desc;
    private final String date;

    public City(String title, String desc, String date) {
        this.title = title;
        this.desc = desc;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return date;
    }
}
