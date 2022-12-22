package com.didichuxing.mas.sdk.quality.report.analysis;

import android.app.Application;
import android.text.TextUtils;
import com.didi.sdk.util.EventKeys;
import com.didichuxing.mas.sdk.quality.report.MASCallback;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.collector.CPUCollector;
import com.didichuxing.mas.sdk.quality.report.collector.CustomCollector;
import com.didichuxing.mas.sdk.quality.report.collector.DeviceCollector;
import com.didichuxing.mas.sdk.quality.report.collector.NetworkCollector;
import com.didichuxing.mas.sdk.quality.report.collector.PackageCollector;
import com.didichuxing.mas.sdk.quality.report.collector.PersistentInfoCollector;
import com.didichuxing.mas.sdk.quality.report.collector.ScreenCollector;
import com.didichuxing.mas.sdk.quality.report.collector.StorageCollector;
import com.didichuxing.mas.sdk.quality.report.record.Event;
import com.didichuxing.omega.sdk.common.utils.Constants;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Timer;
import java.util.TimerTask;

public class AsyncWorker {
    public static void doAsyncInit(Application application) {
        new Timer("OmegaSDK.asyncInit").schedule(new TimerTask() {
            public void run() {
                if (MASCallback.iAsyncInit != null) {
                    MASCallback.iAsyncInit.init();
                }
                EventStorageFixed.uploadLastEvent();
            }
        }, 300);
    }

    public static void trackODAT() {
        if (PersistentInfoCollector.ifNeedODAT()) {
            Event event = new Event("OMGODAT");
            long[] externalStorage = StorageCollector.getExternalStorage();
            event.putAttr("disk_total", Long.valueOf(externalStorage[0]));
            event.putAttr("disk_free", Long.valueOf(externalStorage[1]));
            event.putAttr("app_total_size", Long.valueOf(StorageCollector.getAppTotalSize()));
            event.putNetType();
            event.putAttr("screen_size", ScreenCollector.getScreenSize());
            event.putAttr("cpuAbi", CPUCollector.getCpuArchitecture());
            event.putAttr("omg_key", EncrypteUtil.getDesKey());
            event.putAttr("paired_bluetooth", PackageCollector.getBlueToothList());
            event.putAttr("isEmulator", Integer.valueOf(DeviceCollector.getEmulatorType()));
            event.putNetType();
            event.putAttr("mcc", NetworkCollector.getNetworkOperatorMCC());
            event.putAttr("mnc", NetworkCollector.getNetworkOperatorMNC());
            event.putAttr("msin", NetworkCollector.getNetworkOperatorMSIN());
            event.putAttr("udid", CustomCollector.getDidiDeviceId());
            event.putAttr("usid", CustomCollector.getDidiSuuid());
            event.putAttr("ucid", CustomCollector.getGetUiCid());
            event.putAttr("channel", CustomCollector.getChannel());
            event.putAttr(EventKeys.USER_AGENT_PREFIX, DeviceCollector.getUserAgent());
            event.putAttr("andid", DeviceCollector.getAndroidId());
            if (!TextUtils.isEmpty(MASConfig.OMEGA_OAID)) {
                event.putAttr(Constants.JSON_KEY_OMEGA_OAID, MASConfig.OMEGA_OAID);
            }
            OmegaSDKAdapter.trackMasEvent(event);
        }
    }
}
