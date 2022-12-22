package com.didi.sdk.p154ms.gms.common.update;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import com.didi.sdk.p154ms.common.tasks.OnFailureListener;
import com.didi.sdk.p154ms.common.tasks.OnSuccessListener;
import com.didi.sdk.p154ms.common.update.IAppUpdateInfo;
import com.didi.sdk.p154ms.common.update.IAppUpdateManager;
import com.didi.sdk.p154ms.common.update.IInstallState;
import com.didi.sdk.p154ms.common.update.StateUpdatedListener;
import com.didi.sdk.p154ms.gms.common.GMSType;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import java.util.HashMap;
import java.util.Map;

@ServiceProvider(alias = "GMS", value = {IAppUpdateManager.class})
/* renamed from: com.didi.sdk.ms.gms.common.update.GMSAppUpdateManager */
public class GMSAppUpdateManager extends GMSType implements IAppUpdateManager {
    private AppUpdateManager mGoogleAppUpdateManager;
    private Map<StateUpdatedListener, InstallStateUpdatedListener> mStateUpdatedListenerMap = new HashMap();

    public int getAppUpdateType(boolean z) {
        return z ? 1 : 0;
    }

    public boolean isDownloaded(int i) {
        return i == 11;
    }

    public boolean isForceUpdate(int i) {
        return i == 1;
    }

    public void completeUpdate(Context context) {
        if (checkAndCreateAppUpdateManager(context)) {
            this.mGoogleAppUpdateManager.completeUpdate();
        }
    }

    public boolean startUpdateFlowForResult(IAppUpdateInfo iAppUpdateInfo, int i, Activity activity, int i2) {
        if (!checkAndCreateAppUpdateManager(activity) || !(iAppUpdateInfo instanceof GMSAppUpdateInfo)) {
            return false;
        }
        try {
            return this.mGoogleAppUpdateManager.startUpdateFlowForResult(((GMSAppUpdateInfo) iAppUpdateInfo).getInnerAppUpdateInfo(), i, activity, i2);
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void createAppUpdateInfoTask(Context context, final OnSuccessListener<IAppUpdateInfo> onSuccessListener, final OnFailureListener onFailureListener) {
        if (checkAndCreateAppUpdateManager(context)) {
            Task<AppUpdateInfo> appUpdateInfo = this.mGoogleAppUpdateManager.getAppUpdateInfo();
            appUpdateInfo.addOnSuccessListener(new com.google.android.play.core.tasks.OnSuccessListener<AppUpdateInfo>() {
                public void onSuccess(AppUpdateInfo appUpdateInfo) {
                    OnSuccessListener onSuccessListener = onSuccessListener;
                    if (onSuccessListener != null) {
                        onSuccessListener.onSuccess(new GMSAppUpdateInfo(appUpdateInfo));
                    }
                }
            });
            appUpdateInfo.addOnFailureListener(new com.google.android.play.core.tasks.OnFailureListener() {
                public void onFailure(Exception exc) {
                    OnFailureListener onFailureListener = onFailureListener;
                    if (onFailureListener != null) {
                        onFailureListener.onFailure(exc);
                    }
                }
            });
        }
    }

    public synchronized void registerListener(Context context, final StateUpdatedListener<IInstallState> stateUpdatedListener) {
        if (checkAndCreateAppUpdateManager(context)) {
            if (!this.mStateUpdatedListenerMap.containsKey(stateUpdatedListener)) {
                C125793 r2 = new InstallStateUpdatedListener() {
                    public void onStateUpdate(InstallState installState) {
                        StateUpdatedListener stateUpdatedListener = stateUpdatedListener;
                        if (stateUpdatedListener != null) {
                            stateUpdatedListener.onStateUpdate(new GMSInstallState(installState));
                        }
                    }
                };
                this.mGoogleAppUpdateManager.registerListener(r2);
                this.mStateUpdatedListenerMap.put(stateUpdatedListener, r2);
            }
        }
    }

    public void unregisterListener(Context context, StateUpdatedListener<IInstallState> stateUpdatedListener) {
        if (checkAndCreateAppUpdateManager(context) && this.mStateUpdatedListenerMap.containsKey(stateUpdatedListener)) {
            this.mGoogleAppUpdateManager.unregisterListener(this.mStateUpdatedListenerMap.get(stateUpdatedListener));
        }
    }

    private boolean checkAndCreateAppUpdateManager(Context context) {
        if (this.mGoogleAppUpdateManager != null) {
            return true;
        }
        if (context == null) {
            return false;
        }
        this.mGoogleAppUpdateManager = AppUpdateManagerFactory.create(context);
        return true;
    }
}
