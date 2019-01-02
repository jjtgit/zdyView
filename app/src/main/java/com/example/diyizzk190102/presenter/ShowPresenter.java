package com.example.diyizzk190102.presenter;

import com.example.diyizzk190102.contract.IShowContract;
import com.example.diyizzk190102.entity.User;
import com.example.diyizzk190102.model.ShowModel;
import com.example.diyizzk190102.net.RequestCallback;

import java.util.HashMap;

public class ShowPresenter extends IShowContract.IShowPresenter {
    private ShowModel showModel;
    private IShowContract.IShowView iShowView;
    public ShowPresenter(IShowContract.IShowView iShowView){
        this.showModel=new ShowModel();
        this.iShowView=iShowView;
    }
    @Override
    public void show(HashMap<String, String> params) {
        if (showModel!=null){
            showModel.show(params, new RequestCallback() {
                @Override
                public void onFilaUre(String msg) {
                    if (iShowView!=null){
                        iShowView.onFilaUer(msg);
                    }
                }

                @Override
                public void onSuccess(User user) {
                    if (iShowView!=null){
                        iShowView.onSuccess(user);
                    }
                }

                @Override
                public void onSuccesssMsg(String msg) {
                    if (iShowView!=null){
                        iShowView.onSuccessMsg(msg);
                    }
                }
            });
        }
    }
}
