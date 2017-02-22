package com.example.hsuser4.poll_messenger.Activities.Activities.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hsuser4.poll_messenger.Activities.Activities.Model.PollAnswerModel;
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.SavepollDetails;
import com.example.hsuser4.poll_messenger.R;

import java.util.ArrayList;


public class AnswerOptionsAdapter extends RecyclerView.Adapter<AnswerOptionsAdapter.RecyclerViewHolder> {

    //Declare variables
    Button Options;
    Context mContext;

private ArrayList<PollAnswerModel> arrayList = new ArrayList<PollAnswerModel>();

    public AnswerOptionsAdapter(ArrayList<PollAnswerModel> arrayList, Context context)
    {
        mContext = context;
        this.arrayList =arrayList;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);

        //object of recyclerviewHolder

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        PollAnswerModel pollAnswerModel = arrayList.get(position);
        holder.Options.setText(pollAnswerModel.getPollIdentifier());
        holder.Options.setText(pollAnswerModel.getAnswerDescription());


    }

    @Override
    public int getItemCount() {

        if(arrayList.size()==0){
            return 0;

        }else
            return arrayList.size();

    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder

    {

        Button Options;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            Options = (Button)itemView.findViewById(R.id.btnOptions);

        }

    }
}
