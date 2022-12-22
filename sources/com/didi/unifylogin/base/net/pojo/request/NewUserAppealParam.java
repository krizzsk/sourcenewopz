package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class NewUserAppealParam extends BaseParam implements Serializable {
    private String cell;
    public long uid;
    @SerializedName("verify_session_id")
    private String verifySessionId;

    public NewUserAppealParam(Context context, int i) {
        super(context, i);
    }

    public long getUid() {
        return this.uid;
    }

    public NewUserAppealParam setUid(long j) {
        this.uid = j;
        return this;
    }

    public String getCell() {
        return this.cell;
    }

    public NewUserAppealParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public String getSessionId() {
        return this.verifySessionId;
    }

    public NewUserAppealParam setSessionId(String str) {
        this.verifySessionId = str;
        return this;
    }
}
