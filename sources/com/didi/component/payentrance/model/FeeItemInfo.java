package com.didi.component.payentrance.model;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\b\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\tJ\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001e\u0010\rJ\u0010\u0010\u001f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b \u0010\tR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, mo175978d2 = {"Lcom/didi/component/payentrance/model/FeeItemInfo;", "", "json", "Lorg/json/JSONObject;", "constructor-impl", "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "feeLabel", "", "getFeeLabel-impl", "(Lorg/json/JSONObject;)Ljava/lang/String;", "feeType", "", "getFeeType-impl", "(Lorg/json/JSONObject;)I", "feeValue", "getFeeValue-impl", "getJson", "()Lorg/json/JSONObject;", "component1", "component1-impl", "component2", "component2-impl", "component3", "component3-impl", "equals", "", "other", "equals-impl", "(Lorg/json/JSONObject;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "toString-impl", "comp-payentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@JvmInline
/* compiled from: FareDetailsModel.kt */
public final class FeeItemInfo {

    /* renamed from: a */
    private final JSONObject f14900a;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FeeItemInfo m46258boximpl(JSONObject jSONObject) {
        return new FeeItemInfo(jSONObject);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static JSONObject m46262constructorimpl(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        return jSONObject;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m46263equalsimpl(JSONObject jSONObject, Object obj) {
        return (obj instanceof FeeItemInfo) && Intrinsics.areEqual((Object) jSONObject, (Object) ((FeeItemInfo) obj).m46270unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m46264equalsimpl0(JSONObject jSONObject, JSONObject jSONObject2) {
        return Intrinsics.areEqual((Object) jSONObject, (Object) jSONObject2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m46268hashCodeimpl(JSONObject jSONObject) {
        return jSONObject.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m46269toStringimpl(JSONObject jSONObject) {
        return "FeeItemInfo(json=" + jSONObject + VersionRange.RIGHT_OPEN;
    }

    public boolean equals(Object obj) {
        return m46263equalsimpl(this.f14900a, obj);
    }

    public int hashCode() {
        return m46268hashCodeimpl(this.f14900a);
    }

    public String toString() {
        return m46269toStringimpl(this.f14900a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ JSONObject m46270unboximpl() {
        return this.f14900a;
    }

    private /* synthetic */ FeeItemInfo(JSONObject jSONObject) {
        this.f14900a = jSONObject;
    }

    public final JSONObject getJson() {
        return this.f14900a;
    }

    /* renamed from: getFeeType-impl  reason: not valid java name */
    public static final int m46266getFeeTypeimpl(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "arg0");
        return jSONObject.optInt("fee_type");
    }

    /* renamed from: getFeeLabel-impl  reason: not valid java name */
    public static final String m46265getFeeLabelimpl(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "arg0");
        String optString = jSONObject.optString("fee_label");
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"fee_label\")");
        return optString;
    }

    /* renamed from: getFeeValue-impl  reason: not valid java name */
    public static final String m46267getFeeValueimpl(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "arg0");
        String optString = jSONObject.optString("fee_value");
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"fee_value\")");
        return optString;
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final int m46259component1impl(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "arg0");
        return m46266getFeeTypeimpl(jSONObject);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final String m46260component2impl(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "arg0");
        return m46265getFeeLabelimpl(jSONObject);
    }

    /* renamed from: component3-impl  reason: not valid java name */
    public static final String m46261component3impl(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "arg0");
        return m46267getFeeValueimpl(jSONObject);
    }
}
