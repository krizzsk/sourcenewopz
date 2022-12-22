package com.didi.component.framework.pages.promo.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B_\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006'"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/model/PromoShareInfo;", "", "channel", "", "channelSort", "name", "shareSubTitle", "shareIcon", "shareTitle", "shareUrl", "shareHeadImg", "shareUrlOrigin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannel", "()Ljava/lang/String;", "getChannelSort", "getName", "getShareHeadImg", "getShareIcon", "getShareSubTitle", "getShareTitle", "getShareUrl", "getShareUrlOrigin", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PromoResponse.kt */
public final class PromoShareInfo {
    private final String channel;
    private final String channelSort;
    private final String name;
    private final String shareHeadImg;
    private final String shareIcon;
    private final String shareSubTitle;
    private final String shareTitle;
    private final String shareUrl;
    private final String shareUrlOrigin;

    public static /* synthetic */ PromoShareInfo copy$default(PromoShareInfo promoShareInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        PromoShareInfo promoShareInfo2 = promoShareInfo;
        int i2 = i;
        return promoShareInfo.copy((i2 & 1) != 0 ? promoShareInfo2.channel : str, (i2 & 2) != 0 ? promoShareInfo2.channelSort : str2, (i2 & 4) != 0 ? promoShareInfo2.name : str3, (i2 & 8) != 0 ? promoShareInfo2.shareSubTitle : str4, (i2 & 16) != 0 ? promoShareInfo2.shareIcon : str5, (i2 & 32) != 0 ? promoShareInfo2.shareTitle : str6, (i2 & 64) != 0 ? promoShareInfo2.shareUrl : str7, (i2 & 128) != 0 ? promoShareInfo2.shareHeadImg : str8, (i2 & 256) != 0 ? promoShareInfo2.shareUrlOrigin : str9);
    }

    public final String component1() {
        return this.channel;
    }

    public final String component2() {
        return this.channelSort;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.shareSubTitle;
    }

    public final String component5() {
        return this.shareIcon;
    }

    public final String component6() {
        return this.shareTitle;
    }

    public final String component7() {
        return this.shareUrl;
    }

    public final String component8() {
        return this.shareHeadImg;
    }

    public final String component9() {
        return this.shareUrlOrigin;
    }

    public final PromoShareInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return new PromoShareInfo(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PromoShareInfo)) {
            return false;
        }
        PromoShareInfo promoShareInfo = (PromoShareInfo) obj;
        return Intrinsics.areEqual((Object) this.channel, (Object) promoShareInfo.channel) && Intrinsics.areEqual((Object) this.channelSort, (Object) promoShareInfo.channelSort) && Intrinsics.areEqual((Object) this.name, (Object) promoShareInfo.name) && Intrinsics.areEqual((Object) this.shareSubTitle, (Object) promoShareInfo.shareSubTitle) && Intrinsics.areEqual((Object) this.shareIcon, (Object) promoShareInfo.shareIcon) && Intrinsics.areEqual((Object) this.shareTitle, (Object) promoShareInfo.shareTitle) && Intrinsics.areEqual((Object) this.shareUrl, (Object) promoShareInfo.shareUrl) && Intrinsics.areEqual((Object) this.shareHeadImg, (Object) promoShareInfo.shareHeadImg) && Intrinsics.areEqual((Object) this.shareUrlOrigin, (Object) promoShareInfo.shareUrlOrigin);
    }

    public int hashCode() {
        String str = this.channel;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.channelSort;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.shareSubTitle;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.shareIcon;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.shareTitle;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.shareUrl;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.shareHeadImg;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.shareUrlOrigin;
        if (str9 != null) {
            i = str9.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "PromoShareInfo(channel=" + this.channel + ", channelSort=" + this.channelSort + ", name=" + this.name + ", shareSubTitle=" + this.shareSubTitle + ", shareIcon=" + this.shareIcon + ", shareTitle=" + this.shareTitle + ", shareUrl=" + this.shareUrl + ", shareHeadImg=" + this.shareHeadImg + ", shareUrlOrigin=" + this.shareUrlOrigin + VersionRange.RIGHT_OPEN;
    }

    public PromoShareInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.channel = str;
        this.channelSort = str2;
        this.name = str3;
        this.shareSubTitle = str4;
        this.shareIcon = str5;
        this.shareTitle = str6;
        this.shareUrl = str7;
        this.shareHeadImg = str8;
        this.shareUrlOrigin = str9;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getChannelSort() {
        return this.channelSort;
    }

    public final String getName() {
        return this.name;
    }

    public final String getShareSubTitle() {
        return this.shareSubTitle;
    }

    public final String getShareIcon() {
        return this.shareIcon;
    }

    public final String getShareTitle() {
        return this.shareTitle;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final String getShareHeadImg() {
        return this.shareHeadImg;
    }

    public final String getShareUrlOrigin() {
        return this.shareUrlOrigin;
    }
}
