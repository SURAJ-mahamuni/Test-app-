package com.example.first_test;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;

public class CustomDialog extends Dialog implements View.OnClickListener {
    Button ok,cancel;
    Context context;
    OnValidateDialogListener onValidateDialogListener;

    public CustomDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        setContentView(R.layout.custom_dialog);

        ok = findViewById(R.id.ok);
        cancel = findViewById(R.id.cancel);

        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    public void setOnValidateDialogListener(OnValidateDialogListener onValidateDialogListener){
        this.onValidateDialogListener = onValidateDialogListener;
    }

    public interface OnValidateDialogListener{
        void onOkClick();
        void onCancelClick();
    }

    @Override
    public void onClick(View view) {
        if(view == ok){
            onValidateDialogListener.onOkClick();
        }
        if(view == cancel){
            onValidateDialogListener.onCancelClick();
        }
    }
}
