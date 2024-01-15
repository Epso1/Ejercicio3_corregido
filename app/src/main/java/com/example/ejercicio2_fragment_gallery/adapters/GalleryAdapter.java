package com.example.ejercicio2_fragment_gallery.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicio2_fragment_gallery.R;
import com.example.ejercicio2_fragment_gallery.models.RecyclerItem;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private List<RecyclerItem> mData;

    public GalleryAdapter() {
        mData = new ArrayList<>();
        mData.add(new RecyclerItem("Card 1", R.drawable.image1));
        mData.add(new RecyclerItem("Card 2", R.drawable.image2));
        mData.add(new RecyclerItem("Card 3", R.drawable.image3));
        mData.add(new RecyclerItem("Card 4", R.drawable.image4));
        mData.add(new RecyclerItem("Card 5", R.drawable.image5));
        mData.add(new RecyclerItem("Card 6", R.drawable.image6));
        mData.add(new RecyclerItem("Card 7", R.drawable.image7));
        mData.add(new RecyclerItem("Card 8", R.drawable.image8));
        mData.add(new RecyclerItem("Card 9", R.drawable.image9));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerItem item = mData.get(position);
        // Bind data to the view here
        holder.textView.setText(item.getTitle());
        holder.imageView.setImageResource(item.getImage());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.title);
        }
    }
}