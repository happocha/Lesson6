package ru.geekbrains.lesson6;

import java.io.Serializable;

public class SimpleNote implements Serializable {

    private final String title;
    private final String desc;
    private final String date;

    public SimpleNote(String title, String desc, String date) {
        this.title = title;
        this.desc = desc;
        this.date = date;
    }
}
