package com.didi.soda.bill.dialog.entity;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/bill/dialog/entity/CommonConfirmationDialogEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "confirm", "Lcom/didi/soda/bill/dialog/entity/DialogContentEntity;", "getConfirm", "()Lcom/didi/soda/bill/dialog/entity/DialogContentEntity;", "setConfirm", "(Lcom/didi/soda/bill/dialog/entity/DialogContentEntity;)V", "hasConfirmDialog", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CommonConfirmationDialogEntity.kt */
public final class CommonConfirmationDialogEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 7471011765098160288L;
    private DialogContentEntity confirm = new DialogContentEntity();

    public final DialogContentEntity getConfirm() {
        return this.confirm;
    }

    public final void setConfirm(DialogContentEntity dialogContentEntity) {
        Intrinsics.checkNotNullParameter(dialogContentEntity, "<set-?>");
        this.confirm = dialogContentEntity;
    }

    public final boolean hasConfirmDialog() {
        return !TextUtils.isEmpty(this.confirm.msg);
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/bill/dialog/entity/CommonConfirmationDialogEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonConfirmationDialogEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
