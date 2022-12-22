package com.didiglobal.p205sa.biz.component.interactivedialog;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.config.ButtonModel;
import com.didi.global.globalgenerickit.config.GGKConfigCallbackAdapter;
import com.didi.global.globaluikit.dialog.LEGOBaseAlertDialogFragment;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didiglobal.p205sa.biz.component.xengine.commit.SAXEngineCommitUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016JF\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\"\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0018"}, mo175978d2 = {"com/didiglobal/sa/biz/component/interactivedialog/InteractiveDialogPresenter$show$1", "Lcom/didi/global/globalgenerickit/config/GGKConfigCallbackAdapter;", "alertClickLis", "", "nativeAlert", "Lcom/didi/global/globaluikit/dialog/LEGOBaseAlertDialogFragment;", "model", "Lcom/didi/global/globalgenerickit/config/ButtonModel;", "url", "", "alertWillShow", "id", "alertXMLClickLis", "xMLAlert", "ggkData", "Lcom/didi/global/globalgenerickit/GGKData;", "eventType", "params", "", "", "sheetClickLis", "legoDrawer", "Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "sheetWillShow", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.interactivedialog.InteractiveDialogPresenter$show$1 */
/* compiled from: InteractiveDialogPresenter.kt */
public final class InteractiveDialogPresenter$show$1 extends GGKConfigCallbackAdapter {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ InteractiveDialogPresenter this$0;

    InteractiveDialogPresenter$show$1(InteractiveDialogPresenter interactiveDialogPresenter, FragmentActivity fragmentActivity) {
        this.this$0 = interactiveDialogPresenter;
        this.$activity = fragmentActivity;
    }

    public boolean alertWillShow(String str) {
        if (Intrinsics.areEqual((Object) this.this$0.f51013e, (Object) str)) {
            return false;
        }
        InteractiveDialogPresenter interactiveDialogPresenter = this.this$0;
        if (str == null) {
            str = "";
        }
        interactiveDialogPresenter.f51013e = str;
        return true;
    }

    public boolean sheetWillShow(String str) {
        if (Intrinsics.areEqual((Object) this.this$0.f51012d, (Object) str)) {
            return false;
        }
        InteractiveDialogPresenter interactiveDialogPresenter = this.this$0;
        if (str == null) {
            str = "";
        }
        interactiveDialogPresenter.f51012d = str;
        return true;
    }

    public boolean alertXMLClickLis(LEGOBaseAlertDialogFragment lEGOBaseAlertDialogFragment, GGKData gGKData, String str, String str2, Map<String, Object> map) {
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        return super.alertXMLClickLis(lEGOBaseAlertDialogFragment, gGKData, str, str2, map);
    }

    public boolean alertClickLis(LEGOBaseAlertDialogFragment lEGOBaseAlertDialogFragment, ButtonModel buttonModel, String str) {
        Intrinsics.checkNotNullParameter(lEGOBaseAlertDialogFragment, "nativeAlert");
        Intrinsics.checkNotNullParameter(buttonModel, "model");
        SAXEngineCommitUtil.INSTANCE.configRouterSkip(this.$activity, buttonModel, str, new InteractiveDialogPresenter$show$1$alertClickLis$1(buttonModel, lEGOBaseAlertDialogFragment));
        return true;
    }

    public boolean sheetClickLis(LEGODrawer lEGODrawer, ButtonModel buttonModel, String str) {
        Intrinsics.checkNotNullParameter(lEGODrawer, "legoDrawer");
        Intrinsics.checkNotNullParameter(buttonModel, "model");
        SAXEngineCommitUtil.INSTANCE.configRouterSkip(this.$activity, buttonModel, str, new InteractiveDialogPresenter$show$1$sheetClickLis$1(buttonModel, lEGODrawer));
        return true;
    }
}
