package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.didi.unifylogin.base.net.LoginScene;

public class WanderParam extends BaseParam {
    private String ticket;

    public WanderParam(Context context) {
        super(context, LoginScene.SCENE_UNDEFINED.getSceneNum());
    }

    public WanderParam setTicket(String str) {
        this.ticket = str;
        return this;
    }
}
