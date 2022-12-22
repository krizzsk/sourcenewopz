package com.didichuxing.publicservice.resourcecontrol.dialogfragments;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.onehybrid.container.FusionWebChromeClient;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.container.FusionWebViewClient;
import com.didi.onehybrid.util.C10393Util;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.p197bi.CommonBIUtil;
import com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceTrack;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class AssetWebviewDialogFragment extends BaseDialogFragment implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {
    /* access modifiers changed from: private */
    public static final String TAG = AssetWebviewDialogFragment.class.getSimpleName();
    private static AssetWebviewDialogFragment assetWebviewFragment;
    /* access modifiers changed from: private */
    public RelativeLayout assetNetworkError;
    private boolean hasNavBar;
    /* access modifiers changed from: private */
    public LinearLayout loading;
    /* access modifiers changed from: private */
    public String lwrate;
    /* access modifiers changed from: private */
    public FusionWebView mWebView;
    /* access modifiers changed from: private */
    public View mainView;
    /* access modifiers changed from: private */
    public Map<String, Object> map = new HashMap();
    private int realHeight;
    private Boolean showNavBar;
    /* access modifiers changed from: private */
    public String url = "";

    public static AssetWebviewDialogFragment newInstance(Bundle bundle) {
        AssetWebviewDialogFragment assetWebviewDialogFragment = new AssetWebviewDialogFragment();
        assetWebviewFragment = assetWebviewDialogFragment;
        assetWebviewDialogFragment.setArguments(bundle);
        return assetWebviewFragment;
    }

    public static AssetWebviewDialogFragment getFragment() {
        return assetWebviewFragment;
    }

    public void onDestroyView() {
        assetWebviewFragment = null;
        super.onDestroyView();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.hasNavBar = hasNavigationBar(getActivity());
        final View inflate = layoutInflater.inflate(R.layout.asset_frag_webview_layout, this.rootContainer, true);
        this.mainView = inflate.findViewById(R.id.main);
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(this);
        C10393Util.isWebViewAvailableAsync(getActivity(), new C10393Util.WebViewAvailableCallBack() {
            public void call(boolean z) {
                RelativeLayout unused = AssetWebviewDialogFragment.this.assetNetworkError = (RelativeLayout) inflate.findViewById(R.id.aseet_network_error);
                LinearLayout unused2 = AssetWebviewDialogFragment.this.loading = (LinearLayout) inflate.findViewById(R.id.loading);
                inflate.findViewById(R.id.close_dialog).setOnClickListener(AssetWebviewDialogFragment.this);
                AssetWebviewDialogFragment.this.assetNetworkError.setOnClickListener(AssetWebviewDialogFragment.this);
                if (!z) {
                    if (!AppUtils.networkStatusOK(AssetWebviewDialogFragment.this.getActivity())) {
                        AssetWebviewDialogFragment.this.loading.setVisibility(8);
                        AssetWebviewDialogFragment.this.assetNetworkError.setVisibility(0);
                        return;
                    }
                    AssetWebviewDialogFragment.this.loading.setVisibility(0);
                    AssetWebviewDialogFragment.this.assetNetworkError.setVisibility(8);
                } else if (AssetWebviewDialogFragment.this.activity != null) {
                    FusionWebView unused3 = AssetWebviewDialogFragment.this.mWebView = new FusionWebView(AssetWebviewDialogFragment.this.activity);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) AssetWebviewDialogFragment.this.mWebView.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    }
                    AssetWebviewDialogFragment.this.mWebView.setLayoutParams(layoutParams);
                    ((RelativeLayout) inflate.findViewById(R.id.webview_layout)).addView(AssetWebviewDialogFragment.this.mWebView);
                    Bundle arguments = AssetWebviewDialogFragment.this.getArguments();
                    if (arguments != null && arguments.containsKey(ConstantUtils.EXTRA_WEBVIEW_URL)) {
                        String unused4 = AssetWebviewDialogFragment.this.url = arguments.getString(ConstantUtils.EXTRA_WEBVIEW_URL);
                    } else if (arguments == null || !arguments.containsKey(ConstantUtils.EXTRA_RESOURCE_STR)) {
                        AppUtils.log(" " + AssetWebviewDialogFragment.TAG + "showLinkUrl -> fail : ");
                    } else {
                        AssetWebviewDialogFragment.this.serializable = arguments.getSerializable(ConstantUtils.EXTRA_RESOURCE_STR);
                        if (AssetWebviewDialogFragment.this.serializable != null && (AssetWebviewDialogFragment.this.serializable instanceof DPopResource)) {
                            AssetWebviewDialogFragment assetWebviewDialogFragment = AssetWebviewDialogFragment.this;
                            String unused5 = assetWebviewDialogFragment.url = ((DPopResource) assetWebviewDialogFragment.serializable).data[0].dataDetail.address;
                        }
                    }
                    if (AssetWebviewDialogFragment.this.serializable != null && (AssetWebviewDialogFragment.this.serializable instanceof DPopResource)) {
                        DPopResource dPopResource = (DPopResource) AssetWebviewDialogFragment.this.serializable;
                        AssetWebviewDialogFragment.this.map.putAll(dPopResource.data[0].log_data);
                        String unused6 = AssetWebviewDialogFragment.this.lwrate = dPopResource.data[0].dataDetail.lwrate;
                        AssetWebviewDialogFragment.this.map.put(CommonBIUtil.KEY_ACDID, Integer.valueOf(dPopResource.data == null ? 0 : dPopResource.data[0].activity_id));
                        AssetWebviewDialogFragment.this.map.put("key", "pas_notice");
                        AssetWebviewDialogFragment.this.map.put(CommonBIUtil.KEY_RESOURCEID, CommonBIUtil.convertBiz(ConstantUtils.ResourceId.getResource(AssetWebviewDialogFragment.this.resouceId)));
                        OmegaSDKAdapter.trackEvent(CommonBIUtil.TONE_P_X_HOME_NTPP_SW, (Map<String, Object>) AssetWebviewDialogFragment.this.map);
                        ResourceTrack.trackEventSW(AssetWebviewDialogFragment.this.map);
                    }
                    WebSettings settings = AssetWebviewDialogFragment.this.mWebView.getSettings();
                    settings.setJavaScriptEnabled(true);
                    settings.getUserAgentString();
                    settings.setDomStorageEnabled(true);
                    settings.setLoadsImagesAutomatically(true);
                    AssetWebviewDialogFragment.this.mWebView.setWebViewClient(new FusionWebViewClient(AssetWebviewDialogFragment.this.mWebView) {
                        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                            AppUtils.log("shouldOverrideUrlLoading,url = " + str);
                            return super.shouldOverrideUrlLoading(webView, str);
                        }

                        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                            AppUtils.log("onPageStarted,url = " + str);
                        }

                        public void onPageFinished(WebView webView, String str) {
                            AppUtils.log("onPageFinished");
                            AssetWebviewDialogFragment.this.loading.setVisibility(8);
                        }

                        public void onReceivedError(WebView webView, int i, String str, String str2) {
                            AppUtils.log("onReceivedError");
                            AssetWebviewDialogFragment.this.loading.setVisibility(8);
                            AssetWebviewDialogFragment.this.mWebView.setVisibility(8);
                            AssetWebviewDialogFragment.this.assetNetworkError.setVisibility(0);
                        }
                    });
                    AssetWebviewDialogFragment.this.mWebView.setWebChromeClient(new FusionWebChromeClient(AssetWebviewDialogFragment.this.mWebView) {
                        public void onProgressChanged(WebView webView, int i) {
                            AssetWebviewDialogFragment.this.mWebView.hiddenLoadProgress();
                        }
                    });
                    if (!AppUtils.networkStatusOK(AssetWebviewDialogFragment.this.getActivity())) {
                        AssetWebviewDialogFragment.this.loading.setVisibility(8);
                        AssetWebviewDialogFragment.this.mWebView.setVisibility(8);
                        AssetWebviewDialogFragment.this.assetNetworkError.setVisibility(0);
                    } else {
                        AssetWebviewDialogFragment.this.loading.setVisibility(0);
                        AssetWebviewDialogFragment.this.mWebView.setVisibility(0);
                        AssetWebviewDialogFragment.this.assetNetworkError.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(ResourceManager.getManager().getDevice().token)) {
                        if (AssetWebviewDialogFragment.this.url != null && (AssetWebviewDialogFragment.this.url.contains("?") || AssetWebviewDialogFragment.this.url.contains(ParamKeys.SIGN_AND))) {
                            AssetWebviewDialogFragment assetWebviewDialogFragment2 = AssetWebviewDialogFragment.this;
                            String unused7 = assetWebviewDialogFragment2.url = AssetWebviewDialogFragment.this.url + "&token=" + ResourceManager.getManager().getDevice().token;
                        } else if (AssetWebviewDialogFragment.this.url != null) {
                            if (AssetWebviewDialogFragment.this.url.endsWith("/")) {
                                AssetWebviewDialogFragment assetWebviewDialogFragment3 = AssetWebviewDialogFragment.this;
                                String unused8 = assetWebviewDialogFragment3.url = AssetWebviewDialogFragment.this.url + "?token=" + ResourceManager.getManager().getDevice().token;
                            } else {
                                AssetWebviewDialogFragment assetWebviewDialogFragment4 = AssetWebviewDialogFragment.this;
                                String unused9 = assetWebviewDialogFragment4.url = AssetWebviewDialogFragment.this.url + "/?token=" + ResourceManager.getManager().getDevice().token;
                            }
                        }
                    }
                    AppUtils.log("webview , load  url = " + AssetWebviewDialogFragment.this.url);
                    AssetWebviewDialogFragment.this.mWebView.loadUrl(AssetWebviewDialogFragment.this.url);
                    AssetWebviewDialogFragment.this.mainView.post(new Runnable() {
                        public void run() {
                            ViewGroup.LayoutParams layoutParams = AssetWebviewDialogFragment.this.mainView.getLayoutParams();
                            try {
                                float parseFloat = Float.parseFloat(AssetWebviewDialogFragment.this.lwrate);
                                if (parseFloat > 0.0f) {
                                    layoutParams.height = (int) (((float) layoutParams.width) * parseFloat);
                                }
                                if (parseFloat < 1.0f) {
                                    ((RelativeLayout.LayoutParams) AssetWebviewDialogFragment.this.mainView.getLayoutParams()).addRule(13);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            AssetWebviewDialogFragment.this.mainView.setLayoutParams(layoutParams);
                        }
                    });
                }
            }
        });
        return onCreateView;
    }

    private void setClient() {
        this.mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                AppUtils.log("shouldOverrideUrlLoading,url = " + str);
                return super.shouldOverrideUrlLoading(webView, str);
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                AppUtils.log("onPageStarted,url = " + str);
            }

            public void onPageFinished(WebView webView, String str) {
                AppUtils.log("onPageFinished");
                AssetWebviewDialogFragment.this.loading.setVisibility(8);
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                AppUtils.log("onReceivedError");
                AssetWebviewDialogFragment.this.loading.setVisibility(8);
                AssetWebviewDialogFragment.this.mWebView.setVisibility(8);
                AssetWebviewDialogFragment.this.assetNetworkError.setVisibility(0);
            }
        });
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.close_dialog) {
            OmegaSDKAdapter.trackEvent(CommonBIUtil.TONE_P_X_HOME_NTPPQ_CK, this.map);
            close();
        } else if (view.getId() != R.id.aseet_network_error) {
        } else {
            if (!AppUtils.networkStatusOK(getActivity())) {
                this.mWebView.setVisibility(8);
                this.assetNetworkError.setVisibility(0);
                return;
            }
            this.loading.setVisibility(0);
            this.mWebView.setVisibility(0);
            this.assetNetworkError.setVisibility(8);
            this.mWebView.loadUrl(this.url);
        }
    }

    public void onGlobalLayout() {
        int i;
        Resources resources;
        FragmentActivity activity = getActivity();
        if (this.hasNavBar && activity != null && !activity.isFinishing()) {
            boolean checkDeviceShowNavigationBar = checkDeviceShowNavigationBar(activity.getWindowManager());
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

    private boolean hasNavigationBar(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            defaultDisplay.getMetrics(displayMetrics);
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics2);
            } else {
                Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(defaultDisplay, new Object[]{displayMetrics2});
            }
            this.realHeight = displayMetrics2.heightPixels;
            Resources resources = activity.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"qemu.hw.mainkeys"});
            if ("1".equals(str)) {
                return false;
            }
            if ("0".equals(str)) {
                return true;
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean checkDeviceShowNavigationBar(WindowManager windowManager) {
        if (this.realHeight == -1) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        if (this.realHeight - displayMetrics.heightPixels > 0) {
            return true;
        }
        return false;
    }
}
