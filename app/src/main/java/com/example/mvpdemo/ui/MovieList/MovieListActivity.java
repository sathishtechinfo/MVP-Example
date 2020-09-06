package com.example.mvpdemo.ui.MovieList;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mvpdemo.R;
import com.example.mvpdemo.base.BaseActivity;
import com.example.mvpdemo.data.network.model.MovieListResponse;
import com.example.mvpdemo.data.network.model.MovieResponse;
import com.example.mvpdemo.ui.LoginActivity;
import com.example.mvpdemo.ui.PreferenceUtils;
import com.example.mvpdemo.ui.UsersRecyclerAdapter;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieListActivity extends BaseActivity implements MovieListMvpView {
    @Inject
    MovieListMvpPresenter<MovieListMvpView> mPresenter;
    @Inject
    UsersRecyclerAdapter usersRecyclerAdapter;
    @Inject
    LinearLayoutManager mLayoutManager;
    @BindView(R.id.recyclerViewUsers)
    RecyclerView mRecyclerView;
    Toolbar toolbar;
    List<MovieListResponse> movieListResponses=new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        mPresenter.onPostDetails();
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(toolbar);
        setUp();


    }


    @Override
    protected void setUp() {

       // usersRecyclerAdapter = new PationListAdapter( mbillstatusnew,mFreedonDetails);

        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(usersRecyclerAdapter);

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.log_out:
                PreferenceUtils.savePassword(null, this);
                PreferenceUtils.saveEmail(null, this);
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updatepost(List<MovieListResponse>  movieResponse) {

       // Toast.makeText(getApplicationContext(),movieResponse.toString(),Toast.LENGTH_LONG).show();

        usersRecyclerAdapter = new UsersRecyclerAdapter( this,movieResponse);

        mRecyclerView.setAdapter(usersRecyclerAdapter);
    }
}

