package com.example.loginupdate;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        userAdapter = new UserAdapter(getListUser());
        recyclerView.setAdapter(userAdapter);

        RecyclerView.ItemDecoration ItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(ItemDecoration);
    }

    private static List<User> getListUser(){
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.letter_a,"minh"));
        return list;
    }
}
