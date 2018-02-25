package com.example.auliaramadhanco.auliaramadhan_1202150072_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Aulia Ramadhan on 23/02/2018.
 */

public class AirAdapter extends RecyclerView.Adapter<AirAdapter.AirViewHolder> {

    private GradientDrawable mGradientDrawable;
    private ArrayList<Air> mAirData;
    private Context mContext;

    public AirAdapter(Context mContext, ArrayList<Air> mAirData) {
        this.mAirData = mAirData;
        this.mContext = mContext;
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);
        Drawable draw = ContextCompat.getDrawable
                (mContext, R.drawable.ades);
        mGradientDrawable.setSize(draw.getIntrinsicWidth(),
                draw.getIntrinsicHeight());
    }

    @Override
    public AirViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AirViewHolder(mContext, LayoutInflater.from(mContext).
            inflate(R.layout.menulist_air, parent, false),mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(AirViewHolder holder, int position) {
        Air current = mAirData.get(position);
        holder.bindTo(current);
    }

    @Override
    public int getItemCount() {
        return mAirData.size();
    }

    public class AirViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener{

        private TextView mTitleText;
        private ImageView mImage;
        private Context mContext;
        private Air mCurrent;
        private GradientDrawable mGradientDrawable;



        public  AirViewHolder(Context context, View itemView, GradientDrawable gradientDrawable){
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mImage = (ImageView)itemView.findViewById(R.id.airImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;
            //Set the OnClickListener to the whole view
            itemView.setOnClickListener((View.OnClickListener) this);
        }
        void bindTo(Air current){

            //Populate the textviews with data
            mTitleText.setText(current.getNama());
            //Get the current sport
            mCurrent = current;
            //Load the images into the ImageView using the Glide library

            Glide.with(mContext).load(current.
                    getImage()).placeholder(mGradientDrawable).into(mImage);
        }

        @Override
        public void onClick(View view) {
            //Set up the detail intent
            Intent detailIntent = Air.starter(mContext, mCurrent.getNama(),
                    mCurrent.getImage());

            //Start the detail activity
            mContext.startActivity(detailIntent);
        }
    }
}
