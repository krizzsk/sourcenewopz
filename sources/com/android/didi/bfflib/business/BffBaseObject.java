package com.android.didi.bfflib.business;

import android.text.TextUtils;
import com.android.didi.bfflib.utils.BffLog;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.google.gson.annotations.SerializedName;

public class BffBaseObject implements BffGsonStruct {
    @SerializedName(alternate = {"error"}, value = "errmsg")
    public String errmsg = "";
    @SerializedName(alternate = {"errcode"}, value = "errno")
    public int errno = -800;

    public boolean isAvailable() {
        return this.errno == 0;
    }

    public String getFullErrorMsg() {
        if (TextUtils.isEmpty(this.errmsg)) {
            return "";
        }
        return this.errmsg;
    }

    public String toString() {
        return "BaseObject [errno=" + this.errno + ", errmsg=" + this.errmsg + Const.jaRight;
    }

    public BffBaseObject clone() {
        try {
            return (BffBaseObject) super.clone();
        } catch (CloneNotSupportedException e) {
            BffLog.m1483e(e.getMessage());
            return null;
        }
    }
}
