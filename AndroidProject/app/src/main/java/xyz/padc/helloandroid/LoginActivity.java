package xyz.padc.helloandroid;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;



public class LoginActivity extends AppCompatActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    private static final String CORRECT_EMAIL = "abc@gmail.com";
    private static final String CORRECT_PASSWORD = "Abcdefg";   //constant attribute

    private Button btnLogin;
    private EditText etEmailOrPhone;
    private EditText etPassword;
    private TextView btnForgotPassowrd;
    private TextView btnToRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        etEmailOrPhone = findViewById(R.id.et_email_or_phone);
        etPassword=findViewById(R.id.et_password);
        btnForgotPassowrd=findViewById(R.id.btn_forgot_password);
        btnToRegister=findViewById(R.id.btn_to_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String emailOrPhone = etEmailOrPhone.getText().toString();
              String password=etPassword.getText().toString();

              if(TextUtils.isEmpty(emailOrPhone)){
                    etEmailOrPhone.setError("Email or phone cannot be empty");
                    return;
                }
               if(TextUtils.isEmpty(password)){
                  etPassword.setError("Password cannot be empty");
                  return;
               }

               if(TextUtils.equals(emailOrPhone, CORRECT_EMAIL)
                    && TextUtils.equals(password,CORRECT_PASSWORD)){
                 /*  Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();*/
                  Intent intent = HelloAndroidActivity.newIntent(getApplicationContext());
                  startActivity(intent);
               }else{
                   Snackbar.make(view, "Incorrect email or password", Snackbar.LENGTH_INDEFINITE)
                           .setAction("Action", null).show();
               }

            }
        });
        btnForgotPassowrd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "\"Forgot Password\" is coming soon", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Action", null).show();

            }

        });
        btnToRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = RegisterActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });

    }
}
