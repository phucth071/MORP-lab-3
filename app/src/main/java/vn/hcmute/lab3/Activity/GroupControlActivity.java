package vn.hcmute.lab3.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import vn.hcmute.lab3.R;

public class GroupControlActivity extends AppCompatActivity {

    ConstraintLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_control);

        Button contextMenuView = (Button) findViewById(R.id.buttonContextMenu);
        switchControl();
        checkBoxControl();
        radioButtonControl();
        progressBarControl();
        seekBarControl();
        showPopupMenu();

        registerForContextMenu(contextMenuView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // you can set menu header with title icon etc
        getMenuInflater().inflate(R.menu.menu_setting,menu);
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private void showPopupMenu() {
        Button buttonMenu = findViewById(R.id.buttonMenu);
        PopupMenu popupMenu;
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(GroupControlActivity.this, buttonMenu);
                popupMenu.getMenuInflater().inflate(R.menu.menu_setting, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.menuSetting:
//lệnh
                                Toast.makeText(getApplicationContext(),"Bạn đang chọn Setting",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menuShare:
                                Toast.makeText(getApplicationContext(),"Bạn đang chọn Share",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menuLogout:
                                Toast.makeText(getApplicationContext(),"Bạn đang chọn Logout",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menuSetting) {
            Toast.makeText(getApplicationContext(), "Setting", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.menuShare) {
            Toast.makeText(getApplicationContext(), "Share", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.menuLogout) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Thông báo");
            alert.setMessage("Bạn có muốn đăng xuất không");
            alert.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Bạn chọn ĐĂNG XUẤT", Toast.LENGTH_SHORT).show();
                }
            });
            alert.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Bạn chọn KHÔNG", Toast.LENGTH_SHORT).show();
                }
            });
            alert.show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchControl() {
        Switch sw = findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(),"Wifi đang bật",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Wifi đang tắt",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkBoxControl() {
        CheckBox ck1 = (CheckBox) findViewById(R.id.checkBox);
        bg = findViewById(R.id.constraintLayout);
        ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                bg.setBackgroundResource(R.drawable.bg3);
            }else{
                bg.setBackgroundResource(R.drawable.bg4);
                }
            }
        });
    }

    private void radioButtonControl() {
        RadioGroup rd = (RadioGroup) findViewById(R.id.radioGroup1);
        bg = findViewById(R.id.constraintLayout);
        rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        bg.setBackgroundResource(R.drawable.bg3);
                        break;
                    case R.id.radioButton2:
                        bg.setBackgroundResource(R.drawable.bg4);
                        break;
                }
            }
        });
    }

    private void progressBarControl() {
        ProgressBar progressBar = findViewById(R.id.progressBar);
        ImageButton imgBtn = findViewById(R.id.imageButton);

        imgBtn.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                CountDownTimer cdTimer = new CountDownTimer(10000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = progressBar.getProgress();
                        if (current >= progressBar.getMax()) {
                            current = 0;
                        }
                        progressBar.setProgress(current + 10);
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(getApplicationContext(), "Hết giờ", Toast.LENGTH_SHORT).show();
                    }
                };
                cdTimer.start();
            }
        });
    }

    private void seekBarControl() {
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            //progress: giá trị của seekbar
                Log.d("SeekBarValue","Giá trị:" + progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("SeekBarValue","Start");
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("SeekBarValue","Stop");
            }});

    }
}