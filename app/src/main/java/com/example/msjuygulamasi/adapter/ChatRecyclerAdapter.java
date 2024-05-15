package com.example.msjuygulamasi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.msjuygulamasi.ChatActivity;
import com.example.msjuygulamasi.R;

import com.example.msjuygulamasi.model.ChatMessageModel;
import com.example.msjuygulamasi.utils.AndroidUtil;
import com.example.msjuygulamasi.utils.FirebaseUtil;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ChatRecyclerAdapter extends FirestoreRecyclerAdapter<ChatMessageModel, com.example.msjuygulamasi.adapter.ChatRecyclerAdapter.ChatModelViewHolder> {
    Context context;

    public ChatRecyclerAdapter(@NonNull FirestoreRecyclerOptions<ChatMessageModel> options, Context context) {
        super(options);
        this.context=context;
    }

    protected void onBindViewHolder(@NonNull com.example.msjuygulamasi.adapter.ChatRecyclerAdapter.ChatModelViewHolder holder, int position, @NonNull ChatMessageModel model) {
        if(model.getSenderId().equals(FirebaseUtil.currentUserId())){
            holder.leftChatLayout.setVisibility(View.GONE);
            holder.rightChatLayout.setVisibility(View.VISIBLE);
            holder.rightChatTextview.setText(model.getMessage());

        }else{

        holder.rightChatLayout.setVisibility(View.GONE);
        holder.leftChatLayout.setVisibility(View.VISIBLE);
        holder.leftChatTextview.setText(model.getMessage());

        }

    }


    @NonNull
    @Override
    public com.example.msjuygulamasi.adapter.ChatRecyclerAdapter.ChatModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chat_message_recycler_row,parent,false);
        return new com.example.msjuygulamasi.adapter.ChatRecyclerAdapter.ChatModelViewHolder(view);
    }

    class ChatModelViewHolder extends RecyclerView.ViewHolder {

        LinearLayout leftChatLayout, rightChatLayout;
        TextView leftChatTextview, rightChatTextview;

        public ChatModelViewHolder(@NonNull View itemView) {
            super (itemView);
            leftChatLayout =itemView.findViewById(R.id.left_chat_layout);
            rightChatLayout =itemView.findViewById(R.id.right_chat_layout);
            leftChatTextview =itemView.findViewById(R.id.left_chat_textview);
            rightChatTextview= itemView.findViewById(R.id.righ_chat_textview);

        }

    }


        }


