package com.didi.component.driverbar.impl;

import android.app.Activity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.common.widget.CircleImageView;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.driverbar.AbsDriverBarPresenter;
import com.didi.component.driverbar.IDriverBarV2LockScreenView;
import com.didi.component.driverbar.model.DriverBarCardInfo;
import com.didi.component.driverbar.model.DriverBarStyle;
import com.didi.component.driverbar.model.DriverBarV2Model;
import com.didi.component.driverbar.model.DriverCarData;
import com.didi.component.driverbar.util.DriverBarInfoUtilsKt;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.async.AsyncLayoutFactory;
import com.taxis99.R;

public class DriverBarV2V2LockScreenView implements IViewContainer, IDriverBarV2LockScreenView {
    public static final String TAG = DriverBarV2V2LockScreenView.class.getName();

    /* renamed from: a */
    private TextView f12979a = ((TextView) this.mContainerView.findViewById(R.id.driver_bar_lock_screen_car_name));

    /* renamed from: b */
    private TextView f12980b = ((TextView) this.mContainerView.findViewById(R.id.driver_bar_lock_screen_car_info));

    /* renamed from: c */
    private ImageView f12981c = ((ImageView) this.mContainerView.findViewById(R.id.driver_card_car_image));

    /* renamed from: d */
    private CircleImageView f12982d = ((CircleImageView) this.mContainerView.findViewById(R.id.driver_card_driver_avatar));

    /* renamed from: e */
    private TextView f12983e = ((TextView) this.mContainerView.findViewById(R.id.driver_card_driver_avatar_red_point));

    /* renamed from: f */
    private DriverBarV2Model f12984f;
    protected View mContainerView;
    protected Activity mContext;
    protected AbsDriverBarPresenter mPresenter;

    public ViewGroup getContainer(int i) {
        return null;
    }

    public void handleBluetoothMeetEntranceShow(Boolean bool) {
    }

    public void hideBlueMeetGuide() {
    }

    public void hideCarUpdateInfo() {
    }

    public boolean isPhoneVisible() {
        return false;
    }

    public void nearPickupShow(EtaEda etaEda) {
    }

    public void newMessageBubbleShow(boolean z) {
    }

    public void setDriverBarStyle(DriverBarStyle driverBarStyle) {
    }

    public void setPhoneVisible(boolean z) {
    }

    public void showCarUpdateInfo(String str, String str2, String str3, String str4) {
    }

    public void showPhoneGuide(String str) {
    }

    public DriverBarV2V2LockScreenView(Activity activity, ViewGroup viewGroup) {
        m8800a(activity, viewGroup);
        this.mContext = activity;
        this.f12982d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.LockScreen.EVENT_PANEL_CLICK);
            }
        });
    }

    /* renamed from: a */
    private void m8800a(Activity activity, ViewGroup viewGroup) {
        View viewByResId = AsyncLayoutFactory.getInstance().getViewByResId(R.layout.driver_bar_v2_view_lock_screen);
        if (viewByResId == null) {
            viewByResId = LayoutInflater.from(activity).inflate(R.layout.driver_bar_v2_view_lock_screen, viewGroup, false);
        }
        this.mContainerView = viewByResId;
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.mPresenter.setComponentCreator(iComponentCreator);
    }

    public void setData(DriverBarV2Model driverBarV2Model) {
        String str = TAG;
        SystemUtils.log(4, str, "setData: " + driverBarV2Model, (Throwable) null, "com.didi.component.driverbar.impl.DriverBarV2V2LockScreenView", 97);
        this.f12984f = driverBarV2Model;
        if (driverBarV2Model != null && driverBarV2Model.farModel != null) {
            this.mContainerView.setVisibility(0);
            if (this.f12984f.farModel.carData != null) {
                DriverCarData driverCarData = driverBarV2Model.farModel.carData;
                if (!TextUtils.isEmpty(driverCarData.icon)) {
                    ((RequestBuilder) Glide.with(this.mContext).asBitmap().load(driverCarData.icon).placeholder((int) R.drawable.global_driver_bar_default_car)).into(this.f12981c);
                }
                if (driverCarData.licenseNum != null && !TextUtils.isEmpty(driverCarData.licenseNum.getContent())) {
                    driverCarData.licenseNum.bindTextView(this.f12979a);
                }
                SpannableString spannableString = new SpannableString(" · ");
                this.f12980b.setText("");
                if (driverCarData.carTypeInfo != null && !TextUtils.isEmpty(driverCarData.carTypeInfo.getContent())) {
                    this.f12980b.append(driverCarData.carTypeInfo.parseRichInfo(this.mContext));
                }
                if (driverCarData.carColorInfo != null && !TextUtils.isEmpty(driverCarData.carColorInfo.getContent())) {
                    SpannableString parseRichInfo = driverCarData.carColorInfo.parseRichInfo(this.mContext);
                    if (this.f12980b.getText().length() != 0) {
                        this.f12980b.append(spannableString);
                    }
                    this.f12980b.append(parseRichInfo);
                }
            }
            if (this.f12984f.farModel.personData != null) {
                ((RequestBuilder) Glide.with(this.mContext).asBitmap().load(driverBarV2Model.farModel.personData.avatar).placeholder((int) R.drawable.driver_card_default_big_avatar)).into((ImageView) this.f12982d);
            }
        }
    }

    public void setData(DriverBarCardInfo driverBarCardInfo) {
        setData(DriverBarInfoUtilsKt.toDriverBarV2Model(driverBarCardInfo));
    }

    public View getView() {
        return this.mContainerView;
    }

    public void setPresenter(AbsDriverBarPresenter absDriverBarPresenter) {
        this.mPresenter = absDriverBarPresenter;
    }

    public void setUnreadMsg(int i) {
        this.f12983e.setText(String.valueOf(i));
        this.f12983e.setVisibility(i == 0 ? 8 : 0);
    }
}
