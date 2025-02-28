package com.example.loginupdate.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginupdate.R;
import com.example.loginupdate.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    private List<User> mlistUser;

    public UserAdapter(List<User> mlistUser) {
        this.mlistUser = mlistUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mlistUser.get(position);
        if(user == null){
            return;
        }
        holder.avatar.setImageResource(user.getAvatar());
        holder.username.setText(user.getUsername());

    }

    @Override
    public int getItemCount() {
        if (mlistUser != null){
            return mlistUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private ImageView avatar;
        private TextView username;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            username = itemView.findViewById(R.id.username);
        }
    }
}
