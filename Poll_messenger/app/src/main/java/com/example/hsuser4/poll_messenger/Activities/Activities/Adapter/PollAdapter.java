package com.example.hsuser4.poll_messenger.Activities.Activities.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hsuser4.poll_messenger.Activities.Activities.Model.DisplayRecords;
import com.example.hsuser4.poll_messenger.R;

import java.util.ArrayList;



public class PollAdapter extends RecyclerView.Adapter<PollAdapter.PollViewHolder>{
    public ArrayList<DisplayRecords> mAnswers;
    Context mcontext;

    public PollAdapter(ArrayList<DisplayRecords>mAnswers)
    {
        this.mAnswers =mAnswers;
    }

    public PollAdapter(Context context) {
        this.mcontext = context;
        Toast.makeText(context, "POLL ADAPTER", Toast.LENGTH_LONG);

    }
    private Context getMcontext ()
    {
        return mcontext;
    }

    @Override
    public PollAdapter.PollViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mcontext);

        //inflater
        View Pollview = inflater.inflate(R.layout.activity_display_data,parent,false);

        PollViewHolder viewHolder = new PollViewHolder(Pollview);
        return viewHolder;
    }

    public class PollViewHolder extends RecyclerView.ViewHolder{
          public TextView title ,question, end_date;
          public Button answer;

          public PollViewHolder(View itemView)
          {
              super(itemView);
              title = (TextView) itemView.findViewById(R.id.tvtitle);
              question = (TextView) itemView.findViewById(R.id.tvQuestion);
              end_date = (TextView) itemView.findViewById(R.id.tvdate);

              answer = (Button)itemView.findViewById(R.id.btnAnswers);

          }
      }
    @Override
    public void onBindViewHolder(PollAdapter.PollViewHolder holder, int position) {

        DisplayRecords displayRecords= mAnswers.get(position);

        holder.title.setText(mAnswers.get(position).getPoll_title());
        holder.question.setText(mAnswers.get(position).getquestion());
        holder.end_date.setText(mAnswers.get(position).getEnd_date());

       // holder.answer.setText(mAnswers.get(position).getAnswers());


    }

    @Override
    public int getItemCount()
    {
        if(mAnswers != null){
            return mAnswers.size();
        } else {
            return 0;
        }
    }
}
