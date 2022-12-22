package com.didi.entrega.home.manager;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.home.component.feed.entity.HomeFeedEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¨\u0006\t"}, mo175978d2 = {"Lcom/didi/entrega/home/manager/HomeNoServiceRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "", "()V", "updateStatus", "homeFeedEntity", "Lcom/didi/entrega/customer/repo/CustomerResource;", "Lcom/didi/entrega/home/component/feed/entity/HomeFeedEntity;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeNoServiceRepo.kt */
public final class HomeNoServiceRepo extends Repo<Boolean> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m15147a(CustomerResource<HomeFeedEntity> customerResource) {
        setValue(Boolean.valueOf(customerResource.status == Resource.Status.ERROR && customerResource.code == 40109));
        Object value = getValue();
        Intrinsics.checkNotNullExpressionValue(value, "this.value");
        return ((Boolean) value).booleanValue();
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/entrega/home/manager/HomeNoServiceRepo$Companion;", "", "()V", "getRep", "Lcom/didi/entrega/home/manager/HomeNoServiceRepo;", "kotlin.jvm.PlatformType", "setNoServiceStatus", "", "homeFeedEntity", "Lcom/didi/entrega/customer/repo/CustomerResource;", "Lcom/didi/entrega/home/component/feed/entity/HomeFeedEntity;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeNoServiceRepo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeNoServiceRepo getRep() {
            return (HomeNoServiceRepo) RepoFactory.getRepo(HomeNoServiceRepo.class);
        }

        public final boolean setNoServiceStatus(CustomerResource<HomeFeedEntity> customerResource) {
            Intrinsics.checkNotNullParameter(customerResource, "homeFeedEntity");
            HomeNoServiceRepo rep = getRep();
            Intrinsics.checkNotNullExpressionValue(rep, "getRep()");
            return rep.m15147a(customerResource);
        }
    }
}
