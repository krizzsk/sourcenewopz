package com.didichuxing.comp.telecom.biz.p176ui.base;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/base/ATelecomFragment;", "Landroidx/fragment/app/Fragment;", "()V", "mPageStartTime", "", "onPageShow", "", "onPageStay", "stayTimeMillis", "onPause", "onResume", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.base.ATelecomFragment */
/* compiled from: BaseActivity.kt */
public abstract class ATelecomFragment extends Fragment {

    /* renamed from: a */
    private long f46284a;

    public void onPageShow() {
    }

    public void onPageStay(long j) {
    }

    public void onResume() {
        super.onResume();
        onPageShow();
        this.f46284a = System.currentTimeMillis();
    }

    public void onPause() {
        super.onPause();
        onPageStay(System.currentTimeMillis() - this.f46284a);
    }
}
