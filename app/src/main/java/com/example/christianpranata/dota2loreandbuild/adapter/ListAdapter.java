package com.example.christianpranata.dota2loreandbuild.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.christianpranata.dota2loreandbuild.R;
import com.example.christianpranata.dota2loreandbuild.model.Hero;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private ArrayList<Hero> listHero;
    private OnItemCallback onItemCallback;

    public void setOnItemCallBack(OnItemCallback onItemCallback) {
        this.onItemCallback = onItemCallback;
    }

    public ListAdapter(ArrayList<Hero> list) {
        this.listHero = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_hero, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Hero hero = listHero.get(position);

        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(100, 100))
                .into(holder.imgPhoto);

        holder.tvName.setText(hero.getName());
        holder.tvRole.setText(hero.getRole());
        holder.tvLore.setText(hero.getLore());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemCallback.onItemClicked(listHero.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRole, tvLore;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto =  itemView.findViewById(R.id.img_hero_photo);
            tvName = itemView.findViewById(R.id.tv_hero_name);
            tvRole = itemView.findViewById(R.id.tv_hero_role);
            tvLore = itemView.findViewById(R.id.tv_hero_lore);
        }
    }

    public interface OnItemCallback {
        void onItemClicked(Hero data);
    }
}
