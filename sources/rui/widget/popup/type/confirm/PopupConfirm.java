package rui.widget.popup.type.confirm;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import rui.base.ButtonModel;
import rui.widget.popup.base.BasePopupModel;

public class PopupConfirm extends BasePopupModel<FactoryPopupConfirm> {

    /* renamed from: a */
    private List<ButtonModel> f6827a = new ArrayList();
    public View customView;
    public CharSequence subtitle;
    public CharSequence title;

    public PopupConfirm() {
        this.factory = new FactoryPopupConfirm();
    }

    public void addButton(CharSequence charSequence, String str, View.OnClickListener onClickListener) {
        this.f6827a.add(new ButtonModel(charSequence, str, Integer.MIN_VALUE, onClickListener));
    }

    public List<ButtonModel> getButtons() {
        return this.f6827a;
    }
}
