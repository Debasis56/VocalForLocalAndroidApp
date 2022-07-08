package com.example.android.vocalforlocal.Sellers;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.vocalforlocal.Admin.AdminCheckNewProductsActivity;
import com.example.android.vocalforlocal.Buyers.MainActivity;
import com.example.android.vocalforlocal.Model.Products;
import com.example.android.vocalforlocal.R;

import com.example.android.vocalforlocal.ViewHolder.ItemViewHolder;
import com.example.android.vocalforlocal.ViewHolder.ProductViewHolder;
import com.example.android.vocalforlocal.databinding.ActivitySellerHomeBinding;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class SellerHomeActivity extends AppCompatActivity {
    private TextView mTextMesage;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private DatabaseReference unverifiedProductsRef;

    private ActivitySellerHomeBinding binding;
    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelected =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch(item.getItemId())
                    {
                        case R.id.navigation_home:
                            Intent intentHome = new Intent(SellerHomeActivity.this, SellerHomeActivity.class);
                            startActivity(intentHome);
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

        unverifiedProductsRef = FirebaseDatabase.getInstance().getReference().child("Products");

        recyclerView = findViewById(R.id.seller_home_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_seller_home);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Products> options =
                new FirebaseRecyclerOptions.Builder<Products>()
                        .setQuery(unverifiedProductsRef.orderByChild("sellerID").equalTo(FirebaseAuth.getInstance().getCurrentUser().getUid()), Products.class).build();

        FirebaseRecyclerAdapter<Products, ItemViewHolder> adapter = new FirebaseRecyclerAdapter<Products, ItemViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ItemViewHolder holder, int position, @NonNull Products model) {
                holder.textProductName.setText(model.getPname());
                holder.textProductDescription.setText(model.getDescription());
                holder.txtProductStatus.setText("State : "+model.getProductStats());

                holder.textProductPrice.setText("Price = ₹" + model.getPrice());
                Picasso.get().load(model.getImage()).into(holder.imageView);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String productId = model.getPid();
                        CharSequence options[] = new CharSequence[]
                                {
                                        "Yes",
                                        "No"
                                };

                        AlertDialog.Builder builder = new AlertDialog.Builder(SellerHomeActivity.this);
                        builder.setTitle("Do you want to Delete this Product. Are you sure?");
                        builder.setItems(options, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(which == 0)
                                {
                                    DeleteProduct(productId);
                                }
                                if(which == 1)
                                {

                                }

                            }
                        });
                        builder.show();
                    }
                });

            }

            @NonNull
            @Override
            public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seller_item_view, parent, false);
                ItemViewHolder holder = new ItemViewHolder(view);
                return holder;
            }
        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }

    private void DeleteProduct(String productId) {
        unverifiedProductsRef.child(productId).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(SellerHomeActivity.this, "That item has been deleted successfully.", Toast.LENGTH_SHORT).show();


            }
        });

    }
}