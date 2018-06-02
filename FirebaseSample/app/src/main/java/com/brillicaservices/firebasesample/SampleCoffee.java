package com.brillicaservices.firebasesample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SampleCoffee extends AppCompatActivity {

    TextView coffeeShopLabel, totalPriceDisplay;
    EditText customerName;
    EditText coffeeQuantity;
    Button coffeeSubmitBtn;
    RadioButton quantity250, quantity500;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_coffee);

        coffeeShopLabel = (TextView) findViewById(R.id.coffee_shop);
        customerName = (EditText) findViewById(R.id.coffee_shop_number);
        coffeeQuantity = (EditText) findViewById(R.id.coffee_quantity);
        quantity250 = (RadioButton) findViewById(R.id.quantity_250);
        quantity500 = (RadioButton) findViewById(R.id.quantity_500);
        totalPriceDisplay = (TextView) findViewById(R.id.total_price_display);

        coffeeSubmitBtn = (Button) findViewById(R.id.submit_coffee);

        coffeeSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = String.valueOf(customerName.getText());
                int quantity = Integer.parseInt(customerName.getText().toString());
                int totalPrice = 0;
                if (quantity250.isChecked()) {
                    totalPrice = quantity*10;
                } else {
                    totalPrice = quantity*15;
                }

//                totalPriceDisplay.setText("Hello " + name + " your order price is: " +
//                 totalPrice);
                Toast.makeText(getApplicationContext(), "Hello " + name +
                        " your order price is: " + totalPrice,
                        Toast.LENGTH_LONG).show();


            }
        });

//        Intent intent = getIntent();
//        String str = intent.getStringExtra("key");
////        System.out.print(str);
//        coffeeShopLabel.setText(str);


//        Intent intent = new Intent(SampleCoffee.this, MainActivity.class);
//        intent.putExtra("newValue", "Hello Android");
//        setResult(101, intent);
//        finish();


    }


}
