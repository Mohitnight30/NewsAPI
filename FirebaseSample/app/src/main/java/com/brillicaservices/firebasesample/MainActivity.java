package com.brillicaservices.firebasesample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;

    Button googleSignInButton;
    private FirebaseAuth mAuth;
    private GoogleSignInClient signInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mAuth = FirebaseAuth.getInstance();
        signInClient = GoogleSignIn.getClient(this, gso);

        googleSignInButton = (Button) findViewById(R.id.btn_google_sign_in);

        googleSignInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent signInIntent = signInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        TextView usernameDisplay = (TextView) findViewById(R.id.tv_display_username);
        usernameDisplay.setText(currentUser.getDisplayName());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> accountTask = GoogleSignIn.getSignedInAccountFromIntent(data);

            try{
                GoogleSignInAccount account = accountTask.getResult(ApiException.class);
            } catch (ApiException e) {
                Log.e(TAG, "Google Sign in failed." + e);
            }
        }
    }



    TextView obj;
//    Button btn;

//    int SAMPLE_REQUEST_CODE = 101; // for sample activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        obj = (TextView) findViewById(R.id.hello_world);
        obj.setText("Gurjas");
//        btn = (Button) findViewById(R.id.next_activity_button);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(
//                        MainActivity.this,
//                        SampleCoffee.class);
//                startActivity(intent);
//            }
//        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == SAMPLE_REQUEST_CODE) {
//            String str = data.getStringExtra("newValue");
//            obj.setText(str);
//        }
//
//    }
}
