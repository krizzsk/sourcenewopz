package com.didi.safetoolkit.business.emergency;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.android.didi.safetoolkit.activity.BaseActivityWithUIStuff;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.safetoolkit.apollo.SfApolloUtil;
import com.didi.safetoolkit.business.emergency.model.SfEmgInfo;
import com.didi.safetoolkit.business.emergency.widget.SfEmergencyInfoCardView;
import com.didi.safetoolkit.business.emergency.widget.SfRippleAnimationLayout;
import com.didi.safetoolkit.business.emergency.widget.SliderMoveView;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.model.SfLocation;
import com.didi.safetoolkit.net.SfResponseListener;
import com.didi.safetoolkit.util.SfStringGetter;
import com.didi.safetoolkit.util.statuslightning.StatusBarLightingCompat;
import com.didi.safetoolkit.widget.SfBaseDialog;
import com.didi.safetoolkit.widget.SfCommonTitleBar;
import com.didi.sdk.app.tap.BusinessConstants;
import com.didichuxing.drtl.tookit.DRtlToolkit;
import com.taxis99.R;

public class SfEmergencyAssistanceActivity extends BaseActivityWithUIStuff implements ISfEmergencyAssistanceView {

    /* renamed from: a */
    private SfCommonTitleBar f34321a;

    /* renamed from: b */
    private TextView f34322b;

    /* renamed from: c */
    private TextView f34323c;

    /* renamed from: d */
    private TextView f34324d;

    /* renamed from: e */
    private TextView f34325e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SfEmergencyInfoCardView f34326f;

    /* renamed from: g */
    private SfRippleAnimationLayout f34327g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SfCommonTitleBar f34328h;

    /* renamed from: i */
    private CardView f34329i;

    /* renamed from: j */
    private ImageView f34330j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f34331k;

    /* renamed from: l */
    private ImageView f34332l;

    /* renamed from: m */
    private TextView f34333m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public TextView f34334n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public TextView f34335o;

    /* renamed from: p */
    private ImageView f34336p;

    /* renamed from: q */
    private TextView f34337q;

    /* renamed from: r */
    private TextView f34338r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public SliderMoveView f34339s;

    /* renamed from: t */
    private long f34340t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public SfEmergencyAssistancePresenter f34341u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f34342v = true;

    /* renamed from: w */
    private boolean f34343w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f34344x;

