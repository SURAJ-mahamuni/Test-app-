package com.example.first_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText first_n, last_n, city, pin, date_ob_edt;
    Button date_ob_btn, submit;
    CustomDialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        date_ob_btn.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    private void initView() {
        first_n = findViewById(R.id.first_n);
        last_n = findViewById(R.id.last_n);
        city = findViewById(R.id.city);
        pin = findViewById(R.id.pin);
        date_ob_edt = findViewById(R.id.date_ob_edt);

        date_ob_btn = findViewById(R.id.date_ob_btn);
        submit = findViewById(R.id.submit);
    }

    @Override
    public void onClick(View view) {
        if (view == date_ob_btn) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                    new MyDateSetListener(), 2022, 11, 20);
            datePickerDialog.show();

        }

        if (view == submit) {
            if (first_n.getText() == null || last_n.getText() == null ||
                    city.getText() == null || pin.getText() == null || date_ob_edt.getText() == null) {
                Toast.makeText(this, "You should fill the all information", Toast.LENGTH_SHORT).show();
            } else {
                customDialog = new CustomDialog(MainActivity.this);
                customDialog.setOnValidateDialogListener(new MyValivadeDialogListener());
                customDialog.show();
            }


        }
    }

    class MyValivadeDialogListener implements CustomDialog.OnValidateDialogListener {

        @Override
        public void onOkClick() {
            Intent intent = new Intent(MainActivity.this, Second_Activity.class);
            intent.putExtra("first name", first_n.getText().toString());
            intent.putExtra("last name", last_n.getText().toString());
            intent.putExtra("city", city.getText().toString());
            intent.putExtra("pin", pin.getText().toString());
            intent.putExtra("dob", date_ob_edt.getText().toString());
            startActivity(intent);
        }

        @Override
        public void onCancelClick() {
            customDialog.dismiss();
        }
    }

    class MyDateSetListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            date_ob_edt.setText(day + "/" + month + "/" + year);
        }
    }
}