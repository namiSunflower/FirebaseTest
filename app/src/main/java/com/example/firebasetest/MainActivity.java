package com.example.firebasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText name;
Button submit;
DatabaseReference beep;
String stringName;
getterSetter retrieveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        submit =(Button)findViewById(R.id.submit);
        retrieveData = new getterSetter();
        beep = FirebaseDatabase.getInstance().getReference().child("Member");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveData.setName(name.getText().toString());
                beep.push().setValue(retrieveData);
            }
        });
    }
}