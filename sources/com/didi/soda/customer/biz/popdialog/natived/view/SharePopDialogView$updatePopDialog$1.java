package com.didi.soda.customer.biz.popdialog.natived.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.didi.app.nova.skeleton.image.ImageRequestListener;
import com.didi.soda.customer.biz.popdialog.natived.Contract;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0016J\"\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/soda/customer/biz/popdialog/natived/view/SharePopDialogView$updatePopDialog$1", "Lcom/didi/app/nova/skeleton/image/ImageRequestListener;", "Landroid/graphics/drawable/Drawable;", "onException", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isFirstResource", "onResourceReady", "resource", "isFromMemoryCache", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SharePopDialogView.kt */
public final class SharePopDialogView$updatePopDialog$1 implements ImageRequestListener<Drawable> {
    final /* synthetic */ NAPopDialogEntity $entity;
    final /* synthetic */ SharePopDialogView this$0;

    SharePopDialogView$updatePopDialog$1(SharePopDialogView sharePopDialogView, NAPopDialogEntity nAPopDialogEntity) {
        this.this$0 = sharePopDialogView;
        this.$entity = nAPopDialogEntity;
    }

    public boolean onException(Exception exc, boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        View view = null;
        sb.append(exc == null ? null : exc.getMessage());
        sb.append(",getCause = ");
        if ((exc == null ? null : exc.getCause()) != null) {
            Throwable cause = exc.getCause();
            str = cause == null ? null : cause.getMessage();
        } else {
            str = "null";
        }
        sb.append(str);
        String sb2 = sb.toString();
        LogUtil.m29104i(SharePopDialogView.TAG, Intrinsics.stringPlus("down load image fail = ", sb2));
        ((Contract.AbsPopDialogPresenter) this.this$0.getPresenter()).onDownloadPicFail(sb2);
        View access$getMRootView$p = this.this$0.f40518a;
        if (access$getMRootView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view = access$getMRootView$p;
        }
        view.setVisibility(8);
        return false;
    }

    public boolean onResourceReady(Drawable drawable, boolean z, boolean z2) {
        LogUtil.m29104i(SharePopDialogView.TAG, "download onSuccess");
        ((Contract.AbsPopDialogPresenter) this.this$0.getPresenter()).onDownloadPicSucess();
        this.this$0.m28759a(this.$entity);
        ((Contract.AbsPopDialogPresenter) this.this$0.getPresenter()).onPopDialogShow();
        return false;
    }
}
