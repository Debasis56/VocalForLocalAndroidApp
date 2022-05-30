package com.example.android.vocalforlocal.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android.vocalforlocal.HomeActivity;
import com.example.android.vocalforlocal.MainActivity;
import com.example.android.vocalforlocal.R;

public class AdminCategoryActivity extends AppCompatActivity {
private ImageView bagsandwallets, broom, crafts, eatable, furnitures, handicrafts, handlooms, homeUtilities, jewelleryandhats, jutecrafts, kitchenanddining, officeutilities, terracotta, tribalpainting, woolenarts, stonecarvings;
private Button LogoutBtn, CheckOrdersBtn, maintainProductsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin_category);
        LogoutBtn = (Button) findViewById(R.id.admin_logout_button);
        CheckOrdersBtn = (Button) findViewById(R.id.check_orders_btn);
        maintainProductsBtn = (Button) findViewById(R.id.maintain_products);


        maintainProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, HomeActivity.class);
                intent.putExtra("Admin", "Admin");
                startActivity(intent);


            }
        });

        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
        CheckOrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminNewOrdersActivity.class);
                 startActivity(intent);


            }
        });
        bagsandwallets = (ImageView)findViewById(R.id.BagsAndWallets);
        broom = (ImageView)findViewById(R.id.Brooms);
        crafts = (ImageView)findViewById(R.id.Crafts);
        furnitures = (ImageView)findViewById(R.id.furnitures);
        eatable = (ImageView)findViewById(R.id.eatables);
        handicrafts = (ImageView)findViewById(R.id.Handicrafts);
        handlooms = (ImageView)findViewById(R.id.handlooms);
        homeUtilities = (ImageView)findViewById(R.id.homeUtilities);
        jewelleryandhats = (ImageView)findViewById(R.id.JewelleryAndHats);
        jutecrafts = (ImageView)findViewById(R.id.JuteCrafts);
        kitchenanddining = (ImageView)findViewById(R.id.KitchenAndDining);
        officeutilities = (ImageView)findViewById(R.id.officeUtilities);
        terracotta = (ImageView)findViewById(R.id.terracotta);
        tribalpainting = (ImageView)findViewById(R.id.paintings);
        woolenarts = (ImageView)findViewById(R.id.woolen);
        stonecarvings = (ImageView)findViewById(R.id.StoneCarvings);


        bagsandwallets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Bags And Wallets");
                startActivity(intent);
            }
        });

        broom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Broom");
                startActivity(intent);
            }
        });
        crafts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Crafts");
                startActivity(intent);
            }
        });
        eatable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Eatables");
                startActivity(intent);
            }
        });
        furnitures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Furnitures");
                startActivity(intent);
            }
        });
        handicrafts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Handicrafts");
                startActivity(intent);
            }
        });
        handlooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Handlooms");
                startActivity(intent);
            }
        });
        homeUtilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Home Utilities");
                startActivity(intent);
            }
        });
        jewelleryandhats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Jewellery And Hats");
                startActivity(intent);
            }
        });
        jutecrafts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Jute Crafts");
                startActivity(intent);
            }
        });
        kitchenanddining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Kitchen And Dining");
                startActivity(intent);
            }
        });
        officeutilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Office Utilities");
                startActivity(intent);
            }
        });
        terracotta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Terracotta");
                startActivity(intent);
            }
        });
        tribalpainting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Tribal Painting");
                startActivity(intent);
            }
        });
        woolenarts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Woolen Arts");
                startActivity(intent);
            }
        });
        stonecarvings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Stone Carvings");
                startActivity(intent);
            }
        });
    }
}