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
import com.codingstuff.scrollview.Model.Book;
import com.codingstuff.scrollview.Model.Manga;
import com.codingstuff.scrollview.PDFActivity;
import com.codingstuff.scrollview.R;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder> {

    private List<Book> chapterList;
    public ChapterAdapter(List<Book> chapterList){
        this.chapterList = chapterList;
    }
    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapters_layout, parent , false);
        return new ChapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewHolder holder, int position) {
        holder.mText.setText(chapterList.get(position).getName());
        holder.mImageview.setImageResource(chapterList.get(position).getImage());
        holder.number.setText("#"+String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }

    public class ChapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mImageview;
        private TextView mText, number;
        public ChapterViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mImageview = itemView.findViewById(R.id.image);
            mText = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
        }

        @Override
        public void onClick(View view) {
            int position = this.getAdapterPosition();
            Book book = chapterList.get(position);
            Intent intent = new Intent(view.getContext(), PDFActivity.class);
            String name = book.getName();

            intent.putExtra("Bookname", name);
            intent.putExtra("position", String.valueOf(position));
            view.getContext().startActivity(intent);
        }
    }
}
