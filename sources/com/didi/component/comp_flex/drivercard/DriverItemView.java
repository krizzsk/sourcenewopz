package com.didi.component.comp_flex.drivercard;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.FormatUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.common.net.CarServerParam;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.widget.CircleImageView;
import com.didi.component.comp_flex.drivercard.FlexTemplateDriverModel;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverItemView extends FrameLayout {

    /* renamed from: c */
    private static final String f12144c = "[";

    /* renamed from: d */
    private static final String f12145d = "]";

    /* renamed from: A */
    private long f12146A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public Map<String, Object> f12147B = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f12148a = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f12149b;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f12150e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ProgressBar f12151f;

    /* renamed from: g */
    private CircleImageView f12152g;

    /* renamed from: h */
    private TextView f12153h;

    /* renamed from: i */
    private TextView f12154i;

    /* renamed from: j */
    private TextView f12155j;

    /* renamed from: k */
    private TextView f12156k;

    /* renamed from: l */
    private TextView f12157l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public TextView f12158m;

    /* renamed from: n */
    private ImageView f12159n;

    /* renamed from: o */
    private ImageView f12160o;

    /* renamed from: p */
    private View f12161p;

    /* renamed from: q */
    private LinearLayout f12162q;

    /* renamed from: r */
    private TextView f12163r;

    /* renamed from: s */
    private TextView f12164s;

    /* renamed from: t */
    private LottieAnimationView f12165t;

    /* renamed from: u */
    private LottieAnimationView f12166u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public FlexTemplateDriverModel.TemplateDriverData f12167v;

    /* renamed from: w */
    private CountDownTimer f12168w;

    /* renamed from: x */
    private int f12169x = 0;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public OnOperationDriverCardListener f12170y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public long f12171z;

    public interface OnOperationDriverCardListener {
        void engineCommit(boolean z);

        void removeItem(FlexTemplateDriverModel.TemplateDriverData templateDriverData);
    }

    public DriverItemView(Context context) {
        super(context);
        this.f12149b = context;
        m8212a(context);
    }

    public DriverItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12149b = context;
        m8212a(context);
    }

    public DriverItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12149b = context;
        m8212a(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f12148a.info("onDetachedFromWindow: DriverItemView ", new Object[0]);
        CountDownTimer countDownTimer = this.f12168w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f12168w = null;
        }
    }

    public void setListener(OnOperationDriverCardListener onOperationDriverCardListener) {
        this.f12170y = onOperationDriverCardListener;
    }

    /* renamed from: a */
    private void m8212a(Context context) {
        setBackground(ContextCompat.getDrawable(this.f12149b, R.drawable.flex_list_card_common_bg));
        View inflate = LayoutInflater.from(context).inflate(R.layout.flex_driver_match_item_layout, this, false);
        this.f12150e = inflate;
        this.f12151f = (ProgressBar) inflate.findViewById(R.id.avatar_progressBar);
        this.f12152g = (CircleImageView) this.f12150e.findViewById(R.id.avatar_iv);
        this.f12153h = (TextView) this.f12150e.findViewById(R.id.fee_price);
        this.f12154i = (TextView) this.f12150e.findViewById(R.id.score_tv);
        this.f12161p = this.f12150e.findViewById(R.id.flex_driver_score_layout);
        this.f12155j = (TextView) this.f12150e.findViewById(R.id.eta_distance);
        this.f12156k = (TextView) this.f12150e.findViewById(R.id.eda);
        this.f12157l = (TextView) this.f12150e.findViewById(R.id.car_brand_tv);
        this.f12159n = (ImageView) this.f12150e.findViewById(R.id.score_iv);
        this.f12162q = (LinearLayout) this.f12150e.findViewById(R.id.flex_btn_container);
        this.f12160o = (ImageView) this.f12150e.findViewById(R.id.flex_car_img);
        this.f12158m = (TextView) this.f12150e.findViewById(R.id.countdown_tv);
        this.f12169x = 0;
        addView(this.f12150e);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8214a(final String str, String str2, final boolean z) {
        this.f12169x = z ? 1 : 2;
        OnOperationDriverCardListener onOperationDriverCardListener = this.f12170y;
        if (onOperationDriverCardListener != null) {
            onOperationDriverCardListener.engineCommit(true);
        }
        this.f12147B.put("tag", z ? "reject" : "accept");
        this.f12147B.put("time", Long.valueOf(System.currentTimeMillis() - this.f12146A));
        GlobalOmegaUtils.trackEvent("ibt_gp_wait_drivercard_ck");
        ((Request) DRouter.build(str).putExtra("KEY_COMMIT_SCENE", XERequestKey.SCENE_TRIP)).start(this.f12149b, new RouterCallback() {
            /* JADX WARNING: Removed duplicated region for block: B:23:0x008f  */
            /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResult(com.didi.drouter.router.Result r7) {
                /*
                    r6 = this;
                    java.lang.String r0 = "extension"
                    java.lang.String r1 = "data"
                    com.didi.component.comp_flex.drivercard.DriverItemView r2 = com.didi.component.comp_flex.drivercard.DriverItemView.this
                    com.didi.sdk.logging.Logger r2 = r2.f12148a
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "onResult: 司机卡片 数据提交 link "
                    r3.append(r4)
                    java.lang.String r4 = r5
                    r3.append(r4)
                    java.lang.String r4 = " reject "
                    r3.append(r4)
                    boolean r4 = r7
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    r4 = 0
                    java.lang.Object[] r5 = new java.lang.Object[r4]
                    r2.info((java.lang.String) r3, (java.lang.Object[]) r5)
                    java.lang.String r2 = "KEY_CALLBACK"
                    java.lang.String r7 = r7.getString(r2)
                    boolean r2 = android.text.TextUtils.isEmpty(r7)
                    if (r2 == 0) goto L_0x004b
                    com.didi.component.comp_flex.drivercard.DriverItemView r7 = com.didi.component.comp_flex.drivercard.DriverItemView.this
                    com.didi.component.comp_flex.drivercard.DriverItemView$OnOperationDriverCardListener r7 = r7.f12170y
                    if (r7 == 0) goto L_0x004a
                    com.didi.component.comp_flex.drivercard.DriverItemView r7 = com.didi.component.comp_flex.drivercard.DriverItemView.this
                    com.didi.component.comp_flex.drivercard.DriverItemView$OnOperationDriverCardListener r7 = r7.f12170y
                    r7.engineCommit(r4)
                L_0x004a:
                    return
                L_0x004b:
                    org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0082 }
                    r2.<init>(r7)     // Catch:{ JSONException -> 0x0082 }
                    boolean r7 = r2.has(r1)     // Catch:{ JSONException -> 0x0082 }
                    if (r7 == 0) goto L_0x0086
                    org.json.JSONObject r7 = r2.optJSONObject(r1)     // Catch:{ JSONException -> 0x0082 }
                    if (r7 == 0) goto L_0x0086
                    boolean r1 = r7.has(r0)     // Catch:{ JSONException -> 0x0082 }
                    if (r1 == 0) goto L_0x0086
                    org.json.JSONObject r7 = r7.optJSONObject(r0)     // Catch:{ JSONException -> 0x0082 }
                    if (r7 == 0) goto L_0x0080
                    java.lang.String r0 = "errno"
                    int r0 = r7.optInt(r0)     // Catch:{ JSONException -> 0x0082 }
                    if (r0 == 0) goto L_0x0080
                    java.lang.String r0 = "errmsg"
                    java.lang.String r7 = r7.optString(r0)     // Catch:{ JSONException -> 0x0082 }
                    com.didi.component.comp_flex.drivercard.DriverItemView r0 = com.didi.component.comp_flex.drivercard.DriverItemView.this     // Catch:{ JSONException -> 0x0082 }
                    android.content.Context r0 = r0.f12149b     // Catch:{ JSONException -> 0x0082 }
                    com.didi.global.globaluikit.toast.LEGOToastHelper.showToast(r0, r7)     // Catch:{ JSONException -> 0x0082 }
                    goto L_0x0086
                L_0x0080:
                    r7 = 1
                    goto L_0x0087
                L_0x0082:
                    r7 = move-exception
                    r7.printStackTrace()
                L_0x0086:
                    r7 = 0
                L_0x0087:
                    com.didi.component.comp_flex.drivercard.DriverItemView r0 = com.didi.component.comp_flex.drivercard.DriverItemView.this
                    com.didi.component.comp_flex.drivercard.DriverItemView$OnOperationDriverCardListener r0 = r0.f12170y
                    if (r0 == 0) goto L_0x00ad
                    com.didi.component.comp_flex.drivercard.DriverItemView r0 = com.didi.component.comp_flex.drivercard.DriverItemView.this
                    com.didi.component.comp_flex.drivercard.DriverItemView$OnOperationDriverCardListener r0 = r0.f12170y
                    r0.engineCommit(r4)
                    if (r7 == 0) goto L_0x00ad
                    boolean r7 = r7
                    if (r7 == 0) goto L_0x00ad
                    com.didi.component.comp_flex.drivercard.DriverItemView r7 = com.didi.component.comp_flex.drivercard.DriverItemView.this
                    com.didi.component.comp_flex.drivercard.DriverItemView$OnOperationDriverCardListener r7 = r7.f12170y
                    com.didi.component.comp_flex.drivercard.DriverItemView r0 = com.didi.component.comp_flex.drivercard.DriverItemView.this
                    com.didi.component.comp_flex.drivercard.FlexTemplateDriverModel$TemplateDriverData r0 = r0.f12167v
                    r7.removeItem(r0)
                L_0x00ad:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.component.comp_flex.drivercard.DriverItemView.C49511.onResult(com.didi.drouter.router.Result):void");
            }
        });
    }

    public void setData(final FlexTemplateDriverModel.TemplateDriverData templateDriverData) {
        if (templateDriverData != null) {
            this.f12167v = templateDriverData;
            if (!TextUtils.isEmpty(templateDriverData.did)) {
                this.f12147B.put(CarServerParam.PARAM_DRIVER_ID, templateDriverData.did);
            }
            if (!TextUtils.isEmpty(templateDriverData.bargainId)) {
                this.f12147B.put("budget_id", templateDriverData.bargainId);
            }
            if (templateDriverData.price != null && !TextUtils.isEmpty(templateDriverData.price.getContent())) {
                templateDriverData.price.bindTextView(this.f12153h);
                this.f12147B.put("price", templateDriverData.price.getContent());
            }
            if (templateDriverData.carBrand != null && !TextUtils.isEmpty(templateDriverData.carBrand.getContent())) {
                templateDriverData.carBrand.bindTextView(this.f12157l);
            }
            if (templateDriverData.eta != null && !TextUtils.isEmpty(templateDriverData.eta.getContent())) {
                templateDriverData.eta.bindTextView(this.f12155j);
                this.f12147B.put("eta", templateDriverData.eta.getContent());
            }
            if (templateDriverData.eda != null && !TextUtils.isEmpty(templateDriverData.eda.getContent())) {
                templateDriverData.eda.bindTextView(this.f12156k);
                this.f12147B.put("eda", templateDriverData.eda.getContent());
            }
            if (!TextUtils.isEmpty(templateDriverData.carImg)) {
                ((RequestBuilder) ((RequestBuilder) Glide.with(this.f12149b).asBitmap().load(templateDriverData.carImg).placeholder((int) R.drawable.flex_driver_default_car)).error((int) R.drawable.flex_driver_default_car)).into(this.f12160o);
            }
            if (!TextUtils.isEmpty(templateDriverData.avatar)) {
                ((RequestBuilder) ((RequestBuilder) Glide.with(this.f12149b).asBitmap().load(templateDriverData.avatar).placeholder((int) R.drawable.flex_driver_avatar)).error((int) R.drawable.flex_driver_avatar)).into((ImageView) this.f12152g);
            }
            boolean z = false;
            if (templateDriverData.star != 0.0d) {
                this.f12161p.setVisibility(0);
                if (!TextUtils.isEmpty(templateDriverData.starUrl)) {
                    ((RequestBuilder) ((RequestBuilder) Glide.with(this.f12149b.getApplicationContext()).load(templateDriverData.starUrl).placeholder((int) R.drawable.flex_driver_five_star)).error((int) R.drawable.flex_driver_five_star)).into(this.f12159n);
                }
                this.f12147B.put("driver_star", Double.valueOf(templateDriverData.star));
                this.f12154i.setText(String.valueOf(templateDriverData.star));
            } else {
                this.f12161p.setVisibility(8);
            }
            if (templateDriverData.optionBtns != null && templateDriverData.optionBtns.size() == 2) {
                for (int i = 0; i < templateDriverData.optionBtns.size(); i++) {
                    final FlexTemplateDriverModel.OptionBtn optionBtn = templateDriverData.optionBtns.get(i);
                    if (optionBtn != null) {
                        View inflate = LayoutInflater.from(this.f12149b).inflate(R.layout.flex_driver_btn_layout, this.f12162q, false);
                        if (i == 1) {
                            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = UIUtils.dip2pxInt(this.f12149b, 15.0f);
                            }
                        }
                        this.f12162q.addView(inflate);
                        TextView textView = (TextView) inflate.findViewById(R.id.flex_driver_btn);
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.flex_driver_animation_view);
                        if (optionBtn.type == 0) {
                            this.f12163r = textView;
                            this.f12165t = lottieAnimationView;
                            textView.setText(optionBtn.text);
                            this.f12163r.setBackground(DidiThemeManager.getIns().getResPicker(this.f12149b).getDrawable(R.attr.global_overall_secondary_button_selector));
                            this.f12163r.setTextColor(ContextCompat.getColorStateList(this.f12149b, DidiThemeManager.getIns().getResPicker(this.f12149b).getResIdByTheme(R.attr.global_secondary_button_text_color_selector)));
                            this.f12165t.setBackground(DidiThemeManager.getIns().getResPicker(this.f12149b).getDrawable(R.attr.global_overall_secondary_button_selector));
                            this.f12163r.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    AutoTrackHelper.trackViewOnClick(view);
                                    DriverItemView.this.m8214a(optionBtn.link, templateDriverData.did, true);
                                }
                            });
                        } else {
                            this.f12164s = textView;
                            this.f12166u = lottieAnimationView;
                            textView.setText(optionBtn.text);
                            this.f12164s.setBackground(DidiThemeManager.getIns().getResPicker(this.f12149b).getDrawable(R.attr.global_overall_main_button_selector));
                            this.f12164s.setTextColor(ContextCompat.getColorStateList(this.f12149b, DidiThemeManager.getIns().getResPicker(this.f12149b).getResIdByTheme(R.attr.global_main_button_text_color_selector)));
                            this.f12166u.setBackground(DidiThemeManager.getIns().getResPicker(this.f12149b).getDrawable(R.attr.global_overall_main_button_selector));
                            this.f12164s.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    AutoTrackHelper.trackViewOnClick(view);
                                    DriverItemView.this.m8214a(optionBtn.link, templateDriverData.did, false);
                                }
                            });
                        }
                    }
                }
            }
            m8217b(true, false);
            m8215a(true, false);
            long j = templateDriverData.offset;
            this.f12146A = System.currentTimeMillis();
            long j2 = templateDriverData.expireTs - (this.f12146A + j);
            this.f12171z = j2;
            if (j2 > templateDriverData.ttl) {
                this.f12171z = templateDriverData.ttl;
            }
            if (this.f12171z <= 0) {
                this.f12171z = 0;
            }
            long j3 = templateDriverData.ttl / 100;
            if (this.f12171z <= 0) {
                View view = this.f12150e;
                return;
            }
            final LEGORichInfo lEGORichInfo = templateDriverData.countdownText;
            if (lEGORichInfo != null && !TextUtils.isEmpty(lEGORichInfo.getContent())) {
                this.f12158m.setVisibility(0);
                final String content = lEGORichInfo.getContent();
                int indexOf = content.indexOf("[");
                int indexOf2 = content.indexOf("]");
                String formatTime = FormatUtils.formatTime(this.f12171z / 1000);
                String substring = content.substring(indexOf, indexOf2 + 1);
                int length = formatTime.length() - substring.length();
                content.replace(substring, formatTime);
                if (length != 0) {
                    List<LEGORichInfo.RichInfo> infoList = lEGORichInfo.getInfoList();
                    if (!CollectionUtil.isEmpty((Collection<?>) infoList)) {
                        for (LEGORichInfo.RichInfo next : infoList) {
                            if (next.start == indexOf) {
                                next.length += length;
                                z = true;
                            } else if (z) {
                                next.start += length;
                            }
                        }
                    }
                }
                lEGORichInfo.setText(content.replace(substring, FormatUtils.formatTime((long) ((int) (this.f12171z / 1000)))));
                lEGORichInfo.bindTextView(this.f12158m);
                final FlexTemplateDriverModel.TemplateDriverData templateDriverData2 = templateDriverData;
                final String str = substring;
                this.f12168w = new CountDownTimer(this.f12171z, 100) {
                    int times = 0;

                    public void onTick(long j) {
                        if (!(DriverItemView.this.f12150e == null || DriverItemView.this.f12151f == null)) {
                            DriverItemView.this.f12151f.setProgress((int) (((((double) j) * 1.0d) / ((double) templateDriverData2.ttl)) * 100.0d));
                        }
                        int i = this.times;
                        if (i < 9) {
                            this.times = i + 1;
                            return;
                        }
                        this.times = 0;
                        lEGORichInfo.setText(content.replace(str, FormatUtils.formatTime((long) ((int) (j / 1000)))));
                        lEGORichInfo.bindTextView(DriverItemView.this.f12158m);
                    }

                    public void onFinish() {
                        if (!(DriverItemView.this.f12150e == null || DriverItemView.this.f12170y == null)) {
                            DriverItemView.this.f12170y.removeItem(templateDriverData2);
                        }
                        DriverItemView.this.f12147B.put("time", Long.valueOf(DriverItemView.this.f12171z));
                        GlobalOmegaUtils.trackEvent("ibt_gp_wait_drivercard_timeout_sw");
                    }
                }.start();
            }
            GlobalOmegaUtils.trackEvent("ibt_gp_wait_drivercard_sw", this.f12147B);
        }
    }

    public void updateLoadingStatus(boolean z) {
        if (z) {
            int i = this.f12169x;
            if (i == 1) {
                m8217b(false, true);
                m8215a(false, false);
            } else if (i == 2) {
                m8217b(false, false);
                m8215a(false, true);
            } else {
                m8217b(false, false);
                m8215a(false, false);
            }
        } else {
            this.f12169x = 0;
            m8217b(true, false);
            m8215a(true, false);
        }
    }

    /* renamed from: a */
    private void m8215a(boolean z, boolean z2) {
        if (z2) {
            this.f12166u.setRepeatCount(-1);
            this.f12166u.setVisibility(0);
            this.f12166u.playAnimation();
            this.f12164s.setVisibility(4);
            return;
        }
        this.f12164s.setVisibility(0);
        this.f12164s.setEnabled(z);
        this.f12166u.cancelAnimation();
        this.f12166u.setVisibility(4);
    }

    /* renamed from: b */
    private void m8217b(boolean z, boolean z2) {
        if (z2) {
            this.f12165t.setRepeatCount(-1);
            this.f12165t.setVisibility(0);
            this.f12165t.playAnimation();
            this.f12163r.setVisibility(4);
            return;
        }
        this.f12163r.setVisibility(0);
        this.f12163r.setEnabled(z);
        this.f12165t.cancelAnimation();
        this.f12165t.setVisibility(4);
    }
}
