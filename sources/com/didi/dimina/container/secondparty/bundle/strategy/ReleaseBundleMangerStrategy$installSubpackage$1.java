package com.didi.dimina.container.secondparty.bundle.strategy;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.bean.AppInfo;
import com.didi.dimina.container.mina.DMMinaPerformance;
import com.didi.dimina.container.secondparty.bundle.PmSubModuleReadManager;
import com.didi.dimina.container.secondparty.bundle.bean.PreloadTask;
import com.didi.dimina.container.secondparty.util.Trace4DiUtil;
import com.didi.dimina.container.util.LogUtil;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/dimina/container/secondparty/bundle/strategy/ReleaseBundleMangerStrategy$installSubpackage$1", "Lcom/didi/dimina/container/secondparty/bundle/PmSubModuleReadManager$SubModuleInstallCallBack;", "onModuleInstall", "", "errorCode", "", "installCbConfig", "Lcom/didi/dimina/container/secondparty/bundle/PmSubModuleReadManager$SubModuleInstallCbConfig;", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ReleaseBundleMangerStrategy.kt */
public final class ReleaseBundleMangerStrategy$installSubpackage$1 implements PmSubModuleReadManager.SubModuleInstallCallBack {
    final /* synthetic */ BundleManagerStrategy.SubpackageInfoCallback $callback;
    final /* synthetic */ DMMina $dmMina;
    final /* synthetic */ boolean $isPreload;
    final /* synthetic */ String $mapKey;
    final /* synthetic */ String $moduleName;
    final /* synthetic */ ReleaseBundleMangerStrategy this$0;

    ReleaseBundleMangerStrategy$installSubpackage$1(ReleaseBundleMangerStrategy releaseBundleMangerStrategy, String str, String str2, DMMina dMMina, boolean z, BundleManagerStrategy.SubpackageInfoCallback subpackageInfoCallback) {
        this.this$0 = releaseBundleMangerStrategy;
        this.$moduleName = str;
        this.$mapKey = str2;
        this.$dmMina = dMMina;
        this.$isPreload = z;
        this.$callback = subpackageInfoCallback;
    }

    public void onModuleInstall(int i, PmSubModuleReadManager.SubModuleInstallCbConfig subModuleInstallCbConfig) {
        LogUtil.iRelease(ReleaseBundleMangerStrategy.TAG, this.$moduleName + "\t errorCode=" + i + " 分包下载结果 =" + subModuleInstallCbConfig);
        CopyOnWriteArrayList copyOnWriteArrayList = ReleaseBundleMangerStrategy.Companion.getMSubPackageCallbackMap().get(this.$mapKey);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            String str = null;
            if (i == 0) {
                AppInfo.ModuleInfo moduleInfo = new AppInfo.ModuleInfo();
                moduleInfo.dirPath = subModuleInstallCbConfig != null ? subModuleInstallCbConfig.filePath : null;
                moduleInfo.moduleName = this.$moduleName;
                if (subModuleInstallCbConfig != null) {
                    str = subModuleInstallCbConfig.jsVersion;
                }
                moduleInfo.version = str;
                LogUtil.iRelease(ReleaseBundleMangerStrategy.TAG, "回调的结果是" + moduleInfo);
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    ((BundleManagerStrategy.SubpackageInfoCallback) it.next()).callback(0, moduleInfo);
                }
            } else {
                LogUtil.eRelease(ReleaseBundleMangerStrategy.TAG, "结果 失败了 errorCode=" + i);
                Iterator it2 = copyOnWriteArrayList.iterator();
                while (it2.hasNext()) {
                    ((BundleManagerStrategy.SubpackageInfoCallback) it2.next()).callback(i, (AppInfo.ModuleInfo) null);
                }
            }
        }
        ReleaseBundleMangerStrategy.Companion.getMSubPackageCallbackMap().remove(this.$mapKey);
        if (i == 0) {
            int minaIndex = this.$dmMina.getMinaIndex();
            String str2 = this.$moduleName;
            DMMinaPerformance performance = this.$dmMina.getPerformance();
            Intrinsics.checkExpressionValueIsNotNull(performance, "dmMina.performance");
            Trace4DiUtil.trackSubPackageDownloadResult(minaIndex, true, str2, 0, !performance.isFirstDomReady());
        } else {
            int minaIndex2 = this.$dmMina.getMinaIndex();
            String str3 = this.$moduleName;
            DMMinaPerformance performance2 = this.$dmMina.getPerformance();
            Intrinsics.checkExpressionValueIsNotNull(performance2, "dmMina.performance");
            Trace4DiUtil.trackSubPackageDownloadResult(minaIndex2, false, str3, i, !performance2.isFirstDomReady());
            Trace4DiUtil.tracePmException("", i, "安装子包回调失败");
        }
        if (this.$isPreload && i == -149) {
            ReleaseBundleMangerStrategy.Companion.getMPreloadTaskQueue().offer(new PreloadTask(this.$isPreload, this.$dmMina, this.$moduleName, this.$callback));
            LogUtil.iRelease(ReleaseBundleMangerStrategy.TAG, "预加载任务：" + this.$mapKey + " 被取消，mPreloadTaskQueue = " + ReleaseBundleMangerStrategy.Companion.getMPreloadTaskQueue());
        }
        if (!this.$isPreload && !ReleaseBundleMangerStrategy.Companion.getMPreloadTaskQueue().isEmpty()) {
            LogUtil.iRelease(ReleaseBundleMangerStrategy.TAG, "加载子包完成，重新加载预加载队列");
            for (PreloadTask poll = ReleaseBundleMangerStrategy.Companion.getMPreloadTaskQueue().poll(); poll != null; poll = ReleaseBundleMangerStrategy.Companion.getMPreloadTaskQueue().poll()) {
                LogUtil.iRelease(ReleaseBundleMangerStrategy.TAG, "预加载任务 " + poll.moduleName + " 重新启动");
                this.this$0.installSubpackage(poll.isPreload, poll.dmMina, poll.moduleName, poll.callback);
            }
        }
    }
}
