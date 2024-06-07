package com.example.dcu_image_viwer;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private mAdapter adapter;

    private GridView gv;

    private String selectedImg;

    //private int[] testPic = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,R.drawable.u,R.drawable.v,R.drawable.w,R.drawable.x,R.drawable.y,R.drawable.z,R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4};

    ArrayList<String> ifiles;

    String path = Environment.getExternalStorageDirectory().getPath() + "/" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.READ_EXTERNAL_STORAGE}, MODE_PRIVATE);

        ifiles = new ArrayList<>();

        File[] files= new File(path).listFiles();

        String filename, ext;

        assert files != null;
        for(File file : files){
            filename = file.getName();
            ext = filename.substring(filename.length() - 3);
            Log.i("test",filename);
            if(ext.equals("jpg")){
                ifiles.add(path + filename);
            }
        }

        Log.i("DCU_MP", ifiles.toString());

        gv = findViewById(R.id.gv1);

        adapter = new mAdapter(this,ifiles);

        gv.setAdapter(adapter);
        gv.setOnItemClickListener((parent, view, position, id) -> {
            selectedImg = ifiles.get(position);

            Log.i("DCU_MP", selectedImg);

            Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
            intent.putExtra("data", ifiles);
            intent.putExtra("pic", selectedImg);
            startActivity(intent);

        });
    }
}