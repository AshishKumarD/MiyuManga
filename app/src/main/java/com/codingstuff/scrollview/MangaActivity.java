package com.codingstuff.scrollview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingstuff.scrollview.Adapter.ChapterAdapter;
import com.codingstuff.scrollview.Adapter.MangaAdapter;

import java.util.ArrayList;
import java.util.List;

public class MangaActivity extends AppCompatActivity {

    private RecyclerView chapterRecyclerView;
    TextView nameTV;
    ImageView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga);
        nameTV = findViewById(R.id.name);
        banner = findViewById(R.id.banner);

        Intent intent= getIntent();
        String name = intent.getStringExtra("Bookname");
        int image = intent.getIntExtra("image",0);
        nameTV.setText(name);
        banner.setImageResource(image);



        chapterRecyclerView = findViewById(R.id.chapterRecyclerview);
        chapterRecyclerView.setHasFixedSize(true);
        chapterRecyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));

        List<com.codingstuff.scrollview.Model.Book> ChapterList = new ArrayList<>();

        for(int i=0; i<20; i++) {
            ChapterList.add(new com.codingstuff.scrollview.Model.Book(image, "Chapter " + (i + 1)));
        }
        ChapterAdapter bestSellerAdapter = new ChapterAdapter(ChapterList);

        chapterRecyclerView.setAdapter(bestSellerAdapter);



    }


}