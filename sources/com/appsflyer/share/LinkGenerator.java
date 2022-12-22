package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFExecutor;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.OneLinkHttpTask;
import com.appsflyer.ServerConfigHandler;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;
import org.apache.commons.p071io.IOUtils;

public class LinkGenerator {

    /* renamed from: ı */
    private String f2056;

    /* renamed from: Ɩ */
    private String f2057;

    /* renamed from: ǃ */
    private String f2058;

    /* renamed from: ȷ */
    private String f2059;

    /* renamed from: ɨ */
    private Map<String, String> f2060 = new HashMap();

    /* renamed from: ɩ */
    String f2061;

    /* renamed from: ɪ */
    private Map<String, String> f2062 = new HashMap();

    /* renamed from: ɹ */
    private String f2063;

    /* renamed from: ɾ */
    private String f2064;

    /* renamed from: Ι */
    private String f2065;

    /* renamed from: ι */
    String f2066;

    /* renamed from: І */
    private String f2067;

    /* renamed from: і */
    private String f2068;

    /* renamed from: Ӏ */
    private String f2069;

    public LinkGenerator(String str) {
        this.f2065 = str;
    }

    public LinkGenerator setBrandDomain(String str) {
        this.f2064 = str;
        return this;
    }

    public String getBrandDomain() {
        return this.f2064;
    }

    public LinkGenerator setDeeplinkPath(String str) {
        this.f2069 = str;
        return this;
    }

    public LinkGenerator setBaseDeeplink(String str) {
        this.f2059 = str;
        return this;
    }

    public String getChannel() {
        return this.f2058;
    }

    public LinkGenerator setChannel(String str) {
        this.f2058 = str;
        return this;
    }

    public LinkGenerator setReferrerCustomerId(String str) {
        this.f2067 = str;
        return this;
    }

    public String getMediaSource() {
        return this.f2065;
    }

    public Map<String, String> getParameters() {
        return this.f2060;
    }

    public String getCampaign() {
        return this.f2056;
    }

    public LinkGenerator setCampaign(String str) {
        this.f2056 = str;
        return this;
    }

    public LinkGenerator addParameter(String str, String str2) {
        this.f2060.put(str, str2);
        return this;
    }

    public LinkGenerator addParameters(Map<String, String> map) {
        if (map != null) {
            this.f2060.putAll(map);
        }
        return this;
    }

    public LinkGenerator setReferrerUID(String str) {
        this.f2063 = str;
        return this;
    }

    public LinkGenerator setReferrerName(String str) {
        this.f2068 = str;
        return this;
    }

    public LinkGenerator setReferrerImageURL(String str) {
        this.f2057 = str;
        return this;
    }

    public LinkGenerator setBaseURL(String str, String str2, String str3) {
        if (str == null || str.length() <= 0) {
            this.f2061 = String.format("https://%s/%s", new Object[]{ServerConfigHandler.getUrl("%sapp.%s"), str3});
        } else {
            if (str2 == null || str2.length() < 5) {
                str2 = "go.onelink.me";
            }
            this.f2061 = String.format("https://%s/%s", new Object[]{str2, str});
        }
        return this;
    }

    /* renamed from: ǃ */
    private StringBuilder m1709() {
        StringBuilder sb = new StringBuilder();
        String str = this.f2061;
        if (str == null || !str.startsWith("http")) {
            sb.append(ServerConfigHandler.getUrl(Constants.f2050));
        } else {
            sb.append(this.f2061);
        }
        if (this.f2066 != null) {
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(this.f2066);
        }
        this.f2062.put("pid", this.f2065);
        sb.append('?');
        sb.append("pid=");
        sb.append(m1710(this.f2065, "media source"));
        String str2 = this.f2063;
        if (str2 != null) {
            this.f2062.put("af_referrer_uid", str2);
            sb.append(Typography.amp);
            sb.append("af_referrer_uid=");
            sb.append(m1710(this.f2063, "referrerUID"));
        }
        String str3 = this.f2058;
        if (str3 != null) {
            this.f2062.put("af_channel", str3);
            sb.append(Typography.amp);
            sb.append("af_channel=");
            sb.append(m1710(this.f2058, "channel"));
        }
        String str4 = this.f2067;
        if (str4 != null) {
            this.f2062.put("af_referrer_customer_id", str4);
            sb.append(Typography.amp);
            sb.append("af_referrer_customer_id=");
            sb.append(m1710(this.f2067, "referrerCustomerId"));
        }
        String str5 = this.f2056;
        if (str5 != null) {
            this.f2062.put("c", str5);
            sb.append(Typography.amp);
            sb.append("c=");
            sb.append(m1710(this.f2056, "campaign"));
        }
        String str6 = this.f2068;
        if (str6 != null) {
            this.f2062.put("af_referrer_name", str6);
            sb.append(Typography.amp);
            sb.append("af_referrer_name=");
            sb.append(m1710(this.f2068, "referrerName"));
        }
        String str7 = this.f2057;
        if (str7 != null) {
            this.f2062.put("af_referrer_image_url", str7);
            sb.append(Typography.amp);
            sb.append("af_referrer_image_url=");
            sb.append(m1710(this.f2057, "referrerImageURL"));
        }
        if (this.f2059 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f2059);
            String str8 = "";
            sb2.append(this.f2059.endsWith("/") ? str8 : "/");
            String str9 = this.f2069;
            if (str9 != null) {
                sb2.append(str9);
            }
            this.f2062.put("af_dp", sb2.toString());
            sb.append(Typography.amp);
            sb.append("af_dp=");
            sb.append(m1710(this.f2059, "baseDeeplink"));
            if (this.f2069 != null) {
                if (!this.f2059.endsWith("/")) {
                    str8 = "%2F";
                }
                sb.append(str8);
                sb.append(m1710(this.f2069, "deeplinkPath"));
            }
        }
        for (String next : this.f2060.keySet()) {
            String obj = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(next);
            sb3.append("=");
            sb3.append(m1710(this.f2060.get(next), next));
            if (!obj.contains(sb3.toString())) {
                sb.append(Typography.amp);
                sb.append(next);
                sb.append('=');
                sb.append(m1710(this.f2060.get(next), next));
            }
        }
        return sb;
    }

    /* renamed from: ɩ */
    private static String m1710(String str, String str2) {
        try {
            return URLEncoder.encode(str, "utf8");
        } catch (UnsupportedEncodingException unused) {
            StringBuilder sb = new StringBuilder("Illegal ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            AFLogger.afInfoLog(sb.toString());
            return "";
        } catch (Throwable unused2) {
            return "";
        }
    }

    public String generateLink() {
        return m1709().toString();
    }

    public void generateLink(Context context, CreateOneLinkHttpTask.ResponseListener responseListener) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        if (!this.f2060.isEmpty()) {
            for (Map.Entry next : this.f2060.entrySet()) {
                this.f2062.put(next.getKey(), next.getValue());
            }
        }
        m1709();
        String str = this.f2064;
        Map<String, String> map = this.f2062;
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, generate User Invite Link is disabled", true);
            return;
        }
        CreateOneLinkHttpTask createOneLinkHttpTask = new CreateOneLinkHttpTask(string, map, AppsFlyerLibCore.getInstance(), context, AppsFlyerLib.getInstance().isTrackingStopped());
        createOneLinkHttpTask.setConnProvider(new OneLinkHttpTask.HttpsUrlConnectionProvider());
        createOneLinkHttpTask.setListener(responseListener);
        createOneLinkHttpTask.setBrandDomain(str);
        AFExecutor.getInstance().getThreadPoolExecutor().execute(createOneLinkHttpTask);
    }
}
