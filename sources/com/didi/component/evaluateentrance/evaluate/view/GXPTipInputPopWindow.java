package com.didi.component.evaluateentrance.evaluate.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.net.CarServerParam;
import com.didi.component.evaluateentrance.evaluate.model.GXPCarTipInfo;
import com.global.didi.elvish.Elvish;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class GXPTipInputPopWindow extends PopupWindow {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f13545a = "";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Double f13546b = Double.valueOf(0.0d);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ConfirmButtonClickListener f13547c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f13548d;

    /* renamed from: e */
    private View f13549e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public GXPCarTipInfo f13550f;

    /* renamed from: g */
    private double f13551g = 0.0d;

    /* renamed from: h */
    private String f13552h = "";

    /* renamed from: i */
    private View f13553i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public EditText f13554j;

    public interface ConfirmButtonClickListener {
        void confirmClick(String str, Double d);
    }

    public GXPTipInputPopWindow(View view, int i, int i2, Context context, GXPCarTipInfo gXPCarTipInfo, double d, String str, ConfirmButtonClickListener confirmButtonClickListener) {
        super(view, i, i2);
        this.f13549e = view;
        this.f13547c = confirmButtonClickListener;
        this.f13548d = context;
        this.f13550f = gXPCarTipInfo;
        this.f13551g = d;
        this.f13552h = str;
        m9302a();
    }

    public void show() {
        Context context = this.f13548d;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && !activity.isFinishing() && !isShowing()) {
            setFocusable(true);
            setInputMethodMode(1);
            setSoftInputMode(16);
            setBackgroundDrawable(new ColorDrawable(1076176429));
            setClippingEnabled(true);
            setOutsideTouchable(true);
            this.f13553i.setAnimation(AnimationUtils.loadAnimation(this.f13548d, R.anim.ggk_drawer_bottom_in));
            showAtLocation(this.f13549e, 80, 0, 0);
            this.f13554j.requestFocus();
            this.f13554j.setFocusableInTouchMode(true);
            ((InputMethodManager) this.f13554j.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
        }
    }

    /* renamed from: a */
    private void m9302a() {
        if (this.f13550f != null) {
            this.f13553i = this.f13549e.findViewById(R.id.tip_popup_view);
            this.f13554j = (EditText) this.f13549e.findViewById(R.id.tip_input_drawer_et);
            final TextView textView = (TextView) this.f13549e.findViewById(R.id.tip_input_drawer_btn);
            TextView textView2 = (TextView) this.f13549e.findViewById(R.id.currency_text);
            final ImageView imageView = (ImageView) this.f13549e.findViewById(R.id.del_text_btn);
            if (this.f13551g == 0.0d) {
                EditText editText = this.f13554j;
                editText.setHint(this.f13550f.min + "-" + this.f13550f.max);
                textView.setEnabled(false);
                imageView.setVisibility(8);
            } else {
                EditText editText2 = this.f13554j;
                editText2.setText(this.f13551g + "");
                this.f13545a = this.f13552h;
                this.f13546b = Double.valueOf(this.f13551g);
                textView.setEnabled(true);
                imageView.setVisibility(0);
            }
            textView2.setText(this.f13550f.currency);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GXPTipInputPopWindow.this.f13554j.setText("");
                    if (GXPTipInputPopWindow.this.f13550f != null) {
                        EditText a = GXPTipInputPopWindow.this.f13554j;
                        a.setHint(GXPTipInputPopWindow.this.f13550f.min + "-" + GXPTipInputPopWindow.this.f13550f.max);
                    }
                    imageView.setVisibility(8);
                }
            });
            this.f13554j.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    imageView.setVisibility(0);
                    try {
                        String unused = GXPTipInputPopWindow.this.f13545a = Elvish.Companion.getInstance().formatNumber(Double.valueOf(Double.parseDouble(editable.toString())), -1, 1);
                        if (!GXPTipInputPopWindow.this.f13545a.isEmpty()) {
                            Double unused2 = GXPTipInputPopWindow.this.f13546b = Double.valueOf(Elvish.Companion.getInstance().parseNumberSafety(GXPTipInputPopWindow.this.f13545a, Double.valueOf(0.0d)).doubleValue());
                            if (GXPTipInputPopWindow.this.f13546b.doubleValue() <= 0.0d) {
                                GXPTipInputPopWindow.this.f13554j.setTextColor(ContextCompat.getColor(GXPTipInputPopWindow.this.f13548d, R.color.g_color_000));
                                textView.setEnabled(false);
                            } else if (GXPTipInputPopWindow.this.f13546b.doubleValue() >= ((double) GXPTipInputPopWindow.this.f13550f.min) && GXPTipInputPopWindow.this.f13546b.doubleValue() <= ((double) GXPTipInputPopWindow.this.f13550f.max)) {
                                GXPTipInputPopWindow.this.f13554j.setTextColor(ContextCompat.getColor(GXPTipInputPopWindow.this.f13548d, R.color.g_color_000));
                                textView.setEnabled(true);
                            } else if (GXPTipInputPopWindow.this.f13546b.doubleValue() > ((double) GXPTipInputPopWindow.this.f13550f.max)) {
                                GXPTipInputPopWindow.this.f13554j.setTextColor(ContextCompat.getColor(GXPTipInputPopWindow.this.f13548d, R.color.g_color_FFFF525D));
                                textView.setEnabled(false);
                                HashMap hashMap = new HashMap();
                                hashMap.put(CarServerParam.PARAM_FEE, GXPTipInputPopWindow.this.f13546b.toString());
                                hashMap.put("source", "tipentrance");
                                GlobalOmegaUtils.trackEvent("ibt_gp_tipeamount_error_bt", (Map<String, Object>) hashMap);
                            } else {
                                GXPTipInputPopWindow.this.f13554j.setTextColor(ContextCompat.getColor(GXPTipInputPopWindow.this.f13548d, R.color.g_color_000));
                                textView.setEnabled(false);
                            }
                        } else {
                            GXPTipInputPopWindow.this.f13554j.setTextColor(ContextCompat.getColor(GXPTipInputPopWindow.this.f13548d, R.color.g_color_FFFF525D));
                            textView.setEnabled(false);
                        }
                    } catch (NumberFormatException unused3) {
                        GXPTipInputPopWindow.this.f13554j.setTextColor(ContextCompat.getColor(GXPTipInputPopWindow.this.f13548d, R.color.g_color_FFFF525D));
                        textView.setEnabled(false);
                    }
                }
            });
            ((ImageView) this.f13549e.findViewById(R.id.tip_input_drawer_close)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GXPTipInputPopWindow.this.dismiss();
                    GlobalOmegaUtils.trackEvent("ibt_gp_tipeamount_close_ck", "source", "tipentrance");
                }
            });
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GXPTipInputPopWindow.this.f13547c.confirmClick(GXPTipInputPopWindow.this.f13545a, GXPTipInputPopWindow.this.f13546b);
                    GXPTipInputPopWindow.this.dismiss();
                    HashMap hashMap = new HashMap();
                    hashMap.put("source", "tipentrance");
                    if (!GXPTipInputPopWindow.this.f13545a.isEmpty()) {
                        hashMap.put(CarServerParam.PARAM_FEE, GXPTipInputPopWindow.this.f13545a);
                    }
                    GlobalOmegaUtils.trackEvent("ibt_gp_tipeamount_complete_ck", (Map<String, Object>) hashMap);
                }
            });
        }
    }

    public void dismiss() {
        this.f13553i.setAnimation(AnimationUtils.loadAnimation(this.f13548d, R.anim.ggk_drawer_bottom_out));
        this.f13553i.requestLayout();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                GXPTipInputPopWindow.super.dismiss();
            }
        }, 250);
    }
}
