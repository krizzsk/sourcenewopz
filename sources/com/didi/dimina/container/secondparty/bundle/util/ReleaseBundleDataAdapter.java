package com.didi.dimina.container.secondparty.bundle.util;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bundle.bean.BundleConfig;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.bean.PmAssetModuleBean;
import com.didi.dimina.container.util.TextUtil;
import java.util.ArrayList;
import java.util.List;

public class ReleaseBundleDataAdapter {
    public static final String TAG = "Dimina-PM ReleaseBundleDataAdapter";

    public static BundleConfig dmConfigBean2JsAppDmBundleConfig(DMConfigBean dMConfigBean) {
        if (dMConfigBean == null) {
            return null;
        }
        BundleConfig bundleConfig = new BundleConfig();
        bundleConfig.appId = dMConfigBean.getAppId();
        bundleConfig.versionCode = dMConfigBean.getAppVersionCode();
        bundleConfig.versionName = dMConfigBean.getAppVersionName();
        bundleConfig.updateStrategy = dMConfigBean.getUpdateStrategy();
        bundleConfig.extraInfo = PmJsonUtil.toString(dMConfigBean);
        return bundleConfig;
    }

    public static BundleConfig dmConfigBean2JsSdkBundleConfig(DMMina dMMina, DMConfigBean dMConfigBean) {
        if (dMConfigBean == null) {
            return null;
        }
        BundleConfig bundleConfig = new BundleConfig();
        bundleConfig.versionCode = dMConfigBean.getSdkVersionCode();
        bundleConfig.versionName = dMConfigBean.getSdkVersionName();
        bundleConfig.appId = dMConfigBean.getSdkId(dMMina);
        bundleConfig.updateStrategy = dMConfigBean.getUpdateStrategy();
        bundleConfig.extraInfo = PmJsonUtil.toString(dMConfigBean);
        return bundleConfig;
    }

    public static DMConfigBean.AppModulesBean pmAssetModuleBean2AppModuleBean(PmAssetModuleBean pmAssetModuleBean) {
        DMConfigBean.AppModulesBean appModulesBean = new DMConfigBean.AppModulesBean();
        appModulesBean.setKey(pmAssetModuleBean.getKey());
        appModulesBean.setMd5(pmAssetModuleBean.getMd5());
        appModulesBean.setModuleId(pmAssetModuleBean.getModuleId());
        appModulesBean.setModuleName(pmAssetModuleBean.getModuleName());
        appModulesBean.setLazyDownload(pmAssetModuleBean.getLazyDownload());
        appModulesBean.setVersion(pmAssetModuleBean.getVersion());
        return appModulesBean;
    }

    public static DMConfigBean DMMina2DMConfigBean(DMMina dMMina) {
        if (dMMina == null) {
            return null;
        }
        if (dMMina.getJsAppBundleConfig() == null && dMMina.getJsSdkBundleConfig() == null) {
            return null;
        }
        if (!TextUtil.isEmpty(dMMina.getJsAppBundleConfig().extraInfo)) {
            return PmJsonUtil.json2DmConfigBean(dMMina.getJsAppBundleConfig().extraInfo);
        }
        return PmJsonUtil.json2DmConfigBean(dMMina.getJsSdkBundleConfig().extraInfo);
    }

    public static List<DMConfigBean.AppModulesBean> DMMina2DmConfigBeanAllModulesList(DMMina dMMina) {
        DMConfigBean DMMina2DMConfigBean = DMMina2DMConfigBean(dMMina);
        ArrayList arrayList = new ArrayList();
        arrayList.add(DMMina2DMConfigBean.getSdkModule());
        arrayList.addAll(DMMina2DMConfigBean.getAppModules());
        return arrayList;
    }

    public static List<DMConfigBean.AppModulesBean> DMMina2DmConfigBeanAllModulesList(DMConfigBean dMConfigBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dMConfigBean.getSdkModule());
        arrayList.addAll(dMConfigBean.getAppModules());
        return arrayList;
    }
}
