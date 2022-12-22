package com.didi.sdk.debug.language;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/sdk/debug/language/LanguageDebugPresenter$showDialog$model$1", "Lcom/didi/global/globaluikit/callback/LEGOOnAntiShakeClickListener;", "onAntiShakeClick", "", "p0", "Landroid/view/View;", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LanguageDebugPresenter.kt */
public final class LanguageDebugPresenter$showDialog$model$1 extends LEGOOnAntiShakeClickListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.ObjectRef<LEGODrawer> $drawer;

    LanguageDebugPresenter$showDialog$model$1(Ref.ObjectRef<LEGODrawer> objectRef, Context context) {
        this.$drawer = objectRef;
        this.$context = context;
    }

    public void onAntiShakeClick(View view) {
        LEGODrawer lEGODrawer = (LEGODrawer) this.$drawer.element;
        if (lEGODrawer != null) {
            lEGODrawer.dismiss();
        }
        Context context = this.$context;
        if (context instanceof Fragment) {
            FragmentActivity activity = ((Fragment) context).getActivity();
            if (activity != null) {
                activity.finishAffinity();
            }
        } else if (context instanceof Activity) {
            ((Activity) context).finishAffinity();
        }
        Process.killProcess(Process.myPid());
    }
}
