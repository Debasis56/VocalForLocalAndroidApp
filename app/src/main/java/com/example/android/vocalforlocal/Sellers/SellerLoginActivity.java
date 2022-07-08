package com.example.android.vocalforlocal.Sellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.esotericsoftware.minlog.Log;
import com.example.android.vocalforlocal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SellerLoginActivity extends AppCompatActivity {
    private Button loginSellerButton;
    private EditText emailInput,
            passwordInput;
    private FirebaseAuth mAuth;

    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_login);
        mAuth = FirebaseAuth.getInstance();


        emailInput = findViewById(R.id.seller_login_email);
        passwordInput = findViewById(R.id.seller_login_password);
        loginSellerButton = findViewById(R.id.seller_login_btn);
        loadingBar = new ProgressDialog(this);



        loginSellerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginSeller();
            }
        });

    }

    private void loginSeller() {
       final String email = emailInput.getText().toString();
        final String password = passwordInput.getText().toString();
        if(!email.equals("") && !password.equals("")) {

            loadingBar.setTitle("Seller Account Login");
            loadingBar.setMessage("Please wait, we are checking the credentials");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                loadingBar.dismiss();
                                Log.info("dsad", "Registered Login");
                                Intent intent = new Intent(SellerLoginActivity.this, SellerHomeActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            }


                        }
                    });


        }
        else {
            Toast.makeText(this, "Please Complete the Login Form", Toast.LENGTH_SHORT).show();
        }

    }
}