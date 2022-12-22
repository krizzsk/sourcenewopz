package com.jumio.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.C19937a;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.JumioCameraManager;
import com.jumio.commons.log.LogUtils;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.core.environment.Environment;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.core.plugins.AnalyticsPlugin;
import com.jumio.core.plugins.C20007a;
import com.jumio.core.util.DeviceUtil;
import com.jumio.sdk.controller.JumioController;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.enums.JumioDataCenter;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.exceptions.PlatformNotSupportedException;
import com.jumio.sdk.interfaces.JumioControllerInterface;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jumio.core.C21364k0;
import jumio.core.C21373p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\t\b\u0002¢\u0006\u0004\b3\u00104B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b3\u00105J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0001\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2t\u0010\u0019\u001ap\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012#\u0012!\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\fR\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00067"}, mo175978d2 = {"Lcom/jumio/sdk/JumioSDK;", "", "Landroid/content/Context;", "context", "Lcom/jumio/sdk/interfaces/JumioControllerInterface;", "controllerInterface", "Lcom/jumio/sdk/controller/JumioController;", "start", "Landroid/os/Bundle;", "data", "Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "scanPartInterface", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "controller", "Ljava/util/ArrayList;", "Lcom/jumio/sdk/credentials/JumioCredentialInfo;", "Lkotlin/collections/ArrayList;", "credentials", "Lcom/jumio/sdk/credentials/JumioCredential;", "activeCredential", "Lcom/jumio/sdk/scanpart/JumioScanPart;", "activeScanPart", "", "restore", "Lcom/jumio/core/models/AuthorizationModel;", "authorizationModel", "Lcom/jumio/core/models/AuthorizationModel;", "Lcom/jumio/sdk/controller/JumioController;", "", "customThemeId", "I", "getCustomThemeId", "()I", "setCustomThemeId", "(I)V", "", "token", "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "Lcom/jumio/sdk/enums/JumioDataCenter;", "dataCenter", "Lcom/jumio/sdk/enums/JumioDataCenter;", "getDataCenter", "()Lcom/jumio/sdk/enums/JumioDataCenter;", "setDataCenter", "(Lcom/jumio/sdk/enums/JumioDataCenter;)V", "<init>", "()V", "(Landroid/content/Context;)V", "Companion", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioSDK.kt */
public final class JumioSDK {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String[] requiredPermissions = {Permission.CAMERA};
    /* access modifiers changed from: private */
    public static final String version = Intrinsics.stringPlus("4.1.0", "");
    private AuthorizationModel authorizationModel;
    private JumioController controller;
    private int customThemeId;
    private JumioDataCenter dataCenter;
    private String token;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J%\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0005R\"\u0010\u0014\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0007X\u0004¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, mo175978d2 = {"Lcom/jumio/sdk/JumioSDK$Companion;", "", "Landroid/content/Context;", "context", "", "isSupportedPlatform", "isRooted", "isTablet", "hasAllRequiredPermissions", "", "", "names", "hasPermissionsFor", "(Landroid/content/Context;[Ljava/lang/String;)Z", "getMissingPermissions", "(Landroid/content/Context;)[Ljava/lang/String;", "boolean", "", "giveDataDogConsent", "checkSDKRequirements", "version", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "getVersion$annotations", "()V", "requiredPermissions", "[Ljava/lang/String;", "getRequiredPermissions", "()[Ljava/lang/String;", "getRequiredPermissions$annotations", "<init>", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: JumioSDK.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getRequiredPermissions$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getVersion$annotations() {
        }

        @JvmStatic
        public final void checkSDKRequirements(Context context) throws PlatformNotSupportedException {
            Intrinsics.checkNotNullParameter(context, "context");
            Environment.checkDependencies(context);
            boolean z = C20007a.m39595c(C20007a.C20010c.EMULATOR) && DeviceUtil.isDebug(context);
            if (Build.VERSION.SDK_INT < 16) {
                throw new PlatformNotSupportedException("SDK Version 16 required");
            } else if (JumioCameraManager.Companion.getNumberOfCameras() == 0) {
                throw new PlatformNotSupportedException("No useable camera present");
            } else if (!DeviceUtil.isSupportedPlatform(z)) {
                throw new PlatformNotSupportedException("ARMv7 CPU Architecture with NEON Intrinsics required");
            }
        }

        @JvmStatic
        public final String[] getMissingPermissions(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            int i = 0;
            if (hasAllRequiredPermissions(context)) {
                return new String[0];
            }
            ArrayList arrayList = new ArrayList();
            String[] requiredPermissions = getRequiredPermissions();
            int length = requiredPermissions.length;
            while (i < length) {
                String str = requiredPermissions[i];
                i++;
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    arrayList.add(str);
                }
            }
            Object[] array = arrayList.toArray(new String[arrayList.size()]);
            Intrinsics.checkNotNullExpressionValue(array, "neededPerms.toArray(arr)");
            return (String[]) array;
        }

        public final String[] getRequiredPermissions() {
            return JumioSDK.requiredPermissions;
        }

        public final String getVersion() {
            return JumioSDK.version;
        }

        @JvmStatic
        public final void giveDataDogConsent(boolean z) {
            C20007a.C20010c cVar = C20007a.C20010c.DATADOG;
            if (C20007a.m39595c(cVar)) {
                ((AnalyticsPlugin) C20007a.m39594b(cVar)).enableDataCollection(z);
            }
        }

        @JvmStatic
        public final boolean hasAllRequiredPermissions(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return hasPermissionsFor(context, getRequiredPermissions());
        }

        @JvmStatic
        public final boolean hasPermissionsFor(Context context, String[] strArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(strArr, "names");
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                i++;
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    return false;
                }
            }
            return true;
        }

