package com.gazua.ezswipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BuyerPrice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_price);


        findViewById(R.id.buyerTimeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(new Intent(BuyerPrice.this, BuyerTime.class));
                Toast.makeText(BuyerPrice.this, "Buyer Time.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
