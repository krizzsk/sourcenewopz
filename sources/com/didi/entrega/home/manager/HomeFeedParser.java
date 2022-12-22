package com.didi.entrega.home.manager;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.entrega.customer.foundation.rpc.entity.BannerEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.util.CollectionsUtil;
import com.didi.entrega.home.component.feed.binder.model.HomeServicesRvModel;
import com.didi.entrega.home.component.feed.binder.model.banner.BannerRvModel;
import com.didi.entrega.home.component.feed.entity.ComponentEntity;
import com.didi.entrega.home.component.feed.entity.HomeBackgroundEntity;
import com.didi.entrega.home.component.feed.entity.HomeOrderEntity;
import com.didi.entrega.home.component.feed.entity.HomeServiceItemEntity;
import com.didi.entrega.home.component.feed.entity.HomeTitleEntity;
import com.didi.entrega.home.component.feed.entity.ServiceRuleEntity;
import com.didi.entrega.home.policy.HomePolicyHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jd\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2<\u0010\n\u001a8\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000b¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/entrega/home/manager/HomeFeedParser;", "", "()V", "parseFeedIndex", "", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "list", "Lcom/didi/entrega/home/component/feed/entity/ComponentEntity;", "mHomePolicyHelper", "Lcom/didi/entrega/home/policy/HomePolicyHelper;", "copyFunction", "Lkotlin/Function5;", "Lcom/didi/entrega/home/component/feed/entity/ServiceRuleEntity;", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "", "Lcom/didi/entrega/home/component/feed/entity/HomeBackgroundEntity;", "Lcom/didi/entrega/home/component/feed/entity/HomeTitleEntity;", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedParser.kt */
public final class HomeFeedParser {
    public static final HomeFeedParser INSTANCE = new HomeFeedParser();

    private HomeFeedParser() {
    }

    public final List<RecyclerModel> parseFeedIndex(List<ComponentEntity> list, HomePolicyHelper homePolicyHelper, Function5<? super ServiceRuleEntity, ? super AddressEntity, ? super List<String>, ? super HomeBackgroundEntity, ? super HomeTitleEntity, Unit> function5) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(function5, "copyFunction");
        if (CollectionsUtil.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ServiceRuleEntity serviceRuleEntity = null;
        AddressEntity addressEntity = null;
        List<String> list2 = null;
        HomeBackgroundEntity homeBackgroundEntity = null;
        HomeTitleEntity homeTitleEntity = null;
        for (ComponentEntity next : list) {
            HomeOrderEntity mOrder = next.getMOrder();
            if (mOrder != null) {
                list2 = mOrder.getOrderIds();
            }
            HomeBackgroundEntity mBackGround = next.getMBackGround();
            if (mBackGround != null) {
                homeBackgroundEntity = mBackGround;
            }
            List<HomeServiceItemEntity> mServiceList = next.getMServiceList();
            if (mServiceList != null) {
                arrayList.add(HomeServicesRvModel.Companion.convertRvModel(mServiceList, list, homePolicyHelper));
            }
            List<BannerEntity> mBannerList = next.getMBannerList();
            if (mBannerList != null) {
                arrayList.add(BannerRvModel.convertBannerEntity(mBannerList));
            }
            ServiceRuleEntity mServiceRule = next.getMServiceRule();
            if (mServiceRule != null) {
                serviceRuleEntity = mServiceRule;
            }
            AddressEntity mAddress = next.getMAddress();
            if (mAddress != null) {
                addressEntity = mAddress;
            }
            HomeTitleEntity mTitle = next.getMTitle();
            if (mTitle != null) {
                homeTitleEntity = mTitle;
            }
        }
        function5.invoke(serviceRuleEntity, addressEntity, list2, homeBackgroundEntity, homeTitleEntity);
        return arrayList;
    }
}
