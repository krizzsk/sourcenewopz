package com.jumio.defaultui.view;

import android.graphics.drawable.Drawable;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\f"}, mo175978d2 = {"com/jumio/defaultui/view/BaseFragment$setShowProgress$2", "Landroid/graphics/drawable/Drawable$Callback;", "Landroid/graphics/drawable/Drawable;", "who", "Ljava/lang/Runnable;", "what", "", "unscheduleDrawable", "invalidateDrawable", "", "when", "scheduleDrawable", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: BaseFragment.kt */
public final class BaseFragment$setShowProgress$2 implements Drawable.Callback {
    public final /* synthetic */ MaterialButton $this_setShowProgress;

    public BaseFragment$setShowProgress$2(MaterialButton materialButton) {
        this.$this_setShowProgress = materialButton;
    }

    public void invalidateDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "who");
        this.$this_setShowProgress.invalidate();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(drawable, "who");
        Intrinsics.checkNotNullParameter(runnable, "what");
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Intrinsics.checkNotNullParameter(drawable, "who");
        Intrinsics.checkNotNullParameter(runnable, "what");
    }
}
