package com.example.auliaramadhanco.auliaramadhan_1202150072_modul3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private int level = 0;
    private ImageView gambar1 ;
    private LevelListDrawable levelListDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView Title = (TextView)findViewById(R.id.nama);
        ImageView Image = (ImageView)findViewById(R.id.gambar);
        gambar1 = (ImageView) findViewById(R.id.listdraw);

        //Get the drawable
        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra("image", 0));

        //Create a placeholder gray scrim while the image loads
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //Make it the same size as the image
        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

       //Set the text from the Intent extra
        Title.setText(getIntent().getStringExtra("nama"));

        //Load the image using the glide library and the Intent extra
        Glide.with(this).load(getIntent().getIntExtra("image",0))
                .placeholder(gradientDrawable).into(Image);


    }

    public void ChangeListLevel(View view) {
        int button = view.getId();
        switch (button){
            case R.id.tambah:
                if (level < 5){
                    ++level;
                    gambar1.setImageLevel(level);
                } else{
                    Toast.makeText(this, "Galon Sudah Penuh",Toast.LENGTH_SHORT).show();
                    --level;}
                break;
            case R.id.kurang:
                if (level > 0){
                    --level;
                    gambar1.setImageLevel(level);
                } else{
                    Toast.makeText(this, "Galon Sudah Kosong",Toast.LENGTH_SHORT).show();
                    ++level;}
                break;
        }
    }
}
