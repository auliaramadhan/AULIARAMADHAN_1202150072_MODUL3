package com.example.auliaramadhanco.auliaramadhan_1202150072_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText usernama;
    private  EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernama = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
    }

    public void Login(View view) {
        if (usernama.getText().toString().contains("ead") && pass.getText().toString().contains("mobile"))
        {startActivity(new Intent(this, AirRecyclerView.class));}
    }
}
