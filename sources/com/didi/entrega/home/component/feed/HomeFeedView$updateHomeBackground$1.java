package com.didi.entrega.home.component.feed;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.image.ImageRequestListener;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.home.component.feed.entity.HomeBackgroundEntity;
import com.didi.entrega.home.component.feed.entity.HomeTitleEntity;
import com.didi.entrega.home.manager.HomeOmegaHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\"\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/entrega/home/component/feed/HomeFeedView$updateHomeBackground$1", "Lcom/didi/app/nova/skeleton/image/ImageRequestListener;", "", "onException", "", "e", "Ljava/lang/Exception;", "isFirstResource", "onResourceReady", "resource", "isFromMemoryCache", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedView.kt */
public final class HomeFeedView$updateHomeBackground$1 implements ImageRequestListener<Object> {
    final /* synthetic */ HomeBackgroundEntity $backGround;
    final /* synthetic */ long $beginTime;
    final /* synthetic */ HomeTitleEntity $homeTitle;
    final /* synthetic */ HomeFeedView this$0;

    HomeFeedView$updateHomeBackground$1(HomeTitleEntity homeTitleEntity, HomeFeedView homeFeedView, long j, HomeBackgroundEntity homeBackgroundEntity) {
        this.$homeTitle = homeTitleEntity;
        this.this$0 = homeFeedView;
        this.$beginTime = j;
        this.$backGround = homeBackgroundEntity;
    }

    public boolean onException(Exception exc, boolean z) {
        HomeTitleEntity homeTitleEntity = this.$homeTitle;
        if (homeTitleEntity != null && !TextUtils.isEmpty(homeTitleEntity.getMainTitle())) {
            this.this$0.m15113a(this.$homeTitle);
        }
        LogUtil.m14765i(this.this$0.f20665m, Intrinsics.stringPlus("time = ", Long.valueOf(System.currentTimeMillis() - this.$beginTime)));
        HomeOmegaHelper.Companion.trackHomeBGSW(String.valueOf(System.currentTimeMillis() - this.$beginTime), this.$backGround.getActivityId(), this.$backGround.getUrl(), 0);
        return false;
    }

    public boolean onResourceReady(Object obj, boolean z, boolean z2) {
        String access$getTAG$p = this.this$0.f20665m;
        LogUtil.m14765i(access$getTAG$p, "time = " + (System.currentTimeMillis() - this.$beginTime) + ",isFromMemoryCache = " + z + ",isFirstResource = " + z2);
        HomeOmegaHelper.Companion.trackHomeBGSW(String.valueOf(System.currentTimeMillis() - this.$beginTime), this.$backGround.getActivityId(), this.$backGround.getUrl(), 1);
        return false;
    }
}
