package com.example.android.vocalforlocal.Sellers;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.android.vocalforlocal.Buyers.MainActivity;
import com.example.android.vocalforlocal.R;

import com.example.android.vocalforlocal.databinding.ActivitySellerHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;


public class SellerHomeActivity extends AppCompatActivity {
    private TextView mTextMesage;

    private ActivitySellerHomeBinding binding;
    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelected =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch(item.getItemId())
                    {
                        case R.id.navigation_home:
                            mTextMesage.setText(R.string.title_home);
                            return true;
                        case R.id.navigation_add:
                            Intent intentCate = new Intent(SellerHomeActivity.this, SellerProductCategoryActivity.class);
                            startActivity(intentCate);

                            return true;
                        case R.id.navigation_logout:
                            final FirebaseAuth mAuth;
                            mAuth = FirebaseAuth.getInstance();
                            mAuth.signOut();
                            Intent intentMain = new Intent(SellerHomeActivity.this, MainActivity.class);
                            intentMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intentMain);
                            finish();
                            return true;
                    }
                    return false;
                }
            };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySellerHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelected);


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_seller_home);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}