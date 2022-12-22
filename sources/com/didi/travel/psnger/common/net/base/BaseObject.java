package com.didi.travel.psnger.common.net.base;

import android.text.TextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.Serializable;
import org.json.JSONObject;

public class BaseObject implements Serializable, Cloneable {
    public String errmsg;
    public int errno = -800;
    private Throwable throwable;
    public int timeoffset;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
    }

    public static boolean isAvailable(BaseObject baseObject) {
        return baseObject != null && baseObject.isAvailable();
    }

    public static BaseObject valueOf(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (BaseObject) obj;
        } catch (ClassCastException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public void setThrowable(Throwable th) {
        this.throwable = th;
    }

    public int getErrorCode() {
        return this.errno;
    }

    public void setErrorCode(int i) {
        this.errno = i;
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

    public void resetState() {
        this.errno = -800;
    }

    public String getErrorMsg() {
        return this.errmsg;
    }

    public void setErrorMsg(String str) {
        this.errmsg = str;
    }

    public void parse(String str) {
        if (TextUtils.isEmpty(str)) {
            setErrorCode(-900);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(NetConstant.ERROR_CODE)) {
                setErrorCode(jSONObject.optInt(NetConstant.ERROR_CODE));
            } else if (jSONObject.has("status")) {
                setErrorCode(jSONObject.optInt("status"));
            }
            if (jSONObject.has(NetConstant.ERROR_MSG)) {
                setErrorMsg(jSONObject.optString(NetConstant.ERROR_MSG));
            } else if (jSONObject.has(NetConstant.ERROR)) {
                setErrorMsg(jSONObject.optString(NetConstant.ERROR));
            } else if (jSONObject.has("msg")) {
                setErrorMsg(jSONObject.optString("msg"));
            }
            if (TextUtils.isEmpty(this.errmsg) || TextUtils.isDigitsOnly(this.errmsg)) {
                this.errmsg = null;
            }
            if (jSONObject.has(NetConstant.TIME_OFFSET)) {
                setTimeOffset(jSONObject.optInt(NetConstant.TIME_OFFSET));
            }
            parse(jSONObject);
        } catch (Exception unused) {
            setErrorCode(-900);
        }
    }

    public String toString() {
        return "BaseObject [errno=" + this.errno + ", errmsg=" + this.errmsg + Const.jaRight;
    }

    public BaseObject clone() {
        try {
            return (BaseObject) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BaseObject newBaseObject() {
        try {
            return (BaseObject) getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return clone();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return clone();
        }
    }
}
