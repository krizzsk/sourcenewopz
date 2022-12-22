package com.didi.foundation.sdk.application;

import android.app.Application;
import com.didi.foundation.sdk.application.ability.NetSecurityAbility;
import com.didi.foundation.sdk.application.ability.NetStatisticsAbility;
import com.didi.foundation.sdk.application.ability.OmegaAbility;
import com.didi.foundation.sdk.hotpatch.HotPatchConfiguration;
import com.didi.foundation.sdk.hotpatch.HotPatchHelper;
import com.didi.foundation.sdk.location.LocationService;
import com.didi.foundation.sdk.log.LogFileConfiguration;
import com.didi.foundation.sdk.log.LogServiceHelper;
import com.didi.foundation.sdk.login.LoginService;
import com.didi.foundation.sdk.p116im.IMHelper;
import com.didi.foundation.sdk.service.AudioService;
import com.didi.foundation.sdk.service.LocaleService;
import com.didi.foundation.sdk.swarm.Activator;
import com.didi.foundation.sdk.utils.ScheduleTask;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.swarm.launcher.SwarmLauncher;
import didinet.NetEngine;
import org.osgi.framework.FrameworkListener;

@ServiceProvider(priority = -1, value = {ApplicationListener.class})
public class FoundationApplicationListener extends AbstractLifecycleListener {
    private static Application sApplication;
    private NetEngine mEngine = NetEngine.getInstance();

    /* access modifiers changed from: private */
    public void initDetectSdk(Application application) {
    }

    public static Application getApplication() {
        return sApplication;
    }

    public void onCreate(Application application) {
        sApplication = application;
        this.mEngine.create(application.getApplicationContext());
        initOneLogger(application);
        initLoginSdk(application);
        initSwarmSdk(application);
        initLanguage(application);
        initLocation(application);
        initialization(application);
    }

    private void initLocation(Application application) {
        LocationService.getInstance().initLocationManager(application);
    }

    private void initialization(final Application application) {
        ScheduleTask.getInstance().schedule(new Runnable() {
            public void run() {
                FoundationApplicationListener.this.initOmegaSdk(application);
                FoundationApplicationListener.this.initDetectSdk(application);
                FoundationApplicationListener.this.initIMSdk(application);
                FoundationApplicationListener.this.initAudioSdk(application);
                FoundationApplicationListener.this.initSecuritySdk(application);
                FoundationApplicationListener.this.downloadHotPatch(application);
                FoundationApplicationListener.this.initNetwork(application);
            }
        });
    }

    /* access modifiers changed from: private */
    public void initNetwork(Application application) {
        NetStatisticsAbility.init(application, this.mEngine);
    }

    /* access modifiers changed from: private */
    public void initSecuritySdk(Application application) {
        NetSecurityAbility.init(application);
    }

    private void initOneLogger(Application application) {
        LogServiceHelper.config(application, (LogFileConfiguration) ServiceLoader.load(LogFileConfiguration.class).get());
    }

    /* access modifiers changed from: private */
    public void initIMSdk(Application application) {
        IMHelper.initIMEngine(application);
    }

    /* access modifiers changed from: private */
    public void downloadHotPatch(Application application) {
        HotPatchConfiguration hotPatchConfiguration = (HotPatchConfiguration) ServiceLoader.load(HotPatchConfiguration.class).get();
        if (hotPatchConfiguration == null || hotPatchConfiguration.downloadOnApplicationCreate()) {
            HotPatchHelper.downloadHotPatch(application);
        }
    }

    private void initLanguage(Application application) {
        LocaleService.getInstance().init(application);
    }

    private void initLoginSdk(Application application) {
        LoginService.getInstance().init(application);
    }

    /* access modifiers changed from: private */
    public void initAudioSdk(Application application) {
        AudioService.getInstance().init(application);
    }

    private void initSwarmSdk(Application application) {
        SwarmLauncher.getInstance().launch(application, new Activator(application), (String[]) Activator.ASSET_BUNDLES.toArray(new String[Activator.ASSET_BUNDLES.size()]), new FrameworkListener[0]);
    }

    /* access modifiers changed from: private */
    public void initOmegaSdk(Application application) {
        OmegaAbility.init(application);
    }
}
