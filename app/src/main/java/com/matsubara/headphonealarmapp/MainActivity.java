package com.matsubara.headphonealarmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.matsubara.headphonealarmapp.connector.SoundConnector;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button beepButton = null;
    SoundConnector mSoundConnector = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeButton();
        mSoundConnector = new SoundConnector(this, R.raw.beep_sound);
    }

    public void initializeButton() {
        beepButton = findViewById(R.id.beep_button);
        beepButton.setOnClickListener(view -> {
            if (mSoundConnector == null) {
                Log.e(TAG, "mSoundConnector is null");
                return;
            }
            mSoundConnector.beep();
        });
    }
}