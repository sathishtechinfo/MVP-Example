package com.example.mvpdemo.ui;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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
import com.example.mvpdemo.data.network.model.MoviesItem;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder> {

    private List<MovieListResponse> listUsers;
    Context mContext;

    public UsersRecyclerAdapter(Context mContext, List<MovieListResponse> listUsers) {
        this.listUsers = listUsers;
        this.mContext=mContext;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_recycler, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {

        holder.txtmoviname.setText(listUsers.get(position).getTitle());
        Glide.with(mContext)
                .load(listUsers.get(position).getImage())
                .override(600, 200)
                .into(holder.Img_movipic);


        holder.llLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(mContext,ReviewActivity.class);
                i.putExtra("ID",String.valueOf(listUsers.get(position).getId()));
                mContext.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        Log.v(UsersRecyclerAdapter.class.getSimpleName(),""+listUsers.size());
        return listUsers.size();
    }


    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        public TextView txtmoviname;
        public TextView Txt_Rating;
        public ImageView Img_movipic;


        LinearLayout llLayout;

        public UserViewHolder(View view) {
            super(view);
            txtmoviname = (TextView) view.findViewById(R.id.txtmoviname);
            Txt_Rating = (TextView) view.findViewById(R.id.txtrating);
            Img_movipic=(ImageView)view.findViewById(R.id.imgmovie);
            llLayout=view.findViewById(R.id.ll_layout);

        }
    }


}
