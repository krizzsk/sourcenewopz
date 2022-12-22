package com.didi.component.indriver.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.UiUtils;
import com.didi.component.business.xpanelnew.XpNewHeightChangeModel;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.indriver.AbsIndriverPresenter;
import com.didi.component.indriver.IIndriverView;
import com.didi.component.indriver.MountainInterpolator;
import com.didi.component.indriver.model.DriverData;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.taxis99.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class IndriverView implements IIndriverView {

    /* renamed from: i */
    private static String f14182i = "indriver";

    /* renamed from: k */
    private static final int f14183k = 129;

    /* renamed from: a */
    HashSet<String> f14184a = new HashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f14185b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IndriverItemFooterView f14186c;

    /* renamed from: d */
    private TextView f14187d;

    /* renamed from: e */
    private TextView f14188e;

    /* renamed from: f */
    private TextView f14189f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LinearLayout f14190g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f14191h = 3;

    /* renamed from: j */
    private HashMap<String, HashMap<DriverData, Integer>> f14192j = new HashMap<>();
    protected AbsIndriverPresenter mPresenter;

    public IndriverView(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.indriver_layout, viewGroup, false);
        this.f14185b = inflate;
        this.f14187d = (TextView) inflate.findViewById(R.id.title_text);
        this.f14188e = (TextView) this.f14185b.findViewById(R.id.tips_text);
        this.f14189f = (TextView) this.f14185b.findViewById(R.id.current_price_text);
        this.f14190g = (LinearLayout) this.f14185b.findViewById(R.id.indriver_container);
        this.f14186c = (IndriverItemFooterView) this.f14185b.findViewById(R.id.indriver_footer);
        this.f14192j.clear();
    }

    public View getView() {
        return this.f14185b;
    }

    public void setPresenter(AbsIndriverPresenter absIndriverPresenter) {
        this.mPresenter = absIndriverPresenter;
    }

    public void setTitleText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f14187d.setVisibility(8);
            return;
        }
        this.f14187d.setVisibility(0);
        this.f14187d.setText(str);
    }

    public void setTipsText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f14188e.setVisibility(8);
            return;
        }
        this.f14188e.setVisibility(0);
        this.f14188e.setText(str);
    }

    public void setCurrentPriceText(LEGORichInfo lEGORichInfo) {
        if (lEGORichInfo == null) {
            this.f14189f.setVisibility(8);
            return;
        }
        this.f14189f.setVisibility(0);
        lEGORichInfo.bindTextView(this.f14189f);
    }

    public void resetView() {
        this.f14192j.clear();
        LinearLayout linearLayout = this.f14190g;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x007c, code lost:
        if ((r9.height % com.didi.component.business.util.UiUtils.dip2px(r8.f14185b.getContext(), 129.0f)) >= r1) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x003e, code lost:
        if ((r9 % com.didi.component.business.util.UiUtils.dip2px(r8.f14185b.getContext(), 129.0f)) >= r1) goto L_0x007e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void omegaTrack(com.didi.component.business.model.XpTrackItem r9) {
        /*
            r8 = this;
            android.view.View r0 = r8.f14185b
            android.content.Context r0 = r0.getContext()
            r1 = 1133903872(0x43960000, float:300.0)
            int r0 = com.didi.component.business.util.UiUtils.px2dip(r0, r1)
            android.view.View r1 = r8.f14185b
            android.content.Context r1 = r1.getContext()
            r2 = 1124139008(0x43010000, float:129.0)
            int r1 = com.didi.component.business.util.UiUtils.dip2px(r1, r2)
            int r1 = r1 / 2
            java.util.HashMap<java.lang.String, java.util.HashMap<com.didi.component.indriver.model.DriverData, java.lang.Integer>> r3 = r8.f14192j
            r3.size()
            int r3 = r9.top
            r4 = 0
            if (r3 <= 0) goto L_0x0041
            int r9 = r9.height
            int r9 = r9 - r0
            android.view.View r0 = r8.f14185b
            android.content.Context r0 = r0.getContext()
            int r0 = com.didi.component.business.util.UiUtils.dip2px(r0, r2)
            int r0 = r9 / r0
            android.view.View r3 = r8.f14185b
            android.content.Context r3 = r3.getContext()
            int r2 = com.didi.component.business.util.UiUtils.dip2px(r3, r2)
            int r9 = r9 % r2
            if (r9 < r1) goto L_0x0080
            goto L_0x007e
        L_0x0041:
            int r3 = r9.top
            int r3 = r3 + r0
            if (r3 > 0) goto L_0x0062
            int r0 = java.lang.Math.abs(r3)
            if (r0 >= r1) goto L_0x004d
            goto L_0x0062
        L_0x004d:
            int r0 = java.lang.Math.abs(r3)
            android.view.View r3 = r8.f14185b
            android.content.Context r3 = r3.getContext()
            int r3 = com.didi.component.business.util.UiUtils.dip2px(r3, r2)
            int r0 = r0 / r3
            double r3 = (double) r0
            double r3 = java.lang.Math.ceil(r3)
            int r4 = (int) r3
        L_0x0062:
            int r0 = r9.height
            android.view.View r3 = r8.f14185b
            android.content.Context r3 = r3.getContext()
            int r3 = com.didi.component.business.util.UiUtils.dip2px(r3, r2)
            int r0 = r0 / r3
            int r9 = r9.height
            android.view.View r3 = r8.f14185b
            android.content.Context r3 = r3.getContext()
            int r2 = com.didi.component.business.util.UiUtils.dip2px(r3, r2)
            int r9 = r9 % r2
            if (r9 < r1) goto L_0x0080
        L_0x007e:
            int r0 = r0 + 1
        L_0x0080:
            java.util.HashMap<java.lang.String, java.util.HashMap<com.didi.component.indriver.model.DriverData, java.lang.Integer>> r9 = r8.f14192j
            java.util.Set r9 = r9.entrySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x008a:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x0156
            java.lang.Object r1 = r9.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.util.HashSet<java.lang.String> r3 = r8.f14184a
            boolean r2 = r3.add(r2)
            if (r2 != 0) goto L_0x00a5
            goto L_0x008a
        L_0x00a5:
            java.lang.Object r1 = r1.getValue()
            java.util.HashMap r1 = (java.util.HashMap) r1
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x00b3:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x008a
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.String r5 = f14182i
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = " i "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r7 = " index "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r7 = "/ "
            r6.append(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            com.didi.component.common.util.GLog.m7965d(r5, r6)
            if (r4 > r3) goto L_0x008a
            int r5 = r0 + -1
            if (r3 <= r5) goto L_0x00f6
            goto L_0x008a
        L_0x00f6:
            java.lang.Object r2 = r2.getKey()
            com.didi.component.indriver.model.DriverData r2 = (com.didi.component.indriver.model.DriverData) r2
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r5 = com.didi.component.business.util.CarOrderHelper.getOrderId()
            java.lang.String r6 = "order_id"
            r3.put(r6, r5)
            java.lang.String r5 = r2.did
            java.lang.String r6 = "driver_id"
            r3.put(r6, r5)
            com.didi.global.globaluikit.richinfo.LEGORichInfo r5 = r2.eta
            java.lang.String r5 = r5.getContent()
            java.lang.String r6 = "eda"
            r3.put(r6, r5)
            java.lang.String r5 = r2.trips
            java.lang.String r6 = "trips"
            r3.put(r6, r5)
            double r5 = r2.star
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            java.lang.String r6 = "star"
            r3.put(r6, r5)
            java.lang.String r5 = r2.carBrand
            java.lang.String r6 = "car_brand"
            r3.put(r6, r5)
            android.widget.TextView r5 = r8.f14189f
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "current_price"
            r3.put(r6, r5)
            com.didi.global.globaluikit.richinfo.LEGORichInfo r2 = r2.price
            java.lang.String r2 = r2.getContent()
            java.lang.String r5 = "price"
            r3.put(r5, r2)
            java.lang.String r2 = "ibt_gp_carconfirm_negotiate_detail_sw"
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent((java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.Object>) r3)
            goto L_0x00b3
        L_0x0156:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.indriver.impl.IndriverView.omegaTrack(com.didi.component.business.model.XpTrackItem):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0256, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setIndriverList(java.util.List<com.didi.component.indriver.model.DriverData> r14, int r15) {
        /*
            r13 = this;
            monitor-enter(r13)
            if (r14 != 0) goto L_0x0005
            monitor-exit(r13)
            return
        L_0x0005:
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x0257 }
            r0.<init>()     // Catch:{ all -> 0x0257 }
            if (r15 <= 0) goto L_0x000e
            r13.f14191h = r15     // Catch:{ all -> 0x0257 }
        L_0x000e:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0257 }
            r1.<init>()     // Catch:{ all -> 0x0257 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0257 }
            r2.<init>()     // Catch:{ all -> 0x0257 }
            r3 = 0
            r4 = 0
        L_0x001a:
            int r5 = r14.size()     // Catch:{ all -> 0x0257 }
            if (r4 >= r5) goto L_0x005f
            java.lang.Object r5 = r14.get(r4)     // Catch:{ all -> 0x0257 }
            com.didi.component.indriver.model.DriverData r5 = (com.didi.component.indriver.model.DriverData) r5     // Catch:{ all -> 0x0257 }
            java.lang.String r6 = r5.did     // Catch:{ all -> 0x0257 }
            r0.add(r6)     // Catch:{ all -> 0x0257 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0257 }
            r6.<init>()     // Catch:{ all -> 0x0257 }
            java.lang.String r7 = r5.did     // Catch:{ all -> 0x0257 }
            r6.append(r7)     // Catch:{ all -> 0x0257 }
            java.lang.String r7 = r5.bargainId     // Catch:{ all -> 0x0257 }
            r6.append(r7)     // Catch:{ all -> 0x0257 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0257 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0257 }
            r7.<init>()     // Catch:{ all -> 0x0257 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0257 }
            r7.put(r5, r8)     // Catch:{ all -> 0x0257 }
            r1.put(r6, r7)     // Catch:{ all -> 0x0257 }
            java.util.HashMap<java.lang.String, java.util.HashMap<com.didi.component.indriver.model.DriverData, java.lang.Integer>> r7 = r13.f14192j     // Catch:{ all -> 0x0257 }
            boolean r6 = r7.containsKey(r6)     // Catch:{ all -> 0x0257 }
            if (r6 != 0) goto L_0x005c
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0257 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0257 }
        L_0x005c:
            int r4 = r4 + 1
            goto L_0x001a
        L_0x005f:
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x0257 }
            r4.<init>()     // Catch:{ all -> 0x0257 }
            java.lang.String r5 = "order_id"
            java.lang.String r6 = com.didi.component.business.util.CarOrderHelper.getOrderId()     // Catch:{ all -> 0x0257 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0257 }
            java.lang.String r5 = "driver_id"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0257 }
            r4.put(r5, r0)     // Catch:{ all -> 0x0257 }
            java.lang.String r0 = "ibt_gp_carconfirm_negotiate_sw"
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r4)     // Catch:{ all -> 0x0257 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0257 }
            r0.<init>()     // Catch:{ all -> 0x0257 }
            android.widget.LinearLayout r4 = r13.f14190g     // Catch:{ all -> 0x0257 }
            int r4 = r4.getChildCount()     // Catch:{ all -> 0x0257 }
            java.util.HashMap<java.lang.String, java.util.HashMap<com.didi.component.indriver.model.DriverData, java.lang.Integer>> r5 = r13.f14192j     // Catch:{ all -> 0x0257 }
            java.util.Set r5 = r5.entrySet()     // Catch:{ all -> 0x0257 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0257 }
        L_0x0090:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0257 }
            if (r6 == 0) goto L_0x0114
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0257 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ all -> 0x0257 }
            java.lang.Object r7 = r6.getKey()     // Catch:{ all -> 0x0257 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0257 }
            boolean r7 = r1.containsKey(r7)     // Catch:{ all -> 0x0257 }
            if (r7 != 0) goto L_0x0090
            java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x0257 }
            java.util.HashMap r6 = (java.util.HashMap) r6     // Catch:{ all -> 0x0257 }
            java.util.Set r6 = r6.entrySet()     // Catch:{ all -> 0x0257 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0257 }
        L_0x00b6:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0257 }
            if (r7 == 0) goto L_0x0090
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0257 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ all -> 0x0257 }
            java.lang.Object r7 = r7.getValue()     // Catch:{ all -> 0x0257 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ all -> 0x0257 }
            int r7 = r7.intValue()     // Catch:{ all -> 0x0257 }
            if (r7 >= r4) goto L_0x00df
            android.widget.LinearLayout r8 = r13.f14190g     // Catch:{ all -> 0x0257 }
            android.view.View r8 = r8.getChildAt(r7)     // Catch:{ all -> 0x0257 }
            r13.m9922a((android.view.View) r8)     // Catch:{ all -> 0x0257 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0257 }
            r0.put(r8, r7)     // Catch:{ all -> 0x0257 }
            goto L_0x00b6
        L_0x00df:
            java.lang.String r8 = "dxt"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0257 }
            r6.<init>()     // Catch:{ all -> 0x0257 }
            java.lang.String r9 = "计算错误，无法删除 "
            r6.append(r9)     // Catch:{ all -> 0x0257 }
            r6.append(r7)     // Catch:{ all -> 0x0257 }
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x0257 }
            r6 = 6
            r10 = 0
            java.lang.String r11 = "com.didi.component.indriver.impl.IndriverView"
            r12 = 221(0xdd, float:3.1E-43)
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0257 }
            android.widget.LinearLayout r6 = r13.f14190g     // Catch:{ all -> 0x0257 }
            if (r6 == 0) goto L_0x010a
            android.widget.LinearLayout r6 = r13.f14190g     // Catch:{ all -> 0x0257 }
            r6.removeAllViews()     // Catch:{ all -> 0x0257 }
        L_0x010a:
            java.util.HashMap<java.lang.String, java.util.HashMap<com.didi.component.indriver.model.DriverData, java.lang.Integer>> r6 = r13.f14192j     // Catch:{ all -> 0x0257 }
            r6.clear()     // Catch:{ all -> 0x0257 }
            r0.clear()     // Catch:{ all -> 0x0257 }
            goto L_0x0090
        L_0x0114:
            java.util.Set r4 = r0.entrySet()     // Catch:{ all -> 0x0257 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0257 }
        L_0x011c:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0257 }
            if (r5 == 0) goto L_0x0162
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0257 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x0257 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x0257 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x0257 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x0257 }
            java.util.Set r6 = r2.entrySet()     // Catch:{ all -> 0x0257 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0257 }
        L_0x013a:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0257 }
            if (r7 == 0) goto L_0x011c
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0257 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ all -> 0x0257 }
            java.lang.Object r8 = r7.getValue()     // Catch:{ all -> 0x0257 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x0257 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x0257 }
            java.lang.Object r7 = r7.getKey()     // Catch:{ all -> 0x0257 }
            com.didi.component.indriver.model.DriverData r7 = (com.didi.component.indriver.model.DriverData) r7     // Catch:{ all -> 0x0257 }
            if (r5 > r8) goto L_0x013a
            int r8 = r8 + 1
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0257 }
            r2.put(r7, r8)     // Catch:{ all -> 0x0257 }
            goto L_0x013a
        L_0x0162:
            int r4 = r2.size()     // Catch:{ all -> 0x0257 }
            int r0 = r0.size()     // Catch:{ all -> 0x0257 }
            int r4 = r4 - r0
            com.didi.component.business.xpanelnew.XpNewHeightChangeModel r0 = new com.didi.component.business.xpanelnew.XpNewHeightChangeModel     // Catch:{ all -> 0x0257 }
            r0.<init>()     // Catch:{ all -> 0x0257 }
            java.lang.String r5 = "passenger_newXpanel+bargainingCard_logic+bargaining_card"
            r0.mCardID = r5     // Catch:{ all -> 0x0257 }
            android.view.View r5 = r13.f14185b     // Catch:{ all -> 0x0257 }
            int r5 = r5.getHeight()     // Catch:{ all -> 0x0257 }
            android.view.View r6 = r13.f14185b     // Catch:{ all -> 0x0257 }
            android.content.Context r6 = r6.getContext()     // Catch:{ all -> 0x0257 }
            r7 = 1124139008(0x43010000, float:129.0)
            int r6 = com.didi.component.business.util.UiUtils.dip2px(r6, r7)     // Catch:{ all -> 0x0257 }
            int r6 = r6 * r4
            int r5 = r5 + r6
            r0.mToHeight = r5     // Catch:{ all -> 0x0257 }
            java.lang.String r5 = "indriver"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0257 }
            r6.<init>()     // Catch:{ all -> 0x0257 }
            java.lang.String r7 = "size "
            r6.append(r7)     // Catch:{ all -> 0x0257 }
            r6.append(r4)     // Catch:{ all -> 0x0257 }
            java.lang.String r4 = "/ "
            r6.append(r4)     // Catch:{ all -> 0x0257 }
            android.view.View r4 = r13.f14185b     // Catch:{ all -> 0x0257 }
            int r4 = r4.getWidth()     // Catch:{ all -> 0x0257 }
            r6.append(r4)     // Catch:{ all -> 0x0257 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0257 }
            com.didi.component.common.util.GLog.m7965d(r5, r4)     // Catch:{ all -> 0x0257 }
            com.didi.component.core.event.BaseEventPublisher r4 = com.didi.component.core.event.BaseEventPublisher.getPublisher()     // Catch:{ all -> 0x0257 }
            java.lang.String r5 = "event_xpanel_new_card_height_change"
            r4.publish(r5, r0)     // Catch:{ all -> 0x0257 }
            java.util.HashMap<java.lang.String, java.util.HashMap<com.didi.component.indriver.model.DriverData, java.lang.Integer>> r0 = r13.f14192j     // Catch:{ all -> 0x0257 }
            int r0 = r0.size()     // Catch:{ all -> 0x0257 }
            if (r0 != 0) goto L_0x01e6
            r0 = 0
        L_0x01c1:
            int r2 = r14.size()     // Catch:{ all -> 0x0257 }
            if (r0 >= r2) goto L_0x0221
            com.didi.component.indriver.impl.IndriverItemView r2 = new com.didi.component.indriver.impl.IndriverItemView     // Catch:{ all -> 0x0257 }
            android.view.View r4 = r13.f14185b     // Catch:{ all -> 0x0257 }
            android.content.Context r4 = r4.getContext()     // Catch:{ all -> 0x0257 }
            r2.<init>(r4)     // Catch:{ all -> 0x0257 }
            com.didi.component.indriver.AbsIndriverPresenter r4 = r13.mPresenter     // Catch:{ all -> 0x0257 }
            r2.setPrisenter(r4)     // Catch:{ all -> 0x0257 }
            java.lang.Object r4 = r14.get(r0)     // Catch:{ all -> 0x0257 }
            com.didi.component.indriver.model.DriverData r4 = (com.didi.component.indriver.model.DriverData) r4     // Catch:{ all -> 0x0257 }
            r2.setData(r4)     // Catch:{ all -> 0x0257 }
            r13.m9923a(r2, r0)     // Catch:{ all -> 0x0257 }
            int r0 = r0 + 1
            goto L_0x01c1
        L_0x01e6:
            java.util.Set r14 = r2.entrySet()     // Catch:{ all -> 0x0257 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ all -> 0x0257 }
        L_0x01ee:
            boolean r0 = r14.hasNext()     // Catch:{ all -> 0x0257 }
            if (r0 == 0) goto L_0x0221
            java.lang.Object r0 = r14.next()     // Catch:{ all -> 0x0257 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0257 }
            java.lang.Object r2 = r0.getKey()     // Catch:{ all -> 0x0257 }
            com.didi.component.indriver.model.DriverData r2 = (com.didi.component.indriver.model.DriverData) r2     // Catch:{ all -> 0x0257 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0257 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0257 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0257 }
            com.didi.component.indriver.impl.IndriverItemView r4 = new com.didi.component.indriver.impl.IndriverItemView     // Catch:{ all -> 0x0257 }
            android.view.View r5 = r13.f14185b     // Catch:{ all -> 0x0257 }
            android.content.Context r5 = r5.getContext()     // Catch:{ all -> 0x0257 }
            r4.<init>(r5)     // Catch:{ all -> 0x0257 }
            com.didi.component.indriver.AbsIndriverPresenter r5 = r13.mPresenter     // Catch:{ all -> 0x0257 }
            r4.setPrisenter(r5)     // Catch:{ all -> 0x0257 }
            r4.setData(r2)     // Catch:{ all -> 0x0257 }
            r13.m9923a(r4, r0)     // Catch:{ all -> 0x0257 }
            goto L_0x01ee
        L_0x0221:
            java.util.HashMap<java.lang.String, java.util.HashMap<com.didi.component.indriver.model.DriverData, java.lang.Integer>> r14 = r13.f14192j     // Catch:{ all -> 0x0257 }
            r14.clear()     // Catch:{ all -> 0x0257 }
            java.util.HashMap<java.lang.String, java.util.HashMap<com.didi.component.indriver.model.DriverData, java.lang.Integer>> r14 = r13.f14192j     // Catch:{ all -> 0x0257 }
            r14.putAll(r1)     // Catch:{ all -> 0x0257 }
            java.util.HashMap<java.lang.String, java.util.HashMap<com.didi.component.indriver.model.DriverData, java.lang.Integer>> r14 = r13.f14192j     // Catch:{ all -> 0x0257 }
            int r14 = r14.size()     // Catch:{ all -> 0x0257 }
            r0 = 8
            if (r14 <= r15) goto L_0x0250
            com.didi.component.indriver.impl.IndriverItemFooterView r14 = r13.f14186c     // Catch:{ all -> 0x0257 }
            int r14 = r14.getVisibility()     // Catch:{ all -> 0x0257 }
            if (r14 != r0) goto L_0x0255
            com.didi.component.indriver.impl.IndriverItemFooterView r14 = r13.f14186c     // Catch:{ all -> 0x0257 }
            com.didi.component.indriver.AbsIndriverPresenter r15 = r13.mPresenter     // Catch:{ all -> 0x0257 }
            r14.setPrisenter(r15)     // Catch:{ all -> 0x0257 }
            com.didi.component.indriver.impl.IndriverItemFooterView r14 = r13.f14186c     // Catch:{ all -> 0x0257 }
            r15 = 1
            r14.setArrowExpand(r15)     // Catch:{ all -> 0x0257 }
            com.didi.component.indriver.impl.IndriverItemFooterView r14 = r13.f14186c     // Catch:{ all -> 0x0257 }
            r14.setVisibility(r3)     // Catch:{ all -> 0x0257 }
            goto L_0x0255
        L_0x0250:
            com.didi.component.indriver.impl.IndriverItemFooterView r14 = r13.f14186c     // Catch:{ all -> 0x0257 }
            r14.setVisibility(r0)     // Catch:{ all -> 0x0257 }
        L_0x0255:
            monitor-exit(r13)
            return
        L_0x0257:
            r14 = move-exception
            monitor-exit(r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.indriver.impl.IndriverView.setIndriverList(java.util.List, int):void");
    }

    /* renamed from: a */
    private void m9923a(final View view, int i) {
        if (this.f14190g.getChildCount() >= this.f14191h - 1) {
            this.f14190g.getLayoutParams().height = UiUtils.dip2px(this.f14185b.getContext(), 129.0f) * this.f14191h;
            this.f14190g.requestLayout();
        } else {
            this.f14190g.getLayoutParams().height = -2;
            this.f14190g.requestLayout();
        }
        this.f14190g.addView(view, i);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, UiUtils.dip2px(this.f14185b.getContext(), 129.0f)});
        ofInt.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    view.requestLayout();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(new MountainInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofInt, ofFloat});
        animatorSet.setDuration(300);
        animatorSet.start();
    }

    /* renamed from: a */
    private void m9922a(final View view) {
        if (view != null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{UiUtils.dip2px(this.f14185b.getContext(), 129.0f), 0});
            ofInt.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (view.getLayoutParams() != null) {
                        view.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        view.requestLayout();
                    }
                }
            });
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofInt, ofFloat});
            animatorSet.setDuration(300);
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (IndriverView.this.f14190g != null) {
                        IndriverView.this.f14190g.removeView(view);
                        if (IndriverView.this.f14190g.getChildCount() < IndriverView.this.f14191h) {
                            IndriverView.this.f14190g.getLayoutParams().height = -2;
                            IndriverView.this.f14190g.requestLayout();
                            IndriverView.this.f14186c.setVisibility(8);
                        } else if (IndriverView.this.f14186c.isArrowExpand()) {
                            IndriverView.this.f14190g.getLayoutParams().height = -2;
                            IndriverView.this.f14190g.requestLayout();
                        } else {
                            IndriverView.this.f14190g.getLayoutParams().height = UiUtils.dip2px(IndriverView.this.f14185b.getContext(), 129.0f) * IndriverView.this.f14190g.getChildCount();
                            IndriverView.this.f14190g.requestLayout();
                        }
                    }
                }
            });
            animatorSet.start();
        }
    }

    public void engineCommit(boolean z, boolean z2) {
        int childCount = this.f14190g.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f14190g.getChildAt(i);
            if (childAt instanceof IndriverItemView) {
                ((IndriverItemView) childAt).updateLoadingStatus(z);
            }
        }
    }

    public void expandView(boolean z) {
        int measuredHeight = this.f14190g.getMeasuredHeight();
        int childCount = this.f14190g.getChildCount();
        int dip2px = UiUtils.dip2px(this.f14185b.getContext(), 129.0f) * Math.min(childCount, this.f14191h);
        if (z) {
            dip2px = childCount * UiUtils.dip2px(this.f14185b.getContext(), 129.0f);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{measuredHeight, dip2px});
        ofInt.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (IndriverView.this.f14190g.getLayoutParams() != null) {
                    IndriverView.this.f14190g.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    IndriverView.this.f14190g.requestLayout();
                }
            }
        });
        ofInt.setDuration(400);
        ofInt.start();
    }

    public void removeItem(DriverData driverData) {
        HashMap hashMap;
        String str = driverData.did + driverData.bargainId;
        HashMap<String, HashMap<DriverData, Integer>> hashMap2 = this.f14192j;
        if (hashMap2 != null && hashMap2.containsKey(str) && (hashMap = this.f14192j.get(str)) != null) {
            for (Map.Entry value : hashMap.entrySet()) {
                View childAt = this.f14190g.getChildAt(((Integer) value.getValue()).intValue());
                if (childAt != null) {
                    XpNewHeightChangeModel xpNewHeightChangeModel = new XpNewHeightChangeModel();
                    xpNewHeightChangeModel.mCardID = "passenger_newXpanel+bargainingCard_logic+bargaining_card";
                    xpNewHeightChangeModel.mToHeight = this.f14185b.getHeight() - UiUtils.dip2px(this.f14185b.getContext(), 129.0f);
                    m9922a(childAt);
                    this.f14192j.remove(str);
                    if (this.f14192j.size() == 0) {
                        resetView();
                        BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPNAEL_NEW_REMOVE_CARD, "passenger_newXpanel+bargainingCard_logic+bargaining_card");
                        return;
                    }
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPNAEL_NEW_CARD_HEIGHT_CHANGE, xpNewHeightChangeModel);
                    return;
                }
            }
        }
    }
}
