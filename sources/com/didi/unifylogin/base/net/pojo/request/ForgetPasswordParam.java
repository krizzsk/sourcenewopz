package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;

public class ForgetPasswordParam extends BaseParam {
    private String cell;
    private String code;
    @SerializedName("code_type")
    private int codeType;
    private String email;
    @SerializedName("id_no")
    private String idNum;
    @SerializedName("last_name")
    private String lastName;
    private String name;
    @SerializedName("new_password")
    private String newPassword;
    @SerializedName("password_encrypt_type")
    private int passwordEncrypt;
    private String ticket;

    public ForgetPasswordParam(Context context, int i) {
        super(context, i);
    }

    public ForgetPasswordParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public ForgetPasswordParam setNewPassword(String str) {
        this.newPassword = str;
        return this;
    }

    public ForgetPasswordParam setCode(String str) {
        this.code = str;
        return this;
    }

    public ForgetPasswordParam setCodeType(int i) {
        this.codeType = i;
        return this;
    }

    public ForgetPasswordParam setEmail(String str) {
        this.email = str;
        return this;
    }

    public ForgetPasswordParam setName(String str) {
        this.name = str;
        return this;
    }

    public ForgetPasswordParam setLastName(String str) {
        this.lastName = str;
        return this;
    }

    public ForgetPasswordParam setIdNum(String str) {
        this.idNum = str;
        return this;
    }

    public String getIdNum() {
        return this.idNum;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public int getCodeType() {
        return this.codeType;
    }

    public String getCode() {
        return this.code;
    }

    public String getNewPassword() {
        return this.newPassword;
    }

    public String getCell() {
        return this.cell;
    }

    public ForgetPasswordParam setTicket(String str) {
        this.ticket = str;
        return this;
    }

    public String getTicket() {
        return this.ticket;
    }

    public ForgetPasswordParam setPasswordEncrypt(int i) {
        this.passwordEncrypt = i;
        return this;
    }
}
