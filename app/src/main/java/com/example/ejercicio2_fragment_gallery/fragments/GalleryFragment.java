package com.example.ejercicio2_fragment_gallery.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ejercicio2_fragment_gallery.R;
import com.example.ejercicio2_fragment_gallery.adapters.GalleryAdapter;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    private RecyclerView recyclerView;
    private GalleryAdapter adapter;
    private ActionMode actionMode;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        adapter = new GalleryAdapter(GalleryFragment.this);
        recyclerView.setAdapter(adapter);

        // Register the RecyclerView for context menu
        registerForContextMenu(recyclerView);

        return root;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
            Toast.makeText(getActivity(), "Edit context", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.action_delete) {
            Toast.makeText(getActivity(), "Delete context", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.action_share) {
            Toast.makeText(getActivity(), "Share context", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }


}

