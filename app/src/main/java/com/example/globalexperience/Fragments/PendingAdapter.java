package com.example.globalexperience.Fragments;

import android.content.Context;
import android.graphics.Color;
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

import java.util.List;

public class PendingAdapter extends RecyclerView.Adapter<PendingAdapter.ViewHolder> {

    private Context context;
    private List<Event> eventList;

    public PendingAdapter(Context context) {
        this.context = context;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.name.setText(event.getName());
        if (event.getType().equals("0")){
            holder.type.setText("Student Exchange");
        }else{
            holder.type.setText("Student Excursion");
        }
        holder.host.setText(event.getOrganizer());
        if (event.getStatus().equals("0")){
            holder.status.setText("PENDING");
            holder.banner.setBackgroundColor(Color.MAGENTA);
        }else if (event.getStatus().equals("1")){
            holder.status.setText("APPROVED");
            holder.banner.setBackgroundColor(Color.GREEN);
        }else if (event.getStatus().equals("2")){
            holder.status.setText("REJECTED");
            holder.banner.setBackgroundColor(Color.RED);
        }else if (event.getStatus().equals("3")){
            holder.status.setText("REVISION");
            holder.banner.setBackgroundColor(Color.BLUE);
        }

        if (event.getIs_group().equals("1")){
            if (event.getPivot().getApproved().equals("0")){
                holder.status.setText("Pending");
                holder.banner.setBackgroundColor(Color.MAGENTA);
            }else if (event.getPivot().getApproved().equals("1")){
                holder.status.setText("Approved");
                holder.banner.setBackgroundColor(Color.GREEN);
            }else if (event.getPivot().getApproved().equals("2")) {
                holder.status.setText("Rejected");
                holder.banner.setBackgroundColor(Color.RED);
            }
        }
        holder.cardview.setOnClickListener(v -> {
            NavDirections action = PendingFragmentDirections.actionPendingFragmentToDetailFragment(event, null, null);
            Navigation.findNavController(v).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name, type, host, status;
        CardView cardview;
        View banner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.c_name);
            type = itemView.findViewById(R.id.c_type);
            host = itemView.findViewById(R.id.c_host);
            status = itemView.findViewById(R.id.c_status);
            cardview = itemView.findViewById(R.id.cardview);
            banner = itemView.findViewById(R.id.c_back);
        }
    }
}
