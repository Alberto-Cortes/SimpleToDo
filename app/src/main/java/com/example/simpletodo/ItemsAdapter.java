package com.example.simpletodo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Class responsible to feed model to recycler view for each row
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    public interface OnLongClickListener {
        void onItemLongClicked(int position);
    }
    List<String> items;
    OnLongClickListener longClickListener;

    // Constructor for the class, receives list of strings from main and sets it as attribute
    public ItemsAdapter(List<String> items, OnLongClickListener longClickListener) {
        this.items = items;
        this.longClickListener = longClickListener;
    }

    // Methods generated automatically for proper class functionality
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Use a default configuration to inflate a view from the parent context, populate it, with the recycler.
        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(todoView);
    }

    @Override
    // Binds that to a specific view
    public void onBindViewHolder(@NonNull ItemsAdapter.ViewHolder holder, int position) {
        String item = items.get(position);
        holder.bind(item);
    }

    @Override
    // gets size of list
    public int getItemCount() {
        return items.size();
    }

    // Class responsible to provide access to the views of each row
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(android.R.id.text1);
        }

        // Update view of viewholder with data
        public void bind(String item) {
            // Add item to viewholder
            tvItem.setText(item);
            // Remove item from viewholder
            tvItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    longClickListener.onItemLongClicked(getAdapterPosition());
                    return true;
                }
            });
        }
    }


}
