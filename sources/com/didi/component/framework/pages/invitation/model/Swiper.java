package com.didi.component.framework.pages.invitation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/Swiper;", "", "swiperCard", "", "swiperContent", "swiperTitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSwiperCard", "()Ljava/lang/String;", "setSwiperCard", "(Ljava/lang/String;)V", "getSwiperContent", "setSwiperContent", "getSwiperTitle", "setSwiperTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InviteTheme.kt */
public final class Swiper {
    private String swiperCard;
    private String swiperContent;
    private String swiperTitle;

    public static /* synthetic */ Swiper copy$default(Swiper swiper, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = swiper.swiperCard;
        }
        if ((i & 2) != 0) {
            str2 = swiper.swiperContent;
        }
        if ((i & 4) != 0) {
            str3 = swiper.swiperTitle;
        }
        return swiper.copy(str, str2, str3);
    }

    public final String component1() {
        return this.swiperCard;
    }

    public final String component2() {
        return this.swiperContent;
    }

    public final String component3() {
        return this.swiperTitle;
    }

    public final Swiper copy(String str, String str2, String str3) {
        return new Swiper(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Swiper)) {
            return false;
        }
        Swiper swiper = (Swiper) obj;
        return Intrinsics.areEqual((Object) this.swiperCard, (Object) swiper.swiperCard) && Intrinsics.areEqual((Object) this.swiperContent, (Object) swiper.swiperContent) && Intrinsics.areEqual((Object) this.swiperTitle, (Object) swiper.swiperTitle);
    }

    public int hashCode() {
        String str = this.swiperCard;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.swiperContent;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.swiperTitle;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Swiper(swiperCard=" + this.swiperCard + ", swiperContent=" + this.swiperContent + ", swiperTitle=" + this.swiperTitle + VersionRange.RIGHT_OPEN;
    }

    public Swiper(String str, String str2, String str3) {
        this.swiperCard = str;
        this.swiperContent = str2;
        this.swiperTitle = str3;
    }

    public final String getSwiperCard() {
        return this.swiperCard;
    }

    public final void setSwiperCard(String str) {
        this.swiperCard = str;
    }

    public final String getSwiperContent() {
        return this.swiperContent;
    }

    public final void setSwiperContent(String str) {
        this.swiperContent = str;
    }

    public final String getSwiperTitle() {
        return this.swiperTitle;
    }

    public final void setSwiperTitle(String str) {
        this.swiperTitle = str;
    }
}
