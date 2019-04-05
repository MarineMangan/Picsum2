package com.vogella.android.picsum;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vogella.android.picsum.Modèle.Picsum;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Picsum> values;
    private List<Picsum> Picsum;
    private Context mContext;
    private MainController controlleur;

    MyAdapter(Context mContext, List<Picsum> setList) {
        this.mContext = mContext;
        this.Picsum = setList;
        this.controlleur = MainController.getInstance((MainActivity)this.mContext);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        public View layout;
        public ImageView image;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtName = (TextView) v.findViewById(R.id.cell_txt_picsum_filename);
            image = (ImageView) v.findViewById(R.id.post_url);
            RelativeLayout parentLayout;
        }
    }

    public void add(int position, Picsum item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public MyAdapter(List<Picsum> myDataset) {
        values = myDataset;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Picsum selectedPicsum = values.get(position);
        final String name = selectedPicsum.getFilename();
        holder.txtName.setText(name);
        Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(mContext).asBitmap().load(Picsum.get(position).getPost_url()).into(holder.image);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controlleur.onItemClicked(Picsum.get(position));
            }
        });
    }


    @Override
    public int getItemCount() {
        return values.size();
    }

}