        @JvmStatic
        public final boolean isRooted(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return C21364k0.m42129a(context);
        }

        @JvmStatic
        public final boolean isSupportedPlatform(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                JumioSDK.checkSDKRequirements(context);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        @JvmStatic
        public final boolean isTablet(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return DeviceRotationManager.isTabletDevice(context);
        }
    }

    private JumioSDK() {
        this.authorizationModel = new AuthorizationModel();
        this.token = "";
    }

    @JvmStatic
    public static final void checkSDKRequirements(Context context) throws PlatformNotSupportedException {
        Companion.checkSDKRequirements(context);
    }

    @JvmStatic
    public static final String[] getMissingPermissions(Context context) {
        return Companion.getMissingPermissions(context);
    }

    public static final String[] getRequiredPermissions() {
        return Companion.getRequiredPermissions();
    }

    public static final String getVersion() {
        return Companion.getVersion();
    }

    @JvmStatic
    public static final void giveDataDogConsent(boolean z) {
        Companion.giveDataDogConsent(z);
    }

    @JvmStatic
    public static final boolean hasAllRequiredPermissions(Context context) {
        return Companion.hasAllRequiredPermissions(context);
    }

    @JvmStatic
    public static final boolean hasPermissionsFor(Context context, String[] strArr) {
        return Companion.hasPermissionsFor(context, strArr);
    }

    @JvmStatic
    public static final boolean isRooted(Context context) {
        return Companion.isRooted(context);
    }

    @JvmStatic
    public static final boolean isSupportedPlatform(Context context) {
        return Companion.isSupportedPlatform(context);
    }

    @JvmStatic
    public static final boolean isTablet(Context context) {
        return Companion.isTablet(context);
    }

    public final int getCustomThemeId() {
        return this.customThemeId;
    }

    public final JumioDataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final String getToken() {
        return this.token;
    }

