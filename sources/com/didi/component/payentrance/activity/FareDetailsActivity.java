package com.didi.component.payentrance.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.safetoolkit.activity.BaseActivityWithUIStuff;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.UniPayManager;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.adapter.CommonRvAdapter;
import com.didi.component.common.util.GLog;
import com.didi.component.payentrance.model.FareInfoItem;
import com.didi.component.payentrance.viewmodel.FareDetailViewModel;
import com.didi.entrega.customer.foundation.rpc.ParamsHelper;
import com.didi.safetoolkit.util.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.webview.WebTitleBar;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didiglobal.travel.infra.content.ContextKt;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010-\u001a\u00020.H\u0014J\u001c\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u00010\tH\u0002J\b\u00103\u001a\u00020.H\u0014J\b\u00104\u001a\u000205H\u0014J\u0010\u00106\u001a\n \u0015*\u0004\u0018\u00010$0$H\u0016J\u0010\u00107\u001a\u0002052\u0006\u00108\u001a\u000205H\u0002J\b\u00109\u001a\u00020.H\u0014J\b\u0010:\u001a\u00020.H\u0014J\u0006\u0010;\u001a\u00020<J\u0010\u0010=\u001a\u00020.2\b\u0010>\u001a\u0004\u0018\u00010\u0004J\u001a\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0012\u0010D\u001a\u00020.2\b\u0010E\u001a\u0004\u0018\u00010FH\u0014J\b\u0010G\u001a\u00020.H\u0014J\u001a\u0010H\u001a\u00020.2\b\u0010I\u001a\u0004\u0018\u00010\u001a2\u0006\u0010J\u001a\u00020<H\u0002J\b\u0010K\u001a\u00020.H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R7\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@BX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\n \u0015*\u0004\u0018\u00010\u001a0\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\n \u0015*\u0004\u0018\u00010\u001e0\u001e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\n \u0015*\u0004\u0018\u00010\u001a0\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001cR\u001c\u0010#\u001a\n \u0015*\u0004\u0018\u00010$0$8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*¨\u0006M"}, mo175978d2 = {"Lcom/didi/component/payentrance/activity/FareDetailsActivity;", "Lcom/android/didi/safetoolkit/activity/BaseActivityWithUIStuff;", "()V", "COUNTRY_REGION_BX", "", "lastTime", "", "<set-?>", "Lcom/didi/component/common/adapter/CommonRvAdapter;", "Lcom/didi/component/payentrance/model/FareInfoItem;", "mAdapter", "getMAdapter", "()Lcom/didi/component/common/adapter/CommonRvAdapter;", "setMAdapter", "(Lcom/didi/component/common/adapter/CommonRvAdapter;)V", "mAdapter$delegate", "Lkotlin/properties/ReadWriteProperty;", "mData", "", "mErrorView", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getMErrorView", "()Landroid/widget/LinearLayout;", "mFareDoubtUrl", "mFareDoubtView", "Landroid/widget/TextView;", "getMFareDoubtView", "()Landroid/widget/TextView;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "mReloadTv", "getMReloadTv", "mTitleBar", "Lcom/didi/sdk/webview/WebTitleBar;", "getMTitleBar", "()Lcom/didi/sdk/webview/WebTitleBar;", "viewModel", "Lcom/didi/component/payentrance/viewmodel/FareDetailViewModel;", "getViewModel", "()Lcom/didi/component/payentrance/viewmodel/FareDetailViewModel;", "viewModel$delegate", "Landroidx/lifecycle/ViewModelLazy;", "beforeContentViewLoaded", "", "bindDataToView", "holder", "Lcom/didi/component/common/adapter/CommonRvVH;", "item", "findViews", "getBasicContentLayoutResId", "", "getFallbackView", "getLayoutId", "position", "initData", "initObjects", "isFareDoubtEntryOpen", "", "jumpFareDoubtUrl", "url", "jumpToRulesH5", "context", "Landroid/content/Context;", "order", "Lcom/didi/travel/psnger/model/response/CarOrder;", "parseBundle", "bundle", "Landroid/os/Bundle;", "setListener", "setTextColor", "tv", "isGlobal", "showErrorView", "Companion", "comp-payentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FareDetailsActivity.kt */
public final class FareDetailsActivity extends BaseActivityWithUIStuff {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f14864a = {C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(FareDetailsActivity.class, "mAdapter", "getMAdapter()Lcom/didi/component/common/adapter/CommonRvAdapter;", 0))};

    /* renamed from: h */
    private static final String f14865h = "FareDetailsActivity";

    /* renamed from: b */
    private final String f14866b = "BR";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f14867c;

    /* renamed from: d */
    private final ReadWriteProperty f14868d = Delegates.INSTANCE.notNull();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<FareInfoItem> f14869e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f14870f;

    /* renamed from: g */
    private final ViewModelLazy f14871g;

    public void _$_clearFindViewByIdCache() {
    }

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return R.layout.global_pe_pay_fare_details_activity;
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
    }

    public FareDetailsActivity() {
        ComponentActivity componentActivity = this;
        this.f14871g = new ViewModelLazy(C21490Reflection.getOrCreateKotlinClass(FareDetailViewModel.class), new FareDetailsActivity$special$$inlined$viewModel$1(componentActivity), new FareDetailsActivity$special$$inlined$viewModel$2(componentActivity));
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/component/payentrance/activity/FareDetailsActivity$Companion;", "", "()V", "TAG", "", "comp-payentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FareDetailsActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: a */
    private final RecyclerView m10677a() {
        return (RecyclerView) findViewById(R.id.center_rv);
    }

    /* renamed from: b */
    private final WebTitleBar m10682b() {
        return (WebTitleBar) findViewById(R.id.center_title_bar);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final LinearLayout m10683c() {
        return (LinearLayout) findViewById(R.id.pe_pay_fare_error_view);
    }

    /* renamed from: d */
    private final TextView m10684d() {
        return (TextView) findViewById(R.id.pe_pay_fare_details_reload);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final TextView m10685e() {
        return (TextView) findViewById(R.id.tv_fare_doubt_entry);
    }

    /* renamed from: a */
    private final void m10680a(CommonRvAdapter<FareInfoItem> commonRvAdapter) {
        this.f14868d.setValue(this, f14864a[0], commonRvAdapter);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final CommonRvAdapter<FareInfoItem> m10686f() {
        return (CommonRvAdapter) this.f14868d.getValue(this, f14864a[0]);
    }

    /* renamed from: g */
    private final FareDetailViewModel m10687g() {
        return (FareDetailViewModel) this.f14871g.getValue();
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        WebTitleBar b = m10682b();
        b.setTitle(ContextKt.stringOf(this, R.string.pe_pay_fare_details_title));
        b.setCloseBtnVisibility(8);
        b.setMoreBtnVisibility(8);
        b.setBackBtnVisibility(0);
        TextView middleTv = m10682b().getMiddleTv();
        if (middleTv != null) {
            middleTv.setTypeface(Typeface.DEFAULT_BOLD);
            middleTv.setTextSize(18.0f);
        }
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        m10680a((CommonRvAdapter<FareInfoItem>) new FareDetailsActivity$initObjects$1(this));
        m10677a().setLayoutManager(new LinearLayoutManager(getContext()));
        m10677a().setAdapter(m10686f());
        m10685e().setOnClickListener(new FareDetailsActivity$initObjects$2(this));
    }

    public final void jumpFareDoubtUrl(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            CarOrder order = CarOrderHelper.getOrder();
            String str2 = order == null ? null : order.oid;
            GLog.m7968e(f14865h, Intrinsics.stringPlus("jumpWithDefaultUrl:orderId = ", str2));
            Map hashMap = new HashMap();
            hashMap.put("orderId", str2);
            hashMap.put("source", "fare_detail_page");
            hashMap.put(ParamsHelper.FLUTTER_KF_PAGE_SOURCE, "fare_detail_page");
            str = GlobalWebUrl.buildUrl("https://help.didiglobal.com/processing-passenger-new.html", hashMap);
        }
        UniPayManager.gotoWeb((Context) this, str);
    }

    /* access modifiers changed from: protected */
    public void beforeContentViewLoaded() {
        super.beforeContentViewLoaded();
        try {
            StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        } catch (Exception e) {
            SystemUtils.log(6, f14865h, "StatusBarLightingCompat.setStatusBarBgLightning", e, "com.didi.component.payentrance.activity.FareDetailsActivity", 172);
        }
    }

    /* access modifiers changed from: protected */
    public void initData() {
        showLoading();
        this.f14870f = SystemClock.uptimeMillis();
        m10687g().load(new FareDetailsActivity$initData$1(this));
    }

    public final boolean isFareDoubtEntryOpen() {
        boolean z;
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return false;
        }
        boolean z2 = true;
        if ((order.status != 3 || order.substatus == 2001) && !(order.status == 5 && order.substatus == 5001)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return GlobalApolloUtil.isOpenFareDoubtEntryOnFinishOrder();
        }
        if (!((order.status == 5 && (order.substatus == 5002 || order.substatus == 5003)) || order.status == 6)) {
            z2 = false;
        }
        if (z2) {
            return GlobalApolloUtil.isOpenFareDoubtEntryOnCancelOrder();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        m10682b().setOnBackClickListener(new FareDetailsActivity$setListener$1(this));
    }

    public WebTitleBar getFallbackView() {
        return m10682b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final int m10676a(int i) {
        Collection collection = this.f14869e;
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        switch (this.f14869e.get(i).getType()) {
            case 0:
                return R.layout.global_pe_pay_fare_title_item;
            case 1:
                return R.layout.global_pe_pay_fare_msg;
            case 2:
                return R.layout.global_pe_pay_fare_decoration;
            case 3:
                return R.layout.global_pe_pay_fare_basic_fee;
            case 4:
                return R.layout.global_pe_pay_fare_basic_fee_child;
            case 6:
                return R.layout.global_pe_pay_fare_details_btn;
            case 8:
                return R.layout.global_pe_pay_footer_msg;
            case 9:
                return R.layout.global_pe_pay_fare_car_pool;
            case 10:
                return R.layout.global_pe_pay_fare_title;
            case 11:
                return R.layout.global_pe_pay_fare_payment;
            case 12:
                return R.layout.global_pe_pay_fare_rules;
            default:
                return R.layout.global_pe_pay_fare_decoration_faq;
        }
    }

    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.widget.ImageView, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v6, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r1v8, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r1v10, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r1v13, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r1v15, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r1v18, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r1v21, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r1v24, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r1v26 */
    /* JADX WARNING: type inference failed for: r1v27 */
    /* JADX WARNING: type inference failed for: r1v28 */
    /* JADX WARNING: type inference failed for: r1v29 */
    /* JADX WARNING: type inference failed for: r1v30 */
    /* JADX WARNING: type inference failed for: r1v31 */
    /* JADX WARNING: type inference failed for: r1v32 */
    /* JADX WARNING: type inference failed for: r1v33 */
    /* JADX WARNING: type inference failed for: r1v34 */
    /* JADX WARNING: type inference failed for: r1v35 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m10681a(com.didi.component.common.adapter.CommonRvVH r7, com.didi.component.payentrance.model.FareInfoItem r8) {
        /*
            r6 = this;
            com.didi.travel.psnger.model.response.CarOrder r0 = com.didi.component.business.util.CarOrderHelper.getOrder()
            java.lang.String r1 = r6.f14866b
            java.lang.String r0 = r0.countryCode
            r2 = 1
            boolean r0 = kotlin.text.StringsKt.equals(r1, r0, r2)
            r0 = r0 ^ r2
            r1 = 0
            if (r8 != 0) goto L_0x0013
            r3 = r1
            goto L_0x001b
        L_0x0013:
            int r3 = r8.getType()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x001b:
            r4 = 8
            if (r3 != 0) goto L_0x0020
            goto L_0x0076
        L_0x0020:
            int r5 = r3.intValue()
            if (r5 != 0) goto L_0x0076
            if (r7 != 0) goto L_0x002a
            r0 = r1
            goto L_0x0031
        L_0x002a:
            r0 = 2131430686(0x7f0b0d1e, float:1.848308E38)
            android.widget.TextView r0 = r7.getTextView(r0)
        L_0x0031:
            int r3 = r8.getShowPoi()
            if (r3 != r2) goto L_0x0051
            if (r0 != 0) goto L_0x003a
            goto L_0x003d
        L_0x003a:
            r0.setVisibility(r4)
        L_0x003d:
            if (r7 != 0) goto L_0x0041
            r0 = r1
            goto L_0x004a
        L_0x0041:
            r0 = 2131430687(0x7f0b0d1f, float:1.8483082E38)
            android.view.View r0 = r7.getTargetView(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x004a:
            if (r0 != 0) goto L_0x004d
            goto L_0x0051
        L_0x004d:
            r2 = 0
            r0.setVisibility(r2)
        L_0x0051:
            if (r0 != 0) goto L_0x0054
            goto L_0x005d
        L_0x0054:
            java.lang.String r2 = r8.getFeeLabel()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x005d:
            if (r7 != 0) goto L_0x0060
            goto L_0x0067
        L_0x0060:
            r0 = 2131430685(0x7f0b0d1d, float:1.8483078E38)
            android.widget.TextView r1 = r7.getTextView(r0)
        L_0x0067:
            if (r1 != 0) goto L_0x006b
            goto L_0x02a1
        L_0x006b:
            java.lang.String r7 = r8.getFeeValue()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
            goto L_0x02a1
        L_0x0076:
            if (r3 != 0) goto L_0x0079
            goto L_0x00a0
        L_0x0079:
            int r5 = r3.intValue()
            if (r5 != r2) goto L_0x00a0
            if (r7 != 0) goto L_0x0082
            goto L_0x0089
        L_0x0082:
            r1 = 2131430684(0x7f0b0d1c, float:1.8483076E38)
            android.widget.TextView r1 = r7.getTextView(r1)
        L_0x0089:
            if (r1 != 0) goto L_0x008c
            goto L_0x0095
        L_0x008c:
            java.lang.String r7 = r8.getFeeLabel()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
        L_0x0095:
            boolean r7 = r8.isHighlight()
            if (r7 == 0) goto L_0x02a1
            r6.m10679a((android.widget.TextView) r1, (boolean) r0)
            goto L_0x02a1
        L_0x00a0:
            r2 = 3
            if (r3 != 0) goto L_0x00a4
            goto L_0x0102
        L_0x00a4:
            int r5 = r3.intValue()
            if (r5 != r2) goto L_0x0102
            if (r7 != 0) goto L_0x00ae
            r0 = r1
            goto L_0x00b5
        L_0x00ae:
            r0 = 2131430681(0x7f0b0d19, float:1.848307E38)
            android.widget.TextView r0 = r7.getTextView(r0)
        L_0x00b5:
            if (r7 != 0) goto L_0x00b8
            goto L_0x00bf
        L_0x00b8:
            r1 = 2131430682(0x7f0b0d1a, float:1.8483072E38)
            android.widget.TextView r1 = r7.getTextView(r1)
        L_0x00bf:
            if (r0 != 0) goto L_0x00c2
            goto L_0x00cb
        L_0x00c2:
            java.lang.String r7 = r8.getFeeLabel()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0.setText(r7)
        L_0x00cb:
            if (r1 != 0) goto L_0x00ce
            goto L_0x00d7
        L_0x00ce:
            java.lang.String r7 = r8.getFeeValue()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
        L_0x00d7:
            java.lang.String r7 = r8.getFeeValueRGB()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x02a1
            if (r0 != 0) goto L_0x00e6
            goto L_0x00f1
        L_0x00e6:
            java.lang.String r7 = r8.getFeeValueRGB()
            int r7 = android.graphics.Color.parseColor(r7)
            r0.setTextColor(r7)
        L_0x00f1:
            if (r1 != 0) goto L_0x00f5
            goto L_0x02a1
        L_0x00f5:
            java.lang.String r7 = r8.getFeeValueRGB()
            int r7 = android.graphics.Color.parseColor(r7)
            r1.setTextColor(r7)
            goto L_0x02a1
        L_0x0102:
            r2 = 4
            if (r3 != 0) goto L_0x0106
            goto L_0x013c
        L_0x0106:
            int r5 = r3.intValue()
            if (r5 != r2) goto L_0x013c
            if (r7 != 0) goto L_0x0110
            r0 = r1
            goto L_0x0117
        L_0x0110:
            r0 = 2131430679(0x7f0b0d17, float:1.8483066E38)
            android.widget.TextView r0 = r7.getTextView(r0)
        L_0x0117:
            if (r7 != 0) goto L_0x011a
            goto L_0x0121
        L_0x011a:
            r1 = 2131430680(0x7f0b0d18, float:1.8483068E38)
            android.widget.TextView r1 = r7.getTextView(r1)
        L_0x0121:
            if (r0 != 0) goto L_0x0124
            goto L_0x012d
        L_0x0124:
            java.lang.String r7 = r8.getFeeLabel()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0.setText(r7)
        L_0x012d:
            if (r1 != 0) goto L_0x0131
            goto L_0x02a1
        L_0x0131:
            java.lang.String r7 = r8.getFeeValue()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
            goto L_0x02a1
        L_0x013c:
            r2 = 6
            if (r3 != 0) goto L_0x0140
            goto L_0x016c
        L_0x0140:
            int r5 = r3.intValue()
            if (r5 != r2) goto L_0x016c
            if (r7 != 0) goto L_0x0149
            goto L_0x0150
        L_0x0149:
            r0 = 2131430683(0x7f0b0d1b, float:1.8483074E38)
            android.widget.TextView r1 = r7.getTextView(r0)
        L_0x0150:
            if (r1 != 0) goto L_0x0153
            goto L_0x015c
        L_0x0153:
            java.lang.String r7 = r8.getFeeLabel()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
        L_0x015c:
            if (r1 != 0) goto L_0x0160
            goto L_0x02a1
        L_0x0160:
            com.didi.component.payentrance.activity.FareDetailsActivity$bindDataToView$1 r7 = new com.didi.component.payentrance.activity.FareDetailsActivity$bindDataToView$1
            r7.<init>(r6, r8)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r1.setOnClickListener(r7)
            goto L_0x02a1
        L_0x016c:
            if (r3 != 0) goto L_0x016f
            goto L_0x0196
        L_0x016f:
            int r2 = r3.intValue()
            if (r2 != r4) goto L_0x0196
            if (r7 != 0) goto L_0x0178
            goto L_0x017f
        L_0x0178:
            r1 = 2131430826(0x7f0b0daa, float:1.8483364E38)
            android.widget.TextView r1 = r7.getTextView(r1)
        L_0x017f:
            if (r1 != 0) goto L_0x0182
            goto L_0x018b
        L_0x0182:
            java.lang.String r7 = r8.getFooterMsg()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
        L_0x018b:
            boolean r7 = r8.isHighlight()
            if (r7 == 0) goto L_0x02a1
            r6.m10679a((android.widget.TextView) r1, (boolean) r0)
            goto L_0x02a1
        L_0x0196:
            r0 = 9
            if (r3 != 0) goto L_0x019b
            goto L_0x01d1
        L_0x019b:
            int r2 = r3.intValue()
            if (r2 != r0) goto L_0x01d1
            if (r7 != 0) goto L_0x01a5
            r0 = r1
            goto L_0x01ac
        L_0x01a5:
            r0 = 2131435390(0x7f0b1f7e, float:1.849262E38)
            android.widget.TextView r0 = r7.getTextView(r0)
        L_0x01ac:
            if (r0 != 0) goto L_0x01af
            goto L_0x01b8
        L_0x01af:
            java.lang.String r2 = r8.getCarPoolTitle()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x01b8:
            if (r7 != 0) goto L_0x01bb
            goto L_0x01c2
        L_0x01bb:
            r0 = 2131435362(0x7f0b1f62, float:1.8492564E38)
            android.widget.TextView r1 = r7.getTextView(r0)
        L_0x01c2:
            if (r1 != 0) goto L_0x01c6
            goto L_0x02a1
        L_0x01c6:
            java.lang.String r7 = r8.getCarPoolSubTitle()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
            goto L_0x02a1
        L_0x01d1:
            r0 = 10
            if (r3 != 0) goto L_0x01d6
            goto L_0x01f5
        L_0x01d6:
            int r2 = r3.intValue()
            if (r2 != r0) goto L_0x01f5
            if (r7 != 0) goto L_0x01df
            goto L_0x01e6
        L_0x01df:
            r0 = 2131434585(0x7f0b1c59, float:1.8490988E38)
            android.widget.TextView r1 = r7.getTextView(r0)
        L_0x01e6:
            if (r1 != 0) goto L_0x01ea
            goto L_0x02a1
        L_0x01ea:
            java.lang.String r7 = r8.getTitle()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
            goto L_0x02a1
        L_0x01f5:
            r0 = 11
            if (r3 != 0) goto L_0x01fb
            goto L_0x0280
        L_0x01fb:
            int r2 = r3.intValue()
            if (r2 != r0) goto L_0x0280
            if (r7 != 0) goto L_0x0205
            r0 = r1
            goto L_0x020c
        L_0x0205:
            r0 = 2131430720(0x7f0b0d40, float:1.8483149E38)
            android.widget.TextView r0 = r7.getTextView(r0)
        L_0x020c:
            if (r0 != 0) goto L_0x020f
            goto L_0x0218
        L_0x020f:
            java.lang.String r2 = r8.getFeeLabel()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0218:
            if (r7 != 0) goto L_0x021c
            r0 = r1
            goto L_0x0223
        L_0x021c:
            r0 = 2131430718(0x7f0b0d3e, float:1.8483145E38)
            android.widget.TextView r0 = r7.getTextView(r0)
        L_0x0223:
            if (r0 != 0) goto L_0x0226
            goto L_0x022f
        L_0x0226:
            java.lang.String r2 = r8.getFeeCardSuffix()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x022f:
            if (r7 != 0) goto L_0x0233
            r0 = r1
            goto L_0x023a
        L_0x0233:
            r0 = 2131430722(0x7f0b0d42, float:1.8483153E38)
            android.widget.TextView r0 = r7.getTextView(r0)
        L_0x023a:
            if (r0 != 0) goto L_0x023d
            goto L_0x0246
        L_0x023d:
            java.lang.String r2 = r8.getFeeValue()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0246:
            java.lang.String r2 = r8.getFeeValueRGB()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0260
            if (r0 != 0) goto L_0x0255
            goto L_0x0260
        L_0x0255:
            java.lang.String r2 = r8.getFeeValueRGB()
            int r2 = android.graphics.Color.parseColor(r2)
            r0.setTextColor(r2)
        L_0x0260:
            r0 = r6
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with((androidx.fragment.app.FragmentActivity) r0)
            java.lang.String r8 = r8.getFeeIcon()
            com.bumptech.glide.RequestBuilder r8 = r0.load((java.lang.String) r8)
            if (r7 != 0) goto L_0x0272
            goto L_0x0279
        L_0x0272:
            r0 = 2131430719(0x7f0b0d3f, float:1.8483147E38)
            android.widget.ImageView r1 = r7.getImageView(r0)
        L_0x0279:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r8.into((android.widget.ImageView) r1)
            goto L_0x02a1
        L_0x0280:
            r0 = 12
            if (r3 != 0) goto L_0x0285
            goto L_0x02a1
        L_0x0285:
            int r2 = r3.intValue()
            if (r2 != r0) goto L_0x02a1
            if (r7 != 0) goto L_0x028e
            goto L_0x0295
        L_0x028e:
            r0 = 2131433886(0x7f0b199e, float:1.848957E38)
            android.widget.TextView r1 = r7.getTextView(r0)
        L_0x0295:
            if (r1 != 0) goto L_0x0298
            goto L_0x02a1
        L_0x0298:
            java.lang.String r7 = r8.getTitle()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
        L_0x02a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.payentrance.activity.FareDetailsActivity.m10681a(com.didi.component.common.adapter.CommonRvVH, com.didi.component.payentrance.model.FareInfoItem):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m10678a(Context context, CarOrder carOrder) {
        m10687g().withRulesUrl(carOrder, new FareDetailsActivity$jumpToRulesH5$1(context));
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public final void m10688h() {
        m10683c().setVisibility(0);
        m10684d().setOnClickListener(new FareDetailsActivity$showErrorView$1(this));
    }

    /* renamed from: a */
    private final void m10679a(TextView textView, boolean z) {
        int color = ResourcesHelper.getColor(getContext(), R.color.pe_color_fe7f3f);
        if (!z) {
            color = ResourcesHelper.getColor(getContext(), R.color.pe_color_fea330);
        }
        if (textView != null) {
            textView.setTextColor(color);
        }
    }
}
