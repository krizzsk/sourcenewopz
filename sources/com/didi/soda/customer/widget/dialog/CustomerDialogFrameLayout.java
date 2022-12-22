package com.didi.soda.customer.widget.dialog;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.widget.dialog.RFDialogFrameLayout;

public class CustomerDialogFrameLayout extends RFDialogFrameLayout {
    public CustomerDialogFrameLayout(Context context) {
        super(context);
    }

    public CustomerDialogFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomerDialogFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public TimeInterpolator getTimeInterpolator(boolean z, Dialog dialog) {
        if (z) {
            if (dialog instanceof BottomSheetDialog) {
                return new DecelerateInterpolator();
            }
        } else if (dialog instanceof BottomSheetDialog) {
            return new DecelerateInterpolator();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean isShowBackground(Dialog dialog) {
        if ((dialog instanceof CommonLoadingDialog) || (dialog instanceof CommonBlockDialog)) {
            return false;
        }
        return super.isShowBackground(dialog);
    }
}
