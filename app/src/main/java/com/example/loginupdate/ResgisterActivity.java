package com.example.loginupdate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.loginupdate.model.User;

public class ResgisterActivity extends AppCompatActivity {

    private EditText regemail, regpassword, re_enterpassword;
    private TextView error;
    private Button btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        regemail = findViewById(R.id.regemail);
        regpassword = findViewById(R.id.regpassword);
        re_enterpassword = findViewById(R.id.re_enterpassword);
        error = findViewById(R.id.error);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickregister();
            }
        });
    }

    private void clickregister() {
        String streemail = regemail.getText().toString().trim();
        String strepassword = regpassword.getText().toString().trim();
        String stre_password = re_enterpassword.getText().toString().trim();

        User user = new User(streemail, strepassword);

        error.setVisibility(View.VISIBLE);

        if(user.isValidre_password() && user.isValidemail() && user.isValidre_password()){
            setContentView(R.layout.activiry_login);
        }else{
            error.setText("Email or password or re-enter password invalid");
        }
    }
}