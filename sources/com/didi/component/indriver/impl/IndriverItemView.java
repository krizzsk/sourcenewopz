package com.didi.component.indriver.impl;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.net.CarServerParam;
import com.didi.component.common.util.GLog;
import com.didi.component.common.widget.CircleImageView;
import com.didi.component.common.widget.CircleProgressBar;
import com.didi.component.indriver.AbsIndriverPresenter;
import com.didi.component.indriver.model.DriverData;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class IndriverItemView extends ConstraintLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f14157a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f14158b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CircleProgressBar f14159c;

    /* renamed from: d */
    private CircleImageView f14160d;

    /* renamed from: e */
    private TextView f14161e;

    /* renamed from: f */
    private TextView f14162f;

    /* renamed from: g */
    private TextView f14163g;

    /* renamed from: h */
    private TextView f14164h;

    /* renamed from: i */
    private TextView f14165i;

    /* renamed from: j */
    private TextView f14166j;

    /* renamed from: k */
    private TextView f14167k;

    /* renamed from: l */
    private ImageView f14168l;

    /* renamed from: m */
    private LottieAnimationView f14169m;
    protected AbsIndriverPresenter mPresenter;

    /* renamed from: n */
    private LottieAnimationView f14170n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public DriverData f14171o;

    /* renamed from: p */
    private CountDownTimer f14172p;

    /* renamed from: q */
    private int f14173q = 0;

    public IndriverItemView(Context context) {
        super(context);
        this.f14158b = context;
        m9902a(context);
    }

    public IndriverItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14158b = context;
        m9902a(context);
    }

    public IndriverItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14158b = context;
        m9902a(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CountDownTimer countDownTimer = this.f14172p;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f14172p = null;
        }
    }

    public void setPrisenter(AbsIndriverPresenter absIndriverPresenter) {
        this.mPresenter = absIndriverPresenter;
    }

    /* renamed from: a */
    private void m9902a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.indriver_item, this, true);
        this.f14157a = inflate;
        CircleProgressBar circleProgressBar = (CircleProgressBar) inflate.findViewById(R.id.avatar_progressBar);
        this.f14159c = circleProgressBar;
        circleProgressBar.setGradientStatus(false);
        this.f14159c.setBackColor(Color.parseColor("#ff8040"));
        this.f14159c.setGradientColor(this.f14157a.getResources().getColor(R.color.global_color_gropress_indriver), this.f14157a.getResources().getColor(R.color.global_color_gropress_indriver), 30);
        this.f14160d = (CircleImageView) this.f14157a.findViewById(R.id.avatar_iv);
        this.f14161e = (TextView) this.f14157a.findViewById(R.id.name_tv);
        this.f14162f = (TextView) this.f14157a.findViewById(R.id.prive_tv);
        this.f14163g = (TextView) this.f14157a.findViewById(R.id.star_tv);
        this.f14168l = (ImageView) this.f14157a.findViewById(R.id.star_iv);
        this.f14164h = (TextView) this.f14157a.findViewById(R.id.eda_tv);
        this.f14165i = (TextView) this.f14157a.findViewById(R.id.car_brand_tv);
        this.f14166j = (TextView) this.f14157a.findViewById(R.id.reject_tv);
        this.f14167k = (TextView) this.f14157a.findViewById(R.id.accept_tv);
        this.f14169m = (LottieAnimationView) this.f14157a.findViewById(R.id.reject_animation_view);
        this.f14170n = (LottieAnimationView) this.f14157a.findViewById(R.id.accept_animation_view);
        this.f14166j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (IndriverItemView.this.f14171o != null) {
                    IndriverItemView indriverItemView = IndriverItemView.this;
                    indriverItemView.m9904a(indriverItemView.f14171o.reject.link, IndriverItemView.this.f14171o.did, true);
                }
            }
        });
        this.f14167k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (IndriverItemView.this.f14171o != null) {
                    IndriverItemView indriverItemView = IndriverItemView.this;
                    indriverItemView.m9904a(indriverItemView.f14171o.accept.link, IndriverItemView.this.f14171o.did, false);
                }
            }
        });
        this.f14173q = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9904a(String str, String str2, final boolean z) {
        this.f14173q = z ? 1 : 2;
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", CarOrderHelper.getOrderId());
        hashMap.put(CarServerParam.PARAM_DRIVER_ID, str2);
        GlobalOmegaUtils.trackEvent(z ? "ibt_gp_carconfirm_negotiate_detail_reject_ck" : "ibt_gp_carconfirm_negotiate_detail_accept_ck", (Map<String, Object>) hashMap);
        if (z) {
            updateLoadingStatus(true);
        } else {
            AbsIndriverPresenter absIndriverPresenter = this.mPresenter;
            if (absIndriverPresenter != null) {
                absIndriverPresenter.engineCommit(true, true);
            }
        }
        ((Request) DRouter.build(str).putExtra("KEY_COMMIT_ID", "passenger_newXpanel+bargainingCard_logic+bargaining_card")).start(this.f14158b, new RouterCallback() {
            /* JADX WARNING: Removed duplicated region for block: B:26:0x0071  */
            /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResult(com.didi.drouter.router.Result r5) {
                /*
                    r4 = this;
                    java.lang.String r0 = "extension"
                    java.lang.String r1 = "data"
                    java.lang.String r2 = "KEY_CALLBACK"
                    java.lang.String r5 = r5.getString(r2)
                    boolean r2 = android.text.TextUtils.isEmpty(r5)
                    r3 = 0
                    if (r2 == 0) goto L_0x0029
                    boolean r5 = r7
                    if (r5 == 0) goto L_0x001b
                    com.didi.component.indriver.impl.IndriverItemView r5 = com.didi.component.indriver.impl.IndriverItemView.this
                    r5.updateLoadingStatus(r3)
                    goto L_0x0028
                L_0x001b:
                    com.didi.component.indriver.impl.IndriverItemView r5 = com.didi.component.indriver.impl.IndriverItemView.this
                    com.didi.component.indriver.AbsIndriverPresenter r5 = r5.mPresenter
                    if (r5 == 0) goto L_0x0028
                    com.didi.component.indriver.impl.IndriverItemView r5 = com.didi.component.indriver.impl.IndriverItemView.this
                    com.didi.component.indriver.AbsIndriverPresenter r5 = r5.mPresenter
                    r5.engineCommit(r3, r3)
                L_0x0028:
                    return
                L_0x0029:
                    org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x005e }
                    r2.<init>(r5)     // Catch:{ JSONException -> 0x005e }
                    boolean r5 = r2.has(r1)     // Catch:{ JSONException -> 0x005e }
                    if (r5 == 0) goto L_0x0062
                    org.json.JSONObject r5 = r2.optJSONObject(r1)     // Catch:{ JSONException -> 0x005e }
                    boolean r1 = r5.has(r0)     // Catch:{ JSONException -> 0x005e }
                    if (r1 == 0) goto L_0x0062
                    org.json.JSONObject r5 = r5.optJSONObject(r0)     // Catch:{ JSONException -> 0x005e }
                    if (r5 == 0) goto L_0x005c
                    java.lang.String r0 = "errno"
                    int r0 = r5.optInt(r0)     // Catch:{ JSONException -> 0x005e }
                    if (r0 == 0) goto L_0x005c
                    java.lang.String r0 = "errmsg"
                    java.lang.String r5 = r5.optString(r0)     // Catch:{ JSONException -> 0x005e }
                    com.didi.component.indriver.impl.IndriverItemView r0 = com.didi.component.indriver.impl.IndriverItemView.this     // Catch:{ JSONException -> 0x005e }
                    android.content.Context r0 = r0.f14158b     // Catch:{ JSONException -> 0x005e }
                    com.didi.sdk.util.ToastUtil.show((android.content.Context) r0, (java.lang.CharSequence) r5)     // Catch:{ JSONException -> 0x005e }
                    goto L_0x0062
                L_0x005c:
                    r5 = 1
                    goto L_0x0063
                L_0x005e:
                    r5 = move-exception
                    r5.printStackTrace()
                L_0x0062:
                    r5 = 0
                L_0x0063:
                    com.didi.component.indriver.impl.IndriverItemView r0 = com.didi.component.indriver.impl.IndriverItemView.this
                    android.view.View r0 = r0.f14157a
                    if (r0 == 0) goto L_0x008f
                    com.didi.component.indriver.impl.IndriverItemView r0 = com.didi.component.indriver.impl.IndriverItemView.this
                    com.didi.component.indriver.AbsIndriverPresenter r0 = r0.mPresenter
                    if (r0 == 0) goto L_0x008f
                    boolean r0 = r7
                    if (r0 == 0) goto L_0x0088
                    com.didi.component.indriver.impl.IndriverItemView r5 = com.didi.component.indriver.impl.IndriverItemView.this
                    r5.updateLoadingStatus(r3)
                    com.didi.component.indriver.impl.IndriverItemView r5 = com.didi.component.indriver.impl.IndriverItemView.this
                    com.didi.component.indriver.AbsIndriverPresenter r5 = r5.mPresenter
                    com.didi.component.indriver.impl.IndriverItemView r0 = com.didi.component.indriver.impl.IndriverItemView.this
                    com.didi.component.indriver.model.DriverData r0 = r0.f14171o
                    r5.removeItem(r0)
                    goto L_0x008f
                L_0x0088:
                    com.didi.component.indriver.impl.IndriverItemView r0 = com.didi.component.indriver.impl.IndriverItemView.this
                    com.didi.component.indriver.AbsIndriverPresenter r0 = r0.mPresenter
                    r0.engineCommit(r3, r5)
                L_0x008f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.component.indriver.impl.IndriverItemView.C60183.onResult(com.didi.drouter.router.Result):void");
            }
        });
    }

    public void setData(DriverData driverData) {
        this.f14171o = driverData;
        this.f14161e.setText(driverData.name);
        driverData.price.bindTextView(this.f14162f);
        if (!TextUtils.isEmpty(driverData.starUrl)) {
            Glide.with(this.f14158b.getApplicationContext()).load(driverData.starUrl).into(this.f14168l);
        }
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.f14158b).asBitmap().load(driverData.avatar).placeholder((int) R.drawable.driver_default_avatar)).error((int) R.drawable.driver_default_avatar)).into((ImageView) this.f14160d);
        StringBuilder sb = new StringBuilder();
        sb.append(driverData.star);
        if (!TextUtils.isEmpty(driverData.trips)) {
            sb.append(" · ");
            sb.append(driverData.trips);
        }
        this.f14163g.setText(sb.toString());
        driverData.eta.bindTextView(this.f14164h);
        this.f14165i.setText(driverData.carBrand);
        this.f14166j.setText(driverData.reject.text);
        this.f14167k.setText(driverData.accept.text);
        m9907b(true, false);
        m9905a(true, false);
        long abs = Math.abs(driverData.expireTs - System.currentTimeMillis());
        if (abs > driverData.ttl) {
            abs = driverData.ttl;
        }
        final long j = abs;
        long j2 = driverData.ttl / 100;
        GLog.m7968e("dxt", "timeout = " + j + "/ countDownInterval " + j2);
        final DriverData driverData2 = driverData;
        this.f14172p = new CountDownTimer(j, j2) {
            public void onTick(long j) {
                if (IndriverItemView.this.f14157a != null && IndriverItemView.this.f14159c != null) {
                    IndriverItemView.this.f14159c.setPercent((float) (1.0d - ((((double) j) * 1.0d) / ((double) j))));
                }
            }

            public void onFinish() {
                if (IndriverItemView.this.f14157a != null && IndriverItemView.this.mPresenter != null) {
                    IndriverItemView.this.mPresenter.removeItem(driverData2);
                }
            }
        }.start();
    }

    public void updateLoadingStatus(boolean z) {
        if (z) {
            int i = this.f14173q;
            if (i == 1) {
                m9907b(false, true);
                m9905a(false, false);
            } else if (i == 2) {
                m9907b(false, false);
                m9905a(false, true);
            } else {
                m9907b(false, false);
                m9905a(false, false);
            }
        } else {
            this.f14173q = 0;
            m9907b(true, false);
            m9905a(true, false);
        }
    }

    /* renamed from: a */
    private void m9905a(boolean z, boolean z2) {
        if (z2) {
            this.f14170n.setRepeatCount(-1);
            this.f14170n.setVisibility(0);
            this.f14170n.playAnimation();
            this.f14167k.setVisibility(4);
            return;
        }
        this.f14167k.setVisibility(0);
        this.f14167k.setEnabled(z);
        this.f14167k.setTextColor(Color.parseColor(z ? "#ffffffff" : "#D8DADC"));
        if (z) {
            this.f14167k.setBackground(DidiThemeManager.getIns().getResPicker(this.f14158b).getDrawable(R.attr.global_overall_main_button_selector));
        } else {
            this.f14167k.setBackground(DidiThemeManager.getIns().getResPicker(this.f14158b).getDrawable(R.attr.global_overall_secondary_button_selector));
        }
        this.f14170n.cancelAnimation();
        this.f14170n.setVisibility(4);
    }

    /* renamed from: b */
    private void m9907b(boolean z, boolean z2) {
        if (z2) {
            this.f14169m.setRepeatCount(-1);
            this.f14169m.setVisibility(0);
            this.f14169m.playAnimation();
            this.f14166j.setVisibility(4);
            return;
        }
        this.f14166j.setVisibility(0);
        this.f14166j.setEnabled(z);
        this.f14166j.setTextColor(Color.parseColor(z ? "#ff000000" : "#D8DADC"));
        this.f14169m.cancelAnimation();
        this.f14169m.setVisibility(4);
    }
}
