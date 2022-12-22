package com.didi.entrega.home.manager;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.entrega.customer.repo.RepoFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/home/manager/AddressAbnormalRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "", "()V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddressAbnormalRepo.kt */
public final class AddressAbnormalRepo extends Repo<Boolean> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, mo175978d2 = {"Lcom/didi/entrega/home/manager/AddressAbnormalRepo$Companion;", "", "()V", "getRepo", "Lcom/didi/entrega/home/manager/AddressAbnormalRepo;", "kotlin.jvm.PlatformType", "setHiddenStatus", "", "setShowStatus", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AddressAbnormalRepo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setHiddenStatus() {
            ((AddressAbnormalRepo) RepoFactory.getRepo(AddressAbnormalRepo.class)).setValue(false);
        }

        public final void setShowStatus() {
            ((AddressAbnormalRepo) RepoFactory.getRepo(AddressAbnormalRepo.class)).setValue(true);
        }

        public final AddressAbnormalRepo getRepo() {
            return (AddressAbnormalRepo) RepoFactory.getRepo(AddressAbnormalRepo.class);
        }
    }
}
