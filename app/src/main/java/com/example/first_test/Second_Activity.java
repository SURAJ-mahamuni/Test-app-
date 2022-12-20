package com.example.first_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Second_Activity extends Activity {
    TextView f_n,l_n,c_n,pin_c,dob1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initView();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        f_n.setText(f_n.getHint().toString()+"= "+bundle.getString("first name"));
        l_n.setText(l_n.getHint().toString()+"= "+bundle.getString("last name"));
        c_n.setText(c_n.getHint().toString()+"= "+bundle.getString("city"));
        pin_c.setText(pin_c.getHint().toString()+"= "+bundle.getString("pin"));
        dob1.setText(dob1.getHint().toString()+"= "+bundle.getString("dob"));
    }

    private void initView() {
        f_n = findViewById(R.id.f_n);
        l_n = findViewById(R.id.l_n);
        c_n = findViewById(R.id.c_n);
        pin_c = findViewById(R.id.pin_c);
        dob1 = findViewById(R.id.dob1);
    }
}
