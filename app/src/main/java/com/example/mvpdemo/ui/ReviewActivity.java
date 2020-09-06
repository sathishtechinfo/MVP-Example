package com.example.mvpdemo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mvpdemo.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ReviewActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private User user;
    EditText edt_Review;
    Button btn_Post;
    private RecyclerView recyclerViewUsers;
    private List<User> listUsers;
    private ReviewRecyclerAdapter usersRecyclerAdapter;
    String ID="";
    List<User> students=new ArrayList<>();
    ImageView back;
    LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        databaseHelper=new DatabaseHelper(this);
        user=new User();
        edt_Review=(EditText)findViewById(R.id.edt_review);
        btn_Post=(Button)findViewById(R.id.btn_send);
        back=(ImageView)findViewById(R.id.img_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        initViews();
        initObjects();
        ID=getIntent().getStringExtra("ID");

        btn_Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setReview(edt_Review.getText().toString().trim());
                user.setReview_id(ID);
                databaseHelper.addreview(user);
                Toast.makeText(getApplicationContext(),"Your Review Added successfully",Toast.LENGTH_LONG).show();
                Intent accountsIntent = new Intent(ReviewActivity.this, ReviewActivity.class);
                accountsIntent.putExtra("ID",ID);
                startActivity(accountsIntent);
                finish();
            }
        });
     }
    private void initViews() {

        recyclerViewUsers = (RecyclerView) findViewById(R.id.recyclerViewUsers);
    }

    private void initObjects() {
        listUsers = new ArrayList<>();
        usersRecyclerAdapter = new ReviewRecyclerAdapter(this,listUsers);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewUsers.setLayoutManager(mLayoutManager);
        recyclerViewUsers.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUsers.setHasFixedSize(true);
        recyclerViewUsers.setAdapter(usersRecyclerAdapter);


        getDataFromSQLite();
    }

    private void getDataFromSQLite() {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listUsers.clear();
                listUsers.addAll(databaseHelper.getAllMovie(ID));

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                usersRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}