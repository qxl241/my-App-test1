package com.example.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ChessBoardView chessBoardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chessBoardView = (ChessBoardView) findViewById(R.id.boardView);
    }

    public void doClick(View v) {
        Intent intent = new Intent(MainActivity.this, MusicServer.class);
        switch (v.getId()) {
            case R.id.button1:
                this.startService(intent);
                break;
            case R.id.button2:
                this.stopService(intent);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // 再来一局
        if (id == R.id.action_setting) {
            chessBoardView.start();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
