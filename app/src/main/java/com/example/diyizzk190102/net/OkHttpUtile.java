package com.example.diyizzk190102.net;

import android.os.Handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtile {
    private Handler handler=new Handler();
    private OkHttpClient okHttpClient;
    private static OkHttpUtile mInstrance;
    public OkHttpUtile(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();
    }
    public static OkHttpUtile getmInstrance(){
        if (mInstrance==null){
            synchronized (OkHttpUtile.class){
                if (mInstrance==null){
                    mInstrance=new OkHttpUtile();
                }
            }
        }
        return mInstrance;
    }
    public void doPost(String url, HashMap<String,String>params,final OkHttpCallbask okHttpCallbask){
        final FormBody.Builder formBody = new FormBody.Builder();
        for (Map.Entry<String,String>p:params.entrySet()){
            formBody.add(p.getKey(),p.getValue());
        }
        final Request request = new Request.Builder().url(url).post(formBody.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (okHttpCallbask!=null){
                    okHttpCallbask.failUer("网络异常");
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                int code = response.code();
                if (okHttpCallbask!=null){
                    if (200==code){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                okHttpCallbask.success(result);
                            }
                        });
                    }
                }
            }
        });
    }
}
