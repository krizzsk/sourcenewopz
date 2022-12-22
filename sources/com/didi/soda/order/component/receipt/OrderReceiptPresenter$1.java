package com.didi.soda.order.component.receipt;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.order.binder.receipt.OrderReceiptInputLogicRepo;

class OrderReceiptPresenter$1 extends ComponentLogicUnit {
    final /* synthetic */ C14122a this$0;

    OrderReceiptPresenter$1(C14122a aVar) {
        this.this$0 = aVar;
    }

    public void onBindLogic() {
        ((OrderReceiptInputLogicRepo) getLogic(OrderReceiptInputLogicRepo.class)).subscribe(this.this$0.getScopeContext(), new Action1() {
            public final void call(Object obj) {
                OrderReceiptPresenter$1.this.lambda$onBindLogic$0$OrderReceiptPresenter$1((OrderReceiptInputLogicRepo.ReceiptInputLogicModel) obj);
            }
        });
    }

    public /* synthetic */ void lambda$onBindLogic$0$OrderReceiptPresenter$1(OrderReceiptInputLogicRepo.ReceiptInputLogicModel receiptInputLogicModel) {
        this.this$0.m30766a(receiptInputLogicModel);
    }
}
