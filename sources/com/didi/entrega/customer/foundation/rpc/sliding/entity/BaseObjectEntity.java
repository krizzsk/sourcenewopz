package com.didi.entrega.customer.foundation.rpc.sliding.entity;

import android.text.TextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.json.JSONObject;

public class BaseObjectEntity implements Serializable, Cloneable {
    public static final String ERROR = "error";
    public static final String ERROR_CODE = "errno";
    public static final String ERROR_MSG = "errmsg";
    public static final String TIME_OFFSET = "timeoffset";
    private static final long serialVersionUID = -520925554317224220L;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno = -800;
    private Throwable throwable;
    @SerializedName("timeoffset")
    public int timeoffset;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
    }

    public static boolean isAvailable(BaseObjectEntity baseObjectEntity) {
        return baseObjectEntity != null && baseObjectEntity.isAvailable();
    }

    public static BaseObjectEntity valueOf(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (BaseObjectEntity) obj;
        } catch (ClassCastException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BaseObjectEntity clone() {
        try {
            return (BaseObjectEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getErrorCode() {
        return this.errno;
    }

    public void setErrorCode(int i) {
        this.errno = i;
    }

    public String getErrorMsg() {
        return this.errmsg;
    }

    public void setErrorMsg(String str) {
        this.errmsg = str;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public void setThrowable(Throwable th) {
        this.throwable = th;
    }

    public int getTimeOffset() {
        return this.timeoffset;
    }

    public void setTimeOffset(int i) {
        this.timeoffset = i;
    }

    public boolean isAvailable() {
        return this.errno == 0;
    }

    public void parse(String str) {
        if (TextUtils.isEmpty(str)) {
            setErrorCode(-900);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errno")) {
                setErrorCode(jSONObject.optInt("errno"));
            }
            if (jSONObject.has("errmsg")) {
                setErrorMsg(jSONObject.optString("errmsg"));
            } else if (jSONObject.has("error")) {
                setErrorMsg(jSONObject.optString("error"));
            }
            if (TextUtils.isEmpty(this.errmsg) || TextUtils.isDigitsOnly(this.errmsg)) {
                this.errmsg = null;
            }
            if (jSONObject.has("timeoffset")) {
                setTimeOffset(jSONObject.optInt("timeoffset"));
            }
            parse(jSONObject);
        } catch (Exception unused) {
            setErrorCode(-900);
        }
    }

    public void resetState() {
        this.errno = -800;
    }

    public String toString() {
        return "BaseObjectEntity [errno=" + this.errno + ", errmsg=" + this.errmsg + Const.jaRight;
    }
}
