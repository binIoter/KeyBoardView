package com.kamkeyboard.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.kamkeyboard.custom.KamEditText;
import com.example.kamkeyboard.custom.MyKeyBoardView;
import com.kamkeyboard.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    MyKeyBoardView keyboardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        keyboardView = (MyKeyBoardView) findViewById(R.id.keyboardView);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEditText(final KamEditText myEditText) {
        keyboardView.setEditText(myEditText);
    }

}
