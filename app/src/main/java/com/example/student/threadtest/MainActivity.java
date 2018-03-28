package com.example.student.threadtest;

import android.graphics.drawable.VectorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        // получить ссылку на текстовое поле (findviewbyid)
        // создать экземпляр класса MyThread, передать в него
        // эту ссылку
        // запустить созданный экземпляр
    }

    class MyThread extends Thread {
        public MyThread(TextView textView) {
            super();
            tv = textView;
        }
        TextView tv;
        Runnable settext = new Runnable() {
            @Override
            public void run() {
                tv.setText("Finished");
            }
        };

        @Override
        public void run() {
            // выполняет фоновую работу, ждёт 3 секунды
            try { sleep(3000); }
            catch (InterruptedException e) { }
            runOnUiThread(settext);
        }
    }
}
