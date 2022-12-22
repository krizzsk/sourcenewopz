package com.didi.dimina.container.secondparty.bundle.strategy;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.secondparty.bundle.PmInstallManager;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.bean.InstallModuleFileDescribe;
import com.didi.dimina.container.secondparty.bundle.strategy.InstallTask;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.secondparty.bundle.util.ReleaseBundleDataAdapter;
import com.didi.dimina.container.secondparty.util.Trace4DiUtil;
import com.didi.dimina.container.util.LogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J*\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"com/didi/dimina/container/secondparty/bundle/strategy/ReleaseBundleMangerStrategy$install$1", "Lcom/didi/dimina/container/secondparty/bundle/PmInstallManager$DmInstallCallBack;", "isLocalDone", "", "isRemoteDone", "isSubPreDone", "onLocalInstall", "", "errorCode", "", "localConfigBean", "Lcom/didi/dimina/container/secondparty/bundle/bean/DMConfigBean;", "extraInfo", "Lcom/didi/dimina/container/secondparty/bundle/PmInstallManager$InstallExtraInfo;", "onRemoteInstall", "remoteConfigBean", "onSubPreInstall", "subPreTasks", "", "Lcom/didi/dimina/container/secondparty/bundle/bean/InstallModuleFileDescribe;", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ReleaseBundleMangerStrategy.kt */
public final class ReleaseBundleMangerStrategy$install$1 implements PmInstallManager.DmInstallCallBack {
    final /* synthetic */ String $jsAppId;
    final /* synthetic */ DMMina $mina;
    final /* synthetic */ int $minaIndex;
    final /* synthetic */ long $startTime;
    private boolean isLocalDone;
    private boolean isRemoteDone;
    private boolean isSubPreDone;

    ReleaseBundleMangerStrategy$install$1(long j, String str, DMMina dMMina, int i) {
        this.$startTime = j;
        this.$jsAppId = str;
        this.$mina = dMMina;
        this.$minaIndex = i;
    }

    public void onLocalInstall(int i, DMConfigBean dMConfigBean, PmInstallManager.InstallExtraInfo installExtraInfo) {
        Intrinsics.checkParameterIsNotNull(dMConfigBean, "localConfigBean");
        LogUtil.eRelease(ReleaseBundleMangerStrategy.TAG, "install回调 onLocalInstall() -> errorCode=" + PckErrCode.code2Msg(i) + "\t耗时:" + (System.currentTimeMillis() - this.$startTime) + "\t extraInfo=" + installExtraInfo + " +  localConfigBean=" + dMConfigBean);
        synchronized (ReleaseBundleMangerStrategy.class) {
            if (ReleaseBundleMangerStrategy.Companion.getMPmInstallTaskMap().containsKey(this.$jsAppId)) {
                InstallTask installTask = ReleaseBundleMangerStrategy.Companion.getMPmInstallTaskMap().get(this.$jsAppId);
                if (installTask != null) {
                    InstallTask.Result result = new InstallTask.Result();
                    if (i == 0) {
                        result.jsAppVersion = ReleaseBundleDataAdapter.dmConfigBean2JsAppDmBundleConfig(dMConfigBean);
                        result.jsSdkVersion = ReleaseBundleDataAdapter.dmConfigBean2JsSdkBundleConfig(this.$mina, dMConfigBean);
                    } else {
                        LogUtil.eRelease(ReleaseBundleMangerStrategy.TAG, i + " 本地安装回调失败 ->" + installExtraInfo);
                        StringBuilder sb = new StringBuilder();
                        sb.append("本地安装回调失败 ->");
                        sb.append(installExtraInfo);
                        Trace4DiUtil.tracePmException("", i, sb.toString());
                    }
                    installTask.setLocal(result);
                }
                this.isLocalDone = true;
            }
            if (this.isLocalDone && this.isRemoteDone && this.isSubPreDone) {
                ReleaseBundleMangerStrategy.Companion.getMPmInstallTaskMap().remove(this.$jsAppId);
            }
            Unit unit = Unit.INSTANCE;
        }
        if (i == 0) {
            Trace4DiUtil.trackMainPackageDownloadLocalSuccess(this.$minaIndex, dMConfigBean.getAppVersionCode(), dMConfigBean.getSdkVersionCode(), dMConfigBean.getAppId(), dMConfigBean.getSdkId(this.$mina));
            return;
        }
        Trace4DiUtil.trackMainPackageDownloadLocalFail(this.$minaIndex, i, dMConfigBean.getAppVersionCode(), dMConfigBean.getSdkVersionCode(), dMConfigBean.getAppId(), dMConfigBean.getSdkId(this.$mina));
    }

