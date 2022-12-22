package com.didichuxing.bigdata.p173dp.locsdk.google;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.setting.ILocationSettingRequest;
import com.didichuxing.bigdata.p173dp.locsdk.setting.LocationSettingRequestCallback;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

@ServiceProvider({ILocationSettingRequest.class})
/* renamed from: com.didichuxing.bigdata.dp.locsdk.google.GmsLocationSettingRequest */
public class GmsLocationSettingRequest implements ILocationSettingRequest {

    /* renamed from: a */
    private LocationRequest f45764a;

    public GmsLocationSettingRequest() {
        m32772a();
    }

    /* renamed from: a */
    private void m32772a() {
        LocationRequest locationRequest = new LocationRequest();
        this.f45764a = locationRequest;
        locationRequest.setInterval(1000);
        this.f45764a.setFastestInterval(1000);
        this.f45764a.setPriority(100);
    }

    public void checkSettingRequest(Context context, final LocationSettingRequestCallback locationSettingRequestCallback) {
        if (!(context instanceof Activity)) {
            locationSettingRequestCallback.onFailed();
        }
        final Activity activity = (Activity) context;
        try {
            Task<LocationSettingsResponse> checkLocationSettings = LocationServices.getSettingsClient(activity).checkLocationSettings(new LocationSettingsRequest.Builder().addLocationRequest(this.f45764a).build());
            checkLocationSettings.addOnSuccessListener(activity, (OnSuccessListener<? super LocationSettingsResponse>) new OnSuccessListener<LocationSettingsResponse>() {
                public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                    LocationSettingRequestCallback locationSettingRequestCallback = locationSettingRequestCallback;
                    if (locationSettingRequestCallback != null) {
                        locationSettingRequestCallback.onSuccess();
                    }
                    DLog.m32737d("gms location setting request success... ");
                }
            });
            checkLocationSettings.addOnFailureListener(activity, (OnFailureListener) new OnFailureListener() {
                public void onFailure(Exception exc) {
                    boolean z;
                    DLog.m32737d(" gms location setting request failed... ");
                    if (exc instanceof ResolvableApiException) {
                        z = true;
                        try {
                            ((ResolvableApiException) exc).startResolutionForResult(activity, 4368);
                        } catch (IntentSender.SendIntentException unused) {
                        }
                    } else {
                        z = false;
                    }
                    LocationSettingRequestCallback locationSettingRequestCallback = locationSettingRequestCallback;
                    if (locationSettingRequestCallback != null) {
                        locationSettingRequestCallback.onFailed();
                        locationSettingRequestCallback.onFailed(z);
                    }
                }
            });
        } catch (Exception e) {
            DLog.m32737d(" gms setting request " + e.toString());
        }
    }
}
