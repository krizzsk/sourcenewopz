package com.didi.soda.security;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.ParamsHelper;
import com.didi.soda.customer.foundation.rpc.entity.FacebookRiskEntity;
import com.didi.soda.customer.foundation.rpc.extra.CustomerRiskRpcManager;
import com.didi.soda.customer.foundation.rpc.extra.CustomerRiskRpcService;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.taxis99.R;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public class FacebookBinder extends ItemBinder<SecurityMethodModel, ViewHolder> implements FacebookCallback<LoginResult> {

    /* renamed from: a */
    private static final String f43801a = "FacebookBinder";

    /* renamed from: b */
    private CallbackManager f43802b = CallbackManager.Factory.create();

    /* renamed from: c */
    private CustomerRiskRpcService f43803c = CustomerRiskRpcManager.getInstance();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WeakReference<ScopeContext> f43804d;

    /* renamed from: e */
    private WeakReference<Activity> f43805e;

    /* renamed from: f */
    private Callback f43806f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ViewHolder f43807g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View.OnClickListener f43808h;

    public interface Callback {
        void disable(int i);

        boolean hasEnable();
    }

    public FacebookBinder(ScopeContext scopeContext, Activity activity, View.OnClickListener onClickListener, Callback callback) {
        this.f43804d = new WeakReference<>(scopeContext);
        this.f43808h = onClickListener;
        this.f43805e = new WeakReference<>(activity);
        this.f43806f = callback;
        LoginManager.getInstance().logOut();
        LoginManager.getInstance().setLoginBehavior(LoginBehavior.NATIVE_WITH_FALLBACK);
        LoginManager.getInstance().registerCallback(this.f43802b, this);
    }

    public void bind(ViewHolder viewHolder, final SecurityMethodModel securityMethodModel) {
        viewHolder.mTitle.setCompoundDrawablesWithIntrinsicBounds(viewHolder.itemView.getResources().getDrawable(R.drawable.customer_selector_facebook), (Drawable) null, (Drawable) null, (Drawable) null);
        viewHolder.mTitle.setText(viewHolder.itemView.getContext().getResources().getString(R.string.customer_security_title_facebook));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (FacebookBinder.this.f43808h != null) {
                    FacebookBinder.this.f43808h.onClick(view);
                }
                BillOmegaHelper.Companion.clickSecurityPage(securityMethodModel.cid, Integer.valueOf(securityMethodModel.code));
            }
        });
        m31113a(viewHolder, securityMethodModel);
    }

    public Class<SecurityMethodModel> bindDataType() {
        return SecurityMethodModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_security_item, viewGroup, false));
        this.f43807g = viewHolder;
        return viewHolder;
    }

    public boolean extraCanBindCondition(SecurityMethodModel securityMethodModel) {
        return 41057 == securityMethodModel.code;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.f43802b.onActivityResult(i, i2, intent);
    }

    public void onCancel() {
        LogUtil.m29104i(f43801a, "验证取消");
        LoginManager.getInstance().logOut();
    }

    public void onError(FacebookException facebookException) {
        LogUtil.m29104i(f43801a, "验证失败" + facebookException.toString());
        m31114b();
    }

    public void onSuccess(LoginResult loginResult) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(ParamsHelper.getCommonParams());
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
            DialogUtil.showLoadingDialog((ScopeContext) this.f43804d.get(), false);
            DialogUtil.showBlockDialog((ScopeContext) this.f43804d.get());
            hashMap.put("passenger_id", LoginUtil.getUid());
            hashMap.put("platform_type", 2);
            hashMap.put("appversion", SystemUtil.getVersionName());
            this.f43803c.uploadFacebookToken(hashMap, new RpcService.Callback<String>() {
                public void onFailure(IOException iOException) {
                    iOException.printStackTrace();
                    LogUtil.m29104i(FacebookBinder.f43801a, "验证失败:" + iOException.toString());
                    FacebookBinder.this.m31114b();
                    DialogUtil.hideBlockDialog();
                    DialogUtil.hideLoadingDialog();
                }

                public void onSuccess(String str) {
                    try {
                        FacebookRiskEntity facebookRiskEntity = (FacebookRiskEntity) GsonUtil.fromJson(str, FacebookRiskEntity.class);
                        LogUtil.m29104i(FacebookBinder.f43801a, facebookRiskEntity.toString());
                        if (facebookRiskEntity.errno != 0) {
                            FacebookBinder.this.m31114b();
                        } else {
                            int i = facebookRiskEntity.status;
                            if (i == 1) {
                                if (FacebookBinder.this.f43804d.get() != null) {
                                    ((ScopeContext) FacebookBinder.this.f43804d.get()).getNavigator().finish();
                                }
                                ToastUtil.showCustomerSuccessToast((ScopeContext) FacebookBinder.this.f43804d.get(), FacebookBinder.this.f43807g.itemView.getResources().getString(R.string.customer_security_success_title));
                            } else if (i == 2) {
                                FacebookBinder.this.m31114b();
                            } else if (i == 3) {
                                FacebookBinder.this.m31112a();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        FacebookBinder.this.m31114b();
                    } catch (Throwable th) {
                        DialogUtil.hideBlockDialog();
                        DialogUtil.hideLoadingDialog();
                        throw th;
                    }
                    DialogUtil.hideBlockDialog();
                    DialogUtil.hideLoadingDialog();
                }
            });
        }
    }

    /* renamed from: a */
    private void m31113a(ViewHolder viewHolder, SecurityMethodModel securityMethodModel) {
        if (securityMethodModel.isEnable) {
            viewHolder.mCaution.setVisibility(8);
            viewHolder.mTitle.setTextColor(viewHolder.itemView.getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
            viewHolder.itemView.setEnabled(true);
            return;
        }
        viewHolder.itemView.setEnabled(false);
        viewHolder.mTitle.setTextColor(viewHolder.itemView.getContext().getResources().getColor(R.color.rf_color_gery_3_60_999999));
        viewHolder.mCaution.setVisibility(0);
        if (this.f43806f.hasEnable()) {
            viewHolder.mCaution.setText(viewHolder.itemView.getContext().getResources().getString(R.string.customer_security_fail_caution_content_1));
        } else {
            viewHolder.mCaution.setText(viewHolder.itemView.getContext().getResources().getString(R.string.customer_security_fail_caution_content_2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31112a() {
        DialogUtil.showFacebookFailAlreadyVerifyDialog(((ScopeContext) this.f43804d.get()).getNavigator());
        LoginManager.getInstance().logOut();
        LoginManager.getInstance().setLoginBehavior(LoginBehavior.WEB_ONLY);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m31114b() {
        SecurityMethodModel securityMethodModel = new SecurityMethodModel();
        securityMethodModel.isEnable = false;
        securityMethodModel.code = 41057;
        this.f43806f.disable(securityMethodModel.code);
        if (this.f43806f.hasEnable()) {
            DialogUtil.showFacebookFailSelectOtherDialog(((ScopeContext) this.f43804d.get()).getNavigator());
        } else {
            DialogUtil.showFacebookFailNotSelectDialog(((ScopeContext) this.f43804d.get()).getNavigator());
        }
    }

    public static class ViewHolder extends ItemViewHolder<SecurityMethodModel> {
        /* access modifiers changed from: private */
        public TextView mCaution = ((TextView) findViewById(R.id.customer_tv_security_method_caution));
        /* access modifiers changed from: private */
        public TextView mTitle = ((TextView) findViewById(R.id.customer_tv_security_method_title));

        public ViewHolder(View view) {
            super(view);
        }
    }
}
