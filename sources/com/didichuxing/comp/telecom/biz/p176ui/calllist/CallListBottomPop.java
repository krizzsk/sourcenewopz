package com.didichuxing.comp.telecom.biz.p176ui.calllist;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didichuxing.comp.telecom.biz.p176ui.view.LoadingView;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipBusinessActivity;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.request.VoipCallRequest;
import com.didichuxing.comp.telecom.core.request.model.CallListModel;
import com.didichuxing.comp.telecom.core.request.model.CallListResponse;
import com.didichuxing.comp.telecom.core.request.model.CallMethodItem;
import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00012B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u001c\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0016J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0011H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\u0006\u0010'\u001a\u00020\u0019J\u0012\u0010(\u001a\u00020\u00192\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*J\u0015\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b.J\u0018\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u0002012\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\r\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0018\u00010\u0015R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000¨\u00063"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/calllist/CallListBottomPop;", "Landroid/widget/PopupWindow;", "mActivity", "Landroid/app/Activity;", "mRequestParams", "", "", "", "mPhoneCallback", "Lcom/didichuxing/comp/telecom/biz/ui/calllist/PhoneClickCallback;", "mVoipCallback", "Lcom/didichuxing/comp/telecom/biz/ui/calllist/VoipClickCallback;", "(Landroid/app/Activity;Ljava/util/Map;Lcom/didichuxing/comp/telecom/biz/ui/calllist/PhoneClickCallback;Lcom/didichuxing/comp/telecom/biz/ui/calllist/VoipClickCallback;)V", "TAG", "mCallListView", "Landroid/widget/LinearLayout;", "mCloseView", "Landroid/view/View;", "mLoadingView", "Lcom/didichuxing/comp/telecom/biz/ui/view/LoadingView;", "mRequestCallback", "Lcom/didichuxing/comp/telecom/biz/ui/calllist/CallListBottomPop$CallListRequestCallback;", "mRootView", "Landroid/view/ViewGroup;", "bindListItems", "", "model", "Lcom/didichuxing/comp/telecom/core/request/model/CallListModel;", "buildPhoneCallItem", "itemModel", "Lcom/didichuxing/comp/telecom/core/request/model/CallMethodItem;", "buildVoipCallItem", "voipData", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "dismiss", "initViews", "view", "innerDismiss", "requestCallList", "show", "showForTest", "testModel", "Lcom/didichuxing/comp/telecom/core/request/model/CallListResponse;", "showLoading", "toLoading", "", "showLoading$voip_biz_release", "userClickToMakeCall", "context", "Landroid/content/Context;", "CallListRequestCallback", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.calllist.CallListBottomPop */
/* compiled from: CallListBottomPop.kt */
public final class CallListBottomPop extends PopupWindow {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f46285a = "CallListBottomPop";

    /* renamed from: b */
    private ViewGroup f46286b;

    /* renamed from: c */
    private View f46287c;

    /* renamed from: d */
    private LoadingView f46288d;

    /* renamed from: e */
    private LinearLayout f46289e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CallListRequestCallback f46290f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Activity f46291g;

    /* renamed from: h */
    private final Map<String, Object> f46292h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final PhoneClickCallback f46293i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final VoipClickCallback f46294j;

    public CallListBottomPop(Activity activity, Map<String, ? extends Object> map, PhoneClickCallback phoneClickCallback, VoipClickCallback voipClickCallback) {
        Intrinsics.checkParameterIsNotNull(activity, "mActivity");
        this.f46291g = activity;
        this.f46292h = map;
        this.f46293i = phoneClickCallback;
        this.f46294j = voipClickCallback;
        View inflate = activity.getLayoutInflater().inflate(R.layout.voip_biz_dialog_callist, (ViewGroup) null);
        if (inflate != null) {
            ViewGroup viewGroup = (ViewGroup) inflate;
            this.f46286b = viewGroup;
            m33240a((View) viewGroup);
            setWidth(-1);
            setHeight(-1);
            setContentView(this.f46286b);
            setFocusable(true);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void show() {
        if (!this.f46291g.isDestroyed() && !this.f46291g.isFinishing()) {
            Window window = this.f46291g.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "mActivity.window");
            showAtLocation(window.getDecorView(), 0, 0, 0);
            m33242b();
        }
    }

    public static /* synthetic */ void showForTest$default(CallListBottomPop callListBottomPop, CallListResponse callListResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            callListResponse = null;
        }
        callListBottomPop.showForTest(callListResponse);
    }

