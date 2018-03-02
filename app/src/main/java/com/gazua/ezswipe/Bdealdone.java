package com.gazua.ezswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class Bdealdone extends AppCompatActivity {

    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdealdone);

        ref = DiningSelect.push_reference();
        String sName = ref.child("Seller_name").toString();
        TextView textView = findViewById(R.id.dealdone);
        textView.setText(sName);
        Toast.makeText(Bdealdone.this, sName, Toast.LENGTH_LONG).show();
    }
}
