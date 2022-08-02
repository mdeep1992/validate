package com.example.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
EditText ed_email,ed_number,ed_password;
Button login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_email=findViewById(R.id.edt_email);
       ed_number=findViewById(R.id.edt_number);
       ed_password =findViewById(R.id.edt_password);
        login_btn=findViewById(R.id.button);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = ed_email.getText().toString();
                String number= ed_number.getText().toString();
                String password=ed_password.getText().toString();
                validate(email, number,password);
            }
        });
    }
    private boolean validate(String email,String number,String password) {
        if (!email.matches("[a-zA-Z0-9][-*.#]@[a-z]\\.[a-z]")) {
            ed_email.requestFocus();
            ed_email.setError("enter the valid email address");
            return false;

        } else if (!(number.length() == 10) && number.matches("[89]")) {
            ed_number.setError("phone number contains ten numbers");
            ed_number.requestFocus();
            return false;
        } else
        if (!password.matches("[@#&]+[0-9a-zA-z]+")) {
            ed_password.setError("password too weak");
            ed_password.requestFocus();
            return false;
        }
return true;
    }
}