package com.didi.security.uuid.adapter;

import android.content.Context;
import com.didi.security.uuid.ApolloCallBack;
import com.didi.security.uuid.DeviceTokenManager;
import com.didichuxing.apollo.sdk.Apollo;

public class DeviceTokenWrapper {

    /* renamed from: a */
    private static final String f38554a = "wsg_dtoken_global_toggle";

    /* renamed from: b */
    private static final String f38555b = "wsg_dtoken_upload_toggle";

    /* renamed from: c */
    private DeviceTokenManager f38556c;

    public String getDeviceId() {
        return null;
    }

    private static class SigletonInstance {
        /* access modifiers changed from: private */
        public static final DeviceTokenWrapper INSTANCE = new DeviceTokenWrapper();

        private SigletonInstance() {
        }
    }

    public static DeviceTokenWrapper getInstance() {
        return SigletonInstance.INSTANCE;
    }

    public synchronized void init() {
        if (this.f38556c == null) {
            DeviceTokenManager instance = DeviceTokenManager.getInstance();
            this.f38556c = instance;
            if (instance != null) {
                m27316a();
            }
        }
    }

    public synchronized void init(Context context) {
        init();
    }

    /* renamed from: a */
    private void m27316a() {
        this.f38556c.setApolloCallBack(new ApolloCallBack() {
            public boolean isOn() {
                try {
                    return Apollo.getToggle(DeviceTokenWrapper.f38554a, true).allow();
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            }

            public boolean isDeviceTokenUploadOn() {
                try {
                    return Apollo.getToggle(DeviceTokenWrapper.f38555b, true).allow();
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            }
        });
    }

    public String getDeviceToken() {
        DeviceTokenManager deviceTokenManager = this.f38556c;
        if (deviceTokenManager != null) {
            return deviceTokenManager.getDeviceToken();
        }
        return DeviceTokenManager.getInstance().getDegradeNoInitToken();
    }
}
