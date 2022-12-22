package com.didi.entrega.info.component.receive;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.entrega.info.binder.EditContactBinder;
import com.didi.entrega.info.component.ContactConstract;
import com.didi.entrega.info.model.ContactModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/entrega/info/component/receive/ReceiveContactView$initItemBinders$1$1", "Lcom/didi/entrega/info/binder/EditContactBinder$ContactCardClickListener;", "onCallingCodeClickListener", "", "callingCode", "", "countryId", "", "onPoiClickListener", "textChangeOnModel", "item", "Lcom/didi/entrega/info/model/ContactModel;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ReceiveContactView.kt */
public final class ReceiveContactView$initItemBinders$1$1 implements EditContactBinder.ContactCardClickListener {
    final /* synthetic */ ReceiveContactView this$0;

    ReceiveContactView$initItemBinders$1$1(ReceiveContactView receiveContactView) {
        this.this$0 = receiveContactView;
    }

    public void onPoiClickListener() {
        IPresenter presenter = this.this$0.getPresenter();
        if (presenter != null) {
            ((ContactConstract.AbsEditContactPresenter) presenter).onPoiClick();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.entrega.info.component.ContactConstract.AbsEditContactPresenter");
    }

    public void onCallingCodeClickListener(String str, int i) {
        IPresenter presenter = this.this$0.getPresenter();
        if (presenter != null) {
            ((ContactConstract.AbsEditContactPresenter) presenter).onCallingClick(str, i);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.entrega.info.component.ContactConstract.AbsEditContactPresenter");
    }

    public void textChangeOnModel(ContactModel contactModel) {
        this.this$0.getRepo().setReceiverValue(contactModel);
    }
}
