package com.didi.safetoolkit.business.emergency;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.android.didi.safetoolkit.presenter.AbsPresenter;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.api.ISMonitorDetailsService;
import com.didi.safetoolkit.api.ISfLocationService;
import com.didi.safetoolkit.api.ISfPushManagerService;
import com.didi.safetoolkit.api.ISfUploadLocationService;
import com.didi.safetoolkit.business.emergency.model.SfEmgInfo;
import com.didi.safetoolkit.business.emergency.model.SfEmgStatus;
import com.didi.safetoolkit.business.emergency.store.SfEmergencyAssistanceStore;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.model.SfBaseObject;
import com.didi.safetoolkit.model.SfLocation;
import com.didi.safetoolkit.net.SfResponseListener;
import com.didi.safetoolkit.omega.SfOmegaUtil;
import com.didi.safetoolkit.util.SfLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class SfEmergencyAssistancePresenter extends AbsPresenter<ISfEmergencyAssistanceView> {
    private static final String DEXTER_CLOSED_STATUS = "CLOSED";
    private static final int DEXTER_STOP_PUSH_MESSAGE_TYPE = 151;
    private static final int LOCATION_UPDATE_INTERVAL = 5;
    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private boolean isInLocationSendLoop;
    private boolean isInLocationUpdateLoop;
    /* access modifiers changed from: private */
    public ScheduledFuture locationSendScheduledFuture;
    private ScheduledFuture locationUpdateScheduledFuture;
    /* access modifiers changed from: private */
    public boolean mIsOnEmergencyStatus;
    private ISMonitorDetailsService mService;
    private ISfPushManagerService.ISfPushListener onDexterStatusPushReceivedListener;
    private Runnable sendLocationTask = new Runnable() {
        public void run() {
            SfEmergencyAssistancePresenter.this.sendCurrentLocation();
        }
    };
    private Runnable updateLocationTask = new Runnable() {
        public void run() {
            ((ISfEmergencyAssistanceView) SfEmergencyAssistancePresenter.this.mView).runOnUiThread(new Runnable() {
                public void run() {
                    ((ISfEmergencyAssistanceView) SfEmergencyAssistancePresenter.this.mView).showLocationLoadingStatus();
                    SfEmergencyAssistancePresenter.this.getCurrentLocation(new ISfLocationService.SfCallback() {
                        public void onSucceed(SfLocation sfLocation) {
                            ((ISfEmergencyAssistanceView) SfEmergencyAssistancePresenter.this.mView).showLocationLoadedSucceedStatus(sfLocation);
                        }

                        public void onFailed(String str) {
                            ((ISfEmergencyAssistanceView) SfEmergencyAssistancePresenter.this.mView).showLocationLoadedFailStatus();
                        }
                    });
                }
            });
        }
    };

    private static class StaticISfPushListener implements ISfPushManagerService.ISfPushListener {
        private WeakReference<SfEmergencyAssistancePresenter> mWeakSfEmergencyAssistancePresenter;

        public StaticISfPushListener(SfEmergencyAssistancePresenter sfEmergencyAssistancePresenter) {
            this.mWeakSfEmergencyAssistancePresenter = new WeakReference<>(sfEmergencyAssistancePresenter);
        }

        public void onCommonMsgReceived(int i, String str) {
            SfEmergencyAssistancePresenter sfEmergencyAssistancePresenter;
            if (i == 151) {
                try {
                    if (SfEmergencyAssistancePresenter.DEXTER_CLOSED_STATUS.equals(new JSONObject(str).getString("dexter_status")) && this.mWeakSfEmergencyAssistancePresenter != null && (sfEmergencyAssistancePresenter = (SfEmergencyAssistancePresenter) this.mWeakSfEmergencyAssistancePresenter.get()) != null) {
                        sfEmergencyAssistancePresenter.stopDexter();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public SfEmergencyAssistancePresenter(ISfEmergencyAssistanceView iSfEmergencyAssistanceView) {
        super(iSfEmergencyAssistanceView);
        if (this.mService == null) {
            this.mService = (ISMonitorDetailsService) ServiceLoader.load(ISMonitorDetailsService.class, SafeToolKit.getIns().getBusinessType()).get();
        }
    }

    public void onCreate() {
        super.onCreate();
        SfOmegaUtil.addEventId("gp_safetyToolkit_eHelp_sw").report();
        StaticISfPushListener staticISfPushListener = new StaticISfPushListener(this);
        this.onDexterStatusPushReceivedListener = staticISfPushListener;
        registerPushMessage(staticISfPushListener);
    }

    public void onDestroy() {
        super.onDestroy();
        ScheduledFuture scheduledFuture = this.locationUpdateScheduledFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledFuture scheduledFuture2 = this.locationSendScheduledFuture;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
        }
        this.executorService.shutdown();
        this.updateLocationTask = null;
        ISfPushManagerService.ISfPushListener iSfPushListener = this.onDexterStatusPushReceivedListener;
        if (iSfPushListener != null) {
            unregisterPushMessage(iSfPushListener);
        }
    }

    public void requestEmergencyInfo(final SfResponseListener<SfEmgInfo> sfResponseListener) {
        showPDialog();
        SfEmergencyAssistanceStore.getInstance().getEmergencyInfo(new SfResponseListener<SfEmgInfo>() {
            public void onSuccess(SfEmgInfo sfEmgInfo) {
                SfEmergencyAssistancePresenter.this.closePDialog();
                sfResponseListener.onSuccess(sfEmgInfo);
            }

            public void onError(SfEmgInfo sfEmgInfo) {
                SfEmergencyAssistancePresenter.this.closePDialog();
                if (sfEmgInfo != null) {
                    SfEmergencyAssistancePresenter.this.showToast(sfEmgInfo.errmsg);
                    sfResponseListener.onFail(sfEmgInfo.errno, sfEmgInfo.errmsg);
                }
            }

            public void onFail(int i, String str) {
                SfEmergencyAssistancePresenter.this.closePDialog();
                sfResponseListener.onFail(i, str);
            }
        });
        startLocationUpdateScheduleTask();
    }

    private <T> T getApolloExp(String str, String str2, T t) {
        try {
            return Apollo.getToggle(str).getExperiment().getParam(str2, t);
        } catch (Exception e) {
            SfLog.m24403e(e.getMessage());
            return t;
        }
    }

    private int locationUpdateIntervalFromApollo() {
        return ((Integer) getApolloExp("global_safetytoolkit_location_update_interval", "query_time_interval", 5)).intValue();
    }

    public void startLocationUpdateScheduleTask() {
        if (!this.isInLocationUpdateLoop) {
            this.isInLocationUpdateLoop = true;
            this.locationUpdateScheduledFuture = this.executorService.scheduleAtFixedRate(this.updateLocationTask, 0, (long) locationUpdateIntervalFromApollo(), TimeUnit.SECONDS);
        }
    }

    private int locationUploadIntervalFromApollo() {
        return ((Integer) getApolloExp("global_safetytoolkit_location_update_interval", "upload_time_interval", 5)).intValue();
    }

    /* access modifiers changed from: private */
    public void startLocationSendScheduleTask() {
        if (!this.isInLocationSendLoop) {
            this.isInLocationSendLoop = true;
            this.locationSendScheduledFuture = this.executorService.scheduleAtFixedRate(this.sendLocationTask, 0, (long) locationUploadIntervalFromApollo(), TimeUnit.SECONDS);
        }
    }

    public void requestEmergencyStatus() {
        showPDialog();
        SfEmergencyAssistanceStore.getInstance().getEmergencyStatus(new SfResponseListener<SfEmgStatus>() {
            public void onSuccess(SfEmgStatus sfEmgStatus) {
                SfEmergencyAssistancePresenter.this.closePDialog();
                boolean z = true;
                if (sfEmgStatus.data.isOnEmergencyCallStatus > 0) {
                    boolean unused = SfEmergencyAssistancePresenter.this.mIsOnEmergencyStatus = true;
                    SfEmergencyAssistancePresenter.this.startLocationSendScheduleTask();
                    ((ISfEmergencyAssistanceView) SfEmergencyAssistancePresenter.this.mView).startCallButtonAnimation();
                }
                if (sfEmgStatus != null && sfEmgStatus.data != null) {
                    ISfEmergencyAssistanceView iSfEmergencyAssistanceView = (ISfEmergencyAssistanceView) SfEmergencyAssistancePresenter.this.mView;
                    if (sfEmgStatus.data.isOnEmergencyCallStatus <= 0) {
                        z = false;
                    }
                    iSfEmergencyAssistanceView.updateUIByCallPoliceState(z);
                }
            }

            public void onError(SfEmgStatus sfEmgStatus) {
                SfEmergencyAssistancePresenter.this.closePDialog();
                if (sfEmgStatus != null) {
                    SfEmergencyAssistancePresenter.this.showToast(sfEmgStatus.errmsg);
                }
            }

            public void onFail(int i, String str) {
                SfEmergencyAssistancePresenter.this.closePDialog();
                SfEmergencyAssistancePresenter.this.showToast(str);
            }
        });
    }

    public void handleEmergencyCallClickedNew() {
        makeEmergencyCall();
        SfOmegaUtil.addEventId("gp_safetyToolkit_eHelpPopup_sw").report();
        startDexter();
    }

    public void handleEmergencyCallClicked() {
        if (SafeToolKit.getIns().isVamosDriver()) {
            makeEmergencyCall();
            SfOmegaUtil.addEventId("gp_safetyToolkit_eHelpPopup_sw").report();
            startDexter();
        } else if (!this.mIsOnEmergencyStatus) {
            makeEmergencyCall();
            SfOmegaUtil.addEventId("gp_safetyToolkit_eHelpPopup_sw").report();
            startDexter();
            ((ISfEmergencyAssistanceView) this.mView).startCallButtonAnimation();
        } else {
            ((ISfEmergencyAssistanceView) this.mView).showStopEmerAssistConfirmDialog(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SfEmergencyAssistancePresenter.this.stopDexter();
                }
            });
        }
        ISMonitorDetailsService iSMonitorDetailsService = this.mService;
        if (iSMonitorDetailsService != null) {
            iSMonitorDetailsService.reportMonitorEvent(getContext(), 12);
        }
    }

    public void makeEmergencyCall() {
        String emergencyCallNum = SfEmergencyNumHelper.getEmergencyCallNum();
        ((ISfEmergencyAssistanceView) this.mView).startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + emergencyCallNum)));
    }

    private void startDexter() {
        showPDialog();
        SfEmergencyAssistanceStore.getInstance().startEmergencyCall(new SfResponseListener<SfBaseObject>() {
            public void onSuccess(SfBaseObject sfBaseObject) {
                SfEmergencyAssistancePresenter.this.closePDialog();
                boolean unused = SfEmergencyAssistancePresenter.this.mIsOnEmergencyStatus = true;
                SfEmergencyAssistancePresenter.this.startLocationSendScheduleTask();
                ((ISfEmergencyAssistanceView) SfEmergencyAssistancePresenter.this.mView).startCallButtonAnimation();
                ((ISfEmergencyAssistanceView) SfEmergencyAssistancePresenter.this.mView).updateUIByCallPoliceState(SfEmergencyAssistancePresenter.this.mIsOnEmergencyStatus);
            }

            public void onError(SfBaseObject sfBaseObject) {
                SfEmergencyAssistancePresenter.this.closePDialog();
                ((ISfEmergencyAssistanceView) SfEmergencyAssistancePresenter.this.mView).stopCallButtonAnimation();
                if (sfBaseObject != null) {
                    SfEmergencyAssistancePresenter.this.showToast(sfBaseObject.errmsg);
                }
            }

            public void onFail(int i, String str) {
                SfEmergencyAssistancePresenter.this.closePDialog();
                ((ISfEmergencyAssistanceView) SfEmergencyAssistancePresenter.this.mView).stopCallButtonAnimation();
                SfEmergencyAssistancePresenter.this.showToast(str);
            }
        });
    }

    /* access modifiers changed from: private */
    public void stopDexter() {
        showPDialog();
        SfEmergencyAssistanceStore.getInstance().stopEmergencyCall(new SfResponseListener<SfBaseObject>() {
            public void onSuccess(SfBaseObject sfBaseObject) {
                SfEmergencyAssistancePresenter.this.closePDialog();
                boolean unused = SfEmergencyAssistancePresenter.this.mIsOnEmergencyStatus = false;
                SfEmergencyAssistancePresenter.this.locationSendScheduledFuture.cancel(true);
                ((ISfEmergencyAssistanceView) SfEmergencyAssistancePresenter.this.mView).stopCallButtonAnimation();
                ((ISfEmergencyAssistanceView) SfEmergencyAssistancePresenter.this.mView).updateUIByCallPoliceState(SfEmergencyAssistancePresenter.this.mIsOnEmergencyStatus);
            }

            public void onError(SfBaseObject sfBaseObject) {
                SfEmergencyAssistancePresenter.this.closePDialog();
                if (sfBaseObject != null) {
                    SfEmergencyAssistancePresenter.this.showToast(sfBaseObject.errmsg);
                }
            }

            public void onFail(int i, String str) {
                SfEmergencyAssistancePresenter.this.closePDialog();
                SfEmergencyAssistancePresenter.this.showToast(str);
            }
        });
    }

    /* access modifiers changed from: private */
    public void getCurrentLocation(ISfLocationService.SfCallback sfCallback) {
        ISfLocationService iSfLocationService = (ISfLocationService) ServiceLoader.load(ISfLocationService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfLocationService != null) {
            iSfLocationService.getCurrentLocation(getContext(), sfCallback);
        }
    }

    /* access modifiers changed from: private */
    public void sendCurrentLocation() {
        ISfUploadLocationService iSfUploadLocationService = (ISfUploadLocationService) ServiceLoader.load(ISfUploadLocationService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfUploadLocationService != null) {
            iSfUploadLocationService.sendLocation();
        }
    }

    private void registerPushMessage(ISfPushManagerService.ISfPushListener iSfPushListener) {
        ISfPushManagerService iSfPushManagerService = (ISfPushManagerService) ServiceLoader.load(ISfPushManagerService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfPushManagerService != null) {
            iSfPushManagerService.registerCommonMsgPush(iSfPushListener);
        }
    }

    private void unregisterPushMessage(ISfPushManagerService.ISfPushListener iSfPushListener) {
        ISfPushManagerService iSfPushManagerService = (ISfPushManagerService) ServiceLoader.load(ISfPushManagerService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfPushManagerService != null) {
            iSfPushManagerService.unregisterCommonMsgPush(iSfPushListener);
        }
    }
}
