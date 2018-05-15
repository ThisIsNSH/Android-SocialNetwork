package com.nsh.articlegure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
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

    int i;
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
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        /*LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);*/
        recyclerView.setAdapter(feedAdapter);

    }

    public void getFeed() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getReferenceFromUrl("https://article-gure-276fe.firebaseio.com/");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DataGetter data = dataSnapshot.getValue(DataGetter.class);
                feedList.add(new Feed(data.getInfo(), data.getImg(), data.getLikes()));
                feedAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                final DataGetter data = dataSnapshot.getValue(DataGetter.class);
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot1) {
                        for (int i = 0; i < dataSnapshot1.getChildrenCount(); i++) {

                            if (feedList.get(i).getImgUrl().equals(data.getImg())) {
                                feedList.remove(i);

                                feedList.add(i, new Feed(data.getInfo(), data.getImg(), data.getLikes()));
                                feedAdapter.notifyDataSetChanged();

                            }
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                final DataGetter data = dataSnapshot.getValue(DataGetter.class);
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot1) {
                        for (int i = 0; i < dataSnapshot1.getChildrenCount(); i++) {

                            if (feedList.get(i).getImgUrl().equals(data.getImg())) {
                                feedList.remove(i);

                                feedAdapter.notifyDataSetChanged();

                            }
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
