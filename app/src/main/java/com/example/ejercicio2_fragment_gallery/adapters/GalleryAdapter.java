package com.example.ejercicio2_fragment_gallery.adapters;

import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicio2_fragment_gallery.R;
import com.example.ejercicio2_fragment_gallery.fragments.GalleryFragment;
import com.example.ejercicio2_fragment_gallery.models.RecyclerItem;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private GalleryFragment galleryFragment;
    private List<RecyclerItem> mData;

    public GalleryAdapter(GalleryFragment galleryFragment) {
        this.galleryFragment = galleryFragment;
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

        holder.textView.setText(item.getTitle());
        holder.imageView.setImageResource(item.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the context menu
                v.showContextMenu();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                v.startActionMode(new ActionMode.Callback() {
                    @Override
                    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                        mode.getMenuInflater().inflate(R.menu.context_menu, menu);
                        mode.setTitle("Options");
                        return true;
                    }

                    @Override
                    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                        // Return false if nothing is done
                        return false;
                    }

                    @Override
                    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                        if (item.getItemId() == R.id.action_edit) {
                            Toast.makeText(galleryFragment.getContext(), "Edit Option", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (item.getItemId() == R.id.action_delete) {
                            Toast.makeText(galleryFragment.getContext(), "Delete Option", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (item.getItemId() == R.id.action_share) {
                            Toast.makeText(galleryFragment.getContext(), "Share Option", Toast.LENGTH_SHORT).show();
                            return true;
                        } else {
                            return false;
                        }
                    }

                    @Override
                    public void onDestroyActionMode(ActionMode mode) {
                        // Here you can make any necessary updates to the activity when
                        // the CAB is removed. By default, selected items are deselected/unchecked.
                    }
                });
                return true;
            }
        });
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