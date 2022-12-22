package com.didi.travel.psnger.model.response;

import java.io.Serializable;

public class NextChargeDissentModel implements Serializable {
    private String mCancelTxt;
    private String mChargePageTitle;
    private String mConfirmDialogCancel;
    private String mConfirmDialogOk;
    private String mConfirmMsg;
    private String mConfirmTip;
    private String mConfirmTipPrice;
    private String mConfirmTitleTxt;
    private String mConfirmTxt;
    private String mEntranceTxt;
    private String mEntranceUrl;
    private String mFeeTotalCount = "";
    private String mFeeTotalCountTip = "";
    private String mObjectionMsg;
    private String mObjectionTitle;

    public NextChargeDissentModel(String str, String str2, String str3) {
        parse(str, str2, str3);
    }

    public String getCancelTxt() {
        return this.mCancelTxt;
    }

    public void setCancelTxt(String str) {
        this.mCancelTxt = str;
    }

    public String getChargePageTitle() {
        return this.mChargePageTitle;
    }

    public void setChargePageTitle(String str) {
        this.mChargePageTitle = str;
    }

    public String getEntranceUrl() {
        return this.mEntranceUrl;
    }

    public void setEntranceUrl(String str) {
        this.mEntranceUrl = str;
    }

    public String getConfirmDialogCancel() {
        return this.mConfirmDialogCancel;
    }

    public void setConfirmDialogCancel(String str) {
        this.mConfirmDialogCancel = str;
    }

    public String getConfirmDialogOk() {
        return this.mConfirmDialogOk;
    }

    public void setConfirmDialogOk(String str) {
        this.mConfirmDialogOk = str;
    }

    public String getConfirmMsg() {
        return this.mConfirmMsg;
    }

    public void setConfirmMsg(String str) {
        this.mConfirmMsg = str;
    }

    public String getConfirmTip() {
        return this.mConfirmTip;
    }

    public void setConfirmTip(String str) {
        this.mConfirmTip = str;
    }

    public String getConfirmTitleTxt() {
        return this.mConfirmTitleTxt;
    }

    public void setConfirmTitleTxt(String str) {
        this.mConfirmTitleTxt = str;
    }

    public String getConfirmTxt() {
        return this.mConfirmTxt;
    }

    public void setConfirmTxt(String str) {
        this.mConfirmTxt = str;
    }

    public String getObjectionMsg() {
        return this.mObjectionMsg;
    }

    public void setObjectionMsg(String str) {
        this.mObjectionMsg = str;
    }

    public String getObjectionTitle() {
        return this.mObjectionTitle;
    }

    public void setObjectionTitle(String str) {
        this.mObjectionTitle = str;
    }

    public String getConfirmTipPrice() {
        return this.mConfirmTipPrice;
    }

    public void setConfirmTipPrice(String str) {
        this.mConfirmTipPrice = str;
    }

    public String getEntranceTxt() {
        return this.mEntranceTxt;
    }

    public void setEntranceTxt(String str) {
        this.mEntranceTxt = str;
    }

    public void setTotalCountTip(String str) {
        this.mFeeTotalCountTip = str;
    }

    public String getTotalCountTip() {
        return this.mFeeTotalCountTip;
    }

    public void setTotalCount(String str) {
        this.mFeeTotalCount = str;
    }

