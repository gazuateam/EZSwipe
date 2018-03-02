package com.gazua.ezswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SellerList extends AppCompatActivity {
    ListView listview;
    ArrayList<String> li = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_list);

        final List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        listview = (ListView)findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, li);
        listview.setAdapter(adapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                for (DataSnapshot child: children) {
                    String dining_str = (String) child.child("Location").getValue();
                    if(Objects.equals(dining_str, DiningSelect.dining_hall())) {
                        Map<String, String> map = new HashMap<String, String>();
//                        map.put("RID", (String) child.child("RID").getValue());
//                        map.put("Buyer_ID", (String) child.child("Buyer_ID").getValue());
                        map.put("Buyer_name", (String) child.child("Buyer_name").getValue());
//                        map.put("Created_at", (String) child.child("Created_at").getValue());
//                        map.put("Location", (String) child.child("Location").getValue());
                        map.put("Number", (String) child.child("Number").getValue());
                        map.put("Price", (String) child.child("Price").getValue());
//                        map.put("Seller_name", (String) child.child("Seller_name").getValue());
//                        map.put("Status", (String) child.child("Status").getValue());
//                        map.put("Buyer_ID", (String) child.child("Buyer_ID").getValue());

                        list.add(map);
                    }
                }

                String st = "";

                if(list.size() != 0) {
                    for(int i = 0; i < list.size(); i++) {
                        st = list.get(i).get("Buyer_name");
                        st = st + ",    People: " + list.get(i).get("Number");
                        st = st + ",    $" + list.get(i).get("Price");
                        li.add(st);
                        adapter.notifyDataSetChanged();
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(SellerList.this, "Error", Toast.LENGTH_LONG).show();
            }

        });



    }



}