    /* access modifiers changed from: protected */
    public void beforeContentViewLoaded() {
        super.beforeContentViewLoaded();
        if (BusinessConstants.TYPE_VAMOS.equals(SafeToolKit.getIns().getBusinessType())) {
            this.f34342v = false;
        } else {
            this.f34342v = SfApolloUtil.isNewCallPoliceUI();
        }
        this.f34343w = DRtlToolkit.rtl();
    }

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return this.f34342v ? R.layout.sf_layout_act_emergency_assistance_new : R.layout.sf_layout_act_emergency_assistance;
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        if (this.f34342v) {
            this.f34328h = (SfCommonTitleBar) findViewById(R.id.sf_title_bar);
            this.f34329i = (CardView) findViewById(R.id.layout_card);
            this.f34330j = (ImageView) findViewById(R.id.iv_shield);
            this.f34331k = findViewById(R.id.layout_car_info);
            this.f34332l = (ImageView) findViewById(R.id.iv_car_icon);
            this.f34333m = (TextView) findViewById(R.id.tv_car_tag);
            this.f34334n = (TextView) findViewById(R.id.tv_car_number);
            this.f34335o = (TextView) findViewById(R.id.tv_car_brand);
            this.f34336p = (ImageView) findViewById(R.id.iv_location_icon);
            this.f34337q = (TextView) findViewById(R.id.tv_location_tag);
            this.f34338r = (TextView) findViewById(R.id.tv_location_info);
            SliderMoveView sliderMoveView = (SliderMoveView) findViewById(R.id.v_call_police);
            this.f34339s = sliderMoveView;
            sliderMoveView.setListener(new SliderMoveView.SlideButtonViewListener() {
                public void onSliderMove(float f, float f2) {
                }

                public boolean onSliderStateChange(int i) {
                    if (i != 3 || SfEmergencyAssistanceActivity.this.f34339s.getCurrentPercent() <= 0.95f) {
                        return false;
                    }
                    SfEmergencyAssistanceActivity.this.f34341u.handleEmergencyCallClickedNew();
                    return true;
                }
            });
            return;
        }
        this.f34321a = (SfCommonTitleBar) findViewById(R.id.sf_title_bar);
        this.f34322b = (TextView) findViewById(R.id.sf_call_btn);
        this.f34323c = (TextView) findViewById(R.id.sf_sub_title);
        this.f34324d = (TextView) findViewById(R.id.sf_status_tv);
        this.f34325e = (TextView) findViewById(R.id.sf_call_msg);
        this.f34326f = (SfEmergencyInfoCardView) findViewById(R.id.sf_info_card);
        this.f34327g = (SfRippleAnimationLayout) findViewById(R.id.sf_ripple_container);
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
        if (bundle != null) {
            this.f34344x = bundle.getBoolean("isNotAccepted");
        }
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        this.f34341u = new SfEmergencyAssistancePresenter(this);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        if (this.f34342v) {
            this.f34328h.setTitleText(SfStringGetter.getString(R.string.sf_emergency_assistance_main_title));
            this.f34331k.setVisibility(this.f34344x ? 8 : 0);
            int i = 5;
            this.f34334n.setGravity(this.f34343w ? 5 : 3);
            this.f34335o.setGravity(this.f34343w ? 5 : 3);
            TextView textView = this.f34338r;
            if (!this.f34343w) {
                i = 3;
            }
            textView.setGravity(i);
            updateUIByCallPoliceState(false);
        } else {
            this.f34321a.setTitleText(SfStringGetter.getString(R.string.sf_emergency_assistance_main_title));
            if (this.f34344x) {
                this.f34323c.setText(SfStringGetter.getString(R.string.GRider_Global_Under_the_hmOG));
            } else {
                this.f34323c.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_latest_trip_info, SfEmergencyNumHelper.getEmergencyCallNum()));
            }
            this.f34322b.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_call, SfEmergencyNumHelper.getEmergencyCallNum()));
            this.f34325e.getPaint().setUnderlineText(true);
            this.f34325e.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_call_again_tips, SfEmergencyNumHelper.getEmergencyCallNum()));
            this.f34326f.setVehicleInfoVisible(true ^ this.f34344x);
        }
        this.f34341u.requestEmergencyInfo(new SfResponseListener<SfEmgInfo>() {
            public void onSuccess(final SfEmgInfo sfEmgInfo) {
                if (SfEmergencyAssistanceActivity.this.f34342v) {
                    if (sfEmgInfo == null || sfEmgInfo.data == null || (TextUtils.isEmpty(sfEmgInfo.data.carLicense) && TextUtils.isEmpty(sfEmgInfo.data.carBrand))) {
                        SfEmergencyAssistanceActivity.this.f34331k.setVisibility(8);
                    } else {
                        SfEmergencyAssistanceActivity.this.f34331k.setVisibility(0);
                        SfEmergencyAssistanceActivity.this.f34334n.setText(sfEmgInfo.data.carLicense);
                        SfEmergencyAssistanceActivity.this.f34335o.setText(sfEmgInfo.data.carBrand);
                    }
                    if (sfEmgInfo == null || sfEmgInfo.data == null || TextUtils.isEmpty(sfEmgInfo.data.moreUrl)) {
                        SfEmergencyAssistanceActivity.this.f34328h.setRightTextView("", (View.OnClickListener) null);
                    } else {
                        SfEmergencyAssistanceActivity.this.f34328h.setRightTextView(SfStringGetter.getString(R.string.GRider_improvement_Learn_more_HvDY), new View.OnClickListener() {
                            public void onClick(View view) {
                                AutoTrackHelper.trackViewOnClick(view);
                                DRouter.build(sfEmgInfo.data.moreUrl).start(SfEmergencyAssistanceActivity.this);
                            }
                        });
                    }
                } else if (!SfEmergencyAssistanceActivity.this.f34344x) {
                    SfEmergencyAssistanceActivity.this.f34326f.setEmgInfo(sfEmgInfo);
                }
            }
        });
        if (!SafeToolKit.getIns().isVamosDriver()) {
            this.f34341u.requestEmergencyStatus();
        }
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        if (this.f34342v) {
            this.f34328h.setLeftBtnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SfEmergencyAssistanceActivity.this.onBackPressed();
                }
            });
            return;
        }
        this.f34321a.setLeftBtnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfEmergencyAssistanceActivity.this.onBackPressed();
            }
        });
        this.f34325e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfEmergencyAssistanceActivity.this.f34341u.makeEmergencyCall();
            }
        });
        this.f34322b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfEmergencyAssistanceActivity.this.f34341u.handleEmergencyCallClicked();
            }
        });
    }

    public void showLocationLoadingStatus() {
        if (!this.f34342v) {
            this.f34326f.updatingLocation();
        }
    }

    public void showLocationLoadedSucceedStatus(SfLocation sfLocation) {
        if (this.f34342v) {
            this.f34340t = System.currentTimeMillis();
            this.f34337q.setText(SfStringGetter.getString(R.string.GRider_improvement_Estimated_current_OHzq));
            this.f34338r.setText(sfLocation.address);
            return;
        }
        this.f34326f.updateCurrentLocation(sfLocation.address);
    }

    public void showLocationLoadedFailStatus() {
        if (!this.f34342v) {
            this.f34326f.showLastKnowLocation();
        } else if (!TextUtils.isEmpty(this.f34338r.getText())) {
            this.f34337q.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_last_know_location, Integer.valueOf((int) Math.ceil((double) (((float) ((System.currentTimeMillis() - this.f34340t) / 1000)) / 60.0f)))));
        }
    }

    public void startCallButtonAnimation() {
        if (!SafeToolKit.getIns().isVamosDriver() && !this.f34342v) {
            this.f34327g.startRippleAnimation();
            this.f34322b.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_stop_uploading_location));
            this.f34322b.setTextColor(getResources().getColor(R.color.sf_color_ff525d));
            this.f34322b.setBackground(getResources().getDrawable(R.drawable.sf_emergency_call_stop_btn_selector));
            this.f34324d.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_uploading_location));
            this.f34324d.setVisibility(0);
            this.f34325e.setVisibility(0);
        }
    }

    public void stopCallButtonAnimation() {
        if (!this.f34342v) {
            this.f34327g.stopRippleAnimation();
            this.f34322b.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_call, SfEmergencyNumHelper.getEmergencyCallNum()));
            this.f34322b.setTextColor(getResources().getColor(R.color.sf_white));
            this.f34322b.setBackground(getResources().getDrawable(R.drawable.sf_emergency_call_start_btn_selector));
            this.f34324d.setVisibility(4);
            this.f34325e.setVisibility(4);
        }
    }

    public void showStopEmerAssistConfirmDialog(View.OnClickListener onClickListener) {
        if (!isFinishing() && !isDestroyed()) {
            new SfBaseDialog.DialogBuilder(getContext()).setTitle(SfStringGetter.getString(R.string.sf_emergency_assistance_stop_title)).setTitleTypeface(1).setContent(SfStringGetter.getString(R.string.sf_emergency_assistance_stop_message)).setLeftBtn(SfStringGetter.getString(R.string.sf_emergency_assistance_confirm_stop_btn), onClickListener).setLeftBtnTextColorRes(R.color.sf_color_999999).setRightBtn(SfStringGetter.getString(R.string.sf_emergency_assistance_no_stop_btn)).setRightBtnTypeface(1).setRightBtnTextColorRes(R.color.sf_color_FC9153).setCancelableWhenTouchOutside(false).build().show(getSupportFragmentManager(), "StopEmerAssistConfirmDialog");
        }
    }

    public void updateUIByCallPoliceState(boolean z) {
        String str;
        String str2;
        if (this.f34342v) {
            String str3 = "#FFFFFF";
            this.f34329i.setCardBackgroundColor(Color.parseColor(z ? "#FF4050" : str3));
            this.f34330j.setImageResource(z ? R.drawable.sf_ic_call_police_shield_special : R.drawable.sf_ic_call_police_shield_normal);
            this.f34332l.setImageResource(z ? R.drawable.sf_ic_call_police_car_special : R.drawable.sf_ic_call_police_car_normal);
            String str4 = "#CDFFFFFF";
            this.f34333m.setTextColor(Color.parseColor(z ? str4 : "#919599"));
            this.f34334n.setTextColor(Color.parseColor(z ? str3 : "#000000"));
            TextView textView = this.f34335o;
            if (z) {
                str = str3;
            } else {
                str = "#000000";
            }
            textView.setTextColor(Color.parseColor(str));
            this.f34336p.setImageResource(z ? R.drawable.sf_ic_call_police_location_special : R.drawable.sf_ic_call_police_location_normal);
            TextView textView2 = this.f34337q;
            if (!z) {
                str4 = "#919599";
            }
            textView2.setTextColor(Color.parseColor(str4));
            TextView textView3 = this.f34338r;
            if (!z) {
                str3 = "#000000";
            }
            textView3.setTextColor(Color.parseColor(str3));
            if (z) {
                str2 = SfStringGetter.getString(R.string.GRider_improvement_Sliding_again_EZlR);
            } else {
                str2 = SfStringGetter.getString(R.string.GRider_improvement_Swipe_alarm_sPBI, SfEmergencyNumHelper.getEmergencyCallNum());
            }
            this.f34339s.setForegroundText(str2);
            this.f34339s.setBackgroundText(str2);
        }
    }

    public View getFallbackView() {
        if (this.f34342v) {
            return this.f34328h.getLoadingFallback();
        }
        return this.f34321a.getLoadingFallback();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        SfEmergencyInfoCardView sfEmergencyInfoCardView;
        if (!this.f34342v && (sfEmergencyInfoCardView = this.f34326f) != null) {
            sfEmergencyInfoCardView.onPause();
        }
        super.onPause();
    }
}
