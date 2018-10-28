package com.ariskadm57.pelykat.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ariskadm57.pelykat.Model.Laundry;
import com.ariskadm57.pelykat.R;

import java.util.List;

public class LaundryAdapter extends RecyclerView.Adapter<LaundryAdapter.ViewHolder> {

    private Context context;
    private List<Laundry> list_laundry;

    public LaundryAdapter(Context context, List<Laundry> list_laundry) {
        this.context = context;
        this.list_laundry = list_laundry;
    }

    @NonNull
    @Override
    public LaundryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View row = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_laundry,viewGroup,false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Laundry list_laundry = this.list_laundry.get(position);
        viewHolder.nama.setText(list_laundry.getuNamaLaundry());
        viewHolder.rating.setRating((float) list_laundry.getuRate());
        viewHolder.alamat.setText(list_laundry.getuAlamat());
        viewHolder.jarak.setText("Jarak " + (int) list_laundry.getuJarak());
//        Glide.with(context).load(list_laundry.get().get(0)).centerCrop().into(holder.photo);
    }


    @Override
    public int getItemCount() {
        return list_laundry.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, alamat, jarak;
        ImageView foto;
        RatingBar rating;
        public ViewHolder(View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.list_laundry_nama);
            alamat  = itemView.findViewById(R.id.list_laundry_alamat);
            rating = itemView.findViewById(R.id.list_laundry_rating);
            jarak   = itemView.findViewById(R.id.list_laundry_jarak);
            foto = itemView.findViewById(R.id.list_laundry_foto);
        }
    }

    public Laundry removeItem(int position){
        final Laundry Laundry = list_laundry.remove(position);
        notifyItemRemoved(position);
        return Laundry;
    }

    public void addItem(int position, Laundry laundry){
        list_laundry.add(position, laundry);
    }

    public void moveItem(int fromPosition, int toPosition){
        final Laundry Laundry = list_laundry.remove(fromPosition);
        list_laundry.add(toPosition, Laundry);
        notifyItemMoved(fromPosition, toPosition);
    }

    public void animateTo(List<Laundry> Laundry){
        applyAndAnimateRemovals(Laundry);
        applyAndAnimateAdditions(Laundry);
        applyAndAnimateMovedItems(Laundry);
    }

    private void applyAndAnimateRemovals(List<Laundry> newModels) {
        for (int i = list_laundry.size() - 1; i >= 0; i--) {
            final Laundry model = list_laundry.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<Laundry> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final Laundry model = newModels.get(i);
            if (!list_laundry.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<Laundry> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final Laundry model = newModels.get(toPosition);
            final int fromPosition = list_laundry.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }
}
