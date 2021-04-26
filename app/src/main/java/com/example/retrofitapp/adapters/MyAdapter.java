package com.example.retrofitapp.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapp.fragments.DetailsFragment;
import com.example.retrofitapp.fragments.ListFragment;
import com.example.retrofitapp.interfaces.Navigate;
import com.example.retrofitapp.models.ApiModel;
import com.example.retrofitapp.interfaces.OnClickListner;
import com.example.retrofitapp.R;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<ApiModel> apiModels;
    private OnClickListner onClickListner;

    public MyAdapter(Context context, List<ApiModel> apiModels, OnClickListner onClickListner) {
        this.context = context;
        this.apiModels = apiModels;
        this.onClickListner = onClickListner;
        notifyDataSetChanged();

    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);

        return new MyAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, final int position) {
        final ApiModel apiModel = apiModels.get(position);

        holder.name.setText(apiModel.getName());

        Picasso.get()
                .load(apiModel.getImageurl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageView);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListner.onClick(position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return apiModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, bio;
        CardView cardView;
        ImageView imageView;

        MyViewHolder(View view) {
            super(view);
            cardView = view.findViewById(R.id.card);
            name = view.findViewById(R.id.name);
            imageView = view.findViewById(R.id.coverImage);


        }

    }


}
