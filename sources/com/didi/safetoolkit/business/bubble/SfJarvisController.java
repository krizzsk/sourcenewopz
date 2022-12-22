package com.didi.safetoolkit.business.bubble;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.didi.flutter.nacho.Nacho;
import com.didi.flutter.nacho.p114ui.UIHelper;
import com.didi.global.safetoolkit.SafetoolkitPlugin;
import com.didi.safetoolkit.api.ISfJarvisService;
import com.didi.safetoolkit.api.SfConstant;
import com.didi.safetoolkit.business.JarvisDataHelper;
import com.didi.safetoolkit.business.bubble.BubbleSwitcherView;
import com.didi.safetoolkit.business.bubble.ISafePresenter;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.safetoolkit.business.triprecording.TripRecordingManager;
import com.didi.safetoolkit.omega.SfOmegaUtil;
import com.didi.safetoolkit.router.SfRouter;
import com.didi.safetoolkit.router.SfRouterUtil;
import com.didi.safetoolkit.util.SfListenerManager;
import com.didi.safetoolkit.util.SfOmegaOptListener;
import com.didi.safetoolkit.util.SfOnAntiShakeClickListener;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.Map;
import p242io.flutter.plugin.common.MethodChannel;

public class SfJarvisController implements ISfJarvisController {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f34274a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ISafePresenter f34275b;

    /* renamed from: c */
    private BubbleView f34276c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SfJarvisData f34277d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f34278e;

    /* renamed from: f */
    private boolean f34279f = false;

    /* renamed from: g */
    private SafetoolkitPlugin f34280g;

    /* renamed from: h */
    private SafetoolkitPlugin.DataHandler f34281h = new SafetoolkitPlugin.DataHandler() {
        public void onGetInfo(MethodChannel.Result result) {
            if (SfJarvisController.this.f34277d != null) {
                try {
                    result.success(new Gson().toJson((Object) SfJarvisController.this.f34277d));
                } catch (Exception e) {
                    e.printStackTrace();
                    result.error("", "", (Object) null);
                }
            } else {
                result.error("", "", (Object) null);
            }
        }

        public void onDetached() {
            Uri parse = Uri.parse(SfJarvisController.this.f34278e);
            String path = parse.getPath();
            if (!TextUtils.isEmpty(path) && SfRouter.OPEN_PANEL.equals(path) && !TextUtils.isEmpty(parse.getQueryParameter(SfRouter.BUBBLE_ID))) {
                String queryParameter = parse.getQueryParameter(SfRouter.BUBBLE_ID);
                SfJarvisController sfJarvisController = SfJarvisController.this;
                sfJarvisController.m24249a(sfJarvisController.f34274a, queryParameter);
            }
        }
    };

    public SfJarvisController(Context context) {
        this.f34274a = context;
        this.f34276c = new BubbleView(this.f34274a);
        this.f34275b = new SafePresenter(context);
        if (!m24253a()) {
            init();
        }
    }

    public SfJarvisController(Context context, int i) {
        this.f34274a = context;
        BubbleView bubbleView = new BubbleView(this.f34274a, i);
        this.f34276c = bubbleView;
        bubbleView.setIconSize(i);
        this.f34275b = new SafePresenter(context);
        if (!m24253a()) {
            init();
        }
    }

