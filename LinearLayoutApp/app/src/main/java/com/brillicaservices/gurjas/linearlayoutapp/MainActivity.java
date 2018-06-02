package com.brillicaservices.gurjas.linearlayoutapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/*
 * @Author: Gurjas Singh,
 * Brillica Services, Dehradun
 * Dated - 2, June, 2018*/

public class MainActivity extends AppCompatActivity {

    /*
     * Creating a Global variable of TextView.
     * So that we can use it's reference in other functions as well.
     * */
    TextView obj;

    /*
     * onCreate is default function that we need for every activity.
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Use this function to tell the activity which view is to be loaded.
         * R - automatically generated file. This file will be generated only after successful gradle build*/
        setContentView(R.layout.activity_main);

        /*
         * Casting TextView object with it's ID.
         * R.id.hello_world has been declared in the activity_main.xml file.
         * */
        obj = (TextView) findViewById(R.id.hello_world);

        /*
         * Using predefined function .setText() to set text to the text view
         * */
        obj.setText("Gurjas");
    }
}
