package com.didi.payment.base.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000bR\u0014\u0010\u001a\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/payment/base/utils/ILoadingConfig;", "", "emptyButtonId", "", "getEmptyButtonId", "()I", "emptyLayoutId", "getEmptyLayoutId", "emptyLayoutView", "Landroid/view/View;", "getEmptyLayoutView", "()Landroid/view/View;", "emptyTextId", "getEmptyTextId", "errorButtonId", "getErrorButtonId", "errorLayoutId", "getErrorLayoutId", "errorLayoutView", "getErrorLayoutView", "errorTextId", "getErrorTextId", "loadingLayoutId", "getLoadingLayoutId", "loadingLayoutView", "getLoadingLayoutView", "loadingViewId", "getLoadingViewId", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ILoadingConfig.kt */
public interface ILoadingConfig {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ILoadingConfig.kt */
    public static final class DefaultImpls {
        public static int getEmptyButtonId(ILoadingConfig iLoadingConfig) {
            Intrinsics.checkNotNullParameter(iLoadingConfig, "this");
            return -1;
        }

        public static int getEmptyLayoutId(ILoadingConfig iLoadingConfig) {
            Intrinsics.checkNotNullParameter(iLoadingConfig, "this");
            return 0;
        }

        public static View getEmptyLayoutView(ILoadingConfig iLoadingConfig) {
            Intrinsics.checkNotNullParameter(iLoadingConfig, "this");
            return null;
        }

        public static int getEmptyTextId(ILoadingConfig iLoadingConfig) {
            Intrinsics.checkNotNullParameter(iLoadingConfig, "this");
            return -1;
        }

        public static int getErrorButtonId(ILoadingConfig iLoadingConfig) {
            Intrinsics.checkNotNullParameter(iLoadingConfig, "this");
            return -1;
        }

        public static int getErrorLayoutId(ILoadingConfig iLoadingConfig) {
            Intrinsics.checkNotNullParameter(iLoadingConfig, "this");
            return 0;
        }

        public static View getErrorLayoutView(ILoadingConfig iLoadingConfig) {
            Intrinsics.checkNotNullParameter(iLoadingConfig, "this");
            return null;
        }

        public static int getErrorTextId(ILoadingConfig iLoadingConfig) {
            Intrinsics.checkNotNullParameter(iLoadingConfig, "this");
            return -1;
        }

        public static int getLoadingLayoutId(ILoadingConfig iLoadingConfig) {
            Intrinsics.checkNotNullParameter(iLoadingConfig, "this");
            return 0;
        }

        public static View getLoadingLayoutView(ILoadingConfig iLoadingConfig) {
            Intrinsics.checkNotNullParameter(iLoadingConfig, "this");
            return null;
        }

        public static int getLoadingViewId(ILoadingConfig iLoadingConfig) {
            Intrinsics.checkNotNullParameter(iLoadingConfig, "this");
            return -1;
        }
    }

    int getEmptyButtonId();

    int getEmptyLayoutId();

    View getEmptyLayoutView();

    int getEmptyTextId();

    int getErrorButtonId();

    int getErrorLayoutId();

    View getErrorLayoutView();

    int getErrorTextId();

    int getLoadingLayoutId();

    View getLoadingLayoutView();

    int getLoadingViewId();
}
