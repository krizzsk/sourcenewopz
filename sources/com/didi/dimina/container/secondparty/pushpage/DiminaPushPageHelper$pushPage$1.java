package com.didi.dimina.container.secondparty.pushpage;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: DiminaPushPageHelper.kt */
final class DiminaPushPageHelper$pushPage$1 implements Runnable {
    final /* synthetic */ String $diminaUrlPath;

    DiminaPushPageHelper$pushPage$1(String str) {
        this.$diminaUrlPath = str;
    }

    public final void run() {
        DMMina access$getCurrentDMMina$p = DiminaPushPageHelper.f17437b;
        if (access$getCurrentDMMina$p != null) {
            String str = this.$diminaUrlPath;
            DMMinaNavigatorDelegate curNavigator = access$getCurrentDMMina$p.getCurNavigator();
            Intrinsics.checkExpressionValueIsNotNull(curNavigator, "curNavigator");
            access$getCurrentDMMina$p.pushPage(str, (JSONObject) null, curNavigator.getIndex());
        }
    }
}
