package com.example.auliaramadhanco.auliaramadhan_1202150072_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by Aulia Ramadhan on 23/02/2018.
 */

public class Air {

    private String nama;
    private  int image;

    public Air(String nama, int image) {
        this.nama = nama;
        this.image = image;
    }

    public String getNama(){return nama;}
    public int getImage(){return image;}

    static Intent starter(Context context, String title, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra("nama", title);
        detailIntent.putExtra("image", imageResId);
        return detailIntent;
    }

}
