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
import com.example.globalexperience.model.local.AllEvent;
import com.example.globalexperience.model.local.Event;

import java.util.List;

public class allEventAdapter extends RecyclerView.Adapter<allEventAdapter.ViewHolder>{

    private Context context;
    private List<AllEvent> allEventList;

    public allEventAdapter(Context context) {
        this.context = context;
    }

    public void setAllEventList(List<AllEvent> allEventList) {
        this.allEventList = allEventList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public allEventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new allEventAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull allEventAdapter.ViewHolder holder, int position) {
        AllEvent allEvent = allEventList.get(position);
        holder.name.setText(allEvent.getName());
        holder.type.setText(allEvent.getType());
        holder.date.setText(allEvent.getDate());
        holder.status.setText(allEvent.getStatus());
        holder.cardview.setOnClickListener(v -> {
            NavDirections action = allEventFragmentDirections.actionAllEventFragmentToDetailFragment(null, null, allEvent);
            Navigation.findNavController(v).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return allEventList.size();
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
