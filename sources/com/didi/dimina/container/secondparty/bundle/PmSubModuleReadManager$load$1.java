package com.didi.dimina.container.secondparty.bundle;

import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.secondparty.bundle.util.PmFileUtil;
import com.didi.dimina.container.secondparty.bundle.util.ReleaseBundleDataAdapter;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: PmSubModuleReadManager.kt */
final class PmSubModuleReadManager$load$1 implements Runnable {
    final /* synthetic */ DMMina $dmMina;
    final /* synthetic */ String $moduleName;
    final /* synthetic */ PmSubModuleReadManager this$0;

    PmSubModuleReadManager$load$1(PmSubModuleReadManager pmSubModuleReadManager, DMMina dMMina, String str) {
        this.this$0 = pmSubModuleReadManager;
        this.$dmMina = dMMina;
        this.$moduleName = str;
    }

    public final void run() {
        String str;
        DMConfigBean DMMina2DMConfigBean = ReleaseBundleDataAdapter.DMMina2DMConfigBean(this.$dmMina);
        List<DMConfigBean.AppModulesBean> DMMina2DmConfigBeanAllModulesList = ReleaseBundleDataAdapter.DMMina2DmConfigBeanAllModulesList(DMMina2DMConfigBean);
        LogUtil.iRelease(PmSubModuleReadManager.TAG, "allModuleList.size=" + DMMina2DmConfigBeanAllModulesList.size());
        DMConfigBean.AppModulesBean matchAppModule = PmSubModuleHelper.matchAppModule(DMMina2DmConfigBeanAllModulesList, this.this$0.f17053b);
        if (matchAppModule != null) {
            PmSubModuleReadManager pmSubModuleReadManager = this.this$0;
            Intrinsics.checkExpressionValueIsNotNull(DMMina2DMConfigBean, "dmConfig");
            DMConfigBean.AppModulesBean sdkModule = DMMina2DMConfigBean.getSdkModule();
            Intrinsics.checkExpressionValueIsNotNull(sdkModule, "dmConfig.sdkModule");
            if (TextUtils.equals(sdkModule.getModuleName(), this.$moduleName)) {
                str = DMMina2DMConfigBean.getSdkId(this.$dmMina);
            } else {
                str = DMMina2DMConfigBean.getAppId();
            }
            pmSubModuleReadManager.f17052a = str;
            this.this$0.f17055d = matchAppModule.getVersion();
            String access$getFilePathInFiles$p = this.this$0.m12573a();
            this.this$0.f17057f.filePath = access$getFilePathInFiles$p;
            boolean z = false;
            if (!TextUtils.isEmpty(this.this$0.f17054c)) {
                z = PmFileUtil.isFileExit(access$getFilePathInFiles$p);
            } else if (!CollectionsUtil.isEmpty((Collection) PmFileUtil.childFileInDir(access$getFilePathInFiles$p))) {
                z = true;
            }
            LogUtil.iRelease(PmSubModuleReadManager.TAG, access$getFilePathInFiles$p + " 文件存在？" + z);
            if (z) {
                PmSubModuleReadManager.m12576a(this.this$0, 0, PmFileUtil.read(access$getFilePathInFiles$p), (Throwable) null, 4, (Object) null);
                return;
            }
            this.this$0.m12577a(matchAppModule);
            return;
        }
        PmSubModuleReadManager.m12576a(this.this$0, (int) PckErrCode.SUB_MODULE_NO_CONFIG, (String) null, (Throwable) null, 4, (Object) null);
    }
}
