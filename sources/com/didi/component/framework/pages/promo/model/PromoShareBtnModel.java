package com.didi.component.framework.pages.promo.model;

import com.didi.onekeyshare.entity.OneKeyShareInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/model/PromoShareBtnModel;", "", "shareIcon", "", "shareInfo", "Lcom/didi/onekeyshare/entity/OneKeyShareInfo;", "(Ljava/lang/String;Lcom/didi/onekeyshare/entity/OneKeyShareInfo;)V", "getShareIcon", "()Ljava/lang/String;", "getShareInfo", "()Lcom/didi/onekeyshare/entity/OneKeyShareInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PromoShareBtnModel.kt */
public final class PromoShareBtnModel {
    private final String shareIcon;
    private final OneKeyShareInfo shareInfo;

    public static /* synthetic */ PromoShareBtnModel copy$default(PromoShareBtnModel promoShareBtnModel, String str, OneKeyShareInfo oneKeyShareInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = promoShareBtnModel.shareIcon;
        }
        if ((i & 2) != 0) {
            oneKeyShareInfo = promoShareBtnModel.shareInfo;
        }
        return promoShareBtnModel.copy(str, oneKeyShareInfo);
    }

    public final String component1() {
        return this.shareIcon;
    }

    public final OneKeyShareInfo component2() {
        return this.shareInfo;
    }

    public final PromoShareBtnModel copy(String str, OneKeyShareInfo oneKeyShareInfo) {
        Intrinsics.checkNotNullParameter(oneKeyShareInfo, "shareInfo");
        return new PromoShareBtnModel(str, oneKeyShareInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PromoShareBtnModel)) {
            return false;
        }
        PromoShareBtnModel promoShareBtnModel = (PromoShareBtnModel) obj;
        return Intrinsics.areEqual((Object) this.shareIcon, (Object) promoShareBtnModel.shareIcon) && Intrinsics.areEqual((Object) this.shareInfo, (Object) promoShareBtnModel.shareInfo);
    }

    public int hashCode() {
        String str = this.shareIcon;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.shareInfo.hashCode();
    }

    public String toString() {
        return "PromoShareBtnModel(shareIcon=" + this.shareIcon + ", shareInfo=" + this.shareInfo + VersionRange.RIGHT_OPEN;
    }

    public PromoShareBtnModel(String str, OneKeyShareInfo oneKeyShareInfo) {
        Intrinsics.checkNotNullParameter(oneKeyShareInfo, "shareInfo");
        this.shareIcon = str;
        this.shareInfo = oneKeyShareInfo;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PromoShareBtnModel(String str, OneKeyShareInfo oneKeyShareInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, oneKeyShareInfo);
    }

    public final String getShareIcon() {
        return this.shareIcon;
    }

    public final OneKeyShareInfo getShareInfo() {
        return this.shareInfo;
    }
}
