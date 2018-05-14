package com.nsh.articlegure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nsh.articlegure.Adapter.FeedAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FeedAdapter feedAdapter;
    private List<Feed> feedList;
    private ArrayList<String> info_string, url_string, like_string;

    public String firebase_info, firebase_url, firebase_like;
    public String firebase_info1, firebase_url1, firebase_like1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        feedList = new ArrayList<>();
        feedAdapter = new FeedAdapter(this, feedList);

        getFeed();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(feedAdapter);

    }

    public void getFeed() {
        for (int i = 0; i < 5; i++) {

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference(Integer.toString(i + 1));

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    DataGetter data = dataSnapshot.getValue(DataGetter.class);
                    feedList.add(new Feed(data.getTex(), data.getImg(), data.getLikes()));
                    feedAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(DatabaseError error) {
                }
            });
        }
        feedAdapter.notifyDataSetChanged();
    }
}
