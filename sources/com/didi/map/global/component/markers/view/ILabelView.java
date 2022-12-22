package com.didi.map.global.component.markers.view;

import android.content.Context;
import android.view.View;

public interface ILabelView {
    View getView(Context context, String str);

    View getView(Context context, String str, int i);

    View getView(Context context, String str, int i, boolean z);

    /* renamed from: com.didi.map.global.component.markers.view.ILabelView$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static View $default$getView(ILabelView iLabelView, Context context, String str) {
            return null;
        }

        public static View $default$getView(ILabelView _this, Context context, String str, int i) {
            return _this.getView(context, str);
        }

        public static View $default$getView(ILabelView _this, Context context, String str, int i, boolean z) {
            return _this.getView(context, str, i);
        }
    }
}
