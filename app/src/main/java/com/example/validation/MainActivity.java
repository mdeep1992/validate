package com.example.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    EditText ed_email, ed_number, ed_password;
    Button login_btn;
    TextInputLayout input_layout;
    TextInputEditText edinput_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_email = findViewById(R.id.edt_email);
        ed_number = findViewById(R.id.edt_number);
        ed_password = findViewById(R.id.edt_password);
        login_btn = findViewById(R.id.button);
        input_layout=findViewById(R.id.input_layout);
        edinput_num=findViewById(R.id.input_ednum);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = ed_email.getText().toString();
                String number = ed_number.getText().toString();
                String password = ed_password.getText().toString();
                validate(email, number, password);

            }
        });
        edinput_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input_number=edinput_num.getText().toString();
                if (input_number.length()==0){
                    input_layout.setHelperText("field cannot be empty");

                }else if ((input_number.length()<5) ){
                    input_layout.setHelperText("pls enter atleast 5 digits");
                }else    if ((input_number.length()>5)&&(input_number.length()<8)){
                    input_layout.setHelperText(" num length  should not allow more than 8digits");
                }else if(input_number.length()>=8){
                    input_layout.setHelperText("mob num  is too large");





                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    private boolean validate(String email, String number, String password) {
        if (!email.matches("[a-zA-Z0-9]+[#&*%]{1}[a-zA-z0-9]*[@][a-z]+\\.[a-z]{2,3}")) {
            ed_email.requestFocus();
            ed_email.setError("enter the valid email address");
            return false;

        } else if (!((number.length() == 10) && number.matches("^[8,9]{1}[0-9]{9}"))) {
            ed_number.setError("phone number contains ten numbers");
            return false;
        } else if (!(password.matches("[a-zA-z0-9#*_]+") && (password.length() >= 8))) {
            ed_password.requestFocus();
            ed_password.setError("password too weak");

            return false;
        }
        else  {
            Toast.makeText(this, "loginsuccess", Toast.LENGTH_LONG).show();
            return true;
        }
    }

}