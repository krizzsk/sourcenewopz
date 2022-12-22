package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class DeleteUserParam extends BaseParam implements Serializable {
    private String cell;
    private String code;
    @SerializedName("code_type")
    private int codeType;
    @SerializedName("delete_account_reasons")
    private List<String> deleteAccountReasons;
    private String ticket;

    public DeleteUserParam(Context context, int i) {
        super(context, i);
    }

    public DeleteUserParam setTicket(String str) {
        this.ticket = str;
        return this;
    }

    public DeleteUserParam setCode(String str) {
        this.code = str;
        return this;
    }

    public DeleteUserParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public DeleteUserParam setCodeType(int i) {
        this.codeType = i;
        return this;
    }

    public List<String> getDeleteAccountReasons() {
        return this.deleteAccountReasons;
    }

    public DeleteUserParam setDeleteAccountReasons(List<String> list) {
        this.deleteAccountReasons = list;
        return this;
    }
}
