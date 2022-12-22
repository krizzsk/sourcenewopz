package rui.widget.popup.type.confirm;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import rui.widget.popup.PopupView;
import rui.widget.popup.base.IPopupFactory;
import rui.widget.popup.base.PopupViews;

public class FactoryPopupConfirm implements IPopupFactory<PopupConfirm> {
    public void create(PopupView popupView, PopupConfirm popupConfirm) {
        Context context = popupView.getContext();
        if (!TextUtils.isEmpty(popupConfirm.title)) {
            popupView.addView(PopupViews.createTitle(context, popupConfirm.title));
        }
        if (!TextUtils.isEmpty(popupConfirm.subtitle)) {
            popupView.addView(PopupViews.createSubtitle(context, popupConfirm.subtitle));
        }
        if (popupConfirm.customView != null) {
            FrameLayout createContentContainer = PopupViews.createContentContainer(context);
            createContentContainer.addView(popupConfirm.customView);
            popupView.addView(createContentContainer);
        }
        final LinearLayout createButtonContainer = PopupViews.createButtonContainer(context);
        PopupViews.fillButtonContainer(context, createButtonContainer, popupConfirm.getButtons());
        popupView.addView(createButtonContainer);
        popupView.post(new Runnable() {
            public void run() {
                PopupViews.fixButtonSameHeight(createButtonContainer);
            }
        });
    }
}
