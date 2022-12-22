package com.didi.thirdpartylogin.base;

import android.app.Activity;
import android.content.Intent;

public abstract class AbsThirdPartyLoginBase {
    protected String clientId = null;
    protected int iconRes;
    protected ThirdPartyLoginListener listener = null;

    public abstract String getChannel();

    public abstract String getText();

    public abstract void handleLoginResult(int i, int i2, Intent intent);

    public boolean isOneKeyLogin() {
        return false;
    }

    public boolean isSupport() {
        return true;
    }

    public abstract void startLogin(Activity activity, ThirdPartyLoginListener thirdPartyLoginListener);

    public AbsThirdPartyLoginBase(String str) {
        this.clientId = str;
    }

    public int getIconResource() {
        return this.iconRes;
    }

    public void setIconResource(int i) {
        this.iconRes = i;
    }

    /* access modifiers changed from: protected */
    public void onSucess(String str, String str2) {
        log(getChannel() + "获取成功");
        ThirdPartyLoginListener thirdPartyLoginListener = this.listener;
        if (thirdPartyLoginListener != null) {
            thirdPartyLoginListener.onSucess(str, str2);
            this.listener = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onFailure(Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append(getChannel());
        sb.append("获取失败");
        sb.append(exc == null ? "" : exc.toString());
        log(sb.toString());
        ThirdPartyLoginListener thirdPartyLoginListener = this.listener;
        if (thirdPartyLoginListener != null) {
            thirdPartyLoginListener.onFailure(exc);
            this.listener = null;
        }
    }

    /* access modifiers changed from: protected */
    public void log(String str) {
        ThirdPartyLoginManager.log(str);
    }
}
