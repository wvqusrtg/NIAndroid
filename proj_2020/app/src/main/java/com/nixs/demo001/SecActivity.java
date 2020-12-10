package com.nixs.demo001;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecActivity extends AppCompatActivity {

    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.btn_pre)
    Button btnPre;
    @BindView(R.id.et_content)
    EditText etContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        ButterKnife.bind(this);

        final Intent intent = getIntent();
        tvDesc.setText(intent.getStringExtra("message"));
    }

    @OnClick(R.id.btn_pre)
    public void onClick() {
        Intent intent = new Intent();
        intent.putExtra("result", etContent.getText().toString().trim());
        /*
          调用setResult方法表示我将Intent对象返回给之前的那个Activity，这样就可以在onActivityResult方法中得到Intent对象，
        */
        //resultCode为任意值：EG:1、1000等等这里定义2000
        int resultCode = 2000;
        setResult(resultCode, intent);
        //结束当前这个Activity对象的生命
        finish();
    }
}
