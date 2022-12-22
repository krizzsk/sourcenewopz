package com.didiglobal.p205sa.biz.component.bizcard;

import android.content.Context;
import android.view.View;
import com.didiglobal.enginecore.template.temp.IXEView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/bizcard/BizCardTemplateView;", "Lcom/didiglobal/enginecore/template/temp/IXEView;", "Lcom/didiglobal/sa/biz/component/bizcard/BizCardTempModel;", "()V", "viewGroup", "Lcom/didiglobal/sa/biz/component/bizcard/BizCardItemViewGroup;", "bindData", "", "model", "getView", "Landroid/view/View;", "initView", "context", "Landroid/content/Context;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.bizcard.BizCardTemplateView */
/* compiled from: BizCardTemplateView.kt */
public final class BizCardTemplateView implements IXEView<BizCardTempModel> {

    /* renamed from: a */
    private BizCardItemViewGroup f50803a;

    public void initView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f50803a = new BizCardItemViewGroup(context);
    }

    public void bindData(BizCardTempModel bizCardTempModel) {
        BizCardItemViewGroup bizCardItemViewGroup = this.f50803a;
        if (bizCardItemViewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewGroup");
            bizCardItemViewGroup = null;
        }
        bizCardItemViewGroup.bindData(bizCardTempModel);
    }

    public View getView() {
        BizCardItemViewGroup bizCardItemViewGroup = this.f50803a;
        if (bizCardItemViewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewGroup");
            bizCardItemViewGroup = null;
        }
        return bizCardItemViewGroup;
    }
}
