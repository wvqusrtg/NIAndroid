package com.nixs.demo001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_01)
    Button btn01;
    @BindView(R.id.btn_02)
    Button btn02;
    @BindView(R.id.tv_desc)
    TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_01, R.id.btn_02})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_01: {
                Intent intentNext = new Intent(MainActivity.this,SecActivity.class);
                intentNext.putExtra("message","加菲猫-MainActivity");
                int requestCode = 1000;
                startActivityForResult(intentNext,requestCode);
                //requestCode为任意值：EG:1、1000等等，这里定义1000
                break;
            }
            case R.id.btn_02: {

                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1000 && resultCode==2000){
            tvDesc.setText(data.getStringExtra("result"));
        }
    }
}
