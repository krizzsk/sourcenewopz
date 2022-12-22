package com.didiglobal.p205sa.biz.component.interactivedialog;

import com.didi.global.globalgenerickit.config.ButtonModel;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didiglobal.p205sa.biz.component.xengine.commit.SAXEngineCommitUtil;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didiglobal/sa/biz/component/interactivedialog/InteractiveDialogUtils$show$1$1$sheetClickLis$1", "Lcom/didiglobal/sa/biz/component/xengine/commit/SAXEngineCommitUtil$RouterFinishedListener;", "onRouterFinished", "", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.interactivedialog.InteractiveDialogUtils$show$1$1$sheetClickLis$1 */
/* compiled from: InteractiveDialogUtils.kt */
public final class InteractiveDialogUtils$show$1$1$sheetClickLis$1 implements SAXEngineCommitUtil.RouterFinishedListener {
    final /* synthetic */ LEGODrawer $legoDrawer;
    final /* synthetic */ ButtonModel $model;

    InteractiveDialogUtils$show$1$1$sheetClickLis$1(ButtonModel buttonModel, LEGODrawer lEGODrawer) {
        this.$model = buttonModel;
        this.$legoDrawer = lEGODrawer;
    }

    public void onRouterFinished() {
        if (this.$model.nodismiss != 1) {
            this.$legoDrawer.dismiss();
        }
    }
}
