package com.example.globalexperience.Fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.globalexperience.R;
import com.example.globalexperience.model.local.Event;
import com.example.globalexperience.model.local.History;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{

    private Context context;
    private List<History> historyList;

    public HistoryAdapter(Context context) {
        this.context = context;
    }

    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        History history = historyList.get(position);
        holder.name.setText(history.getName());
        if (history.getType().equals("0")){
            holder.status.setText("Student Exchange");
        }else{
            holder.status.setText("Student Excursion");
        }
        holder.host.setText(history.getOrganizer());
        if (history.getStatus().equals("0")){
            holder.status.setText("Pending");
        }else if (history.getStatus().equals("1")){
            holder.status.setText("Approved");
        }else if (history.getStatus().equals("2")){
            holder.status.setText("Rejected");
        }else if (history.getStatus().equals("3")){
            holder.status.setText("Revision");
        }else if (history.getStatus().equals("4")){
            holder.status.setText("Open");
        }else {
            holder.status.setText("Close");
        }
        holder.cardview.setOnClickListener(v -> {
            HistoryFragmentDirections.ActionHistoryFragmentToDetailFragment actionHistoryFragmentToDetailFragment = HistoryFragmentDirections.actionHistoryFragmentToDetailFragment(null, history, null);
            Navigation.findNavController(v).navigate(actionHistoryFragmentToDetailFragment);
        });
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name, type, host, status;
        CardView cardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.c_name);
            type = itemView.findViewById(R.id.c_type);
            host = itemView.findViewById(R.id.c_host);
            status = itemView.findViewById(R.id.c_status);
            cardview = itemView.findViewById(R.id.cardview);
        }
    }
}
