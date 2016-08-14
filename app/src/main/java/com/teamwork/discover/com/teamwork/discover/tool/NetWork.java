package com.teamwork.discover.com.teamwork.discover.tool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pcx on 2016/8/14.
 */

public class NetWork {
    public static  String getJson(String url_path, String page, String size){

        Log.e("json","获取json数据");
        String json_str = null;
        try {
            URL url = new URL(url_path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setReadTimeout(8000);
            conn.setDoOutput(true);

            StringBuffer params = new StringBuffer();
            params .append("page=").append(page)
                    .append("&")
                    .append("size=").append(size);

            byte[] bytes = params.toString().getBytes();
            conn.getOutputStream().write(bytes);
            InputStream is = conn.getInputStream();

            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while( (len = is.read(buffer)) != -1 ){
                outStream.write(buffer, 0, len);
            }

//            byte[] data = outStream.toByteArray();

            json_str = outStream.toString();

            outStream.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json_str;
    }



    public static Bitmap getBitmap(String url_path){
        Log.e("pic","图片下载");
        Bitmap bitmap = null;
        try {
            URL url = new URL(url_path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(8000);
            conn.setDoInput(true);

            if (conn.getResponseCode() == 200){
                BufferedInputStream bis = new BufferedInputStream(new BufferedInputStream(conn.getInputStream()));

                bitmap = BitmapFactory.decodeStream(bis);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
