package com.didi.entrega.info.component.receive;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.info.repo.InfoOrderRepoConfig;
import com.didi.entrega.info.repo.InfoRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/entrega/info/component/receive/ReceiveContactUpdatePresenter$subscrib$1", "Lcom/didi/app/nova/skeleton/repo/Action1;", "Lcom/didi/entrega/info/repo/InfoOrderRepoConfig;", "call", "", "t", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ReceiveContactUpdatePresenter.kt */
public final class ReceiveContactUpdatePresenter$subscrib$1 implements Action1<InfoOrderRepoConfig> {
    final /* synthetic */ InfoRepo $infoRepo;
    final /* synthetic */ ReceiveContactUpdatePresenter this$0;

    ReceiveContactUpdatePresenter$subscrib$1(InfoRepo infoRepo, ReceiveContactUpdatePresenter receiveContactUpdatePresenter) {
        this.$infoRepo = infoRepo;
        this.this$0 = receiveContactUpdatePresenter;
    }

    public void call(InfoOrderRepoConfig infoOrderRepoConfig) {
        AddressEntity receiveContact = this.$infoRepo.getReceiveContact();
        int indexOf = this.this$0.getDataListManager().indexOf(this.this$0.getContractModel());
        LogUtil.m14765i(this.this$0.getTAG(), Intrinsics.stringPlus("联系人发生变化,index:", Integer.valueOf(indexOf)));
        if (indexOf >= 0) {
            this.this$0.getComponentRepo().setReceiverValue(receiveContact);
            ReceiveContactUpdatePresenter receiveContactUpdatePresenter = this.this$0;
            receiveContactUpdatePresenter.setContractModel(receiveContactUpdatePresenter.getComponentRepo().getReceiver());
            if (this.this$0.getContractModel() != null) {
                this.this$0.getDataListManager().set(indexOf, this.this$0.getContractModel());
            }
        }
    }
}
