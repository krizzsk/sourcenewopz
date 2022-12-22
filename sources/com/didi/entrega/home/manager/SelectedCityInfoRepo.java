package com.didi.entrega.home.manager;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.home.component.city.model.HomeCityItemRvModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006\t"}, mo175978d2 = {"Lcom/didi/entrega/home/manager/SelectedCityInfoRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Lcom/didi/entrega/home/component/city/model/HomeCityItemRvModel;", "()V", "setStatus", "", "address", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SelectedCityInfoRepo.kt */
public final class SelectedCityInfoRepo extends Repo<HomeCityItemRvModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15148a(AddressEntity addressEntity) {
        if (addressEntity != null && addressEntity.poi != null) {
            setValue(new HomeCityItemRvModel(addressEntity));
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/entrega/home/manager/SelectedCityInfoRepo$Companion;", "", "()V", "hasData", "", "onChangeData", "", "address", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SelectedCityInfoRepo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void onChangeData(AddressEntity addressEntity) {
            Repo repo = RepoFactory.getRepo(SelectedCityInfoRepo.class);
            Intrinsics.checkNotNullExpressionValue(repo, "getRepo(SelectedCityInfoRepo::class.java)");
            ((SelectedCityInfoRepo) repo).m15148a(addressEntity);
        }

        public final boolean hasData() {
            return ((SelectedCityInfoRepo) RepoFactory.getRepo(SelectedCityInfoRepo.class)).getValue() != null;
        }
    }
}
