package com.jumio.defaultui.view;

import com.jumio.core.views.ScanView;
import com.jumio.defaultui.view.JumioDialog;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00048V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, mo175978d2 = {"com/jumio/defaultui/view/ScanFragment$scanUpdateObserver$1$1$1", "Lcom/jumio/defaultui/view/JumioDialog$DialogAction;", "", "onAction", "", "getCaption", "()I", "caption", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: ScanFragment.kt */
public final class ScanFragment$scanUpdateObserver$1$1$1 implements JumioDialog.DialogAction {
    public final /* synthetic */ ScanFragment this$0;

    public ScanFragment$scanUpdateObserver$1$1$1(ScanFragment scanFragment) {
        this.this$0 = scanFragment;
    }

    public int getCaption() {
        return R.string.jumio_button_continue;
    }

    public void onAction() {
        this.this$0.getJumioViewModel().mo38c(true);
        ScanView access$getScanView$p = this.this$0.scanView;
        if (access$getScanView$p != null) {
            access$getScanView$p.setExtraction(true);
        }
    }
}
