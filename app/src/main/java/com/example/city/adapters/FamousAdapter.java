package com.example.city.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.city.R;
import com.example.city.models.FamousModel;

import java.util.ArrayList;

public class FamousAdapter extends RecyclerView.Adapter<FamousAdapter.viewHolder> {
    ArrayList<FamousModel> list;
    Context context;

    public FamousAdapter(ArrayList<FamousModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.famous_design,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        FamousModel model = list.get(position);
        holder.imageView.setImageResource(model.getPic());
        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,desc;
        public viewHolder(@NonNull View itemView) {

            super(itemView);
            imageView = itemView.findViewById(R.id.famous_image);
            title = itemView.findViewById(R.id.famous_title);
            desc = itemView.findViewById(R.id.famous_desc);
        }
    }
}
