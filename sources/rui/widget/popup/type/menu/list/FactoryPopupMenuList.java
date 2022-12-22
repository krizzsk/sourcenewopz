package rui.widget.popup.type.menu.list;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;
import rui.base.BaseViews;
import rui.util.ViewUtils;
import rui.widget.popup.PopupView;
import rui.widget.popup.base.IPopupFactory;
import rui.widget.popup.base.PopupViews;

public class FactoryPopupMenuList implements IPopupFactory<PopupMenuList> {
    public void create(PopupView popupView, PopupMenuList popupMenuList) {
        Context context = popupView.getContext();
        ViewUtils.setBackgroundColor(popupView, R.color.rui_color_transparent);
        popupView.setPadding((int) ViewUtils.m3859dp(context, 16.0f), 0, (int) ViewUtils.m3859dp(context, 16.0f), 0);
        LinearLayout createMenuListSection = PopupViews.createMenuListSection(context);
        popupView.addView(createMenuListSection);
        for (int i = 0; i < popupMenuList.getButtons().size(); i++) {
            TextView createMenuListButton = PopupViews.createMenuListButton(context);
            createMenuListButton.setText(popupMenuList.getButtons().get(i).title);
            createMenuListButton.setOnClickListener(popupMenuList.getButtons().get(i).onClick);
            createMenuListSection.addView(createMenuListButton);
            if (i != popupMenuList.getButtons().size() - 1) {
                createMenuListSection.addView(BaseViews.createSplit(context));
            }
        }
        if (popupMenuList.hasCancel) {
            TextView createMenuCancelButton = PopupViews.createMenuCancelButton(context);
            createMenuCancelButton.setText(popupMenuList.cancelText);
            createMenuCancelButton.setOnClickListener(popupMenuList.cancelClickListener);
            popupView.addView(createMenuCancelButton);
        }
    }
}
