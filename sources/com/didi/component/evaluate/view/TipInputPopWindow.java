package com.didi.component.evaluate.view;

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
import com.didi.travel.psnger.model.response.CarTipInfo;
import com.global.didi.elvish.Elvish;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class TipInputPopWindow extends PopupWindow {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f13385a = "";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Double f13386b = Double.valueOf(0.0d);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ConfirmButtonClickListener f13387c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f13388d;

    /* renamed from: e */
    private View f13389e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CarTipInfo f13390f;

    /* renamed from: g */
    private double f13391g = 0.0d;

    /* renamed from: h */
    private String f13392h = "";

    /* renamed from: i */
    private View f13393i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public EditText f13394j;

    interface ConfirmButtonClickListener {
        void confirmClick(String str, Double d);
    }

    public TipInputPopWindow(View view, int i, int i2, Context context, CarTipInfo carTipInfo, double d, String str, ConfirmButtonClickListener confirmButtonClickListener) {
        super(view, i, i2);
        this.f13389e = view;
        this.f13387c = confirmButtonClickListener;
        this.f13388d = context;
        this.f13390f = carTipInfo;
        this.f13391g = d;
        this.f13392h = str;
        m9174a();
    }

    public void show() {
        Context context = this.f13388d;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && !activity.isFinishing() && !isShowing()) {
            setFocusable(true);
            setInputMethodMode(1);
            setSoftInputMode(16);
            setBackgroundDrawable(new ColorDrawable(1076176429));
            setClippingEnabled(true);
            setOutsideTouchable(true);
            showAtLocation(this.f13389e, 80, 0, 0);
            this.f13393i.setAnimation(AnimationUtils.loadAnimation(this.f13388d, R.anim.ggk_drawer_bottom_in));
            showAtLocation(this.f13389e, 80, 0, 0);
            this.f13394j.requestFocus();
            this.f13394j.setFocusableInTouchMode(true);
            ((InputMethodManager) this.f13394j.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
        }
    }

    /* renamed from: a */
    private void m9174a() {
        if (this.f13390f != null) {
            this.f13393i = this.f13389e.findViewById(R.id.evaluate_tip_view);
            this.f13394j = (EditText) this.f13389e.findViewById(R.id.tip_input_drawer_et);
            final TextView textView = (TextView) this.f13389e.findViewById(R.id.tip_input_drawer_btn);
            TextView textView2 = (TextView) this.f13389e.findViewById(R.id.currency_text);
            final ImageView imageView = (ImageView) this.f13389e.findViewById(R.id.del_text_btn);
            if (this.f13391g == 0.0d) {
                EditText editText = this.f13394j;
                editText.setHint(this.f13390f.min + "-" + this.f13390f.max);
                textView.setEnabled(false);
                imageView.setVisibility(8);
            } else {
                EditText editText2 = this.f13394j;
                editText2.setText(this.f13391g + "");
                this.f13386b = Double.valueOf(this.f13391g);
                this.f13385a = this.f13392h;
                textView.setEnabled(true);
                imageView.setVisibility(0);
            }
            textView2.setText(this.f13390f.currency);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    TipInputPopWindow.this.f13394j.setText("");
                    if (TipInputPopWindow.this.f13390f != null) {
                        EditText a = TipInputPopWindow.this.f13394j;
                        a.setHint(TipInputPopWindow.this.f13390f.min + "-" + TipInputPopWindow.this.f13390f.max);
                    }
                    imageView.setVisibility(8);
                }
            });
            this.f13394j.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    imageView.setVisibility(0);
                    try {
                        String unused = TipInputPopWindow.this.f13385a = Elvish.Companion.getInstance().formatNumber(Double.valueOf(Double.parseDouble(editable.toString())), -1, 1);
                        if (!TipInputPopWindow.this.f13385a.isEmpty()) {
                            Double unused2 = TipInputPopWindow.this.f13386b = Double.valueOf(Elvish.Companion.getInstance().parseNumberSafety(TipInputPopWindow.this.f13385a, Double.valueOf(0.0d)).doubleValue());
                            if (TipInputPopWindow.this.f13386b.doubleValue() <= 0.0d) {
                                TipInputPopWindow.this.f13394j.setTextColor(ContextCompat.getColor(TipInputPopWindow.this.f13388d, R.color.g_color_000));
                                textView.setEnabled(false);
                            } else if (TipInputPopWindow.this.f13386b.doubleValue() >= ((double) TipInputPopWindow.this.f13390f.min) && TipInputPopWindow.this.f13386b.doubleValue() <= ((double) TipInputPopWindow.this.f13390f.max)) {
                                TipInputPopWindow.this.f13394j.setTextColor(ContextCompat.getColor(TipInputPopWindow.this.f13388d, R.color.g_color_000));
                                textView.setEnabled(true);
                            } else if (TipInputPopWindow.this.f13386b.doubleValue() > ((double) TipInputPopWindow.this.f13390f.max)) {
                                TipInputPopWindow.this.f13394j.setTextColor(ContextCompat.getColor(TipInputPopWindow.this.f13388d, R.color.g_color_FFFF525D));
                                textView.setEnabled(false);
                                HashMap hashMap = new HashMap();
                                hashMap.put(CarServerParam.PARAM_FEE, TipInputPopWindow.this.f13386b.toString());
                                hashMap.put("source", "starratedetail");
                                GlobalOmegaUtils.trackEvent("ibt_gp_tipeamount_error_bt", (Map<String, Object>) hashMap);
                            } else {
                                TipInputPopWindow.this.f13394j.setTextColor(ContextCompat.getColor(TipInputPopWindow.this.f13388d, R.color.g_color_000));
                                textView.setEnabled(false);
                            }
                        } else {
                            TipInputPopWindow.this.f13394j.setTextColor(ContextCompat.getColor(TipInputPopWindow.this.f13388d, R.color.g_color_FFFF525D));
                            textView.setEnabled(false);
                        }
                    } catch (NumberFormatException unused3) {
                        TipInputPopWindow.this.f13394j.setTextColor(ContextCompat.getColor(TipInputPopWindow.this.f13388d, R.color.g_color_FFFF525D));
                        textView.setEnabled(false);
                    }
                }
            });
            ((ImageView) this.f13389e.findViewById(R.id.tip_input_drawer_close)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    TipInputPopWindow.this.dismiss();
                    GlobalOmegaUtils.trackEvent("ibt_gp_tipeamount_close_ck", "source", "starratedetail");
                }
            });
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    TipInputPopWindow.this.f13387c.confirmClick(TipInputPopWindow.this.f13385a, TipInputPopWindow.this.f13386b);
                    TipInputPopWindow.this.dismiss();
                    HashMap hashMap = new HashMap();
                    hashMap.put("source", "starratedetail");
                    if (!TipInputPopWindow.this.f13385a.isEmpty()) {
                        hashMap.put(CarServerParam.PARAM_FEE, TipInputPopWindow.this.f13385a);
                    }
                    GlobalOmegaUtils.trackEvent("ibt_gp_tipeamount_complete_ck", (Map<String, Object>) hashMap);
                }
            });
        }
    }

    public void dismiss() {
        this.f13393i.setAnimation(AnimationUtils.loadAnimation(this.f13388d, R.anim.ggk_drawer_bottom_out));
        this.f13393i.requestLayout();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                TipInputPopWindow.super.dismiss();
            }
        }, 250);
    }
}
