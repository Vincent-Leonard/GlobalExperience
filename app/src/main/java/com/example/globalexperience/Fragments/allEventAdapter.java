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
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_adapter, parent, false);
        return new allEventAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull allEventAdapter.ViewHolder holder, int position) {
        AllEvent allEvent = allEventList.get(position);
        holder.name.setText(allEvent.getName());
        if (allEvent.getType().equals("0")){
            holder.status.setText("Student Exchange");
        }else{
            holder.status.setText("Student Excursion");
        }
        holder.host.setText(allEvent.getOrganizer());
        if (allEvent.getStatus().equals("0")){
            holder.status.setText("Pending");
        }else if (allEvent.getStatus().equals("1")){
            holder.status.setText("Approved");
        }else if (allEvent.getStatus().equals("2")){
            holder.status.setText("Rejected");
        }else if (allEvent.getStatus().equals("3")){
            holder.status.setText("Revision");
        }else if (allEvent.getStatus().equals("4")){
            holder.status.setText("Open");
        }else {
            holder.status.setText("Close");
        }
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
