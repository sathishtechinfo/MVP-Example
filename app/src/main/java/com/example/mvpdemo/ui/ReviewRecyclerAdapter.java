package com.example.mvpdemo.ui;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvpdemo.R;
import com.example.mvpdemo.data.network.model.MovieListResponse;

import java.util.List;

public class ReviewRecyclerAdapter extends RecyclerView.Adapter<ReviewRecyclerAdapter.UserViewHolder> {

    private List<User> listUsers;
    Context mContext;
    DatabaseHelper databaseHelper;

    public ReviewRecyclerAdapter(Context mContext, List<User> listUsers) {
        this.listUsers = listUsers;
        this.mContext=mContext;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie_recycler, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {

        holder.txtmoviname.setText(databaseHelper.getUsername()+" : "+listUsers.get(position).getReview());

    }

    @Override
    public int getItemCount() {
        Log.v(ReviewRecyclerAdapter.class.getSimpleName(),""+listUsers.size());
        return listUsers.size();
    }


    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        public TextView txtmoviname;


        LinearLayout llLayout;

        public UserViewHolder(View view) {
            super(view);
            txtmoviname = (TextView) view.findViewById(R.id.txtmoviname);
            llLayout=view.findViewById(R.id.ll_layout);
            databaseHelper=new DatabaseHelper(mContext);

        }
    }


}