    public String getTotalCount() {
        return this.mFeeTotalCount;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|(1:4)|9|10|(1:12)|13|14|(2:16|25)(1:24)) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        com.didi.travel.psnger.utils.LogUtil.m31426d("parse exception ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0040 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046 A[Catch:{ JSONException -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parse(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            java.lang.String r0 = "msg"
            boolean r1 = com.didi.sdk.util.TextUtil.isEmpty(r10)     // Catch:{ JSONException -> 0x001e }
            if (r1 != 0) goto L_0x0023
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x001e }
            r1.<init>(r10)     // Catch:{ JSONException -> 0x001e }
            java.lang.String r10 = r1.optString(r0)     // Catch:{ JSONException -> 0x001e }
            java.lang.String r2 = "url"
            java.lang.String r1 = r1.optString(r2)     // Catch:{ JSONException -> 0x001e }
            r9.setEntranceTxt(r10)     // Catch:{ JSONException -> 0x001e }
            r9.setEntranceUrl(r1)     // Catch:{ JSONException -> 0x001e }
            goto L_0x0023
        L_0x001e:
            java.lang.String r10 = "because feeEntrance return [] not empty"
            com.didi.travel.psnger.utils.LogUtil.m31426d(r10)     // Catch:{ Exception -> 0x00b8 }
        L_0x0023:
            boolean r10 = com.didi.sdk.util.TextUtil.isEmpty(r12)     // Catch:{ JSONException -> 0x0040 }
            if (r10 != 0) goto L_0x0040
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0040 }
            r10.<init>(r12)     // Catch:{ JSONException -> 0x0040 }
            java.lang.String r12 = "needfee_title"
            java.lang.String r12 = r10.optString(r12)     // Catch:{ JSONException -> 0x0040 }
            java.lang.String r1 = "needfee_total"
            java.lang.String r10 = r10.optString(r1)     // Catch:{ JSONException -> 0x0040 }
            r9.setTotalCountTip(r12)     // Catch:{ JSONException -> 0x0040 }
            r9.setTotalCount(r10)     // Catch:{ JSONException -> 0x0040 }
        L_0x0040:
            boolean r10 = com.didi.sdk.util.TextUtil.isEmpty(r11)     // Catch:{ JSONException -> 0x00b3 }
            if (r10 != 0) goto L_0x00b8
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b3 }
            r10.<init>(r11)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r11 = "page_title"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r12 = "objection_title"
            java.lang.String r12 = r10.optString(r12)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r1 = "objection_msg"
            java.lang.String r1 = r10.optString(r1)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r2 = "button_ok"
            java.lang.String r2 = r10.optString(r2)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r3 = "button_err"
            java.lang.String r3 = r10.optString(r3)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r4 = "confirm_msg"
            org.json.JSONObject r10 = r10.optJSONObject(r4)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r4 = "title"
            java.lang.String r4 = r10.optString(r4)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r0 = r10.optString(r0)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r5 = "tips"
            java.lang.String r5 = r10.optString(r5)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r6 = "total_fee"
            java.lang.String r6 = r10.optString(r6)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r7 = "button_confirm"
            java.lang.String r7 = r10.optString(r7)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r8 = "button_cancel"
            java.lang.String r10 = r10.optString(r8)     // Catch:{ JSONException -> 0x00b3 }
            r9.setChargePageTitle(r11)     // Catch:{ JSONException -> 0x00b3 }
            r9.setObjectionTitle(r12)     // Catch:{ JSONException -> 0x00b3 }
            r9.setObjectionMsg(r1)     // Catch:{ JSONException -> 0x00b3 }
            r9.setConfirmTxt(r2)     // Catch:{ JSONException -> 0x00b3 }
            r9.setCancelTxt(r3)     // Catch:{ JSONException -> 0x00b3 }
            r9.setConfirmTitleTxt(r4)     // Catch:{ JSONException -> 0x00b3 }
            r9.setConfirmMsg(r0)     // Catch:{ JSONException -> 0x00b3 }
            r9.setConfirmTip(r5)     // Catch:{ JSONException -> 0x00b3 }
            r9.setConfirmTipPrice(r6)     // Catch:{ JSONException -> 0x00b3 }
            r9.setConfirmDialogOk(r7)     // Catch:{ JSONException -> 0x00b3 }
            r9.setConfirmDialogCancel(r10)     // Catch:{ JSONException -> 0x00b3 }
            goto L_0x00b8
        L_0x00b3:
            java.lang.String r10 = "parse exception "
            com.didi.travel.psnger.utils.LogUtil.m31426d(r10)     // Catch:{ Exception -> 0x00b8 }
        L_0x00b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.travel.psnger.model.response.NextChargeDissentModel.parse(java.lang.String, java.lang.String, java.lang.String):void");
    }
}
