package com.didi.soda.customer.foundation.util.startup;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.didi.foundation.sdk.location.LocationService;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.tracker.LaunchAppTracker;
import com.didi.soda.customer.foundation.util.LocalPermissionHelper;
import com.didi.soda.customer.foundation.util.LocalPermissionHelperPatch;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.foundation.util.SplashUtil;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.topgun.manager.HomeFeedRepo;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;

public class StartLocHelper {

    /* renamed from: a */
    private static boolean f41268a = false;

    /* renamed from: b */
    private static boolean f41269b = false;

    /* renamed from: c */
    private static boolean f41270c = false;

    public static void startLocationFromApp(Application application) {
        if (FallbackController.isOpenPreLoc() && checkInitPermission(application)) {
            LaunchAppTracker.Companion.log(" >>>>> startLocationFromApp ");
            LocationService.getInstance().startLocation(application);
            f41268a = true;
        }
    }

    public static void startLocationFromSplash(Application application) {
        if (!f41268a) {
            LaunchAppTracker.Companion.log(" >>>>> startLocationFromSplash ");
            LocationService.getInstance().startLocation(application);
        }
    }

    public static void startFeedIndexFromApp(Application application) {
        if (FallbackController.isOpenPreFeed() && checkInitPermission(application)) {
            f41269b = true;
            if (((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mFirstOpenTime <= 0) {
                LaunchAppTracker.Companion.log(">>>>> app 首次打开 不请求");
                ((HomeFeedRepo) RepoFactory.getRepo(HomeFeedRepo.class)).abortPreLoad();
                return;
            }
            LaunchAppTracker.Companion.log(">>>>> app 非首次打开 发送请求");
            LaunchAppTracker.Companion.beginTrace("init-WaitLocToRefreshHome");
            ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).locateThenRefreshHome(1);
        }
    }

    public static void startFeedIndexFromMain() {
        if (!f41269b) {
            if (!SplashUtil.isFirstOpen()) {
                LaunchAppTracker.Companion.log(">>>>> main 非首次打开 发送请求");
                LaunchAppTracker.Companion.beginTrace("init-WaitLocToRefreshHome");
                ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).locateThenRefreshHome(1);
            } else {
                LaunchAppTracker.Companion.log(">>>>> main 首次打开 不发送请求");
            }
            ((HomeFeedRepo) RepoFactory.getRepo(HomeFeedRepo.class)).abortPreLoad();
        }
        f41269b = false;
    }

    public static boolean isPreLoc() {
        return f41268a;
    }

    public static void preloadLaunch() {
        f41270c = true;
    }

    public static boolean isPreLoad() {
        return f41270c;
    }

    public static boolean checkInitPermission(Context context) {
        if (context instanceof Activity) {
            return LocalPermissionHelper.checkoutPermission((Activity) context, LocalPermissionHelper.INIT_REQUIRED_PERMISSIONS);
        }
        return LocalPermissionHelperPatch.checkoutPermission(context, LocalPermissionHelper.INIT_REQUIRED_PERMISSIONS);
    }
}
