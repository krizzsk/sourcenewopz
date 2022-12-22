package com.didi.addressnew.view;

import android.text.Editable;
import android.view.View;

public interface ISearchViewCallback {
    void afterTextChanged(View view, int i, Editable editable);

    void focusChanged(int i, boolean z);

    void onClearClick(int i, String str);

    void onClick(int i);
}
