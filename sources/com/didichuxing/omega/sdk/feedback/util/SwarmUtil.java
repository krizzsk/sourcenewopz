package com.didichuxing.omega.sdk.feedback.util;

import android.app.Activity;
import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.location.Location;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.afanty.common.AfantyConfig;
import com.didichuxing.afanty.common.utils.OLog;
import com.didichuxing.apollo.sdk.swarm.ToggleService;
import com.didichuxing.omega.sdk.feedback.FeedbackActivator;
import com.didichuxing.swarm.toolkit.BusinessContextService;
import com.didichuxing.swarm.toolkit.ConfigurationService;
import com.didichuxing.swarm.toolkit.LanguageService;
import com.didichuxing.swarm.toolkit.LocationService;
import com.didichuxing.swarm.toolkit.ToolkitService;
import com.didichuxing.swarm.toolkit.UserService;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Locale;
import org.osgi.framework.BundleContext;

public class SwarmUtil {
    public static String getUserUid() {
        try {
            BundleContext bundleContext = FeedbackActivator.getInstance().getBundle().getBundleContext();
            String string = ((UserService) bundleContext.getService(bundleContext.getServiceReference(UserService.class))).getAuthData().getString("uid");
            if (string == null || string.isEmpty()) {
                return "";
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getUserToken() {
        try {
            BundleContext bundleContext = FeedbackActivator.getInstance().getBundle().getBundleContext();
            String string = ((UserService) bundleContext.getService(bundleContext.getServiceReference(UserService.class))).getAuthData().getString("token");
            if (string == null || string.isEmpty()) {
                return "";
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getUserPhone() {
        try {
            BundleContext bundleContext = FeedbackActivator.getInstance().getBundle().getBundleContext();
            String string = ((UserService) bundleContext.getService(bundleContext.getServiceReference(UserService.class))).getAuthData().getString("phone");
            if (string == null || string.isEmpty()) {
                return "";
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getCityId() {
        try {
            BundleContext bundleContext = FeedbackActivator.getInstance().getBundle().getBundleContext();
            String cityId = ((LocationService) bundleContext.getService(bundleContext.getServiceReference(LocationService.class))).getCityId();
            if (cityId == null || cityId.isEmpty()) {
                return "";
            }
            return cityId;
        } catch (Exception unused) {
            return "";
        }
    }

    public static double[] getLocation() {
        double[] dArr = {0.0d, 0.0d};
        try {
            BundleContext bundleContext = FeedbackActivator.getInstance().getBundle().getBundleContext();
            Location location = ((LocationService) bundleContext.getService(bundleContext.getServiceReference(LocationService.class))).getLocation();
            if (location != null) {
                dArr[0] = location.getLongitude();
                dArr[1] = location.getLatitude();
            }
        } catch (Exception unused) {
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
        }
        return dArr;
    }

    public static String getBusinessId() {
        try {
            BundleContext bundleContext = FeedbackActivator.getInstance().getBundle().getBundleContext();
            String businessId = ((BusinessContextService) bundleContext.getService(bundleContext.getServiceReference(BusinessContextService.class))).getBusinessId();
            if (businessId == null || businessId.isEmpty()) {
                return "";
            }
            return businessId;
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|(2:13|14)|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004f, code lost:
        if (r3 == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0047, code lost:
        if (r3 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0057 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x0057=Splitter:B:15:0x0057, B:7:0x0049=Splitter:B:7:0x0049} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFeedbackToggle() {
        /*
            java.lang.String r0 = ""
            com.didichuxing.swarm.runtime.SwarmPlugin r1 = com.didichuxing.omega.sdk.feedback.FeedbackActivator.getInstance()     // Catch:{ Exception -> 0x0058 }
            org.osgi.framework.Bundle r1 = r1.getBundle()     // Catch:{ Exception -> 0x0058 }
            org.osgi.framework.BundleContext r1 = r1.getBundleContext()     // Catch:{ Exception -> 0x0058 }
            java.lang.Class<com.didichuxing.swarm.toolkit.ConfigurationService> r2 = com.didichuxing.swarm.toolkit.ConfigurationService.class
            org.osgi.framework.ServiceReference r2 = r1.getServiceReference(r2)     // Catch:{ Exception -> 0x0058 }
            java.lang.Object r1 = r1.getService(r2)     // Catch:{ Exception -> 0x0058 }
            com.didichuxing.swarm.toolkit.ConfigurationService r1 = (com.didichuxing.swarm.toolkit.ConfigurationService) r1     // Catch:{ Exception -> 0x0058 }
            com.google.gson.JsonParser r2 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x0058 }
            r2.<init>()     // Catch:{ Exception -> 0x0058 }
            r3 = 0
            java.lang.String r4 = "com.didichuxing.omega.sdk.omegasdk_feedback"
            java.io.InputStream r3 = r1.getConfiguration(r4)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            r1.<init>(r3)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            com.google.gson.JsonElement r1 = r2.parse((java.io.Reader) r1)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            com.google.gson.JsonObject r1 = r1.getAsJsonObject()     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            java.lang.String r2 = "toggles"
            com.google.gson.JsonElement r1 = r1.get(r2)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            com.google.gson.JsonObject r1 = r1.getAsJsonObject()     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            java.lang.String r2 = "feedback"
            com.google.gson.JsonElement r1 = r1.get(r2)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            java.lang.String r0 = r1.getAsString()     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            if (r3 == 0) goto L_0x0058
        L_0x0049:
            r3.close()     // Catch:{ Exception -> 0x0058 }
            goto L_0x0058
        L_0x004d:
            r1 = move-exception
            goto L_0x0052
        L_0x004f:
            if (r3 == 0) goto L_0x0058
            goto L_0x0049
        L_0x0052:
            if (r3 == 0) goto L_0x0057
            r3.close()     // Catch:{ Exception -> 0x0057 }
        L_0x0057:
            throw r1     // Catch:{ Exception -> 0x0058 }
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.util.SwarmUtil.getFeedbackToggle():java.lang.String");
    }

    public static boolean isToggleOpen(String str) {
        try {
            if (str.isEmpty()) {
                return false;
            }
            BundleContext bundleContext = FeedbackActivator.getInstance().getBundle().getBundleContext();
            return ((ToggleService) bundleContext.getService(bundleContext.getServiceReference(ToggleService.class))).allow(str).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static Activity getCurrentActivity() {
        try {
            BundleContext bundleContext = FeedbackActivator.getInstance().getBundle().getBundleContext();
            return ((ToolkitService) bundleContext.getService(bundleContext.getServiceReference(ToolkitService.class))).getActivity();
        } catch (Exception unused) {
            return null;
        }
    }

    public static Application getApplication() {
        try {
            BundleContext bundleContext = FeedbackActivator.getInstance().getBundle().getBundleContext();
            return (Application) bundleContext.getService(bundleContext.getServiceReference(Application.class));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|(2:13|14)|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004f, code lost:
        if (r3 == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0047, code lost:
        if (r3 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0057 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x0057=Splitter:B:15:0x0057, B:7:0x0049=Splitter:B:7:0x0049} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getHuiduToggle() {
        /*
            java.lang.String r0 = ""
            com.didichuxing.swarm.runtime.SwarmPlugin r1 = com.didichuxing.omega.sdk.feedback.FeedbackActivator.getInstance()     // Catch:{ Exception -> 0x0058 }
            org.osgi.framework.Bundle r1 = r1.getBundle()     // Catch:{ Exception -> 0x0058 }
            org.osgi.framework.BundleContext r1 = r1.getBundleContext()     // Catch:{ Exception -> 0x0058 }
            java.lang.Class<com.didichuxing.swarm.toolkit.ConfigurationService> r2 = com.didichuxing.swarm.toolkit.ConfigurationService.class
            org.osgi.framework.ServiceReference r2 = r1.getServiceReference(r2)     // Catch:{ Exception -> 0x0058 }
            java.lang.Object r1 = r1.getService(r2)     // Catch:{ Exception -> 0x0058 }
            com.didichuxing.swarm.toolkit.ConfigurationService r1 = (com.didichuxing.swarm.toolkit.ConfigurationService) r1     // Catch:{ Exception -> 0x0058 }
            com.google.gson.JsonParser r2 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x0058 }
            r2.<init>()     // Catch:{ Exception -> 0x0058 }
            r3 = 0
            java.lang.String r4 = "com.didichuxing.omega.sdk.omegasdk_feedback"
            java.io.InputStream r3 = r1.getConfiguration(r4)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            r1.<init>(r3)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            com.google.gson.JsonElement r1 = r2.parse((java.io.Reader) r1)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            com.google.gson.JsonObject r1 = r1.getAsJsonObject()     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            java.lang.String r2 = "toggles"
            com.google.gson.JsonElement r1 = r1.get(r2)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            com.google.gson.JsonObject r1 = r1.getAsJsonObject()     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            java.lang.String r2 = "huidu"
            com.google.gson.JsonElement r1 = r1.get(r2)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            java.lang.String r0 = r1.getAsString()     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            if (r3 == 0) goto L_0x0058
        L_0x0049:
            r3.close()     // Catch:{ Exception -> 0x0058 }
            goto L_0x0058
        L_0x004d:
            r1 = move-exception
            goto L_0x0052
        L_0x004f:
            if (r3 == 0) goto L_0x0058
            goto L_0x0049
        L_0x0052:
            if (r3 == 0) goto L_0x0057
            r3.close()     // Catch:{ Exception -> 0x0057 }
        L_0x0057:
            throw r1     // Catch:{ Exception -> 0x0058 }
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.util.SwarmUtil.getHuiduToggle():java.lang.String");
    }

    public static int getAppType() {
        InputStream inputStream = null;
        try {
            BundleContext bundleContext = FeedbackActivator.getInstance().getBundle().getBundleContext();
            JsonParser jsonParser = new JsonParser();
            InputStream configuration = ((ConfigurationService) bundleContext.getService(bundleContext.getServiceReference(ConfigurationService.class))).getConfiguration("com.didichuxing.omega.sdk.omegasdk_feedback");
            int asInt = jsonParser.parse((Reader) new InputStreamReader(configuration)).getAsJsonObject().get("appType").getAsInt();
            if (configuration != null) {
                try {
                    configuration.close();
                } catch (Exception unused) {
                }
            }
            return asInt;
        } catch (Exception unused2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused3) {
                }
            }
            return 1;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    public static String getHuiduId() {
        String string;
        try {
            Application application = getApplication();
            ApplicationInfo applicationInfo = SystemUtils.getApplicationInfo(application.getPackageManager(), application.getPackageName(), 128);
            if (applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("issue") || (string = applicationInfo.metaData.getString("issue")) == null || string.trim().length() <= 0) {
                return "";
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getLang() {
        if (AfantyConfig.iGetLanguage != null) {
            return AfantyConfig.iGetLanguage.getLanguage();
        }
        try {
            BundleContext bundleContext = FeedbackActivator.getInstance().getBundle().getBundleContext();
            return ((LanguageService) bundleContext.getService(bundleContext.getServiceReference(LanguageService.class))).getLanguage();
        } catch (Exception e) {
            OLog.m32668e("get lang from swarm fail:" + e.toString());
            return "unknown";
        }
    }

    public static String getUserPhoneCountryCode() {
        try {
            BundleContext bundleContext = FeedbackActivator.getInstance().getBundle().getBundleContext();
            String string = ((UserService) bundleContext.getService(bundleContext.getServiceReference(UserService.class))).getAuthData().getString("phonecountrycode");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getCanonicalCountryCode() {
        String country = Locale.getDefault().getCountry();
        if (!TextUtils.isEmpty(country)) {
            return country;
        }
        try {
            return getApplication().getResources().getConfiguration().locale.getCountry();
        } catch (Exception unused) {
            return "xx";
        }
    }
}
