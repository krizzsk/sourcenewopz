package rui.widget.popup.type.menu.list;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import rui.base.ButtonModel;
import rui.widget.popup.base.BasePopupModel;

public class PopupMenuList extends BasePopupModel<FactoryPopupMenuList> {

    /* renamed from: a */
    private List<ButtonModel> f6833a = new ArrayList();
    public View.OnClickListener cancelClickListener;
    public CharSequence cancelText = "";
    public boolean hasCancel = true;

    public PopupMenuList() {
        this.factory = new FactoryPopupMenuList();
    }

    public void addButton(CharSequence charSequence, View.OnClickListener onClickListener) {
        this.f6833a.add(new ButtonModel(charSequence, (String) null, Integer.MIN_VALUE, onClickListener));
    }

    public List<ButtonModel> getButtons() {
        return this.f6833a;
    }
}
