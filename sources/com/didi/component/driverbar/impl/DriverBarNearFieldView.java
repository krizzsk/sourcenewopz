package com.didi.component.driverbar.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.OrderComManager;
import com.didi.component.business.util.UiUtils;
import com.didi.component.business.util.Utils;
import com.didi.component.driverbar.AvatarEnlargePopup;
import com.didi.component.driverbar.model.DriverBarV2Model;
import com.didi.component.driverbar.model.DriverCarData;
import com.didi.component.driverbar.model.DriverOptionModel;
import com.didi.component.driverbar.model.DriverPersonData;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.popup.BubbleCloseListener;
import com.didi.map.global.flow.scene.order.serving.components.OrderFloatWindowManager;
import com.didi.sdk.util.ResourcesHelper;
import com.didiglobal.travel.util.view.ViewEx;
import com.taxis99.R;
import kotlin.Pair;
import org.json.JSONException;
import org.json.JSONObject;

public class DriverBarNearFieldView extends DriverBarFieldBase {

    /* renamed from: a */
    private TextView f12953a = ((TextView) findView(R.id.driver_card_car_label));
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView f12954b = ((ImageView) findView(R.id.driver_card_car_image));

    /* renamed from: c */
    private TextView f12955c = ((TextView) findView(R.id.driver_card_car_num));

    /* renamed from: d */
    private TextView f12956d = ((TextView) findView(R.id.driver_card_car_info));

    /* renamed from: e */
    private ImageView f12957e = ((ImageView) findView(R.id.driver_card_person_image));

    /* renamed from: f */
    private TextView f12958f = ((TextView) findView(R.id.driver_card_near_star_text));

    /* renamed from: g */
    private TextView f12959g = ((TextView) findView(R.id.driver_card_near_trip_num));

    /* renamed from: h */
    private TextView f12960h = ((TextView) findView(R.id.driver_card_person_info));

    /* renamed from: i */
    private TextView f12961i = ((TextView) findView(R.id.dot_text1));

    /* renamed from: j */
    private TextView f12962j = ((TextView) findView(R.id.dot_text2));

    /* renamed from: k */
    private View f12963k = findView(R.id.driver_card_person_info_ll);

    /* renamed from: l */
    private ImageView f12964l = ((ImageView) findView(R.id.driver_card_near_star_img));

    /* renamed from: m */
    private ViewGroup f12965m = ((ViewGroup) findView(R.id.driver_card_phone_container));

    /* renamed from: n */
    private ViewGroup f12966n = ((ViewGroup) findView(R.id.driver_card_buleTooth_container));

    /* renamed from: o */
    private ViewGroup f12967o = ((ViewGroup) findView(R.id.driver_card_im_container));

    /* renamed from: p */
    private DriverBarV2Model f12968p;

    /* renamed from: q */
    private ImageView f12969q = ((ImageView) findView(R.id.bluetooth_meet_entrance_icon));

