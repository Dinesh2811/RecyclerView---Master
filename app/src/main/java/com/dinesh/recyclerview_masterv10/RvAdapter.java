package com.dinesh.recyclerview_masterv10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    ArrayList<RvModel> rvModels = new ArrayList<>();
    RvInterface rvInterface;

    public RvAdapter(ArrayList<RvModel> rvModels, RvInterface rvInterface) {
        this.rvModels = rvModels;
        this.rvInterface = rvInterface;
    }

    public RvAdapter(ArrayList<RvModel> rvModels) {
        this.rvModels = rvModels;
    }

    public RvAdapter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(rvModels.get(position).id);
        holder.textView2.setText(rvModels.get(position).name);
        holder.textView3.setText(rvModels.get(position).email);
        holder.textView4.setText(rvModels.get(position).mobile);
    }

    @Override
    public int getItemCount() {
        return rvModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView, textView2, textView3, textView4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            textView4 = itemView.findViewById(R.id.textView4);

//itemView doesn't work if layout has scroll view or card view
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rvInterface.onItemClick(v, getAdapterPosition());
                }
            });
        }
    }
}
