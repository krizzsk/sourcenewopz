package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 C2\u00020\u0001:\u0001CBÇ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0013\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0007HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010:\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001eJÐ\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020\u000fHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001eR\u001b\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b(\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#¨\u0006D"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderStatusServer;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "title", "", "etaTime", "content", "processBar", "", "Lcom/didi/soda/customer/foundation/rpc/entity/ProcessBar;", "etaOriginTime", "wordChain", "Lcom/didi/soda/customer/foundation/rpc/entity/WordChain;", "serverSubject", "Lcom/didi/soda/customer/foundation/rpc/entity/ServerSubject;", "scene", "", "showCouponIcon", "etaFactors", "supplements", "etaType", "latestEtaWordChain", "latestEtaBuriedPoint", "laterSceneBuriedPoint", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/WordChain;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/didi/soda/customer/foundation/rpc/entity/WordChain;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getEtaFactors", "getEtaOriginTime", "getEtaTime", "getEtaType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLaterSceneBuriedPoint", "getLatestEtaBuriedPoint", "getLatestEtaWordChain", "()Lcom/didi/soda/customer/foundation/rpc/entity/WordChain;", "getProcessBar", "()Ljava/util/List;", "getScene", "getServerSubject", "getShowCouponIcon", "getSupplements", "getTitle", "getWordChain", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/WordChain;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/didi/soda/customer/foundation/rpc/entity/WordChain;Ljava/lang/String;Ljava/lang/String;)Lcom/didi/soda/customer/foundation/rpc/entity/OrderStatusServer;", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class OrderStatusServer implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -4780776892588864891L;
    private final String content;
    private final String etaFactors;
    private final String etaOriginTime;
    private final String etaTime;
    private final Integer etaType;
    private final String laterSceneBuriedPoint;
    private final String latestEtaBuriedPoint;
    private final WordChain latestEtaWordChain;
    private final List<ProcessBar> processBar;
    private final Integer scene;
    private final List<ServerSubject> serverSubject;
    private final Integer showCouponIcon;
    private final String supplements;
    private final String title;
    private final WordChain wordChain;

    public OrderStatusServer() {
        this((String) null, (String) null, (String) null, (List) null, (String) null, (WordChain) null, (List) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (WordChain) null, (String) null, (String) null, 32767, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderStatusServer copy$default(OrderStatusServer orderStatusServer, String str, String str2, String str3, List list, String str4, WordChain wordChain2, List list2, Integer num, Integer num2, String str5, String str6, Integer num3, WordChain wordChain3, String str7, String str8, int i, Object obj) {
        OrderStatusServer orderStatusServer2 = orderStatusServer;
        int i2 = i;
        return orderStatusServer.copy((i2 & 1) != 0 ? orderStatusServer2.title : str, (i2 & 2) != 0 ? orderStatusServer2.etaTime : str2, (i2 & 4) != 0 ? orderStatusServer2.content : str3, (i2 & 8) != 0 ? orderStatusServer2.processBar : list, (i2 & 16) != 0 ? orderStatusServer2.etaOriginTime : str4, (i2 & 32) != 0 ? orderStatusServer2.wordChain : wordChain2, (i2 & 64) != 0 ? orderStatusServer2.serverSubject : list2, (i2 & 128) != 0 ? orderStatusServer2.scene : num, (i2 & 256) != 0 ? orderStatusServer2.showCouponIcon : num2, (i2 & 512) != 0 ? orderStatusServer2.etaFactors : str5, (i2 & 1024) != 0 ? orderStatusServer2.supplements : str6, (i2 & 2048) != 0 ? orderStatusServer2.etaType : num3, (i2 & 4096) != 0 ? orderStatusServer2.latestEtaWordChain : wordChain3, (i2 & 8192) != 0 ? orderStatusServer2.latestEtaBuriedPoint : str7, (i2 & 16384) != 0 ? orderStatusServer2.laterSceneBuriedPoint : str8);
    }

    public final String component1() {
        return this.title;
    }

    public final String component10() {
        return this.etaFactors;
    }

    public final String component11() {
        return this.supplements;
    }

    public final Integer component12() {
        return this.etaType;
    }

    public final WordChain component13() {
        return this.latestEtaWordChain;
    }

    public final String component14() {
        return this.latestEtaBuriedPoint;
    }

    public final String component15() {
        return this.laterSceneBuriedPoint;
    }

    public final String component2() {
        return this.etaTime;
    }

    public final String component3() {
        return this.content;
    }

    public final List<ProcessBar> component4() {
        return this.processBar;
    }

    public final String component5() {
        return this.etaOriginTime;
    }

    public final WordChain component6() {
        return this.wordChain;
    }

    public final List<ServerSubject> component7() {
        return this.serverSubject;
    }

    public final Integer component8() {
        return this.scene;
    }

    public final Integer component9() {
        return this.showCouponIcon;
    }

    public final OrderStatusServer copy(String str, String str2, String str3, List<ProcessBar> list, String str4, WordChain wordChain2, List<ServerSubject> list2, Integer num, Integer num2, String str5, String str6, Integer num3, WordChain wordChain3, String str7, String str8) {
        return new OrderStatusServer(str, str2, str3, list, str4, wordChain2, list2, num, num2, str5, str6, num3, wordChain3, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderStatusServer)) {
            return false;
        }
        OrderStatusServer orderStatusServer = (OrderStatusServer) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) orderStatusServer.title) && Intrinsics.areEqual((Object) this.etaTime, (Object) orderStatusServer.etaTime) && Intrinsics.areEqual((Object) this.content, (Object) orderStatusServer.content) && Intrinsics.areEqual((Object) this.processBar, (Object) orderStatusServer.processBar) && Intrinsics.areEqual((Object) this.etaOriginTime, (Object) orderStatusServer.etaOriginTime) && Intrinsics.areEqual((Object) this.wordChain, (Object) orderStatusServer.wordChain) && Intrinsics.areEqual((Object) this.serverSubject, (Object) orderStatusServer.serverSubject) && Intrinsics.areEqual((Object) this.scene, (Object) orderStatusServer.scene) && Intrinsics.areEqual((Object) this.showCouponIcon, (Object) orderStatusServer.showCouponIcon) && Intrinsics.areEqual((Object) this.etaFactors, (Object) orderStatusServer.etaFactors) && Intrinsics.areEqual((Object) this.supplements, (Object) orderStatusServer.supplements) && Intrinsics.areEqual((Object) this.etaType, (Object) orderStatusServer.etaType) && Intrinsics.areEqual((Object) this.latestEtaWordChain, (Object) orderStatusServer.latestEtaWordChain) && Intrinsics.areEqual((Object) this.latestEtaBuriedPoint, (Object) orderStatusServer.latestEtaBuriedPoint) && Intrinsics.areEqual((Object) this.laterSceneBuriedPoint, (Object) orderStatusServer.laterSceneBuriedPoint);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.etaTime;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.content;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<ProcessBar> list = this.processBar;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.etaOriginTime;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        WordChain wordChain2 = this.wordChain;
        int hashCode6 = (hashCode5 + (wordChain2 == null ? 0 : wordChain2.hashCode())) * 31;
        List<ServerSubject> list2 = this.serverSubject;
        int hashCode7 = (hashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num = this.scene;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.showCouponIcon;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.etaFactors;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.supplements;
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num3 = this.etaType;
        int hashCode12 = (hashCode11 + (num3 == null ? 0 : num3.hashCode())) * 31;
        WordChain wordChain3 = this.latestEtaWordChain;
        int hashCode13 = (hashCode12 + (wordChain3 == null ? 0 : wordChain3.hashCode())) * 31;
        String str7 = this.latestEtaBuriedPoint;
        int hashCode14 = (hashCode13 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.laterSceneBuriedPoint;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode14 + i;
    }

    public String toString() {
        return "OrderStatusServer(title=" + this.title + ", etaTime=" + this.etaTime + ", content=" + this.content + ", processBar=" + this.processBar + ", etaOriginTime=" + this.etaOriginTime + ", wordChain=" + this.wordChain + ", serverSubject=" + this.serverSubject + ", scene=" + this.scene + ", showCouponIcon=" + this.showCouponIcon + ", etaFactors=" + this.etaFactors + ", supplements=" + this.supplements + ", etaType=" + this.etaType + ", latestEtaWordChain=" + this.latestEtaWordChain + ", latestEtaBuriedPoint=" + this.latestEtaBuriedPoint + ", laterSceneBuriedPoint=" + this.laterSceneBuriedPoint + VersionRange.RIGHT_OPEN;
    }

    public OrderStatusServer(String str, String str2, String str3, List<ProcessBar> list, String str4, WordChain wordChain2, List<ServerSubject> list2, Integer num, Integer num2, String str5, String str6, Integer num3, WordChain wordChain3, String str7, String str8) {
        this.title = str;
        this.etaTime = str2;
        this.content = str3;
        this.processBar = list;
        this.etaOriginTime = str4;
        this.wordChain = wordChain2;
        this.serverSubject = list2;
        this.scene = num;
        this.showCouponIcon = num2;
        this.etaFactors = str5;
        this.supplements = str6;
        this.etaType = num3;
        this.latestEtaWordChain = wordChain3;
        this.latestEtaBuriedPoint = str7;
        this.laterSceneBuriedPoint = str8;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getEtaTime() {
        return this.etaTime;
    }

    public final String getContent() {
        return this.content;
    }

    public final List<ProcessBar> getProcessBar() {
        return this.processBar;
    }

    public final String getEtaOriginTime() {
        return this.etaOriginTime;
    }

    public final WordChain getWordChain() {
        return this.wordChain;
    }

    public final List<ServerSubject> getServerSubject() {
        return this.serverSubject;
    }

    public final Integer getScene() {
        return this.scene;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderStatusServer(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.util.List r20, java.lang.String r21, com.didi.soda.customer.foundation.rpc.entity.WordChain r22, java.util.List r23, java.lang.Integer r24, java.lang.Integer r25, java.lang.String r26, java.lang.String r27, java.lang.Integer r28, com.didi.soda.customer.foundation.rpc.entity.WordChain r29, java.lang.String r30, java.lang.String r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r18
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r19
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r20
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r21
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r22
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r23
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r24
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            r11 = 0
            if (r10 == 0) goto L_0x004d
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            goto L_0x004f
        L_0x004d:
            r10 = r25
        L_0x004f:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0055
            r12 = r2
            goto L_0x0057
        L_0x0055:
            r12 = r26
        L_0x0057:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005d
            r13 = r2
            goto L_0x005f
        L_0x005d:
            r13 = r27
        L_0x005f:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0068
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            goto L_0x006a
        L_0x0068:
            r11 = r28
        L_0x006a:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0070
            r14 = r2
            goto L_0x0072
        L_0x0070:
            r14 = r29
        L_0x0072:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0078
            r15 = r2
            goto L_0x007a
        L_0x0078:
            r15 = r30
        L_0x007a:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x007f
            goto L_0x0081
        L_0x007f:
            r2 = r31
        L_0x0081:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r12
            r28 = r13
            r29 = r11
            r30 = r14
            r31 = r15
            r32 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.OrderStatusServer.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, com.didi.soda.customer.foundation.rpc.entity.WordChain, java.util.List, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, com.didi.soda.customer.foundation.rpc.entity.WordChain, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getShowCouponIcon() {
        return this.showCouponIcon;
    }

    public final String getEtaFactors() {
        return this.etaFactors;
    }

    public final String getSupplements() {
        return this.supplements;
    }

    public final Integer getEtaType() {
        return this.etaType;
    }

    public final WordChain getLatestEtaWordChain() {
        return this.latestEtaWordChain;
    }

    public final String getLatestEtaBuriedPoint() {
        return this.latestEtaBuriedPoint;
    }

    public final String getLaterSceneBuriedPoint() {
        return this.laterSceneBuriedPoint;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderStatusServer$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
