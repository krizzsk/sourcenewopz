package com.didi.dimina.container.secondparty.bundle.strategy;

import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.bean.BundleConfig;
import java.util.ArrayList;
import java.util.List;

public class InstallTask {

    /* renamed from: a */
    private final List<BundleManagerStrategy.InstallCallback> f17094a = new ArrayList();
    public Result local = null;
    public Result remote = null;
    public Result subPre = null;

    public static class Result {
        public BundleConfig jsAppVersion;
        public BundleConfig jsSdkVersion;
    }

    public void recordCallback(BundleManagerStrategy.InstallCallback installCallback) {
        Result result = this.local;
        if (result != null) {
            installCallback.onOriginalPackageInstalled(result.jsAppVersion, this.local.jsSdkVersion);
        }
        Result result2 = this.remote;
        if (result2 != null) {
            installCallback.onUpdateMainPackageInstalled(result2.jsAppVersion, this.remote.jsSdkVersion);
        }
        this.f17094a.add(installCallback);
    }

    public void setLocal(Result result) {
        this.local = result;
        for (BundleManagerStrategy.InstallCallback next : this.f17094a) {
            if (next != null) {
                try {
                    next.onOriginalPackageInstalled(this.local.jsAppVersion, this.local.jsSdkVersion);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setRemote(Result result) {
        this.remote = result;
        for (BundleManagerStrategy.InstallCallback next : this.f17094a) {
            if (next != null) {
                try {
                    next.onUpdateMainPackageInstalled(this.remote.jsAppVersion, this.remote.jsSdkVersion);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setSubPre(Result result) {
        this.subPre = result;
        for (BundleManagerStrategy.InstallCallback next : this.f17094a) {
            if (next != null) {
                try {
                    next.onUpdateSubPackageInstalled(this.subPre.jsAppVersion, this.subPre.jsSdkVersion);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
