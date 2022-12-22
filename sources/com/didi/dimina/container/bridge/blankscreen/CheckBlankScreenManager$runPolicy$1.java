package com.didi.dimina.container.bridge.blankscreen;

import android.view.View;
import android.widget.Toast;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.mina.ITask;
import com.didi.dimina.container.service.WsgService;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, mo175978d2 = {"com/didi/dimina/container/bridge/blankscreen/CheckBlankScreenManager$runPolicy$1", "Lcom/didi/dimina/container/mina/ITask;", "", "onComplete", "", "result", "(Ljava/lang/Float;)V", "runTaskInBackground", "()Ljava/lang/Float;", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CheckBlankScreenManager.kt */
public final class CheckBlankScreenManager$runPolicy$1 implements ITask<Float> {
    final /* synthetic */ DMConfig.BlankScreenConfig $config;
    final /* synthetic */ int $currentTimes;
    final /* synthetic */ View $view;
    final /* synthetic */ CheckBlankScreenManager this$0;

    CheckBlankScreenManager$runPolicy$1(CheckBlankScreenManager checkBlankScreenManager, int i, DMConfig.BlankScreenConfig blankScreenConfig, View view) {
        this.this$0 = checkBlankScreenManager;
        this.$currentTimes = i;
        this.$config = blankScreenConfig;
        this.$view = view;
    }

    public Float runTaskInBackground() {
        if (this.this$0.isQuit()) {
            this.this$0.m12311a("runTaskInBackground 页面退出检测完毕");
            return Float.valueOf(0.0f);
        }
        this.this$0.f16689f = System.currentTimeMillis();
        this.this$0.f16690g = true;
        CheckBlankScreenManager checkBlankScreenManager = this.this$0;
        StringBuilder sb = new StringBuilder();
        sb.append("runTaskInBackground  开始在线程：");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append("：中进行 第 ");
        sb.append(this.this$0.m12315b(this.$currentTimes));
        sb.append(" 次检测");
        checkBlankScreenManager.m12311a(sb.toString());
        int vCount = this.$config.getVCount();
        double d = (double) 0;
        if (this.$config.getHorizontalRate() > d) {
            Dimina.Config config = Dimina.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
            Dimina.AdapterConfig adapterConfig = config.getAdapterConfig();
            Intrinsics.checkExpressionValueIsNotNull(adapterConfig, "Dimina.getConfig().adapterConfig");
            WsgService wsgService = adapterConfig.getWsgService();
            Dimina.Config config2 = Dimina.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config2, "Dimina.getConfig()");
            vCount = (int) (((double) wsgService.getScreenWidth(config2.getApp())) * this.$config.getHorizontalRate());
        }
        int hCount = this.$config.getHCount();
        if (this.$config.getVerticalRate() > d) {
            Dimina.Config config3 = Dimina.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config3, "Dimina.getConfig()");
            Dimina.AdapterConfig adapterConfig2 = config3.getAdapterConfig();
            Intrinsics.checkExpressionValueIsNotNull(adapterConfig2, "Dimina.getConfig().adapterConfig");
            WsgService wsgService2 = adapterConfig2.getWsgService();
            Dimina.Config config4 = Dimina.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config4, "Dimina.getConfig()");
            hCount = (int) (((double) wsgService2.getScreenHeight(config4.getApp())) * this.$config.getVerticalRate());
        }
        CheckBlankScreenManager checkBlankScreenManager2 = this.this$0;
        checkBlankScreenManager2.m12311a("实际采样的点数为 vertical:" + vCount + ",  horzontial:" + hCount);
        float colorRate = CheckViewColorTool.colorRate(this.$view, vCount, hCount);
        this.this$0.f16690g = false;
        return Float.valueOf(colorRate);
    }

    public void onComplete(Float f) {
        DMMina access$getDmMina$p;
        if (this.this$0.isQuit()) {
            this.this$0.m12311a("onComplete页面退出检测完毕");
        } else if (f != null) {
            f.floatValue();
            if (((double) f.floatValue()) >= this.$config.getRate()) {
                this.this$0.m12310a(this.$config, this.$currentTimes, 1, f.floatValue());
                this.this$0.m12308a(this.$currentTimes, this.$view, this.$config);
                Dimina.Config config = Dimina.getConfig();
                Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
                if (config.isDebug() && (access$getDmMina$p = this.this$0.f16686c) != null) {
                    SystemUtils.showToast(Toast.makeText(access$getDmMina$p.getActivity(), "监测到页面白屏(仅Debug包出现该提示)", 0));
                    return;
                }
                return;
            }
            View view = this.$view;
            if (!(view instanceof WebViewEngine)) {
                this.this$0.m12310a(this.$config, this.$currentTimes, -1, f.floatValue());
            } else if (this.this$0.m12314a((WebViewEngine) view, this.$config)) {
                this.this$0.checkIsSkeletonShow((WebViewEngine) this.$view, this.$config, this.$currentTimes, f.floatValue());
            } else {
                this.this$0.m12310a(this.$config, this.$currentTimes, -1, f.floatValue());
            }
        } else {
            this.this$0.m12311a("onComplete  result==null 出现异常数据 检测完毕");
        }
    }
}
