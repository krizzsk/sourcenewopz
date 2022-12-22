package com.didi.sdk.p154ms.common.update;

import android.app.Activity;
import android.content.Context;
import com.didi.sdk.p154ms.common.tasks.OnFailureListener;
import com.didi.sdk.p154ms.common.tasks.OnSuccessListener;

/* renamed from: com.didi.sdk.ms.common.update.IAppUpdateManager */
public interface IAppUpdateManager {
    void completeUpdate(Context context);

    void createAppUpdateInfoTask(Context context, OnSuccessListener<IAppUpdateInfo> onSuccessListener, OnFailureListener onFailureListener);

    int getAppUpdateType(boolean z);

    boolean isDownloaded(int i);

    boolean isForceUpdate(int i);

    void registerListener(Context context, StateUpdatedListener<IInstallState> stateUpdatedListener);

    boolean startUpdateFlowForResult(IAppUpdateInfo iAppUpdateInfo, int i, Activity activity, int i2);

    void unregisterListener(Context context, StateUpdatedListener<IInstallState> stateUpdatedListener);
}
