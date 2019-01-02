package com.example.diyizzk190102.model;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.diyizzk190102.api.UserApi;
import com.example.diyizzk190102.contract.IShowContract;
import com.example.diyizzk190102.entity.User;
import com.example.diyizzk190102.net.OkHttpCallbask;
import com.example.diyizzk190102.net.OkHttpUtile;
import com.example.diyizzk190102.net.RequestCallback;
import com.google.gson.Gson;

import java.util.HashMap;

public class ShowModel implements IShowContract.IShowModel {
    Handler handler=new Handler();
    @Override
    public void show(HashMap<String, String> params, final RequestCallback callback) {
        OkHttpUtile.getmInstrance().doPost(UserApi.User_SHOW, params, new OkHttpCallbask() {
            @Override
            public void failUer(String msg) {
                if (callback!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFilaUre("网络异常");
                        }
                    });
                }
            }

            @Override
            public void success(String result) {
                if (!TextUtils.isEmpty(result)){
                    requesstCall(result,callback);
                }
            }
        });
    }
    private void requesstCall(final String result, final RequestCallback callback) {
       final User user = new Gson().fromJson(result, User.class);
       handler.post(new Runnable() {
           @Override
           public void run() {
               callback.onSuccess(user);
           }
       });
    }
}
