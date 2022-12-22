package com.datadog.android.rum.model;

import com.appsflyer.internal.referrer.Payload;
import com.datadog.android.core.internal.utils.MiscUtilsKt;
import com.datadog.android.log.LogAttributes;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper;
import com.didichuxing.publicservice.p196db.base.AdDbHelper;
import com.didichuxing.publicservice.p196db.model.ScreenAdNewModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.koushikdutta.async.http.AsyncHttpDelete;
import com.koushikdutta.async.http.AsyncHttpHead;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b\b\u0018\u0000 M2\u00020\u0001:\u0018JKLMNOPQRSTUVWXYZ[\\]^_`aB}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u00107\u001a\u00020\u0017HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\t\u0010<\u001a\u00020\u000bHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010@\u001a\u00020\u0013HÆ\u0003J\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020FHÖ\u0001J\u0006\u0010G\u001a\u00020HJ\t\u0010I\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b0\u0010*R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u0006b"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent;", "", "date", "", "application", "Lcom/datadog/android/rum/model/ErrorEvent$Application;", "service", "", "session", "Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSession;", "view", "Lcom/datadog/android/rum/model/ErrorEvent$View;", "usr", "Lcom/datadog/android/rum/model/ErrorEvent$Usr;", "connectivity", "Lcom/datadog/android/rum/model/ErrorEvent$Connectivity;", "synthetics", "Lcom/datadog/android/rum/model/ErrorEvent$Synthetics;", "dd", "Lcom/datadog/android/rum/model/ErrorEvent$Dd;", "context", "Lcom/datadog/android/rum/model/ErrorEvent$Context;", "error", "Lcom/datadog/android/rum/model/ErrorEvent$Error;", "action", "Lcom/datadog/android/rum/model/ErrorEvent$Action;", "(JLcom/datadog/android/rum/model/ErrorEvent$Application;Ljava/lang/String;Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSession;Lcom/datadog/android/rum/model/ErrorEvent$View;Lcom/datadog/android/rum/model/ErrorEvent$Usr;Lcom/datadog/android/rum/model/ErrorEvent$Connectivity;Lcom/datadog/android/rum/model/ErrorEvent$Synthetics;Lcom/datadog/android/rum/model/ErrorEvent$Dd;Lcom/datadog/android/rum/model/ErrorEvent$Context;Lcom/datadog/android/rum/model/ErrorEvent$Error;Lcom/datadog/android/rum/model/ErrorEvent$Action;)V", "getAction", "()Lcom/datadog/android/rum/model/ErrorEvent$Action;", "getApplication", "()Lcom/datadog/android/rum/model/ErrorEvent$Application;", "getConnectivity", "()Lcom/datadog/android/rum/model/ErrorEvent$Connectivity;", "getContext", "()Lcom/datadog/android/rum/model/ErrorEvent$Context;", "getDate", "()J", "getDd", "()Lcom/datadog/android/rum/model/ErrorEvent$Dd;", "getError", "()Lcom/datadog/android/rum/model/ErrorEvent$Error;", "getService", "()Ljava/lang/String;", "getSession", "()Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSession;", "getSynthetics", "()Lcom/datadog/android/rum/model/ErrorEvent$Synthetics;", "type", "getType", "getUsr", "()Lcom/datadog/android/rum/model/ErrorEvent$Usr;", "getView", "()Lcom/datadog/android/rum/model/ErrorEvent$View;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Action", "Application", "Cellular", "Companion", "Connectivity", "Context", "Dd", "DdSession", "Error", "ErrorEventSession", "ErrorEventSessionType", "Handling", "Interface", "Method", "Plan", "Provider", "ProviderType", "Resource", "Source", "SourceType", "Status", "Synthetics", "Usr", "View", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ErrorEvent.kt */
public final class ErrorEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final long f3939a;

    /* renamed from: b */
    private final Application f3940b;

    /* renamed from: c */
    private final String f3941c;

    /* renamed from: d */
    private final ErrorEventSession f3942d;

    /* renamed from: e */
    private final View f3943e;

    /* renamed from: f */
    private final Usr f3944f;

    /* renamed from: g */
    private final Connectivity f3945g;

    /* renamed from: h */
    private final Synthetics f3946h;

    /* renamed from: i */
    private final C2202Dd f3947i;

    /* renamed from: j */
    private final Context f3948j;

    /* renamed from: k */
    private final Error f3949k;

    /* renamed from: l */
    private final Action f3950l;

    /* renamed from: m */
    private final String f3951m;

    public static /* synthetic */ ErrorEvent copy$default(ErrorEvent errorEvent, long j, Application application, String str, ErrorEventSession errorEventSession, View view, Usr usr, Connectivity connectivity, Synthetics synthetics, C2202Dd dd, Context context, Error error, Action action, int i, Object obj) {
        ErrorEvent errorEvent2 = errorEvent;
        int i2 = i;
        return errorEvent.copy((i2 & 1) != 0 ? errorEvent2.f3939a : j, (i2 & 2) != 0 ? errorEvent2.f3940b : application, (i2 & 4) != 0 ? errorEvent2.f3941c : str, (i2 & 8) != 0 ? errorEvent2.f3942d : errorEventSession, (i2 & 16) != 0 ? errorEvent2.f3943e : view, (i2 & 32) != 0 ? errorEvent2.f3944f : usr, (i2 & 64) != 0 ? errorEvent2.f3945g : connectivity, (i2 & 128) != 0 ? errorEvent2.f3946h : synthetics, (i2 & 256) != 0 ? errorEvent2.f3947i : dd, (i2 & 512) != 0 ? errorEvent2.f3948j : context, (i2 & 1024) != 0 ? errorEvent2.f3949k : error, (i2 & 2048) != 0 ? errorEvent2.f3950l : action);
    }

    @JvmStatic
    public static final ErrorEvent fromJson(String str) throws JsonParseException {
        return Companion.fromJson(str);
    }

    public final long component1() {
        return this.f3939a;
    }

    public final Context component10() {
        return this.f3948j;
    }

    public final Error component11() {
        return this.f3949k;
    }

    public final Action component12() {
        return this.f3950l;
    }

    public final Application component2() {
        return this.f3940b;
    }

    public final String component3() {
        return this.f3941c;
    }

    public final ErrorEventSession component4() {
        return this.f3942d;
    }

    public final View component5() {
        return this.f3943e;
    }

    public final Usr component6() {
        return this.f3944f;
    }

    public final Connectivity component7() {
        return this.f3945g;
    }

    public final Synthetics component8() {
        return this.f3946h;
    }

    public final C2202Dd component9() {
        return this.f3947i;
    }

    public final ErrorEvent copy(long j, Application application, String str, ErrorEventSession errorEventSession, View view, Usr usr, Connectivity connectivity, Synthetics synthetics, C2202Dd dd, Context context, Error error, Action action) {
        Application application2 = application;
        Intrinsics.checkNotNullParameter(application2, "application");
        ErrorEventSession errorEventSession2 = errorEventSession;
        Intrinsics.checkNotNullParameter(errorEventSession2, "session");
        View view2 = view;
        Intrinsics.checkNotNullParameter(view2, "view");
        C2202Dd dd2 = dd;
        Intrinsics.checkNotNullParameter(dd2, "dd");
        Error error2 = error;
        Intrinsics.checkNotNullParameter(error2, "error");
        return new ErrorEvent(j, application2, str, errorEventSession2, view2, usr, connectivity, synthetics, dd2, context, error2, action);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorEvent)) {
            return false;
        }
        ErrorEvent errorEvent = (ErrorEvent) obj;
        return this.f3939a == errorEvent.f3939a && Intrinsics.areEqual((Object) this.f3940b, (Object) errorEvent.f3940b) && Intrinsics.areEqual((Object) this.f3941c, (Object) errorEvent.f3941c) && Intrinsics.areEqual((Object) this.f3942d, (Object) errorEvent.f3942d) && Intrinsics.areEqual((Object) this.f3943e, (Object) errorEvent.f3943e) && Intrinsics.areEqual((Object) this.f3944f, (Object) errorEvent.f3944f) && Intrinsics.areEqual((Object) this.f3945g, (Object) errorEvent.f3945g) && Intrinsics.areEqual((Object) this.f3946h, (Object) errorEvent.f3946h) && Intrinsics.areEqual((Object) this.f3947i, (Object) errorEvent.f3947i) && Intrinsics.areEqual((Object) this.f3948j, (Object) errorEvent.f3948j) && Intrinsics.areEqual((Object) this.f3949k, (Object) errorEvent.f3949k) && Intrinsics.areEqual((Object) this.f3950l, (Object) errorEvent.f3950l);
    }

    public int hashCode() {
        int hashCode = ((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3939a) * 31) + this.f3940b.hashCode()) * 31;
        String str = this.f3941c;
        int i = 0;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f3942d.hashCode()) * 31) + this.f3943e.hashCode()) * 31;
        Usr usr = this.f3944f;
        int hashCode3 = (hashCode2 + (usr == null ? 0 : usr.hashCode())) * 31;
        Connectivity connectivity = this.f3945g;
        int hashCode4 = (hashCode3 + (connectivity == null ? 0 : connectivity.hashCode())) * 31;
        Synthetics synthetics = this.f3946h;
        int hashCode5 = (((hashCode4 + (synthetics == null ? 0 : synthetics.hashCode())) * 31) + this.f3947i.hashCode()) * 31;
        Context context = this.f3948j;
        int hashCode6 = (((hashCode5 + (context == null ? 0 : context.hashCode())) * 31) + this.f3949k.hashCode()) * 31;
        Action action = this.f3950l;
        if (action != null) {
            i = action.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "ErrorEvent(date=" + this.f3939a + ", application=" + this.f3940b + ", service=" + this.f3941c + ", session=" + this.f3942d + ", view=" + this.f3943e + ", usr=" + this.f3944f + ", connectivity=" + this.f3945g + ", synthetics=" + this.f3946h + ", dd=" + this.f3947i + ", context=" + this.f3948j + ", error=" + this.f3949k + ", action=" + this.f3950l + VersionRange.RIGHT_OPEN;
    }

    public ErrorEvent(long j, Application application, String str, ErrorEventSession errorEventSession, View view, Usr usr, Connectivity connectivity, Synthetics synthetics, C2202Dd dd, Context context, Error error, Action action) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(errorEventSession, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3939a = j;
        this.f3940b = application;
        this.f3941c = str;
        this.f3942d = errorEventSession;
        this.f3943e = view;
        this.f3944f = usr;
        this.f3945g = connectivity;
        this.f3946h = synthetics;
        this.f3947i = dd;
        this.f3948j = context;
        this.f3949k = error;
        this.f3950l = action;
        this.f3951m = "error";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ErrorEvent(long r18, com.datadog.android.rum.model.ErrorEvent.Application r20, java.lang.String r21, com.datadog.android.rum.model.ErrorEvent.ErrorEventSession r22, com.datadog.android.rum.model.ErrorEvent.View r23, com.datadog.android.rum.model.ErrorEvent.Usr r24, com.datadog.android.rum.model.ErrorEvent.Connectivity r25, com.datadog.android.rum.model.ErrorEvent.Synthetics r26, com.datadog.android.rum.model.ErrorEvent.C2202Dd r27, com.datadog.android.rum.model.ErrorEvent.Context r28, com.datadog.android.rum.model.ErrorEvent.Error r29, com.datadog.android.rum.model.ErrorEvent.Action r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r17 = this;
            r0 = r31
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r7 = r2
            goto L_0x000b
        L_0x0009:
            r7 = r21
        L_0x000b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0011
            r10 = r2
            goto L_0x0013
        L_0x0011:
            r10 = r24
        L_0x0013:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0019
            r11 = r2
            goto L_0x001b
        L_0x0019:
            r11 = r25
        L_0x001b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0021
            r12 = r2
            goto L_0x0023
        L_0x0021:
            r12 = r26
        L_0x0023:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0029
            r14 = r2
            goto L_0x002b
        L_0x0029:
            r14 = r28
        L_0x002b:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0032
            r16 = r2
            goto L_0x0034
        L_0x0032:
            r16 = r30
        L_0x0034:
            r3 = r17
            r4 = r18
            r6 = r20
            r8 = r22
            r9 = r23
            r13 = r27
            r15 = r29
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.rum.model.ErrorEvent.<init>(long, com.datadog.android.rum.model.ErrorEvent$Application, java.lang.String, com.datadog.android.rum.model.ErrorEvent$ErrorEventSession, com.datadog.android.rum.model.ErrorEvent$View, com.datadog.android.rum.model.ErrorEvent$Usr, com.datadog.android.rum.model.ErrorEvent$Connectivity, com.datadog.android.rum.model.ErrorEvent$Synthetics, com.datadog.android.rum.model.ErrorEvent$Dd, com.datadog.android.rum.model.ErrorEvent$Context, com.datadog.android.rum.model.ErrorEvent$Error, com.datadog.android.rum.model.ErrorEvent$Action, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final long getDate() {
        return this.f3939a;
    }

    public final Application getApplication() {
        return this.f3940b;
    }

    public final String getService() {
        return this.f3941c;
    }

    public final ErrorEventSession getSession() {
        return this.f3942d;
    }

    public final View getView() {
        return this.f3943e;
    }

    public final Usr getUsr() {
        return this.f3944f;
    }

    public final Connectivity getConnectivity() {
        return this.f3945g;
    }

    public final Synthetics getSynthetics() {
        return this.f3946h;
    }

    public final C2202Dd getDd() {
        return this.f3947i;
    }

    public final Context getContext() {
        return this.f3948j;
    }

    public final Error getError() {
        return this.f3949k;
    }

    public final Action getAction() {
        return this.f3950l;
    }

    public final String getType() {
        return this.f3951m;
    }

    public final JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(LogAttributes.DATE, (Number) Long.valueOf(this.f3939a));
        jsonObject.add("application", this.f3940b.toJson());
        String str = this.f3941c;
        if (str != null) {
            jsonObject.addProperty("service", str);
        }
        jsonObject.add("session", this.f3942d.toJson());
        jsonObject.add("view", this.f3943e.toJson());
        Usr usr = this.f3944f;
        if (usr != null) {
            jsonObject.add("usr", usr.toJson());
        }
        Connectivity connectivity = this.f3945g;
        if (connectivity != null) {
            jsonObject.add("connectivity", connectivity.toJson());
        }
        Synthetics synthetics = this.f3946h;
        if (synthetics != null) {
            jsonObject.add("synthetics", synthetics.toJson());
        }
        jsonObject.add("_dd", this.f3947i.toJson());
        Context context = this.f3948j;
        if (context != null) {
            jsonObject.add("context", context.toJson());
        }
        jsonObject.addProperty("type", this.f3951m);
        jsonObject.add("error", this.f3949k.toJson());
        Action action = this.f3950l;
        if (action != null) {
            jsonObject.add("action", action.toJson());
        }
        return jsonObject;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0086 A[Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x009e A[Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00c9 A[Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00f5 A[Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }] */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.datadog.android.rum.model.ErrorEvent fromJson(java.lang.String r18) throws com.google.gson.JsonParseException {
            /*
                r17 = this;
                java.lang.String r0 = "it"
                java.lang.String r1 = "serializedObject"
                r2 = r18
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
                com.google.gson.JsonElement r1 = com.google.gson.JsonParser.parseString(r18)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.google.gson.JsonObject r1 = r1.getAsJsonObject()     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                java.lang.String r2 = "date"
                com.google.gson.JsonElement r2 = r1.get(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                long r4 = r2.getAsLong()     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                java.lang.String r2 = "application"
                com.google.gson.JsonElement r2 = r1.get(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.datadog.android.rum.model.ErrorEvent$Application$Companion r3 = com.datadog.android.rum.model.ErrorEvent.Application.Companion     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.datadog.android.rum.model.ErrorEvent$Application r6 = r3.fromJson(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                java.lang.String r2 = "service"
                com.google.gson.JsonElement r2 = r1.get(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                r3 = 0
                if (r2 != 0) goto L_0x0039
                r7 = r3
                goto L_0x003e
            L_0x0039:
                java.lang.String r2 = r2.getAsString()     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                r7 = r2
            L_0x003e:
                java.lang.String r2 = "session"
                com.google.gson.JsonElement r2 = r1.get(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.datadog.android.rum.model.ErrorEvent$ErrorEventSession$Companion r8 = com.datadog.android.rum.model.ErrorEvent.ErrorEventSession.Companion     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.datadog.android.rum.model.ErrorEvent$ErrorEventSession r8 = r8.fromJson(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                java.lang.String r2 = "view"
                com.google.gson.JsonElement r2 = r1.get(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.datadog.android.rum.model.ErrorEvent$View$Companion r9 = com.datadog.android.rum.model.ErrorEvent.View.Companion     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.datadog.android.rum.model.ErrorEvent$View r9 = r9.fromJson(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                java.lang.String r2 = "usr"
                com.google.gson.JsonElement r2 = r1.get(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                if (r2 != 0) goto L_0x006e
            L_0x006c:
                r10 = r3
                goto L_0x007c
            L_0x006e:
                java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                if (r2 != 0) goto L_0x0075
                goto L_0x006c
            L_0x0075:
                com.datadog.android.rum.model.ErrorEvent$Usr$Companion r10 = com.datadog.android.rum.model.ErrorEvent.Usr.Companion     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.datadog.android.rum.model.ErrorEvent$Usr r2 = r10.fromJson(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                r10 = r2
            L_0x007c:
                java.lang.String r2 = "connectivity"
                com.google.gson.JsonElement r2 = r1.get(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                if (r2 != 0) goto L_0x0086
            L_0x0084:
                r11 = r3
                goto L_0x0094
            L_0x0086:
                java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                if (r2 != 0) goto L_0x008d
                goto L_0x0084
            L_0x008d:
                com.datadog.android.rum.model.ErrorEvent$Connectivity$Companion r11 = com.datadog.android.rum.model.ErrorEvent.Connectivity.Companion     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.datadog.android.rum.model.ErrorEvent$Connectivity r2 = r11.fromJson(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                r11 = r2
            L_0x0094:
                java.lang.String r2 = "synthetics"
                com.google.gson.JsonElement r2 = r1.get(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                if (r2 != 0) goto L_0x009e
            L_0x009c:
                r12 = r3
                goto L_0x00ac
            L_0x009e:
                java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                if (r2 != 0) goto L_0x00a5
                goto L_0x009c
            L_0x00a5:
                com.datadog.android.rum.model.ErrorEvent$Synthetics$Companion r12 = com.datadog.android.rum.model.ErrorEvent.Synthetics.Companion     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.datadog.android.rum.model.ErrorEvent$Synthetics r2 = r12.fromJson(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                r12 = r2
            L_0x00ac:
                java.lang.String r2 = "_dd"
                com.google.gson.JsonElement r2 = r1.get(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.datadog.android.rum.model.ErrorEvent$Dd$Companion r13 = com.datadog.android.rum.model.ErrorEvent.C2202Dd.Companion     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.datadog.android.rum.model.ErrorEvent$Dd r13 = r13.fromJson(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                java.lang.String r2 = "context"
                com.google.gson.JsonElement r2 = r1.get(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                if (r2 != 0) goto L_0x00c9
            L_0x00c7:
                r14 = r3
                goto L_0x00d7
            L_0x00c9:
                java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                if (r2 != 0) goto L_0x00d0
                goto L_0x00c7
            L_0x00d0:
                com.datadog.android.rum.model.ErrorEvent$Context$Companion r14 = com.datadog.android.rum.model.ErrorEvent.Context.Companion     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.datadog.android.rum.model.ErrorEvent$Context r2 = r14.fromJson(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                r14 = r2
            L_0x00d7:
                java.lang.String r2 = "error"
                com.google.gson.JsonElement r2 = r1.get(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.datadog.android.rum.model.ErrorEvent$Error$Companion r15 = com.datadog.android.rum.model.ErrorEvent.Error.Companion     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.datadog.android.rum.model.ErrorEvent$Error r15 = r15.fromJson(r2)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                java.lang.String r0 = "action"
                com.google.gson.JsonElement r0 = r1.get(r0)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                if (r0 != 0) goto L_0x00f5
            L_0x00f2:
                r16 = r3
                goto L_0x0104
            L_0x00f5:
                java.lang.String r0 = r0.toString()     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                if (r0 != 0) goto L_0x00fc
                goto L_0x00f2
            L_0x00fc:
                com.datadog.android.rum.model.ErrorEvent$Action$Companion r1 = com.datadog.android.rum.model.ErrorEvent.Action.Companion     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                com.datadog.android.rum.model.ErrorEvent$Action r0 = r1.fromJson(r0)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                r16 = r0
            L_0x0104:
                com.datadog.android.rum.model.ErrorEvent r0 = new com.datadog.android.rum.model.ErrorEvent     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                r3 = r0
                r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ IllegalStateException -> 0x0116, NumberFormatException -> 0x010b }
                return r0
            L_0x010b:
                r0 = move-exception
                com.google.gson.JsonParseException r1 = new com.google.gson.JsonParseException
                java.lang.String r0 = r0.getMessage()
                r1.<init>((java.lang.String) r0)
                throw r1
            L_0x0116:
                r0 = move-exception
                com.google.gson.JsonParseException r1 = new com.google.gson.JsonParseException
                java.lang.String r0 = r0.getMessage()
                r1.<init>((java.lang.String) r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.rum.model.ErrorEvent.Companion.fromJson(java.lang.String):com.datadog.android.rum.model.ErrorEvent");
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Application;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public static final class Application {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        /* renamed from: id */
        private final String f3953id;

        public static /* synthetic */ Application copy$default(Application application, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = application.f3953id;
            }
            return application.copy(str);
        }

        @JvmStatic
        public static final Application fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final String component1() {
            return this.f3953id;
        }

        public final Application copy(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            return new Application(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Application) && Intrinsics.areEqual((Object) this.f3953id, (Object) ((Application) obj).f3953id);
        }

        public int hashCode() {
            return this.f3953id.hashCode();
        }

        public String toString() {
            return "Application(id=" + this.f3953id + VersionRange.RIGHT_OPEN;
        }

        public Application(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            this.f3953id = str;
        }

        public final String getId() {
            return this.f3953id;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", this.f3953id);
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Application$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Application;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Application fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    String asString = JsonParser.parseString(str).getAsJsonObject().get("id").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "id");
                    return new Application(asString);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSession;", "", "id", "", "type", "Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSessionType;", "hasReplay", "", "(Ljava/lang/String;Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSessionType;Ljava/lang/Boolean;)V", "getHasReplay", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "()Ljava/lang/String;", "getType", "()Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSessionType;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSessionType;Ljava/lang/Boolean;)Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSession;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public static final class ErrorEventSession {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Boolean hasReplay;

        /* renamed from: id */
        private final String f3955id;
        private final ErrorEventSessionType type;

        public static /* synthetic */ ErrorEventSession copy$default(ErrorEventSession errorEventSession, String str, ErrorEventSessionType errorEventSessionType, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = errorEventSession.f3955id;
            }
            if ((i & 2) != 0) {
                errorEventSessionType = errorEventSession.type;
            }
            if ((i & 4) != 0) {
                bool = errorEventSession.hasReplay;
            }
            return errorEventSession.copy(str, errorEventSessionType, bool);
        }

        @JvmStatic
        public static final ErrorEventSession fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final String component1() {
            return this.f3955id;
        }

        public final ErrorEventSessionType component2() {
            return this.type;
        }

        public final Boolean component3() {
            return this.hasReplay;
        }

        public final ErrorEventSession copy(String str, ErrorEventSessionType errorEventSessionType, Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(errorEventSessionType, "type");
            return new ErrorEventSession(str, errorEventSessionType, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ErrorEventSession)) {
                return false;
            }
            ErrorEventSession errorEventSession = (ErrorEventSession) obj;
            return Intrinsics.areEqual((Object) this.f3955id, (Object) errorEventSession.f3955id) && this.type == errorEventSession.type && Intrinsics.areEqual((Object) this.hasReplay, (Object) errorEventSession.hasReplay);
        }

        public int hashCode() {
            int hashCode = ((this.f3955id.hashCode() * 31) + this.type.hashCode()) * 31;
            Boolean bool = this.hasReplay;
            return hashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "ErrorEventSession(id=" + this.f3955id + ", type=" + this.type + ", hasReplay=" + this.hasReplay + VersionRange.RIGHT_OPEN;
        }

        public ErrorEventSession(String str, ErrorEventSessionType errorEventSessionType, Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(errorEventSessionType, "type");
            this.f3955id = str;
            this.type = errorEventSessionType;
            this.hasReplay = bool;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ErrorEventSession(String str, ErrorEventSessionType errorEventSessionType, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, errorEventSessionType, (i & 4) != 0 ? null : bool);
        }

        public final String getId() {
            return this.f3955id;
        }

        public final ErrorEventSessionType getType() {
            return this.type;
        }

        public final Boolean getHasReplay() {
            return this.hasReplay;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", this.f3955id);
            jsonObject.add("type", this.type.toJson());
            Boolean bool = this.hasReplay;
            if (bool != null) {
                jsonObject.addProperty("has_replay", Boolean.valueOf(bool.booleanValue()));
            }
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSession$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSession;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ErrorEventSession fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
                    String asString = asJsonObject.get("id").getAsString();
                    String asString2 = asJsonObject.get("type").getAsString();
                    ErrorEventSessionType.Companion companion = ErrorEventSessionType.Companion;
                    Intrinsics.checkNotNullExpressionValue(asString2, "it");
                    ErrorEventSessionType fromJson = companion.fromJson(asString2);
                    JsonElement jsonElement = asJsonObject.get("has_replay");
                    Boolean valueOf = jsonElement == null ? null : Boolean.valueOf(jsonElement.getAsBoolean());
                    Intrinsics.checkNotNullExpressionValue(asString, "id");
                    return new ErrorEventSession(asString, fromJson, valueOf);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJF\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0006\u0010!\u001a\u00020\"J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\u0011¨\u0006%"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$View;", "", "id", "", "referrer", "url", "name", "inForeground", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getInForeground", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "setName", "(Ljava/lang/String;)V", "getReferrer", "setReferrer", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/datadog/android/rum/model/ErrorEvent$View;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public static final class View {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        /* renamed from: id */
        private final String f3958id;
        private final Boolean inForeground;
        private String name;
        private String referrer;
        private String url;

        public static /* synthetic */ View copy$default(View view, String str, String str2, String str3, String str4, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = view.f3958id;
            }
            if ((i & 2) != 0) {
                str2 = view.referrer;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = view.url;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = view.name;
            }
            String str7 = str4;
            if ((i & 16) != 0) {
                bool = view.inForeground;
            }
            return view.copy(str, str5, str6, str7, bool);
        }

        @JvmStatic
        public static final View fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final String component1() {
            return this.f3958id;
        }

        public final String component2() {
            return this.referrer;
        }

        public final String component3() {
            return this.url;
        }

        public final String component4() {
            return this.name;
        }

        public final Boolean component5() {
            return this.inForeground;
        }

        public final View copy(String str, String str2, String str3, String str4, Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str3, "url");
            return new View(str, str2, str3, str4, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof View)) {
                return false;
            }
            View view = (View) obj;
            return Intrinsics.areEqual((Object) this.f3958id, (Object) view.f3958id) && Intrinsics.areEqual((Object) this.referrer, (Object) view.referrer) && Intrinsics.areEqual((Object) this.url, (Object) view.url) && Intrinsics.areEqual((Object) this.name, (Object) view.name) && Intrinsics.areEqual((Object) this.inForeground, (Object) view.inForeground);
        }

        public int hashCode() {
            int hashCode = this.f3958id.hashCode() * 31;
            String str = this.referrer;
            int i = 0;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.url.hashCode()) * 31;
            String str2 = this.name;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.inForeground;
            if (bool != null) {
                i = bool.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "View(id=" + this.f3958id + ", referrer=" + this.referrer + ", url=" + this.url + ", name=" + this.name + ", inForeground=" + this.inForeground + VersionRange.RIGHT_OPEN;
        }

        public View(String str, String str2, String str3, String str4, Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str3, "url");
            this.f3958id = str;
            this.referrer = str2;
            this.url = str3;
            this.name = str4;
            this.inForeground = bool;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ View(String str, String str2, String str3, String str4, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : bool);
        }

        public final String getId() {
            return this.f3958id;
        }

        public final String getReferrer() {
            return this.referrer;
        }

        public final void setReferrer(String str) {
            this.referrer = str;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final Boolean getInForeground() {
            return this.inForeground;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", this.f3958id);
            String str = this.referrer;
            if (str != null) {
                jsonObject.addProperty(Payload.REFERRER, str);
            }
            jsonObject.addProperty("url", this.url);
            String str2 = this.name;
            if (str2 != null) {
                jsonObject.addProperty("name", str2);
            }
            Boolean bool = this.inForeground;
            if (bool != null) {
                jsonObject.addProperty("in_foreground", Boolean.valueOf(bool.booleanValue()));
            }
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$View$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$View;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final View fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
                    String asString = asJsonObject.get("id").getAsString();
                    JsonElement jsonElement = asJsonObject.get(Payload.REFERRER);
                    String asString2 = jsonElement == null ? null : jsonElement.getAsString();
                    String asString3 = asJsonObject.get("url").getAsString();
                    JsonElement jsonElement2 = asJsonObject.get("name");
                    String asString4 = jsonElement2 == null ? null : jsonElement2.getAsString();
                    JsonElement jsonElement3 = asJsonObject.get("in_foreground");
                    Boolean valueOf = jsonElement3 == null ? null : Boolean.valueOf(jsonElement3.getAsBoolean());
                    Intrinsics.checkNotNullExpressionValue(asString, "id");
                    Intrinsics.checkNotNullExpressionValue(asString3, "url");
                    return new View(asString, asString2, asString3, asString4, valueOf);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007HÆ\u0003JE\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001d"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Usr;", "", "id", "", "name", "email", "additionalProperties", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getEmail", "()Ljava/lang/String;", "getId", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public static final class Usr {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final String[] RESERVED_PROPERTIES = {"id", "name", "email"};
        private final Map<String, Object> additionalProperties;
        private final String email;

        /* renamed from: id */
        private final String f3957id;
        private final String name;

        public Usr() {
            this((String) null, (String) null, (String) null, (Map) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Usr copy$default(Usr usr, String str, String str2, String str3, Map<String, Object> map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = usr.f3957id;
            }
            if ((i & 2) != 0) {
                str2 = usr.name;
            }
            if ((i & 4) != 0) {
                str3 = usr.email;
            }
            if ((i & 8) != 0) {
                map = usr.additionalProperties;
            }
            return usr.copy(str, str2, str3, map);
        }

        @JvmStatic
        public static final Usr fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final String component1() {
            return this.f3957id;
        }

        public final String component2() {
            return this.name;
        }

        public final String component3() {
            return this.email;
        }

        public final Map<String, Object> component4() {
            return this.additionalProperties;
        }

        public final Usr copy(String str, String str2, String str3, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "additionalProperties");
            return new Usr(str, str2, str3, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Usr)) {
                return false;
            }
            Usr usr = (Usr) obj;
            return Intrinsics.areEqual((Object) this.f3957id, (Object) usr.f3957id) && Intrinsics.areEqual((Object) this.name, (Object) usr.name) && Intrinsics.areEqual((Object) this.email, (Object) usr.email) && Intrinsics.areEqual((Object) this.additionalProperties, (Object) usr.additionalProperties);
        }

        public int hashCode() {
            String str = this.f3957id;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.name;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.email;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return ((hashCode2 + i) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Usr(id=" + this.f3957id + ", name=" + this.name + ", email=" + this.email + ", additionalProperties=" + this.additionalProperties + VersionRange.RIGHT_OPEN;
        }

        public Usr(String str, String str2, String str3, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "additionalProperties");
            this.f3957id = str;
            this.name = str2;
            this.email = str3;
            this.additionalProperties = map;
        }

        public final String getId() {
            return this.f3957id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getEmail() {
            return this.email;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Usr(String str, String str2, String str3, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.f3957id;
            if (str != null) {
                jsonObject.addProperty("id", str);
            }
            String str2 = this.name;
            if (str2 != null) {
                jsonObject.addProperty("name", str2);
            }
            String str3 = this.email;
            if (str3 != null) {
                jsonObject.addProperty("email", str3);
            }
            for (Map.Entry next : this.additionalProperties.entrySet()) {
                String str4 = (String) next.getKey();
                Object value = next.getValue();
                if (!ArraysKt.contains((T[]) RESERVED_PROPERTIES, str4)) {
                    jsonObject.add(str4, MiscUtilsKt.toJsonElement(value));
                }
            }
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Usr$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Usr;", "serializedObject", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String[] getRESERVED_PROPERTIES$dd_sdk_android_release() {
                return Usr.RESERVED_PROPERTIES;
            }

            @JvmStatic
            public final Usr fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
                    JsonElement jsonElement = asJsonObject.get("id");
                    String str2 = null;
                    String asString = jsonElement == null ? null : jsonElement.getAsString();
                    JsonElement jsonElement2 = asJsonObject.get("name");
                    String asString2 = jsonElement2 == null ? null : jsonElement2.getAsString();
                    JsonElement jsonElement3 = asJsonObject.get("email");
                    if (jsonElement3 != null) {
                        str2 = jsonElement3.getAsString();
                    }
                    Map linkedHashMap = new LinkedHashMap();
                    for (Map.Entry next : asJsonObject.entrySet()) {
                        if (!ArraysKt.contains((T[]) getRESERVED_PROPERTIES$dd_sdk_android_release(), next.getKey())) {
                            Object key = next.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                            linkedHashMap.put(key, next.getValue());
                        }
                    }
                    return new Usr(asString, asString2, str2, linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Connectivity;", "", "status", "Lcom/datadog/android/rum/model/ErrorEvent$Status;", "interfaces", "", "Lcom/datadog/android/rum/model/ErrorEvent$Interface;", "cellular", "Lcom/datadog/android/rum/model/ErrorEvent$Cellular;", "(Lcom/datadog/android/rum/model/ErrorEvent$Status;Ljava/util/List;Lcom/datadog/android/rum/model/ErrorEvent$Cellular;)V", "getCellular", "()Lcom/datadog/android/rum/model/ErrorEvent$Cellular;", "getInterfaces", "()Ljava/util/List;", "getStatus", "()Lcom/datadog/android/rum/model/ErrorEvent$Status;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public static final class Connectivity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Cellular cellular;
        private final List<Interface> interfaces;
        private final Status status;

        public static /* synthetic */ Connectivity copy$default(Connectivity connectivity, Status status2, List<Interface> list, Cellular cellular2, int i, Object obj) {
            if ((i & 1) != 0) {
                status2 = connectivity.status;
            }
            if ((i & 2) != 0) {
                list = connectivity.interfaces;
            }
            if ((i & 4) != 0) {
                cellular2 = connectivity.cellular;
            }
            return connectivity.copy(status2, list, cellular2);
        }

        @JvmStatic
        public static final Connectivity fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final Status component1() {
            return this.status;
        }

        public final List<Interface> component2() {
            return this.interfaces;
        }

        public final Cellular component3() {
            return this.cellular;
        }

        public final Connectivity copy(Status status2, List<? extends Interface> list, Cellular cellular2) {
            Intrinsics.checkNotNullParameter(status2, "status");
            Intrinsics.checkNotNullParameter(list, "interfaces");
            return new Connectivity(status2, list, cellular2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Connectivity)) {
                return false;
            }
            Connectivity connectivity = (Connectivity) obj;
            return this.status == connectivity.status && Intrinsics.areEqual((Object) this.interfaces, (Object) connectivity.interfaces) && Intrinsics.areEqual((Object) this.cellular, (Object) connectivity.cellular);
        }

        public int hashCode() {
            int hashCode = ((this.status.hashCode() * 31) + this.interfaces.hashCode()) * 31;
            Cellular cellular2 = this.cellular;
            return hashCode + (cellular2 == null ? 0 : cellular2.hashCode());
        }

        public String toString() {
            return "Connectivity(status=" + this.status + ", interfaces=" + this.interfaces + ", cellular=" + this.cellular + VersionRange.RIGHT_OPEN;
        }

        public Connectivity(Status status2, List<? extends Interface> list, Cellular cellular2) {
            Intrinsics.checkNotNullParameter(status2, "status");
            Intrinsics.checkNotNullParameter(list, "interfaces");
            this.status = status2;
            this.interfaces = list;
            this.cellular = cellular2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Connectivity(Status status2, List list, Cellular cellular2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(status2, list, (i & 4) != 0 ? null : cellular2);
        }

        public final Status getStatus() {
            return this.status;
        }

        public final List<Interface> getInterfaces() {
            return this.interfaces;
        }

        public final Cellular getCellular() {
            return this.cellular;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("status", this.status.toJson());
            JsonArray jsonArray = new JsonArray(this.interfaces.size());
            for (Interface json : this.interfaces) {
                jsonArray.add(json.toJson());
            }
            jsonObject.add("interfaces", jsonArray);
            Cellular cellular2 = this.cellular;
            if (cellular2 != null) {
                jsonObject.add("cellular", cellular2.toJson());
            }
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Connectivity$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Connectivity;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Connectivity fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
                    String asString = asJsonObject.get("status").getAsString();
                    Status.Companion companion = Status.Companion;
                    Intrinsics.checkNotNullExpressionValue(asString, "it");
                    Status fromJson = companion.fromJson(asString);
                    JsonArray<JsonElement> asJsonArray = asJsonObject.get("interfaces").getAsJsonArray();
                    ArrayList arrayList = new ArrayList(asJsonArray.size());
                    Intrinsics.checkNotNullExpressionValue(asJsonArray, "jsonArray");
                    for (JsonElement asString2 : asJsonArray) {
                        Interface.Companion companion2 = Interface.Companion;
                        String asString3 = asString2.getAsString();
                        Intrinsics.checkNotNullExpressionValue(asString3, "it.asString");
                        arrayList.add(companion2.fromJson(asString3));
                    }
                    JsonElement jsonElement = asJsonObject.get("cellular");
                    Cellular cellular = null;
                    if (jsonElement != null) {
                        String jsonElement2 = jsonElement.toString();
                        if (jsonElement2 != null) {
                            cellular = Cellular.Companion.fromJson(jsonElement2);
                        }
                    }
                    return new Connectivity(fromJson, arrayList, cellular);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Synthetics;", "", "testId", "", "resultId", "(Ljava/lang/String;Ljava/lang/String;)V", "getResultId", "()Ljava/lang/String;", "getTestId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public static final class Synthetics {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String resultId;
        private final String testId;

        public static /* synthetic */ Synthetics copy$default(Synthetics synthetics, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = synthetics.testId;
            }
            if ((i & 2) != 0) {
                str2 = synthetics.resultId;
            }
            return synthetics.copy(str, str2);
        }

        @JvmStatic
        public static final Synthetics fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final String component1() {
            return this.testId;
        }

        public final String component2() {
            return this.resultId;
        }

        public final Synthetics copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "testId");
            Intrinsics.checkNotNullParameter(str2, "resultId");
            return new Synthetics(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Synthetics)) {
                return false;
            }
            Synthetics synthetics = (Synthetics) obj;
            return Intrinsics.areEqual((Object) this.testId, (Object) synthetics.testId) && Intrinsics.areEqual((Object) this.resultId, (Object) synthetics.resultId);
        }

        public int hashCode() {
            return (this.testId.hashCode() * 31) + this.resultId.hashCode();
        }

        public String toString() {
            return "Synthetics(testId=" + this.testId + ", resultId=" + this.resultId + VersionRange.RIGHT_OPEN;
        }

        public Synthetics(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "testId");
            Intrinsics.checkNotNullParameter(str2, "resultId");
            this.testId = str;
            this.resultId = str2;
        }

        public final String getTestId() {
            return this.testId;
        }

        public final String getResultId() {
            return this.resultId;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("test_id", this.testId);
            jsonObject.addProperty("result_id", this.resultId);
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Synthetics$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Synthetics;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Synthetics fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
                    String asString = asJsonObject.get("test_id").getAsString();
                    String asString2 = asJsonObject.get("result_id").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "testId");
                    Intrinsics.checkNotNullExpressionValue(asString2, "resultId");
                    return new Synthetics(asString, asString2);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Dd;", "", "session", "Lcom/datadog/android/rum/model/ErrorEvent$DdSession;", "(Lcom/datadog/android/rum/model/ErrorEvent$DdSession;)V", "formatVersion", "", "getFormatVersion", "()J", "getSession", "()Lcom/datadog/android/rum/model/ErrorEvent$DdSession;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.datadog.android.rum.model.ErrorEvent$Dd */
    /* compiled from: ErrorEvent.kt */
    public static final class C2202Dd {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final long formatVersion;
        private final DdSession session;

        public C2202Dd() {
            this((DdSession) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ C2202Dd copy$default(C2202Dd dd, DdSession ddSession, int i, Object obj) {
            if ((i & 1) != 0) {
                ddSession = dd.session;
            }
            return dd.copy(ddSession);
        }

        @JvmStatic
        public static final C2202Dd fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final DdSession component1() {
            return this.session;
        }

        public final C2202Dd copy(DdSession ddSession) {
            return new C2202Dd(ddSession);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C2202Dd) && Intrinsics.areEqual((Object) this.session, (Object) ((C2202Dd) obj).session);
        }

        public int hashCode() {
            DdSession ddSession = this.session;
            if (ddSession == null) {
                return 0;
            }
            return ddSession.hashCode();
        }

        public String toString() {
            return "Dd(session=" + this.session + VersionRange.RIGHT_OPEN;
        }

        public C2202Dd(DdSession ddSession) {
            this.session = ddSession;
            this.formatVersion = 2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C2202Dd(DdSession ddSession, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : ddSession);
        }

        public final DdSession getSession() {
            return this.session;
        }

        public final long getFormatVersion() {
            return this.formatVersion;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("format_version", (Number) Long.valueOf(this.formatVersion));
            DdSession ddSession = this.session;
            if (ddSession != null) {
                jsonObject.add("session", ddSession.toJson());
            }
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Dd$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Dd;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* renamed from: com.datadog.android.rum.model.ErrorEvent$Dd$Companion */
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final C2202Dd fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    JsonElement jsonElement = JsonParser.parseString(str).getAsJsonObject().get("session");
                    DdSession ddSession = null;
                    if (jsonElement != null) {
                        String jsonElement2 = jsonElement.toString();
                        if (jsonElement2 != null) {
                            ddSession = DdSession.Companion.fromJson(jsonElement2);
                        }
                    }
                    return new C2202Dd(ddSession);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0017\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J!\u0010\t\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Context;", "", "additionalProperties", "", "", "(Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public static final class Context {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Map<String, Object> additionalProperties;

        public Context() {
            this((Map) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Context copy$default(Context context, Map<String, Object> map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = context.additionalProperties;
            }
            return context.copy(map);
        }

        @JvmStatic
        public static final Context fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final Map<String, Object> component1() {
            return this.additionalProperties;
        }

        public final Context copy(Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "additionalProperties");
            return new Context(map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Context) && Intrinsics.areEqual((Object) this.additionalProperties, (Object) ((Context) obj).additionalProperties);
        }

        public int hashCode() {
            return this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Context(additionalProperties=" + this.additionalProperties + VersionRange.RIGHT_OPEN;
        }

        public Context(Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "additionalProperties");
            this.additionalProperties = map;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Context(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry next : this.additionalProperties.entrySet()) {
                jsonObject.add((String) next.getKey(), MiscUtilsKt.toJsonElement(next.getValue()));
            }
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Context$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Context;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Context fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
                    Map linkedHashMap = new LinkedHashMap();
                    for (Map.Entry next : asJsonObject.entrySet()) {
                        Object key = next.getKey();
                        Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                        linkedHashMap.put(key, next.getValue());
                    }
                    return new Context(linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 92\u00020\u0001:\u00019Bu\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\u0006\u00106\u001a\u000207J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\b\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u0006:"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Error;", "", "id", "", "message", "source", "Lcom/datadog/android/rum/model/ErrorEvent$Source;", "stack", "isCrash", "", "type", "handling", "Lcom/datadog/android/rum/model/ErrorEvent$Handling;", "handlingStack", "sourceType", "Lcom/datadog/android/rum/model/ErrorEvent$SourceType;", "resource", "Lcom/datadog/android/rum/model/ErrorEvent$Resource;", "(Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/model/ErrorEvent$Source;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/datadog/android/rum/model/ErrorEvent$Handling;Ljava/lang/String;Lcom/datadog/android/rum/model/ErrorEvent$SourceType;Lcom/datadog/android/rum/model/ErrorEvent$Resource;)V", "getHandling", "()Lcom/datadog/android/rum/model/ErrorEvent$Handling;", "getHandlingStack", "()Ljava/lang/String;", "getId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMessage", "setMessage", "(Ljava/lang/String;)V", "getResource", "()Lcom/datadog/android/rum/model/ErrorEvent$Resource;", "getSource", "()Lcom/datadog/android/rum/model/ErrorEvent$Source;", "getSourceType", "()Lcom/datadog/android/rum/model/ErrorEvent$SourceType;", "getStack", "setStack", "getType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/model/ErrorEvent$Source;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/datadog/android/rum/model/ErrorEvent$Handling;Ljava/lang/String;Lcom/datadog/android/rum/model/ErrorEvent$SourceType;Lcom/datadog/android/rum/model/ErrorEvent$Resource;)Lcom/datadog/android/rum/model/ErrorEvent$Error;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public static final class Error {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Handling handling;
        private final String handlingStack;

        /* renamed from: id */
        private final String f3954id;
        private final Boolean isCrash;
        private String message;
        private final Resource resource;
        private final Source source;
        private final SourceType sourceType;
        private String stack;
        private final String type;

        public static /* synthetic */ Error copy$default(Error error, String str, String str2, Source source2, String str3, Boolean bool, String str4, Handling handling2, String str5, SourceType sourceType2, Resource resource2, int i, Object obj) {
            Error error2 = error;
            int i2 = i;
            return error.copy((i2 & 1) != 0 ? error2.f3954id : str, (i2 & 2) != 0 ? error2.message : str2, (i2 & 4) != 0 ? error2.source : source2, (i2 & 8) != 0 ? error2.stack : str3, (i2 & 16) != 0 ? error2.isCrash : bool, (i2 & 32) != 0 ? error2.type : str4, (i2 & 64) != 0 ? error2.handling : handling2, (i2 & 128) != 0 ? error2.handlingStack : str5, (i2 & 256) != 0 ? error2.sourceType : sourceType2, (i2 & 512) != 0 ? error2.resource : resource2);
        }

        @JvmStatic
        public static final Error fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final String component1() {
            return this.f3954id;
        }

        public final Resource component10() {
            return this.resource;
        }

        public final String component2() {
            return this.message;
        }

        public final Source component3() {
            return this.source;
        }

        public final String component4() {
            return this.stack;
        }

        public final Boolean component5() {
            return this.isCrash;
        }

        public final String component6() {
            return this.type;
        }

        public final Handling component7() {
            return this.handling;
        }

        public final String component8() {
            return this.handlingStack;
        }

        public final SourceType component9() {
            return this.sourceType;
        }

        public final Error copy(String str, String str2, Source source2, String str3, Boolean bool, String str4, Handling handling2, String str5, SourceType sourceType2, Resource resource2) {
            Intrinsics.checkNotNullParameter(str2, "message");
            Intrinsics.checkNotNullParameter(source2, "source");
            return new Error(str, str2, source2, str3, bool, str4, handling2, str5, sourceType2, resource2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual((Object) this.f3954id, (Object) error.f3954id) && Intrinsics.areEqual((Object) this.message, (Object) error.message) && this.source == error.source && Intrinsics.areEqual((Object) this.stack, (Object) error.stack) && Intrinsics.areEqual((Object) this.isCrash, (Object) error.isCrash) && Intrinsics.areEqual((Object) this.type, (Object) error.type) && this.handling == error.handling && Intrinsics.areEqual((Object) this.handlingStack, (Object) error.handlingStack) && this.sourceType == error.sourceType && Intrinsics.areEqual((Object) this.resource, (Object) error.resource);
        }

        public int hashCode() {
            String str = this.f3954id;
            int i = 0;
            int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.message.hashCode()) * 31) + this.source.hashCode()) * 31;
            String str2 = this.stack;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.isCrash;
            int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str3 = this.type;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Handling handling2 = this.handling;
            int hashCode5 = (hashCode4 + (handling2 == null ? 0 : handling2.hashCode())) * 31;
            String str4 = this.handlingStack;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            SourceType sourceType2 = this.sourceType;
            int hashCode7 = (hashCode6 + (sourceType2 == null ? 0 : sourceType2.hashCode())) * 31;
            Resource resource2 = this.resource;
            if (resource2 != null) {
                i = resource2.hashCode();
            }
            return hashCode7 + i;
        }

        public String toString() {
            return "Error(id=" + this.f3954id + ", message=" + this.message + ", source=" + this.source + ", stack=" + this.stack + ", isCrash=" + this.isCrash + ", type=" + this.type + ", handling=" + this.handling + ", handlingStack=" + this.handlingStack + ", sourceType=" + this.sourceType + ", resource=" + this.resource + VersionRange.RIGHT_OPEN;
        }

        public Error(String str, String str2, Source source2, String str3, Boolean bool, String str4, Handling handling2, String str5, SourceType sourceType2, Resource resource2) {
            Intrinsics.checkNotNullParameter(str2, "message");
            Intrinsics.checkNotNullParameter(source2, "source");
            this.f3954id = str;
            this.message = str2;
            this.source = source2;
            this.stack = str3;
            this.isCrash = bool;
            this.type = str4;
            this.handling = handling2;
            this.handlingStack = str5;
            this.sourceType = sourceType2;
            this.resource = resource2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Error(java.lang.String r15, java.lang.String r16, com.datadog.android.rum.model.ErrorEvent.Source r17, java.lang.String r18, java.lang.Boolean r19, java.lang.String r20, com.datadog.android.rum.model.ErrorEvent.Handling r21, java.lang.String r22, com.datadog.android.rum.model.ErrorEvent.SourceType r23, com.datadog.android.rum.model.ErrorEvent.Resource r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
            /*
                r14 = this;
                r0 = r25
                r1 = r0 & 1
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r4 = r2
                goto L_0x000a
            L_0x0009:
                r4 = r15
            L_0x000a:
                r1 = r0 & 8
                if (r1 == 0) goto L_0x0010
                r7 = r2
                goto L_0x0012
            L_0x0010:
                r7 = r18
            L_0x0012:
                r1 = r0 & 16
                if (r1 == 0) goto L_0x0018
                r8 = r2
                goto L_0x001a
            L_0x0018:
                r8 = r19
            L_0x001a:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x0020
                r9 = r2
                goto L_0x0022
            L_0x0020:
                r9 = r20
            L_0x0022:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0028
                r10 = r2
                goto L_0x002a
            L_0x0028:
                r10 = r21
            L_0x002a:
                r1 = r0 & 128(0x80, float:1.794E-43)
                if (r1 == 0) goto L_0x0030
                r11 = r2
                goto L_0x0032
            L_0x0030:
                r11 = r22
            L_0x0032:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L_0x0038
                r12 = r2
                goto L_0x003a
            L_0x0038:
                r12 = r23
            L_0x003a:
                r0 = r0 & 512(0x200, float:7.175E-43)
                if (r0 == 0) goto L_0x0040
                r13 = r2
                goto L_0x0042
            L_0x0040:
                r13 = r24
            L_0x0042:
                r3 = r14
                r5 = r16
                r6 = r17
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.rum.model.ErrorEvent.Error.<init>(java.lang.String, java.lang.String, com.datadog.android.rum.model.ErrorEvent$Source, java.lang.String, java.lang.Boolean, java.lang.String, com.datadog.android.rum.model.ErrorEvent$Handling, java.lang.String, com.datadog.android.rum.model.ErrorEvent$SourceType, com.datadog.android.rum.model.ErrorEvent$Resource, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getId() {
            return this.f3954id;
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.message = str;
        }

        public final Source getSource() {
            return this.source;
        }

        public final String getStack() {
            return this.stack;
        }

        public final void setStack(String str) {
            this.stack = str;
        }

        public final Boolean isCrash() {
            return this.isCrash;
        }

        public final String getType() {
            return this.type;
        }

        public final Handling getHandling() {
            return this.handling;
        }

        public final String getHandlingStack() {
            return this.handlingStack;
        }

        public final SourceType getSourceType() {
            return this.sourceType;
        }

        public final Resource getResource() {
            return this.resource;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.f3954id;
            if (str != null) {
                jsonObject.addProperty("id", str);
            }
            jsonObject.addProperty("message", this.message);
            jsonObject.add("source", this.source.toJson());
            String str2 = this.stack;
            if (str2 != null) {
                jsonObject.addProperty("stack", str2);
            }
            Boolean bool = this.isCrash;
            if (bool != null) {
                jsonObject.addProperty("is_crash", Boolean.valueOf(bool.booleanValue()));
            }
            String str3 = this.type;
            if (str3 != null) {
                jsonObject.addProperty("type", str3);
            }
            Handling handling2 = this.handling;
            if (handling2 != null) {
                jsonObject.add("handling", handling2.toJson());
            }
            String str4 = this.handlingStack;
            if (str4 != null) {
                jsonObject.addProperty("handling_stack", str4);
            }
            SourceType sourceType2 = this.sourceType;
            if (sourceType2 != null) {
                jsonObject.add(ParamKeys.PARAM_CHARGE_DISSENT_SOURCE, sourceType2.toJson());
            }
            Resource resource2 = this.resource;
            if (resource2 != null) {
                jsonObject.add("resource", resource2.toJson());
            }
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Error$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Error;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARNING: Removed duplicated region for block: B:27:0x008d A[Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }] */
            /* JADX WARNING: Removed duplicated region for block: B:28:0x008f A[Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }] */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x009e A[Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }] */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x00b6 A[Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }] */
            @kotlin.jvm.JvmStatic
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final com.datadog.android.rum.model.ErrorEvent.Error fromJson(java.lang.String r15) throws com.google.gson.JsonParseException {
                /*
                    r14 = this;
                    java.lang.String r0 = "message"
                    java.lang.String r1 = "serializedObject"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
                    com.google.gson.JsonElement r15 = com.google.gson.JsonParser.parseString(r15)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    com.google.gson.JsonObject r15 = r15.getAsJsonObject()     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    java.lang.String r1 = "id"
                    com.google.gson.JsonElement r1 = r15.get(r1)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    r2 = 0
                    if (r1 != 0) goto L_0x001a
                    r4 = r2
                    goto L_0x001f
                L_0x001a:
                    java.lang.String r1 = r1.getAsString()     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    r4 = r1
                L_0x001f:
                    com.google.gson.JsonElement r1 = r15.get(r0)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    java.lang.String r5 = r1.getAsString()     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    java.lang.String r1 = "source"
                    com.google.gson.JsonElement r1 = r15.get(r1)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    java.lang.String r1 = r1.getAsString()     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    com.datadog.android.rum.model.ErrorEvent$Source$Companion r3 = com.datadog.android.rum.model.ErrorEvent.Source.Companion     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    java.lang.String r6 = "it"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    com.datadog.android.rum.model.ErrorEvent$Source r6 = r3.fromJson(r1)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    java.lang.String r1 = "stack"
                    com.google.gson.JsonElement r1 = r15.get(r1)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    if (r1 != 0) goto L_0x0046
                    r7 = r2
                    goto L_0x004b
                L_0x0046:
                    java.lang.String r1 = r1.getAsString()     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    r7 = r1
                L_0x004b:
                    java.lang.String r1 = "is_crash"
                    com.google.gson.JsonElement r1 = r15.get(r1)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    if (r1 != 0) goto L_0x0055
                    r8 = r2
                    goto L_0x005e
                L_0x0055:
                    boolean r1 = r1.getAsBoolean()     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    r8 = r1
                L_0x005e:
                    java.lang.String r1 = "type"
                    com.google.gson.JsonElement r1 = r15.get(r1)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    if (r1 != 0) goto L_0x0068
                    r9 = r2
                    goto L_0x006d
                L_0x0068:
                    java.lang.String r1 = r1.getAsString()     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    r9 = r1
                L_0x006d:
                    java.lang.String r1 = "handling"
                    com.google.gson.JsonElement r1 = r15.get(r1)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    if (r1 != 0) goto L_0x0077
                L_0x0075:
                    r10 = r2
                    goto L_0x0085
                L_0x0077:
                    java.lang.String r1 = r1.getAsString()     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    if (r1 != 0) goto L_0x007e
                    goto L_0x0075
                L_0x007e:
                    com.datadog.android.rum.model.ErrorEvent$Handling$Companion r3 = com.datadog.android.rum.model.ErrorEvent.Handling.Companion     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    com.datadog.android.rum.model.ErrorEvent$Handling r1 = r3.fromJson(r1)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    r10 = r1
                L_0x0085:
                    java.lang.String r1 = "handling_stack"
                    com.google.gson.JsonElement r1 = r15.get(r1)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    if (r1 != 0) goto L_0x008f
                    r11 = r2
                    goto L_0x0094
                L_0x008f:
                    java.lang.String r1 = r1.getAsString()     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    r11 = r1
                L_0x0094:
                    java.lang.String r1 = "source_type"
                    com.google.gson.JsonElement r1 = r15.get(r1)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    if (r1 != 0) goto L_0x009e
                L_0x009c:
                    r12 = r2
                    goto L_0x00ac
                L_0x009e:
                    java.lang.String r1 = r1.getAsString()     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    if (r1 != 0) goto L_0x00a5
                    goto L_0x009c
                L_0x00a5:
                    com.datadog.android.rum.model.ErrorEvent$SourceType$Companion r3 = com.datadog.android.rum.model.ErrorEvent.SourceType.Companion     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    com.datadog.android.rum.model.ErrorEvent$SourceType r1 = r3.fromJson(r1)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    r12 = r1
                L_0x00ac:
                    java.lang.String r1 = "resource"
                    com.google.gson.JsonElement r15 = r15.get(r1)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    if (r15 != 0) goto L_0x00b6
                L_0x00b4:
                    r13 = r2
                    goto L_0x00c4
                L_0x00b6:
                    java.lang.String r15 = r15.toString()     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    if (r15 != 0) goto L_0x00bd
                    goto L_0x00b4
                L_0x00bd:
                    com.datadog.android.rum.model.ErrorEvent$Resource$Companion r1 = com.datadog.android.rum.model.ErrorEvent.Resource.Companion     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    com.datadog.android.rum.model.ErrorEvent$Resource r2 = r1.fromJson(r15)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    goto L_0x00b4
                L_0x00c4:
                    com.datadog.android.rum.model.ErrorEvent$Error r15 = new com.datadog.android.rum.model.ErrorEvent$Error     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    r3 = r15
                    r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ IllegalStateException -> 0x00d9, NumberFormatException -> 0x00ce }
                    return r15
                L_0x00ce:
                    r15 = move-exception
                    com.google.gson.JsonParseException r0 = new com.google.gson.JsonParseException
                    java.lang.String r15 = r15.getMessage()
                    r0.<init>((java.lang.String) r15)
                    throw r0
                L_0x00d9:
                    r15 = move-exception
                    com.google.gson.JsonParseException r0 = new com.google.gson.JsonParseException
                    java.lang.String r15 = r15.getMessage()
                    r0.<init>((java.lang.String) r15)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.rum.model.ErrorEvent.Error.Companion.fromJson(java.lang.String):com.datadog.android.rum.model.ErrorEvent$Error");
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Action;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public static final class Action {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        /* renamed from: id */
        private final String f3952id;

        public static /* synthetic */ Action copy$default(Action action, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = action.f3952id;
            }
            return action.copy(str);
        }

        @JvmStatic
        public static final Action fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final String component1() {
            return this.f3952id;
        }

        public final Action copy(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            return new Action(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Action) && Intrinsics.areEqual((Object) this.f3952id, (Object) ((Action) obj).f3952id);
        }

        public int hashCode() {
            return this.f3952id.hashCode();
        }

        public String toString() {
            return "Action(id=" + this.f3952id + VersionRange.RIGHT_OPEN;
        }

        public Action(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            this.f3952id = str;
        }

        public final String getId() {
            return this.f3952id;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", this.f3952id);
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Action$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Action;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Action fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    String asString = JsonParser.parseString(str).getAsJsonObject().get("id").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "id");
                    return new Action(asString);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Cellular;", "", "technology", "", "carrierName", "(Ljava/lang/String;Ljava/lang/String;)V", "getCarrierName", "()Ljava/lang/String;", "getTechnology", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public static final class Cellular {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String carrierName;
        private final String technology;

        public Cellular() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Cellular copy$default(Cellular cellular, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cellular.technology;
            }
            if ((i & 2) != 0) {
                str2 = cellular.carrierName;
            }
            return cellular.copy(str, str2);
        }

        @JvmStatic
        public static final Cellular fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final String component1() {
            return this.technology;
        }

        public final String component2() {
            return this.carrierName;
        }

        public final Cellular copy(String str, String str2) {
            return new Cellular(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Cellular)) {
                return false;
            }
            Cellular cellular = (Cellular) obj;
            return Intrinsics.areEqual((Object) this.technology, (Object) cellular.technology) && Intrinsics.areEqual((Object) this.carrierName, (Object) cellular.carrierName);
        }

        public int hashCode() {
            String str = this.technology;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.carrierName;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Cellular(technology=" + this.technology + ", carrierName=" + this.carrierName + VersionRange.RIGHT_OPEN;
        }

        public Cellular(String str, String str2) {
            this.technology = str;
            this.carrierName = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Cellular(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getTechnology() {
            return this.technology;
        }

        public final String getCarrierName() {
            return this.carrierName;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.technology;
            if (str != null) {
                jsonObject.addProperty("technology", str);
            }
            String str2 = this.carrierName;
            if (str2 != null) {
                jsonObject.addProperty("carrier_name", str2);
            }
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Cellular$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Cellular;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Cellular fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
                    JsonElement jsonElement = asJsonObject.get("technology");
                    String str2 = null;
                    String asString = jsonElement == null ? null : jsonElement.getAsString();
                    JsonElement jsonElement2 = asJsonObject.get("carrier_name");
                    if (jsonElement2 != null) {
                        str2 = jsonElement2.getAsString();
                    }
                    return new Cellular(asString, str2);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$DdSession;", "", "plan", "Lcom/datadog/android/rum/model/ErrorEvent$Plan;", "(Lcom/datadog/android/rum/model/ErrorEvent$Plan;)V", "getPlan", "()Lcom/datadog/android/rum/model/ErrorEvent$Plan;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public static final class DdSession {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Plan plan;

        public static /* synthetic */ DdSession copy$default(DdSession ddSession, Plan plan2, int i, Object obj) {
            if ((i & 1) != 0) {
                plan2 = ddSession.plan;
            }
            return ddSession.copy(plan2);
        }

        @JvmStatic
        public static final DdSession fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final Plan component1() {
            return this.plan;
        }

        public final DdSession copy(Plan plan2) {
            Intrinsics.checkNotNullParameter(plan2, "plan");
            return new DdSession(plan2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DdSession) && this.plan == ((DdSession) obj).plan;
        }

        public int hashCode() {
            return this.plan.hashCode();
        }

        public String toString() {
            return "DdSession(plan=" + this.plan + VersionRange.RIGHT_OPEN;
        }

        public DdSession(Plan plan2) {
            Intrinsics.checkNotNullParameter(plan2, "plan");
            this.plan = plan2;
        }

        public final Plan getPlan() {
            return this.plan;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("plan", this.plan.toJson());
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$DdSession$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$DdSession;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final DdSession fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    String asString = JsonParser.parseString(str).getAsJsonObject().get("plan").getAsString();
                    Plan.Companion companion = Plan.Companion;
                    Intrinsics.checkNotNullExpressionValue(asString, "it");
                    return new DdSession(companion.fromJson(asString));
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0006\u0010\u001f\u001a\u00020 J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006#"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Resource;", "", "method", "Lcom/datadog/android/rum/model/ErrorEvent$Method;", "statusCode", "", "url", "", "provider", "Lcom/datadog/android/rum/model/ErrorEvent$Provider;", "(Lcom/datadog/android/rum/model/ErrorEvent$Method;JLjava/lang/String;Lcom/datadog/android/rum/model/ErrorEvent$Provider;)V", "getMethod", "()Lcom/datadog/android/rum/model/ErrorEvent$Method;", "getProvider", "()Lcom/datadog/android/rum/model/ErrorEvent$Provider;", "getStatusCode", "()J", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public static final class Resource {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Method method;
        private final Provider provider;
        private final long statusCode;
        private String url;

        public static /* synthetic */ Resource copy$default(Resource resource, Method method2, long j, String str, Provider provider2, int i, Object obj) {
            if ((i & 1) != 0) {
                method2 = resource.method;
            }
            if ((i & 2) != 0) {
                j = resource.statusCode;
            }
            long j2 = j;
            if ((i & 4) != 0) {
                str = resource.url;
            }
            String str2 = str;
            if ((i & 8) != 0) {
                provider2 = resource.provider;
            }
            return resource.copy(method2, j2, str2, provider2);
        }

        @JvmStatic
        public static final Resource fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final Method component1() {
            return this.method;
        }

        public final long component2() {
            return this.statusCode;
        }

        public final String component3() {
            return this.url;
        }

        public final Provider component4() {
            return this.provider;
        }

        public final Resource copy(Method method2, long j, String str, Provider provider2) {
            Intrinsics.checkNotNullParameter(method2, "method");
            Intrinsics.checkNotNullParameter(str, "url");
            return new Resource(method2, j, str, provider2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Resource)) {
                return false;
            }
            Resource resource = (Resource) obj;
            return this.method == resource.method && this.statusCode == resource.statusCode && Intrinsics.areEqual((Object) this.url, (Object) resource.url) && Intrinsics.areEqual((Object) this.provider, (Object) resource.provider);
        }

        public int hashCode() {
            int hashCode = ((((this.method.hashCode() * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.statusCode)) * 31) + this.url.hashCode()) * 31;
            Provider provider2 = this.provider;
            return hashCode + (provider2 == null ? 0 : provider2.hashCode());
        }

        public String toString() {
            return "Resource(method=" + this.method + ", statusCode=" + this.statusCode + ", url=" + this.url + ", provider=" + this.provider + VersionRange.RIGHT_OPEN;
        }

        public Resource(Method method2, long j, String str, Provider provider2) {
            Intrinsics.checkNotNullParameter(method2, "method");
            Intrinsics.checkNotNullParameter(str, "url");
            this.method = method2;
            this.statusCode = j;
            this.url = str;
            this.provider = provider2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Resource(Method method2, long j, String str, Provider provider2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(method2, j, str, (i & 8) != 0 ? null : provider2);
        }

        public final Method getMethod() {
            return this.method;
        }

        public final long getStatusCode() {
            return this.statusCode;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }

        public final Provider getProvider() {
            return this.provider;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("method", this.method.toJson());
            jsonObject.addProperty("status_code", (Number) Long.valueOf(this.statusCode));
            jsonObject.addProperty("url", this.url);
            Provider provider2 = this.provider;
            if (provider2 != null) {
                jsonObject.add("provider", provider2.toJson());
            }
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Resource$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Resource;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Resource fromJson(String str) throws JsonParseException {
                Provider provider;
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
                    String asString = asJsonObject.get("method").getAsString();
                    Method.Companion companion = Method.Companion;
                    Intrinsics.checkNotNullExpressionValue(asString, "it");
                    Method fromJson = companion.fromJson(asString);
                    long asLong = asJsonObject.get("status_code").getAsLong();
                    String asString2 = asJsonObject.get("url").getAsString();
                    JsonElement jsonElement = asJsonObject.get("provider");
                    if (jsonElement != null) {
                        String jsonElement2 = jsonElement.toString();
                        if (jsonElement2 != null) {
                            provider = Provider.Companion.fromJson(jsonElement2);
                            Intrinsics.checkNotNullExpressionValue(asString2, "url");
                            return new Resource(fromJson, asLong, asString2, provider);
                        }
                    }
                    provider = null;
                    Intrinsics.checkNotNullExpressionValue(asString2, "url");
                    return new Resource(fromJson, asLong, asString2, provider);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Provider;", "", "domain", "", "name", "type", "Lcom/datadog/android/rum/model/ErrorEvent$ProviderType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/model/ErrorEvent$ProviderType;)V", "getDomain", "()Ljava/lang/String;", "getName", "getType", "()Lcom/datadog/android/rum/model/ErrorEvent$ProviderType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public static final class Provider {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String domain;
        private final String name;
        private final ProviderType type;

        public Provider() {
            this((String) null, (String) null, (ProviderType) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Provider copy$default(Provider provider, String str, String str2, ProviderType providerType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = provider.domain;
            }
            if ((i & 2) != 0) {
                str2 = provider.name;
            }
            if ((i & 4) != 0) {
                providerType = provider.type;
            }
            return provider.copy(str, str2, providerType);
        }

        @JvmStatic
        public static final Provider fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final String component1() {
            return this.domain;
        }

        public final String component2() {
            return this.name;
        }

        public final ProviderType component3() {
            return this.type;
        }

        public final Provider copy(String str, String str2, ProviderType providerType) {
            return new Provider(str, str2, providerType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Provider)) {
                return false;
            }
            Provider provider = (Provider) obj;
            return Intrinsics.areEqual((Object) this.domain, (Object) provider.domain) && Intrinsics.areEqual((Object) this.name, (Object) provider.name) && this.type == provider.type;
        }

        public int hashCode() {
            String str = this.domain;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.name;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            ProviderType providerType = this.type;
            if (providerType != null) {
                i = providerType.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "Provider(domain=" + this.domain + ", name=" + this.name + ", type=" + this.type + VersionRange.RIGHT_OPEN;
        }

        public Provider(String str, String str2, ProviderType providerType) {
            this.domain = str;
            this.name = str2;
            this.type = providerType;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Provider(String str, String str2, ProviderType providerType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : providerType);
        }

        public final String getDomain() {
            return this.domain;
        }

        public final String getName() {
            return this.name;
        }

        public final ProviderType getType() {
            return this.type;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.domain;
            if (str != null) {
                jsonObject.addProperty("domain", str);
            }
            String str2 = this.name;
            if (str2 != null) {
                jsonObject.addProperty("name", str2);
            }
            ProviderType providerType = this.type;
            if (providerType != null) {
                jsonObject.add("type", providerType.toJson());
            }
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Provider$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Provider;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Provider fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
                    JsonElement jsonElement = asJsonObject.get("domain");
                    ProviderType providerType = null;
                    String asString = jsonElement == null ? null : jsonElement.getAsString();
                    JsonElement jsonElement2 = asJsonObject.get("name");
                    String asString2 = jsonElement2 == null ? null : jsonElement2.getAsString();
                    JsonElement jsonElement3 = asJsonObject.get("type");
                    if (jsonElement3 != null) {
                        String asString3 = jsonElement3.getAsString();
                        if (asString3 != null) {
                            providerType = ProviderType.Companion.fromJson(asString3);
                        }
                    }
                    return new Provider(asString, asString2, providerType);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSessionType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "USER", "SYNTHETICS", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public enum ErrorEventSessionType {
        USER("user"),
        SYNTHETICS("synthetics");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String jsonValue;

        @JvmStatic
        public static final ErrorEventSessionType fromJson(String str) {
            return Companion.fromJson(str);
        }

        private ErrorEventSessionType(String str) {
            this.jsonValue = str;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSessionType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSessionType;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ErrorEventSessionType fromJson(String str) {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                for (ErrorEventSessionType errorEventSessionType : ErrorEventSessionType.values()) {
                    if (Intrinsics.areEqual((Object) errorEventSessionType.jsonValue, (Object) str)) {
                        return errorEventSessionType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Status;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "CONNECTED", "NOT_CONNECTED", "MAYBE", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public enum Status {
        CONNECTED(AnalyseTickHelper.SDK_CONNECTED),
        NOT_CONNECTED("not_connected"),
        MAYBE("maybe");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String jsonValue;

        @JvmStatic
        public static final Status fromJson(String str) {
            return Companion.fromJson(str);
        }

        private Status(String str) {
            this.jsonValue = str;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Status$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Status;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Status fromJson(String str) {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                for (Status status : Status.values()) {
                    if (Intrinsics.areEqual((Object) status.jsonValue, (Object) str)) {
                        return status;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Interface;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "BLUETOOTH", "CELLULAR", "ETHERNET", "WIFI", "WIMAX", "MIXED", "OTHER", "UNKNOWN", "NONE", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public enum Interface {
        BLUETOOTH("bluetooth"),
        CELLULAR("cellular"),
        ETHERNET("ethernet"),
        WIFI("wifi"),
        WIMAX("wimax"),
        MIXED("mixed"),
        OTHER("other"),
        UNKNOWN("unknown"),
        NONE("none");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String jsonValue;

        @JvmStatic
        public static final Interface fromJson(String str) {
            return Companion.fromJson(str);
        }

        private Interface(String str) {
            this.jsonValue = str;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Interface$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Interface;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Interface fromJson(String str) {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                for (Interface interfaceR : Interface.values()) {
                    if (Intrinsics.areEqual((Object) interfaceR.jsonValue, (Object) str)) {
                        return interfaceR;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Source;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "NETWORK", "SOURCE", "CONSOLE", "LOGGER", "AGENT", "WEBVIEW", "CUSTOM", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public enum Source {
        NETWORK("network"),
        SOURCE("source"),
        CONSOLE("console"),
        LOGGER("logger"),
        AGENT("agent"),
        WEBVIEW("webview"),
        CUSTOM("custom");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String jsonValue;

        @JvmStatic
        public static final Source fromJson(String str) {
            return Companion.fromJson(str);
        }

        private Source(String str) {
            this.jsonValue = str;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Source$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Source;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Source fromJson(String str) {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                for (Source source : Source.values()) {
                    if (Intrinsics.areEqual((Object) source.jsonValue, (Object) str)) {
                        return source;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Handling;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "HANDLED", "UNHANDLED", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public enum Handling {
        HANDLED("handled"),
        UNHANDLED("unhandled");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String jsonValue;

        @JvmStatic
        public static final Handling fromJson(String str) {
            return Companion.fromJson(str);
        }

        private Handling(String str) {
            this.jsonValue = str;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Handling$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Handling;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Handling fromJson(String str) {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                for (Handling handling : Handling.values()) {
                    if (Intrinsics.areEqual((Object) handling.jsonValue, (Object) str)) {
                        return handling;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$SourceType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "ANDROID", "BROWSER", "IOS", "REACT_NATIVE", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public enum SourceType {
        ANDROID("android"),
        BROWSER("browser"),
        IOS("ios"),
        REACT_NATIVE("react-native");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String jsonValue;

        @JvmStatic
        public static final SourceType fromJson(String str) {
            return Companion.fromJson(str);
        }

        private SourceType(String str) {
            this.jsonValue = str;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$SourceType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$SourceType;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final SourceType fromJson(String str) {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                for (SourceType sourceType : SourceType.values()) {
                    if (Intrinsics.areEqual((Object) sourceType.jsonValue, (Object) str)) {
                        return sourceType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Plan;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/Number;)V", "toJson", "Lcom/google/gson/JsonElement;", "PLAN_1", "PLAN_2", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public enum Plan {
        PLAN_1((Number) 1),
        PLAN_2((Number) 2);
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final Number jsonValue;

        @JvmStatic
        public static final Plan fromJson(String str) {
            return Companion.fromJson(str);
        }

        private Plan(Number number) {
            this.jsonValue = number;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Plan$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Plan;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Plan fromJson(String str) {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                for (Plan plan : Plan.values()) {
                    if (Intrinsics.areEqual((Object) plan.jsonValue.toString(), (Object) str)) {
                        return plan;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Method;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "POST", "GET", "HEAD", "PUT", "DELETE", "PATCH", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public enum Method {
        POST("POST"),
        GET("GET"),
        HEAD(AsyncHttpHead.METHOD),
        PUT("PUT"),
        DELETE(AsyncHttpDelete.METHOD),
        PATCH("PATCH");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String jsonValue;

        @JvmStatic
        public static final Method fromJson(String str) {
            return Companion.fromJson(str);
        }

        private Method(String str) {
            this.jsonValue = str;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$Method$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$Method;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Method fromJson(String str) {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                for (Method method : Method.values()) {
                    if (Intrinsics.areEqual((Object) method.jsonValue, (Object) str)) {
                        return method;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$ProviderType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "AD", "ADVERTISING", "ANALYTICS", "CDN", "CONTENT", "CUSTOMER_SUCCESS", "FIRST_PARTY", "HOSTING", "MARKETING", "OTHER", "SOCIAL", "TAG_MANAGER", "UTILITY", "VIDEO", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ErrorEvent.kt */
    public enum ProviderType {
        AD(AdDbHelper.DB_NAME),
        ADVERTISING("advertising"),
        ANALYTICS("analytics"),
        CDN(ScreenAdNewModel.ScreenAdNewColumn.CDN),
        CONTENT("content"),
        CUSTOMER_SUCCESS("customer-success"),
        FIRST_PARTY("first party"),
        HOSTING("hosting"),
        MARKETING("marketing"),
        OTHER("other"),
        SOCIAL("social"),
        TAG_MANAGER("tag-manager"),
        UTILITY("utility"),
        VIDEO("video");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String jsonValue;

        @JvmStatic
        public static final ProviderType fromJson(String str) {
            return Companion.fromJson(str);
        }

        private ProviderType(String str) {
            this.jsonValue = str;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/model/ErrorEvent$ProviderType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ErrorEvent$ProviderType;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ErrorEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ProviderType fromJson(String str) {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                for (ProviderType providerType : ProviderType.values()) {
                    if (Intrinsics.areEqual((Object) providerType.jsonValue, (Object) str)) {
                        return providerType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }
}
