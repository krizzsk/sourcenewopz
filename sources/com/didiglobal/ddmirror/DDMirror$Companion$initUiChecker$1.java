package com.didiglobal.ddmirror;

import com.didiglobal.ddmirror.uichecker.UiChecker;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: DDMirror.kt */
final class DDMirror$Companion$initUiChecker$1 implements Runnable {
    final /* synthetic */ String $config;
    final /* synthetic */ IDDMirrorInitCallback $initCallback;

    DDMirror$Companion$initUiChecker$1(String str, IDDMirrorInitCallback iDDMirrorInitCallback) {
        this.$config = str;
        this.$initCallback = iDDMirrorInitCallback;
    }

    public final void run() {
        UiChecker.Companion.initFromString(this.$config, this.$initCallback);
    }
}
