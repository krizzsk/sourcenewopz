package com.didi.entrega.info.model;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.app.constant.Const;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\u0002\u0010\rJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J%\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b`\fHÆ\u0003Ja\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b`\fHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010*\u001a\u00020\u0006HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R6\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011¨\u0006,"}, mo175978d2 = {"Lcom/didi/entrega/info/model/OmegaCommonModel;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "poiId", "", "cityId", "fromPage", "", "pageSource", "eventSource", "extentionMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Ljava/lang/String;IIILjava/util/HashMap;)V", "getCityId", "()Ljava/lang/String;", "setCityId", "(Ljava/lang/String;)V", "getEventSource", "()I", "setEventSource", "(I)V", "getExtentionMap", "()Ljava/util/HashMap;", "setExtentionMap", "(Ljava/util/HashMap;)V", "getFromPage", "setFromPage", "getPageSource", "setPageSource", "getPoiId", "setPoiId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OmegaCommonModel.kt */
public final class OmegaCommonModel implements IEntity {
    private String cityId;
    private int eventSource;
    private HashMap<String, Object> extentionMap;
    private int fromPage;
    private int pageSource;
    private String poiId;

    public OmegaCommonModel() {
        this((String) null, (String) null, 0, 0, 0, (HashMap) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OmegaCommonModel copy$default(OmegaCommonModel omegaCommonModel, String str, String str2, int i, int i2, int i3, HashMap<String, Object> hashMap, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = omegaCommonModel.poiId;
        }
        if ((i4 & 2) != 0) {
            str2 = omegaCommonModel.cityId;
        }
        String str3 = str2;
        if ((i4 & 4) != 0) {
            i = omegaCommonModel.fromPage;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = omegaCommonModel.pageSource;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            i3 = omegaCommonModel.eventSource;
        }
        int i7 = i3;
        if ((i4 & 32) != 0) {
            hashMap = omegaCommonModel.extentionMap;
        }
        return omegaCommonModel.copy(str, str3, i5, i6, i7, hashMap);
    }

    public final String component1() {
        return this.poiId;
    }

    public final String component2() {
        return this.cityId;
    }

    public final int component3() {
        return this.fromPage;
    }

    public final int component4() {
        return this.pageSource;
    }

    public final int component5() {
        return this.eventSource;
    }

    public final HashMap<String, Object> component6() {
        return this.extentionMap;
    }

    public final OmegaCommonModel copy(String str, String str2, int i, int i2, int i3, HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(str, Const.H5Params.POIID);
        Intrinsics.checkNotNullParameter(str2, "cityId");
        Intrinsics.checkNotNullParameter(hashMap, "extentionMap");
        return new OmegaCommonModel(str, str2, i, i2, i3, hashMap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OmegaCommonModel)) {
            return false;
        }
        OmegaCommonModel omegaCommonModel = (OmegaCommonModel) obj;
        return Intrinsics.areEqual((Object) this.poiId, (Object) omegaCommonModel.poiId) && Intrinsics.areEqual((Object) this.cityId, (Object) omegaCommonModel.cityId) && this.fromPage == omegaCommonModel.fromPage && this.pageSource == omegaCommonModel.pageSource && this.eventSource == omegaCommonModel.eventSource && Intrinsics.areEqual((Object) this.extentionMap, (Object) omegaCommonModel.extentionMap);
    }

    public int hashCode() {
        return (((((((((this.poiId.hashCode() * 31) + this.cityId.hashCode()) * 31) + this.fromPage) * 31) + this.pageSource) * 31) + this.eventSource) * 31) + this.extentionMap.hashCode();
    }

    public String toString() {
        return "OmegaCommonModel(poiId=" + this.poiId + ", cityId=" + this.cityId + ", fromPage=" + this.fromPage + ", pageSource=" + this.pageSource + ", eventSource=" + this.eventSource + ", extentionMap=" + this.extentionMap + VersionRange.RIGHT_OPEN;
    }

    public OmegaCommonModel(String str, String str2, int i, int i2, int i3, HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(str, Const.H5Params.POIID);
        Intrinsics.checkNotNullParameter(str2, "cityId");
        Intrinsics.checkNotNullParameter(hashMap, "extentionMap");
        this.poiId = str;
        this.cityId = str2;
        this.fromPage = i;
        this.pageSource = i2;
        this.eventSource = i3;
        this.extentionMap = hashMap;
    }

    public final String getPoiId() {
        return this.poiId;
    }

    public final void setPoiId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.poiId = str;
    }

    public final String getCityId() {
        return this.cityId;
    }

    public final void setCityId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cityId = str;
    }

    public final int getFromPage() {
        return this.fromPage;
    }

    public final void setFromPage(int i) {
        this.fromPage = i;
    }

    public final int getPageSource() {
        return this.pageSource;
    }

    public final void setPageSource(int i) {
        this.pageSource = i;
    }

    public final int getEventSource() {
        return this.eventSource;
    }

    public final void setEventSource(int i) {
        this.eventSource = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OmegaCommonModel(java.lang.String r5, java.lang.String r6, int r7, int r8, int r9, java.util.HashMap r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            java.lang.String r0 = ""
            if (r12 == 0) goto L_0x0008
            r12 = r0
            goto L_0x0009
        L_0x0008:
            r12 = r5
        L_0x0009:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r0 = r6
        L_0x000f:
            r5 = r11 & 4
            r6 = 0
            if (r5 == 0) goto L_0x0016
            r1 = 0
            goto L_0x0017
        L_0x0016:
            r1 = r7
        L_0x0017:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x001d
            r2 = 0
            goto L_0x001e
        L_0x001d:
            r2 = r8
        L_0x001e:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0024
            r3 = 0
            goto L_0x0025
        L_0x0024:
            r3 = r9
        L_0x0025:
            r5 = r11 & 32
            if (r5 == 0) goto L_0x002e
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
        L_0x002e:
            r11 = r10
            r5 = r4
            r6 = r12
            r7 = r0
            r8 = r1
            r9 = r2
            r10 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.model.OmegaCommonModel.<init>(java.lang.String, java.lang.String, int, int, int, java.util.HashMap, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final HashMap<String, Object> getExtentionMap() {
        return this.extentionMap;
    }

    public final void setExtentionMap(HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.extentionMap = hashMap;
    }
}
