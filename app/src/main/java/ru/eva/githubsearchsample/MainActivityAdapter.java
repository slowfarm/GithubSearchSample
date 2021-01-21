package ru.eva.githubsearchsample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {

    private List<Item> items = new ArrayList<>();

    public void addItems(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Owner owner = items.get(position).getOwner();
        Picasso.get().load(owner.getAvatarUrl()).into(holder.photoImageView);
        holder.nameTextView.setText(owner.getLogin());
        holder.linkTextView.setText(owner.getHtmlUrl());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView photoImageView;
        private final TextView nameTextView, linkTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photoImageView = itemView.findViewById(R.id.photoImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            linkTextView = itemView.findViewById(R.id.linkTextView);
        }
    }
}
