package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 @2\u00020\u0001:\u0001@Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0010HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00105\u001a\u00020\tHÆ\u0003J\t\u00106\u001a\u00020\u000bHÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jy\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020\u000bHÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u001b\"\u0004\b\u001e\u0010\u001dR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0015R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015¨\u0006A"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "title", "", "statusDesc", "bgColor", "tabId", "recId", "opacity", "", "index", "", "isSelect", "countDown", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CountDownEntity;", "localDeadLine", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FIILcom/didi/soda/customer/foundation/rpc/entity/topgun/CountDownEntity;J)V", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "getCountDown", "()Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CountDownEntity;", "setCountDown", "(Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CountDownEntity;)V", "getIndex", "()I", "setIndex", "(I)V", "setSelect", "getLocalDeadLine", "()J", "setLocalDeadLine", "(J)V", "getOpacity", "()F", "setOpacity", "(F)V", "getRecId", "setRecId", "getStatusDesc", "setStatusDesc", "getTabId", "setTabId", "getTitle", "setTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TabInfoEntity.kt */
public final class TabInfoEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -5314081396812318105L;
    private String bgColor;
    private CountDownEntity countDown;
    private int index;
    private int isSelect;
    private long localDeadLine;
    private float opacity;
    private String recId;
    private String statusDesc;
    private String tabId;
    private String title;

    public static /* synthetic */ TabInfoEntity copy$default(TabInfoEntity tabInfoEntity, String str, String str2, String str3, String str4, String str5, float f, int i, int i2, CountDownEntity countDownEntity, long j, int i3, Object obj) {
        TabInfoEntity tabInfoEntity2 = tabInfoEntity;
        int i4 = i3;
        return tabInfoEntity.copy((i4 & 1) != 0 ? tabInfoEntity2.title : str, (i4 & 2) != 0 ? tabInfoEntity2.statusDesc : str2, (i4 & 4) != 0 ? tabInfoEntity2.bgColor : str3, (i4 & 8) != 0 ? tabInfoEntity2.tabId : str4, (i4 & 16) != 0 ? tabInfoEntity2.recId : str5, (i4 & 32) != 0 ? tabInfoEntity2.opacity : f, (i4 & 64) != 0 ? tabInfoEntity2.index : i, (i4 & 128) != 0 ? tabInfoEntity2.isSelect : i2, (i4 & 256) != 0 ? tabInfoEntity2.countDown : countDownEntity, (i4 & 512) != 0 ? tabInfoEntity2.localDeadLine : j);
    }

    public final String component1() {
        return this.title;
    }

    public final long component10() {
        return this.localDeadLine;
    }

    public final String component2() {
        return this.statusDesc;
    }

    public final String component3() {
        return this.bgColor;
    }

    public final String component4() {
        return this.tabId;
    }

    public final String component5() {
        return this.recId;
    }

    public final float component6() {
        return this.opacity;
    }

    public final int component7() {
        return this.index;
    }

    public final int component8() {
        return this.isSelect;
    }

    public final CountDownEntity component9() {
        return this.countDown;
    }

    public final TabInfoEntity copy(String str, String str2, String str3, String str4, String str5, float f, int i, int i2, CountDownEntity countDownEntity, long j) {
        return new TabInfoEntity(str, str2, str3, str4, str5, f, i, i2, countDownEntity, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabInfoEntity)) {
            return false;
        }
        TabInfoEntity tabInfoEntity = (TabInfoEntity) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) tabInfoEntity.title) && Intrinsics.areEqual((Object) this.statusDesc, (Object) tabInfoEntity.statusDesc) && Intrinsics.areEqual((Object) this.bgColor, (Object) tabInfoEntity.bgColor) && Intrinsics.areEqual((Object) this.tabId, (Object) tabInfoEntity.tabId) && Intrinsics.areEqual((Object) this.recId, (Object) tabInfoEntity.recId) && Intrinsics.areEqual((Object) Float.valueOf(this.opacity), (Object) Float.valueOf(tabInfoEntity.opacity)) && this.index == tabInfoEntity.index && this.isSelect == tabInfoEntity.isSelect && Intrinsics.areEqual((Object) this.countDown, (Object) tabInfoEntity.countDown) && this.localDeadLine == tabInfoEntity.localDeadLine;
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.statusDesc;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.bgColor;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.tabId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.recId;
        int hashCode5 = (((((((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + Float.floatToIntBits(this.opacity)) * 31) + this.index) * 31) + this.isSelect) * 31;
        CountDownEntity countDownEntity = this.countDown;
        if (countDownEntity != null) {
            i = countDownEntity.hashCode();
        }
        return ((hashCode5 + i) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.localDeadLine);
    }

    public String toString() {
        return "TabInfoEntity(title=" + this.title + ", statusDesc=" + this.statusDesc + ", bgColor=" + this.bgColor + ", tabId=" + this.tabId + ", recId=" + this.recId + ", opacity=" + this.opacity + ", index=" + this.index + ", isSelect=" + this.isSelect + ", countDown=" + this.countDown + ", localDeadLine=" + this.localDeadLine + VersionRange.RIGHT_OPEN;
    }

    public TabInfoEntity(String str, String str2, String str3, String str4, String str5, float f, int i, int i2, CountDownEntity countDownEntity, long j) {
        this.title = str;
        this.statusDesc = str2;
        this.bgColor = str3;
        this.tabId = str4;
        this.recId = str5;
        this.opacity = f;
        this.index = i;
        this.isSelect = i2;
        this.countDown = countDownEntity;
        this.localDeadLine = j;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TabInfoEntity(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, float r21, int r22, int r23, com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity r24, long r25, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r15 = this;
            r0 = r27
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r4 = r2
            goto L_0x000c
        L_0x000a:
            r4 = r16
        L_0x000c:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0012
            r5 = r2
            goto L_0x0014
        L_0x0012:
            r5 = r17
        L_0x0014:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x001a
            r6 = r2
            goto L_0x001c
        L_0x001a:
            r6 = r18
        L_0x001c:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0022
            r7 = r2
            goto L_0x0024
        L_0x0022:
            r7 = r19
        L_0x0024:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x002a
            r8 = r2
            goto L_0x002c
        L_0x002a:
            r8 = r20
        L_0x002c:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0035
            r1 = 1065353216(0x3f800000, float:1.0)
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0037
        L_0x0035:
            r9 = r21
        L_0x0037:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x003e
            r1 = 0
            r11 = 0
            goto L_0x0040
        L_0x003e:
            r11 = r23
        L_0x0040:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0047
            r1 = 0
            r12 = r1
            goto L_0x0049
        L_0x0047:
            r12 = r24
        L_0x0049:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0051
            r0 = 0
            r13 = r0
            goto L_0x0053
        L_0x0051:
            r13 = r25
        L_0x0053:
            r3 = r15
            r10 = r22
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, float, int, int, com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getStatusDesc() {
        return this.statusDesc;
    }

    public final void setStatusDesc(String str) {
        this.statusDesc = str;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(String str) {
        this.bgColor = str;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final void setTabId(String str) {
        this.tabId = str;
    }

    public final String getRecId() {
        return this.recId;
    }

    public final void setRecId(String str) {
        this.recId = str;
    }

    public final float getOpacity() {
        return this.opacity;
    }

    public final void setOpacity(float f) {
        this.opacity = f;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final int isSelect() {
        return this.isSelect;
    }

    public final void setSelect(int i) {
        this.isSelect = i;
    }

    public final CountDownEntity getCountDown() {
        return this.countDown;
    }

    public final void setCountDown(CountDownEntity countDownEntity) {
        this.countDown = countDownEntity;
    }

    public final long getLocalDeadLine() {
        return this.localDeadLine;
    }

    public final void setLocalDeadLine(long j) {
        this.localDeadLine = j;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TabInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
