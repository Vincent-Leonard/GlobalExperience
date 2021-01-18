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
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        History history = historyList.get(position);
        holder.name.setText(history.getName());
        holder.type.setText(history.getType());
        holder.date.setText(history.getDate());
        holder.status.setText(history.getStatus());
        holder.cardview.setOnClickListener(v -> {
            NavDirections action = HistoryFragmentDirections.actionHistoryFragmentToDetailFragment(null, history);
            Navigation.findNavController(v).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name, type, date, status;
        CardView cardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.event_name_card);
            type = itemView.findViewById(R.id.event_type_card);
            date = itemView.findViewById(R.id.event_date_card);
            status = itemView.findViewById(R.id.event_status_card);
            cardview = itemView.findViewById(R.id.cardView);
        }
    }
}
