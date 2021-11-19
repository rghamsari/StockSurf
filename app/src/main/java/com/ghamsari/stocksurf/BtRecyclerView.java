package com.ghamsari.stocksurf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ghamsari.stocksurf.Model.Bitcoin;

import java.util.List;

public class BtRecyclerView extends RecyclerView.Adapter<BtRecyclerView.ViewHolder> {
    private List<Bitcoin> localDataSet;
    public void CustomAdapter (List<Bitcoin> localDataSet){
        this.localDataSet = localDataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.bitcoin = localDataSet.get(position);
      holder.txHigh .setText(String.valueOf(holder.bitcoin.getHigh()));
      holder.txLow.setText(String.valueOf(holder.bitcoin.getLow()));

    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView txHigh ;
           TextView txLow ;
        Bitcoin bitcoin;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           txHigh = itemView.findViewById(R.id.High);
            txLow = itemView.findViewById(R.id.Low);
           bitcoin =new Bitcoin();

        }
    }
}
