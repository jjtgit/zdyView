package com.example.diyizzk190102.contract;

import com.example.diyizzk190102.entity.User;
import com.example.diyizzk190102.net.RequestCallback;

import java.util.HashMap;
//契约类
public interface IShowContract {
    //封装Presenter
    public abstract class IShowPresenter{
        public abstract void show(HashMap<String,String> params);
    }
    //封装Model
    interface IShowModel{
        void show(HashMap<String,String>params, RequestCallback callback);
    }
    //封装view
    interface IShowView{
        void onKeywordError(String error);
        void onPagerError(String error);
        void onFilaUer(String msg);
        void onSuccess(User user);
        void onSuccessMsg(String msg);
    }
}
