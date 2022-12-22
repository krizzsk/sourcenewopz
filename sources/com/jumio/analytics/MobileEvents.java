package com.jumio.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.nfc.NfcAdapter;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.core.error.Error;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.models.SelectionModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.persistence.DataManager;
import com.jumio.core.plugins.C20007a;
import com.jumio.core.util.ReflectionUtil;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.retry.JumioRetryReason;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import jumio.core.C21338a;
import jumio.core.C21360j0;
import jumio.core.C21373p;
import jumio.core.C21387w;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b9\u0010:J\u001c\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0007J\u001c\u0010\b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0007J(\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0007J(\u0010\u0014\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0007J\u0014\u0010\u0019\u001a\u00020\u00052\n\u0010\u0018\u001a\u00060\u0016j\u0002`\u0017H\u0007J\u001c\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J\u001c\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J \u0010$\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\"H\u0007J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u001c\u0010&\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J\u001a\u0010+\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0007R\u0016\u0010,\u001a\u00020\u001f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u001f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b.\u0010-R\u0016\u0010/\u001a\u00020\u001f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00100\u001a\u00020\u001f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b0\u0010-R\u0016\u00101\u001a\u00020\u001f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b1\u0010-R\u0016\u00102\u001a\u00020\u001f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b2\u0010-R\u0016\u00103\u001a\u00020\u001f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b3\u0010-R\u0016\u00104\u001a\u00020\u001f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b4\u0010-R\u0016\u00105\u001a\u00020\u001f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b5\u0010-R\u0016\u00106\u001a\u00020\u001f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b6\u0010-R\u0016\u00107\u001a\u00020\u001f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b7\u0010-R\u0016\u00108\u001a\u00020\u001f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b8\u0010-¨\u0006;"}, mo175978d2 = {"Lcom/jumio/analytics/MobileEvents;", "", "Lcom/jumio/analytics/a;", "lifecycleType", "data", "Lcom/jumio/analytics/AnalyticsEvent;", "lifecycle", "Lcom/jumio/sdk/enums/JumioScanStep;", "scanStep", "", "action", "userAction", "Landroid/content/Context;", "context", "Lcom/jumio/core/persistence/DataManager;", "dataManager", "Lcom/jumio/core/models/AuthorizationModel;", "authorizationModel", "", "isDefaultUI", "sdkParameters", "deviceInformation", "Ljava/lang/Exception;", "Lkotlin/Exception;", "ex", "exception", "eventName", "Lcom/jumio/analytics/MetaInfo;", "metaInfo", "alert", "misc", "", "request", "httpCode", "", "roundtripTime", "networkRequest", "additionalDatapoints", "cvDebugging", "Ljumio/core/j0;", "reportingModel", "Ljumio/core/p;", "credentialsModel", "reporting", "EVENTTYPE_SDKPARAMETERS", "I", "EVENTTYPE_MOBILE_DEVICE_INFO", "EVENTTYPE_ALERT", "EVENTTYPE_ADDITIONAL_DATAPOINTS", "EVENTTYPE_REPORTING", "EVENTTYPE_SCANSTEP", "EVENTTYPE_USERACTION", "EVENTTYPE_SDKLIFECYCLE", "EVENTTYPE_EXCEPTION", "EVENTTYPE_NETWORKCALL", "EVENTTYPE_CV", "EVENTTYPE_MISC", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: MobileEvents.kt */
public final class MobileEvents {
    public static final int EVENTTYPE_ADDITIONAL_DATAPOINTS = 313;
    public static final int EVENTTYPE_ALERT = 311;
    public static final int EVENTTYPE_CV = 315;
    public static final int EVENTTYPE_EXCEPTION = 305;
    public static final int EVENTTYPE_MISC = 317;
    public static final int EVENTTYPE_MOBILE_DEVICE_INFO = 307;
    public static final int EVENTTYPE_NETWORKCALL = 309;
    public static final int EVENTTYPE_REPORTING = 316;
    public static final int EVENTTYPE_SCANSTEP = 300;
    public static final int EVENTTYPE_SDKLIFECYCLE = 302;
    public static final int EVENTTYPE_SDKPARAMETERS = 306;
    public static final int EVENTTYPE_USERACTION = 301;
    public static final MobileEvents INSTANCE = new MobileEvents();

    /* renamed from: com.jumio.analytics.MobileEvents$a */
    /* compiled from: MobileEvents.kt */
    public /* synthetic */ class C19936a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f54528a;

        static {
            int[] iArr = new int[C19937a.values().length];
            iArr[C19937a.ERROR.ordinal()] = 1;
            f54528a = iArr;
        }
    }

    @JvmStatic
    public static final AnalyticsEvent additionalDatapoints(Context context, DataManager dataManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataManager, "dataManager");
        return new AnalyticsEvent(313, "noValue", ((C21338a) dataManager.get(C21338a.class)).mo175777a(context, dataManager));
    }

    @JvmStatic
    public static final AnalyticsEvent alert(String str, MetaInfo metaInfo) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        return new AnalyticsEvent(311, str, metaInfo);
    }

    public static /* synthetic */ AnalyticsEvent alert$default(String str, MetaInfo metaInfo, int i, Object obj) {
        if ((i & 2) != 0) {
            metaInfo = null;
        }
        return alert(str, metaInfo);
    }

    @JvmStatic
    public static final AnalyticsEvent cvDebugging(String str, MetaInfo metaInfo) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        return new AnalyticsEvent(315, str, metaInfo);
    }

    public static /* synthetic */ AnalyticsEvent cvDebugging$default(String str, MetaInfo metaInfo, int i, Object obj) {
        if ((i & 2) != 0) {
            metaInfo = null;
        }
        return cvDebugging(str, metaInfo);
    }

    @JvmStatic
    public static final AnalyticsEvent deviceInformation(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        boolean z = false;
        String substring = "4.1.0 (90)".substring(0, StringsKt.indexOf$default((CharSequence) "4.1.0 (90)", " (", 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String valueOf = String.valueOf(Build.VERSION.SDK_INT);
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put("sdk-version", substring);
        metaInfo.put("os", "Android");
        metaInfo.put("os-version", valueOf);
        metaInfo.put("manufacturer", str);
        metaInfo.put("model", str2);
        metaInfo.put("hasDeviceNFC", Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.nfc")));
        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
            z = true;
        }
        metaInfo.put("wasNFCenabled", Boolean.valueOf(z));
        metaInfo.put("isTablet", Boolean.valueOf(DeviceRotationManager.isTabletDevice(context)));
        return new AnalyticsEvent(307, "noValue", metaInfo);
    }

    @JvmStatic
    public static final AnalyticsEvent exception(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "ex");
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "writer.toString()");
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put("message", stringWriter2);
        return new AnalyticsEvent(305, "exception", metaInfo);
    }

    @JvmStatic
    public static final AnalyticsEvent lifecycle(C19937a aVar, Object obj) {
        Error error;
        Intrinsics.checkNotNullParameter(aVar, "lifecycleType");
        MetaInfo metaInfo = new MetaInfo();
        if (C19936a.f54528a[aVar.ordinal()] == 1 && (error = (Error) obj) != null) {
            metaInfo.put("code", error.getCode());
            metaInfo.put("retryPossible", Boolean.valueOf(error.isRetryable()));
        }
        return new AnalyticsEvent(302, aVar.toString(), metaInfo);
    }

    public static /* synthetic */ AnalyticsEvent lifecycle$default(C19937a aVar, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return lifecycle(aVar, obj);
    }

    @JvmStatic
    public static final AnalyticsEvent misc(String str, MetaInfo metaInfo) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        return new AnalyticsEvent(317, str, metaInfo);
    }

    public static /* synthetic */ AnalyticsEvent misc$default(String str, MetaInfo metaInfo, int i, Object obj) {
        if ((i & 2) != 0) {
            metaInfo = null;
        }
        return misc(str, metaInfo);
    }

    @JvmStatic
    public static final AnalyticsEvent networkRequest(int i, int i2, long j) {
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put("http", Integer.valueOf(i2));
        metaInfo.put("roundtrip", Long.valueOf(j));
        return new AnalyticsEvent(309, String.valueOf(i), metaInfo);
    }

    @JvmStatic
    public static final AnalyticsEvent reporting(C21360j0 j0Var, C21373p pVar) {
        Intrinsics.checkNotNullParameter(j0Var, "reportingModel");
        return new AnalyticsEvent(316, "noValue", j0Var.mo175811a(pVar));
    }

    @JvmStatic
    public static final AnalyticsEvent scanStep(JumioScanStep jumioScanStep, Object obj) {
        Intrinsics.checkNotNullParameter(jumioScanStep, "scanStep");
        MetaInfo metaInfo = new MetaInfo();
        if (obj instanceof ScanPartModel) {
            ScanPartModel scanPartModel = (ScanPartModel) obj;
            metaInfo.put("side", scanPartModel.getSide().toString());
            metaInfo.put("type", scanPartModel.getMode().toString());
        } else if (obj instanceof JumioRetryReason) {
            metaInfo.put("retryCode", Integer.valueOf(((JumioRetryReason) obj).getCode()));
        } else if (obj instanceof MetaInfo) {
            metaInfo.putAll((Map) obj);
        } else if (obj instanceof String) {
            metaInfo.put("additionalData", obj);
        }
        String str = jumioScanStep.toString();
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
            return new AnalyticsEvent(300, lowerCase, metaInfo);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ AnalyticsEvent scanStep$default(JumioScanStep jumioScanStep, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return scanStep(jumioScanStep, obj);
    }

    @JvmStatic
    public static final AnalyticsEvent sdkParameters(Context context, DataManager dataManager, AuthorizationModel authorizationModel, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataManager, "dataManager");
        Intrinsics.checkNotNullParameter(authorizationModel, "authorizationModel");
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put("dataCenter", authorizationModel.getDataCenter().toString());
        String str8 = "1";
        String stringPlus = Intrinsics.stringPlus("", C20007a.m39595c(C20007a.C20010c.LINEFINDER) ? str8 : "0");
        if (C20007a.m39595c(C20007a.C20010c.MANUAL)) {
            str = str8;
        } else {
            str = "0";
        }
        String stringPlus2 = Intrinsics.stringPlus(stringPlus, str);
        if (C20007a.m39595c(C20007a.C20010c.FACE_MANUAL)) {
            str2 = str8;
        } else {
            str2 = "0";
        }
        String stringPlus3 = Intrinsics.stringPlus(stringPlus2, str2);
        if (C20007a.m39595c(C20007a.C20010c.MRZ)) {
            str3 = str8;
        } else {
            str3 = "0";
        }
        String stringPlus4 = Intrinsics.stringPlus(stringPlus3, str3);
        if (C20007a.m39595c(C20007a.C20010c.NFC)) {
            str4 = str8;
        } else {
            str4 = "0";
        }
        String stringPlus5 = Intrinsics.stringPlus(stringPlus4, str4);
        if (C20007a.m39595c(C20007a.C20010c.BARCODE)) {
            str5 = str8;
        } else {
            str5 = "0";
        }
        String stringPlus6 = Intrinsics.stringPlus(stringPlus5, str5);
        if (C20007a.m39595c(C20007a.C20010c.BARCODE_NATIVE)) {
            str6 = str8;
        } else {
            str6 = "0";
        }
        String stringPlus7 = Intrinsics.stringPlus(stringPlus6, str6);
        if (C20007a.m39595c(C20007a.C20010c.FACE_IPROOV)) {
            str7 = str8;
        } else {
            str7 = "0";
        }
        String stringPlus8 = Intrinsics.stringPlus(stringPlus7, str7);
        if (!C20007a.m39593a(C20007a.C20009b.IPROOV)) {
            str8 = "0";
        }
        metaInfo.put("modules", Intrinsics.stringPlus(stringPlus8, str8));
        if (ReflectionUtil.hasClass("com.facebook.react.ReactActivity")) {
            metaInfo.put("superDelegate", "ReactActivity");
        } else if (ReflectionUtil.hasClass("org.apache.cordova.CordovaActivity")) {
            metaInfo.put("superDelegate", "CordovaActivity");
        } else if (ReflectionUtil.hasClass("io.flutter.embedding.android.FlutterActivity")) {
            metaInfo.put("superDelegate", "FlutterActivity");
        } else if (z) {
            metaInfo.put("superDelegate", "JumioActivity");
        }
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "context.packageManager.g…o(context.packageName, 0)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ENGLISH, "%s (%d)", Arrays.copyOf(new Object[]{packageInfo.versionName, Integer.valueOf(packageInfo.versionCode)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            metaInfo.put("appVersion", format);
        } catch (Exception e) {
            Log.printStackTrace(e);
        }
        metaInfo.put("accountId", ((C21387w) dataManager.get(C21387w.class)).mo175884a());
        metaInfo.put("scanMode", ((SettingsModel) dataManager.get(SettingsModel.class)).getWorkflowDefinitionKey());
        return new AnalyticsEvent(306, "noValue", metaInfo);
    }

    @JvmStatic
    public static final AnalyticsEvent userAction(String str, JumioScanStep jumioScanStep, Object obj) {
        Intrinsics.checkNotNullParameter(str, "action");
        MetaInfo metaInfo = new MetaInfo();
        if (obj instanceof String) {
            metaInfo.put("additionalData", obj);
        } else if (obj instanceof SelectionModel) {
            SelectionModel selectionModel = (SelectionModel) obj;
            metaInfo.put("country", selectionModel.getCountry().getIsoCode());
            metaInfo.put("idType", selectionModel.getDocumentType().getIdType().toString());
            metaInfo.put("idStyle", selectionModel.getVariant().getVariant().toString());
        }
        if (jumioScanStep != null) {
            metaInfo.put("view", jumioScanStep.toString());
        }
        return new AnalyticsEvent(301, str, metaInfo);
    }

    public static /* synthetic */ AnalyticsEvent userAction$default(String str, JumioScanStep jumioScanStep, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            jumioScanStep = null;
        }
        if ((i & 4) != 0) {
            obj = null;
        }
        return userAction(str, jumioScanStep, obj);
    }
}
