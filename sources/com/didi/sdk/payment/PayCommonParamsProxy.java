package com.didi.sdk.payment;

import android.content.Context;
import android.util.Pair;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.component.protocol.ComponentLoadUtil;
import com.didi.sdk.component.protocol.IA3Manager;
import com.didi.sdk.developermode.DevModeUtil;
import com.didi.sdk.idfa.IDFAManager;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.pay.base.PayCommonParamsUtil;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.util.CommonParamsUtil;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.request.ServerParam;
import java.util.HashMap;

public class PayCommonParamsProxy implements PayCommonParamsUtil.CommonParamsProxy {

    /* renamed from: a */
    private HashMap<String, Object> f36893a = new HashMap<>();

    public int getStartCityId() {
        return -1;
    }

    public HashMap<String, Object> addCommonParam(HashMap<String, Object> hashMap, Context context) {
        return CommonParamsUtil.addCommonParam(hashMap, context);
    }

    public String createCommonParamJson(Context context) {
        return CommonParamsUtil.createCommonParamJson(context);
    }

    public String createCommonParamString(Context context) {
        return CommonParamsUtil.createCommonParamString(context);
    }

    public Pair<Double, Double> getLastKnownLocation(Context context) {
        DIDILocation lastKnownLocation = LocationPerformer.getInstance().getLastKnownLocation(context);
        if (lastKnownLocation == null) {
            return null;
        }
        return new Pair<>(Double.valueOf(lastKnownLocation.getLatitude()), Double.valueOf(lastKnownLocation.getLongitude()));
    }

    public String getDeviceId(Context context) {
        return SecurityUtil.getDeviceId();
    }

    public String getSUUID(Context context) {
        return SecurityUtil.getSUUID();
    }

    public String getLocaleCode() {
        return MultiLocaleStore.getInstance().getLocaleCode();
    }

    public boolean isLogin(Context context) {
        return NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow();
    }

    public boolean isTestNow() {
        return DevModeUtil.getDevEnvironment(DIDIApplicationDelegate.getAppContext()) == DevModeUtil.DevEnvironment.DEBUG;
    }

    public void startLogin(Context context) {
        NationTypeUtil.getNationComponentData().getLoginAction().go2Login();
    }

    public String getToken(Context context) {
        return NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
    }

    public Object getCurrency() {
        return NationTypeUtil.getNationComponentData().getCurrency();
    }

    public String getLang() {
        return MultiLocaleStore.getInstance().getLocaleCode();
    }

    public String getUid(Context context) {
        return NationTypeUtil.getNationComponentData().getLoginInfo().getUid();
    }

    public String getPid(Context context) {
        return NationTypeUtil.getNationComponentData().getLoginInfo().getPid();
    }

    public String getUUID(Context context) {
        return SecurityUtil.getUUID();
    }

    public HashMap<String, Object> getRiskParam(Context context) {
        String str;
        HashMap<String, Object> hashMap = new HashMap<>();
        IA3Manager iA3Manager = (IA3Manager) ComponentLoadUtil.getComponent(IA3Manager.class);
        if (iA3Manager != null) {
            str = iA3Manager.getToken(context);
        } else {
            str = SystemUtil.getIMEI();
        }
        String iPAddress = SystemUtil.getIPAddress(context);
        String locCountry = NationTypeUtil.getNationComponentData().getLocCountry();
        String imsi = SystemUtil.getIMSI();
        String networkType = SystemUtil.getNetworkType();
        hashMap.put("idfa", IDFAManager.getIdfa(context));
        hashMap.put("a3", str);
        hashMap.put("country", locCountry);
        hashMap.put("ip", iPAddress);
        hashMap.put("phone_imsi", imsi);
        hashMap.put(ServerParam.PARAM_NETWORK_TYPE, networkType);
        hashMap.put("wifi_mac", "");
        return hashMap;
    }

    public HashMap<String, Object> getCommonParam(Context context) {
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        this.f36893a.put("location_country", nationComponentData.getLocCountry());
        this.f36893a.put("biz_type", nationComponentData.getBiz_type());
        this.f36893a.put("terminal_id", nationComponentData.getTerminal_id());
        this.f36893a.put("platform_type", nationComponentData.getPlatform_type());
        this.f36893a.put("origin_id", nationComponentData.getOriginID());
        this.f36893a.put("utc_offset", String.valueOf(nationComponentData.getTimeZoneUtcOffset()));
        this.f36893a.put("location_cityid", nationComponentData.getCityId());
        if (nationComponentData.getLoginInfo() != null) {
            this.f36893a.put("phone", nationComponentData.getLoginInfo().getPhone());
        }
        return this.f36893a;
    }
}
