package com.didi.entrega.info.component;

import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.info.component.ContactConstract;
import com.didi.entrega.info.model.HistoryModel;
import com.didi.entrega.info.repo.HistoryListRepo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "his", "Lcom/didi/entrega/info/model/HistoryModel;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.entrega.info.component.ContactConstract$AbsEditContactPresenter$onHistoryItemDeleteClick$2$1$1 */
/* compiled from: ContactConstract.kt */
final class C8193x471ce07e extends Lambda implements Function1<HistoryModel, Unit> {
    final /* synthetic */ ContactConstract.AbsEditContactPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C8193x471ce07e(ContactConstract.AbsEditContactPresenter absEditContactPresenter) {
        super(1);
        this.this$0 = absEditContactPresenter;
    }

    public final Unit invoke(HistoryModel historyModel) {
        AddressEntity address;
        String str;
        Intrinsics.checkNotNullParameter(historyModel, "his");
        ((ContactConstract.AbsEditContactView) this.this$0.getLogicView()).hideLoading();
        int indexOf = this.this$0.getDataListManager().indexOf(historyModel);
        if (indexOf < 0) {
            return null;
        }
        this.this$0.getDataListManager().remove(indexOf);
        HistoryListRepo historyListRepo = (HistoryListRepo) RepoFactory.getRepo(HistoryListRepo.class);
        CommonInfoEntity.HistoryContact historyEntity = historyModel.getHistoryEntity();
        String str2 = "";
        if (!(historyEntity == null || (address = historyEntity.getAddress()) == null || (str = address.aid) == null)) {
            str2 = str;
        }
        historyListRepo.deleteOneFromHistory(str2);
        return null;
    }
}
