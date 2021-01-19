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
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.name.setText(event.getName());
        holder.type.setText(event.getType());
        holder.date.setText(event.getDate());
        holder.status.setText(event.getStatus());
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