    public final void showForTest(CallListResponse callListResponse) {
        if (!this.f46291g.isDestroyed() && !this.f46291g.isFinishing()) {
            Window window = this.f46291g.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "mActivity.window");
            showAtLocation(window.getDecorView(), 0, 0, 0);
            showLoading$voip_biz_release(false);
            m33241a(callListResponse != null ? callListResponse.getData() : null);
        }
    }

    public void dismiss() {
        super.dismiss();
        m33238a();
    }

    /* renamed from: a */
    private final void m33238a() {
        super.dismiss();
        CallListRequestCallback callListRequestCallback = this.f46290f;
        if (callListRequestCallback != null) {
            callListRequestCallback.cancel();
        }
        this.f46290f = null;
        ViewGroup viewGroup = this.f46286b;
        if (viewGroup != null) {
            viewGroup.removeCallbacks((Runnable) null);
        }
    }

    /* renamed from: a */
    private final void m33240a(View view) {
        View findViewById = view.findViewById(R.id.callListContainer);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "callListContainer");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadii(new float[]{24.0f, 24.0f, 24.0f, 24.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        findViewById.setBackground(gradientDrawable);
        TextView textView = (TextView) view.findViewById(R.id.callListTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "this");
        textView.setText(textView.getContext().getString(R.string.GDriver_IBT_c_WOOe));
        View findViewById2 = view.findViewById(R.id.callListClose);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById<View>(R.id.callListClose)");
        this.f46287c = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseView");
        }
        findViewById2.setOnClickListener(new CallListBottomPop$initViews$3(this));
        View findViewById3 = view.findViewById(R.id.callListLoading);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById<Loadin…ew>(R.id.callListLoading)");
        this.f46288d = (LoadingView) findViewById3;
        View findViewById4 = view.findViewById(R.id.callListItems);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "view.findViewById<Linear…yout>(R.id.callListItems)");
        this.f46289e = (LinearLayout) findViewById4;
    }

    public final void showLoading$voip_biz_release(boolean z) {
        LinearLayout linearLayout = this.f46289e;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCallListView");
        }
        int i = 8;
        linearLayout.setVisibility(z ? 8 : 0);
        LoadingView loadingView = this.f46288d;
        if (loadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        }
        if (z) {
            i = 0;
        }
        loadingView.setVisibility(i);
        if (z) {
            LoadingView loadingView2 = this.f46288d;
            if (loadingView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
            }
            loadingView2.startLoading();
            return;
        }
        LoadingView loadingView3 = this.f46288d;
        if (loadingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        }
        loadingView3.stopLoading();
    }

    /* renamed from: b */
    private final void m33242b() {
        if (CallManagerAssist.isRelease()) {
            Runnable callListBottomPop$requestCallList$cancelDelay$1 = new CallListBottomPop$requestCallList$cancelDelay$1(this);
            ViewGroup viewGroup = this.f46286b;
            if (viewGroup != null) {
                viewGroup.postDelayed(callListBottomPop$requestCallList$cancelDelay$1, 5000);
            }
        }
        CallListRequestCallback callListRequestCallback = new CallListRequestCallback(this);
        this.f46290f = callListRequestCallback;
        showLoading$voip_biz_release(true);
        VoipCallRequest voipCallRequest = VoipCallRequest.INSTANCE;
        Map<String, Object> map = this.f46292h;
        if (map == null) {
            map = Collections.emptyMap();
            Intrinsics.checkExpressionValueIsNotNull(map, "Collections.emptyMap()");
        }
        voipCallRequest.requestCallList(map, callListRequestCallback);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r2 = r8.getCallList();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m33241a(com.didichuxing.comp.telecom.core.request.model.CallListModel r8) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            if (r8 == 0) goto L_0x0013
            com.didichuxing.comp.telecom.core.request.model.CallList r2 = r8.getCallList()
            if (r2 == 0) goto L_0x0013
            java.util.List r2 = r2.getItems()
            goto L_0x0014
        L_0x0013:
            r2 = r1
        L_0x0014:
            if (r2 == 0) goto L_0x0076
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r4 = 1
            r3 = r3 ^ r4
            if (r3 != r4) goto L_0x0076
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r1 = r2.iterator()
        L_0x0027:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x005d
            java.lang.Object r2 = r1.next()
            com.didichuxing.comp.telecom.core.request.model.CallMethodItem r2 = (com.didichuxing.comp.telecom.core.request.model.CallMethodItem) r2
            java.lang.Integer r3 = r2.getType()
            r5 = 2
            if (r3 != 0) goto L_0x003b
            goto L_0x0049
        L_0x003b:
            int r6 = r3.intValue()
            if (r6 != r5) goto L_0x0049
            android.view.View r2 = r7.m33236a((com.didichuxing.comp.telecom.core.request.model.CallMethodItem) r2, (com.didichuxing.comp.telecom.core.request.model.CallListModel) r8)
            r0.add(r2)
            goto L_0x0027
        L_0x0049:
            if (r3 != 0) goto L_0x004c
            goto L_0x0027
        L_0x004c:
            int r3 = r3.intValue()
            if (r3 != r4) goto L_0x0027
            r3 = r8
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r3 = (com.didichuxing.comp.telecom.core.voip.VoipCallModel) r3
            android.view.View r2 = r7.m33237a((com.didichuxing.comp.telecom.core.request.model.CallMethodItem) r2, (com.didichuxing.comp.telecom.core.voip.VoipCallModel) r3)
            r0.add(r2)
            goto L_0x0027
        L_0x005d:
            com.didichuxing.comp.telecom.core.CallManagerAssist r1 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r2 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r1 = r1.getConfig()
            if (r1 == 0) goto L_0x007d
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallEventTickHandler r1 = r1.getEventTickHandler()
            if (r1 == 0) goto L_0x007d
            r1.onCallListShow(r8)
            goto L_0x007d
        L_0x0076:
            android.view.View r8 = r7.m33236a((com.didichuxing.comp.telecom.core.request.model.CallMethodItem) r1, (com.didichuxing.comp.telecom.core.request.model.CallListModel) r1)
            r0.add(r8)
        L_0x007d:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r8 = r0.iterator()
        L_0x0083:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x009c
            java.lang.Object r0 = r8.next()
            android.view.View r0 = (android.view.View) r0
            android.widget.LinearLayout r1 = r7.f46289e
            if (r1 != 0) goto L_0x0098
            java.lang.String r2 = "mCallListView"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0098:
            r1.addView(r0)
            goto L_0x0083
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.biz.p176ui.calllist.CallListBottomPop.m33241a(com.didichuxing.comp.telecom.core.request.model.CallListModel):void");
    }

    /* renamed from: a */
    private final View m33236a(CallMethodItem callMethodItem, CallListModel callListModel) {
        CharSequence charSequence;
        String title;
        LayoutInflater layoutInflater = this.f46291g.getLayoutInflater();
        LinearLayout linearLayout = this.f46289e;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCallListView");
        }
        int i = 0;
        View inflate = layoutInflater.inflate(R.layout.voip_biz_dialog_callist_item, linearLayout, false);
        boolean isEnable = callMethodItem != null ? callMethodItem.isEnable() : true;
        int i2 = isEnable ? R.drawable.voip_biz_calllist_phone_icon : R.drawable.voip_biz_calllist_phone_icon_unable;
        int color = ContextCompat.getColor(this.f46291g, isEnable ? R.color.c_333333 : R.color.c_999999);
        ((ImageView) inflate.findViewById(R.id.callTypeIcon)).setImageResource(i2);
        TextView textView = (TextView) inflate.findViewById(R.id.callTypeTitle);
        if (callMethodItem == null || (title = callMethodItem.getTitle()) == null) {
            Intrinsics.checkExpressionValueIsNotNull(inflate, "itemView");
            charSequence = inflate.getContext().getString(R.string.GDriver_IBT_General_telephone_omHT);
        } else {
            charSequence = title;
        }
        textView.setText(charSequence);
        textView.setTextColor(color);
        TextView textView2 = (TextView) inflate.findViewById(R.id.callTypeSubtitle);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "this");
        String str = null;
        textView2.setText(callMethodItem != null ? callMethodItem.getSubtitle() : null);
        textView2.setTextColor(color);
        if (callMethodItem != null) {
            str = callMethodItem.getSubtitle();
        }
        if (TextUtils.isEmpty(str)) {
            i = 8;
        }
        textView2.setVisibility(i);
        inflate.setOnClickListener(new CallListBottomPop$buildPhoneCallItem$3(this, callMethodItem, callListModel));
        Intrinsics.checkExpressionValueIsNotNull(inflate, "itemView");
        inflate.setClickable(isEnable);
        return inflate;
    }

    /* renamed from: a */
    private final View m33237a(CallMethodItem callMethodItem, VoipCallModel voipCallModel) {
        CharSequence charSequence;
        LayoutInflater layoutInflater = this.f46291g.getLayoutInflater();
        LinearLayout linearLayout = this.f46289e;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCallListView");
        }
        int i = 0;
        View inflate = layoutInflater.inflate(R.layout.voip_biz_dialog_callist_item, linearLayout, false);
        boolean isEnable = callMethodItem.isEnable();
        int i2 = isEnable ? R.drawable.voip_biz_calllist_voip_icon : R.drawable.voip_biz_calllist_voip_icon_unable;
        int color = ContextCompat.getColor(this.f46291g, isEnable ? R.color.c_333333 : R.color.c_999999);
        ((ImageView) inflate.findViewById(R.id.callTypeIcon)).setImageResource(i2);
        TextView textView = (TextView) inflate.findViewById(R.id.callTypeTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "this");
        String title = callMethodItem.getTitle();
        if (title != null) {
            charSequence = title;
        } else {
            Intrinsics.checkExpressionValueIsNotNull(inflate, "itemView");
            charSequence = inflate.getContext().getString(R.string.GDriver_IBT_Network_calls_yEJz);
        }
        textView.setText(charSequence);
        textView.setTextColor(color);
        TextView textView2 = (TextView) inflate.findViewById(R.id.callTypeSubtitle);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "this");
        textView2.setText(callMethodItem.getSubtitle());
        textView2.setTextColor(color);
        if (TextUtils.isEmpty(callMethodItem.getSubtitle())) {
            i = 8;
        }
        textView2.setVisibility(i);
        inflate.setOnClickListener(new CallListBottomPop$buildVoipCallItem$3(this, callMethodItem, voipCallModel));
        Intrinsics.checkExpressionValueIsNotNull(inflate, "itemView");
        inflate.setClickable(isEnable);
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33239a(Context context, VoipCallModel voipCallModel) {
        String str = this.f46285a;
        CallLogUtil.logI(str, "userClickToMakeCall " + voipCallModel);
        VoipBusinessActivity.Companion.openPage(context, voipCallModel, 2);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/calllist/CallListBottomPop$CallListRequestCallback;", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didichuxing/comp/telecom/core/request/model/CallListResponse;", "mBottomPop", "Lcom/didichuxing/comp/telecom/biz/ui/calllist/CallListBottomPop;", "(Lcom/didichuxing/comp/telecom/biz/ui/calllist/CallListBottomPop;Lcom/didichuxing/comp/telecom/biz/ui/calllist/CallListBottomPop;)V", "finished", "", "getFinished", "()Z", "setFinished", "(Z)V", "getMBottomPop", "()Lcom/didichuxing/comp/telecom/biz/ui/calllist/CallListBottomPop;", "setMBottomPop", "(Lcom/didichuxing/comp/telecom/biz/ui/calllist/CallListBottomPop;)V", "cancel", "", "onFailure", "exception", "Ljava/io/IOException;", "onSuccess", "value", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
    /* renamed from: com.didichuxing.comp.telecom.biz.ui.calllist.CallListBottomPop$CallListRequestCallback */
    /* compiled from: CallListBottomPop.kt */
    public final class CallListRequestCallback implements RpcService.Callback<CallListResponse> {
        private boolean finished;
        private CallListBottomPop mBottomPop;

        public CallListRequestCallback(CallListBottomPop callListBottomPop) {
            this.mBottomPop = callListBottomPop;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CallListRequestCallback(CallListBottomPop callListBottomPop, CallListBottomPop callListBottomPop2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : callListBottomPop2);
        }

        public final CallListBottomPop getMBottomPop() {
            return this.mBottomPop;
        }

        public final void setMBottomPop(CallListBottomPop callListBottomPop) {
            this.mBottomPop = callListBottomPop;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final void setFinished(boolean z) {
            this.finished = z;
        }

        public void onSuccess(CallListResponse callListResponse) {
            this.finished = true;
            CallListBottomPop callListBottomPop = this.mBottomPop;
            if (callListBottomPop != null) {
                callListBottomPop.m33241a(callListResponse != null ? callListResponse.getData() : null);
            }
            CallListBottomPop callListBottomPop2 = this.mBottomPop;
            if (callListBottomPop2 != null) {
                callListBottomPop2.showLoading$voip_biz_release(false);
            }
        }

        public void onFailure(IOException iOException) {
            this.finished = true;
            CallListBottomPop callListBottomPop = this.mBottomPop;
            if (callListBottomPop != null) {
                callListBottomPop.m33241a((CallListModel) null);
            }
            CallListBottomPop callListBottomPop2 = this.mBottomPop;
            if (callListBottomPop2 != null) {
                callListBottomPop2.showLoading$voip_biz_release(false);
            }
        }

        public final void cancel() {
            this.mBottomPop = null;
        }
    }
}
