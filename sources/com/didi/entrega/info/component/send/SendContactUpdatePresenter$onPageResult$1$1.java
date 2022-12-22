package com.didi.entrega.info.component.send;

import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.info.helper.InfoDataHelper;
import com.didi.entrega.info.model.BaseContactModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/entrega/info/model/BaseContactModel;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SendContactUpdatePresenter.kt */
final class SendContactUpdatePresenter$onPageResult$1$1 extends Lambda implements Function0<BaseContactModel> {
    final /* synthetic */ AddressEntity $it;
    final /* synthetic */ SendContactUpdatePresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SendContactUpdatePresenter$onPageResult$1$1(SendContactUpdatePresenter sendContactUpdatePresenter, AddressEntity addressEntity) {
        super(0);
        this.this$0 = sendContactUpdatePresenter;
        this.$it = addressEntity;
    }

    public final BaseContactModel invoke() {
        this.this$0.setContractModel(InfoDataHelper.INSTANCE.copyAddressEntity(this.this$0.getContractModel(), this.$it));
        this.this$0.getComponentRepo().setSenderValue(this.this$0.getContractModel());
        return this.this$0.getContractModel();
    }
}
