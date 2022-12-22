package com.didi.soda.customer.foundation.rpc.entity.topgun;

import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.NoMoreLoginEntity;
import com.didi.soda.customer.foundation.rpc.entity.SearchRecommendTagEntity;
import com.didi.soda.datasource.page.dynamic.DynamicBaseEntity;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u0001:\u0001=B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010%8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R \u0010(\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010.\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\f\"\u0004\b0\u0010\u000eR \u00101\u001a\u0004\u0018\u0001028\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R \u00107\u001a\u0004\u0018\u0001088\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006>"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeEntity;", "Lcom/didi/soda/datasource/page/dynamic/DynamicBaseEntity;", "()V", "mAddrEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeAddrEntity;", "getMAddrEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeAddrEntity;", "setMAddrEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeAddrEntity;)V", "mAmbientImg", "", "getMAmbientImg", "()Ljava/lang/String;", "setMAmbientImg", "(Ljava/lang/String;)V", "mDistributorEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeModuleEntity;", "getMDistributorEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeModuleEntity;", "setMDistributorEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeModuleEntity;)V", "mFeedEntity", "getMFeedEntity", "setMFeedEntity", "mFooterLoginEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/NoMoreLoginEntity;", "getMFooterLoginEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/NoMoreLoginEntity;", "setMFooterLoginEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/NoMoreLoginEntity;)V", "mNativePageInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/NativePageInfoEntity;", "getMNativePageInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/topgun/NativePageInfoEntity;", "setMNativePageInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/topgun/NativePageInfoEntity;)V", "mNavi", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$NaviStructBean;", "getMNavi", "()Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$NaviStructBean;", "mNotifyEntity", "Lcom/google/gson/JsonElement;", "getMNotifyEntity", "()Lcom/google/gson/JsonElement;", "setMNotifyEntity", "(Lcom/google/gson/JsonElement;)V", "mRecId", "getMRecId", "setMRecId", "mSuspendBall", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeFeedSuspendBallEntity;", "getMSuspendBall", "()Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeFeedSuspendBallEntity;", "setMSuspendBall", "(Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeFeedSuspendBallEntity;)V", "searchEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/SearchRecommendTagEntity;", "getSearchEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/SearchRecommendTagEntity;", "setSearchEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/SearchRecommendTagEntity;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeEntity.kt */
public final class HomeEntity extends DynamicBaseEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = -1247538872705346964L;
    @SerializedName("address")
    private HomeAddrEntity mAddrEntity;
    @SerializedName("ambientImg")
    private String mAmbientImg;
    @SerializedName("distributor")
    private HomeModuleEntity mDistributorEntity;
    @SerializedName("feed")
    private HomeModuleEntity mFeedEntity;
    @SerializedName("signIn")
    private NoMoreLoginEntity mFooterLoginEntity;
    @SerializedName("nativePage")
    private NativePageInfoEntity mNativePageInfo;
    @SerializedName("navi")
    private final ActivityInfoEntity.NaviStructBean mNavi;
    @SerializedName("notify")
    private JsonElement mNotifyEntity;
    @SerializedName("recId")
    private String mRecId;
    @SerializedName("suspendBall")
    private HomeFeedSuspendBallEntity mSuspendBall;
    @SerializedName("search")
    private SearchRecommendTagEntity searchEntity;

    public final HomeAddrEntity getMAddrEntity() {
        return this.mAddrEntity;
    }

    public final void setMAddrEntity(HomeAddrEntity homeAddrEntity) {
        this.mAddrEntity = homeAddrEntity;
    }

    public final HomeModuleEntity getMDistributorEntity() {
        return this.mDistributorEntity;
    }

    public final void setMDistributorEntity(HomeModuleEntity homeModuleEntity) {
        this.mDistributorEntity = homeModuleEntity;
    }

    public final HomeModuleEntity getMFeedEntity() {
        return this.mFeedEntity;
    }

    public final void setMFeedEntity(HomeModuleEntity homeModuleEntity) {
        this.mFeedEntity = homeModuleEntity;
    }

    public final NativePageInfoEntity getMNativePageInfo() {
        return this.mNativePageInfo;
    }

    public final void setMNativePageInfo(NativePageInfoEntity nativePageInfoEntity) {
        this.mNativePageInfo = nativePageInfoEntity;
    }

    public final String getMAmbientImg() {
        return this.mAmbientImg;
    }

    public final void setMAmbientImg(String str) {
        this.mAmbientImg = str;
    }

    public final HomeFeedSuspendBallEntity getMSuspendBall() {
        return this.mSuspendBall;
    }

    public final void setMSuspendBall(HomeFeedSuspendBallEntity homeFeedSuspendBallEntity) {
        this.mSuspendBall = homeFeedSuspendBallEntity;
    }

    public final NoMoreLoginEntity getMFooterLoginEntity() {
        return this.mFooterLoginEntity;
    }

    public final void setMFooterLoginEntity(NoMoreLoginEntity noMoreLoginEntity) {
        this.mFooterLoginEntity = noMoreLoginEntity;
    }

    public final String getMRecId() {
        return this.mRecId;
    }

    public final void setMRecId(String str) {
        this.mRecId = str;
    }

    public final ActivityInfoEntity.NaviStructBean getMNavi() {
        return this.mNavi;
    }

    public final SearchRecommendTagEntity getSearchEntity() {
        return this.searchEntity;
    }

    public final void setSearchEntity(SearchRecommendTagEntity searchRecommendTagEntity) {
        this.searchEntity = searchRecommendTagEntity;
    }

    public final JsonElement getMNotifyEntity() {
        return this.mNotifyEntity;
    }

    public final void setMNotifyEntity(JsonElement jsonElement) {
        this.mNotifyEntity = jsonElement;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
