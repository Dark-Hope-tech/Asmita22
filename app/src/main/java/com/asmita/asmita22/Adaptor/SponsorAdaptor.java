package com.asmita.asmita22.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.asmita.asmita22.Models.SponsorsModel;
import com.asmita.asmita22.Models.homeModel;
import com.asmita.asmita22.R;

import java.util.ArrayList;

public class SponsorAdaptor extends RecyclerView.Adapter<SponsorAdaptor.viewholder>{
    ArrayList<SponsorsModel> list;
    Context context;

    public SponsorAdaptor(ArrayList<SponsorsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SponsorAdaptor.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sponsors_sample,parent,false);
        return new SponsorAdaptor.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SponsorAdaptor.viewholder holder, int position) {
        final SponsorsModel model= list.get(position);
        Glide.with(context).load(model.getImg()).into(holder.SponsorImg);
        holder.SponsorImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(model.getLink()));
                context.startActivity(browserIntent);
            }
        });
        holder.SponsorName.setText(model.getSponsorName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class viewholder extends RecyclerView.ViewHolder {
        ImageView SponsorImg;
        TextView SponsorName;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            SponsorImg=itemView.findViewById(R.id.SponsorImage);
            SponsorName=itemView.findViewById(R.id.SponsorName);
        }
    }
}
