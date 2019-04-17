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

import okhttp3.OkHttpClient;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.MODE_FIXED;

public class KeroseneActivity extends AppCompatActivity {

    BottomNavigationBar bottomNavigationBar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kerosene);

        //okhttp
//        OkHttpClient okHttpClient = new OkHttpClient();
//        final Request request = new Request.Builder()
//                .url()
//                .get()
//                .build();

        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_nav_bar);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.compas_24, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.books_24, "仓库"))
                .addItem(new BottomNavigationItem(R.drawable.email_24, "消息"))
                .addItem(new BottomNavigationItem(R.drawable.user_24, "我"))
                .setFirstSelectedPosition(0)
                .initialise();

        //set tab listener
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

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