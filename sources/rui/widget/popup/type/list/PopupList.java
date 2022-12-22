package rui.widget.popup.type.list;

import java.util.ArrayList;
import java.util.List;
import rui.widget.popup.base.BasePopupModel;
import rui.widget.popup.type.list.PopupList.Item;

public class PopupList<T extends Item> extends BasePopupModel<FactoryPopupList> {
    public static final String CHECKBOX_ICON_ORANGE = "CHECKBOX_ICON_ORANGE";
    public static final String CHECKBOX_ICON_YELLOW = "CHECKBOX_ICON_YELLOW";
    public boolean allowEmpty = false;
    public CharSequence buttonTitle = "确定";
    public String checkboxIconColor = CHECKBOX_ICON_ORANGE;
    public List<T> dataList;
    public List<T> defaultSelect = new ArrayList();
    public Listener<T> listener;
    public boolean multiSelect;
    public CharSequence subtitle;
    public CharSequence title;

    public interface Item {
        String title();
    }

    public interface Listener<T> {
        void onSelect(List<T> list);
    }

    public PopupList() {
        this.factory = new FactoryPopupList();
    }
}
