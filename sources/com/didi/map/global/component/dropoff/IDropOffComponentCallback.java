package com.didi.map.global.component.dropoff;

import android.view.View;
import com.didi.map.global.component.dropoff.model.DropOffAddress;

public interface IDropOffComponentCallback {

    /* renamed from: com.didi.map.global.component.dropoff.IDropOffComponentCallback$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onCardViewOperation(IDropOffComponentCallback iDropOffComponentCallback, int i) {
        }

        public static void $default$onDropOffAddressChanged(IDropOffComponentCallback iDropOffComponentCallback, boolean z, DropOffAddress dropOffAddress, View view) {
        }

        public static void $default$onDropoffLoading(IDropOffComponentCallback iDropOffComponentCallback, View view) {
        }

        public static void $default$onStartDragging(IDropOffComponentCallback iDropOffComponentCallback) {
        }
    }

    void onCardViewOperation(int i);

    void onDropOffAddressChanged(boolean z, DropOffAddress dropOffAddress, View view);

    void onDropoffLoading(View view);

    void onStartDragging();
}
