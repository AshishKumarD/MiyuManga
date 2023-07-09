package com.codingstuff.scrollview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;

import com.codingstuff.scrollview.Adapter.MangaAdapter;
import com.codingstuff.scrollview.Adapter.BookAdapter;
import com.codingstuff.scrollview.Adapter.FanartAdapter;
import com.codingstuff.scrollview.Model.Manga;
import com.codingstuff.scrollview.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView fanartRecyclerView, mangaRecyclerView, booKRecyclerView;
    List<Integer> fanartList = new ArrayList<>();
    private FanartAdapter fanartAdapter;
    int scrollCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        // best RecyclerView

        mangaRecyclerView = findViewById(R.id.bestSellerRecyclerview);
        mangaRecyclerView.setHasFixedSize(true);
        mangaRecyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));
        List<Manga> MangaList = new ArrayList<>();

        MangaList.add(new Manga(R.drawable.naruto , "Naruto"));
        MangaList.add(new Manga(R.drawable.chainsawman, "Chainsaw Man"));
        MangaList.add(new Manga(R.drawable.haikyu , "Haikyu"));
        MangaList.add(new Manga(R.drawable.watermelom , "Watermelon"));
        MangaList.add(new Manga(R.drawable.bluelock , "BlueLock"));
        MangaAdapter bestSellerAdapter = new MangaAdapter(MangaList);

        mangaRecyclerView.setAdapter(bestSellerAdapter);


        // clothing RecyclerView

        booKRecyclerView = findViewById(R.id.latestRecyclerview);
        booKRecyclerView.setHasFixedSize(true);
        booKRecyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));

        List<Book> BookList = new ArrayList<>();

        BookList.add(new Book(R.drawable.chainsaw, "Chainsaw Man"));
        BookList.add(new Book(R.drawable.onepiece , "One Piece"));
        BookList.add(new Book(R.drawable.fullmetal , "Full Metal"));
        BookList.add(new Book(R.drawable.berserk , "Berserk"));
        BookList.add(new Book(R.drawable.haikyuu , "Haikyuu"));
        BookList.add(new Book(R.drawable.silentvoice , "Silent Voice"));
        BookList.add(new Book(R.drawable.vinland , "Vinland Saga"));
        BookList.add(new Book(R.drawable.jojo , "Jojo"));






        BookAdapter clothingAdapter = new BookAdapter(BookList);
        booKRecyclerView.setAdapter(clothingAdapter);

        /// offer RecyclerView
        fanartRecyclerView = findViewById(R.id.fanartRecyclerView);
        fanartRecyclerView.setHasFixedSize(true);

        //LinearLayoutManager linearLayoutManager = new   LinearLayoutManager(MainActivity.this);





       // fanartList.add(R.drawable.fa1);
        fanartList.add(R.drawable.fa2);
        fanartList.add(R.drawable.fa3);
        fanartList.add(R.drawable.fa4);


   //     autoScrollAnother();



    }


     @Override
        protected void onResume() {
        super.onResume();

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this) {

            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller smoothScroller = new LinearSmoothScroller(MainActivity.this) {
                    private static final float SPEED = 200f;// Change this value (default=25f)

                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return SPEED / displayMetrics.densityDpi;
                    }
                };
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }
        };

        autoScrollAnother();
         layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

         fanartRecyclerView.setLayoutManager(layoutManager);
         fanartAdapter = new FanartAdapter(fanartList);
         fanartRecyclerView.setAdapter(fanartAdapter);


    }

    public void autoScrollAnother() {
        scrollCount = 0;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                fanartRecyclerView.smoothScrollToPosition((scrollCount++));
                if (scrollCount == fanartAdapter.getItemCount()) { scrollCount-=3;
             //   fanartList.addAll(fanartList);
                 //   fanartAdapter.notifyDataSetChanged();
                }
                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(runnable, 2000);
    }



}