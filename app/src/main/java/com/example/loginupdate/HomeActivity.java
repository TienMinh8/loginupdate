package com.example.loginupdate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginupdate.adapter.UserAdapter;
import com.example.loginupdate.model.User;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private ImageView back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> back());

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        userAdapter = new UserAdapter(getListUser());
        recyclerView.setAdapter(userAdapter);

        RecyclerView.ItemDecoration ItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(ItemDecoration);
    }

    private void back() {
        startActivity(new Intent(HomeActivity.this, MainActivity.class));
    }

    private static List<User> getListUser(){
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.letter_a,"minh"));
        list.add(new User(R.drawable.letter_a,"error"));
        list.add(new User(R.drawable.letter_a,"successful"));
        list.add(new User(R.drawable.letter_a,"aaaaaa"));
        list.add(new User(R.drawable.letter_a,"bbbbbb"));
        list.add(new User(R.drawable.letter_a,"cccccc"));
        list.add(new User(R.drawable.custom_email_icon,"nguyễn tiến minh"));
        return list;
    }
}
