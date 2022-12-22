package com.didi.dimina.container.util;

import android.content.Context;
import com.didi.dimina.container.bridge.permission.PermissionDescInfo;
import com.didi.dimina.container.bridge.permission.SinglePermissionCallBack;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.p106ui.dialog.BottomDialog;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: PermissionUtil.kt */
final class PermissionUtil$checkAndRequestBridgePermission$1 implements Runnable {
    final /* synthetic */ SinglePermissionCallBack $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $permission;
    final /* synthetic */ PermissionDescInfo $permissionDescInfo;

    PermissionUtil$checkAndRequestBridgePermission$1(String str, SinglePermissionCallBack singlePermissionCallBack, Context context, PermissionDescInfo permissionDescInfo) {
        this.$permission = str;
        this.$callback = singlePermissionCallBack;
        this.$context = context;
        this.$permissionDescInfo = permissionDescInfo;
    }

    public final void run() {
        Object obj = MMKVUtil.getInstance().get(this.$permission, false);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
        } else if (((Boolean) obj).booleanValue()) {
            PermissionUtil.INSTANCE.m13425a(this.$callback, this.$permission, 0);
        } else {
            BottomDialog bottomDialog = new BottomDialog(this.$context, this.$permissionDescInfo);
            bottomDialog.setBottomDialogClickListener(new BottomDialog.BottomDialogClickListener(this) {
                final /* synthetic */ PermissionUtil$checkAndRequestBridgePermission$1 this$0;

                {
                    this.this$0 = r1;
                }

                public void onPositiveBtnClick() {
                    MMKVUtil.getInstance().save(this.this$0.$permission, true);
                    PermissionUtil.INSTANCE.m13425a(this.this$0.$callback, this.this$0.$permission, 0);
                }

                public void onNegativeBtnClick() {
                    PermissionUtil.INSTANCE.m13425a(this.this$0.$callback, this.this$0.$permission, -1);
                }
            });
            SystemUtils.showDialog(bottomDialog);
        }
    }
}
