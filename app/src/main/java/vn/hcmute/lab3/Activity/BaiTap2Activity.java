package vn.hcmute.lab3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Random;

import vn.hcmute.lab3.R;

public class BaiTap2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_tap2);

        Switch switchChangeBg = (Switch) findViewById(R.id.switchChangeBg);
        ConstraintLayout bg = findViewById(R.id.constraintLayout);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.bg1);
        arrayList.add(R.drawable.bg2);
        arrayList.add(R.drawable.bg3);
        arrayList.add(R.drawable.bg4);
        Random random = new Random();

        switchChangeBg.setOnCheckedChangeListener((buttonView, isChecked) -> {
            int vitri = random.nextInt(arrayList.size());
            bg.setBackgroundResource(arrayList.get(vitri));
        });
    }
}