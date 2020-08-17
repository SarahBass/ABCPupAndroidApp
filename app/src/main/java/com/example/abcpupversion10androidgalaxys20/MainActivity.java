package com.example.abcpupversion10androidgalaxys20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    final float scale = 0.95f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abcspacebackgrounds);

        final ImageView aLetter = new ImageView(this.getApplicationContext());

        aLetter.setImageDrawable(getDrawable(R.drawable.ic_button_for_dictionary));
        View lettersBox = (View) findViewById(R.id.lettersBox);
        ((LinearLayout) lettersBox).addView(aLetter);

        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        lettersBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                aLetter.setX(event.getX() - aLetter.getWidth() / 2);
                aLetter.setY(event.getY() - aLetter.getHeight() / 2);

                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {

                    aLetter.setScaleX(scale);
                    aLetter.setScaleY(scale);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        v.vibrate(10);
                    }
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    aLetter.setScaleX(1.0f);
                    aLetter.setScaleY(1.0f);
                }

                return true;
            }
        });
    }
}