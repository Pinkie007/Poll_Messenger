package com.example.hsuser4.poll_messenger.Activities.Activities.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hsuser4.poll_messenger.Activities.Activities.Activities.AnswersDisplayActivity;
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.SavepollDetails;
import com.example.hsuser4.poll_messenger.R;

import java.util.ArrayList;

/**
 * Created by hsuser4 on 2017/02/22.
 */

public class PollAdapter extends RecyclerView.Adapter<PollAdapter.RecyclerViewHolder> {
    //Declare variables
    TextView title, question;
    Context mContext;

    private ArrayList<SavepollDetails> arrayList = new ArrayList<SavepollDetails>();

    public PollAdapter(ArrayList<SavepollDetails> arrayList, Context context) {
        mContext = context;
        this.arrayList = arrayList;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_results, parent, false);

        //object of recyclerviewHolder
        PollAdapter.RecyclerViewHolder recyclerViewHolder = new PollAdapter.RecyclerViewHolder(view);
        return recyclerViewHolder;

    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {

        SavepollDetails savepollDetails = arrayList.get(position);

        holder.title.setText(savepollDetails.getPoll_title());
        holder.question.setText(savepollDetails.getQuestion());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(mContext, AnswersDisplayActivity.class);

                String pollGUID = arrayList.get(holder.getAdapterPosition()).getPoll_guid();
                Bundle b = new Bundle();
                b.putString("Poll GUID", pollGUID);

                myintent.putExtras(b);

                mContext.startActivity(myintent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (arrayList.size() == 0) {
            return 0;
        } else

            return arrayList.size();

    }


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder

    {
         TextView title, question;
        ImageView imageView;


        public RecyclerViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tvtitle);
            question = (TextView) itemView.findViewById(R.id.tvquestion);
             imageView = (ImageView) itemView.findViewById(R.id.imgnext);


        }

    }
}
