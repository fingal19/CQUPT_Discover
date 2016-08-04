package com.teamwork.discover;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mtoolbar;
    private TextView mtittle_tv;
    private ImageView miv_1;
    private ImageView miv_2;
    private ImageView miv_3;
    //LINE_CODE判断是否登录
    //已登录则返回数值 1  未登录返回数值 0   默认情况下为 0
    int LINE_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        initToolbar();

        miv_1 = (ImageView) findViewById(R.id.iv_1);
        miv_2 = (ImageView) findViewById(R.id.iv_2);
        miv_3 = (ImageView) findViewById(R.id.iv_3);

        miv_1.setOnClickListener(this);
        miv_2.setOnClickListener(this);
        miv_3.setOnClickListener(this);

    }

    private void initToolbar() {
        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        mtittle_tv = (TextView) findViewById(R.id.tittle_tv);
        //用TextView设置的一个居中假标题
        mtoolbar.setTitle("");
        mtittle_tv.setText("2016新生专题网");

        mtoolbar.setNavigationIcon(R.mipmap.ic_back);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //个人中心
        mtoolbar.inflateMenu(R.menu.menu_1);
        mtoolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.identify:
                        //进入个人中心页面 在返回此页面时
                        //会返回LINE_CODE数值 0或者1
                        Intent intent_1 = new Intent(MainActivity.this,Personal.class);
                        intent_1.putExtra("line_code",LINE_CODE + "");
                        startActivityForResult(intent_1,1);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    LINE_CODE = data.getIntExtra("LINE_CODE",0);
                    Log.e("line_code",LINE_CODE + "");
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        //分别进入 新生攻略 大数据 重邮风采 三个板块
        switch (view.getId()){
            case R.id.iv_1:

                break;
            case R.id.iv_2:

                break;
            case R.id.iv_3:

                break;
            default:
                break;
        }
    }
}
