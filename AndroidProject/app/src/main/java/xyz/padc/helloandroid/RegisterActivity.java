package xyz.padc.helloandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.PrivateKey;

/**
 * Created by DELL on 11/16/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    public static Intent newIntent(Context context){
        Intent intent=new Intent(context, RegisterActivity.class);
        return intent;

    }
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etAddress;
    private Button btnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister=findViewById(R.id.btn_register);
        etName=findViewById(R.id.et_name);
        etPhone=findViewById(R.id.et_phone);
        etEmail=findViewById(R.id.et_email);
        etPassword=findViewById(R.id.et_password);
        etConfirmPassword=findViewById(R.id.et_confirm_password);
        etAddress=findViewById(R.id.et_address);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String phone=etPhone.getText().toString();
                String email=etEmail.getText().toString();
                String password=etPassword.getText().toString();
                String confirmPassword=etConfirmPassword.getText().toString();


                if(TextUtils.isEmpty(name)){
                    etName.setError("Your name cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(phone)){
                    etPhone.setError("Your Phone cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    etEmail.setError("Your Email cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    etPassword.setError("Password cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(confirmPassword)){
                    etConfirmPassword.setError("Please insert confirm password");
                    return;
                }
                if(TextUtils.isEmpty(confirmPassword)){
                    etAddress.setError("Address cannot be empty");
                    return;
                }

                Intent intent = LoginActivity.newIntent(getApplicationContext());
                startActivity(intent);



            }
        });


    }
}
