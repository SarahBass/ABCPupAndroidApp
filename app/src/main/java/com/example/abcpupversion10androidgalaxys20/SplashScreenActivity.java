package com.example.abcpupversion10androidgalaxys20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.lang.ref.WeakReference;


public class SplashScreenActivity extends AppCompatActivity {

    //Private declarations
    private InternalHandler mHandler;
    private long mStartTime;


    //Constants
    private static final int GO_AHEAD = 1;
    private static final long MAX_TIME = 1500L;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView splashscreen = (ImageView) findViewById(R.id.splashscreenimageview);
        Glide.with(this).load(R.drawable.splashscreen).into(splashscreen);
        mStartTime = SystemClock.uptimeMillis();
        mHandler = new InternalHandler(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        final Message goAHeadMessage = mHandler.obtainMessage(GO_AHEAD);
        mHandler.sendMessageAtTime(goAHeadMessage, mStartTime + MAX_TIME);

    }

    private void endSplash() {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        finish();

    }

    private static class InternalHandler extends Handler {

        private WeakReference<SplashScreenActivity> mSAWeakRef;

        public InternalHandler(SplashScreenActivity mSARef) {
            this.mSAWeakRef = new WeakReference<SplashScreenActivity>(mSARef);
        }

        @Override
        public void handleMessage(Message msg) {
            final SplashScreenActivity mActivity = mSAWeakRef.get();
            if (mActivity == null)
                return;
            switch (msg.what) {
                case GO_AHEAD:
                    long elapsedTime = SystemClock.uptimeMillis() - mActivity.mStartTime;
                    if (elapsedTime >= MAX_TIME) {
                        mActivity.endSplash();
                    }
                    break;
            }
        }
    }
}