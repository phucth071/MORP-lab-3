package vn.hcmute.lab3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import vn.hcmute.lab3.R;

public class BackgroundLayoutActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_layout);
        ConstraintLayout bg = findViewById(R.id.constraintLayout);
        bg.setBackgroundColor(Color.BLUE);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.bg1);
        arrayList.add(R.drawable.bg2);
        arrayList.add(R.drawable.bg3);
        arrayList.add(R.drawable.bg4);
        Random random = new Random();
        int vitri = random.nextInt(arrayList.size());
        Log.d("RAND", "rand int = " + vitri);
        bg.setBackgroundResource(arrayList.get(vitri - 1));

    }
}