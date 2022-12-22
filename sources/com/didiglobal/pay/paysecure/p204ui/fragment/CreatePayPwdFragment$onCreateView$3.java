package com.didiglobal.pay.paysecure.p204ui.fragment;

import com.didi.sdk.util.UiThreadHandler;
import com.didiglobal.pay.paysecure.omega.OmegaUtil;
import com.didiglobal.pay.paysecure.omega.OmegaUtilKt;
import com.didiglobal.pay.paysecure.p204ui.fragment.CreatePayPwdFragment;
import com.didiglobal.pay.paysecure.p204ui.view.InputResultListener;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didiglobal/pay/paysecure/ui/fragment/CreatePayPwdFragment$onCreateView$3", "Lcom/didiglobal/pay/paysecure/ui/view/InputResultListener;", "onChange", "", "onResult", "result", "", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment$onCreateView$3 */
/* compiled from: CreatePayPwdFragment.kt */
public final class CreatePayPwdFragment$onCreateView$3 implements InputResultListener {
    final /* synthetic */ CreatePayPwdFragment this$0;

    CreatePayPwdFragment$onCreateView$3(CreatePayPwdFragment createPayPwdFragment) {
        this.this$0 = createPayPwdFragment;
    }

    public void onChange() {
        CreatePayPwdFragment.access$getMConfirm$p(this.this$0).setEnabled(false);
    }

    public void onResult(String str) {
        Intrinsics.checkParameterIsNotNull(str, "result");
        int i = CreatePayPwdFragment.WhenMappings.$EnumSwitchMapping$1[this.this$0.getMState().ordinal()];
        if (i == 1) {
            new OmegaUtil("ibt_password_original_password_change_veri_ck").add(OmegaUtilKt.ENTRANCE_PAGE_ID, Integer.valueOf(this.this$0.getSourcePageId())).send();
            this.this$0.m36267d(str);
        } else if (i == 2 || i == 3) {
            if (this.this$0.m36261a(str)) {
                this.this$0.f50422h = str;
                UiThreadHandler.postDelayed(new CreatePayPwdFragment$onCreateView$3$onResult$1(this), 500);
                return;
            }
            UiThreadHandler.postDelayed(new CreatePayPwdFragment$onCreateView$3$onResult$2(this), 500);
            CreatePayPwdFragment.access$getMSubTitleView$p(this.this$0).setVisibility(4);
            CreatePayPwdFragment.access$getMHintView$p(this.this$0).setVisibility(0);
            CreatePayPwdFragment.access$getMHintView$p(this.this$0).setText(R.string.Finance_PASSWORD_Do_not_ufXK);
        } else if (i == 4) {
            this.this$0.m36263b(str);
        }
    }
}
