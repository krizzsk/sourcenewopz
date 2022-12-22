package com.didi.global.fintech.cashier.model.net.request;

import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.soda.web.config.WebConstant;
import com.didichuxing.request.ServerParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b@\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FHÖ\u0003J\t\u0010G\u001a\u00020HHÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\u0003J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u0003J\u000e\u0010N\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u0003R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u0010\u0016¨\u0006P"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/DeviceInfo;", "Ljava/io/Serializable;", "system", "", "model", "from_type", "device_id", "uuid", "suuid", "os_version", "imei", "ssid", "channel", "terminal_id", "app_uni_id", "app_version", "lat", "lng", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApp_uni_id", "()Ljava/lang/String;", "setApp_uni_id", "(Ljava/lang/String;)V", "getApp_version", "setApp_version", "getChannel", "setChannel", "getDevice_id", "setDevice_id", "getFrom_type", "setFrom_type", "getImei", "setImei", "getLat", "setLat", "getLng", "setLng", "getModel", "setModel", "getOs_version", "setOs_version", "getSsid", "setSsid", "getSuuid", "setSuuid", "getSystem", "setSystem", "getTerminal_id", "setTerminal_id", "getUuid", "setUuid", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "updateAppId", "id", "updateAppVersion", "version", "updateFromType", "type", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierRequestCommonParams.kt */
public final class DeviceInfo implements Serializable {
    @SerializedName("app_uni_id")
    private String app_uni_id;
    @SerializedName("app_version")
    private String app_version;
    @SerializedName("channel")
    private String channel;
    @SerializedName("device_id")
    private String device_id;
    @SerializedName("from_type")
    private String from_type;
    @SerializedName("imei")
    private String imei;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;
    private String model;
    @SerializedName("os_version")
    private String os_version;
    @SerializedName("ssid")
    private String ssid;
    @SerializedName("suuid")
    private String suuid;
    private String system;
    @SerializedName("terminal_id")
    private String terminal_id;
    @SerializedName("uuid")
    private String uuid;

    public DeviceInfo() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 32767, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DeviceInfo copy$default(DeviceInfo deviceInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i, Object obj) {
        DeviceInfo deviceInfo2 = deviceInfo;
        int i2 = i;
        return deviceInfo.copy((i2 & 1) != 0 ? deviceInfo2.system : str, (i2 & 2) != 0 ? deviceInfo2.model : str2, (i2 & 4) != 0 ? deviceInfo2.from_type : str3, (i2 & 8) != 0 ? deviceInfo2.device_id : str4, (i2 & 16) != 0 ? deviceInfo2.uuid : str5, (i2 & 32) != 0 ? deviceInfo2.suuid : str6, (i2 & 64) != 0 ? deviceInfo2.os_version : str7, (i2 & 128) != 0 ? deviceInfo2.imei : str8, (i2 & 256) != 0 ? deviceInfo2.ssid : str9, (i2 & 512) != 0 ? deviceInfo2.channel : str10, (i2 & 1024) != 0 ? deviceInfo2.terminal_id : str11, (i2 & 2048) != 0 ? deviceInfo2.app_uni_id : str12, (i2 & 4096) != 0 ? deviceInfo2.app_version : str13, (i2 & 8192) != 0 ? deviceInfo2.lat : str14, (i2 & 16384) != 0 ? deviceInfo2.lng : str15);
    }

    public final String component1() {
        return this.system;
    }

    public final String component10() {
        return this.channel;
    }

    public final String component11() {
        return this.terminal_id;
    }

    public final String component12() {
        return this.app_uni_id;
    }

    public final String component13() {
        return this.app_version;
    }

    public final String component14() {
        return this.lat;
    }

    public final String component15() {
        return this.lng;
    }

    public final String component2() {
        return this.model;
    }

    public final String component3() {
        return this.from_type;
    }

    public final String component4() {
        return this.device_id;
    }

    public final String component5() {
        return this.uuid;
    }

    public final String component6() {
        return this.suuid;
    }

    public final String component7() {
        return this.os_version;
    }

    public final String component8() {
        return this.imei;
    }

    public final String component9() {
        return this.ssid;
    }

