package com.didi.component.operationpanel.model;

import com.didi.component.business.sharetrip.CommonTripShareManager;
import kotlin.Metadata;
import p242io.reactivex.functions.Action;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OperationPanelModel.kt */
final class OperationPanelModel$doShare$1 implements Action {
    final /* synthetic */ OperationPanelModel this$0;

    OperationPanelModel$doShare$1(OperationPanelModel operationPanelModel) {
        this.this$0 = operationPanelModel;
    }

    public final void run() {
        CommonTripShareManager access$get_shareManager$p = this.this$0.f14839e;
        if (access$get_shareManager$p != null) {
            access$get_shareManager$p.disMissOneKeyShareDialog();
        }
    }
}
