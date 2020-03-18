package com.example.mymediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button playButton,pauseButton,stopButton;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = (Button) findViewById(R.id.playButtonId);
        pauseButton = (Button) findViewById(R.id.pauseButtonId);
        stopButton =(Button) findViewById(R.id.stopButtonId);


         mediaPlayer = MediaPlayer.create(this,R.raw.music);

        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);


    }
@Override
    public void onClick(View v) {

    if (v.getId() == R.id.playButtonId) {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            //int duration = mediaPlayer.getDuration() / 1000;
            Toast.makeText(MainActivity.this, "Song Played" , Toast.LENGTH_SHORT).show();
        }
    }
    if (v.getId() == R.id.pauseButtonId) {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            Toast.makeText(MainActivity.this, "Song Paused", Toast.LENGTH_SHORT).show();
        }
    }
    if (v.getId() == R.id.stopButtonId) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            Toast.makeText(MainActivity.this, "Song Stopped", Toast.LENGTH_SHORT).show();
        }
    }

}
    @Override
    protected void onDestroy() {
     if(mediaPlayer!=null && mediaPlayer.isPlaying()){
         mediaPlayer.stop();
         mediaPlayer.release();
         mediaPlayer=null;
     }

        super.onDestroy();
    }
}

