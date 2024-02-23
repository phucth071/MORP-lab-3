package vn.hcmute.lab3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import vn.hcmute.lab3.R;

public class ImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        ImageView imgView = findViewById(R.id.imageView);
        imgView.setImageResource(R.drawable.img_cat);
    }
}