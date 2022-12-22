package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import java.io.Serializable;

public class ComboJudgeParam extends BaseParam implements Serializable {
    private String cell;
    private String email;
    private String invoke_scene;

    public ComboJudgeParam(Context context, int i) {
        super(context, i);
    }

    public ComboJudgeParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public String getCell() {
        return this.cell;
    }

    public String getInvokeScene() {
        return this.invoke_scene;
    }

    public ComboJudgeParam setInvokeScene(String str) {
        this.invoke_scene = str;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public ComboJudgeParam setEmail(String str) {
        this.email = str;
        return this;
    }
}
