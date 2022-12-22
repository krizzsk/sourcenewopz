package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class InsuranceStatusInfo extends BaseObject {
    private String certTypeName;
    private String clauseLabel;
    private String clauseTitle;
    private String clauseUrl;
    private String name;
    private String number;
    private int status;
    private String tipInfo;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.certTypeName = jSONObject.optString("cert_type");
        this.tipInfo = jSONObject.optString("insure_tips_msg");
        this.status = jSONObject.optInt("insure_status");
        this.name = jSONObject.optString("user_name");
        this.number = jSONObject.optString("cert_no");
        this.clauseLabel = jSONObject.optString("insure_clause_tips");
        this.clauseTitle = jSONObject.optString("insure_clause_title");
        this.clauseUrl = jSONObject.optString("insure_clause_url");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public String getCertTypeName() {
        return this.certTypeName;
    }

    public void setCertTypeName(String str) {
        this.certTypeName = str;
    }

    public String getTipInfo() {
        return this.tipInfo;
    }

    public void setTipInfo(String str) {
        this.tipInfo = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getClauseLabel() {
        return this.clauseLabel;
    }

    public void setClauseLabel(String str) {
        this.clauseLabel = str;
    }

    public String getClauseTitle() {
        return this.clauseTitle;
    }

    public void setClauseTitle(String str) {
        this.clauseTitle = str;
    }

    public String getClauseUrl() {
        return this.clauseUrl;
    }

    public void setClauseUrl(String str) {
        this.clauseUrl = str;
    }
}
