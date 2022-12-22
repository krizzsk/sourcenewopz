package com.didi.map.global.component.floatingwindow;

import android.graphics.Bitmap;
import android.view.View;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u0017\u001a\u00020\u0003H&¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/map/global/component/floatingwindow/IFWController;", "", "close", "", "hidden", "isOpen", "", "isShow", "open", "setCarBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setMainTitle", "title", "", "setOnClickListener", "listener", "Landroid/view/View$OnClickListener;", "setStyle", "style", "Lcom/didi/map/global/component/floatingwindow/IFWController$Style;", "setSubTitle", "subtitle", "show", "Style", "compFloatingWindow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IFWController.kt */
public interface IFWController {

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/map/global/component/floatingwindow/IFWController$Style;", "", "(Ljava/lang/String;I)V", "Grey", "Gradient", "Orange", "compFloatingWindow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IFWController.kt */
    public enum Style {
        Grey,
        Gradient,
        Orange
    }

    void close();

    void hidden();

    boolean isOpen();

    boolean isShow();

    void open();

    void setCarBitmap(Bitmap bitmap);

    void setMainTitle(String str);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setStyle(Style style);

    void setSubTitle(String str);

    void show();
}