    public void onRemoteInstall(int i, DMConfigBean dMConfigBean, PmInstallManager.InstallExtraInfo installExtraInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        LogUtil.iRelease(ReleaseBundleMangerStrategy.TAG, "install回调  onRemoteInstall() -> errorCode=" + PckErrCode.code2Msg(i) + "\t耗时:" + (System.currentTimeMillis() - this.$startTime) + "\t extraInfo=" + installExtraInfo + "\t remoteConfigBean=" + dMConfigBean);
        synchronized (ReleaseBundleMangerStrategy.class) {
            if (ReleaseBundleMangerStrategy.Companion.getMPmInstallTaskMap().containsKey(this.$jsAppId)) {
                InstallTask installTask = ReleaseBundleMangerStrategy.Companion.getMPmInstallTaskMap().get(this.$jsAppId);
                if (installTask != null) {
                    InstallTask.Result result = new InstallTask.Result();
                    if (i == 0) {
                        result.jsAppVersion = ReleaseBundleDataAdapter.dmConfigBean2JsAppDmBundleConfig(dMConfigBean);
                        result.jsSdkVersion = ReleaseBundleDataAdapter.dmConfigBean2JsSdkBundleConfig(this.$mina, dMConfigBean);
                    } else {
                        LogUtil.eRelease(ReleaseBundleMangerStrategy.TAG, i + " remote安装回调失败 ->" + installExtraInfo);
                        StringBuilder sb = new StringBuilder();
                        sb.append("remote安装回调失败 ->");
                        sb.append(installExtraInfo);
                        Trace4DiUtil.tracePmException("", i, sb.toString());
                    }
                    installTask.setRemote(result);
                }
                this.isRemoteDone = true;
            }
            if (this.isLocalDone && this.isRemoteDone && this.isSubPreDone) {
                ReleaseBundleMangerStrategy.Companion.getMPmInstallTaskMap().remove(this.$jsAppId);
            }
            if (i == 0) {
                int i2 = this.$minaIndex;
                String str5 = null;
                String appVersionCode = dMConfigBean != null ? dMConfigBean.getAppVersionCode() : null;
                String sdkVersionCode = dMConfigBean != null ? dMConfigBean.getSdkVersionCode() : null;
                String appId = dMConfigBean != null ? dMConfigBean.getAppId() : null;
                if (dMConfigBean != null) {
                    str5 = dMConfigBean.getSdkId(this.$mina);
                }
                Trace4DiUtil.trackMainPackageDownloadRemoteSuccess(i2, appVersionCode, sdkVersionCode, appId, str5);
            } else {
                int i3 = this.$minaIndex;
                if (dMConfigBean == null) {
                    str = "";
                } else {
                    str = dMConfigBean.getAppVersionCode();
                }
                String str6 = str;
                if (dMConfigBean == null) {
                    str2 = "";
                } else {
                    str2 = dMConfigBean.getSdkVersionCode();
                }
                String str7 = str2;
                if (dMConfigBean == null) {
                    str3 = "";
                } else {
                    str3 = dMConfigBean.getAppId();
                }
                String str8 = str3;
                if (dMConfigBean == null) {
                    str4 = "";
                } else {
                    str4 = dMConfigBean.getSdkId(this.$mina);
                }
                Trace4DiUtil.trackMainPackageDownloadRemoteFail(i3, i, str6, str7, str8, str4);
                Trace4DiUtil.newTraceForceUpdateErrorEnd(this.$mina, this.$jsAppId, i, "发生异常");
            }
            Unit unit = Unit.INSTANCE;
        }
        if (i != 0) {
            Trace4DiUtil.tracePmException("", i, "远程安装回调失败 -> " + installExtraInfo);
        }
    }

    public void onSubPreInstall(int i, List<? extends InstallModuleFileDescribe> list, PmInstallManager.InstallExtraInfo installExtraInfo) {
        LogUtil.iRelease(ReleaseBundleMangerStrategy.TAG, "install回调  onSubPreInstall() -> errorCode=" + PckErrCode.code2Msg(i) + "\t extraInfo=" + installExtraInfo + "\t subPreTasks=" + list);
        synchronized (ReleaseBundleMangerStrategy.class) {
            if (ReleaseBundleMangerStrategy.Companion.getMPmInstallTaskMap().containsKey(this.$jsAppId)) {
                InstallTask installTask = ReleaseBundleMangerStrategy.Companion.getMPmInstallTaskMap().get(this.$jsAppId);
                if (installTask != null) {
                    InstallTask.Result result = new InstallTask.Result();
                    if (i != 0) {
                        LogUtil.eRelease(ReleaseBundleMangerStrategy.TAG, i + " subPre安装回调失败 ->" + installExtraInfo);
                        StringBuilder sb = new StringBuilder();
                        sb.append("subPre安装回调失败 ->");
                        sb.append(installExtraInfo);
                        Trace4DiUtil.tracePmException("", i, sb.toString());
                    }
                    installTask.setSubPre(result);
                }
                this.isSubPreDone = true;
            }
            if (this.isLocalDone && this.isRemoteDone && this.isSubPreDone) {
                ReleaseBundleMangerStrategy.Companion.getMPmInstallTaskMap().remove(this.$jsAppId);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
