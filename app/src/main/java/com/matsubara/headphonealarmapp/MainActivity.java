package com.matsubara.headphonealarmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.matsubara.headphonealarmapp.connector.SoundConnector;
import com.matsubara.headphonealarmapp.connector.TimeConnector;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView currentTimeTextView;
    Button beepButton;
    TimeConnector mTimeConnector = null;
    SoundConnector mSoundConnector = null;

    private final Handler handler = new Handler(Looper.getMainLooper());

    private final Runnable updateCurrentTimeTask = new Runnable() {
        @Override
        public void run() {
            updateCurrentTime();
            handler.postDelayed(this, 1000); // 1秒ごとに更新
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();
        mTimeConnector = new TimeConnector();
        mSoundConnector = new SoundConnector(this, R.raw.beep_sound);

        handler.post(updateCurrentTimeTask);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void initializeView() {
        beepButton = findViewById(R.id.beep_button);
        beepButton.setOnClickListener(view -> {
            if (mSoundConnector == null) {
                Log.e(TAG, "mSoundConnector is null");
                return;
            }
            mSoundConnector.beep();
        });

        currentTimeTextView = findViewById(R.id.current_time_text);
    }

    private void updateCurrentTime() {
        currentTimeTextView.setText(mTimeConnector.getCurrentTime());
    }
}