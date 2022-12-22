package com.didiglobal.scan.view.fragment;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.scan.data.ManualInputInfo;
import com.didiglobal.scan.data.ManualInputInfoItem;
import com.didiglobal.scan.delegate.ViewClickDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: QrCodeScanFragment.kt */
final class QrCodeScanFragment$initListener$5 implements View.OnClickListener {
    final /* synthetic */ QrCodeScanFragment this$0;

    QrCodeScanFragment$initListener$5(QrCodeScanFragment qrCodeScanFragment) {
        this.this$0 = qrCodeScanFragment;
    }

    public final void onClick(View view) {
        ArrayList<ManualInputInfoItem> infoList;
        ViewClickDelegate viewClickDelegate;
        AutoTrackHelper.trackViewOnClick(view);
        ManualInputInfo inputInfo = this.this$0.getInputInfo();
        if (inputInfo != null && (infoList = inputInfo.getInfoList()) != null && !infoList.isEmpty()) {
            ManualInputInfoItem manualInputInfoItem = infoList.get(0);
            Intrinsics.checkExpressionValueIsNotNull(manualInputInfoItem, "it[0]");
            ManualInputInfoItem manualInputInfoItem2 = manualInputInfoItem;
            ServiceLoader<S> load = ServiceLoader.load(ViewClickDelegate.class, manualInputInfoItem2.getActionType());
            if (load != null && (viewClickDelegate = (ViewClickDelegate) load.get()) != null) {
                viewClickDelegate.onEnterPinClick(manualInputInfoItem2.getScheme());
            }
        }
    }
}
