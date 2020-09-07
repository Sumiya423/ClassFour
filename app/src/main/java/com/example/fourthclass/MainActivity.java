package com.example.fourthclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2;
    Spinner spinner;
    String[]  name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.ButtonOneId);
        btn2=findViewById(R.id.ButtonTwoId);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        spinner= findViewById(R.id.spinnerId);
        name = getResources().getStringArray(R.array.Country);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource
                (this,R.array.Country,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.ButtonOneId){
            Intent intent= new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("Key","one");
            startActivity(intent);
        }
        else if(v.getId()==R.id.ButtonTwoId){
            Intent intent= new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("Key","two");
            startActivity(intent);
        }
    }
}