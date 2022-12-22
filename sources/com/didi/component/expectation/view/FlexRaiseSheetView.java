package com.didi.component.expectation.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.common.util.DecimalUtils;
import com.didi.component.common.view.AmountDecimalEditText;
import com.didi.component.expectation.model.FlexRaiseSheet;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.view.SimplePopupBase;
import com.didichuxing.drtl.tookit.DRtlToolkit;
import com.global.didi.elvish.Elvish;
import com.taxis99.R;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class FlexRaiseSheetView extends ConstraintLayout {

    /* renamed from: a */
    private final Logger f13701a = LoggerFactory.getLogger("FlexRaiseSheetView");

    /* renamed from: b */
    private View f13702b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f13703c;

    /* renamed from: d */
    private TextView f13704d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f13705e;

    /* renamed from: f */
    private TextView f13706f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f13707g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f13708h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public TextView f13709i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AmountDecimalEditText f13710j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f13711k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public FlexRaiseSheet f13712l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public SimplePopupBase f13713m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public BigDecimal f13714n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public BigDecimal f13715o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public BigDecimal f13716p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public BigDecimal f13717q;

    /* renamed from: r */
    private String f13718r;

    public FlexRaiseSheetView(Context context) {
        super(context);
        m9458a(context);
    }

    public FlexRaiseSheetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9458a(context);
    }

    public FlexRaiseSheetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9458a(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* renamed from: a */
    private void m9458a(Context context) {
        this.f13703c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_flex_raise_sheet_layout, this, true);
        this.f13702b = inflate;
        this.f13704d = (TextView) inflate.findViewById(R.id.bargain_card_title);
        this.f13705e = (TextView) this.f13702b.findViewById(R.id.bargain_reduce_price_btn);
        this.f13706f = (TextView) this.f13702b.findViewById(R.id.bargain_currency_symbol);
        this.f13710j = (AmountDecimalEditText) this.f13702b.findViewById(R.id.price_input_et);
        if (DRtlToolkit.rtl()) {
            this.f13710j.setLayoutDirection(1);
        }
        this.f13711k = this.f13702b.findViewById(R.id.price_cursor_bottomline);
        this.f13707g = (TextView) this.f13702b.findViewById(R.id.bargain_increase_price_btn);
        this.f13708h = (TextView) this.f13702b.findViewById(R.id.discount_tips);
        this.f13709i = (TextView) this.f13702b.findViewById(R.id.flex_confirm_price_btn);
        this.f13705e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                String standardAmountString = DecimalUtils.getStandardAmountString(FlexRaiseSheetView.this.f13710j.getText().toString());
                BigDecimal subtract = new BigDecimal(standardAmountString).subtract(FlexRaiseSheetView.this.f13717q);
                FlexRaiseSheetView flexRaiseSheetView = FlexRaiseSheetView.this;
                flexRaiseSheetView.m9464b("reduce price " + subtract.toString() + "/ " + FlexRaiseSheetView.this.f13714n);
                if (subtract.compareTo(FlexRaiseSheetView.this.f13714n) < 0) {
                    FlexRaiseSheetView.this.f13705e.setEnabled(false);
                    return;
                }
                FlexRaiseSheetView.this.m9457a(2, standardAmountString, subtract.toString());
                FlexRaiseSheetView.this.f13707g.setEnabled(true);
                FlexRaiseSheetView.this.f13710j.setText(subtract.toString());
                if (subtract.compareTo(FlexRaiseSheetView.this.f13714n) == 0) {
                    FlexRaiseSheetView.this.f13709i.setEnabled(false);
                }
            }
        });
        this.f13707g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                String standardAmountString = DecimalUtils.getStandardAmountString(FlexRaiseSheetView.this.f13710j.getText().toString());
                BigDecimal add = new BigDecimal(standardAmountString).add(FlexRaiseSheetView.this.f13716p);
                FlexRaiseSheetView flexRaiseSheetView = FlexRaiseSheetView.this;
                flexRaiseSheetView.m9464b("add price " + add.toString() + "/ " + FlexRaiseSheetView.this.f13714n);
                if (add.compareTo(FlexRaiseSheetView.this.f13715o) > 0) {
                    FlexRaiseSheetView.this.f13707g.setEnabled(false);
                    return;
                }
                FlexRaiseSheetView.this.m9457a(1, standardAmountString, add.toString());
                FlexRaiseSheetView.this.f13705e.setEnabled(true);
                if (add.compareTo(FlexRaiseSheetView.this.f13714n) == 0) {
                    FlexRaiseSheetView.this.f13709i.setEnabled(false);
                }
                FlexRaiseSheetView.this.f13710j.setText(add.toString());
            }
        });
        this.f13709i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FlexRaiseSheetView.this.f13709i.setEnabled(false);
                String standardAmountString = DecimalUtils.getStandardAmountString(FlexRaiseSheetView.this.f13710j.getText().toString());
                FlexRaiseSheetView.this.m9461a(standardAmountString);
                HashMap hashMap = new HashMap();
                hashMap.put("k", "click");
                hashMap.put(RavenKey.VERSION, "raisefare_confirm");
                hashMap.put("price", FlexRaiseSheetView.this.f13714n);
                hashMap.put("suggest_price", standardAmountString);
                GlobalOmegaUtils.trackEvent("ibt_gp_wait_raisefare_confirm_ck", (Map<String, Object>) hashMap);
            }
        });
        this.f13711k.setEnabled(false);
        this.f13710j.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                FlexRaiseSheetView.this.f13711k.setEnabled(z);
                FlexRaiseSheetView.this.f13710j.setCursorVisible(z);
                if (z) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("k", "click");
                    hashMap.put(RavenKey.VERSION, "raisefare_change_input");
                    hashMap.put("price", FlexRaiseSheetView.this.f13714n);
                    GlobalOmegaUtils.trackEvent("ibt_gp_wait_raisefare_change_input_ck", (Map<String, Object>) hashMap);
                }
            }
        });
        this.f13710j.setCustomizedAfterTextChangeListener(new AmountDecimalEditText.CustomizedAfterTextChangeListener() {
            public void afterTextChanged(String str) {
                FlexRaiseSheetView.this.f13709i.setEnabled(str != null && !TextUtils.isEmpty(str));
                if (TextUtils.isEmpty(str)) {
                    FlexRaiseSheetView.this.f13705e.setEnabled(false);
                    FlexRaiseSheetView.this.f13707g.setEnabled(false);
                    return;
                }
                BigDecimal bigDecimal = new BigDecimal(DecimalUtils.getStandardAmountString(str));
                if (bigDecimal.compareTo(FlexRaiseSheetView.this.f13714n) < 0) {
                    FlexRaiseSheetView.this.f13708h.setVisibility(0);
                    FlexRaiseSheetView.this.f13712l.min_tips.bindTextView(FlexRaiseSheetView.this.f13708h);
                    FlexRaiseSheetView.this.f13705e.setEnabled(false);
                    FlexRaiseSheetView.this.f13709i.setEnabled(false);
                } else if (bigDecimal.compareTo(FlexRaiseSheetView.this.f13715o) > 0) {
                    FlexRaiseSheetView.this.f13707g.setEnabled(false);
                    FlexRaiseSheetView.this.f13708h.setVisibility(0);
                    FlexRaiseSheetView.this.f13712l.max_tips.bindTextView(FlexRaiseSheetView.this.f13708h);
                    FlexRaiseSheetView.this.f13709i.setEnabled(false);
                } else {
                    FlexRaiseSheetView.this.f13708h.setVisibility(8);
                    FlexRaiseSheetView.this.f13709i.setEnabled(true);
                    FlexRaiseSheetView.this.f13707g.setEnabled(true);
                    FlexRaiseSheetView.this.f13705e.setEnabled(true);
                    if (bigDecimal.subtract(FlexRaiseSheetView.this.f13717q).compareTo(FlexRaiseSheetView.this.f13714n) < 0) {
                        FlexRaiseSheetView.this.f13705e.setEnabled(false);
                    } else if (bigDecimal.add(FlexRaiseSheetView.this.f13716p).compareTo(FlexRaiseSheetView.this.f13715o) > 0) {
                        FlexRaiseSheetView.this.f13707g.setEnabled(false);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9457a(int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put(RavenKey.VERSION, "raisefare_change");
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("price", str);
        hashMap.put("suggest_price", str2);
        GlobalOmegaUtils.trackEvent("ibt_gp_wait_raisefare_change_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9461a(String str) {
        m9464b("price commit " + str + "/ link " + this.f13718r);
        try {
            if (!TextUtils.isEmpty(this.f13718r)) {
                String str2 = this.f13718r;
                String queryParameter = Uri.parse(str2).getQueryParameter("query");
                if (!TextUtils.isEmpty(queryParameter)) {
                    String substring = str2.substring(0, str2.indexOf("?"));
                    JSONObject jSONObject = new JSONObject(URLDecoder.decode(queryParameter, "UTF-8"));
                    jSONObject.put("new_price", str);
                    ((Request) DRouter.build(substring + "?query=" + URLEncoder.encode(jSONObject.toString(), "UTF-8")).putExtra("KEY_COMMIT_SCENE", XERequestKey.SCENE_TRIP)).start(this.f13703c, new RouterCallback() {
                        /* JADX WARNING: Removed duplicated region for block: B:22:0x006f  */
                        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void onResult(com.didi.drouter.router.Result r6) {
                            /*
                                r5 = this;
                                java.lang.String r0 = "extension"
                                java.lang.String r1 = "data"
                                java.lang.String r2 = "KEY_CALLBACK"
                                java.lang.String r6 = r6.getString(r2)
                                boolean r2 = android.text.TextUtils.isEmpty(r6)
                                r3 = 1
                                if (r2 == 0) goto L_0x0022
                                com.didi.component.expectation.view.FlexRaiseSheetView r6 = com.didi.component.expectation.view.FlexRaiseSheetView.this
                                java.lang.String r0 = "xengine commit failed"
                                r6.m9464b((java.lang.String) r0)
                                com.didi.component.expectation.view.FlexRaiseSheetView r6 = com.didi.component.expectation.view.FlexRaiseSheetView.this
                                android.widget.TextView r6 = r6.f13709i
                                r6.setEnabled(r3)
                                return
                            L_0x0022:
                                r2 = 0
                                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0061 }
                                r4.<init>(r6)     // Catch:{ JSONException -> 0x0061 }
                                boolean r6 = r4.has(r1)     // Catch:{ JSONException -> 0x0061 }
                                if (r6 == 0) goto L_0x005e
                                org.json.JSONObject r6 = r4.optJSONObject(r1)     // Catch:{ JSONException -> 0x0061 }
                                boolean r1 = r6.has(r0)     // Catch:{ JSONException -> 0x0061 }
                                if (r1 == 0) goto L_0x005e
                                org.json.JSONObject r6 = r6.optJSONObject(r0)     // Catch:{ JSONException -> 0x0061 }
                                if (r6 == 0) goto L_0x005f
                                java.lang.String r0 = "errno"
                                int r0 = r6.optInt(r0)     // Catch:{ JSONException -> 0x0061 }
                                if (r0 == 0) goto L_0x005f
                                java.lang.String r0 = "errmsg"
                                java.lang.String r6 = r6.optString(r0)     // Catch:{ JSONException -> 0x0061 }
                                com.didi.component.expectation.view.FlexRaiseSheetView r0 = com.didi.component.expectation.view.FlexRaiseSheetView.this     // Catch:{ JSONException -> 0x0061 }
                                android.content.Context r0 = r0.f13703c     // Catch:{ JSONException -> 0x0061 }
                                com.didi.global.globaluikit.toast.LEGOToastHelper.showToast(r0, r6)     // Catch:{ JSONException -> 0x0061 }
                                com.didi.component.expectation.view.FlexRaiseSheetView r6 = com.didi.component.expectation.view.FlexRaiseSheetView.this     // Catch:{ JSONException -> 0x0061 }
                                android.widget.TextView r6 = r6.f13709i     // Catch:{ JSONException -> 0x0061 }
                                r6.setEnabled(r3)     // Catch:{ JSONException -> 0x0061 }
                            L_0x005e:
                                r3 = 0
                            L_0x005f:
                                r2 = r3
                                goto L_0x0065
                            L_0x0061:
                                r6 = move-exception
                                r6.printStackTrace()
                            L_0x0065:
                                if (r2 == 0) goto L_0x0078
                                com.didi.component.expectation.view.FlexRaiseSheetView r6 = com.didi.component.expectation.view.FlexRaiseSheetView.this
                                com.didi.sdk.view.SimplePopupBase r6 = r6.f13713m
                                if (r6 == 0) goto L_0x0078
                                com.didi.component.expectation.view.FlexRaiseSheetView r6 = com.didi.component.expectation.view.FlexRaiseSheetView.this
                                com.didi.sdk.view.SimplePopupBase r6 = r6.f13713m
                                r6.dismiss()
                            L_0x0078:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.didi.component.expectation.view.FlexRaiseSheetView.C57506.onResult(com.didi.drouter.router.Result):void");
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSimplePopupBase(SimplePopupBase simplePopupBase) {
        this.f13713m = simplePopupBase;
    }

    public void setData(FlexRaiseSheet flexRaiseSheet) {
        this.f13712l = flexRaiseSheet;
        if (flexRaiseSheet.config == null) {
            m9464b("data config is null");
            return;
        }
        this.f13714n = new BigDecimal(flexRaiseSheet.config.current_price);
        this.f13715o = new BigDecimal(flexRaiseSheet.config.max_price);
        this.f13716p = new BigDecimal(flexRaiseSheet.config.addPrice_count);
        this.f13717q = new BigDecimal(flexRaiseSheet.config.subPrice_count);
        this.f13718r = flexRaiseSheet.btn_submit_link;
        BigDecimal bigDecimal = new BigDecimal(flexRaiseSheet.config.current_price);
        if (bigDecimal.compareTo(BigDecimal.ZERO) != 0) {
            this.f13710j.setText(bigDecimal.toString());
        }
        m9456a();
    }

    /* renamed from: a */
    private void m9456a() {
        FlexRaiseSheet flexRaiseSheet = this.f13712l;
        if (flexRaiseSheet != null) {
            flexRaiseSheet.title.bindTextView(this.f13704d);
            this.f13705e.setEnabled(false);
            this.f13711k.setEnabled(false);
            this.f13709i.setEnabled(false);
            try {
                this.f13709i.setBackground(DidiThemeManager.getIns().getResPicker(this.f13703c).getDrawable(R.attr.global_overall_main_button_selector));
                this.f13709i.setTextColor(ContextCompat.getColorStateList(this.f13703c, DidiThemeManager.getIns().getResPicker(this.f13703c).getResIdByTheme(R.attr.global_main_button_text_color_selector)));
                if (this.f13712l.btn_title != null && !TextUtils.isEmpty(this.f13712l.btn_title)) {
                    this.f13709i.setText(this.f13712l.btn_title);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f13712l.config != null) {
                if (!TextUtils.isEmpty(this.f13712l.config.subPrice_count)) {
                    this.f13705e.setText("-" + Elvish.Companion.getInstance().formatNumber(Integer.valueOf(this.f13712l.config.subPrice_count), 0, 1));
                }
                if (!TextUtils.isEmpty(this.f13712l.config.addPrice_count)) {
                    this.f13707g.setText("+" + Elvish.Companion.getInstance().formatNumber(Integer.valueOf(this.f13712l.config.addPrice_count), 0, 1));
                }
                if (!TextUtils.isEmpty(this.f13712l.config.currency_symbol)) {
                    this.f13706f.setText(this.f13712l.config.currency_symbol);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9464b(String str) {
        this.f13701a.info(str, new Object[0]);
    }
}
