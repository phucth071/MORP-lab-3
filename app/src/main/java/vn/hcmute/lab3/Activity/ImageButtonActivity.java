package vn.hcmute.lab3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import vn.hcmute.lab3.R;

public class ImageButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_button);

        ImageButton imgBtn = findViewById(R.id.imageButton);
        ImageView imgView = findViewById(R.id.imageView);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView.setImageResource(R.drawable.img_cat_2);
                imgView.getLayoutParams().width = 550;
                imgView.getLayoutParams().height = 550;
            }
        });
    }
}