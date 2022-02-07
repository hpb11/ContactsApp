package com.example.contactapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    CardView addbtn;
    ArrayList<Contact> contacts;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.list);
        addbtn=findViewById(R.id.addBtn);
        contacts= new ArrayList<>();
       contacts.add(new Contact("Kushal","9428317708"));
        contacts.add(new Contact("Papa","9974066389"));
        contacts.add(new Contact("Unknown","9973066389"));


        adapter= new MyAdapter(contacts,this);
        list.setAdapter(adapter);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddNewContactActivity.class);
               startActivityForResult(intent,100);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK){
            String name=data.getStringExtra("name");
            String phone=data.getStringExtra("phone");
            Contact c=new Contact(name,phone);
            contacts.add(c);
            adapter.notifyDataSetChanged();

        }
    }
}