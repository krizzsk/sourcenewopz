package com.didi.dimina.container.secondparty.bundle;

import android.content.Context;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.secondparty.bundle.strategy.ReleaseBundleMangerStrategy;
import com.didi.dimina.container.secondparty.bundle.util.PmAssetsUtil;
import com.didi.dimina.container.secondparty.bundle.util.PmFileHelper;
import com.didi.dimina.container.secondparty.util.ApolloUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TextUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/PreInstallManager;", "", "()V", "Companion", "Strategy", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PreInstallManager.kt */
public final class PreInstallManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "PreInstallManager";

    /* renamed from: a */
    private static final long f17062a = 86400000;

    @JvmStatic
    public static final Strategy checkStrategy(DMConfig dMConfig) {
        return Companion.checkStrategy(dMConfig);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/PreInstallManager$Strategy;", "", "index", "", "(Ljava/lang/String;II)V", "getIndex", "()I", "MISS", "RECENTLY_USED", "NO_BUNDLE", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: PreInstallManager.kt */
    public enum Strategy {
        MISS(0),
        RECENTLY_USED(1),
        NO_BUNDLE(2);
        
        private final int index;

        private Strategy(int i) {
            this.index = i;
        }

        public final int getIndex() {
            return this.index;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/PreInstallManager$Companion;", "", "()V", "ONE_DAY", "", "TAG", "", "checkStrategy", "Lcom/didi/dimina/container/secondparty/bundle/PreInstallManager$Strategy;", "config", "Lcom/didi/dimina/container/DMConfig;", "getInternalDay", "", "isNoBundleEnable", "", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: PreInstallManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Strategy checkStrategy(DMConfig dMConfig) {
            Intrinsics.checkParameterIsNotNull(dMConfig, "config");
            Companion companion = this;
            if (companion.getInternalDay() == 0) {
                return Strategy.MISS;
            }
            DMConfig.LaunchConfig launchConfig = dMConfig.getLaunchConfig();
            ReleaseBundleMangerStrategy releaseBundleMangerStrategy = null;
            String appId = launchConfig != null ? launchConfig.getAppId() : null;
            if (appId == null) {
                return Strategy.MISS;
            }
            MMKVUtil instance = MMKVUtil.getInstance();
            Object obj = instance.get(Constant.KEY_PRE_INSTALL_RECENTLY_USED_JSAPP_PREFIX + appId, Long.MAX_VALUE);
            if (obj != null) {
                long longValue = ((Long) obj).longValue();
                if (System.currentTimeMillis() - longValue < ((long) companion.getInternalDay()) * 86400000 && System.currentTimeMillis() - longValue > 0) {
                    return Strategy.RECENTLY_USED;
                }
                if (!companion.isNoBundleEnable()) {
                    return Strategy.MISS;
                }
                if (!TextUtil.isEmpty(PmFileHelper.readFilesJsAppDmConfig((Context) null, appId, (DMMina) null))) {
                    return Strategy.MISS;
                }
                DMConfig.LaunchConfig launchConfig2 = dMConfig.getLaunchConfig();
                Intrinsics.checkExpressionValueIsNotNull(launchConfig2, "config.launchConfig");
                BundleManagerStrategy bundleManagerStrategy = launchConfig2.getBundleManagerStrategy();
                if (bundleManagerStrategy instanceof ReleaseBundleMangerStrategy) {
                    releaseBundleMangerStrategy = bundleManagerStrategy;
                }
                ReleaseBundleMangerStrategy releaseBundleMangerStrategy2 = releaseBundleMangerStrategy;
                if (releaseBundleMangerStrategy2 != null) {
                    if (TextUtil.isEmpty(releaseBundleMangerStrategy2.getAssetPath())) {
                        return Strategy.NO_BUNDLE;
                    }
                    Dimina.Config config = Dimina.getConfig();
                    Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
                    if (!PmAssetsUtil.isAssetsFilesExist(config.getApp(), releaseBundleMangerStrategy2.getAssetPath() + File.separator + "config.json")) {
                        LogUtil.iRelease(PreInstallManager.TAG, " 预安装策略检测到 本地无底包");
                        return Strategy.NO_BUNDLE;
                    }
                }
                return Strategy.MISS;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
        }

        private final int getInternalDay() {
            int intValue = ((Number) ApolloUtil.Companion.getApolloValue("dimina_saga_predownLoad_config", "valid_days", 30)).intValue();
            LogUtil.iRelease(PreInstallManager.TAG, "Apollo dimina_saga_predownLoad_config, valid_days 得到的值是 " + intValue);
            return intValue;
        }

        private final boolean isNoBundleEnable() {
            int intValue = ((Number) ApolloUtil.Companion.getApolloValue("dimina_saga_predownLoad_config", "not_package_enable", 0)).intValue();
            StringBuilder sb = new StringBuilder();
            sb.append("Apollo dimina_saga_predownLoad_config, not_package_enable 得到的值是 b:");
            sb.append(intValue != 0);
            sb.append(", ret:");
            sb.append(intValue);
            LogUtil.iRelease(PreInstallManager.TAG, sb.toString());
            if (intValue != 0) {
                return true;
            }
            return false;
        }
    }
}
