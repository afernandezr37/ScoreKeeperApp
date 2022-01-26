package com.example.scorekeeperapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    private TextView scoreText1;
    private TextView scoreText2;

    static final String SCORE_1 = "score team 1";
    static final String SCORE_2 = "score team 2";

    private int score1;
    private int score2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreText1 = findViewById(R.id.score_1);
        scoreText2 = findViewById(R.id.score_2);

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt(SCORE_1);
            score2 = savedInstanceState.getInt(SCORE_2);

            scoreText1.setText(String.valueOf(score1));
            scoreText2.setText(String.valueOf(score2));
        }
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.decreaseTeam1:
                score1--;
                scoreText1.setText(String.valueOf(score1));
                break;
            case R.id.decreaseTeam2:
                score2--;
                scoreText2.setText(String.valueOf(score2));
        }
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.increaseTeam1:
                score1++;
                scoreText1.setText(String.valueOf(score1));
                break;
            case R.id.increaseTeam2:
                score2++;
                scoreText2.setText(String.valueOf(score2));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SCORE_1, score1);
        outState.putInt(SCORE_2, score2);
        super.onSaveInstanceState(outState);
    }
}