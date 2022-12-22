package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import android.os.Build;
import com.didi.sdk.util.SystemUtil;
import com.didi.unifylogin.base.api.BaseListenerContainer;
import com.didi.unifylogin.base.net.LoginNetParamListener;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.utils.LoginDeviceUtil;
import com.didi.unifylogin.utils.SecurityUtil;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BaseParam implements Serializable {
    private static final int SDK_TYPE_FLUTTER = 1;
    private static final int SDK_TYPE_NATIVE = 0;

    /* renamed from: a3 */
    protected String f44702a3;
    protected String api_version = "1.0.2";
    protected String app_version;
    protected int appid = -1;
    protected String canonical_country_code;
    protected String channel;
    protected int city_id;
    protected String country_calling_code = "+86";
    protected int country_id = 86;
    protected String device_name;
    protected Map<String, Object> extra_info;
    protected String idfa;
    protected String imei;
    protected String lang;
    protected double lat;
    protected double lng;
    @SerializedName("login_sdk_type")
    protected int loginSdkType = 0;
    protected String map_type = "soso";
    protected String model;
    protected String network_type;
    protected String omega_id;

    /* renamed from: os */
    protected String f44703os;
    protected int role = -1;
    protected int scene;
    protected String suuid;
    protected String terminal_id;
    protected int utcoffset;

    public BaseParam(Context context, int i) {
        buildCommonParam(context);
        if (i == LoginScene.SCENE_DELETE_ACCOUNT.getSceneNum()) {
            this.scene = LoginScene.SCENE_CANCEL.getSceneNum();
        } else {
            this.scene = i;
        }
    }

    private void buildCommonParam(Context context) {
        LoginNetParamListener netParamListener = BaseListenerContainer.getNetParamListener();
        this.app_version = SystemUtil.getVersionName();
        this.channel = SystemUtil.getChannelId();
        this.imei = LoginDeviceUtil.getIMEI();
        this.suuid = SecurityUtil.getUUID(context);
        this.model = Build.MODEL;
        this.device_name = Build.DEVICE;
        this.omega_id = OmegaSDK.getOmegaId();
        if (netParamListener != null) {
            this.lat = netParamListener.getLat();
            this.lng = netParamListener.getLng();
            this.map_type = netParamListener.getMapType();
            this.appid = netParamListener.getAppId();
            this.role = netParamListener.getRole();
            this.country_id = netParamListener.getCountryId();
            this.country_calling_code = netParamListener.getCountryCallingCode();
            this.canonical_country_code = netParamListener.getCanonicalCountryCode();
            this.lang = netParamListener.getLanguage();
            this.f44702a3 = netParamListener.getA3(context);
            this.idfa = netParamListener.getIdfa(context);
            this.city_id = netParamListener.getCityId();
            this.utcoffset = netParamListener.getUtcOffset(context);
            if (netParamListener.getExtraInfo() != null) {
                this.extra_info = netParamListener.getExtraInfo();
                this.terminal_id = netParamListener.getTerminalId();
            }
        }
        this.f44703os = Build.VERSION.RELEASE;
        this.network_type = SystemUtil.getNetworkType();
    }

    public Map<String, String> getBaseMap() {
        HashMap hashMap = new HashMap();
        ArrayList<Field> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(getClass().getDeclaredFields()));
        for (Field field : arrayList) {
            try {
                if (!field.getName().equals("$change")) {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        field.setAccessible(true);
                        Object obj = field.get(this);
                        if (!(obj instanceof String)) {
                            obj = String.valueOf(obj);
                        }
                        hashMap.put(field.getName(), (String) obj);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public Map<String, Object> getBaseObjectMap() {
        HashMap hashMap = new HashMap();
        ArrayList<Field> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(getClass().getDeclaredFields()));
        for (Field field : arrayList) {
            try {
                if (!field.getName().equals("$change")) {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        field.setAccessible(true);
                        hashMap.put(field.getName(), field.get(this));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        ArrayList<Field> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(getClass().getDeclaredFields()));
        Class<? super Object> superclass = getClass().getSuperclass();
        if (superclass != null) {
            arrayList.addAll(Arrays.asList(superclass.getDeclaredFields()));
        }
        for (Field field : arrayList) {
            try {
                if (!field.getName().equals("$change")) {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        field.setAccessible(true);
                        Object obj = field.get(this);
                        if (!(obj instanceof String)) {
                            obj = String.valueOf(obj);
                        }
                        hashMap.put(field.getName(), (String) obj);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap.toString();
    }

    public int getScene() {
        return this.scene;
    }

    public int getCountry_id() {
        return this.country_id;
    }

    public String getCountryCallingCode() {
        return this.country_calling_code;
    }

    public BaseParam setScene(int i) {
        this.scene = i;
        return this;
    }

    public BaseParam setCountry_id(int i) {
        this.country_id = i;
        return this;
    }

    public BaseParam setCountryCallingCode(String str) {
        this.country_calling_code = str;
        return this;
    }

    public BaseParam setCanonicalCountryCode(String str) {
        this.canonical_country_code = str;
        return this;
    }

    public String getLang() {
        return this.lang;
    }

    public void useFlutterLoginSdkType() {
        this.loginSdkType = 1;
    }
}
