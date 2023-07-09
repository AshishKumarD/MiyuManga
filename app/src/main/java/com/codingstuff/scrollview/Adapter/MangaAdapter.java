package com.codingstuff.scrollview.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codingstuff.scrollview.MangaActivity;
import com.codingstuff.scrollview.Model.Manga;
import com.codingstuff.scrollview.R;

import java.util.List;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.ChapterViewHolder> {

    private List<Manga> bestSellerList;
    public MangaAdapter(List<Manga> bestSellerList){
        this.bestSellerList = bestSellerList;
    }
    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.manga_layout, parent , false);
        return new ChapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewHolder holder, int position) {
        holder.mText.setText(bestSellerList.get(position).getName());
        holder.mImageview.setImageResource(bestSellerList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return bestSellerList.size();
    }

    public class ChapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mImageview;
        private TextView mText;
        public ChapterViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mImageview = itemView.findViewById(R.id.bestSellerImage);
            mText = itemView.findViewById(R.id.bestSellerText);
        }

        @Override
        public void onClick(View view) {
            int position = this.getAdapterPosition();
            Manga manga = bestSellerList.get(position);
            Intent intent = new Intent(view.getContext(), MangaActivity.class);
            String name = manga.getName();

            intent.putExtra("Bookname", name);
            intent.putExtra("image", manga.getImage());
            view.getContext().startActivity(intent);
        }
    }
}