    public final void restore(Context context, Bundle bundle, JumioControllerInterface jumioControllerInterface, JumioScanPartInterface jumioScanPartInterface, Function4<? super JumioController, ? super ArrayList<JumioCredentialInfo>, ? super JumioCredential, ? super JumioScanPart, Unit> function4) {
        JumioScanPart activeScanPart$jumio_core_release;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "data");
        Intrinsics.checkNotNullParameter(jumioControllerInterface, "controllerInterface");
        Intrinsics.checkNotNullParameter(function4, "restore");
        JumioController jumioController = new JumioController(context, bundle, jumioControllerInterface, jumioScanPartInterface);
        this.controller = jumioController;
        ArrayList<JumioCredentialInfo> e = ((C21373p) jumioController.getController$jumio_core_release().getDataManager().get(C21373p.class)).mo175867e();
        JumioCredential activeCredential$jumio_core_release = jumioController.getController$jumio_core_release().getActiveCredential$jumio_core_release();
        JumioCredential activeCredential$jumio_core_release2 = jumioController.getController$jumio_core_release().getActiveCredential$jumio_core_release();
        function4.invoke(jumioController, e, activeCredential$jumio_core_release, activeCredential$jumio_core_release2 == null ? null : activeCredential$jumio_core_release2.getActiveScanPart$jumio_core_release());
        JumioCredential activeCredential$jumio_core_release3 = jumioController.getController$jumio_core_release().getActiveCredential$jumio_core_release();
        if (activeCredential$jumio_core_release3 != null && (activeScanPart$jumio_core_release = activeCredential$jumio_core_release3.getActiveScanPart$jumio_core_release()) != null) {
            if (activeScanPart$jumio_core_release.getScanPart$jumio_core_release().getScanPartModel().getScanStep() == JumioScanStep.STARTED || activeScanPart$jumio_core_release.getScanPart$jumio_core_release().getScanPartModel().getScanStep() == JumioScanStep.SCAN_VIEW || activeScanPart$jumio_core_release.getScanPart$jumio_core_release().getScanPartModel().getScanStep() == JumioScanStep.RETRY) {
                if (activeScanPart$jumio_core_release.getScanPart$jumio_core_release().getScanPartModel().getLastRetryReason() == null) {
                    activeScanPart$jumio_core_release.getScanPart$jumio_core_release().getScanPartModel().setLastRetryReason(new JumioRetryReason(1, ""));
                }
                JumioRetryReason lastRetryReason = activeScanPart$jumio_core_release.getScanPart$jumio_core_release().getScanPartModel().getLastRetryReason();
                Intrinsics.checkNotNull(lastRetryReason);
                activeScanPart$jumio_core_release.retry(lastRetryReason);
            }
        }
    }

    public final void setCustomThemeId(int i) {
        this.customThemeId = i;
    }

    public final void setDataCenter(JumioDataCenter jumioDataCenter) {
        this.dataCenter = jumioDataCenter;
    }

    public final void setToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.token = str;
    }

    public final JumioController start(Context context, JumioControllerInterface jumioControllerInterface) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumioControllerInterface, "controllerInterface");
        JumioDataCenter jumioDataCenter = this.dataCenter;
        boolean z = true;
        if (!(this.token.length() > 0) || jumioDataCenter == null) {
            z = false;
        }
        if (z) {
            LogUtils.init();
            Analytics.Companion companion = Analytics.Companion;
            companion.configure$jumio_core_release();
            companion.add(MobileEvents.lifecycle$default(C19937a.CREATED, (Object) null, 2, (Object) null));
            this.authorizationModel.setToken(this.token);
            this.authorizationModel.setDataCenter(jumioDataCenter);
            this.authorizationModel.getSessionKey().generate();
            Logger.getLogger("org.jmrtd").setLevel(Level.OFF);
            JumioController jumioController = new JumioController(context, this.authorizationModel, jumioControllerInterface, this.customThemeId);
            this.controller = jumioController;
            return jumioController;
        }
        throw new IllegalArgumentException("token and dataCenter need to be set".toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public JumioSDK(Context context) {
        this();
        Intrinsics.checkNotNullParameter(context, "context");
        checkSDKRequirements(context);
        Environment.checkOcrVersion(context);
    }
}
