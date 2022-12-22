package com.didi.dimina.container.secondparty.bundle;

import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didi.dimina.container.secondparty.bundle.util.PmFileHelper;
import com.didi.dimina.container.secondparty.bundle.util.PmFileUtil;
import com.didi.dimina.container.secondparty.bundle.util.ReleaseBundleDataAdapter;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PmSubModuleHelper {
    public static final String TAG = "Dimina-PM PmSubModuleHelper";

    public static DMConfigBean.AppModulesBean matchAppModule(List<DMConfigBean.AppModulesBean> list, String str) {
        DMConfigBean.AppModulesBean appModulesBean = null;
        if (list == null) {
            return null;
        }
        Iterator<DMConfigBean.AppModulesBean> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DMConfigBean.AppModulesBean next = it.next();
            if (TextUtils.equals(next.getModuleName(), str)) {
                appModulesBean = next;
                break;
            }
        }
        if (appModulesBean == null) {
            LogUtil.eRelease(TAG, "listSize=" + CollectionsUtil.getSize((Collection) list) + " 匹配:" + str + "\t 结果: null");
        }
        return appModulesBean;
    }

    public static void isModuleInstalled(DMMina dMMina, String str, String str2, IDMCommonAction<Boolean> iDMCommonAction) {
        LogUtil.iRelease(TAG, "isModuleInstalled() -> " + str + "\t moduleName=" + str2);
        if (matchAppModule(ReleaseBundleDataAdapter.DMMina2DmConfigBeanAllModulesList(dMMina), str2) != null) {
            String filesModuleFilePath = PmFileHelper.getFilesModuleFilePath(dMMina, (Context) Dimina.getConfig().getApp(), str, str2, (String) null);
            LogUtil.iRelease(TAG, "isModuleInstalled() ->  filePath= " + filesModuleFilePath + "\t 子孩子=" + PmFileUtil.childFileInDir(filesModuleFilePath));
            StringBuilder sb = new StringBuilder();
            sb.append(filesModuleFilePath);
            sb.append(File.separator);
            sb.append(PmFileConstant.MODULE_UNZIP_SUCCESS_FLAG);
            String sb2 = sb.toString();
            if (iDMCommonAction != null) {
                iDMCommonAction.callback(Boolean.valueOf(PmFileUtil.isFileExit(sb2)));
                return;
            }
            return;
        }
        iDMCommonAction.callback(false);
        LogUtil.eRelease(TAG, "没有匹配到对应 module");
    }
}
