package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class InsuranceHistoryInfo extends BaseObject {
    private String accountCode;
    private String bankCode;
    private String bankName;
    private String certIdcardNo;
    private String certPassportNo;
    private String passengerId;
    private String phoneNumber;
    private String userName;

    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        if (jSONObject.has("account") && (optJSONObject = jSONObject.optJSONObject("account")) != null) {
            this.passengerId = optJSONObject.optString("passenger_id");
            this.userName = optJSONObject.optString("user_name");
            this.phoneNumber = optJSONObject.optString("client_phone");
            this.certIdcardNo = optJSONObject.optString("cert_idcard_no");
            this.certPassportNo = optJSONObject.optString("cert_passport_no");
            this.accountCode = optJSONObject.optString("account_code");
            this.bankCode = optJSONObject.optString("bank_code");
            this.bankName = optJSONObject.optString("bank_name");
        }
    }

    public String getPassengerId() {
        return this.passengerId;
    }

    public void setPassengerId(String str) {
        this.passengerId = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String getCertIdcardNo() {
        return this.certIdcardNo;
    }

    public void setCertIdcardNo(String str) {
        this.certIdcardNo = str;
    }

    public String getCertPassportNo() {
        return this.certPassportNo;
    }

    public void setCertPassportNo(String str) {
        this.certPassportNo = str;
    }

    public String getAccountCode() {
        return this.accountCode;
    }

    public void setAccountCode(String str) {
        this.accountCode = str;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public void setBankCode(String str) {
        this.bankCode = str;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }
}
