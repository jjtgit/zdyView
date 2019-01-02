package com.example.diyizzk190102.net;

import com.example.diyizzk190102.entity.User;

public interface RequestCallback {
    void onFilaUre(String msg);
    void onSuccess(User user);
    void onSuccesssMsg(String msg);
}
