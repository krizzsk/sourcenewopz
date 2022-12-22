package rui.widget.popup.type.list;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rui.base.BaseViews;
import rui.widget.button.ButtonStyles;
import rui.widget.popup.PopupView;
import rui.widget.popup.base.IPopupFactory;
import rui.widget.popup.base.PopupViews;
import rui.widget.popup.type.list.PopupList;

public class FactoryPopupList implements IPopupFactory<PopupList> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ISelectData f6830a;

    private interface ISelectData {
        void add(Object obj, View view);

        void defaultSelect(List<Object> list);

        List<Object> getSelect();

        void relateToButton(Button button);
    }

    public void create(PopupView popupView, final PopupList popupList) {
        View view;
        ISelectData dataMulti = popupList.multiSelect ? new DataMulti(popupList.allowEmpty) : new DataSingle(popupList.allowEmpty);
        this.f6830a = dataMulti;
        dataMulti.defaultSelect(popupList.defaultSelect);
        Context context = popupView.getContext();
        popupView.addView(PopupViews.createTitle(context, popupList.title));
        popupView.addView(PopupViews.createSubtitle(context, popupList.subtitle));
        ScrollView createListContainer = PopupViews.createListContainer(context);
        LinearLayout createListLayout = PopupViews.createListLayout(context);
        createListContainer.addView(createListLayout);
        for (T next : popupList.dataList) {
            if (popupList.checkboxIconColor.equals(PopupList.CHECKBOX_ICON_YELLOW)) {
                view = PopupViews.createListItemYellow(context, ((PopupList.Item) next).title(), this.f6830a.getSelect().contains(next));
            } else {
                view = PopupViews.createListItem(context, ((PopupList.Item) next).title(), this.f6830a.getSelect().contains(next));
            }
            this.f6830a.add(next, view);
            createListLayout.addView(view);
        }
        popupView.addView(createListContainer);
        LinearLayout createButtonContainer = PopupViews.createButtonContainer(context);
        Button createButton = BaseViews.createButton(context, TextUtils.isEmpty(popupList.buttonTitle) ? "确定" : popupList.buttonTitle, ButtonStyles.BUTTON_MAIN_ORANGE, Integer.MIN_VALUE, (View.OnClickListener) null);
        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (popupList.listener != null) {
                    popupList.listener.onSelect(FactoryPopupList.this.f6830a.getSelect());
                }
            }
        });
        this.f6830a.relateToButton(createButton);
        createButtonContainer.addView(createButton);
        popupView.addView(createButtonContainer);
    }

    private static class DataSingle implements ISelectData {
        private boolean allowEmpty;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Button f6832b;
        /* access modifiers changed from: private */
        public Object currentSelected = null;
        /* access modifiers changed from: private */
        public HashMap<Object, CheckBox> map = new HashMap<>();

        public DataSingle(boolean z) {
            this.allowEmpty = z;
        }

        public void defaultSelect(List<Object> list) {
            if (list != null && list.size() > 0) {
                this.currentSelected = list.get(0);
            }
        }

        public void add(final Object obj, View view) {
            final CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);
            this.map.put(obj, checkBox);
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (DataSingle.this.currentSelected != null) {
                        ((CheckBox) DataSingle.this.map.get(DataSingle.this.currentSelected)).setChecked(false);
                    }
                    Object unused = DataSingle.this.currentSelected = obj;
                    checkBox.setChecked(true);
                    if (DataSingle.this.f6832b != null) {
                        DataSingle.this.f6832b.setEnabled(true);
                    }
                }
            });
        }

        public void relateToButton(Button button) {
            this.f6832b = button;
            button.setEnabled(this.allowEmpty || this.currentSelected != null);
        }

        public List<Object> getSelect() {
            ArrayList arrayList = new ArrayList();
            Object obj = this.currentSelected;
            if (obj != null) {
                arrayList.add(obj);
            }
            return arrayList;
        }
    }

    private static class DataMulti implements ISelectData {
        /* access modifiers changed from: private */
        public boolean allowEmpty;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Button f6831b;
        /* access modifiers changed from: private */
        public List<Object> currentSelected = new ArrayList();

        public DataMulti(boolean z) {
            this.allowEmpty = z;
        }

        public void defaultSelect(List<Object> list) {
            if (list != null) {
                this.currentSelected.addAll(list);
            }
        }

        public void add(final Object obj, View view) {
            final CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    boolean z = false;
                    if (DataMulti.this.currentSelected.contains(obj)) {
                        checkBox.setChecked(false);
                        DataMulti.this.currentSelected.remove(obj);
                    } else {
                        checkBox.setChecked(true);
                        DataMulti.this.currentSelected.add(obj);
                    }
                    if (DataMulti.this.f6831b != null) {
                        Button access$500 = DataMulti.this.f6831b;
                        if (DataMulti.this.allowEmpty || !DataMulti.this.currentSelected.isEmpty()) {
                            z = true;
                        }
                        access$500.setEnabled(z);
                    }
                }
            });
        }

        public void relateToButton(Button button) {
            this.f6831b = button;
            button.setEnabled(this.allowEmpty || !this.currentSelected.isEmpty());
        }

        public List<Object> getSelect() {
            return this.currentSelected;
        }
    }
}
