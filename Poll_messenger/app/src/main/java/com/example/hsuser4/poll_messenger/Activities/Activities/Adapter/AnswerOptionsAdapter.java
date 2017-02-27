package com.example.hsuser4.poll_messenger.Activities.Activities.Adapter;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.hsuser4.poll_messenger.Activities.Activities.Model.PollAnswerModel;
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.PostPollModel;
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.SavepollDetails;
import com.example.hsuser4.poll_messenger.Activities.Activities.Services.ApiUtils;
import com.example.hsuser4.poll_messenger.Activities.Activities.Services.PostApi;
import com.example.hsuser4.poll_messenger.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AnswerOptionsAdapter extends RecyclerView.Adapter<AnswerOptionsAdapter.RecyclerViewHolder> {

    //Declare variables
    Button Options;
    Context mContext;
    private PostApi mpostService;

    final int answer_id =0;
    final String os_type = "Android";
    final String location = "Durban";
    final String manu = Build.MANUFACTURER;
    final String dev = Build.VERSION.RELEASE;
    final String os_version = Build.MODEL;
    final String user_name = "Pinkie";
    final String user_id = "dubepinkie07@gmail.com";
    final String dateVoted = "";



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

        final PollAnswerModel pollAnswerModel = arrayList.get(position);
        holder.Options.setText(pollAnswerModel.getPollIdentifier());
        holder.Options.setText(pollAnswerModel.getAnswerDescription());



        holder.Options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                mpostService = ApiUtils.getPostApi();

                String guii=pollAnswerModel.getPollIdentifier().toString();
                int id=pollAnswerModel.getAnswerID();
                sendPost(guii,id,os_type,location,manu,dev,os_version,user_name,user_id,dateVoted);
            }
        });
    }


    public void sendPost(String pollGuid, int ansId, String os_type, String location, String manufacturer,String device_model,
                         String os_version, String user_name, String user_id, String date_voted)
    {
        ApiUtils.getPostApi();
        mpostService.savePost(pollGuid, ansId, os_type, location, manufacturer, device_model, os_version, user_name, user_id, date_voted)
                .enqueue(new Callback<PostPollModel>() {

            @Override
            public void onResponse(Call<PostPollModel> call, Response<PostPollModel> response) {
                if(response.isSuccessful())
                {
                    showResponse(response.body().toString());
                    Log.i("TAG", "post submitted to API" + response.body().toString());

                    Toast.makeText(mContext,"success",Toast.LENGTH_SHORT).show();

                }
            }
            @Override
            public void onFailure(Call<PostPollModel> call, Throwable t) {
                Log.e("TAG", "Unable to submit post to API" );

                Toast.makeText(mContext,"failed check connection",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void showResponse(String response ) {

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
