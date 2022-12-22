package com.didi.dimina.container.secondparty.permission;

import android.app.Activity;
import android.content.Context;
import com.didi.dimina.container.bridge.permission.DiminaPermissionDescDialog;
import com.didi.dimina.container.bridge.permission.PermissionDescInfo;
import com.didi.dimina.container.bridge.permission.SinglePermissionCallBack;
import com.didi.dimina.container.secondparty.permission.DidiPermissionManager;
import com.didi.dimina.container.secondparty.permission.DiminaPermissionRejectConfirmDialog;
import com.didi.permission.core.PermissionCoreUtils;
import com.didi.sdk.apm.SystemUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: DidiPermissionManager.kt */
final class DidiPermissionManager$requestPermission$1 implements Runnable {
    final /* synthetic */ SinglePermissionCallBack $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $permission;
    final /* synthetic */ PermissionDescInfo $permissionDescInfo;
    final /* synthetic */ boolean $privacy;
    final /* synthetic */ DidiPermissionManager this$0;

    DidiPermissionManager$requestPermission$1(DidiPermissionManager didiPermissionManager, Context context, String str, SinglePermissionCallBack singlePermissionCallBack, PermissionDescInfo permissionDescInfo, boolean z) {
        this.this$0 = didiPermissionManager;
        this.$context = context;
        this.$permission = str;
        this.$callback = singlePermissionCallBack;
        this.$permissionDescInfo = permissionDescInfo;
        this.$privacy = z;
    }

    public final void run() {
        Context context = this.$context;
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            Integer num = (Integer) this.this$0.f17312a.get(this.$permission);
            if (num != null) {
                DidiPermissionManager didiPermissionManager = this.this$0;
                SinglePermissionCallBack singlePermissionCallBack = this.$callback;
                String str = this.$permission;
                Intrinsics.checkExpressionValueIsNotNull(num, "it");
                didiPermissionManager.m12862a(singlePermissionCallBack, str, num.intValue());
                return;
            }
            boolean hasPermissions = AndPermission.hasPermissions(this.$context, new String[]{this.$permission});
            if (hasPermissions) {
                this.this$0.m12862a(this.$callback, this.$permission, 0);
                return;
            }
            int i = DidiPermissionManager.WhenMappings.$EnumSwitchMapping$0[PermissionCoreUtils.Companion.checkPermission(this.$context, this.$permission).ordinal()];
            if (i == 1) {
                this.this$0.m12862a(this.$callback, this.$permission, 0);
            } else if (i == 2) {
                final DiminaPermissionDescDialog access$getDescDialog = this.this$0.m12860a(this.$context, this.$permissionDescInfo, this.$permission);
                if (!hasPermissions) {
                    this.this$0.m12861a(access$getDescDialog);
                }
                AndPermission.with(this.$context).runtime().permission(new String[]{this.$permission}).onDenied(new Action<List<String>>(this) {
                    final /* synthetic */ DidiPermissionManager$requestPermission$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void onAction(List<String> list) {
                        PermissionCoreUtils.Companion.savePermission(this.this$0.$context, this.this$0.$permission, -1);
                        this.this$0.this$0.m12863b(access$getDescDialog);
                        this.this$0.this$0.m12862a(this.this$0.$callback, this.this$0.$permission, -1);
                    }
                }).rationale(new Rationale<List<String>>(this) {
                    final /* synthetic */ DidiPermissionManager$requestPermission$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void showRationale(Context context, List<String> list, final RequestExecutor requestExecutor) {
                        Intrinsics.checkParameterIsNotNull(context, "<anonymous parameter 0>");
                        Intrinsics.checkParameterIsNotNull(list, "<anonymous parameter 1>");
                        Intrinsics.checkParameterIsNotNull(requestExecutor, "requestExecutor");
                        this.this$0.this$0.m12863b(access$getDescDialog);
                        SystemUtils.showDialog(new DiminaPermissionRejectConfirmDialog.DiminaBuilder().setContent(this.this$0.$permissionDescInfo.getContent()).setCallBack(new DiminaPermissionRejectConfirmDialog.CallBack(this) {
                            final /* synthetic */ C75803 this$0;

                            {
                                this.this$0 = r1;
                            }

                            public void cancel() {
                                requestExecutor.cancel();
                            }

                            public void confirm() {
                                this.this$0.this$0.this$0.m12861a(access$getDescDialog);
                                requestExecutor.execute();
                            }
                        }).build(this.this$0.$context));
                    }
                }).onGranted(new Action<List<String>>(this) {
                    final /* synthetic */ DidiPermissionManager$requestPermission$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void onAction(List<String> list) {
                        PermissionCoreUtils.Companion.savePermission(this.this$0.$context, this.this$0.$permission, 0);
                        this.this$0.this$0.m12863b(access$getDescDialog);
                        this.this$0.this$0.m12862a(this.this$0.$callback, this.this$0.$permission, 0);
                    }
                }).start();
            } else if (i == 3) {
                this.this$0.m12862a(this.$callback, this.$permission, -1);
                if (!this.$privacy) {
                    SystemUtils.showDialog(new DiminaPermissionRejectConfirmDialog.DiminaBuilder().setContent(this.$permissionDescInfo.getContent()).setConfirmText("去设置").setCallBack(new DiminaPermissionRejectConfirmDialog.CallBack(this) {
                        final /* synthetic */ DidiPermissionManager$requestPermission$1 this$0;

                        public void cancel() {
                        }

                        {
                            this.this$0 = r1;
                        }

                        public void confirm() {
                            AndPermission.with(this.this$0.$context).runtime().setting().start(1);
                        }
                    }).build(this.$context));
                }
            }
        }
    }
}
