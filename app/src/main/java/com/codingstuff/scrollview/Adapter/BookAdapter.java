package com.codingstuff.scrollview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codingstuff.scrollview.Model.Book;
import com.codingstuff.scrollview.PDFActivity;
import com.codingstuff.scrollview.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHOlder> {

    private List<Book> bookList;

    private Context context;

    public BookAdapter(List<Book> bookList, Context context) {
        this.bookList = bookList;
        this.context = context;
    }

    public BookAdapter(List<Book> bookList){
        this.bookList = bookList;
    }
    @NonNull
    @Override
    public BookViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_layout, parent , false);
        return new BookViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHOlder holder, int position) {
        holder.offer.setText(bookList.get(position).getName());
        holder.mImageView.setImageResource(bookList.get(position).getImage());



    }


    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class BookViewHOlder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView offer;
        private ImageView mImageView;
        public BookViewHOlder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            offer = itemView.findViewById(R.id.clothing_offer_tv);
            mImageView = itemView.findViewById(R.id.clothing_image);
        }

        @Override
        public void onClick(View view) {
            int position = this.getAdapterPosition();
            Book book = bookList.get(position);
            Intent intent = new Intent(view.getContext(), PDFActivity.class);
            String name = book.getName();

            intent.putExtra("Bookname", name);
            intent.putExtra("position", String.valueOf(position));
            view.getContext().startActivity(intent);
        }
    }
}
