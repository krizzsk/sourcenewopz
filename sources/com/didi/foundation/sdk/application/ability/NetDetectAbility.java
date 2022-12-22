package com.didi.foundation.sdk.application.ability;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.foundation.sdk.location.LocationService;
import com.didi.foundation.sdk.service.AccountService;
import com.didi.foundation.sdk.service.DeviceService;
import com.didi.foundation.sdk.utils.NetUtil;
import com.didi.one.netdetect.DetectionTaskManager;
import com.didi.one.netdetect.model.DetectionParam;
import com.didi.one.netdetect.security.SignGenerator;
import com.didi.sdk.util.SystemUtil;
import com.didi.security.wireless.adapter.SecurityWrapper;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import didihttp.internal.trace.IdGenrator;
import java.util.Map;

public class NetDetectAbility {

    /* renamed from: a */
    private static final int f21162a = 180000;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f21163b;

    /* renamed from: c */
    private String f21164c;

    /* renamed from: d */
    private String f21165d;

    /* renamed from: e */
    private String f21166e;

    /* renamed from: f */
    private Application f21167f;

    private NetDetectAbility(Builder builder) {
        this.f21163b = new Handler(Looper.getMainLooper());
        this.f21164c = builder.mTripCountry;
        this.f21165d = builder.mDataType;
        this.f21166e = builder.mApolloToggle;
        this.f21167f = builder.mContext;
    }

    public void init() {
        m15579a(this.f21167f, this.f21166e, this.f21165d, this.f21164c);
    }

    /* renamed from: a */
    private void m15579a(Application application, String str, String str2, String str3) {
        DetectionParam detectionParam = new DetectionParam();
        detectionParam.apolloName = str;
        if (!TextUtils.isEmpty(AccountService.getInstance().getCityId())) {
            detectionParam.cityId = Integer.parseInt(AccountService.getInstance().getCityId());
        } else {
            detectionParam.cityId = 0;
        }
        detectionParam.datatype = str2;
        detectionParam.phone = AccountService.getInstance().getPhone();
        detectionParam.uid = AccountService.getInstance().getUid();
        DIDILocation lastKnownLocation = LocationService.getInstance().getLastKnownLocation();
        if (lastKnownLocation != null) {
            detectionParam.lat = lastKnownLocation.getLatitude();
            detectionParam.lng = lastKnownLocation.getLongitude();
        }
        detectionParam.appVersion = SystemUtil.getVersionName(application);
        detectionParam.deviceId = DeviceService.getInstance().getDeviceId();
        detectionParam.traceId = IdGenrator.generate(NetUtil.getIpv4Address());
        detectionParam.tripCountry = str3;
        DetectionTaskManager.getInstance().init(application, detectionParam, new SignGenerator() {
            public String genSign(Map<String, String> map) {
                return SecurityWrapper.doSign(SecurityWrapper.prepareSign(map));
            }
        });
    }

    public void startDetection() {
        this.f21163b.postDelayed(new PingRunnable(), 180000);
    }

    public void startDetection(int i) {
        this.f21163b.postDelayed(new PingRunnable(), (long) i);
    }

    public void resumeDetection() {
        DetectionTaskManager.getInstance().resumeDetection();
    }

    public void stopDetection() {
        DetectionTaskManager.getInstance().stopDetection();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String mApolloToggle;
        /* access modifiers changed from: private */
        public Application mContext;
        /* access modifiers changed from: private */
        public String mDataType;
        /* access modifiers changed from: private */
        public String mTripCountry;

        public Builder setContext(Application application) {
            this.mContext = application;
            return this;
        }

        public Builder setDataType(String str) {
            this.mDataType = str;
            return this;
        }

        public Builder setTripCountry(String str) {
            this.mTripCountry = str;
            return this;
        }

        public Builder setApolloToggle(String str) {
            this.mApolloToggle = str;
            return this;
        }

        public NetDetectAbility Builder() {
            if (this.mContext == null) {
                throw new RuntimeException("mContext is null");
            } else if (TextUtils.isEmpty(this.mDataType)) {
                throw new RuntimeException("mDataType is null");
            } else if (!TextUtils.isEmpty(this.mApolloToggle)) {
                return new NetDetectAbility(this);
            } else {
                throw new RuntimeException("mApolloToggle is null");
            }
        }
    }

    private class PingRunnable implements Runnable {
        private PingRunnable() {
        }

        public void run() {
            DetectionTaskManager.getInstance().startDetection();
            NetDetectAbility.this.f21163b.postDelayed(this, 180000);
        }
    }
}
