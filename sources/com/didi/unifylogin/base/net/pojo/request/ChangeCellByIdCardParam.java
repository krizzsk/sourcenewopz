package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ChangeCellByIdCardParam extends BaseParam implements Serializable {
    @SerializedName("code_type")
    private int codeType;
    @SerializedName("id_card")
    private String idNum;
    @SerializedName("new_cell")
    private String newCell;
    @SerializedName("new_code")
    private String newCode;
    @SerializedName("session_id")
    private String sessionId;

    public String getNewCell() {
        return this.newCell;
    }

    public void setNewCell(String str) {
        this.newCell = str;
    }

    public String getNewCode() {
        return this.newCode;
    }

    public void setNewCode(String str) {
        this.newCode = str;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String getIdNum() {
        return this.idNum;
    }

    public void setIdNum(String str) {
        this.idNum = str;
    }

    public int getCodeType() {
        return this.codeType;
    }

    public void setCodeType(int i) {
        this.codeType = i;
    }

    public ChangeCellByIdCardParam(Context context, int i) {
        super(context, i);
    }
}
