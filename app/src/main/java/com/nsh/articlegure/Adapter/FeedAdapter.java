package com.nsh.articlegure.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nsh.articlegure.Feed;
import com.nsh.articlegure.R;

import java.util.List;

/**
 * Created by ThisIsNSH on 5/14/2018.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder> {

    private Context mContext;
    private List<Feed> feedList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView info_text1,like_count1;
        public ImageView image1;
        public Button like1;

        public MyViewHolder(View view){
            super(view);
            like1 = view.findViewById(R.id.like);
            info_text1 = view.findViewById(R.id.info);
            like_count1 = view.findViewById(R.id.like_count);
            image1 = view.findViewById(R.id.image);
        }
    }

    public FeedAdapter(Context mContext,List<Feed> feedList){
        this.mContext=mContext;
        this.feedList=feedList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.feed_view,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position){
        Feed feed = feedList.get(position);
        holder.like_count1.setText(feed.getLike()+" people\nlike this");
        Glide.with(mContext).load(feed.getImgUrl()).into(holder.image1);
        holder.info_text1.setText(feed.getInfo());

        holder.like1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference ref = database.getReference(Integer.toString(position+1)).child("likes");
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String data = dataSnapshot.getValue(String.class);
                        ref.setValue(Integer.toString(Integer.parseInt(data)+1));
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                /*String data = holder.like_count1.getText().toString();
                ref.setValue(Integer.toString(Integer.parseInt(data)+1));
                holder.like_count1.setText(Integer.toString(Integer.parseInt(data)+1));*/
            }
        });
    }
    @Override
    public int getItemCount() {
        return feedList.size();
    }
}