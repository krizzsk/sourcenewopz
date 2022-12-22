package com.didi.map.global.rpc.model;

import com.android.didi.bfflib.business.BffNetConstant;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class MapRpcBaseResult implements Serializable, Cloneable {
    private transient String CODE_KEY = BffNetConstant.ERR_CODE;
    private transient String MSG_KEY = "errmsg";
    private byte[] bytes;
    private int errcode;
    private String errmsg;
    private transient File file;
    private transient String jsonStr;
    private transient int successCode = 0;

    public byte[] getBytes() {
        return this.bytes;
    }

    public void setBytes(byte[] bArr) {
        this.bytes = bArr;
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file2) {
        this.file = file2;
    }

    public MapRpcBaseResult() {
    }

    public MapRpcBaseResult(String str, String str2, int i) {
        this.CODE_KEY = str;
        this.MSG_KEY = str2;
        this.successCode = i;
    }

    public int getErrcode() {
        return this.errcode;
    }

    public void setErrcode(int i) {
        this.errcode = i;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String str) {
        this.errmsg = str;
    }

    public String getJson() {
        return this.jsonStr;
    }

    public void setJson(String str) {
        this.jsonStr = str;
    }

    public void parseJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.errcode = jSONObject.optInt(this.CODE_KEY);
            this.errmsg = jSONObject.optString(this.MSG_KEY);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean isSuccess() {
        return this.errcode == this.successCode;
    }

    public int getSuccessCode() {
        return this.successCode;
    }

    public String toString() {
        return "MapRpcBaseResult{CODE_KEY='" + this.CODE_KEY + '\'' + ", MSG_KEY='" + this.MSG_KEY + '\'' + ", successCode=" + this.successCode + ", errcode=" + this.errcode + ", errmsg='" + this.errmsg + '\'' + ", bytes=" + Arrays.toString(this.bytes) + ", json='" + this.jsonStr + '\'' + ", file=" + this.file + '}';
    }
}
