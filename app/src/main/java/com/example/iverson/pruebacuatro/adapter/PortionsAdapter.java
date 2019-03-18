package com.example.iverson.pruebacuatro.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iverson.pruebacuatro.R;
import com.example.iverson.pruebacuatro.models.PortionFields;

import java.util.ArrayList;
import java.util.List;

public class PortionsAdapter extends RecyclerView.Adapter<PortionsAdapter.ViewHolder>{

    private List<PortionFields> portionFieldsList = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_portionfield, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PortionFields portionField = portionFieldsList.get(position);
        holder.name.setText("Portion: " + portionField.getItem_name());
        holder.calories.setText("Calories: " + String.valueOf(portionField.getNf_calories()));
        holder.fat.setText("Total Fat: " + String.valueOf(portionField.getNf_total_fat()));
    }

    @Override
    public int getItemCount() {
        return portionFieldsList.size();
    }

    public void update(List<PortionFields> portionFieldsList){
        this.portionFieldsList.clear();
        this.portionFieldsList.addAll(portionFieldsList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name, calories, fat;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.nameTv);
            calories = (TextView) itemView.findViewById(R.id.caloriesTv);
            fat = (TextView) itemView.findViewById(R.id.fatTv);
        }
    }
}
