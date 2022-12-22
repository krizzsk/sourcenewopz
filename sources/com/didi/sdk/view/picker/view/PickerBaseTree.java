package com.didi.sdk.view.picker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.didi.sdk.view.picker.IPickerData;
import com.didi.sdk.view.picker.NumberPickerView;
import com.didi.sdk.view.picker.PickerDataNode;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

abstract class PickerBaseTree<T extends IPickerData> extends PickerBase<T> {

    /* renamed from: a */
    private List<PickerDataNode<T>> f38152a;

    public PickerBaseTree(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setPickerData(List<PickerDataNode<T>> list) {
        if (this.f38152a == null && list != null) {
            m26977a(list);
            this.f38152a = list;
            this.mCurAllIndex = new int[this.mColumnCount];
        }
    }

    /* access modifiers changed from: protected */
    public void initPickerView() {
        if (this.f38152a != null) {
            this.mPickerViews = new NumberPickerView[this.mColumnCount];
            for (final int i = 0; i < this.mColumnCount; i++) {
                this.mPickerViews[i] = (NumberPickerView) LayoutInflater.from(getContext()).inflate(R.layout.picker_wheel, this, false);
                addView(this.mPickerViews[i]);
                this.mPickerViews[i].setOnValueChangedListener(new NumberPickerView.OnValueChangeListener() {
                    public void onValueChange(NumberPickerView numberPickerView, int i, int i2) {
                        PickerBaseTree.this.modifyColumn(i, i2);
                        if (PickerBaseTree.this.mIsResultRealTime) {
                            PickerBaseTree.this.confirmSelectAndCallback();
                        }
                    }
                });
            }
            applyStyle(this.mStyleInner);
            applyStyle(this.mStyle);
            if (!this.mHasInit) {
                setInitialSelect((T[]) this.mInitialSelect);
                setInitialSelect(this.mInitialIndex);
            }
            m26979b(getCurrentData());
        }
    }

    public void setInitialSelect(T... tArr) {
        int a;
        if (!this.mHasInit) {
            List<PickerDataNode<T>> list = this.f38152a;
            if (list == null) {
                this.mInitialSelect = tArr;
            } else if (tArr != null) {
                int i = 0;
                while (i < Math.min(this.mColumnCount, tArr.length) && list != null && !list.isEmpty() && (a = m26975a(list, tArr[i])) >= 0) {
                    this.mCurAllIndex[i] = a;
                    list = list.get(a).pointList;
                    i++;
                }
            }
        }
    }

    public void setInitialSelect(int... iArr) {
        if (!this.mHasInit) {
            List<PickerDataNode<T>> list = this.f38152a;
            if (list == null) {
                this.mInitialIndex = iArr;
            } else if (iArr != null) {
                int i = 0;
                while (i < Math.min(this.mColumnCount, iArr.length) && list != null && !list.isEmpty() && iArr[i] >= 0 && iArr[i] < list.size()) {
                    this.mCurAllIndex[i] = iArr[i];
                    list = list.get(iArr[i]).pointList;
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public List<T> getSelectedData() {
        List currentData = getCurrentData();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < currentData.size(); i++) {
            arrayList.add(((Entry) currentData.get(i)).columnData.get(this.mCurAllIndex[i]));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public int[] getSelectedIndex() {
        List currentData = getCurrentData();
        int[] iArr = new int[currentData.size()];
        for (int i = 0; i < currentData.size(); i++) {
            iArr[i] = ((Entry) currentData.get(i)).index;
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public List<T> getColumnData(int i) {
        List currentData = getCurrentData();
        Entry entry = null;
        for (int i2 = 0; i2 <= i; i2++) {
            if (i2 < currentData.size()) {
                entry = (Entry) currentData.get(i2);
            }
        }
        return entry != null ? entry.columnData : new ArrayList();
    }

    /* renamed from: a */
    private void m26977a(List<PickerDataNode<T>> list) {
        m26978a(list, 0);
    }

    /* renamed from: a */
    private void m26978a(List<PickerDataNode<T>> list, int i) {
        if (list == null || list.isEmpty()) {
            if (i <= this.mColumnCount) {
                i = this.mColumnCount;
            }
            this.mColumnCount = i;
            return;
        }
        int i2 = i + 1;
        for (PickerDataNode next : list) {
            if (next != null) {
                m26978a(next.pointList, i2);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private List<Entry<T>> getCurrentData() {
        return m26976a(this.mCurAllIndex);
    }

    /* renamed from: a */
    private List<Entry<T>> m26976a(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        List<PickerDataNode<T>> list = this.f38152a;
        for (int i = 0; i < Math.min(this.mColumnCount, iArr.length) && list != null && !list.isEmpty(); i++) {
            int i2 = iArr[i];
            ArrayList arrayList2 = new ArrayList();
            for (PickerDataNode<T> pickerDataNode : list) {
                arrayList2.add(pickerDataNode.data);
            }
            Entry entry = new Entry();
            entry.columnData = arrayList2;
            entry.index = i2;
            arrayList.add(entry);
            list = i2 < list.size() ? list.get(i2).pointList : null;
        }
        return arrayList;
    }

    /* renamed from: b */
    private void m26979b(List<Entry<T>> list) {
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[list.size()];
        for (int i = 0; i < this.mColumnCount; i++) {
            if (i < list.size()) {
                this.mPickerViews[i].refreshByNewDisplayedValues(list.get(i).getStringArray());
                this.mPickerViews[i].setValue(list.get(i).index);
                this.mPickerViews[i].show();
                arrayList.add(list.get(i).columnData.get(list.get(i).index));
                iArr[i] = list.get(i).index;
            } else {
                this.mPickerViews[i].hide();
            }
        }
        onWheelChanged(arrayList, iArr);
    }

    /* access modifiers changed from: protected */
    public void modifyColumn(int i, int i2) {
        int indexOf;
        List currentData = getCurrentData();
        if (i >= 0 && i < currentData.size() && i2 >= 0 && i2 < ((Entry) currentData.get(i)).columnData.size()) {
            this.mCurAllIndex[i] = i2;
            boolean z = false;
            for (int i3 = i + 1; i3 < this.mColumnCount; i3++) {
                if (!z) {
                    if (currentData.size() > i3) {
                        IPickerData iPickerData = (IPickerData) ((Entry) currentData.get(i3)).columnData.get(this.mCurAllIndex[i3]);
                        int i4 = i3 + 1;
                        int[] iArr = new int[i4];
                        System.arraycopy(this.mCurAllIndex, 0, iArr, 0, i4);
                        List a = m26976a(iArr);
                        if (a.size() == i4 && (indexOf = ((Entry) a.get(i3)).indexOf(iPickerData)) >= 0) {
                            this.mCurAllIndex[i3] = indexOf;
                        }
                    }
                    z = true;
                }
                this.mCurAllIndex[i3] = 0;
            }
            m26979b(m26976a(this.mCurAllIndex));
        }
    }

    /* access modifiers changed from: protected */
    public void modifyManyColumn(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            modifyColumn(i, iArr[i]);
        }
    }

    private static class Entry<T extends IPickerData> {
        List<T> columnData;
        int index;

        private Entry() {
        }

        /* access modifiers changed from: package-private */
        public List<String> getStringList() {
            ArrayList arrayList = new ArrayList();
            for (T simpleData : this.columnData) {
                arrayList.add(simpleData.getSimpleData());
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public String[] getStringArray() {
            return (String[]) getStringList().toArray(new String[0]);
        }

        /* access modifiers changed from: package-private */
        public int indexOf(T t) {
            return getStringList().indexOf(t.getSimpleData());
        }
    }

    /* renamed from: a */
    private int m26975a(List<PickerDataNode<T>> list, T t) {
        if (list == null) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).data.getSimpleData().equals(t.getSimpleData())) {
                return i;
            }
        }
        return -1;
    }
}
