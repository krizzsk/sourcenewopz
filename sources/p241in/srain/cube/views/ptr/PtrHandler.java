package p241in.srain.cube.views.ptr;

import android.view.View;

/* renamed from: in.srain.cube.views.ptr.PtrHandler */
public interface PtrHandler {
    boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2);

    void onRefreshBegin(PtrFrameLayout ptrFrameLayout);
}
