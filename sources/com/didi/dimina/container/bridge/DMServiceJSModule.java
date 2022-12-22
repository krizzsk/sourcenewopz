package com.didi.dimina.container.bridge;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.base.DMServiceSubBridgeModule;
import com.didi.dimina.container.bridge.base.JsInterface;
import com.didi.dimina.container.bridge.plugin.GlobalJSModuleManager;
import com.didi.dimina.container.messager.jsmodule.BaseServiceModule;
import com.didi.dimina.container.messager.jsmodule.JSModuleWrapper;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.SafeNavigateUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

public class DMServiceJSModule extends BaseServiceModule {
    public static final String EXPORT_NAME = "DMServiceBridgeModule";
    private final FragmentActivity mActivity;
    /* access modifiers changed from: private */
    public final DMServiceJSModuleLazyParameter parameter;

    public DMServiceJSModule(DMMina dMMina) {
        super(dMMina);
        LogUtil.m13411i("DiminaServiceJSModule init start");
        this.parameter = new DMServiceJSModuleLazyParameter(dMMina);
        this.mActivity = dMMina.getActivity();
        this.parameter.init();
        doSubModulePreOperate(dMMina);
        LogUtil.m13411i("DiminaServiceJSModule init end  ");
    }

    @JsInterface({"getJSModuleLazyParameter"})
    public DMServiceJSModuleLazyParameter getJSModuleLazyParameter() {
        return this.parameter;
    }

    private void doSubModulePreOperate(DMMina dMMina) {
        for (JSModuleWrapper next : GlobalJSModuleManager.getDMServiceSubJSModuleWrapper(dMMina)) {
            if (((DMServiceSubBridgeModule) next.getJSModuleClass().getAnnotation(DMServiceSubBridgeModule.class)).preCreateInstance()) {
                next.getServiceModuleInstance(dMMina);
            }
        }
    }

    @JsInterface({"launch"})
    public void launch(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigator().mo54467a(jSONObject, callbackFunction);
    }

    @JsInterface({"coreRequestFinished"})
    public void coreRequestFinished(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigator().coreRequestFinished(jSONObject, callbackFunction);
    }

    @JsInterface({"reLaunch"})
    public void reLaunch(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigator().mo54468b(jSONObject, callbackFunction);
    }

