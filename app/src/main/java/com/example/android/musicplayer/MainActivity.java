package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.musicplayer.R;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final File musicFiles = new File(Environment.getExternalStorageDirectory(), "Music");
        // TODO: 10.04.2018 Handle null list
        final String[] files = musicFiles.list();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.song_list, files);

        ListView listView = findViewById(R.id.songs);
        listView.setAdapter(arrayAdapter);

        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // Do something in response to the click
                playSong(musicFiles.getPath() + File.separator + files[position]);
            }
        };
        listView.setOnItemClickListener(mMessageClickedHandler);
    }

    public void playSong(String path) {

        if (mediaPlayer.isPlaying()){
            mediaPlayer.reset();
        }
        try {
            mediaPlayer.setDataSource(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }
}
