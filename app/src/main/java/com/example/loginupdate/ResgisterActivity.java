package com.example.loginupdate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.loginupdate.model.User;

public class ResgisterActivity extends AppCompatActivity {

    private EditText regemail, regpassword, re_enterpassword;
    private TextView error;
    private Button btn_register;
    private ImageView back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);


        back = findViewById(R.id.back);
        regemail = findViewById(R.id.regemail);
        regpassword = findViewById(R.id.regpassword);
        re_enterpassword = findViewById(R.id.re_enterpassword);
        error = findViewById(R.id.error);
        btn_register = findViewById(R.id.btn_register);

        back.setOnClickListener(v -> back());

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickregister();
            }
        });
    }

    private void back() {
        startActivity(new Intent(ResgisterActivity.this, MainActivity.class));
    }

    private void clickregister() {
        String streemail = regemail.getText().toString().trim();
        String strepassword = regpassword.getText().toString().trim();
        String stre_password = re_enterpassword.getText().toString().trim();

        User user = new User(streemail, strepassword, stre_password);

        error.setVisibility(View.VISIBLE);

        if(user.isValidemail() && user.isValidpassword() && user.isValidre_password()){
            startActivity(new Intent(ResgisterActivity.this, MainActivity.class));
        }else{
            error.setText("Email or password or re-enter password invalid");
            Log.d("DEBUG", "Email hợp lệ: " + user.isValidemail());
            Log.d("DEBUG", "Password hợp lệ: " + user.isValidpassword());
            Log.d("DEBUG", "Re-password hợp lệ: " + user.isValidre_password());
        }
    }
}