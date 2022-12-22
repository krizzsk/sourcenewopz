package com.didiglobal.scan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.didiglobal.scan.data.ManualInputInfo;
import com.didiglobal.scan.data.ManualInputInfoItem;
import com.didiglobal.scan.view.activity.GlobalScanActivity;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ.\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0014"}, mo175978d2 = {"Lcom/didiglobal/scan/GlobalScan;", "", "()V", "getScanExtra", "Landroid/os/Bundle;", "from", "Lcom/didiglobal/scan/GlobalScan$ScanFrom;", "userType", "", "inputInfoList", "", "Lcom/didiglobal/scan/data/ManualInputInfoItem;", "start", "", "context", "Landroid/content/Context;", "transStrToForm", "fromStr", "", "ScanFrom", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: GlobalScan.kt */
public final class GlobalScan {
    public static final GlobalScan INSTANCE = new GlobalScan();

    private GlobalScan() {
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo175978d2 = {"Lcom/didiglobal/scan/GlobalScan$ScanFrom;", "", "from", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "INDEX", "SIDEBAR", "WALLET", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: GlobalScan.kt */
    public enum ScanFrom {
        INDEX("index"),
        SIDEBAR("sidebar"),
        WALLET("wallet");
        
        private final String from;

        private ScanFrom(String str) {
            this.from = str;
        }

        public final String getFrom() {
            return this.from;
        }
    }

    public final ScanFrom transStrToForm(String str) {
        Intrinsics.checkParameterIsNotNull(str, "fromStr");
        if (Intrinsics.areEqual((Object) str, (Object) ScanFrom.INDEX.getFrom())) {
            return ScanFrom.INDEX;
        }
        if (Intrinsics.areEqual((Object) str, (Object) ScanFrom.SIDEBAR.getFrom())) {
            return ScanFrom.SIDEBAR;
        }
        if (Intrinsics.areEqual((Object) str, (Object) ScanFrom.WALLET.getFrom())) {
            return ScanFrom.WALLET;
        }
        return ScanFrom.INDEX;
    }

    public final void start(ScanFrom scanFrom, Context context, int i, List<ManualInputInfoItem> list) {
        Intrinsics.checkParameterIsNotNull(scanFrom, "from");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intent intent = new Intent(context, GlobalScanActivity.class);
        intent.putExtra("key_from", scanFrom.getFrom());
        intent.putExtra(GlobalScanActivity.KEY_USERTYPE, i);
        ManualInputInfo manualInputInfo = new ManualInputInfo();
        if (list != null) {
            Collection collection = list;
            if (!collection.isEmpty()) {
                manualInputInfo.getInfoList().addAll(collection);
            }
        }
        intent.putExtra(GlobalScanActivity.KEY_INPUT_INFO, manualInputInfo);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public final Bundle getScanExtra(ScanFrom scanFrom, int i, List<ManualInputInfoItem> list) {
        Intrinsics.checkParameterIsNotNull(scanFrom, "from");
        Bundle bundle = new Bundle();
        bundle.putString("key_from", scanFrom.getFrom());
        bundle.putInt(GlobalScanActivity.KEY_USERTYPE, i);
        ManualInputInfo manualInputInfo = new ManualInputInfo();
        if (list != null) {
            Collection collection = list;
            if (!collection.isEmpty()) {
                manualInputInfo.getInfoList().addAll(collection);
            }
        }
        bundle.putSerializable(GlobalScanActivity.KEY_INPUT_INFO, manualInputInfo);
        return bundle;
    }
}
