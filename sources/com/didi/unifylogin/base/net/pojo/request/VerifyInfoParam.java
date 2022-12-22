package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class VerifyInfoParam extends BaseParam implements Serializable {
    @SerializedName("mfa_version")
    public int mfaVersion;
    private long uid;

    public VerifyInfoParam(Context context, int i) {
        super(context, i);
    }

    public long getUid() {
        return this.uid;
    }

    public VerifyInfoParam setUid(long j) {
        this.uid = j;
        return this;
    }
}