    public final DeviceInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        String str16 = str;
        Intrinsics.checkNotNullParameter(str16, WebConstant.SYSTEM_ENTRANCE_PLATFORM);
        String str17 = str2;
        Intrinsics.checkNotNullParameter(str17, "model");
        String str18 = str3;
        Intrinsics.checkNotNullParameter(str18, CashierParam.PARAM_FROM_TYPE);
        String str19 = str4;
        Intrinsics.checkNotNullParameter(str19, "device_id");
        String str20 = str5;
        Intrinsics.checkNotNullParameter(str20, "uuid");
        String str21 = str6;
        Intrinsics.checkNotNullParameter(str21, "suuid");
        String str22 = str7;
        Intrinsics.checkNotNullParameter(str22, ServerParam.PARAM_OS_VERSION);
        String str23 = str8;
        Intrinsics.checkNotNullParameter(str23, "imei");
        String str24 = str9;
        Intrinsics.checkNotNullParameter(str24, "ssid");
        String str25 = str10;
        Intrinsics.checkNotNullParameter(str25, "channel");
        String str26 = str11;
        Intrinsics.checkNotNullParameter(str26, "terminal_id");
        String str27 = str12;
        Intrinsics.checkNotNullParameter(str27, "app_uni_id");
        String str28 = str13;
        Intrinsics.checkNotNullParameter(str28, "app_version");
        String str29 = str14;
        Intrinsics.checkNotNullParameter(str29, "lat");
        Intrinsics.checkNotNullParameter(str15, "lng");
        return new DeviceInfo(str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str15);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return Intrinsics.areEqual((Object) this.system, (Object) deviceInfo.system) && Intrinsics.areEqual((Object) this.model, (Object) deviceInfo.model) && Intrinsics.areEqual((Object) this.from_type, (Object) deviceInfo.from_type) && Intrinsics.areEqual((Object) this.device_id, (Object) deviceInfo.device_id) && Intrinsics.areEqual((Object) this.uuid, (Object) deviceInfo.uuid) && Intrinsics.areEqual((Object) this.suuid, (Object) deviceInfo.suuid) && Intrinsics.areEqual((Object) this.os_version, (Object) deviceInfo.os_version) && Intrinsics.areEqual((Object) this.imei, (Object) deviceInfo.imei) && Intrinsics.areEqual((Object) this.ssid, (Object) deviceInfo.ssid) && Intrinsics.areEqual((Object) this.channel, (Object) deviceInfo.channel) && Intrinsics.areEqual((Object) this.terminal_id, (Object) deviceInfo.terminal_id) && Intrinsics.areEqual((Object) this.app_uni_id, (Object) deviceInfo.app_uni_id) && Intrinsics.areEqual((Object) this.app_version, (Object) deviceInfo.app_version) && Intrinsics.areEqual((Object) this.lat, (Object) deviceInfo.lat) && Intrinsics.areEqual((Object) this.lng, (Object) deviceInfo.lng);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.system.hashCode() * 31) + this.model.hashCode()) * 31) + this.from_type.hashCode()) * 31) + this.device_id.hashCode()) * 31) + this.uuid.hashCode()) * 31) + this.suuid.hashCode()) * 31) + this.os_version.hashCode()) * 31) + this.imei.hashCode()) * 31) + this.ssid.hashCode()) * 31) + this.channel.hashCode()) * 31) + this.terminal_id.hashCode()) * 31) + this.app_uni_id.hashCode()) * 31) + this.app_version.hashCode()) * 31) + this.lat.hashCode()) * 31) + this.lng.hashCode();
    }

    public String toString() {
        return "DeviceInfo(system=" + this.system + ", model=" + this.model + ", from_type=" + this.from_type + ", device_id=" + this.device_id + ", uuid=" + this.uuid + ", suuid=" + this.suuid + ", os_version=" + this.os_version + ", imei=" + this.imei + ", ssid=" + this.ssid + ", channel=" + this.channel + ", terminal_id=" + this.terminal_id + ", app_uni_id=" + this.app_uni_id + ", app_version=" + this.app_version + ", lat=" + this.lat + ", lng=" + this.lng + VersionRange.RIGHT_OPEN;
    }

    public DeviceInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        String str16 = str;
        String str17 = str2;
        String str18 = str3;
        String str19 = str4;
        String str20 = str5;
        String str21 = str6;
        String str22 = str7;
        String str23 = str8;
        String str24 = str9;
        String str25 = str10;
        String str26 = str11;
        String str27 = str12;
        String str28 = str13;
        String str29 = str14;
        String str30 = str15;
        Intrinsics.checkNotNullParameter(str16, WebConstant.SYSTEM_ENTRANCE_PLATFORM);
        Intrinsics.checkNotNullParameter(str17, "model");
        Intrinsics.checkNotNullParameter(str18, CashierParam.PARAM_FROM_TYPE);
        Intrinsics.checkNotNullParameter(str19, "device_id");
        Intrinsics.checkNotNullParameter(str20, "uuid");
        Intrinsics.checkNotNullParameter(str21, "suuid");
        Intrinsics.checkNotNullParameter(str22, ServerParam.PARAM_OS_VERSION);
        Intrinsics.checkNotNullParameter(str23, "imei");
        Intrinsics.checkNotNullParameter(str24, "ssid");
        Intrinsics.checkNotNullParameter(str25, "channel");
        Intrinsics.checkNotNullParameter(str26, "terminal_id");
        Intrinsics.checkNotNullParameter(str27, "app_uni_id");
        Intrinsics.checkNotNullParameter(str28, "app_version");
        Intrinsics.checkNotNullParameter(str29, "lat");
        Intrinsics.checkNotNullParameter(str30, "lng");
        this.system = str16;
        this.model = str17;
        this.from_type = str18;
        this.device_id = str19;
        this.uuid = str20;
        this.suuid = str21;
        this.os_version = str22;
        this.imei = str23;
        this.ssid = str24;
        this.channel = str25;
        this.terminal_id = str26;
        this.app_uni_id = str27;
        this.app_version = str28;
        this.lat = str29;
        this.lng = str30;
    }

    public final String getSystem() {
        return this.system;
    }

    public final void setSystem(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.system = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceInfo(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, int r33, kotlin.jvm.internal.DefaultConstructorMarker r34) {
        /*
            r17 = this;
            r0 = r33
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = "Android"
            goto L_0x000b
        L_0x0009:
            r1 = r18
        L_0x000b:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0019
            java.lang.String r2 = com.didi.sdk.util.SystemUtil.getModel()
            java.lang.String r3 = "getModel()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            goto L_0x001b
        L_0x0019:
            r2 = r19
        L_0x001b:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0022
            java.lang.String r3 = "NATIVE"
            goto L_0x0024
        L_0x0022:
            r3 = r20
        L_0x0024:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0037
            com.didi.global.fintech.cashier.user.facade.CashierFacade$Companion r4 = com.didi.global.fintech.cashier.user.facade.CashierFacade.Companion
            com.didi.global.fintech.cashier.user.facade.CashierFacade r4 = r4.getInstance()
            com.didi.global.fintech.cashier.user.facade.CashierInitConfig r4 = r4.getInitConfig()
            java.lang.String r4 = r4.getDeviceId()
            goto L_0x0039
        L_0x0037:
            r4 = r21
        L_0x0039:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x004c
            com.didi.global.fintech.cashier.user.facade.CashierFacade$Companion r5 = com.didi.global.fintech.cashier.user.facade.CashierFacade.Companion
            com.didi.global.fintech.cashier.user.facade.CashierFacade r5 = r5.getInstance()
            com.didi.global.fintech.cashier.user.facade.CashierInitConfig r5 = r5.getInitConfig()
            java.lang.String r5 = r5.getUUID()
            goto L_0x004e
        L_0x004c:
            r5 = r22
        L_0x004e:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0061
            com.didi.global.fintech.cashier.user.facade.CashierFacade$Companion r6 = com.didi.global.fintech.cashier.user.facade.CashierFacade.Companion
            com.didi.global.fintech.cashier.user.facade.CashierFacade r6 = r6.getInstance()
            com.didi.global.fintech.cashier.user.facade.CashierInitConfig r6 = r6.getInitConfig()
            java.lang.String r6 = r6.getSUUID()
            goto L_0x0063
        L_0x0061:
            r6 = r23
        L_0x0063:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x006f
            java.lang.String r7 = android.os.Build.VERSION.RELEASE
            java.lang.String r8 = "RELEASE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            goto L_0x0071
        L_0x006f:
            r7 = r24
        L_0x0071:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x007f
            java.lang.String r8 = com.didi.sdk.util.SystemUtil.getIMEI()
            java.lang.String r9 = "getIMEI()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            goto L_0x0081
        L_0x007f:
            r8 = r25
        L_0x0081:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0089
            java.lang.String r9 = "ssid"
            goto L_0x008b
        L_0x0089:
            r9 = r26
        L_0x008b:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0099
            java.lang.String r10 = com.didi.sdk.util.SystemUtil.getChannelId()
            java.lang.String r11 = "getChannelId()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            goto L_0x009b
        L_0x0099:
            r10 = r27
        L_0x009b:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x00ae
            com.didi.global.fintech.cashier.user.facade.CashierFacade$Companion r11 = com.didi.global.fintech.cashier.user.facade.CashierFacade.Companion
            com.didi.global.fintech.cashier.user.facade.CashierFacade r11 = r11.getInstance()
            com.didi.global.fintech.cashier.user.facade.CashierInitConfig r11 = r11.getInitConfig()
            java.lang.String r11 = r11.getTerminalID()
            goto L_0x00b0
        L_0x00ae:
            r11 = r28
        L_0x00b0:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x00b8
            java.lang.String r12 = "temp holder id"
            goto L_0x00ba
        L_0x00b8:
            r12 = r29
        L_0x00ba:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x00c2
            java.lang.String r13 = "temp holder version"
            goto L_0x00c4
        L_0x00c2:
            r13 = r30
        L_0x00c4:
            r14 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x00db
            com.didi.global.fintech.cashier.user.facade.CashierFacade$Companion r14 = com.didi.global.fintech.cashier.user.facade.CashierFacade.Companion
            com.didi.global.fintech.cashier.user.facade.CashierFacade r14 = r14.getInstance()
            com.didi.global.fintech.cashier.user.facade.CashierInitConfig r14 = r14.getInitConfig()
            double r14 = r14.getLat()
            java.lang.String r14 = java.lang.String.valueOf(r14)
            goto L_0x00dd
        L_0x00db:
            r14 = r31
        L_0x00dd:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x00f4
            com.didi.global.fintech.cashier.user.facade.CashierFacade$Companion r0 = com.didi.global.fintech.cashier.user.facade.CashierFacade.Companion
            com.didi.global.fintech.cashier.user.facade.CashierFacade r0 = r0.getInstance()
            com.didi.global.fintech.cashier.user.facade.CashierInitConfig r0 = r0.getInitConfig()
            double r15 = r0.getLng()
            java.lang.String r0 = java.lang.String.valueOf(r15)
            goto L_0x00f6
        L_0x00f4:
            r0 = r32
        L_0x00f6:
            r18 = r17
            r19 = r1
            r20 = r2
            r21 = r3
            r22 = r4
            r23 = r5
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r9
            r28 = r10
            r29 = r11
            r30 = r12
            r31 = r13
            r32 = r14
            r33 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.request.DeviceInfo.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getModel() {
        return this.model;
    }

    public final void setModel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.model = str;
    }

    public final String getFrom_type() {
        return this.from_type;
    }

    public final void setFrom_type(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.from_type = str;
    }

    public final String getDevice_id() {
        return this.device_id;
    }

    public final void setDevice_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.device_id = str;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final void setUuid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uuid = str;
    }

    public final String getSuuid() {
        return this.suuid;
    }

    public final void setSuuid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.suuid = str;
    }

    public final String getOs_version() {
        return this.os_version;
    }

    public final void setOs_version(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.os_version = str;
    }

    public final String getImei() {
        return this.imei;
    }

    public final void setImei(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imei = str;
    }

    public final String getSsid() {
        return this.ssid;
    }

    public final void setSsid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ssid = str;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final void setChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channel = str;
    }

    public final String getTerminal_id() {
        return this.terminal_id;
    }

    public final void setTerminal_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.terminal_id = str;
    }

    public final String getApp_uni_id() {
        return this.app_uni_id;
    }

    public final void setApp_uni_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.app_uni_id = str;
    }

    public final String getApp_version() {
        return this.app_version;
    }

    public final void setApp_version(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.app_version = str;
    }

    public final String getLat() {
        return this.lat;
    }

    public final void setLat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lat = str;
    }

    public final String getLng() {
        return this.lng;
    }

    public final void setLng(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lng = str;
    }

    public final DeviceInfo updateAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        DeviceInfo deviceInfo = this;
        deviceInfo.setApp_uni_id(str);
        return deviceInfo;
    }

    public final DeviceInfo updateAppVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "version");
        DeviceInfo deviceInfo = this;
        deviceInfo.setApp_version(str);
        return deviceInfo;
    }

    public final DeviceInfo updateFromType(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        DeviceInfo deviceInfo = this;
        deviceInfo.setFrom_type(str);
        return deviceInfo;
    }
}
