package com.example.android.musicplayer;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.musicplayer.R;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File musicFiles = new File(Environment.getExternalStorageDirectory(), "Music");

        String[] files = musicFiles.list();
        for (String file : files) {
            Log.i("Mihai", file);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.song_list, files);

        ListView listView = findViewById(R.id.songs);
        listView.setAdapter(arrayAdapter);
    }
}
