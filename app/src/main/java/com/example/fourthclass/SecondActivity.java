package com.example.fourthclass;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class SecondActivity extends AppCompatActivity {

    TextView textView, timeText,dateText;
    Button dateBtn,timeBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Second Activity");
        textView= findViewById(R.id.textViewId);
        dateBtn=findViewById(R.id.dateBtnId);
        timeBtn=findViewById(R.id.timeBtnId);
        dateText=findViewById(R.id.dateTextId);
        timeText=findViewById(R.id.timeTextId);

        String value = getIntent().getStringExtra("Key");

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePicker timePicker=new TimePicker(SecondActivity.this);

                int hour = timePicker.getHour();
                int min =timePicker.getMinute();

                TimePickerDialog dialog = new TimePickerDialog(SecondActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minitue) {
                        timeText.setText("Time: "+hourOfDay+":"+minitue);

                    }
                },hour,min,false);
                dialog.show();

            }
        });

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePicker datePicker=new DatePicker(SecondActivity.this);

                int day=datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();

                DatePickerDialog dialog= new DatePickerDialog(SecondActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        int a= month+1;
                        dateText.setText("Date: "+dayOfMonth+"/"+a+"/"+year);

                    }
                },year,month,day);

                dialog.show();

            }
        });

        if(value.equals("one")){
            textView.setText("Come from Button One");
        }
        else if (value.equals("two")){
            textView.setText("Come from Button Two");
        }
    }
}