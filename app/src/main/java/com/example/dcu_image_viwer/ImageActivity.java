package com.example.dcu_image_viwer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.Gallery;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter rAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Intent intent = getIntent();
        ArrayList<String> data = (ArrayList<String>) getIntent().getSerializableExtra("data");
        Log.i("DCU_MP", data.toString());
        String pic = intent.getStringExtra("pic");

        Bitmap bmp = BitmapFactory.decodeFile(pic);

        ImageView imageView = findViewById(R.id.iv1);
        imageView.setImageBitmap(bmp);

        recyclerView = findViewById(R.id.ry1);
        recyclerView.setHasFixedSize(true);

        rAdapter = new gAdapter(data);
        recyclerView.setAdapter(rAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}