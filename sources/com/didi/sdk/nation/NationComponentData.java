package com.didi.sdk.nation;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.developermode.DevModeUtil;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import java.io.Serializable;
import java.util.TimeZone;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.json.JSONObject;

public class NationComponentData implements Serializable {
    private static String TAG = "NationComponentData";
    private static String testOriginId;
    private String biz_type;
    private String brand;
    private String cityId;
    private String cityName;
    private String coordinateType = "";
    private String currency;
    private DIDILocation didiLocation;
    private String g_Lang = "";
    private String locCountry;
    private int locCountryId;
    private String localeCode;
    private LoginAction loginAction;
    private LoginInfo loginInfo;
    private int mapTypeInt;
    private String mapTypeString;
    private String omegaUploadHost;
    private String originId;
    private String platform_type;
    private String productPreFix;
    private PushConfig pushConfig;
    private String terminal_id;
    private int timeZoneUtcOffset;
    private String userAgentPrefix;

    public interface LoginAction {
        void go2Login();

        void login();

        void loginout(String str);
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("loginInfo", this.loginInfo.toString());
            jSONObject.put("pushConfigInfo", this.pushConfig.toString());
            jSONObject.put("originId", this.originId);
            jSONObject.put("timeZoneUtcOffset", this.timeZoneUtcOffset);
            jSONObject.put("terminal_id", this.terminal_id);
            jSONObject.put("platform_type", this.platform_type);
            jSONObject.put("biz_type", this.biz_type);
            jSONObject.put("mapTypeString", this.mapTypeString);
            jSONObject.put("localeCode", this.localeCode);
            jSONObject.put("locCountry", this.locCountry);
            jSONObject.put("cityId", this.cityId);
            jSONObject.put("omegaUploadHost", this.omegaUploadHost);
            jSONObject.put("g_Lang", this.g_Lang);
            jSONObject.put("userAgentPrefix", this.userAgentPrefix);
            jSONObject.put("brand", this.brand);
        } catch (Exception unused) {
        }
        SystemUtils.log(3, TAG, jSONObject.toString(), (Throwable) null, "com.didi.sdk.nation.NationComponentData", 92);
        return jSONObject.toString();
    }

    public String getCoordinateType() {
        return this.coordinateType;
    }

    public void setCoordinateType(String str) {
        this.coordinateType = str;
    }

    public void setProductPreFix(String str) {
        this.productPreFix = str;
    }

    public String getProductPreFix() {
        return this.productPreFix;
    }

    public void setPushConfig(PushConfig pushConfig2) {
        this.pushConfig = pushConfig2;
    }

    public PushConfig getPushConfig() {
        return this.pushConfig;
    }

    public void setDidiLocation(DIDILocation dIDILocation) {
        this.didiLocation = dIDILocation;
    }

    public DIDILocation getDidiLocation() {
        return this.didiLocation;
    }

    public LoginInfo getLoginInfo() {
        return this.loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo2) {
        this.loginInfo = loginInfo2;
    }

    public String getOriginID() {
        if (TextUtil.isEmpty(testOriginId) || DevModeUtil.getDevEnvironment(DIDIApplicationDelegate.getAppContext()) != DevModeUtil.DevEnvironment.DEBUG) {
            return this.originId;
        }
        return testOriginId;
    }

    public void setTestOriginId(String str) {
        testOriginId = str;
    }

    public void setOriginID(String str) {
        this.originId = str;
    }

    public String getTerminal_id() {
        return this.terminal_id;
    }

    public void setTerminal_id(String str) {
        this.terminal_id = str;
    }

    public String getPlatform_type() {
        return this.platform_type;
    }

    public void setPlatform_type(String str) {
        this.platform_type = str;
    }

    public String getBiz_type() {
        return this.biz_type;
    }

    public void setBiz_type(String str) {
        this.biz_type = str;
    }

    public void setTimeZoneUtcOffset(int i) {
        this.timeZoneUtcOffset = i;
    }

    public int getTimeZoneUtcOffset() {
        return this.timeZoneUtcOffset;
    }

    public String getTimeZonID() {
        return TimeZone.getDefault().getID();
    }

    public String getMapTypeString() {
        return this.mapTypeString;
    }

    public void setMapTypeString(String str) {
        this.mapTypeString = str;
    }

    public String getLocaleCode() {
        return this.localeCode;
    }

    public void setLocaleCode(String str) {
        this.localeCode = str;
    }

    public String getLocCountry() {
        return this.locCountry;
    }

    public int getLocCountryId() {
        return this.locCountryId;
    }

    public void setLocCountryId(int i) {
        this.locCountryId = i;
    }

    public void setLocCountry(String str) {
        this.locCountry = str;
    }

    public String getCityId() {
        StringBuilder sb;
        int i = -1;
        try {
            i = Integer.valueOf(this.cityId).intValue();
            sb = new StringBuilder();
        } catch (Exception unused) {
            sb = new StringBuilder();
        } catch (Throwable unused2) {
            sb = new StringBuilder();
        }
        sb.append(i);
        sb.append("");
        return sb.toString();
    }

    public void setCityId(String str) {
        this.cityId = str;
    }

    public String getGLang() {
        return this.g_Lang;
    }

    public void setGLang(String str) {
        this.g_Lang = str;
    }

    public String getOmegaSDKUploadHost() {
        return this.omegaUploadHost;
    }

    public void setOmegaUploadHost(String str) {
        this.omegaUploadHost = str;
    }

    public int getMapTypeInt() {
        return this.mapTypeInt;
    }

    public void setMapTypeInt(int i) {
        this.mapTypeInt = i;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getUserAgentPrefix() {
        return this.userAgentPrefix;
    }

    public void setUserAgentPrefix(String str) {
        this.userAgentPrefix = str;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public DevModeUtil.DevEnvironment getDevEnvironment() {
        return DevModeUtil.getDevEnvironment(DIDIApplicationDelegate.getAppContext());
    }

    public boolean isDebugEnvironment() {
        return DevModeUtil.getDevEnvironment(DIDIApplicationDelegate.getAppContext()) == DevModeUtil.DevEnvironment.DEBUG;
    }

    public boolean isReleaseEnvironment() {
        return DevModeUtil.getDevEnvironment(DIDIApplicationDelegate.getAppContext()) == DevModeUtil.DevEnvironment.RELEASE;
    }

    public boolean isUNDEFINE() {
        return DevModeUtil.getDevEnvironment(DIDIApplicationDelegate.getAppContext()) == DevModeUtil.DevEnvironment.UNDEFINE;
    }

    public void setLoginAction(LoginAction loginAction2) {
        this.loginAction = loginAction2;
    }

    public LoginAction getLoginAction() {
        return this.loginAction;
    }

    public static class LoginInfo implements Serializable {
        private String firstname;
        private boolean isLoginNow;
        private String kDToken;
        private String lastname;
        private String phone;
        private String phoneCountryCode;
        private String pid;
        private String token;
        private String uid;

        public String getToken() {
            return this.token;
        }

        public void setToken(String str) {
            this.token = str;
        }

        public String getUid() {
            return this.uid;
        }

        public void setUid(String str) {
            this.uid = str;
        }

        public String getPhone() {
            return this.phone;
        }

        public void setPhone(String str) {
            this.phone = str;
        }

        public String getKDToken() {
            return this.kDToken;
        }

        public void setkDToken(String str) {
            this.kDToken = str;
        }

        public String getPhoneCountryCode() {
            return this.phoneCountryCode;
        }

        public void setPhoneCountryCode(String str) {
            this.phoneCountryCode = str;
        }

        public String getPid() {
            return this.pid;
        }

        public void setPid(String str) {
            this.pid = str;
        }

        public void setLoginNow(boolean z) {
            this.isLoginNow = z;
        }

        public boolean isLoginNow() {
            return this.isLoginNow;
        }

        public String getFirstname() {
            return this.firstname;
        }

        public void setFirstname(String str) {
            this.firstname = str;
        }

        public String getLastname() {
            return this.lastname;
        }

        public void setLastname(String str) {
            this.lastname = str;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("token", this.token);
                jSONObject.put("uid", this.uid);
                jSONObject.put("phone", this.phone);
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }
    }

    public static class PushConfig {

        /* renamed from: ip */
        private String f36847ip;
        private boolean isConnected;
        private int port;
        private String pushId;

        public boolean isConnected() {
            return PushClient.getClient().isConnected();
        }

        public String getIp() {
            return this.f36847ip;
        }

        public void setIp(String str) {
            this.f36847ip = str;
        }

        public int getPort() {
            return this.port;
        }

        public void setPort(int i) {
            this.port = i;
        }

        public String getPushId() {
            return this.pushId;
        }

        public void setPushId(String str) {
            this.pushId = str;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ip", this.f36847ip);
                jSONObject.put(AgentOptions.PORT, this.port);
                jSONObject.put("pushid", this.pushId);
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }
    }
}
