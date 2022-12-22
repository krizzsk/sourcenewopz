package com.didi.component.driverbar.impl;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.business.util.Utils;
import com.didi.component.driverbar.AvatarEnlargePopup;
import com.didi.component.driverbar.model.DriverBarV2Model;
import com.didi.component.driverbar.model.DriverCarData;
import com.didi.component.driverbar.model.DriverPersonData;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.scene.order.serving.components.OrderFloatWindowManager;
import com.didi.sdk.address.address.entity.Address;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didiglobal.font.DIDIFontUtils;
import com.didiglobal.travel.util.view.ViewEx;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;

public class DriverBarFarFieldView extends DriverBarFieldBase {
    public static final int ANIMATION_TIME = 400;
    public static final int ANIMATION_TIME_SHORT = 300;

    /* renamed from: A */
    private TextView f12924A;

    /* renamed from: B */
    private TextView f12925B;

    /* renamed from: C */
    private ImageView f12926C;

    /* renamed from: a */
    private TextView f12927a = ((TextView) findView(R.id.driver_card_car_label));
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView f12928b = ((ImageView) findView(R.id.driver_card_car_image));
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f12929c = ((TextView) findView(R.id.driver_card_car_num));
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f12930d = ((TextView) findView(R.id.driver_card_car_info));

    /* renamed from: e */
    private ImageView f12931e = ((ImageView) findView(R.id.driver_card_person_image));

    /* renamed from: f */
    private TextView f12932f = ((TextView) findView(R.id.driver_card_person_name));

    /* renamed from: g */
    private LinearLayout f12933g = ((LinearLayout) findView(R.id.driver_card_person_info_ll));

    /* renamed from: h */
    private TextView f12934h = ((TextView) findView(R.id.driver_card_benefit_text));

    /* renamed from: i */
    private ImageView f12935i = ((ImageView) findView(R.id.driver_card_benefit_img));

    /* renamed from: j */
    private LinearLayout f12936j = ((LinearLayout) findView(R.id.driver_card_benefit_ll));
    /* access modifiers changed from: private */

    /* renamed from: k */
    public DriverBarV2View f12937k;

    /* renamed from: l */
    private DriverBarV2Model f12938l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public View f12939m;

    /* renamed from: n */
    private View f12940n;

    /* renamed from: o */
    private ImageView f12941o;

    /* renamed from: p */
    private ImageView f12942p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public TextView f12943q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public LinearLayout f12944r;

    /* renamed from: s */
    private View f12945s = findView(R.id.driver_card_line);

    /* renamed from: t */
    private ImageView f12946t;

    /* renamed from: u */
    private TextView f12947u;

    /* renamed from: v */
    private TextView f12948v;

    /* renamed from: w */
    private TextView f12949w;

    /* renamed from: x */
    private TextView f12950x;

    /* renamed from: y */
    private TextView f12951y;

    /* renamed from: z */
    private TextView f12952z;

    public DriverBarFarFieldView(Context context, ViewGroup viewGroup, DriverBarV2View driverBarV2View) {
        super(context, viewGroup);
        this.f12937k = driverBarV2View;
        this.f12949w = (TextView) findView(R.id.driver_card_star_text);
        this.f12946t = (ImageView) findView(R.id.driver_card_star_img);
        this.f12947u = (TextView) findView(R.id.dot_text1);
        this.f12948v = (TextView) findView(R.id.driver_card_trip_num);
        this.f12950x = (TextView) findView(R.id.driver_card_near_person_info);
        this.f12951y = (TextView) findView(R.id.driver_card_near_star_text);
        this.f12952z = (TextView) findView(R.id.driver_card_near_trip_num);
        this.f12924A = (TextView) findView(R.id.dot_text1_near);
        this.f12925B = (TextView) findView(R.id.dot_text2_near);
        this.f12926C = (ImageView) findView(R.id.driver_card_near_star_img);
        this.f12944r = (LinearLayout) findView(R.id.driver_card_person_info_near_ll);
        this.f12939m = findView(R.id.driver_card_avatar_near_ll);
        this.f12940n = findView(R.id.driver_card_person_image_bg_near);
        this.f12942p = (ImageView) findView(R.id.driver_card_person_image_near);
        this.f12943q = (TextView) findView(R.id.driver_card_car_num_near);
        this.f12941o = (ImageView) findView(R.id.driver_card_car_image_near);
    }

