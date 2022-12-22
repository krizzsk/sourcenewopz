package com.didi.soda.home.topgun.widget.floatlayout;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/floatlayout/IStickHolder;", "", "getStickParent", "Landroid/view/ViewGroup;", "getStickView", "Landroid/view/View;", "openStick", "", "updateWhenFloating", "", "positionStart", "", "itemCount", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IStickHolder.kt */
public interface IStickHolder {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IStickHolder.kt */
    public static final class DefaultImpls {
        public static boolean openStick(IStickHolder iStickHolder) {
            Intrinsics.checkNotNullParameter(iStickHolder, "this");
            return true;
        }
    }

    ViewGroup getStickParent();

    View getStickView();

    boolean openStick();

    void updateWhenFloating(int i, int i2);
}
