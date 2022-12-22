package com.didi.soda.customer.blocks.card.suapp;

import com.didi.soda.customer.blocks.ItemOperationListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/suapp/SaItemOperationListener;", "Lcom/didi/soda/customer/blocks/ItemOperationListener;", "doWrapButton", "", "needWrap", "", "doWrapTextLine", "getImageHeight", "", "getWidgetType", "shouldWarpButton", "shouldWarpTextLine", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SaItemOperationListener.kt */
public interface SaItemOperationListener extends ItemOperationListener {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SaItemOperationListener.kt */
    public static final class DefaultImpls {
        public static void doWrapButton(SaItemOperationListener saItemOperationListener, boolean z) {
            Intrinsics.checkNotNullParameter(saItemOperationListener, "this");
        }

        public static void doWrapTextLine(SaItemOperationListener saItemOperationListener, boolean z) {
            Intrinsics.checkNotNullParameter(saItemOperationListener, "this");
        }

        public static int getImageHeight(SaItemOperationListener saItemOperationListener) {
            Intrinsics.checkNotNullParameter(saItemOperationListener, "this");
            return 0;
        }

        public static int getWidgetType(SaItemOperationListener saItemOperationListener) {
            Intrinsics.checkNotNullParameter(saItemOperationListener, "this");
            return 0;
        }

        public static boolean shouldWarpButton(SaItemOperationListener saItemOperationListener) {
            Intrinsics.checkNotNullParameter(saItemOperationListener, "this");
            return false;
        }

        public static boolean shouldWarpTextLine(SaItemOperationListener saItemOperationListener) {
            Intrinsics.checkNotNullParameter(saItemOperationListener, "this");
            return false;
        }
    }

    void doWrapButton(boolean z);

    void doWrapTextLine(boolean z);

    int getImageHeight();

    int getWidgetType();

    boolean shouldWarpButton();

    boolean shouldWarpTextLine();
}
