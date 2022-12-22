package com.didi.map.global.component.floatingwindow.view;

import android.graphics.Bitmap;
import android.view.View;
import com.didi.map.global.component.floatingwindow.IFWController;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001aJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/map/global/component/floatingwindow/view/IFWView;", "", "setCarBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "setMainTitle", "mainTitle", "", "setMaskVisible", "visible", "", "setSubTitle", "subTitle", "setTouchListener", "listener", "Landroid/view/View$OnTouchListener;", "updateMaskState", "isShow", "alpha", "", "updateViewBackground", "colorState", "Lcom/didi/map/global/component/floatingwindow/IFWController$Style;", "shapeState", "Lcom/didi/map/global/component/floatingwindow/view/IFWView$FWShapeState;", "FWShapeState", "compFloatingWindow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IFWView.kt */
public interface IFWView {

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/map/global/component/floatingwindow/view/IFWView$FWShapeState;", "", "(Ljava/lang/String;I)V", "EXPAND", "EXPAND_NORMAL_DRAG", "EXPAND_HANDLE_DRAG", "ROLL", "compFloatingWindow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IFWView.kt */
    public enum FWShapeState {
        EXPAND,
        EXPAND_NORMAL_DRAG,
        EXPAND_HANDLE_DRAG,
        ROLL
    }

    void setCarBitmap(Bitmap bitmap);

    void setMainTitle(String str);

    void setMaskVisible(boolean z);

    void setSubTitle(String str);

    void setTouchListener(View.OnTouchListener onTouchListener);

    void updateMaskState(boolean z, float f);

    void updateViewBackground(IFWController.Style style, FWShapeState fWShapeState);
}
