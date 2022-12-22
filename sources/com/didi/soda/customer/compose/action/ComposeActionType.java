package com.didi.soda.customer.compose.action;

import android.net.Uri;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.widget.dialog.RFCommonDialog;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.soda.customer.compose.action.ComposeActionType;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ComposeActionEntity;
import com.didi.soda.customer.widget.dialog.SodaWindowFactory;
import com.didi.soda.customer.widget.text.RichTextParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/customer/compose/action/ComposeActionType;", "", "Lcom/didi/soda/customer/compose/action/Behaviour;", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "DIALOG", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ComposeActionType.kt */
public enum ComposeActionType implements Behaviour {
    ;
    
    private final String type;

    private ComposeActionType(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0001\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/customer/compose/action/ComposeActionType$DIALOG;", "Lcom/didi/soda/customer/compose/action/ComposeActionType;", "btnAction", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "actions", "", "", "dialog", "Lcom/didi/rfusion/widget/dialog/RFDialog;", "doAction", "", "composeActionEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ComposeActionType.kt */
    static final class DIALOG extends ComposeActionType {
        DIALOG(String str, int i) {
            super(str, i, "dialog", (DefaultConstructorMarker) null);
        }

        public boolean doAction(ScopeContext scopeContext, ComposeActionEntity composeActionEntity) {
            ComposeActionEntity.RetainInfo retainInfo;
            Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
            if (composeActionEntity == null || (retainInfo = composeActionEntity.getRetainInfo()) == null) {
                LogUtil.m29104i(name(), "do not show dialog because composeActionEntity.retainInfo == null");
                return false;
            } else if (!StrategyAction.doStrategy$default(StrategyAction.INSTANCE, retainInfo.getStrategy(), (String) null, 2, (Object) null)) {
                return false;
            } else {
                List<ComposeActionEntity.RetainInfo.BtnList> btnList = retainInfo.getBtnList();
                if (btnList == null) {
                    LogUtil.m29104i(name(), "do not show dialog because retainInfo.btnList == null");
                    return false;
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                RFCommonDialog.Builder builder = (RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(RichTextParser.parseText(retainInfo.getContent())).setTitle(retainInfo.getTitle());
                if (btnList.size() == 2) {
                    builder.setSubAction1(btnList.get(0).getTitle(), new RFDialogInterface.OnClickListener(scopeContext, btnList, objectRef) {
                        public final /* synthetic */ ScopeContext f$1;
                        public final /* synthetic */ List f$2;
                        public final /* synthetic */ Ref.ObjectRef f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void onClick(RFDialog rFDialog) {
                            ComposeActionType.DIALOG.m46889doAction$lambda6$lambda4$lambda0(ComposeActionType.DIALOG.this, this.f$1, this.f$2, this.f$3, rFDialog);
                        }
                    });
                    builder.setMainAction(btnList.get(1).getTitle(), new RFDialogInterface.OnClickListener(scopeContext, btnList, objectRef) {
                        public final /* synthetic */ ScopeContext f$1;
                        public final /* synthetic */ List f$2;
                        public final /* synthetic */ Ref.ObjectRef f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void onClick(RFDialog rFDialog) {
                            ComposeActionType.DIALOG.m46890doAction$lambda6$lambda4$lambda1(ComposeActionType.DIALOG.this, this.f$1, this.f$2, this.f$3, rFDialog);
                        }
                    });
                } else if (btnList.size() == 1) {
                    builder.setMainAction(btnList.get(0).getTitle(), new RFDialogInterface.OnClickListener(scopeContext, btnList, objectRef) {
                        public final /* synthetic */ ScopeContext f$1;
                        public final /* synthetic */ List f$2;
                        public final /* synthetic */ Ref.ObjectRef f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void onClick(RFDialog rFDialog) {
                            ComposeActionType.DIALOG.m46891doAction$lambda6$lambda4$lambda2(ComposeActionType.DIALOG.this, this.f$1, this.f$2, this.f$3, rFDialog);
                        }
                    });
                }
                objectRef.element = builder.create();
                SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) objectRef.element);
                List<String> actions = retainInfo.getActions();
                if (actions != null) {
                    ComposeActionExecute composeActionExecute = new ComposeActionExecute();
                    for (String execute : actions) {
                        composeActionExecute.execute(scopeContext, execute, (ComposeActionEntity) null, (ActionInterceptListener) null);
                    }
                }
                return true;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: doAction$lambda-6$lambda-4$lambda-0  reason: not valid java name */
        public static final void m46889doAction$lambda6$lambda4$lambda0(DIALOG dialog, ScopeContext scopeContext, List list, Ref.ObjectRef objectRef, RFDialog rFDialog) {
            Intrinsics.checkNotNullParameter(dialog, "this$0");
            Intrinsics.checkNotNullParameter(scopeContext, "$scopeContext");
            Intrinsics.checkNotNullParameter(list, "$btnList");
            Intrinsics.checkNotNullParameter(objectRef, "$dialog");
            dialog.btnAction(scopeContext, ((ComposeActionEntity.RetainInfo.BtnList) list.get(0)).getActions(), (RFDialog) objectRef.element);
        }

        /* access modifiers changed from: private */
        /* renamed from: doAction$lambda-6$lambda-4$lambda-1  reason: not valid java name */
        public static final void m46890doAction$lambda6$lambda4$lambda1(DIALOG dialog, ScopeContext scopeContext, List list, Ref.ObjectRef objectRef, RFDialog rFDialog) {
            Intrinsics.checkNotNullParameter(dialog, "this$0");
            Intrinsics.checkNotNullParameter(scopeContext, "$scopeContext");
            Intrinsics.checkNotNullParameter(list, "$btnList");
            Intrinsics.checkNotNullParameter(objectRef, "$dialog");
            dialog.btnAction(scopeContext, ((ComposeActionEntity.RetainInfo.BtnList) list.get(1)).getActions(), (RFDialog) objectRef.element);
        }

        /* access modifiers changed from: private */
        /* renamed from: doAction$lambda-6$lambda-4$lambda-2  reason: not valid java name */
        public static final void m46891doAction$lambda6$lambda4$lambda2(DIALOG dialog, ScopeContext scopeContext, List list, Ref.ObjectRef objectRef, RFDialog rFDialog) {
            Intrinsics.checkNotNullParameter(dialog, "this$0");
            Intrinsics.checkNotNullParameter(scopeContext, "$scopeContext");
            Intrinsics.checkNotNullParameter(list, "$btnList");
            Intrinsics.checkNotNullParameter(objectRef, "$dialog");
            dialog.btnAction(scopeContext, ((ComposeActionEntity.RetainInfo.BtnList) list.get(0)).getActions(), (RFDialog) objectRef.element);
        }

        private final void btnAction(ScopeContext scopeContext, List<String> list, RFDialog rFDialog) {
            if (list != null) {
                ComposeActionExecute composeActionExecute = new ComposeActionExecute();
                for (String next : list) {
                    String queryParameter = Uri.parse(next).getQueryParameter("type");
                    if (queryParameter != null) {
                        int hashCode = queryParameter.hashCode();
                        if (hashCode != -1367724422) {
                            if (hashCode == 111185 && queryParameter.equals("pop")) {
                                if (rFDialog != null) {
                                    rFDialog.dismiss();
                                }
                                scopeContext.getNavigator().finish();
                            }
                        } else if (queryParameter.equals("cancel")) {
                            if (rFDialog != null) {
                                rFDialog.dismiss();
                            }
                        }
                    }
                    composeActionExecute.execute(scopeContext, next, (ComposeActionEntity) null, (ActionInterceptListener) null);
                }
            }
        }
    }
}
