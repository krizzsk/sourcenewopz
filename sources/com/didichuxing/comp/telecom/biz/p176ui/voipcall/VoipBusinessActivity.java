package com.didichuxing.comp.telecom.biz.p176ui.voipcall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.comp.telecom.biz.p176ui.base.ATelecomActivity;
import com.didichuxing.comp.telecom.biz.p176ui.view.StatusBarUtil;
import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\u000b"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipBusinessActivity;", "Lcom/didichuxing/comp/telecom/biz/ui/base/ATelecomActivity;", "()V", "genFragment", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipBusinessFragment;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.VoipBusinessActivity */
/* compiled from: VoipBusinessActivity.kt */
public final class VoipBusinessActivity extends ATelecomActivity {
    public static final int ACTION_CALL_INCOME = 3;
    public static final int ACTION_MAKE_CALL = 2;
    public static final int ACTION_TRY_RESUME = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_ACTION = "call_action";
    public static final String KEY_VOIP_DATA = "voip_data";

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ \u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipBusinessActivity$Companion;", "", "()V", "ACTION_CALL_INCOME", "", "ACTION_MAKE_CALL", "ACTION_TRY_RESUME", "KEY_ACTION", "", "KEY_VOIP_DATA", "buildIncomeIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "model", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "buildResumeIntent", "openPage", "", "action", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
    /* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.VoipBusinessActivity$Companion */
    /* compiled from: VoipBusinessActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void openPage$default(Companion companion, Context context, VoipCallModel voipCallModel, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = 1;
            }
            companion.openPage(context, voipCallModel, i);
        }

        public final void openPage(Context context, VoipCallModel voipCallModel, int i) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(voipCallModel, "model");
            Intent intent = new Intent(context, VoipBusinessActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(VoipBusinessActivity.KEY_VOIP_DATA, voipCallModel);
            intent.putExtra(VoipBusinessActivity.KEY_ACTION, i);
            context.startActivity(intent);
        }

        public static /* synthetic */ Intent buildIncomeIntent$default(Companion companion, Context context, VoipCallModel voipCallModel, int i, Object obj) {
            if ((i & 2) != 0) {
                voipCallModel = null;
            }
            return companion.buildIncomeIntent(context, voipCallModel);
        }

        public final Intent buildIncomeIntent(Context context, VoipCallModel voipCallModel) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intent intent = new Intent(context, VoipBusinessActivity.class);
            intent.setFlags(268435456);
            if (voipCallModel != null) {
                intent.putExtra(VoipBusinessActivity.KEY_VOIP_DATA, voipCallModel);
            }
            intent.putExtra(VoipBusinessActivity.KEY_ACTION, 3);
            return intent;
        }

        public static /* synthetic */ Intent buildResumeIntent$default(Companion companion, Context context, VoipCallModel voipCallModel, int i, Object obj) {
            if ((i & 2) != 0) {
                voipCallModel = null;
            }
            return companion.buildResumeIntent(context, voipCallModel);
        }

        public final Intent buildResumeIntent(Context context, VoipCallModel voipCallModel) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intent intent = new Intent(context, VoipBusinessActivity.class);
            intent.setFlags(268435456);
            if (voipCallModel != null) {
                intent.putExtra(VoipBusinessActivity.KEY_VOIP_DATA, voipCallModel);
            }
            intent.putExtra(VoipBusinessActivity.KEY_ACTION, 1);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public VoipBusinessFragment genFragment() {
        return new VoipBusinessFragment();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        getWindow().addFlags(128);
        StatusBarUtil.immerse(this, false);
    }

    public void onBackPressed() {
        Fragment mFragment = getMFragment();
        if (!(mFragment instanceof VoipBusinessFragment)) {
            mFragment = null;
        }
        VoipBusinessFragment voipBusinessFragment = (VoipBusinessFragment) mFragment;
        if (voipBusinessFragment == null || !voipBusinessFragment.onBackPressed()) {
            super.onBackPressed();
        }
    }
}
