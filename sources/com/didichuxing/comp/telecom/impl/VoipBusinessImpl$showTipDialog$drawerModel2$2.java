package com.didichuxing.comp.telecom.impl;

import android.view.View;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didichuxing/comp/telecom/impl/VoipBusinessImpl$showTipDialog$drawerModel2$2", "Lcom/didi/global/globaluikit/callback/LEGOOnAntiShakeClickListener;", "onAntiShakeClick", "", "p0", "Landroid/view/View;", "voip-impl_brpaxRelease"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: VoipBusinessImpl.kt */
public final class VoipBusinessImpl$showTipDialog$drawerModel2$2 extends LEGOOnAntiShakeClickListener {
    final /* synthetic */ Ref.ObjectRef $drawerImpl;
    final /* synthetic */ View.OnClickListener $no;

    VoipBusinessImpl$showTipDialog$drawerModel2$2(Ref.ObjectRef objectRef, View.OnClickListener onClickListener) {
        this.$drawerImpl = objectRef;
        this.$no = onClickListener;
    }

    public void onAntiShakeClick(View view) {
        LEGODrawer lEGODrawer = (LEGODrawer) this.$drawerImpl.element;
        if (lEGODrawer != null) {
            lEGODrawer.dismiss();
        }
        View.OnClickListener onClickListener = this.$no;
        if (onClickListener != null) {
            if (view == null) {
                Intrinsics.throwNpe();
            }
            onClickListener.onClick(view);
        }
    }
}
