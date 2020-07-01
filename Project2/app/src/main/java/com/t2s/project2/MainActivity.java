package com.t2s.project2;

import android.content.Intent;
import android.os.Bundle;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    CountingIdlingResource idlingResource = new CountingIdlingResource("DATA LOADER");
    IdlingResource resource = new IdlingResource() {
        @Override
        public String getName() {
            return null;
        }

        @Override
        public boolean isIdleNow() {
            return false;
        }

        @Override
        public void registerIdleTransitionCallback(ResourceCallback callback) {

        }
    };

    private TextView tenSec;
    //private final CountingIdlingResource fooServerIdlingResource;

   //public MainActivity(CountingIdlingResource fooServerIdlingResource) {
       // this.fooServerIdlingResource = fooServerIdlingResource;
    //}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tenSec = (TextView) findViewById(R.id.tenSec);
        tenSec.setText("this text will change in 10 sec");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    idlingResource.increment();
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        changeText(tenSec);
                    }
                });
                idlingResource.decrement();
            }
        });


        Button button = (Button) findViewById(R.id.button_next_activity);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                openSecondActivity();
            }
        });
        thread.start();
    }
    public void changeText(TextView tenSec){
        tenSec.setText("Hello world");
    }
    public void openSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public IdlingResource IdlingResource() {
        return resource;
    }
}

