package com.didi.component.service.activity.risk.items;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.service.activity.risk.AbsRiskItem;
import com.didi.component.service.activity.risk.RiskListAdapter;
import com.didi.component.service.activity.risk.RiskUploadResponse;
import com.didi.component.service.activity.risk.RiskViewHolder;
import com.didi.component.service.activity.risk.dialog.NormalDialogInfo;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.view.dialog.AlertController;
import com.didichuxing.foundation.rpc.RpcService;
import com.facebook.AccessToken;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FacebookItem extends AbsRiskItem implements FacebookCallback<LoginResult> {

    /* renamed from: a */
    private CallbackManager f15723a = CallbackManager.Factory.create();

    /* renamed from: b */
    private boolean f15724b = true;

    /* access modifiers changed from: protected */
    public int getItemIconRes() {
        return R.drawable.fb_icon_selector;
    }

    /* access modifiers changed from: protected */
    public int getItemTitleRes() {
        return R.string.risk_facebook_label;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    public FacebookItem(String str, RiskListAdapter riskListAdapter, Activity activity) {
        super(str, riskListAdapter, activity);
        try {
            LoginManager.getInstance().logOut();
        } catch (Exception e) {
            if (m11472a(e) && this.mActivity != null) {
                this.mActivity.finish();
                return;
            }
        }
        LoginManager.getInstance().setLoginBehavior(LoginBehavior.NATIVE_WITH_FALLBACK);
        LoginManager.getInstance().registerCallback(this.f15723a, this);
    }

    /* renamed from: a */
    private boolean m11472a(Exception exc) {
        if (exc != null) {
            boolean isEmpty = TextUtils.isEmpty(exc.getMessage());
            Throwable th = exc;
            if (!isEmpty) {
                while (th.getCause() != null) {
                    th = th.getCause();
                }
                String message = th.getMessage();
                if (TextUtils.isEmpty(message) || (!message.contains("MissingWebViewPackageException") && !message.contains("No WebView installed"))) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onClick(RiskListAdapter riskListAdapter, View view, RiskViewHolder riskViewHolder, int i) {
        List asList = Arrays.asList(new String[]{"email", "public_profile", AuthenticationTokenClaims.JSON_KEY_USER_FRIENDS});
        if (GlobalApolloUtil.isRequestFacebookUserPostsPermission()) {
            asList.add("user_posts");
        }
        LoginManager.getInstance().logInWithReadPermissions(this.mActivity, (Collection<String>) asList);
        trackClickEvent(3);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f15723a.onActivityResult(i, i2, intent);
    }

    public void onSuccess(LoginResult loginResult) {
        SystemUtils.log(4, "Facebook", "onSuccess", (Throwable) null, "com.didi.component.service.activity.risk.items.FacebookItem", 118);
        HashMap hashMap = new HashMap();
        if (loginResult != null) {
            AccessToken accessToken = loginResult.getAccessToken();
            if (accessToken != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(accessToken.getToken());
                String str = "";
                sb.append(str);
                hashMap.put("fb_token", sb.toString());
                hashMap.put("fb_userid", accessToken.getUserId() + str);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.addAll(accessToken.getPermissions());
                hashSet.removeAll(accessToken.getDeclinedPermissions());
                for (String str2 : hashSet) {
                    str = str + str2 + ",";
                }
                if (str.lastIndexOf(",") != -1) {
                    str = str.substring(0, str.length() - 1);
                }
                hashMap.put("fb_permissions", str);
            }
            final IDialog showLoading = showLoading(this.mActivity.getString(R.string.loading_txt));
            Bff.call(new IBffProxy.Ability.Builder(this.mActivity, BffConstants.AbilityID.ABILITY_FACEBOOK_RISK).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    String str;
                    if (jsonObject != null) {
                        try {
                            str = jsonObject.toString();
                        } catch (Exception e) {
                            e.printStackTrace();
                            FacebookItem.this.m11473b();
                        }
                    } else {
                        str = "";
                    }
                    SystemUtils.log(4, "RiskSuccess", str, (Throwable) null, "com.didi.component.service.activity.risk.items.FacebookItem$1", 151);
                    RiskUploadResponse riskUploadResponse = (RiskUploadResponse) new Gson().fromJson((JsonElement) jsonObject, RiskUploadResponse.class);
                    if (riskUploadResponse == null || riskUploadResponse.errno == 0 || riskUploadResponse.data == null) {
                        int i = riskUploadResponse.data.verify;
                        if (i == 1) {
                            Intent intent = new Intent();
                            intent.putExtra("type", FacebookItem.this.mTypeName);
                            FacebookItem.this.finishActivity(intent);
                            ToastHelper.showLongCompleted((Context) FacebookItem.this.mActivity, FacebookItem.this.mActivity.getString(R.string.risk_page_success_toast));
                            FacebookItem.this.trackVerifyEvent();
                        } else if (i == 2) {
                            FacebookItem.this.m11473b();
                        } else if (i == 3) {
                            FacebookItem.this.m11469a();
                        }
                        FacebookItem.this.dismissLoading(showLoading);
                    }
                    FacebookItem.this.m11473b();
                    FacebookItem.this.dismissLoading(showLoading);
                }

                public void onFailure(IOException iOException) {
                    iOException.printStackTrace();
                    ToastHelper.showLongInfo((Context) FacebookItem.this.mActivity, FacebookItem.this.mActivity.getString(R.string.risk_page_no_internet_toast));
                    FacebookItem.this.dismissLoading(showLoading);
                }
            }).build());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11469a() {
        NormalDialogInfo normalDialogInfo = new NormalDialogInfo(1001);
        normalDialogInfo.setIcon(AlertController.IconType.INFO).setCloseVisible(false).setCancelable(false).setMessage((CharSequence) this.mActivity.getString(R.string.risk_page_dialog_msg_alert_other_account_msg)).setTitle((CharSequence) this.mActivity.getString(R.string.risk_page_dialog_msg_alert_other_account_title)).setPositiveText((CharSequence) this.mActivity.getString(R.string.risk_page_dialog_msg_alert_continue));
        showDialog(normalDialogInfo, (IDialog.DialogListener) null);
        LoginManager.getInstance().logOut();
        LoginManager.getInstance().setLoginBehavior(LoginBehavior.WEB_ONLY);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11473b() {
        this.f15724b = false;
        NormalDialogInfo normalDialogInfo = new NormalDialogInfo(1001);
        normalDialogInfo.setIcon(AlertController.IconType.INFO).setCloseVisible(false).setCancelable(false).setTitle((CharSequence) this.mActivity.getString(R.string.risk_page_dialog_msg_alert_fail_title)).setPositiveText((CharSequence) this.mActivity.getString(R.string.risk_page_dialog_msg_alert_continue));
        if (hasEnableItem()) {
            normalDialogInfo.setMessage((CharSequence) this.mActivity.getString(R.string.risk_page_dialog_msg_alert_fail_msg));
        } else {
            normalDialogInfo.setMessage((CharSequence) this.mActivity.getString(R.string.risk_page_dialog_msg_alert_fail_no_choose_msg));
        }
        showDialog(normalDialogInfo, (IDialog.DialogListener) null);
        notifyChanged();
    }

    public void onCancel() {
        SystemUtils.log(4, "Facebook", "onCancel", (Throwable) null, "com.didi.component.service.activity.risk.items.FacebookItem", 231);
        LoginManager.getInstance().logOut();
    }

    public void onError(FacebookException facebookException) {
        SystemUtils.log(4, "Facebook", "onError:" + facebookException.getMessage(), (Throwable) null, "com.didi.component.service.activity.risk.items.FacebookItem", 237);
        ToastHelper.showLongInfo((Context) this.mActivity, this.mActivity.getString(R.string.risk_page_no_internet_toast));
    }

    /* access modifiers changed from: protected */
    public boolean isItemEnable() {
        return this.f15724b;
    }
}
