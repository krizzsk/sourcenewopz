package com.didi.rfusion.widget.searchbar;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo175978d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: RFSearchBar.kt */
final class RFSearchBar$initView$1 implements View.OnFocusChangeListener {
    final /* synthetic */ RFSearchBar this$0;

    RFSearchBar$initView$1(RFSearchBar rFSearchBar) {
        this.this$0 = rFSearchBar;
    }

    public final void onFocusChange(View view, boolean z) {
        this.this$0.setHasFocus(z);
    }
}
