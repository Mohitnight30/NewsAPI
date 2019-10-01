package com.example.firstapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    String value = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.ac1_text_view);
        button = findViewById(R.id.ac1_button);

//        Intent intent = getIntent();
//        if (intent.hasExtra("Name")) {
//            value = intent.getStringExtra("Name");
//            textView.setText("Hello " + value);
//            String college = intent.getStringExtra("College");
//            Toast.makeText(getApplicationContext(),
//                    "Your college is: " + college,
//                    Toast.LENGTH_LONG).show();
//        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(
                        MainActivity.this,
                        Main2Activity.class);
                startActivityForResult(intent1,
                        101);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == 101) &&
                (resultCode == RESULT_OK) ) {
            String name = data.
                    getStringExtra("Name");
            textView.setText("Hello " + name);
        }

    }
}