    public DriverBarNearFieldView(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void inflateView(Context context, ViewGroup viewGroup) {
        this.mContainerView = ViewEx.inflateViewAsync(context, (int) R.layout.driver_bar_v2_near_view, viewGroup, false);
    }

    public void setData(DriverBarV2Model driverBarV2Model) {
        if (driverBarV2Model != null && driverBarV2Model.nearModel != null) {
            this.f12968p = driverBarV2Model;
            if (driverBarV2Model.nearModel.carData != null) {
                DriverCarData driverCarData = driverBarV2Model.nearModel.carData;
                if (driverBarV2Model.carLabel != null && !TextUtils.isEmpty(driverBarV2Model.carLabel.getContent())) {
                    driverBarV2Model.carLabel.bindTextView(this.f12953a);
                }
                if (!TextUtils.isEmpty(driverCarData.icon) && !Utils.isDestroy(this.mContext)) {
                    ((RequestBuilder) Glide.with(this.mContext).asBitmap().load(driverCarData.icon).placeholder((int) R.drawable.global_driver_bar_default_car)).into(new CustomTarget<Bitmap>() {
                        public void onLoadCleared(Drawable drawable) {
                        }

                        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                            DriverBarNearFieldView.this.f12954b.setImageBitmap(bitmap);
                            OrderFloatWindowManager.Instance().setModelBitmap(bitmap);
                        }
                    });
                }
                if (driverCarData.licenseNum != null && !TextUtils.isEmpty(driverCarData.licenseNum.getContent())) {
                    driverCarData.licenseNum.bindTextView(this.f12955c);
                    OrderFloatWindowManager.Instance().setLicensePlate(driverCarData.licenseNum.getContent());
                }
                this.f12956d.setText("");
                if (driverCarData.carTypeInfo != null && !TextUtils.isEmpty(driverCarData.carTypeInfo.getContent())) {
                    this.f12956d.append(driverCarData.carTypeInfo.parseRichInfo(this.mContext));
                }
                if (driverCarData.carColorInfo != null && !TextUtils.isEmpty(driverCarData.carColorInfo.getContent())) {
                    SpannableString parseRichInfo = driverCarData.carColorInfo.parseRichInfo(this.mContext);
                    if (!TextUtils.isEmpty(this.f12956d.getText())) {
                        this.f12956d.append(new SpannableString(" · "));
                    }
                    this.f12956d.append(parseRichInfo);
                }
                if (TextUtils.isEmpty(this.f12956d.getText())) {
                    this.f12956d.setVisibility(8);
                } else {
                    this.f12956d.setVisibility(0);
                }
            }
            if (driverBarV2Model.nearModel.personData != null) {
                final DriverPersonData driverPersonData = driverBarV2Model.nearModel.personData;
                if (!Utils.isDestroy(this.mContext)) {
                    ((RequestBuilder) Glide.with(this.mContext).asBitmap().load(driverPersonData.avatar).placeholder((int) R.drawable.driver_card_default_avatar_v2)).into(this.f12957e);
                }
                if (driverPersonData.nameInfo == null || TextUtils.isEmpty(driverPersonData.nameInfo.getContent())) {
                    this.f12960h.setVisibility(8);
                } else {
                    this.f12960h.setVisibility(0);
                    driverPersonData.nameInfo.bindTextView(this.f12960h);
                }
                if (driverPersonData.score == null || TextUtils.isEmpty(driverPersonData.score.getContent())) {
                    this.f12958f.setVisibility(8);
                    this.f12964l.setVisibility(8);
                } else {
                    if (this.f12960h.getVisibility() == 8) {
                        this.f12961i.setVisibility(8);
                    } else {
                        this.f12961i.setVisibility(0);
                    }
                    this.f12958f.setVisibility(0);
                    this.f12964l.setVisibility(0);
                    driverPersonData.score.bindTextView(this.f12958f);
                }
                if (driverPersonData.orderCount == null || TextUtils.isEmpty(driverPersonData.orderCount.getContent())) {
                    this.f12959g.setVisibility(8);
                } else {
                    if (this.f12960h.getVisibility() == 0 || this.f12958f.getVisibility() == 0) {
                        this.f12962j.setVisibility(0);
                    } else {
                        this.f12962j.setVisibility(8);
                    }
                    this.f12959g.setVisibility(0);
                    driverPersonData.orderCount.bindTextView(this.f12959g);
                }
                this.f12963k.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        DriverBarNearFieldView.this.dispatchDriverClicked(new Pair("type", "1"));
                    }
                });
                this.f12957e.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        GlobalOmegaUtils.trackEvent("ibt_gp_tripservice_driverhead_ck", "type", "1");
                        new AvatarEnlargePopup(DriverBarNearFieldView.this.mContext, LayoutInflater.from(DriverBarNearFieldView.this.mContext).inflate(R.layout.driver_avatar_enlarge_popup, (ViewGroup) null), -1, -1, driverPersonData.avatar).show();
                    }
                });
            }
            if (OrderComManager.getInstance().isShowBlueToothEntrance) {
                m8791a(this.f12968p, OrderComManager.getInstance().isShowBlueToothEntrance);
            }
            this.f12969q.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (DriverBarNearFieldView.this.mPresenter != null) {
                        DriverBarNearFieldView.this.mPresenter.bluetoothMeetClick();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m8791a(DriverBarV2Model driverBarV2Model, boolean z) {
        ImageView imageView = (ImageView) findView(R.id.bluetooth_meet_entrance_icon);
        if ((this.f12965m.getLayoutParams() instanceof FrameLayout.LayoutParams) && (this.f12967o.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f12965m.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f12967o.getLayoutParams();
            JSONObject jSONObject = null;
            if (z) {
                if (!TextUtils.isEmpty(driverBarV2Model.bluetoothMeetOption)) {
                    try {
                        jSONObject = new JSONObject(driverBarV2Model.bluetoothMeetOption);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (jSONObject != null) {
                        DriverOptionModel driverOptionModel = new DriverOptionModel();
                        driverOptionModel.parse(jSONObject);
                        ((RequestBuilder) Glide.with(this.mContext).asBitmap().load(driverOptionModel.normalIcon).placeholder((int) R.drawable.bluetooth_entrance_ic)).into(imageView);
                    }
                }
                this.f12966n.setVisibility(0);
                layoutParams.rightMargin = UiUtils.dip2px(this.mContext, 55.0f);
                this.f12966n.findViewById(R.id.bluetooth_meet_entrance_icon);
                layoutParams2.width = UiUtils.dip2px(this.mContext, 205.0f);
                this.f12965m.setLayoutParams(layoutParams);
                this.f12967o.setLayoutParams(layoutParams2);
                if (!GlobalSPUtil.isBluetoothMeetGuideShown(this.mContext)) {
                    m8790a();
                    return;
                }
                return;
            }
            this.f12966n.setVisibility(8);
            layoutParams.rightMargin = UiUtils.dip2px(this.mContext, 0.0f);
            layoutParams2.width = UiUtils.dip2px(this.mContext, -2.0f);
            this.f12965m.setLayoutParams(layoutParams);
            this.f12967o.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: a */
    private void m8790a() {
        FrameLayout frameLayout = (FrameLayout) findView(R.id.bluetooth_meet_bubble_msg_container);
        frameLayout.setVisibility(0);
        ImageView imageView = (ImageView) findView(R.id.bluetooth_meet_entrance_icon);
        if (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(0, UiUtils.dip2px(this.mContext, 70.0f), UiUtils.dip2px(this.mContext, 25.0f), 0);
            frameLayout.removeAllViews();
            frameLayout.addView(LEGOUICreator.createBubble(this.mContext, ResourcesHelper.getString(this.mContext, R.string.GRider_navigation__qvCr), Color.parseColor("#5C6166"), "bottom_right", 3, false, (BubbleCloseListener) null).getView());
        }
        if (this.f12966n.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) this.f12966n.getLayoutParams()).setMargins(0, UiUtils.dip2px(this.mContext, -70.0f), UiUtils.dip2px(this.mContext, -25.0f), 0);
        }
    }

    public void handleBluetoothMeetEntranceShow(Boolean bool) {
        DriverBarV2Model driverBarV2Model = this.f12968p;
        if (driverBarV2Model != null) {
            m8791a(driverBarV2Model, true);
        }
    }

    public void hideBlueMeetGuide() {
        FrameLayout frameLayout = (FrameLayout) findView(R.id.bluetooth_meet_bubble_msg_container);
        if (frameLayout.getVisibility() == 0) {
            frameLayout.setVisibility(8);
            ImageView imageView = (ImageView) findView(R.id.bluetooth_meet_entrance_icon);
            if (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.f12966n.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.f12966n.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        GlobalSPUtil.setBlueMeetGuideShown(this.mContext, true);
    }
}
