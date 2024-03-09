package com.matsubara.headphonealarmapp.connector;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class SoundConnector {

    private static final String TAG = "SoundConnector";

    private final Context mContext;

    MediaPlayer mBeepMediaPlayer = null;

    public SoundConnector(Context context, int beepResId) {
        mContext = context;
        buildPlayer(beepResId);
    }

    private void buildPlayer(int beepResId) {
        mBeepMediaPlayer = MediaPlayer.create(mContext, beepResId);
    }

    public void beep() {
        if (mBeepMediaPlayer == null) {
            Log.e(TAG, "mBeepMediaPlayer is null");
            return;
        }
        mBeepMediaPlayer.start();
    }
}