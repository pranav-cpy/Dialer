package com.team.pranav.dialer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,call;
    TextView name,provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        b0=(Button)findViewById(R.id.no0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
