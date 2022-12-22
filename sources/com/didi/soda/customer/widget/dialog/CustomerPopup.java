package com.didi.soda.customer.widget.dialog;

import android.content.Context;
import android.view.View;
import com.didi.app.nova.skeleton.support.rui.Popup;
import rui.base.ButtonModel;
import rui.widget.popup.base.BasePopupModel;
import rui.widget.popup.type.menu.list.PopupMenuList;

public class CustomerPopup extends Popup {
    @Deprecated
    public void init(BasePopupModel basePopupModel) {
    }

    public CustomerPopup(Context context, BasePopupModel basePopupModel) {
        super(context);
        if (basePopupModel instanceof PopupMenuList) {
            m29491a((PopupMenuList) basePopupModel);
        }
        super.init(basePopupModel);
    }

    /* renamed from: a */
    private void m29491a(PopupMenuList popupMenuList) {
        for (ButtonModel next : popupMenuList.getButtons()) {
            if (next != null) {
                final View.OnClickListener onClickListener = next.onClick;
                next.onClick = new View.OnClickListener() {
                    public void onClick(View view) {
                        View.OnClickListener onClickListener = onClickListener;
                        if (onClickListener != null) {
                            onClickListener.onClick(view);
                        }
                        CustomerPopup.this.dismiss();
                    }
                };
            }
        }
        final View.OnClickListener onClickListener2 = popupMenuList.cancelClickListener;
        popupMenuList.cancelClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                View.OnClickListener onClickListener = onClickListener2;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                CustomerPopup.this.dismiss();
            }
        };
    }
}
