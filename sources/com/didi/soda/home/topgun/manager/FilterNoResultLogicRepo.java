package com.didi.soda.home.topgun.manager;

import com.didi.app.nova.skeleton.repo.Repo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/manager/FilterNoResultLogicRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "", "()V", "searchStatus", "getSearchStatus", "()I", "setSearchStatus", "(I)V", "shopLandStatus", "getShopLandStatus", "setShopLandStatus", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FilterNoResultLogicRepo.kt */
public final class FilterNoResultLogicRepo extends Repo<Integer> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int STATUS_OF_RESET_FILTER = 1;

    /* renamed from: a */
    private int f42973a;

    /* renamed from: b */
    private int f42974b;

    public final int getShopLandStatus() {
        return this.f42973a;
    }

    public final void setShopLandStatus(int i) {
        this.f42973a = i;
    }

    public final int getSearchStatus() {
        return this.f42974b;
    }

    public final void setSearchStatus(int i) {
        this.f42974b = i;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/manager/FilterNoResultLogicRepo$Companion;", "", "()V", "STATUS_OF_RESET_FILTER", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FilterNoResultLogicRepo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
