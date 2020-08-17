package com.example.abcpupversion10androidgalaxys20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abcspacebackgrounds);

        final ImageView aLetter = new ImageView(this.getApplicationContext());
        aLetter.setImageDrawable(getDrawable(R.drawable.ic_button_for_dictionary));
        View lettersBox = (View) findViewById(R.id.lettersBox);
        ((LinearLayout) lettersBox).addView(aLetter);

        lettersBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View var1, MotionEvent var2) {
                aLetter.setX(var2.getX() - 150);
                aLetter.setY(var2.getY() - 150);
                return true;
            }
        });
    }
}