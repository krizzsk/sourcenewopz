package com.didiglobal.font.iface;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public interface DecoratorFactory extends LayoutInflater.Factory2 {
    void onDecorateView(View view, View view2, String str, Context context, AttributeSet attributeSet);
}