    @JsInterface({"redirectTo"})
    public void redirectTo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigator().mo54469c(jSONObject, callbackFunction);
    }

    @JsInterface({"navigateTo"})
    public void navigateTo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        SafeNavigateUtil.safeNavigate(new Function0(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object invoke() {
                return DMServiceJSModule.this.lambda$navigateTo$0$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ Unit lambda$navigateTo$0$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigator().mo54472d(jSONObject, callbackFunction);
        return null;
    }

    @JsInterface({"navigateBack"})
    public void navigateBack(JSONObject jSONObject, CallbackFunction callbackFunction) {
        SafeNavigateUtil.safeNavigate(new Function0(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object invoke() {
                return DMServiceJSModule.this.lambda$navigateBack$1$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ Unit lambda$navigateBack$1$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigator().mo54473e(jSONObject, callbackFunction);
        return null;
    }

    @JsInterface({"getCurrentPages"})
    public void getCurrentPages(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigator().mo54475f(jSONObject, callbackFunction);
    }

    @JsInterface({"switchTab"})
    public void switchTab(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigator().switchTab(jSONObject, callbackFunction);
    }

    @JsInterface({"closeDimina"})
    public void closeDimina(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigator().closeDimina(jSONObject, callbackFunction);
    }

    @JsInterface({"exitMiniProgram"})
    public void exitMiniProgram(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigator().exitMiniProgram(jSONObject, callbackFunction);
    }

    @JsInterface({"showToast"})
    public void showToast(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getToast().mo54720a(jSONObject, callbackFunction);
    }

    @JsInterface({"hideToast"})
    public void hideToast(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getToast().mo54721b(jSONObject, callbackFunction);
    }

    @JsInterface({"setStorage"})
    public void setStorage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getStorage().mo54698a(jSONObject, callbackFunction);
    }

    @JsInterface({"removeStorage"})
    public void removeStorage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getStorage().mo54701c(jSONObject, callbackFunction);
    }

    @JsInterface({"getStorage"})
    public void getStorage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getStorage().mo54703e(jSONObject, callbackFunction);
    }

    @JsInterface({"getStorageInfo"})
    public void getStorageInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getStorage().mo54696a(callbackFunction);
    }

    @JsInterface({"clearStorage"})
    public void clearStorage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getStorage().mo54704f(jSONObject, callbackFunction);
    }

    @JsInterface({"setStorageSync"})
    public void setStorageSync(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getStorage().mo54697a(jSONObject);
    }

    @JsInterface({"removeStorageSync"})
    public JSONObject removeStorageSync(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getStorage().mo54700b(jSONObject, callbackFunction);
    }

    @JsInterface({"getStorageSync"})
    public Object getStorageSync(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getStorage().mo54702d(jSONObject, callbackFunction);
    }

    @JsInterface({"getStorageInfoSync"})
    public JSONObject getStorageInfoSync(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getStorage().mo54695a();
    }

    @JsInterface({"clearStorageSync"})
    public JSONObject clearStorageSync(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getStorage().mo54699b();
    }

    @JsInterface({"logDebug"})
    public void logDebug(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getLog().mo54568a(jSONObject, callbackFunction);
    }

    @JsInterface({"logInfo"})
    public void logInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getLog().mo54569b(jSONObject, callbackFunction);
    }

    @JsInterface({"logWarn"})
    public void logWarn(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getLog().mo54570c(jSONObject, callbackFunction);
    }

    @JsInterface({"logError"})
    public void logError(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getLog().mo54571d(jSONObject, callbackFunction);
    }

    @JsInterface({"getImageInfo"})
    public void getImageInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getImage().mo54441a(jSONObject, callbackFunction);
    }

    @JsInterface({"saveImageToPhotosAlbum"})
    public void saveImageToPhotosAlbum(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getImage().mo54442b(jSONObject, callbackFunction);
    }

    @JsInterface({"compressImage"})
    public void compressImage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getImage().mo54443c(jSONObject, callbackFunction);
    }

    public /* synthetic */ void lambda$setNavigationBarTitle$2$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigationBar().mo54593a(jSONObject, callbackFunction);
    }

    @JsInterface({"setNavigationBarTitle"})
    public void setNavigationBarTitle(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$setNavigationBarTitle$2$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$setNavigationBarColor$3$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigationBar().mo54595b(jSONObject, callbackFunction);
    }

    @JsInterface({"setNavigationBarColor"})
    public void setNavigationBarColor(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$setNavigationBarColor$3$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$setNavigationTitleColor$4$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigationBar().mo54596c(jSONObject, callbackFunction);
    }

    @JsInterface({"setNavigationTitleColor"})
    public void setNavigationTitleColor(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$setNavigationTitleColor$4$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$showNavigationBar$5$DMServiceJSModule(JSONObject jSONObject) {
        this.parameter.getNavigationBar().mo54592a(jSONObject);
    }

    @JsInterface({"showNavigationBar"})
    public void showNavigationBar(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject) {
            public final /* synthetic */ JSONObject f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$showNavigationBar$5$DMServiceJSModule(this.f$1);
            }
        });
    }

    @JsInterface({"hideNavigationBar"})
    public void hideNavigationBar(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$hideNavigationBar$6$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$hideNavigationBar$6$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigationBar().mo54594b(jSONObject);
        CallBackUtil.onSuccess(callbackFunction);
    }

    public /* synthetic */ void lambda$setNavigationBarButton$7$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigationBar().mo54597d(jSONObject, callbackFunction);
    }

    @JsInterface({"setNavigationBarButton"})
    public void setNavigationBarButton(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$setNavigationBarButton$7$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$setNavigationBarClickListener$8$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNavigationBar().mo54598e(jSONObject, callbackFunction);
    }

    @JsInterface({"setNavigationBarClickListener"})
    public void setNavigationBarClickListener(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$setNavigationBarClickListener$8$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    @JsInterface({"getMenuButtonBoundingClientRect"})
    public JSONObject getMenuButtonBoundingClientRect(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getNavigationBar().mo54599f(jSONObject, callbackFunction);
    }

    @JsInterface({"getSystemInfo"})
    public void getSystemInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getSystemInfo().mo54708b(jSONObject, callbackFunction);
    }

    @JsInterface({"getSystemInfoSync"})
    public JSONObject getSystemInfoSync(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getSystemInfo().mo54706a(jSONObject, callbackFunction);
    }

    @JsInterface({"getAccountInfoSync"})
    public JSONObject getAccountInfoSync(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getSystemInfo().mo54710c(jSONObject, callbackFunction);
    }

    @JsInterface({"showPopup"})
    public void showPopup(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getPopup().mo54520a(jSONObject, callbackFunction);
    }

    @JsInterface({"hidePopup"})
    public void hidePopup(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getPopup().mo54521b(jSONObject, callbackFunction);
    }

    public /* synthetic */ void lambda$showActionSheet$9$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getPopup().mo54522c(jSONObject, callbackFunction);
    }

    @JsInterface({"showActionSheet"})
    public void showActionSheet(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$showActionSheet$9$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    @JsInterface({"showModal"})
    public void showModal(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getModal().showModal(jSONObject, callbackFunction);
    }

    @JsInterface({"enableAlertBeforeUnload"})
    public void enableAlertBeforeUnload(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getKeyEvent().enableAlertBeforeUnload(jSONObject, callbackFunction, this.mDimina);
    }

    @JsInterface({"disableAlertBeforeUnload"})
    public void disableAlertBeforeUnload(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getKeyEvent().mo54456a(jSONObject, callbackFunction, this.mDimina);
    }

    @JsInterface({"saveFile"})
    public void saveFile(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getFileOperation().mo54563a(jSONObject, callbackFunction);
    }

    @JsInterface({"removeSavedFile"})
    public void removeSavedFile(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getFileOperation().mo54564b(jSONObject, callbackFunction);
    }

    @JsInterface({"getSavedFileList"})
    public void getSavedFileList(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getFileOperation().mo54565c(jSONObject, callbackFunction);
    }

    @JsInterface({"getFileInfo"})
    public void getFileInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getFileOperation().mo54567e(jSONObject, callbackFunction);
    }

    @JsInterface({"getSavedFileInfo"})
    public void getSavedFileInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getFileOperation().mo54566d(jSONObject, callbackFunction);
    }

    @JsInterface({"showLoading"})
    public void showLoading(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getLoading().showLoading(jSONObject, callbackFunction);
    }

    @JsInterface({"hideLoading"})
    public void hideLoading(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getLoading().hideLoading(jSONObject, callbackFunction);
    }

    @JsInterface({"customShare"})
    public void customShare(JSONObject jSONObject, CallbackFunction callbackFunction) {
        CallBackUtil.onFail("分享失败", callbackFunction);
    }

    @JsInterface({"makePhoneCall"})
    public void makePhoneCall(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getPhone().makePhoneCall(jSONObject, callbackFunction);
    }

    @JsInterface({"setClipboardData"})
    public void setClipboardData(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getClipboard().setClipboardData(jSONObject, callbackFunction);
    }

    @JsInterface({"getClipboardData"})
    public void getClipboardData(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getClipboard().getClipboardData(jSONObject, callbackFunction);
    }

    public /* synthetic */ void lambda$setTabBarStyle$10$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getTabBar().mo54713a(jSONObject, callbackFunction);
    }

    @JsInterface({"setTabBarStyle"})
    public void setTabBarStyle(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$setTabBarStyle$10$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$setTabBarItem$11$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getTabBar().mo54715b(jSONObject, callbackFunction);
    }

    @JsInterface({"setTabBarItem"})
    public void setTabBarItem(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$setTabBarItem$11$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$showTabBarRedDot$12$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getTabBar().mo54716c(jSONObject, callbackFunction);
    }

    @JsInterface({"showTabBarRedDot"})
    public void showTabBarRedDot(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$showTabBarRedDot$12$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    @JsInterface({"hideTabBarRedDot"})
    public void hideTabBarRedDot(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$hideTabBarRedDot$13$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$hideTabBarRedDot$13$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getTabBar().mo54717d(jSONObject, callbackFunction);
    }

    public /* synthetic */ void lambda$setTabBarBadge$14$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getTabBar().mo54718e(jSONObject, callbackFunction);
    }

    @JsInterface({"setTabBarBadge"})
    public void setTabBarBadge(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$setTabBarBadge$14$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$removeTabBarBadge$15$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getTabBar().mo54719f(jSONObject, callbackFunction);
    }

    @JsInterface({"removeTabBarBadge"})
    public void removeTabBarBadge(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$removeTabBarBadge$15$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$showTabBar$16$DMServiceJSModule(CallbackFunction callbackFunction) {
        this.parameter.getTabBar().mo54712a(callbackFunction);
    }

    @JsInterface({"showTabBar"})
    public void showTabBar(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(callbackFunction) {
            public final /* synthetic */ CallbackFunction f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$showTabBar$16$DMServiceJSModule(this.f$1);
            }
        });
    }

    @JsInterface({"hideTabBar"})
    public void hideTabBar(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(callbackFunction) {
            public final /* synthetic */ CallbackFunction f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$hideTabBar$17$DMServiceJSModule(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$hideTabBar$17$DMServiceJSModule(CallbackFunction callbackFunction) {
        this.parameter.getTabBar().mo54714b(callbackFunction);
    }

    @JsInterface({"getLaunchOptionSync"})
    public JSONObject getLaunchOptionSync(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getLaunchOptions().mo54461a(jSONObject, callbackFunction);
    }

    @JsInterface({"getLaunchOptionsSync"})
    public JSONObject getLaunchOptionsSync(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getLaunchOptions().mo54461a(jSONObject, callbackFunction);
    }

    @JsInterface({"invokeServiceReady"})
    public void invokeServiceReady(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getLaunchOptions().mo54462b(jSONObject, callbackFunction);
    }

    @JsInterface({"invokeBusinessReady"})
    public void invokeBusinessReady(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getLaunchOptions().mo54463c(jSONObject, callbackFunction);
    }

    @JsInterface({"getEnterOptionsSync"})
    public JSONObject getEnterOptionsSync(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getLaunchOptions().mo54461a(jSONObject, callbackFunction);
    }

    @JsInterface({"request"})
    public void request(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNetworkSubJSBridge(true).request(jSONObject, callbackFunction);
    }

    @JsInterface({"createRequestTask"})
    public void createRequestTask(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNetworkSubJSBridge(true).createRequestTask(jSONObject, callbackFunction);
    }

    @JsInterface({"operateRequestTask"})
    public void operateRequestTask(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNetworkSubJSBridge(true).operateRequestTask(jSONObject, callbackFunction);
    }

    @JsInterface({"createDownloadTask"})
    public void createDownloadTask(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNetworkSubJSBridge(true).createDownloadTask(jSONObject, callbackFunction);
    }

    @JsInterface({"operateDownloadTask"})
    public void operateDownloadTask(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNetworkSubJSBridge(true).operateDownloadTask(jSONObject, callbackFunction);
    }

    @JsInterface({"createUploadTask"})
    public void createUploadTask(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNetworkSubJSBridge(true).createUploadTask(jSONObject, callbackFunction);
    }

    @JsInterface({"operateUploadTask"})
    public void operateUploadTask(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNetworkSubJSBridge(true).operateUploadTask(jSONObject, callbackFunction);
    }

    @JsInterface({"getNetworkType"})
    public void getNetworkType(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNetworkSubJSBridge(true).getNetworkType(jSONObject, callbackFunction);
    }

    @JsInterface({"uploadFile"})
    public void uploadFile(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNetworkSubJSBridge(true).uploadFile(jSONObject, callbackFunction);
    }

    @JsInterface({"downloadFile"})
    public void downloadFile(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getNetworkSubJSBridge(true).downloadFile(jSONObject, callbackFunction);
    }

    @JsInterface({"startWifi"})
    public void startWifi(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getWifiSubJSBridge(true).starWifi(jSONObject, callbackFunction);
    }

    @JsInterface({"stopWifi"})
    public void stopWifi(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getWifiSubJSBridge(true).stopWifi(jSONObject, callbackFunction);
    }

    @JsInterface({"getConnectedWifi"})
    public void getConnectedWifi(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getWifiSubJSBridge(true).getConnectedWifi(jSONObject, callbackFunction);
    }

    @JsInterface({"unlink"})
    public void unlink(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getFileSystemManager().unlink(jSONObject, callbackFunction);
    }

    @JsInterface({"fileSystemReadFile"})
    public void readFile(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getFileSystemManager().readFile(jSONObject, callbackFunction);
    }

    @JsInterface({"fileSystemReadFileSync"})
    public JSONObject readFileSync(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getFileSystemManager().readFileSync(jSONObject);
    }

    @JsInterface({"fileSystemWriteFile"})
    public void writeFile(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getFileSystemManager().writeFile(jSONObject, callbackFunction);
    }

    @JsInterface({"fileSystemWriteFileSync"})
    public void writeFileSync(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getFileSystemManager().writeFileSync(jSONObject);
    }

    public /* synthetic */ void lambda$previewImage$18$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getImagePreview().startImagePreviewActivity(jSONObject, callbackFunction);
    }

    @JsInterface({"previewImage"})
    public void previewImage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$previewImage$18$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    @JsInterface({"loadJSFileToDataThread"})
    public void loadJSFileToDataThread(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getPackage().mo54694a(jSONObject, callbackFunction);
    }

    public /* synthetic */ void lambda$startPullDownRefresh$19$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getPageRefresh().mo54504a(jSONObject, callbackFunction);
    }

    @JsInterface({"startPullDownRefresh"})
    public void startPullDownRefresh(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$startPullDownRefresh$19$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$stopPullDownRefresh$20$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getPageRefresh().mo54505b(jSONObject, callbackFunction);
    }

    @JsInterface({"stopPullDownRefresh"})
    public void stopPullDownRefresh(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$stopPullDownRefresh$20$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    @JsInterface({"enablePullDownRefresh"})
    public void enablePullDownRefresh(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(callbackFunction) {
            public final /* synthetic */ CallbackFunction f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$enablePullDownRefresh$21$DMServiceJSModule(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$enablePullDownRefresh$21$DMServiceJSModule(CallbackFunction callbackFunction) {
        this.parameter.getPageRefresh().enablePullDownRefresh(callbackFunction);
    }

    @JsInterface({"disablePullDownRefresh"})
    public void disablePullDownRefresh(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(callbackFunction) {
            public final /* synthetic */ CallbackFunction f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$disablePullDownRefresh$22$DMServiceJSModule(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$disablePullDownRefresh$22$DMServiceJSModule(CallbackFunction callbackFunction) {
        this.parameter.getPageRefresh().disablePullDownRefresh(callbackFunction);
    }

    @JsInterface({"openSetting"})
    public void openSetting(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getSettingSubJSBridge().mo54538a(jSONObject, callbackFunction);
    }

    @JsInterface({"authorize"})
    public void authorize(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getSettingSubJSBridge().mo54539b(jSONObject, callbackFunction);
    }

    @JsInterface({"preloadSubPackage"})
    public void preloadSubPackage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getPreLoadSubPackage().preloadSubPackage(jSONObject, callbackFunction);
    }

    @JsInterface({"loadSubPackage"})
    public void loadSubPackage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getLoadSubPackage().loadSubPackage(jSONObject, callbackFunction);
    }

    @JsInterface({"switchTabLoadJSFileToDataThreadFinish"})
    public void switchTabLoadJSFileToDataThreadFinish(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getLoadSubPackage().switchTabLoadJSFileToDataThreadFinish(jSONObject, callbackFunction);
    }

    @JsInterface({"getContextCanvas"})
    public JSONObject getContextCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getCanvas().getContext(jSONObject, callbackFunction);
    }

    @JsInterface({"widthCanvas"})
    public void widthCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().width(jSONObject, callbackFunction);
    }

    @JsInterface({"heightCanvas"})
    public void heightCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().height(jSONObject, callbackFunction);
    }

    @JsInterface({"clearRectCanvas"})
    public void clearRectCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().clearRect(jSONObject, callbackFunction);
    }

    @JsInterface({"fillRectCanvas"})
    public void fillRectCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().fillRect(jSONObject, callbackFunction);
    }

    @JsInterface({"strokeRectCanvas"})
    public void strokeRectCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().strokeRect(jSONObject, callbackFunction);
    }

    @JsInterface({"fillTextCanvas"})
    public void fillTextCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().fillText(jSONObject, callbackFunction);
    }

    @JsInterface({"strokeTextCanvas"})
    public void strokeTextCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().strokeText(jSONObject, callbackFunction);
    }

    @JsInterface({"lineWidthCanvas"})
    public Object lineWidthCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getCanvas().lineWidth(jSONObject, callbackFunction);
    }

    @JsInterface({"lineCapCanvas"})
    public Object lineCapCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getCanvas().lineCap(jSONObject, callbackFunction);
    }

    @JsInterface({"lineJoinCanvas"})
    public Object lineJoinCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getCanvas().lineJoin(jSONObject, callbackFunction);
    }

    @JsInterface({"miterLimitCanvas"})
    public Object miterLimitCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getCanvas().miterLimit(jSONObject, callbackFunction);
    }

    @JsInterface({"fillStyleCanvas"})
    public Object fillStyleCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getCanvas().fillStyle(jSONObject, callbackFunction);
    }

    @JsInterface({"strokeStyleCanvas"})
    public Object strokeStyleCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getCanvas().strokeStyle(jSONObject, callbackFunction);
    }

    @JsInterface({"shadowColorCanvas"})
    public Object shadowColorCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getCanvas().shadowColor(jSONObject, callbackFunction);
    }

    @JsInterface({"shadowBlurCanvas"})
    public Object shadowBlurCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getCanvas().shadowBlur(jSONObject, callbackFunction);
    }

    @JsInterface({"shadowOffsetXCanvas"})
    public Object shadowOffsetXCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getCanvas().shadowOffsetX(jSONObject, callbackFunction);
    }

    @JsInterface({"shadowOffsetYCanvas"})
    public Object shadowOffsetYCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getCanvas().shadowOffsetY(jSONObject, callbackFunction);
    }

    @JsInterface({"closePathCanvas"})
    public void closePathCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().closePath(jSONObject, callbackFunction);
    }

    @JsInterface({"moveToCanvas"})
    public void moveToCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().moveTo(jSONObject, callbackFunction);
    }

    @JsInterface({"lineToCanvas"})
    public void lineToCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().lineTo(jSONObject, callbackFunction);
    }

    @JsInterface({"bezierCurveToCanvas"})
    public void bezierCurveToCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().bezierCurveTo(jSONObject, callbackFunction);
    }

    @JsInterface({"quadraticCurveToCanvas"})
    public void quadraticCurveToCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().quadraticCurveTo(jSONObject, callbackFunction);
    }

    @JsInterface({"arcCanvas"})
    public void arcCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().arc(jSONObject, callbackFunction);
    }

    @JsInterface({"rectCanvas"})
    public void rectCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().rect(jSONObject, callbackFunction);
    }

    @JsInterface({"fillCanvas"})
    public void fillCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().fill(jSONObject, callbackFunction);
    }

    @JsInterface({"strokeCanvas"})
    public void strokeCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().stroke(jSONObject, callbackFunction);
    }

    @JsInterface({"clipCanvas"})
    public void clipCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().clip(jSONObject, callbackFunction);
    }

    @JsInterface({"isPointInPathCanvas"})
    public Object isPointInPathCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getCanvas().isPointInPath(jSONObject, callbackFunction);
    }

    @JsInterface({"rotateCanvas"})
    public void rotateCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().rotate(jSONObject, callbackFunction);
    }

    @JsInterface({"scaleCanvas"})
    public void scaleCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().scale(jSONObject, callbackFunction);
    }

    @JsInterface({"translateCanvas"})
    public void translateCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().translate(jSONObject, callbackFunction);
    }

    @JsInterface({"transformCanvas"})
    public void transformCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().transform(jSONObject, callbackFunction);
    }

    @JsInterface({"setTransformCanvas"})
    public void setTransformCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().setTransform(jSONObject, callbackFunction);
    }

    @JsInterface({"drawImageCanvas"})
    public void drawImageCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().drawImage(jSONObject, callbackFunction);
    }

    @JsInterface({"saveCanvas"})
    public void saveCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().save(jSONObject, callbackFunction);
    }

    @JsInterface({"restoreCanvas"})
    public void restoreCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().restore(jSONObject, callbackFunction);
    }

    @JsInterface({"textAlignCanvas"})
    public Object textAlignCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getCanvas().textAlign(jSONObject, callbackFunction);
    }

    @JsInterface({"fontCanvas"})
    public Object fontCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getCanvas().font(jSONObject, callbackFunction);
    }

    @JsInterface({"beginPathCanvas"})
    public void beginPathCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getCanvas().beginPath(jSONObject, callbackFunction);
    }

    @JsInterface({"toDataURLCanvas"})
    public Object toDataURLCanvas(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getCanvas().toDataURL(jSONObject);
    }

    public /* synthetic */ void lambda$showCapsuleButton$23$DMServiceJSModule(CallbackFunction callbackFunction) {
        this.parameter.getCapsuleButton().setCapsuleButtonVisible(true, callbackFunction);
    }

    @JsInterface({"showCapsuleButton"})
    public void showCapsuleButton(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(callbackFunction) {
            public final /* synthetic */ CallbackFunction f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$showCapsuleButton$23$DMServiceJSModule(this.f$1);
            }
        });
    }

    @JsInterface({"hideCapsuleButton"})
    public void hideCapsuleButton(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(callbackFunction) {
            public final /* synthetic */ CallbackFunction f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$hideCapsuleButton$24$DMServiceJSModule(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$hideCapsuleButton$24$DMServiceJSModule(CallbackFunction callbackFunction) {
        this.parameter.getCapsuleButton().setCapsuleButtonVisible(false, callbackFunction);
    }

    public /* synthetic */ void lambda$vibrateShort$25$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getVibrateSubJSBridge().vibrateShort(jSONObject, callbackFunction);
    }

    @JsInterface({"vibrateShort"})
    public void vibrateShort(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$vibrateShort$25$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$vibrateLong$26$DMServiceJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getVibrateSubJSBridge().vibrateLong(jSONObject, callbackFunction);
    }

    @JsInterface({"vibrateLong"})
    public void vibrateLong(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceJSModule.this.lambda$vibrateLong$26$DMServiceJSModule(this.f$1, this.f$2);
            }
        });
    }

    @JsInterface({"applyUpdate"})
    public void applyUpdate(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getForceUpdateSubJSBridge().applyUpdate(jSONObject, callbackFunction);
    }

    @JsInterface({"getSetting"})
    public void getSettings(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getSettingSubJSBridge().mo54540c(jSONObject, callbackFunction);
    }

    @JsInterface({"updateAudioInstanceState"})
    public void updateAudioState(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getInnerAudioContext(true).updateAudioState(jSONObject, callbackFunction);
    }

    @JsInterface({"audioInstancePlay"})
    public void playAudio(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getInnerAudioContext(true).play(jSONObject, callbackFunction);
    }

    @JsInterface({"audioInstanceStop"})
    public void stopAudio(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getInnerAudioContext(true).stop(jSONObject, callbackFunction);
    }

    @JsInterface({"setBackgroundFetchToken"})
    public void setBackgroundFetchToken(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getFirstTogetherSubJSBridge().mo54136a(jSONObject, callbackFunction);
    }

    @JsInterface({"getBackgroundFetchData"})
    public void getBackgroundFetchData(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getFirstTogetherSubJSBridge().mo54137b(jSONObject, callbackFunction);
    }

    @JsInterface({"firstLaunchDuration"})
    public void firstLaunchDuration(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getFirstTogetherSubJSBridge().mo54138c(jSONObject, callbackFunction);
    }

    @JsInterface({"saveSnapshot"})
    public void saveSnapshot(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getSnapshotSubJSBridge().mo54543a(this.mDimina, jSONObject, callbackFunction);
    }

    @JsInterface({"hideSnapshot"})
    public void hideSnapshot(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getSnapshotSubJSBridge().mo54544b(this.mDimina, jSONObject, callbackFunction);
    }

    @JsInterface({"hideKeyboard"})
    public void hideKeyboard(final JSONObject jSONObject, final CallbackFunction callbackFunction) {
        UIHandlerUtil.runOnUiThread(new Runnable() {
            public void run() {
                DMServiceJSModule.this.parameter.getKeyboard().mo54458a(jSONObject, callbackFunction);
            }
        });
    }

    @JsInterface({"getBatteryInfo"})
    public void getBatteryInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getBatteryInfoBridge().mo54139a(jSONObject, callbackFunction);
    }

    @JsInterface({"getBatteryInfoSync"})
    public JSONObject getBatteryInfoSync(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return this.parameter.getBatteryInfoBridge().mo54140b(jSONObject, callbackFunction);
    }

    @JsInterface({"setScreenBrightness"})
    public void setScreenBrightness(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getScreenBridge().mo54533a(jSONObject, callbackFunction);
    }

    @JsInterface({"setKeepScreenOn"})
    public void setKeepScreenOn(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getScreenBridge().mo54534b(jSONObject, callbackFunction);
    }

    @JsInterface({"getScreenBrightness"})
    public void getScreenBrightness(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getScreenBridge().mo54535c(jSONObject, callbackFunction);
    }

    @JsInterface({"startRecord"})
    public void startRecord(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getRecordSubJSBridge().startRecord(jSONObject, callbackFunction);
    }

    @JsInterface({"stopRecord"})
    public void stopRecord(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getRecordSubJSBridge().stopRecord(jSONObject, callbackFunction);
    }

    @JsInterface({"checkBridgeExist"})
    public void canIUse(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("moduleName");
        if (TextUtils.isEmpty(optString)) {
            optString = "DMServiceBridgeModule";
        }
        this.parameter.getBridgeCheckBridge().checkBridgeExist(jSONObject, optString, callbackFunction);
    }

    @JsInterface({"reportUncaughtError"})
    public void reportUncaughtError(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getUncaughtErrorSubBridge().reportUncaughtError(jSONObject, callbackFunction);
    }

    public void onDestroy() {
        super.onDestroy();
        NetworkSubJSBridge networkSubJSBridge = this.parameter.getNetworkSubJSBridge(false);
        if (networkSubJSBridge != null) {
            networkSubJSBridge.onDestroy();
        }
        InnerAudioContextSubJSBridge innerAudioContext = this.parameter.getInnerAudioContext(false);
        if (innerAudioContext != null) {
            innerAudioContext.onDestroy();
        }
        WifiSubJSBridge wifiSubJSBridge = this.parameter.getWifiSubJSBridge(false);
        if (wifiSubJSBridge != null) {
            wifiSubJSBridge.onDestroy();
        }
    }
}
