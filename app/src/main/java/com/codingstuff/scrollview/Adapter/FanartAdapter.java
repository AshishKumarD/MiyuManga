package com.codingstuff.scrollview.Adapter;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codingstuff.scrollview.R;

import java.util.List;

public class FanartAdapter extends RecyclerView.Adapter<FanartAdapter.OfferViewHOlder>{

    private List<Integer> imageList;

    public FanartAdapter(List<Integer> imageList){
        this.imageList= imageList;
    }
    @NonNull
    @Override
    public OfferViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fanart_layout, parent, false);
        return new OfferViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHOlder holder, int position) {
        holder.mImageView.setImageResource(imageList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }



    public class OfferViewHOlder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        public OfferViewHOlder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.offer_iv);
        }
    }
}
