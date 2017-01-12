package com.luyunfeng.resourcehelper;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by luyunfeng on 2017/1/10.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_0 = (TextView) findViewById(R.id.tv_0);
        TextView tv_1 = (TextView) findViewById(R.id.tv_1);
        TextView tv_2 = (TextView) findViewById(R.id.tv_2);
        TextView tv_3 = (TextView) findViewById(R.id.tv_3);
        TextView tv_4 = (TextView) findViewById(R.id.tv_4);
        final TextView tv_5 = (TextView) findViewById(R.id.tv_5);
        TextView tv_6 = (TextView) findViewById(R.id.tv_6);
        TextView tv_7 = (TextView) findViewById(R.id.tv_7);


        int dpi = ResourceHelper.getResources().getDisplayMetrics().densityDpi;
        String text = ResourceHelper.getResources().getString(R.string.dpi_, String.valueOf(dpi));
        tv_0.setText(text);


        tv_1.setTextSize(ResourceHelper.getSpPixelSize(R.dimen.large_text_size));


        // 当然可以直接用StringRes设置，tv_2.setText(R.string.app_name);
        tv_2.setText(ResourceHelper.getString(R.string.app_name));


        String[] demo = ResourceHelper.getStringArray(R.array.demo);
        tv_3.setText(TextUtils.join(" ", demo));


        tv_4.setTextColor(ResourceHelper.getColor(R.color.colorAccent));


        tv_5.setTextColor(ResourceHelper.getColorStateList(R.color.normal_color_selector));
        tv_5.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv_5.setEnabled(false);
            }
        }, 2000);


        StringBuilder builder = null;
        try {
            InputStream inputStream = ResourceHelper.getAssets().open("test.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            builder = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) {
                builder.append(str);
            }
            br.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (builder == null) builder = new StringBuilder("ic_launcher");
            tv_6.setText(builder.toString());


        int drawableId = ResourceHelper.getIdentifier(builder.toString(), "drawable");
        // int drawableId = R.drawable.ic_launcher;
        Drawable drawable = ResourceHelper.getDrawable(drawableId);
        int size = (int) ResourceHelper.getDimension(R.dimen.activity_vertical_margin);
        drawable.setBounds(0, 0, size, size);

        tv_7.setCompoundDrawablePadding(ResourceHelper.getDimensionPixelSize(R.dimen.activity_vertical_margin));
        tv_7.setCompoundDrawables(drawable, null, null, null);
    }
}