    /* renamed from: a */
    private boolean m24253a() {
        IToggle toggle = Apollo.getToggle("sf_flutter_engine_delay_init");
        if (toggle == null || !toggle.allow() || ((Integer) toggle.getExperiment().getParam("initdelay", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public View getView() {
        return this.f34276c;
    }

    public void setBubbleStatusAndShow(final SfBubbleData sfBubbleData) {
        if (sfBubbleData == null) {
            this.f34276c.setVisibleExceptImg(false);
            this.f34276c.updateSwitcher((SfBubbleData) null, (BubbleSwitcherView.ClickListener) null);
            this.f34276c.setBubbleSymbol(SfConstant.SfDangerLevel.LEVEL_NORMAL);
            this.f34276c.setBubbleBg("#FFFCFEFF");
            this.f34276c.setOnClickListener(new SfOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    String str;
                    SfJarvisController.this.init();
                    if (SfJarvisController.this.f34277d == null || SfJarvisController.this.f34277d.menus == null || SfJarvisController.this.f34277d.banner == null) {
                        ISfJarvisService iSfJarvisService = (ISfJarvisService) ServiceLoader.load(ISfJarvisService.class, SafeToolKit.getIns().getBusinessType()).get();
                        if (iSfJarvisService != null) {
                            iSfJarvisService.nullShieldClick(SfJarvisController.this.f34274a);
                            return;
                        }
                        return;
                    }
                    if (SfJarvisController.this.f34277d.timeline == null) {
                        str = "?_nacho_container_tag=safe_toolkit&_nacho_height=" + UIHelper.flutterDesignPx2NativePx(SfJarvisController.this.f34274a, (float) ((SfJarvisController.this.f34277d.menus.size() * 168) + 304));
                    } else {
                        str = "";
                    }
                    SfJarvisController.this.f34275b.onActionClick("globalOneTravel://one/safety/safety_panel" + str);
                    SfOmegaUtil.addEventId("ibt_gp_safetyicon_btn_ck").report();
                }
            });
            return;
        }
        this.f34276c.setVisibleExceptImg(true);
        this.f34276c.setBubbleSymbol(sfBubbleData.dangerLevel);
        this.f34276c.setBubbleBg(sfBubbleData.bgColor);
        this.f34276c.updateSwitcher(sfBubbleData, new BubbleSwitcherView.ClickListener() {
            public void onActionClick(String str) {
                String unused = SfJarvisController.this.f34278e = str;
                SfJarvisController.this.f34275b.onActionClick(str);
            }
        });
        this.f34276c.setOnClickListener(new SfOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                String str;
                SfJarvisController.this.init();
                if (SfJarvisController.this.f34277d != null && SfJarvisController.this.f34277d.menus != null && SfJarvisController.this.f34277d.banner != null) {
                    if (SfJarvisController.this.f34277d.timeline == null) {
                        str = "?_nacho_container_tag=safe_toolkit&_nacho_height=" + UIHelper.flutterDesignPx2NativePx(SfJarvisController.this.f34274a, (float) ((SfJarvisController.this.f34277d.menus.size() * 168) + 304));
                    } else {
                        str = "";
                    }
                    SfJarvisController.this.f34275b.onActionClick("globalOneTravel://one/safety/safety_panel" + str);
                    SfOmegaUtil.addEventId("ibt_gp_safetyicon_btn_ck").addKeyValue(SfOmegaUtil.getJsonObjectMap(sfBubbleData.track)).report();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24252a(SfBubbleData sfBubbleData) {
        if (sfBubbleData != null) {
            String str = sfBubbleData.dangerLevel;
            Map<String, Object> jsonObjectMap = SfOmegaUtil.getJsonObjectMap(sfBubbleData.track);
            char c = 65535;
            switch (str.hashCode()) {
                case -1955878649:
                    if (str.equals(SfConstant.SfDangerLevel.LEVEL_NORMAL)) {
                        c = 0;
                        break;
                    }
                    break;
                case -224957234:
                    if (str.equals(SfConstant.SfDangerLevel.LEVEL_LOW_MEDIUM_RISK)) {
                        c = 2;
                        break;
                    }
                    break;
                case 1310068556:
                    if (str.equals(SfConstant.SfDangerLevel.LEVEL_HIGH_RISK)) {
                        c = 3;
                        break;
                    }
                    break;
                case 1795442690:
                    if (str.equals(SfConstant.SfDangerLevel.LEVEL_IMPORTANT)) {
                        c = 1;
                        break;
                    }
                    break;
            }
            String str2 = c != 0 ? c != 1 ? c != 2 ? c != 3 ? "" : "red" : "yellow" : "blue" : "white";
            if (m24255a(jsonObjectMap)) {
                SfOmegaUtil.addEventId("ibt_gp_safetyicon_view_sw").addKeyValue(jsonObjectMap).addKeyValue("style", str2).report();
            }
        }
    }

    /* renamed from: a */
    private boolean m24254a(SfJarvisData sfJarvisData) {
        return (sfJarvisData == null || sfJarvisData.menus == null || sfJarvisData.banner == null) ? false : true;
    }

    public void refreshJarvisData(SfJarvisData sfJarvisData) {
        this.f34277d = sfJarvisData;
        if (Nacho.getInstance().isFlutterOnTop() && m24254a(sfJarvisData)) {
            if (this.f34280g == null) {
                this.f34280g = (SafetoolkitPlugin) Nacho.getInstance().getPlugin(SafetoolkitPlugin.class);
            }
            SafetoolkitPlugin safetoolkitPlugin = this.f34280g;
            if (safetoolkitPlugin != null) {
                safetoolkitPlugin.updateInfo(new Gson().toJson((Object) this.f34277d));
            }
        }
        boolean z = true;
        try {
            if (!this.f34279f && !TripRecordingManager.Companion.getInstance().isRecording() && JarvisDataHelper.openVoice(sfJarvisData) && (this.f34274a instanceof Activity)) {
                this.f34279f = true;
                TripRecordingManager.Companion.getInstance().startAndPermission((Activity) this.f34274a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f34275b.refreshJarvisData(sfJarvisData, new ISafePresenter.Callback() {
            public void callback(SfBubbleData sfBubbleData, boolean z) {
                SfJarvisController.this.setBubbleStatusAndShow(sfBubbleData);
                if (z) {
                    SfJarvisController.this.m24252a(sfBubbleData);
                }
            }
        });
        if (SfListenerManager.getMonitorUpdateListener() != null && sfJarvisData != null && sfJarvisData.menus != null && sfJarvisData.menus.size() > 0) {
            Iterator<JsonElement> it = sfJarvisData.menus.iterator();
            while (it.hasNext()) {
                JsonElement next = it.next();
                if (next instanceof JsonObject) {
                    String asString = ((JsonObject) next).get("action").getAsString();
                    if (!TextUtils.isEmpty(asString)) {
                        Uri parse = Uri.parse(asString);
                        String path = parse.getPath();
                        if (!TextUtils.isEmpty(path) && path.equals(SfRouter.TRIP_MONITOR)) {
                            SfViewMonitorMenuModel sfViewMonitorMenuModel = new SfViewMonitorMenuModel();
                            sfViewMonitorMenuModel.canMonitor = SfRouterUtil.parseInt(parse.getQueryParameter("enable_notice"), 0) == 1;
                            if (SfRouterUtil.parseInt(parse.getQueryParameter("monitor_type"), 0) != 2) {
                                z = false;
                            }
                            sfViewMonitorMenuModel.isMonitoring = z;
                            sfViewMonitorMenuModel.pushId = parse.getQueryParameter("push_id");
                            sfViewMonitorMenuModel.alertTile = parse.getQueryParameter("alert_title");
                            sfViewMonitorMenuModel.btnOkText = parse.getQueryParameter("button_ok");
                            sfViewMonitorMenuModel.btnJumpText = parse.getQueryParameter("button_to_safety");
                            sfViewMonitorMenuModel.pageTitle = parse.getQueryParameter("detail_page_title");
                            sfViewMonitorMenuModel.imgUrl = parse.getQueryParameter("detail_page_imgurl");
                            sfViewMonitorMenuModel.monitorDesc = parse.getQueryParameter("detail_page_content");
                            sfViewMonitorMenuModel.monitorStateText = parse.getQueryParameter("detail_page_monitor_state_text");
                            SfListenerManager.getMonitorUpdateListener().monitorUpdate(sfViewMonitorMenuModel);
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    public void closeSafePanel() {
        Nacho.getInstance().dismissFlutterDialog();
    }

    public void init() {
        if (this.f34280g == null) {
            this.f34280g = (SafetoolkitPlugin) Nacho.getInstance().getPlugin(SafetoolkitPlugin.class);
        }
        SafetoolkitPlugin safetoolkitPlugin = this.f34280g;
        if (safetoolkitPlugin != null) {
            safetoolkitPlugin.setDataHandler(this.f34281h);
        }
    }

    public void onRemove() {
        SafetoolkitPlugin safetoolkitPlugin = this.f34280g;
        if (safetoolkitPlugin != null && safetoolkitPlugin.getDataHandler() == this.f34281h) {
            this.f34280g.setDataHandler((SafetoolkitPlugin.DataHandler) null);
        }
    }

    public void removeCallback() {
        ISafePresenter iSafePresenter = this.f34275b;
        if (iSafePresenter != null) {
            iSafePresenter.removeCallBacks();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24249a(Context context, String str) {
        ISfJarvisService iSfJarvisService = (ISfJarvisService) ServiceLoader.load(ISfJarvisService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfJarvisService != null) {
            iSfJarvisService.monitorAbnormalClick(context, str);
        }
    }

    /* renamed from: a */
    private boolean m24255a(Map<String, Object> map) {
        SfOmegaOptListener sfSpListener = SafeToolKit.getIns().getSfSpListener();
        if (sfSpListener == null || map == null) {
            return false;
        }
        return sfSpListener.isReportOmega(String.valueOf(map.get("status_id")));
    }
}
