package ru.geekbrains.lesson6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /*
        1. Создать фрагмент со списком городов
        2. Динамечески добавить список городов
        3. Создать фрагмент для отображения герба
        4. Поддержать land ориент.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}