    /* access modifiers changed from: protected */
    public void inflateView(Context context, ViewGroup viewGroup) {
        this.mContainerView = ViewEx.inflateViewAsync(context, (int) R.layout.driver_bar_v2_far_view, viewGroup, false);
    }

    public void setData(final DriverBarV2Model driverBarV2Model) {
        int i;
        int i2;
        super.setData(driverBarV2Model);
        this.f12938l = driverBarV2Model;
        if (driverBarV2Model != null && driverBarV2Model.farModel != null) {
            if (driverBarV2Model.farModel.carData != null) {
                DriverCarData driverCarData = driverBarV2Model.farModel.carData;
                if (!TextUtils.isEmpty(driverCarData.icon) && !Utils.isDestroy(this.mContext)) {
                    ((RequestBuilder) Glide.with(this.mContext).asBitmap().load(driverCarData.icon).placeholder((int) R.drawable.global_driver_bar_default_car)).into(new CustomTarget<Bitmap>() {
                        public void onLoadCleared(Drawable drawable) {
                        }

                        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                            DriverBarFarFieldView.this.f12928b.setImageBitmap(bitmap);
                            OrderFloatWindowManager.Instance().setModelBitmap(bitmap);
                        }
                    });
                }
                if (driverCarData.licenseNum != null && !TextUtils.isEmpty(driverCarData.licenseNum.getContent())) {
                    driverCarData.licenseNum.bindTextView(this.f12929c);
                    OrderFloatWindowManager.Instance().setLicensePlate(driverCarData.licenseNum.getContent());
                }
                if (driverBarV2Model.carLabel == null || TextUtils.isEmpty(driverBarV2Model.carLabel.getContent())) {
                    this.f12927a.setVisibility(8);
                } else {
                    driverBarV2Model.carLabel.bindTextView(this.f12927a);
                    this.f12927a.setVisibility(0);
                }
                SpannableString spannableString = new SpannableString(" · ");
                this.f12930d.setText("");
                if (driverCarData.carTypeInfo != null && !TextUtils.isEmpty(driverCarData.carTypeInfo.getContent())) {
                    this.f12930d.append(driverCarData.carTypeInfo.parseRichInfo(this.mContext));
                }
                if (driverCarData.carColorInfo != null && !TextUtils.isEmpty(driverCarData.carColorInfo.getContent())) {
                    SpannableString parseRichInfo = driverCarData.carColorInfo.parseRichInfo(this.mContext);
                    if (this.f12930d.getText().length() != 0) {
                        this.f12930d.append(spannableString);
                    }
                    this.f12930d.append(parseRichInfo);
                }
            }
            if (driverBarV2Model.farModel.personData != null) {
                final DriverPersonData driverPersonData = driverBarV2Model.farModel.personData;
                if (!Utils.isDestroy(this.mContext)) {
                    ((RequestBuilder) Glide.with(this.mContext).asBitmap().load(driverPersonData.avatar).placeholder((int) R.drawable.driver_card_default_avatar_v2)).into(this.f12931e);
                }
                if (driverPersonData.nameInfo == null || TextUtils.isEmpty(driverPersonData.nameInfo.getContent())) {
                    this.f12932f.setVisibility(8);
                } else {
                    this.f12932f.setVisibility(0);
                    driverPersonData.nameInfo.bindTextView(this.f12932f);
                }
                if (driverPersonData.score == null || TextUtils.isEmpty(driverPersonData.score.getContent())) {
                    this.f12949w.setVisibility(8);
                    this.f12946t.setVisibility(8);
                } else {
                    this.f12949w.setVisibility(0);
                    this.f12946t.setVisibility(0);
                    driverPersonData.score.bindTextView(this.f12949w);
                }
                if (driverPersonData.orderCount == null || TextUtils.isEmpty(driverPersonData.orderCount.getContent())) {
                    this.f12948v.setVisibility(8);
                } else {
                    if (this.f12949w.getVisibility() == 0) {
                        this.f12947u.setVisibility(0);
                    } else {
                        this.f12947u.setVisibility(8);
                    }
                    this.f12948v.setVisibility(0);
                    driverPersonData.orderCount.bindTextView(this.f12948v);
                }
                this.f12933g.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        DriverBarFarFieldView.this.dispatchDriverClicked(new Pair("type", "2"));
                    }
                });
                this.f12931e.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        GlobalOmegaUtils.trackEvent("ibt_gp_tripservice_driverhead_ck", "type", "2");
                        new AvatarEnlargePopup(DriverBarFarFieldView.this.mContext, LayoutInflater.from(DriverBarFarFieldView.this.mContext).inflate(R.layout.driver_avatar_enlarge_popup, (ViewGroup) null), -1, -1, driverPersonData.avatar).show();
                    }
                });
            }
            if (driverBarV2Model.benefitModel == null || driverBarV2Model.benefitModel.info == null || TextUtils.isEmpty(driverBarV2Model.benefitModel.info.getContent())) {
                this.f12936j.setVisibility(8);
                return;
            }
            this.f12936j.setVisibility(0);
            if (TextUtils.isEmpty(driverBarV2Model.benefitModel.colorStar) || TextUtils.isEmpty(driverBarV2Model.benefitModel.colorEnd)) {
                i2 = Color.parseColor("#FFFFFF");
                i = Color.parseColor("#FFFFFF");
            } else {
                try {
                    i2 = Color.parseColor(driverBarV2Model.benefitModel.colorStar);
                    i = Color.parseColor(driverBarV2Model.benefitModel.colorEnd);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    i2 = Color.parseColor("#FFFFFF");
                    i = Color.parseColor("#FFFFFF");
                }
            }
            this.f12936j.setBackground(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{i2, i}));
            driverBarV2Model.benefitModel.info.bindTextView(this.f12934h);
            if (!TextUtils.isEmpty(driverBarV2Model.benefitModel.benefitLink)) {
                this.f12936j.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        DriverBarFarFieldView.this.mPresenter.onBenefitTextClick(driverBarV2Model.benefitModel.benefitLink);
                    }
                });
            }
            if (!TextUtils.isEmpty(driverBarV2Model.benefitModel.icon)) {
                this.f12935i.setVisibility(0);
                if (!Utils.isDestroy(this.mContext)) {
                    Glide.with(this.mContext).asBitmap().load(driverBarV2Model.benefitModel.icon).into(this.f12935i);
                    return;
                }
                return;
            }
            this.f12935i.setVisibility(8);
        }
    }

    public void nearPickupShow(EtaEda etaEda) {
        super.nearPickupShow(etaEda);
        this.mPresenter.nearPickUpSwitch();
        ((Vibrator) this.mContext.getSystemService("vibrator")).vibrate(new long[]{10, 100, 10, 100}, -1);
        DriverBarV2Model driverBarV2Model = this.f12938l;
        if (!(driverBarV2Model == null || driverBarV2Model.nearModel == null)) {
            DriverCarData driverCarData = this.f12938l.nearModel.carData;
            if (driverCarData != null) {
                if (driverCarData.licenseNum != null && !TextUtils.isEmpty(driverCarData.licenseNum.getContent())) {
                    this.f12943q.setText(driverCarData.licenseNum.getContent());
                }
                if (!Utils.isDestroy(this.mContext)) {
                    ((RequestBuilder) Glide.with(this.mContext).asBitmap().load(driverCarData.icon).placeholder((int) R.drawable.global_driver_bar_default_car)).into(this.f12941o);
                }
            }
            DriverPersonData driverPersonData = this.f12938l.nearModel.personData;
            if (driverPersonData != null) {
                if (!Utils.isDestroy(this.mContext)) {
                    ((RequestBuilder) Glide.with(this.mContext).asBitmap().load(driverPersonData.avatar).placeholder((int) R.drawable.driver_card_default_avatar_v2)).into(this.f12942p);
                }
                if (driverPersonData.nameInfo == null || TextUtils.isEmpty(driverPersonData.nameInfo.getContent())) {
                    this.f12950x.setVisibility(8);
                } else {
                    this.f12950x.setVisibility(0);
                    driverPersonData.nameInfo.bindTextView(this.f12950x);
                }
                if (driverPersonData.score == null || TextUtils.isEmpty(driverPersonData.score.getContent())) {
                    this.f12951y.setVisibility(8);
                    this.f12926C.setVisibility(8);
                } else {
                    if (this.f12950x.getVisibility() == 8) {
                        this.f12924A.setVisibility(8);
                    } else {
                        this.f12924A.setVisibility(0);
                    }
                    this.f12951y.setVisibility(0);
                    this.f12926C.setVisibility(0);
                    driverPersonData.score.bindTextView(this.f12951y);
                }
                if (driverPersonData.orderCount == null || TextUtils.isEmpty(driverPersonData.orderCount.getContent())) {
                    this.f12952z.setVisibility(8);
                } else {
                    if (this.f12950x.getVisibility() == 0 || this.f12951y.getVisibility() == 0) {
                        this.f12925B.setVisibility(0);
                    } else {
                        this.f12925B.setVisibility(8);
                    }
                    this.f12952z.setVisibility(0);
                    driverPersonData.orderCount.bindTextView(this.f12952z);
                }
            }
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f12945s, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setDuration(200);
        this.f12944r.setVisibility(0);
        this.f12939m.setVisibility(0);
        this.f12943q.setVisibility(4);
        this.f12928b.setVisibility(8);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f12930d.getLayoutParams();
        layoutParams.topMargin = 0;
        this.f12930d.setLayoutParams(layoutParams);
        final ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f12931e, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f12933g, "alpha", new float[]{1.0f, 0.0f});
        ofFloat2.setDuration(300);
        ofFloat3.setDuration(300);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f12942p, "alpha", new float[]{0.0f, 1.0f});
        ofFloat4.setDuration(300);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f12940n, "alpha", new float[]{0.0f, 1.0f});
        ofFloat5.setDuration(300);
        final ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f12944r, "alpha", new float[]{0.0f, 1.0f});
        ofFloat6.setDuration(300);
        final ObjectAnimator objectAnimator = ofFloat;
        final ObjectAnimator objectAnimator2 = ofFloat3;
        final ObjectAnimator objectAnimator3 = ofFloat4;
        final ObjectAnimator objectAnimator4 = ofFloat5;
        getView().post(new Runnable() {
            public void run() {
                int measuredWidth = DriverBarFarFieldView.this.mContainerView.getMeasuredWidth() / 2;
                int left = DriverBarFarFieldView.this.f12939m.getLeft();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(DriverBarFarFieldView.this.f12939m, "translationX", new float[]{(float) ((measuredWidth - left) - (DriverBarFarFieldView.this.f12939m.getMeasuredWidth() / 2))});
                ofFloat.setDuration(400);
                int top = DriverBarFarFieldView.this.f12939m.getTop();
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(DriverBarFarFieldView.this.f12939m, "translationY", new float[]{38.0f - ((float) top)});
                ofFloat2.setDuration(400);
                int left2 = DriverBarFarFieldView.this.f12943q.getLeft();
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(DriverBarFarFieldView.this.f12943q, "translationX", new float[]{(float) (((measuredWidth - left2) - (DriverBarFarFieldView.this.f12943q.getMeasuredWidth() / 2)) + 25)});
                ofFloat3.setDuration(400);
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(DriverBarFarFieldView.this.f12943q, "translationY", new float[]{(float) (255 - DriverBarFarFieldView.this.f12943q.getTop())});
                ofFloat4.setDuration(400);
                int left3 = DriverBarFarFieldView.this.f12930d.getLeft();
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(DriverBarFarFieldView.this.f12930d, "translationX", new float[]{(float) (((measuredWidth - left3) - (DriverBarFarFieldView.this.f12930d.getMeasuredWidth() / 2)) - 4)});
                ofFloat5.setDuration(400);
                ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(DriverBarFarFieldView.this.f12930d, "translationY", new float[]{(float) (390 - DriverBarFarFieldView.this.f12930d.getTop())});
                ofFloat6.setDuration(400);
                int left4 = DriverBarFarFieldView.this.f12944r.getLeft();
                ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(DriverBarFarFieldView.this.f12944r, "translationX", new float[]{(float) ((measuredWidth - left4) - (DriverBarFarFieldView.this.f12944r.getMeasuredWidth() / 2))});
                ofFloat7.setDuration(400);
                ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(DriverBarFarFieldView.this.f12944r, "translationY", new float[]{(float) (448 - DriverBarFarFieldView.this.f12944r.getTop())});
                ofFloat8.setDuration(400);
                ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(DriverBarFarFieldView.this.mIMContainer, "translationY", new float[]{-8.0f});
                ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(DriverBarFarFieldView.this.mPhoneContainer, "translationY", new float[]{-8.0f});
                DriverBarFarFieldView.this.f12943q.setVisibility(0);
                DriverBarFarFieldView.this.f12929c.setVisibility(4);
                DriverBarFarFieldView.this.f12943q.setTypeface(DIDIFontUtils.Companion.getDidiTypeface(DriverBarFarFieldView.this.mContext, Typeface.defaultFromStyle(1)));
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{20, 35});
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        DriverBarFarFieldView.this.f12943q.setTextSize((float) ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                ObjectAnimator objectAnimator = ofFloat9;
                ofInt.setDuration(400);
                ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{12, 14});
                ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        SpannableString spannableString = new SpannableString(DriverBarFarFieldView.this.f12930d.getText());
                        spannableString.setSpan(new AbsoluteSizeSpan(intValue, true), 0, DriverBarFarFieldView.this.f12930d.length(), 33);
                        DriverBarFarFieldView.this.f12930d.setText(spannableString);
                    }
                });
                ObjectAnimator objectAnimator2 = ofFloat10;
                ValueAnimator ofInt3 = ValueAnimator.ofInt(new int[]{DriverBarFarFieldView.this.mContainerView.getMeasuredHeight(), UiUtils.dip2px(DriverBarFarFieldView.this.mContext, 250.0f)});
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        ViewGroup.LayoutParams layoutParams = DriverBarFarFieldView.this.mContainerView.getLayoutParams();
                        layoutParams.height = intValue;
                        DriverBarFarFieldView.this.mContainerView.setLayoutParams(layoutParams);
                        DriverBarFarFieldView.this.mContainerView.requestLayout();
                    }
                });
                ofInt3.setDuration(400);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(new Animator[]{objectAnimator, ofFloat2, objectAnimator2, ofInt3, ofFloat, ofFloat2, objectAnimator3, ofInt, ofFloat6, ofFloat3, ofFloat4, ofFloat5, ofFloat6, ofFloat7, ofInt2, ofFloat8, objectAnimator, objectAnimator2, objectAnimator4});
                animatorSet.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        DriverBarFarFieldView.this.f12937k.showNearView();
                    }
                });
                animatorSet.start();
            }
        });
        traceEvent(etaEda);
    }

    public void newMessageBubbleShow(boolean z) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f12945s.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = UiUtils.dip2px(this.mContext, 0.0f);
        } else {
            layoutParams.bottomMargin = UiUtils.dip2px(this.mContext, 15.0f);
        }
        this.f12945s.setLayoutParams(layoutParams);
    }

    public void traceEvent(EtaEda etaEda) {
        Address address;
        HashMap hashMap = new HashMap();
        if (etaEda != null) {
            hashMap.put("eda", Integer.valueOf(etaEda.eda));
        }
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.mContext).getLastKnownLocation();
        CarOrder order = CarOrderHelper.getOrder();
        if (!(order == null || (address = order.startAddress) == null || lastKnownLocation == null)) {
            hashMap.put("distance", Double.valueOf(DDSphericalUtil.computeDistanceBetween(new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()), new LatLng(address.latitude, address.longitude))));
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_waitfordriver_nearbyaddress_sw", (Map<String, Object>) hashMap);
    }
}
