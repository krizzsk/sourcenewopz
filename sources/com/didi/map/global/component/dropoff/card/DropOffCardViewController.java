package com.didi.map.global.component.dropoff.card;

import android.content.Context;
import android.view.View;
import com.didi.map.global.component.dropoff.card.IDropOffCard;
import com.didi.map.global.component.dropoff.model.DropOffAddress;

public class DropOffCardViewController {

    /* renamed from: a */
    private Context f25438a;

    /* renamed from: b */
    private int f25439b = 1;

    /* renamed from: c */
    private DropOffConfirmCardView f25440c;

    /* renamed from: d */
    private IDropOffCard.DropOffCardCallback f25441d;

    public DropOffCardViewController(Context context, IDropOffCard.DropOffCardCallback dropOffCardCallback) {
        this.f25438a = context;
        this.f25441d = dropOffCardCallback;
    }

    public View getView(int i, DropOffAddress dropOffAddress) {
        this.f25439b = 1;
        if (this.f25440c == null) {
            DropOffConfirmCardView dropOffConfirmCardView = (DropOffConfirmCardView) DropOffCardFactory.getCardView(this.f25438a, 1);
            this.f25440c = dropOffConfirmCardView;
            dropOffConfirmCardView.setCardCallback(this.f25441d);
        }
        this.f25440c.updateCard(dropOffAddress);
        return this.f25440c;
    }

    public View onDataLoading() {
        if (this.f25440c == null) {
            DropOffConfirmCardView dropOffConfirmCardView = (DropOffConfirmCardView) DropOffCardFactory.getCardView(this.f25438a, 1);
            this.f25440c = dropOffConfirmCardView;
            dropOffConfirmCardView.setCardCallback(this.f25441d);
        }
        this.f25440c.onDataLoading();
        return this.f25440c;
    }

    public void setAddressName(String str) {
        DropOffConfirmCardView dropOffConfirmCardView = this.f25440c;
        if (dropOffConfirmCardView != null) {
            dropOffConfirmCardView.setAddressNameText(str);
        }
    }

    public void setSubTitle(String str) {
        DropOffConfirmCardView dropOffConfirmCardView = this.f25440c;
        if (dropOffConfirmCardView != null) {
            dropOffConfirmCardView.setSubTitleText(str);
        }
    }
}
