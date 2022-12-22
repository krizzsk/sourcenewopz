package com.didi.entrega.security.binder;

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
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.ParamsHelper;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.foundation.rpc.extra.CustomerRiskRpcManager;
import com.didi.entrega.foundation.rpc.extra.CustomerRiskRpcService;
import com.didi.entrega.security.model.SecurityMethodModel;
import com.didi.sdk.util.SystemUtil;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004:\u0003567B%\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J \u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010+J\b\u0010,\u001a\u00020\u001aH\u0016J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020\u001a2\b\u00101\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u00102\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u00103\u001a\u00020\u001aH\u0002J\b\u00104\u001a\u00020\u001aH\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, mo175978d2 = {"Lcom/didi/entrega/security/binder/FacebookBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/entrega/security/model/SecurityMethodModel;", "Lcom/didi/entrega/security/binder/FacebookBinder$ViewHolder;", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "activity", "Landroid/app/Activity;", "listener", "Landroid/view/View$OnClickListener;", "callback", "Lcom/didi/entrega/security/binder/FacebookBinder$Callback;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Landroid/app/Activity;Landroid/view/View$OnClickListener;Lcom/didi/entrega/security/binder/FacebookBinder$Callback;)V", "mActivityWr", "Ljava/lang/ref/WeakReference;", "mCallback", "mCallbackManager", "Lcom/facebook/CallbackManager;", "mClickListener", "mRiskRpcService", "Lcom/didi/entrega/foundation/rpc/extra/CustomerRiskRpcService;", "mViewHolder", "mWr", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "extraCanBindCondition", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCancel", "onError", "error", "Lcom/facebook/FacebookException;", "onSuccess", "loginResult", "showFailCaution", "showFailDialog", "showOtherAccountDialog", "Callback", "Companion", "ViewHolder", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FacebookBinder.kt */
public final class FacebookBinder extends ItemBinder<SecurityMethodModel, ViewHolder> implements FacebookCallback<LoginResult> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: h */
    private static final String f21054h = "FacebookBinder";

    /* renamed from: a */
    private final CallbackManager f21055a;

    /* renamed from: b */
    private final CustomerRiskRpcService f21056b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final WeakReference<ScopeContext> f21057c;

    /* renamed from: d */
    private final WeakReference<Activity> f21058d;

    /* renamed from: e */
    private final Callback f21059e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ViewHolder f21060f;

    /* renamed from: g */
    private final View.OnClickListener f21061g;

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/entrega/security/binder/FacebookBinder$Callback;", "", "disable", "", "id", "", "hasEnable", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FacebookBinder.kt */
    public interface Callback {
        void disable(int i);

        boolean hasEnable();
    }

    public Class<SecurityMethodModel> bindDataType() {
        return SecurityMethodModel.class;
    }

    public FacebookBinder(ScopeContext scopeContext, Activity activity, View.OnClickListener onClickListener, Callback callback) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f21057c = new WeakReference<>(scopeContext);
        this.f21061g = onClickListener;
        this.f21058d = new WeakReference<>(activity);
        this.f21059e = callback;
        CallbackManager create = CallbackManager.Factory.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        this.f21055a = create;
        CustomerRiskRpcManager instance = CustomerRiskRpcManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        this.f21056b = instance;
        LoginManager.getInstance().logOut();
        LoginManager.getInstance().setLoginBehavior(LoginBehavior.NATIVE_WITH_FALLBACK);
        LoginManager.getInstance().registerCallback(this.f21055a, this);
    }

    public void bind(ViewHolder viewHolder, SecurityMethodModel securityMethodModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(securityMethodModel, "item");
        viewHolder.getMTitle().setCompoundDrawablesWithIntrinsicBounds(viewHolder.itemView.getResources().getDrawable(R.drawable.entrega_customer_selector_facebook), (Drawable) null, (Drawable) null, (Drawable) null);
        viewHolder.getMTitle().setText(viewHolder.itemView.getContext().getResources().getString(R.string.customer_security_title_facebook));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FacebookBinder.m15440a(FacebookBinder.this, view);
            }
        });
        m15439a(viewHolder, securityMethodModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15440a(FacebookBinder facebookBinder, View view) {
        Intrinsics.checkNotNullParameter(facebookBinder, "this$0");
        View.OnClickListener onClickListener = facebookBinder.f21061g;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ViewHolder viewHolder = new ViewHolder(layoutInflater.inflate(R.layout.entrega_customer_binder_security_item, viewGroup, false));
        this.f21060f = viewHolder;
        Intrinsics.checkNotNull(viewHolder);
        return viewHolder;
    }

    public boolean extraCanBindCondition(SecurityMethodModel securityMethodModel) {
        Intrinsics.checkNotNullParameter(securityMethodModel, "item");
        return 41057 == securityMethodModel.getCode();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        this.f21055a.onActivityResult(i, i2, intent);
    }

    public void onCancel() {
        LogUtil.m14765i(f21054h, "验证取消");
        LoginManager.getInstance().logOut();
    }

    public void onError(FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(facebookException, "error");
        LogUtil.m14765i(f21054h, Intrinsics.stringPlus("验证失败", facebookException));
        m15441b();
    }

    public void onSuccess(LoginResult loginResult) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(ParamsHelper.getCommonParams());
        if (loginResult != null) {
            AccessToken accessToken = loginResult.getAccessToken();
            if (accessToken != null) {
                Map map = hashMap;
                String str = "";
                map.put("fb_token", Intrinsics.stringPlus(accessToken.getToken(), str));
                map.put("fb_userid", Intrinsics.stringPlus(accessToken.getUserId(), str));
                Set<String> hashSet = new HashSet<>();
                Set<String> permissions = accessToken.getPermissions();
                Intrinsics.checkNotNullExpressionValue(permissions, "token.permissions");
                hashSet.addAll(permissions);
                Set<String> declinedPermissions = accessToken.getDeclinedPermissions();
                Intrinsics.checkNotNullExpressionValue(declinedPermissions, "token.declinedPermissions");
                hashSet.removeAll(declinedPermissions);
                for (String str2 : hashSet) {
                    str = str + str2 + ',';
                }
                if (StringsKt.lastIndexOf$default((CharSequence) str, ",", 0, false, 6, (Object) null) != -1) {
                    int length = str.length() - 1;
                    if (str != null) {
                        str = str.substring(0, length);
                        Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                map.put("fb_permissions", str);
            }
            ScopeContext scopeContext = (ScopeContext) this.f21057c.get();
            if (scopeContext != null) {
                DialogUtil.showLoadingDialog(scopeContext, false);
                DialogUtil.showBlockDialog(scopeContext);
            }
            Map map2 = hashMap;
            String uid = LoginUtil.getUid();
            Intrinsics.checkNotNullExpressionValue(uid, "getUid()");
            map2.put("passenger_id", uid);
            map2.put("platform_type", 2);
            String versionName = SystemUtil.getVersionName();
            Intrinsics.checkNotNullExpressionValue(versionName, "getVersionName()");
            map2.put("appversion", versionName);
            this.f21056b.uploadFacebookToken(hashMap, new FacebookBinder$onSuccess$2(this));
        }
    }

    /* renamed from: a */
    private final void m15439a(ViewHolder viewHolder, SecurityMethodModel securityMethodModel) {
        if (securityMethodModel.isEnable()) {
            viewHolder.getMCaution().setVisibility(8);
            viewHolder.getMTitle().setTextColor(viewHolder.itemView.getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
            viewHolder.itemView.setEnabled(true);
            return;
        }
        viewHolder.itemView.setEnabled(false);
        viewHolder.getMTitle().setTextColor(viewHolder.itemView.getContext().getResources().getColor(R.color.rf_color_gery_3_60_999999));
        viewHolder.getMCaution().setVisibility(0);
        if (this.f21059e.hasEnable()) {
            viewHolder.getMCaution().setText(viewHolder.itemView.getContext().getResources().getString(R.string.customer_security_fail_caution_content_1));
        } else {
            viewHolder.getMCaution().setText(viewHolder.itemView.getContext().getResources().getString(R.string.customer_security_fail_caution_content_2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15438a() {
        ScopeContext scopeContext = (ScopeContext) this.f21057c.get();
        if (scopeContext != null) {
            DialogUtil.showFacebookFailAlreadyVerifyDialog(scopeContext.getNavigator());
        }
        LoginManager.getInstance().logOut();
        LoginManager.getInstance().setLoginBehavior(LoginBehavior.WEB_ONLY);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m15441b() {
        SecurityMethodModel securityMethodModel = new SecurityMethodModel();
        securityMethodModel.setEnable(false);
        securityMethodModel.setCode(41057);
        this.f21059e.disable(securityMethodModel.getCode());
        ScopeContext scopeContext = (ScopeContext) this.f21057c.get();
        if (scopeContext != null) {
            if (this.f21059e.hasEnable()) {
                DialogUtil.showFacebookFailSelectOtherDialog(scopeContext.getNavigator());
            } else {
                DialogUtil.showFacebookFailNotSelectDialog(scopeContext.getNavigator());
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, mo175978d2 = {"Lcom/didi/entrega/security/binder/FacebookBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/entrega/security/model/SecurityMethodModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mCaution", "Landroid/widget/TextView;", "getMCaution", "()Landroid/widget/TextView;", "mTitle", "getMTitle", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FacebookBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<SecurityMethodModel> {
        private final TextView mCaution;
        private final TextView mTitle;

        public ViewHolder(View view) {
            super(view);
            Object findViewById = findViewById(R.id.customer_tv_security_method_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<TextView1>(…tv_security_method_title)");
            this.mTitle = (TextView) findViewById;
            Object findViewById2 = findViewById(R.id.customer_tv_security_method_caution);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TextView1>(…_security_method_caution)");
            this.mCaution = (TextView) findViewById2;
        }

        public final TextView getMTitle() {
            return this.mTitle;
        }

        public final TextView getMCaution() {
            return this.mCaution;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/security/binder/FacebookBinder$Companion;", "", "()V", "TAG", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FacebookBinder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
