package com.didi.dimina.starbox;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.mina.DefaultDMNavigator;
import com.didi.dimina.container.secondparty.DMConfig4Di;
import com.didi.dimina.container.secondparty.Dimina4Di;
import com.didi.dimina.container.secondparty.bundle.strategy.ReleaseBundleMangerStrategy;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0002\b\tB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0002¨\u0006\n"}, mo175978d2 = {"Lcom/didi/dimina/starbox/StarBoxActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "startDiminaRelease", "Companion", "DMNavigator", "starbox_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: StarBoxActivity.kt */
public final class StarBoxActivity extends FragmentActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "StarBoxActivity";

    /* renamed from: a */
    private HashMap f17994a;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f17994a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f17994a == null) {
            this.f17994a = new HashMap();
        }
        View view = (View) this.f17994a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f17994a.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/dimina/starbox/StarBoxActivity$Companion;", "", "()V", "TAG", "", "start", "", "context", "Landroid/content/Context;", "starbox_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: StarBoxActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intent intent = new Intent(context, StarBoxActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        super.onCreate(bundle);
        m13456a();
    }

    /* renamed from: a */
    private final void m13456a() {
        String str;
        DMConfig4Di dMConfig4Di = new DMConfig4Di(this);
        DMConfig4Di.LaunchConfig launchConfig = dMConfig4Di.getLaunchConfig();
        if (launchConfig != null) {
            launchConfig.setBundleManagerStrategy(new ReleaseBundleMangerStrategy());
            Dimina.Config config = Dimina.getConfig();
            if (!(config instanceof Dimina4Di.Config)) {
                config = null;
            }
            Dimina4Di.Config config2 = (Dimina4Di.Config) config;
            if (config2 == null || (str = config2.getStarBoxAppId()) == null) {
                str = StarBox.starBoxAppId;
            }
            launchConfig.setAppId(str);
            launchConfig.setEngineFactory(new StarBoxActivity$startDiminaRelease$1$1());
        }
        Dimina.launch(this, dMConfig4Di, new DMNavigator(getSupportFragmentManager(), 16908290));
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/dimina/starbox/StarBoxActivity$DMNavigator;", "Lcom/didi/dimina/container/mina/DefaultDMNavigator;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "containerViewId", "", "(Lcom/didi/dimina/starbox/StarBoxActivity;Landroidx/fragment/app/FragmentManager;I)V", "closeDimina", "", "navigateBack", "minaIndex", "stackIndex", "popCount", "starbox_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: StarBoxActivity.kt */
    public final class DMNavigator extends DefaultDMNavigator {
        public DMNavigator(FragmentManager fragmentManager, int i) {
            super(fragmentManager, i);
        }

        public boolean navigateBack(int i, int i2, int i3) {
            boolean navigateBack = super.navigateBack(i, i2, i3);
            if (this.mPageStack.isEmpty() || DMMinaPool.size() == 0) {
                StarBoxActivity.this.finish();
            }
            return navigateBack;
        }

        public boolean closeDimina() {
            boolean closeDimina = super.closeDimina();
            if (this.mPageStack.isEmpty() || DMMinaPool.size() == 0) {
                StarBoxActivity.this.finish();
            }
            return closeDimina;
        }
    }
}
