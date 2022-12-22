package com.didi.dimina.container.secondparty.bundle.util;

import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.mina.DMMinaHelper;
import com.didi.dimina.container.secondparty.bundle.DiminaHelper;
import com.didi.dimina.container.secondparty.bundle.PmConstant;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.bean.PmAssetAppConfigBean;
import com.didi.dimina.container.secondparty.bundle.bean.PmAssetModuleBean;
import com.didi.dimina.container.secondparty.bundle.bean.PmAssetSdkConfigBean;
import com.didi.dimina.container.secondparty.util.DebugExceptionUtil;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PmFileHelper {
    public static final String TAG = "Dimina-PM PmFileHelper";

    /* renamed from: a */
    private static final AtomicInteger f17100a = new AtomicInteger(0);

    public static String readAssetDmConfig(DMMina dMMina, Context context, String str) {
        if (!UpgradeUtil.isNativeAppUpgrade()) {
            String assetsDmConfigFromMMKV = getAssetsDmConfigFromMMKV(context, dMMina);
            LogUtil.iRelease(TAG, "从mmkv中 读取到 Assets 资源配置： " + assetsDmConfigFromMMKV);
            if (!TextUtils.isEmpty(assetsDmConfigFromMMKV)) {
                return assetsDmConfigFromMMKV;
            }
        }
        String a = m12673a(dMMina, context, str);
        deleteAssetsDmConfigFromMMKV(dMMina);
        writeAssetsDmConfig2MMKV(context, dMMina, a);
        return a;
    }

    public static String getAssetsDmConfigFromMMKV(Context context, DMMina dMMina) {
        String assetsConfigMMKVKey = getAssetsConfigMMKVKey(dMMina, String.valueOf(Dimina.getConfig().getAdapterConfig().getWsgService().getAppVersionCode(context)));
        LogUtil.iRelease(TAG, "得到asset config在mmkv中的key : " + assetsConfigMMKVKey);
        return (String) MMKVUtil.getInstance().get(assetsConfigMMKVKey, "");
    }

    public static void writeAssetsDmConfig2MMKV(Context context, DMMina dMMina, String str) {
        MMKVUtil.getInstance().save(getAssetsConfigMMKVKey(dMMina, String.valueOf(Dimina.getConfig().getAdapterConfig().getWsgService().getAppVersionCode(context))), str);
    }

    public static void deleteAssetsDmConfigFromMMKV(DMMina dMMina) {
        MMKVUtil.getInstance().remove(getAssetsConfigMMKVKey(dMMina, String.valueOf(((Integer) MMKVUtil.getInstance().get(PmConstant.KEY_NATIVE_APP_VERSION_CODE, 0)).intValue())));
    }

    public static String getAssetsConfigMMKVKey(DMMina dMMina, String str) {
        return DiminaHelper.getJsAppAssetDir(dMMina) + "_" + DiminaHelper.getJsSdkAssetDir(dMMina) + "_" + str;
    }

    public static String readFilesJsAppDmConfig(Context context, String str, DMMina dMMina) {
        String mMKVDmConfigKey = getMMKVDmConfigKey(str, dMMina);
        LogUtil.iRelease(TAG, "得到dm_config在mmkv中的key名 : " + mMKVDmConfigKey);
        return (String) MMKVUtil.getInstance().get(mMKVDmConfigKey, "");
    }

    public static String getZipModuleCacheFilePath(Context context, String str, String str2, String str3) {
        File file = new File(PmFileUtil.getInternalCacheDirectory(context, PmFileConstant.getDiminaBundleRootDir() + "/" + str2), str3);
        file.mkdirs();
        String str4 = file.getAbsolutePath() + File.separator + str + PmFileConstant.ZIP_SUFFIX;
        LogUtil.iRelease(TAG, "getZipModuleCacheFileName = " + str4);
        return str4;
    }

    public static String getFilesDmConfigTmpFilePath(Context context, String str) {
        File file = new File(PmFileUtil.getInternalFilesDirectory(context, PmFileConstant.getDiminaBundleRootDir()), str);
        file.mkdirs();
        String str2 = file.getAbsolutePath() + File.separator + PmFileConstant.DM_CONFIG_FILE_NAME_IN_CACHE;
        LogUtil.iRelease(TAG, "getCacheDmConfigFilePath = " + str2);
        return str2;
    }

    public static String getFilesNodeConfigTmpFilePath(Context context, String str) {
        File file = new File(PmFileUtil.getInternalFilesDirectory(context, PmFileConstant.DIMINA_NODE_CONFIG_ROOT_DIR), str);
        file.mkdirs();
        String str2 = file.getAbsolutePath() + File.separator + PmFileConstant.NODE_CONFIG_FILE_NAME_IN_CACHE;
        LogUtil.iRelease(TAG, "getCacheNodeConfigFilePath = " + str2);
        return str2;
    }

    public static String getCacheDmBundleDir(Context context) {
        File file = new File(PmFileUtil.getInternalCacheDirectory(context, PmFileConstant.getDiminaBundleRootDir()), "");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    public static String getFileDmBundleDir(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + PmFileConstant.getDiminaBundleRootDir());
        file.mkdirs();
        return file.getAbsolutePath();
    }

    public static String absolutePath2RelativePath(String str) {
        int indexOf = str.indexOf(PmFileConstant.getDiminaBundleRootDir());
        return indexOf >= 0 ? str.substring(indexOf + PmFileConstant.getDiminaBundleRootDir().length() + 1) : str;
    }

    public static String filePath2fileDir(String str) {
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf >= 0 ? str.substring(0, lastIndexOf) : str;
    }

    public static String getFilesNodeConfigNormalFilePath(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + File.separator + PmFileConstant.DIMINA_NODE_CONFIG_ROOT_DIR + File.separator + str + File.separator + "config.json";
    }

    public static String getFilesModuleFilePath(Context context, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append(PmFileConstant.getDiminaBundleRootDir());
        sb.append(File.separator);
        sb.append(str);
        sb.append(File.separator);
        sb.append(str2);
        sb.append(File.separator);
        sb.append(str3);
        if (!TextUtils.isEmpty(str4)) {
            if (str4.length() > 1 && str4.indexOf(File.separator) != 0) {
                LogUtil.eRelease(TAG, "" + str3 + "\t " + str4 + "\t 第一位不是分隔符");
                sb.append(File.separator);
            }
            sb.append(str4);
        }
        LogUtil.iRelease(TAG, "" + str3 + " " + str4 + " 最终得到的完整路径=" + sb.toString());
        return sb.toString();
    }

    public static String getFilesModuleFilePath(DMMina dMMina, Context context, String str, String str2, String str3) {
        String str4;
        String str5;
        DMConfigBean DMMina2DMConfigBean = ReleaseBundleDataAdapter.DMMina2DMConfigBean(dMMina);
        if (TextUtils.equals(DMMina2DMConfigBean.getSdkModule().getModuleName(), str2)) {
            str5 = DMMina2DMConfigBean.getSdkId(dMMina);
            str4 = DMMina2DMConfigBean.getSdkVersionCode();
        } else {
            str5 = DMMina2DMConfigBean.getAppId();
            str4 = DMMina2DMConfigBean.getAppVersionCode();
        }
        return getFilesModuleFilePath(context, str5, str4, str2, str3);
    }

    public static List<String> findAllDmConfigFilePathInFilesDmBundle(Context context) {
        ArrayList arrayList = new ArrayList();
        String fileDmBundleDir = getFileDmBundleDir(context);
        List<String> childFileInDir = PmFileUtil.childFileInDir(fileDmBundleDir);
        LogUtil.iRelease(TAG, "dm_bundles/下面内容:" + childFileInDir);
        for (String str : childFileInDir) {
            String str2 = fileDmBundleDir + File.separator + str + File.separator + PmFileConstant.DM_CONFIG_FILE_NAME;
            if (PmFileUtil.isFileExit(str2)) {
                arrayList.add(str2);
            }
        }
        LogUtil.iRelease(TAG, "dm_bundles/下面所有配置文件列表 = " + arrayList);
        return arrayList;
    }

    public static List<String> readAllDmConfigContentInDmBundle(Context context) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (String next : findAllDmConfigFilePathInFilesDmBundle(context)) {
            String read = PmFileUtil.read(next);
            StringBuilder sb = new StringBuilder();
            int i2 = i + 1;
            sb.append(i);
            sb.append("  读取配置长度=");
            sb.append(read.length());
            sb.append("\t ->");
            sb.append(next);
            LogUtil.iRelease(TAG, sb.toString());
            if (!TextUtils.isEmpty(read)) {
                arrayList.add(read);
            }
            i = i2;
        }
        return arrayList;
    }

    public static String getAssetDmConfigFilePath(String str) {
        if (str.lastIndexOf(File.separator) + 1 == str.length()) {
            return str + PmFileConstant.DM_CONFIG_FILE_NAME;
        }
        return str + File.separator + PmFileConstant.DM_CONFIG_FILE_NAME;
    }

    /* renamed from: a */
    private static String m12673a(DMMina dMMina, Context context, String str) {
        String str2 = deleteLastSeparator(DiminaHelper.getJsSdkAssetDir(dMMina)) + File.separator + "config.json";
        LogUtil.iRelease(TAG, "getDmConfigDependTwoAssetConfigFile() -> jsSdkConfigPath=" + str2);
        String readAssetsFile = PmAssetsUtil.readAssetsFile(context, str2);
        if (TextUtils.isEmpty(readAssetsFile)) {
            LogUtil.eRelease(TAG, " 读取到的 asset sdk config.json内容 为null, 直接返回");
            return "";
        }
        PmAssetSdkConfigBean pmAssetSdkConfigBean = (PmAssetSdkConfigBean) PmJsonUtil.toObject(readAssetsFile, PmAssetSdkConfigBean.class);
        if (!(pmAssetSdkConfigBean == null || pmAssetSdkConfigBean.getModules() == null)) {
            for (PmAssetModuleBean version : pmAssetSdkConfigBean.getModules()) {
                version.setVersion(pmAssetSdkConfigBean.getVersion(), pmAssetSdkConfigBean.getSdkVersionName());
            }
        }
        if (CollectionsUtil.getSize((Collection) pmAssetSdkConfigBean.getModules()) != 1) {
            DebugExceptionUtil.throwRuntimeExceptionIfDebug("从配置文件中读取的 sdk config.json 的module数量错误, size -> " + CollectionsUtil.getSize((Collection) pmAssetSdkConfigBean.getModules()));
            LogUtil.eRelease(TAG, "从配置文件中读取的 sdk config.json 的module数量错误, size -> " + CollectionsUtil.getSize((Collection) pmAssetSdkConfigBean.getModules()));
        }
        String str3 = deleteLastSeparator(str) + File.separator + "config.json";
        LogUtil.iRelease(TAG, "getDmConfigDependTwoAssetConfigFile() -> jsAppConfigPath=" + str3);
        String readAssetsFile2 = PmAssetsUtil.readAssetsFile(context, str3);
        if (TextUtils.isEmpty(readAssetsFile2)) {
            LogUtil.eRelease(TAG, " 读取到的 asset app config.json内容 为null， 直接返回");
            return "";
        }
        PmAssetAppConfigBean pmAssetAppConfigBean = (PmAssetAppConfigBean) PmJsonUtil.toObject(readAssetsFile2, PmAssetAppConfigBean.class);
        if (!(pmAssetAppConfigBean == null || pmAssetAppConfigBean.getModules() == null)) {
            for (PmAssetModuleBean version2 : pmAssetAppConfigBean.getModules()) {
                version2.setVersion(pmAssetAppConfigBean.getVersion(), pmAssetAppConfigBean.getAppVersionName());
            }
        }
        DMConfigBean dMConfigBean = new DMConfigBean();
        dMConfigBean.setAppId(pmAssetAppConfigBean.getAppId());
        dMConfigBean.setAppVersion(pmAssetAppConfigBean.getModules().get(0).getVersion(), pmAssetAppConfigBean.getModules().get(0).getVersionName());
        dMConfigBean.setSdkId(pmAssetSdkConfigBean.getAppId(dMMina));
        dMConfigBean.setSdkVersion(pmAssetSdkConfigBean.getVersion(), pmAssetSdkConfigBean.getSdkVersionName());
        ArrayList arrayList = new ArrayList();
        for (PmAssetModuleBean pmAssetModuleBean2AppModuleBean : pmAssetAppConfigBean.getModules()) {
            DMConfigBean.AppModulesBean pmAssetModuleBean2AppModuleBean2 = ReleaseBundleDataAdapter.pmAssetModuleBean2AppModuleBean(pmAssetModuleBean2AppModuleBean);
            pmAssetModuleBean2AppModuleBean2.setChannel(pmAssetAppConfigBean.getChannel());
            arrayList.add(pmAssetModuleBean2AppModuleBean2);
        }
        dMConfigBean.setAppModules(arrayList);
        DMConfigBean.AppModulesBean pmAssetModuleBean2AppModuleBean3 = ReleaseBundleDataAdapter.pmAssetModuleBean2AppModuleBean(pmAssetSdkConfigBean.getModules().get(0));
        pmAssetModuleBean2AppModuleBean3.setChannel(pmAssetSdkConfigBean.getChannel());
        dMConfigBean.setSdkModule(pmAssetModuleBean2AppModuleBean3);
        LogUtil.m13412i(TAG, "从Asset两个配置文件 转化后的 dmConfigBean=" + dMConfigBean);
        return PmJsonUtil.toString(dMConfigBean);
    }

    public static String deleteLastSeparator(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.lastIndexOf("/") + 1 == str.length() ? str.substring(0, str.length() - 1) : str;
    }

    public static String getMMKVDmConfigKey(String str, DMMina dMMina) {
        return PmConstant.getPrefixMMKVDmConfigKey() + str + "_" + DMMinaHelper.getJsSdkId();
    }

    public static void writeDmConfig2MMKV(String str, String str2, DMMina dMMina) {
        MMKVUtil.getInstance().save(getMMKVDmConfigKey(str, dMMina), str2);
    }

    public static String createAppJsFilesDir(Context context, String str, String str2) {
        String str3 = context.getFilesDir().getAbsolutePath() + File.separator + PmFileConstant.getDiminaBundleRootDir() + File.separator + str + File.separator + str2;
        PmFileUtil.mkdirs(str3);
        LogUtil.iRelease("getAppJsSdkFilesDir", "sdkDir=" + str3);
        return str3;
    }

    public static String getZipModuleCacheUniquFilePath(Context context, String str, String str2, String str3) {
        File file = new File(PmFileUtil.getInternalCacheDirectory(context, PmFileConstant.getDiminaBundleRootDir() + "/" + str2), str3);
        file.mkdirs();
        String str4 = file.getAbsolutePath() + File.separator + str + m12672a() + PmFileConstant.ZIP_SUFFIX;
        LogUtil.iRelease(TAG, "getZipModuleCacheFileName = " + str4);
        return str4;
    }

    /* renamed from: a */
    private static String m12672a() {
        return ".aaa_" + f17100a.incrementAndGet() + "_bbb";
    }
}
