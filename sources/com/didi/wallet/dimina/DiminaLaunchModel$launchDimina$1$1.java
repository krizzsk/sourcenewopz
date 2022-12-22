package com.didi.wallet.dimina;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.Dimina;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DiminaLaunchModel.kt */
final class DiminaLaunchModel$launchDimina$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ DMConfig $config;
    final /* synthetic */ DMNavigator $mDMNavigator;
    final /* synthetic */ Fragment $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiminaLaunchModel$launchDimina$1$1(Fragment fragment, DMConfig dMConfig, DMNavigator dMNavigator) {
        super(1);
        this.$this_apply = fragment;
        this.$config = dMConfig;
        this.$mDMNavigator = dMNavigator;
    }

    public /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        FragmentActivity activity = this.$this_apply.getActivity();
        if (activity != null) {
            DMConfig dMConfig = this.$config;
            DMNavigator dMNavigator = this.$mDMNavigator;
            if (z) {
                Dimina.launch(activity, dMConfig, dMNavigator);
            } else {
                dMNavigator.closePage();
            }
        }
    }
}
