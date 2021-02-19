package ru.geekbrains.lesson6;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder> {

    private static final String TAG = "CitiesAdapter";

    private final List<City> cities = new ArrayList<>();
    private final CitiesAdapterCallback callback;

    public CitiesAdapter(CitiesAdapterCallback callback) {
        this.callback = callback;
    }

    public void setItems(List<City> items) {
        cities.clear();
        cities.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cities, parent, false);
         return new CitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesViewHolder holder, int position) {
        holder.onBind(cities.get(position), position);
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    class CitiesViewHolder extends RecyclerView.ViewHolder {

        private final MaterialTextView textView;

        public CitiesViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item_title);
        }

        public void onBind(City model, int position) {
            Log.d(TAG, String.valueOf(position));
            textView.setText(model.getTitle());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition() != RecyclerView.NO_POSITION) {
                        callback.onOnItemClicked(getAdapterPosition());
                    }
                }
            });
        }
    }
}
