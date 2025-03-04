package com.example.loginupdate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginupdate.adapter.UserAdapter;
import com.example.loginupdate.model.User;

import java.util.List;

public class   MainActivity extends AppCompatActivity {

    private EditText email, password;
    private TextView error, reg;
    private Button btnsignin, change;
    private RecyclerView recyclerview;
    private List<User> userList;
    private UserAdapter userAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initView();
        setupListener();
        
    }

    private void initView(){
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        error = findViewById(R.id.error);
        btnsignin = findViewById(R.id.btn_signin);
        reg = findViewById(R.id.reg);
        change = findViewById(R.id.change);
    }

    private void setupListener(){
        btnsignin.setOnClickListener(v -> clickLogin());
        reg.setOnClickListener(v -> navigateToRegister());
        change.setOnClickListener(v -> backchange());
    }



    private void clickLogin(){

        String stremail = email.getText().toString().trim();
        String strpassword = password.getText().toString().trim();
        if (TextUtils.isEmpty(stremail) || TextUtils.isEmpty(strpassword)) {
            error.setVisibility(View.VISIBLE);
            error.setTextColor(Color.RED);
            error.setText("Email and password are required");
            return;
        }
        User user = new User(stremail, strpassword);
        if (stremail.equals("admin@gmail.com") && strpassword.equals("1234567")) {
            Toast.makeText(MainActivity.this,"Login successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
        } else {
            error.setVisibility(View.VISIBLE);
            error.setTextColor(Color.RED);
            error.setText("Invalid email or password");
        }
    }

    private void navigateToRegister(){
        startActivity(new Intent(MainActivity.this, ResgisterActivity.class));
    }
    private void backchange() {
        startActivity(new Intent(MainActivity.this, ChangeActivity.class));
    }
}