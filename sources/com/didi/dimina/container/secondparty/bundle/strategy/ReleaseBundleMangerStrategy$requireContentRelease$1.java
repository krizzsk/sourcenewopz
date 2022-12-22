package com.didi.dimina.container.secondparty.bundle.strategy;

import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.secondparty.bundle.PmSubModuleReadManager;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/dimina/container/secondparty/bundle/strategy/ReleaseBundleMangerStrategy$requireContentRelease$1", "Lcom/didi/dimina/container/secondparty/bundle/PmSubModuleReadManager$SubModuleInstallCallBack;", "onModuleInstall", "", "errorCode", "", "installCbConfig", "Lcom/didi/dimina/container/secondparty/bundle/PmSubModuleReadManager$SubModuleInstallCbConfig;", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ReleaseBundleMangerStrategy.kt */
public final class ReleaseBundleMangerStrategy$requireContentRelease$1 implements PmSubModuleReadManager.SubModuleInstallCallBack {
    final /* synthetic */ BundleManagerStrategy.ReadFileCallBack $callback;
    final /* synthetic */ String $jsAppId;
    final /* synthetic */ String $moduleName;
    final /* synthetic */ String $subPath;

    ReleaseBundleMangerStrategy$requireContentRelease$1(String str, String str2, String str3, BundleManagerStrategy.ReadFileCallBack readFileCallBack) {
        this.$jsAppId = str;
        this.$moduleName = str2;
        this.$subPath = str3;
        this.$callback = readFileCallBack;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onModuleInstall(int r8, com.didi.dimina.container.secondparty.bundle.PmSubModuleReadManager.SubModuleInstallCbConfig r9) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "requireContentRelease() -> "
            r0.append(r1)
            java.lang.String r1 = r7.$jsAppId
            r0.append(r1)
            java.lang.String r1 = "\t "
            r0.append(r1)
            java.lang.String r2 = r7.$moduleName
            r0.append(r2)
            r0.append(r1)
            java.lang.String r2 = r7.$subPath
            r0.append(r2)
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "Dimina-PM DmPckMangerStrategy"
            com.didi.dimina.container.util.LogUtil.iRelease(r2, r0)
            com.didi.dimina.container.bundle.BundleManagerStrategy$ReadFileCallBack r0 = r7.$callback
            if (r0 == 0) goto L_0x0099
            r3 = 0
            if (r8 != 0) goto L_0x004b
            r8 = 1
            com.didi.dimina.container.bundle.BundleManagerStrategy$FileInfo r1 = new com.didi.dimina.container.bundle.BundleManagerStrategy$FileInfo
            if (r9 == 0) goto L_0x003f
            java.lang.String r2 = r9.content
            goto L_0x0040
        L_0x003f:
            r2 = r3
        L_0x0040:
            if (r9 == 0) goto L_0x0044
            java.lang.String r3 = r9.filePath
        L_0x0044:
            r1.<init>(r2, r3)
            r0.onRead(r8, r1)
            goto L_0x0099
        L_0x004b:
            r4 = 0
            com.didi.dimina.container.bundle.BundleManagerStrategy$FileInfo r5 = new com.didi.dimina.container.bundle.BundleManagerStrategy$FileInfo
            r6 = 3
            r5.<init>(r3, r3, r6, r3)
            r0.onRead(r4, r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "requireContentRelease() 回调fail-> "
            r0.append(r4)
            java.lang.String r4 = r7.$jsAppId
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r7.$moduleName
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r7.$subPath
            r0.append(r4)
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            com.didi.dimina.container.util.LogUtil.eRelease(r2, r0)
            if (r9 == 0) goto L_0x0085
            java.lang.Throwable r3 = r9.throwable
        L_0x0085:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "requireContentRelease回调失败 ->"
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            com.didi.dimina.container.util.TraceUtil.tracePmException(r3, r8, r9)
        L_0x0099:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.bundle.strategy.ReleaseBundleMangerStrategy$requireContentRelease$1.onModuleInstall(int, com.didi.dimina.container.secondparty.bundle.PmSubModuleReadManager$SubModuleInstallCbConfig):void");
    }
}
