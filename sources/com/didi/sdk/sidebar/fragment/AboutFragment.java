package com.didi.sdk.sidebar.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BizConstants;
import com.didi.onekeyshare.ShareBuilder;
import com.didi.onekeyshare.ShareConfig;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.wrapper.IPlatform;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.IComponent;
import com.didi.sdk.app.IStatusBar;
import com.didi.sdk.config.GlobalConfigCenter;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.DebugUtils;
import com.didi.sdk.util.FormatUtils;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.didi.share.spi.ComponentManager;
import com.didi.sharesdk.OneKeyShareModel;
import com.didi.sharesdk.ShareApi;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.thirdpartylogin.base.ThirdPartyLoginListener;
import com.didi.thirdpartylogin.base.ThirdPartyLoginManager;
import com.didichuxing.apollo.sdk.Apollo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AboutFragment extends Fragment implements View.OnClickListener, IComponent<BaseBusinessContext>, IStatusBar {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public BaseBusinessContext f37241a;

    /* renamed from: b */
    private View.OnTouchListener f37242b = new View.OnTouchListener() {
        long lastTapTimeMs = 0;
        int numberOfTaps = 0;
        long touchDownMs = 0;

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.touchDownMs = System.currentTimeMillis();
            } else if (action == 1) {
                if (System.currentTimeMillis() - this.touchDownMs > ((long) ViewConfiguration.getTapTimeout())) {
                    this.numberOfTaps = 0;
                    this.lastTapTimeMs = 0;
                } else {
                    if (this.numberOfTaps <= 0 || System.currentTimeMillis() - this.lastTapTimeMs >= ((long) ViewConfiguration.getDoubleTapTimeout())) {
                        this.numberOfTaps = 1;
                    } else {
                        this.numberOfTaps++;
                    }
                    this.lastTapTimeMs = System.currentTimeMillis();
                    if (this.numberOfTaps == 10) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(AboutFragment.this.getActivity());
                        builder.setTitle((CharSequence) "请选择进入调试的功能");
                        builder.setItems((CharSequence[]) new String[]{"网络调试", "HotPatch调试", "连接长链", "断开长链", "打开facebook登录crash", "打开fcebook分享crash", "打开google登录crash", "打开whatsapp分享carsh", "打开email分享frash", "打开复制链接crash", "打开分享图片crash", "Drouter 测试", "分享面板"}, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                                if (i == 0) {
                                    Intent intent = new Intent(AboutFragment.this.getContext().getPackageName() + ".com.didi.sdk.push.ui.check");
                                    intent.setPackage(AboutFragment.this.f37241a.getContext().getPackageName());
                                    AboutFragment.this.f37241a.getContext().startActivity(intent);
                                } else if (i == 1) {
                                    Intent intent2 = new Intent("com.didi.sdk.onehotpatch.debug");
                                    intent2.setPackage(AboutFragment.this.f37241a.getContext().getPackageName());
                                    AboutFragment.this.f37241a.getContext().startActivity(intent2);
                                } else if (i == 2) {
                                    PushClient.getClient().startPush();
                                } else if (i == 3) {
                                    PushClient.getClient().stopPush();
                                } else if (i == 4) {
                                    AboutFragment.this.m26448c();
                                } else if (i == 5) {
                                    AboutFragment.this.m26446b();
                                } else if (i == 6) {
                                    AboutFragment.this.m26450d();
                                } else if (i == 7) {
                                    AboutFragment.this.m26444a(SharePlatform.WHATSAPP_PLATFORM);
                                } else if (i == 8) {
                                    AboutFragment.this.m26444a(SharePlatform.EMAIL_PLATFORM);
                                } else if (i == 9) {
                                    AboutFragment.this.m26444a(SharePlatform.COPY_LINK_PLATFORM);
                                } else if (i == 10) {
                                    AboutFragment.this.m26444a(SharePlatform.SAVEIMAGE_PLATFORM);
                                } else if (i == 11) {
                                    AboutFragment.this.f37241a.getNavigation().transition(AboutFragment.this.f37241a, new Intent(AboutFragment.this.f37241a.getContext(), DRouterTestFragment.class));
                                } else if (i == 12) {
                                    AboutFragment.this.m26443a();
                                }
                            }
                        });
                        builder.setCancelable(false);
                        builder.show();
                    }
                }
            }
            return true;
        }
    };

    public boolean showStatusBar() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        OmegaSDKAdapter.trackEvent("pas_setting_about_ck");
        View inflate = layoutInflater.inflate(R.layout.setting_about, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.about_logo);
        CommonTitleBar commonTitleBar = (CommonTitleBar) inflate.findViewById(R.id.title_bar);
        commonTitleBar.setLeftBackListener(this);
        commonTitleBar.setTitle(FormatUtils.format(getContext(), R.string.setting_about_title, FormatUtils.PLACEHOLDER.BRAND));
        String versionName = SystemUtil.getVersionName(getActivity());
        String brand = NationTypeUtil.getNationComponentData().getBrand();
        ((TextView) inflate.findViewById(R.id.version_info)).setText(brand + " " + versionName);
        Drawable appIcon = AppUtils.getAppIcon(getContext());
        if (appIcon != null) {
            imageView.setImageDrawable(appIcon);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.contact_email);
        GlobalConfigCenter configCenter = GlobalConfigCenter.getConfigCenter();
        configCenter.loadConfig(getContext(), NationTypeUtil.getNationComponentData().getLocCountry());
        String aboutEmail = configCenter.getAboutEmail();
        if (TextUtils.isEmpty(aboutEmail)) {
            inflate.findViewById(R.id.contact_me).setVisibility(4);
        }
        textView.setText(aboutEmail);
        TextView textView2 = (TextView) inflate.findViewById(R.id.copyright_statement);
        String string = getString(R.string.global_copyright_statement);
        String locCountry = NationTypeUtil.getNationComponentData().getLocCountry();
        if (!AppUtils.isGlobalApp(getContext())) {
            inflate.findViewById(R.id.contact_me).setVisibility(8);
            textView.setVisibility(8);
        } else if ("MX".equals(locCountry)) {
            inflate.findViewById(R.id.contact_me).setVisibility(8);
            textView.setVisibility(8);
            textView2.setVisibility(0);
            textView2.setText(string);
        } else if ("JP".equals(locCountry)) {
            textView2.setVisibility(0);
            textView2.setText(getString(R.string.jp_copyright_statement));
            inflate.findViewById(R.id.contact_me).setVisibility(8);
            textView.setVisibility(8);
        } else {
            textView2.setVisibility(8);
            if ("AU".equals(locCountry)) {
                inflate.findViewById(R.id.contact_me).setVisibility(0);
                textView.setText(BizConstants.AUS.CUSTOM_SERVICE_EMAIL);
                textView.setVisibility(0);
            } else {
                inflate.findViewById(R.id.contact_me).setVisibility(8);
                textView.setVisibility(8);
            }
        }
        inflate.findViewById(R.id.version_holder).setOnTouchListener(this.f37242b);
        imageView.setOnTouchListener(this.f37242b);
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26443a() {
        if (DebugUtils.isDebug()) {
            ShareConfig.getConfig().setNation(ShareConfig.Nation.CHINA);
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.add(SharePlatform.WHATSAPP_PLATFORM);
            arrayList.add(SharePlatform.LINE_PLATFORM);
            arrayList.add(SharePlatform.MESSENGER_PLATFORM);
            arrayList.add(SharePlatform.FACEBOOK_PLATFORM);
            arrayList.add(SharePlatform.REFRESH_ICON);
            arrayList.add(SharePlatform.EMAIL_PLATFORM);
            arrayList.add(SharePlatform.TWITTER_PLATFORM);
            arrayList.add(SharePlatform.SAVEIMAGE_PLATFORM);
            arrayList.add(SharePlatform.COPY_LINK_PLATFORM);
            arrayList.add(SharePlatform.TELEGRAM_PLATFORM);
            arrayList.add(SharePlatform.SYSTEM_PLATFORM);
            ShareInfo shareInfo = new ShareInfo();
            shareInfo.type = "image";
            shareInfo.title = "我正在使用滴滴快车，车牌号为[京A6987087]，车主为[测师傅]";
            shareInfo.content = "点击查看行程动态";
            shareInfo.url = "https://d.99app.com/ATwasoa?shareChannel=Whatsapp&share_media=Whatsapp";
            shareInfo.imageUrl = "https://img0.didiglobal.com/static/gstar/img/040Mz5f1H41555315956601.png";
            shareInfo.smsMessage = "I'm riding with Pop. Licence plate number: LOTEST6041240, Driver: 测试号650911131177544.,Tap here to track my ride. https://d.99app.com/uvZOJWI";
            shareInfo.platforms = arrayList;
            shareInfo.extra = new HashMap<>();
            shareInfo.recipients = new ArrayList();
            shareInfo.recipients.add("yuqiang@didiglobal.com");
            shareInfo.recipients.add("yuqiang@didichuxing.com");
            shareInfo.extra = new HashMap<>();
            shareInfo.extra.put("appId", "gh_56f26a7d5943");
            shareInfo.extra.put("path", "/pages/guest/guest");
            shareInfo.extra.put("low_version_url", "xxxerr.html");
            ShareBuilder.buildShare(getActivity(), shareInfo, (ICallback.IPlatformShareCallback) new ICallback.IPlatformShareCallback2() {
                public void onError(SharePlatform sharePlatform, int i) {
                    Context context = AboutFragment.this.getContext();
                    ToastHelper.showLongError(context, "onError " + i);
                }

                public void onComplete(SharePlatform sharePlatform) {
                    SystemUtils.log(6, "onComplete:", sharePlatform.platformName(), (Throwable) null, "com.didi.sdk.sidebar.fragment.AboutFragment$2", 267);
                }

                public void onError(SharePlatform sharePlatform) {
                    SystemUtils.log(6, "onError:", sharePlatform.platformName(), (Throwable) null, "com.didi.sdk.sidebar.fragment.AboutFragment$2", 272);
                }

                public void onCancel(SharePlatform sharePlatform) {
                    SystemUtils.log(6, "onCancel:", sharePlatform.platformName(), (Throwable) null, "com.didi.sdk.sidebar.fragment.AboutFragment$2", 278);
                }
            }, (ICallback.IPlatformClickCallback) new ICallback.IPlatformClickCallback() {
                public void onClickPlatform(OneKeyShareInfo oneKeyShareInfo) {
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26446b() {
        if (DebugUtils.isDebug() || Apollo.getToggle("global_passenger_ninja_control").allow()) {
            ShareApi.show((Activity) null, new OneKeyShareModel(""), (ICallback.IPlatformShareCallback) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m26448c() {
        if (DebugUtils.isDebug() || Apollo.getToggle("global_passenger_ninja_control").allow()) {
            List<AbsThirdPartyLoginBase> thirdPartyLogins = ThirdPartyLoginManager.getThirdPartyLogins();
            int i = 0;
            while (i < thirdPartyLogins.size()) {
                AbsThirdPartyLoginBase absThirdPartyLoginBase = thirdPartyLogins.get(i);
                if (absThirdPartyLoginBase == null || absThirdPartyLoginBase.getChannel() == null || !absThirdPartyLoginBase.getChannel().equalsIgnoreCase("facebook")) {
                    i++;
                } else {
                    absThirdPartyLoginBase.startLogin((Activity) null, (ThirdPartyLoginListener) null);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m26450d() {
        if (DebugUtils.isDebug()) {
            List<AbsThirdPartyLoginBase> thirdPartyLogins = ThirdPartyLoginManager.getThirdPartyLogins();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= thirdPartyLogins.size()) {
                    break;
                }
                AbsThirdPartyLoginBase absThirdPartyLoginBase = thirdPartyLogins.get(i);
                if ("google".equals(absThirdPartyLoginBase.getChannel())) {
                    absThirdPartyLoginBase.startLogin((Activity) null, (ThirdPartyLoginListener) null);
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                ToastHelper.showShortInfo(getContext(), "Its not support Google Login");
            }
        }
    }

    /* renamed from: a */
    private IPlatform m26441a(String str) {
        Iterator<S> componentIterator = ComponentManager.getInstance().getComponentIterator(IPlatform.class);
        while (componentIterator.hasNext()) {
            IPlatform iPlatform = (IPlatform) componentIterator.next();
            if (iPlatform.matchPlatform(str)) {
                return iPlatform;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26444a(SharePlatform sharePlatform) {
        m26441a(sharePlatform.platformName()).share((Context) null, new OneKeyShareInfo(), (ICallback.IPlatformShareCallback) null);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.f37241a.getNavigation().popBackStack();
    }

    public BaseBusinessContext getBusinessContext() {
        return this.f37241a;
    }

    public void setBusinessContext(BaseBusinessContext baseBusinessContext) {
        this.f37241a = baseBusinessContext;
    }
}
