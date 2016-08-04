package com.teamwork.discover;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Personal extends AppCompatActivity {

    private Toolbar mtoolbar;
    private TextView mtittle_tv;

    int line_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        Intent intent = getIntent();
        String s  = intent.getStringExtra("line_code");
        line_code = Integer.parseInt(s);
        initView();
    }

    private void initView() {
        initToolbar();

    }

    private void initToolbar() {
        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        mtittle_tv = (TextView) findViewById(R.id.tittle_tv);
        mtittle_tv.setText("个人中心");
        mtoolbar.setNavigationIcon(R.mipmap.ic_back);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //返回数值 0或者1
                Intent intent = new Intent();
                intent.putExtra("LINE_CODE",line_code);
                setResult(RESULT_OK,intent);

                finish();
            }
        });
    }
}
