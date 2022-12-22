package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 A2\u00020\u0001:\u0001AB\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t¢\u0006\u0002\u0010\u0011J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020\rHÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015¨\u0006B"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/HomeEfoInfoEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "title", "", "url", "clickMore", "Lcom/didi/soda/customer/foundation/rpc/entity/HomeEfoMoreEntity;", "bevelColor", "bgColor", "", "rightPic", "recId", "countDownSecond", "", "countDownDesc", "efoItemList", "Lcom/didi/soda/customer/foundation/rpc/entity/GoodsItemEntity;", "(Ljava/lang/String;Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/HomeEfoMoreEntity;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getBevelColor", "()Ljava/lang/String;", "setBevelColor", "(Ljava/lang/String;)V", "getBgColor", "()Ljava/util/List;", "setBgColor", "(Ljava/util/List;)V", "getClickMore", "()Lcom/didi/soda/customer/foundation/rpc/entity/HomeEfoMoreEntity;", "setClickMore", "(Lcom/didi/soda/customer/foundation/rpc/entity/HomeEfoMoreEntity;)V", "getCountDownDesc", "setCountDownDesc", "getCountDownSecond", "()Ljava/lang/Integer;", "setCountDownSecond", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEfoItemList", "setEfoItemList", "getRecId", "setRecId", "getRightPic", "setRightPic", "getTitle", "setTitle", "getUrl", "setUrl", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/HomeEfoMoreEntity;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/didi/soda/customer/foundation/rpc/entity/HomeEfoInfoEntity;", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeEfoInfoEntity.kt */
public final class HomeEfoInfoEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -8355351095907035352L;
    private String bevelColor;
    private List<String> bgColor;
    private HomeEfoMoreEntity clickMore;
    private String countDownDesc;
    private Integer countDownSecond;
    private List<? extends GoodsItemEntity> efoItemList;
    private String recId;
    private String rightPic;
    private String title;
    private String url;

    public HomeEfoInfoEntity() {
        this((String) null, (String) null, (HomeEfoMoreEntity) null, (String) null, (List) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, 1023, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HomeEfoInfoEntity copy$default(HomeEfoInfoEntity homeEfoInfoEntity, String str, String str2, HomeEfoMoreEntity homeEfoMoreEntity, String str3, List list, String str4, String str5, Integer num, String str6, List list2, int i, Object obj) {
        HomeEfoInfoEntity homeEfoInfoEntity2 = homeEfoInfoEntity;
        int i2 = i;
        return homeEfoInfoEntity.copy((i2 & 1) != 0 ? homeEfoInfoEntity2.title : str, (i2 & 2) != 0 ? homeEfoInfoEntity2.url : str2, (i2 & 4) != 0 ? homeEfoInfoEntity2.clickMore : homeEfoMoreEntity, (i2 & 8) != 0 ? homeEfoInfoEntity2.bevelColor : str3, (i2 & 16) != 0 ? homeEfoInfoEntity2.bgColor : list, (i2 & 32) != 0 ? homeEfoInfoEntity2.rightPic : str4, (i2 & 64) != 0 ? homeEfoInfoEntity2.recId : str5, (i2 & 128) != 0 ? homeEfoInfoEntity2.countDownSecond : num, (i2 & 256) != 0 ? homeEfoInfoEntity2.countDownDesc : str6, (i2 & 512) != 0 ? homeEfoInfoEntity2.efoItemList : list2);
    }

    public final String component1() {
        return this.title;
    }

    public final List<GoodsItemEntity> component10() {
        return this.efoItemList;
    }

    public final String component2() {
        return this.url;
    }

    public final HomeEfoMoreEntity component3() {
        return this.clickMore;
    }

    public final String component4() {
        return this.bevelColor;
    }

    public final List<String> component5() {
        return this.bgColor;
    }

    public final String component6() {
        return this.rightPic;
    }

    public final String component7() {
        return this.recId;
    }

    public final Integer component8() {
        return this.countDownSecond;
    }

    public final String component9() {
        return this.countDownDesc;
    }

    public final HomeEfoInfoEntity copy(String str, String str2, HomeEfoMoreEntity homeEfoMoreEntity, String str3, List<String> list, String str4, String str5, Integer num, String str6, List<? extends GoodsItemEntity> list2) {
        return new HomeEfoInfoEntity(str, str2, homeEfoMoreEntity, str3, list, str4, str5, num, str6, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeEfoInfoEntity)) {
            return false;
        }
        HomeEfoInfoEntity homeEfoInfoEntity = (HomeEfoInfoEntity) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) homeEfoInfoEntity.title) && Intrinsics.areEqual((Object) this.url, (Object) homeEfoInfoEntity.url) && Intrinsics.areEqual((Object) this.clickMore, (Object) homeEfoInfoEntity.clickMore) && Intrinsics.areEqual((Object) this.bevelColor, (Object) homeEfoInfoEntity.bevelColor) && Intrinsics.areEqual((Object) this.bgColor, (Object) homeEfoInfoEntity.bgColor) && Intrinsics.areEqual((Object) this.rightPic, (Object) homeEfoInfoEntity.rightPic) && Intrinsics.areEqual((Object) this.recId, (Object) homeEfoInfoEntity.recId) && Intrinsics.areEqual((Object) this.countDownSecond, (Object) homeEfoInfoEntity.countDownSecond) && Intrinsics.areEqual((Object) this.countDownDesc, (Object) homeEfoInfoEntity.countDownDesc) && Intrinsics.areEqual((Object) this.efoItemList, (Object) homeEfoInfoEntity.efoItemList);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        HomeEfoMoreEntity homeEfoMoreEntity = this.clickMore;
        int hashCode3 = (hashCode2 + (homeEfoMoreEntity == null ? 0 : homeEfoMoreEntity.hashCode())) * 31;
        String str3 = this.bevelColor;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list = this.bgColor;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.rightPic;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.recId;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.countDownSecond;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        String str6 = this.countDownDesc;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<? extends GoodsItemEntity> list2 = this.efoItemList;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "HomeEfoInfoEntity(title=" + this.title + ", url=" + this.url + ", clickMore=" + this.clickMore + ", bevelColor=" + this.bevelColor + ", bgColor=" + this.bgColor + ", rightPic=" + this.rightPic + ", recId=" + this.recId + ", countDownSecond=" + this.countDownSecond + ", countDownDesc=" + this.countDownDesc + ", efoItemList=" + this.efoItemList + VersionRange.RIGHT_OPEN;
    }

    public HomeEfoInfoEntity(String str, String str2, HomeEfoMoreEntity homeEfoMoreEntity, String str3, List<String> list, String str4, String str5, Integer num, String str6, List<? extends GoodsItemEntity> list2) {
        this.title = str;
        this.url = str2;
        this.clickMore = homeEfoMoreEntity;
        this.bevelColor = str3;
        this.bgColor = list;
        this.rightPic = str4;
        this.recId = str5;
        this.countDownSecond = num;
        this.countDownDesc = str6;
        this.efoItemList = list2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final HomeEfoMoreEntity getClickMore() {
        return this.clickMore;
    }

    public final void setClickMore(HomeEfoMoreEntity homeEfoMoreEntity) {
        this.clickMore = homeEfoMoreEntity;
    }

    public final String getBevelColor() {
        return this.bevelColor;
    }

    public final void setBevelColor(String str) {
        this.bevelColor = str;
    }

    public final List<String> getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(List<String> list) {
        this.bgColor = list;
    }

    public final String getRightPic() {
        return this.rightPic;
    }

    public final void setRightPic(String str) {
        this.rightPic = str;
    }

    public final String getRecId() {
        return this.recId;
    }

    public final void setRecId(String str) {
        this.recId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HomeEfoInfoEntity(java.lang.String r12, java.lang.String r13, com.didi.soda.customer.foundation.rpc.entity.HomeEfoMoreEntity r14, java.lang.String r15, java.util.List r16, java.lang.String r17, java.lang.String r18, java.lang.Integer r19, java.lang.String r20, java.util.List r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r14
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r15
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0027
        L_0x0025:
            r6 = r16
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r2
            goto L_0x002f
        L_0x002d:
            r7 = r17
        L_0x002f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0035
            r8 = r2
            goto L_0x0037
        L_0x0035:
            r8 = r18
        L_0x0037:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L_0x0043
        L_0x0041:
            r9 = r19
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r20
        L_0x004b:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r2 = r21
        L_0x0052:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.HomeEfoInfoEntity.<init>(java.lang.String, java.lang.String, com.didi.soda.customer.foundation.rpc.entity.HomeEfoMoreEntity, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getCountDownSecond() {
        return this.countDownSecond;
    }

    public final void setCountDownSecond(Integer num) {
        this.countDownSecond = num;
    }

    public final String getCountDownDesc() {
        return this.countDownDesc;
    }

    public final void setCountDownDesc(String str) {
        this.countDownDesc = str;
    }

    public final List<GoodsItemEntity> getEfoItemList() {
        return this.efoItemList;
    }

    public final void setEfoItemList(List<? extends GoodsItemEntity> list) {
        this.efoItemList = list;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/HomeEfoInfoEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeEfoInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
