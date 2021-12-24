package com.example.lesson40;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import AdapterBook.AdapterBook;
import AdapterBook.RecyclerViewClickListener;

public class SecondActivity extends AppCompatActivity implements RecyclerViewClickListener {
    private static final String TAG = "Тэг";
    TextView playersNick, playersDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        playersNick = findViewById(R.id.players_nick);
        playersDesc = findViewById(R.id.players_desc);
        String name = getIntent().getStringExtra("Название");
        String description = getIntent().getStringExtra("Описание");

        playersNick.setText(name);
        playersDesc.setText(description);
    }


    @Override
    public void onNoteClick(int position) {
        Log.d(TAG, "Click: ");

    }
}