package com.hik.theo.kerosene;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import org.json.JSONObject;
import org.w3c.dom.Text;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.MODE_FIXED;

public class KeroseneActivity extends AppCompatActivity {

    BottomNavigationBar bottomNavigationBar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kerosene);

        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_nav_bar);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.compas_24, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.books_24, "博客"))
                .addItem(new BottomNavigationItem(R.drawable.email_24, "消息"))
                .addItem(new BottomNavigationItem(R.drawable.user_24, "我"))
                .setFirstSelectedPosition(0)
                .initialise();

//        bottomNavigationBar
//                .setMode(MODE_FIXED) // 设置mode
//                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)  // 背景样式
//                .setBarBackgroundColor("#2FA8E1") // 背景颜色
//                .setInActiveColor("#929292") // 未选中状态颜色
//                .setActiveColor("#ffffff") // 选中状态颜色
//                .addItem(BottomNavigationItem(R.drawable.message,"消息").setInactiveIconResource(R.drawable.message_no)) // 添加Item
//                .addItem(BottomNavigationItem(R.drawable.kaoqing,"考勤").setInactiveIconResource(R.drawable.kaoqing_no))
//                .addItem(BottomNavigationItem(R.drawable.job,"工作").setInactiveIconResource(R.drawable.job_no))
//                .addItem(BottomNavigationItem(R.drawable.user,"我的").setInactiveIconResource(R.drawable.user_no))
//                .setFirstSelectedPosition(0) //设置默认选中位置
//                .initialise()  // 提交初始化（完成配置）

        TextView hw = (TextView) findViewById(R.id.hw);
        RequestQueue rq = Volley.newRequestQueue(this);
        String url = "https://www.anapioficeandfire.com/api/houses/10";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                hw.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}