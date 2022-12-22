package com.didichuxing.publicservice.resourcecontrol.dialogfragments;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.app.constant.Const;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.network.HttpHelper;
import com.didichuxing.publicservice.resourcecontrol.p197bi.CommonBIUtil;
import com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource;
import com.didichuxing.publicservice.resourcecontrol.utils.C16245Util;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceTrack;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class AssetPopwindowDialogFragment2 extends BaseDialogFragment implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {
    public static String TAG = AssetPopwindowDialogFragment2.class.getSimpleName();
    /* access modifiers changed from: private */
    public float bannerScale = 2.25f;
    /* access modifiers changed from: private */
    public float brandScale = 1.295f;
    private TextView button1;
    private TextView button2;
    private View contentView;
    /* access modifiers changed from: private */
    public DPopResource.DataBean data;
    private View dividerView;
    /* access modifiers changed from: private */
    public Handler handler = new Handler(Looper.getMainLooper());
    private boolean hasNavBar;
    /* access modifiers changed from: private */
    public ImageView imageView;
    private ImageView imgClose;
    private TextView layout1Text1;
    private TextView layout1Text2;
    private TextView layout1Text3;
    private TextView layout1Title;
    private TextView layout2Text1;
    private TextView layout2Text2;
    private TextView layout2Text3;
    private TextView layout2Text4;
    private TextView layout2Text5;
    private TextView layout2Text6;
    private TextView layout2Title;
    private View layoutBanner;
    private View layoutBrand;
    private View loadingView;
    /* access modifiers changed from: private */
    public ImageView logoImageView;
    private View mainView;
    private HashMap map = new HashMap();
    private Boolean showNavBar;

    public static AssetPopwindowDialogFragment2 newInstance(Bundle bundle) {
        AssetPopwindowDialogFragment2 assetPopwindowDialogFragment2 = new AssetPopwindowDialogFragment2();
        assetPopwindowDialogFragment2.setArguments(bundle);
        return assetPopwindowDialogFragment2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.asset_frag_popowindow_layout2, this.rootContainer, true);
        inflate.setOnClickListener(this);
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.hasNavBar = C16245Util.hasNavigationBar(getActivity());
        DPopResource dPopResource = (DPopResource) this.serializable;
        String convertBiz = CommonBIUtil.convertBiz(ConstantUtils.ResourceId.getResource(this.resouceId));
        String valueOf = String.valueOf(dPopResource.data[0].activity_id);
        this.map.put(CommonBIUtil.KEY_RESOURCEID, convertBiz);
        this.map.put(CommonBIUtil.KEY_ACDID, valueOf);
        this.map.putAll(dPopResource.data[0].log_data);
        OmegaSDKAdapter.trackEvent("theone_ppx_publicservice_test16", "", this.map);
        OmegaSDKAdapter.trackEvent(CommonBIUtil.TONE_P_X_HOME_NTPP_SW, (Map<String, Object>) this.map);
        ResourceTrack.trackEventSW(this.map);
        OmegaSDKAdapter.trackEvent("theone_ppx_publicservice_test17", "", this.map);
        this.data = dPopResource.data[0];
        AppUtils.log("pop window data = " + this.data);
        setupView(inflate);
        loadImage();
        return onCreateView;
    }

    private void setupView(View view) {
        this.imgClose = (ImageView) view.findViewById(R.id.close_dialog);
        this.button1 = (TextView) view.findViewById(R.id.button1);
        this.button2 = (TextView) view.findViewById(R.id.button2);
        this.layout1Text1 = (TextView) view.findViewById(R.id.layout1_line1);
        this.layout1Text2 = (TextView) view.findViewById(R.id.layout1_line2);
        this.layout1Text3 = (TextView) view.findViewById(R.id.layout1_line3);
        this.layout1Title = (TextView) view.findViewById(R.id.layout1_title);
        this.layout2Text1 = (TextView) view.findViewById(R.id.layout2_line1);
        this.layout2Text2 = (TextView) view.findViewById(R.id.layout2_line2);
        this.layout2Text3 = (TextView) view.findViewById(R.id.layout2_line3);
        this.layout2Text4 = (TextView) view.findViewById(R.id.layout2_line4);
        this.layout2Text5 = (TextView) view.findViewById(R.id.layout2_line5);
        this.layout2Text6 = (TextView) view.findViewById(R.id.layout2_line6);
        this.layout2Title = (TextView) view.findViewById(R.id.layout2_title);
        this.imageView = (ImageView) view.findViewById(R.id.asset_img);
        this.logoImageView = (ImageView) view.findViewById(R.id.logo);
        this.layoutBrand = view.findViewById(R.id.layout_brand);
        this.layoutBanner = view.findViewById(R.id.layout_banner);
        this.dividerView = view.findViewById(R.id.divider);
        View findViewById = view.findViewById(R.id.main);
        this.mainView = findViewById;
        findViewById.setOnClickListener(this);
        this.loadingView = view.findViewById(R.id.loading);
        this.contentView = view.findViewById(R.id.content_view);
        this.imgClose.setOnClickListener(this);
        switchToLoading();
        this.imageView.post(new Runnable() {
            public void run() {
                AssetPopwindowDialogFragment2.this.parseDataType();
            }
        });
    }

    private void loadImage() {
        HttpHelper.requestBitmap(this.data.dataDetail.image, new HttpHelper.BitmapRequestCallBack() {
            public void onSuccess(final Bitmap bitmap) {
                if (bitmap == null) {
                    onFail(-1);
                } else {
                    AssetPopwindowDialogFragment2.this.handler.post(new Runnable() {
                        public void run() {
                            AssetPopwindowDialogFragment2.this.imageView.setImageBitmap(bitmap);
                            SystemUtils.log(3, "AppUtils", "bmp width = " + bitmap.getWidth() + ",height = " + bitmap.getHeight() + ",scale = " + (((float) bitmap.getWidth()) / (((float) bitmap.getHeight()) * 1.0f)) + ",type = " + AssetPopwindowDialogFragment2.this.data.dataDetail.type + ",expected scale:banner = " + AssetPopwindowDialogFragment2.this.bannerScale + ",brand = " + AssetPopwindowDialogFragment2.this.brandScale, (Throwable) null, "com.didichuxing.publicservice.resourcecontrol.dialogfragments.AssetPopwindowDialogFragment2$2$1", 139);
                            AssetPopwindowDialogFragment2.this.switchToNormal();
                        }
                    });
                }
            }

            public void onFail(int i) {
                AssetPopwindowDialogFragment2.this.handler.post(new Runnable() {
                    public void run() {
                        AssetPopwindowDialogFragment2.this.imageView.setImageDrawable(AssetPopwindowDialogFragment2.this.getResources().getDrawable(R.drawable.common_zhanwei_didi_logo));
                        AssetPopwindowDialogFragment2.this.imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        AssetPopwindowDialogFragment2.this.switchToNormal();
                    }
                });
                AppUtils.log("load asset image fail,code = " + i);
            }
        });
        HttpHelper.requestBitmap(this.data.dataDetail.logo, new HttpHelper.BitmapRequestCallBack() {
            public void onSuccess(final Bitmap bitmap) {
                AssetPopwindowDialogFragment2.this.handler.post(new Runnable() {
                    public void run() {
                        AssetPopwindowDialogFragment2.this.logoImageView.setImageBitmap(bitmap);
                    }
                });
            }

            public void onFail(int i) {
                AppUtils.log("load logo image fail,code = " + i);
            }
        });
    }

    private void openWeb() {
        if (!TextUtils.isEmpty(this.data.dataDetail.link)) {
            Intent intent = new Intent("didi.passenger.intent.action.WebActivity");
            intent.setComponent(new ComponentName(getActivity(), "com.didi.sdk.webview.WebActivity"));
            intent.putExtra("url", this.data.dataDetail.link);
            startActivity(intent);
            close();
        }
    }

    public void onGlobalLayout() {
        int i;
        Resources resources;
        FragmentActivity activity = getActivity();
        if (this.hasNavBar && activity != null && !activity.isFinishing()) {
            boolean checkDeviceShowNavigationBar = C16245Util.checkDeviceShowNavigationBar(activity.getWindowManager(), activity);
            Boolean bool = this.showNavBar;
            if (bool == null || checkDeviceShowNavigationBar != bool.booleanValue()) {
                AppUtils.log("onGlobalLayout,reset top margin, hasNavBar = " + this.hasNavBar + ",last showNavBar = " + this.showNavBar + ",show = " + checkDeviceShowNavigationBar);
                this.showNavBar = Boolean.valueOf(checkDeviceShowNavigationBar);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mainView.getLayoutParams();
                if (checkDeviceShowNavigationBar) {
                    resources = getResources();
                    i = R.dimen.webview_dialog_show_bar_top;
                } else {
                    resources = getResources();
                    i = R.dimen.webview_dialog_top;
                }
                layoutParams.setMargins(layoutParams.leftMargin, resources.getDimensionPixelOffset(i), layoutParams.rightMargin, layoutParams.bottomMargin);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(layoutParams.leftMargin);
                    layoutParams.setMarginEnd(layoutParams.rightMargin);
                }
                this.mainView.setLayoutParams(layoutParams);
            }
        }
    }

    /* access modifiers changed from: private */
    public void parseDataType() {
        DPopResource.DataBean dataBean = this.data;
        if (dataBean == null || dataBean.dataDetail == null || this.data.dataDetail.type == null) {
            AppUtils.log("data is null");
            return;
        }
        DPopResource.DataDetail dataDetail = this.data.dataDetail;
        String str = dataDetail.type;
        char c = 65535;
        switch (str.hashCode()) {
            case -1396342996:
                if (str.equals(Const.ComponentType.BANNER)) {
                    c = 2;
                    break;
                }
                break;
            case -1376697729:
                if (str.equals("brandWithButton")) {
                    c = 1;
                    break;
                }
                break;
            case 93997959:
                if (str.equals("brand")) {
                    c = 0;
                    break;
                }
                break;
            case 576711652:
                if (str.equals("bannerWithButton")) {
                    c = 3;
                    break;
                }
                break;
        }
        if (c == 0 || c == 1) {
            if ("brand".equals(str)) {
                this.button1.setVisibility(8);
            } else if ("brandWithButton".equals(str)) {
                this.layout1Text2.setVisibility(8);
                this.layout1Text3.setVisibility(8);
                this.button1.setVisibility(0);
                this.button1.setText(dataDetail.btnText);
                this.button1.setTextColor(Color.parseColor(dataDetail.btnColor));
            }
            this.layoutBrand.setVisibility(0);
            this.layoutBanner.setVisibility(8);
            this.layout1Text1.setText(dataDetail.line1);
            this.layout1Text2.setText(dataDetail.line2);
            this.layout1Text3.setText(dataDetail.line3);
            this.layout1Title.setText(dataDetail.title);
            this.button1.setOnClickListener(this);
            resetImageViewScale(this.brandScale);
            updateViewStatus(this.layout1Text1, dataDetail.line1);
            updateViewStatus(this.layout1Text2, dataDetail.line2);
            updateViewStatus(this.layout1Text3, dataDetail.line3);
        } else if (c == 2 || c == 3) {
            if (Const.ComponentType.BANNER.equals(str)) {
                this.button2.setVisibility(8);
            } else if ("bannerWithButton".equals(str)) {
                this.button2.setVisibility(0);
                this.button2.setText(dataDetail.btnText);
                try {
                    this.button2.setTextColor(Color.parseColor(dataDetail.btnColor));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.layoutBanner.setVisibility(0);
            this.layoutBrand.setVisibility(8);
            this.layout2Text1.setText(dataDetail.line1);
            this.layout2Text2.setText(dataDetail.line2);
            this.layout2Text3.setText(dataDetail.line3);
            this.layout2Text4.setText(dataDetail.line4);
            this.layout2Text5.setText(dataDetail.line5);
            this.layout2Text6.setText(dataDetail.line6);
            this.layout2Title.setText(dataDetail.title);
            updateViewStatus(this.layout2Text1, dataDetail.line1);
            updateViewStatus(this.layout2Text2, dataDetail.line2);
            updateViewStatus(this.layout2Text3, dataDetail.line3);
            updateViewStatus(this.layout2Text4, dataDetail.line4);
            updateViewStatus(this.layout2Text5, dataDetail.line5);
            updateViewStatus(this.layout2Text6, dataDetail.line6);
            this.button2.setOnClickListener(this);
            resetImageViewScale(this.bannerScale);
        }
        this.imageView.setTag(str);
    }

    private void updateViewStatus(View view, String str) {
        if (str == null) {
            view.setVisibility(8);
        } else if (str.equals("")) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
    }

    private void resetImageViewScale(float f) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.imageView.getLayoutParams();
        layoutParams.height = (int) (((float) this.imageView.getWidth()) / f);
        SystemUtils.log(3, "AppUtils", "resetImageViewScale,imageView height = " + this.imageView.getHeight() + ",imageView width = " + this.imageView.getWidth(), (Throwable) null, "com.didichuxing.publicservice.resourcecontrol.dialogfragments.AssetPopwindowDialogFragment2", 299);
        this.imageView.setLayoutParams(layoutParams);
    }

    private void switchToLoading() {
        this.loadingView.setVisibility(0);
        this.contentView.setVisibility(4);
        this.dividerView.setVisibility(4);
        this.logoImageView.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public void switchToNormal() {
        this.loadingView.setVisibility(4);
        this.contentView.setVisibility(0);
        this.dividerView.setVisibility(0);
        this.logoImageView.setVisibility(0);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.close_dialog) {
            OmegaSDKAdapter.trackEvent(CommonBIUtil.TONE_P_X_HOME_NTPPQ_CK, (Map<String, Object>) this.map);
            close();
        } else if (id == R.id.button2 || id == R.id.button1 || id == R.id.main) {
            openWeb();
        } else {
            close();
        }
    }
}
