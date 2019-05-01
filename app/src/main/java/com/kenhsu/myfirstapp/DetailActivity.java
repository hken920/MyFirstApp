package com.kenhsu.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView name;
    ImageView image;
    TextView desc;
    TextView dir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = findViewById(R.id.textView4);
        image = findViewById(R.id.imageView2);
        desc = findViewById(R.id.textView3);
        dir = findViewById(R.id.textView2);

        Intent intent = getIntent();

        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image", 0));
        desc.setText(intent.getStringExtra("desc"));
        dir.setText(intent.getStringExtra("dir"));
    }
}
