package com.didi.foundation.sdk.upgrade;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.didi.foundation.sdk.log.LogService;
import com.didi.foundation.sdk.service.LocaleService;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.upgrade.bean.UpdateResponse;
import com.didichuxing.upgrade.sdk.IUpgradeCallback;
import com.didichuxing.upgrade.sdk.UpgradeConfig;
import com.didichuxing.upgrade.sdk.UpgradeSDK;
import java.io.File;

@ServiceProvider({UpgradeServiceProvider.class})
public class UpgradeServiceImpl implements UpgradeServiceProvider {
    public static final String MARKET_PREFIX = "market://";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f21386a = LogService.getLogger((Class<?>) UpgradeServiceImpl.class);

    public void releaseDownloadSdk() {
    }

    public void checkUpdate(String str, Context context, final String str2, final String str3, final String str4, final double d, final double d2, LogListener logListener, final UpgradeListener upgradeListener) {
        Logger logger = this.f21386a;
        logger.debug("checkUpdate with custom host:" + str, new Object[0]);
        UpgradeSDK instance = UpgradeSDK.getInstance();
        instance.setUpgradeCallback(new IUpgradeCallback() {
            public void onDownloadFailed(int i, String str) {
            }

            public void onDownloadProgress(int i) {
            }

            public void onDownloadStart() {
            }

            public void onDownloadSuccess() {
            }

            public void onPatchFailed(int i) {
            }

            public void onPatchStart() {
            }

            public void onPatchSuccess(File file) {
            }

            public void onRequestSuccess(boolean z, UpdateResponse updateResponse) {
                Logger a = UpgradeServiceImpl.this.f21386a;
                a.info("onRequestSuccess " + updateResponse.toString(), new Object[0]);
                UpgradeListener upgradeListener = upgradeListener;
                if (upgradeListener == null) {
                    return;
                }
                if (updateResponse == null) {
                    upgradeListener.onFail(-1);
                    return;
                }
                UpgradeEntity a2 = UpgradeServiceImpl.this.m15707a(updateResponse);
                if (a2 == null) {
                    upgradeListener.onFail(-1);
                } else {
                    upgradeListener.onSuccess(a2);
                }
            }

            public void onRequestFailed(int i) {
                Logger a = UpgradeServiceImpl.this.f21386a;
                a.info("onRequestFailed: " + i, new Object[0]);
                UpgradeListener upgradeListener = upgradeListener;
                if (upgradeListener != null) {
                    upgradeListener.onFail(i);
                }
            }
        });
        if (!TextUtils.isEmpty(str)) {
            instance.setHost(str);
        }
        instance.setPhoneNumber(new UpgradeConfig.IGetPhone() {
            public String getPhone() {
                return str3;
            }
        });
        instance.setCityCode(new UpgradeConfig.IGetCityId() {
            public String getCityId() {
                return str2;
            }
        });
        instance.setLatitude(new UpgradeConfig.IGetLatitude() {
            public String getLatitude() {
                return "" + d;
            }
        });
        instance.setLongitude(new UpgradeConfig.IGetLongitude() {
            public String getLongitude() {
                return "" + d2;
            }
        });
        instance.setUid(new UpgradeConfig.IGetUid() {
            public String getDidiPassengerUid() {
                return str4;
            }
        });
        instance.setAppLanguage(new UpgradeConfig.IGetLanguage() {
            public String getAppLanguage() {
                return LocaleService.getInstance().getCurrentLangTag();
            }
        });
        instance.enableLog(true);
        instance.AsyncInit(context, 100);
    }

    public void goToGooglePlay(Context context, String str, String str2) {
        String substring = str.substring(str.indexOf("id=") + 3);
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=" + substring));
            intent.setPackage("com.android.vending");
            intent.addFlags(268435456);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + substring));
            intent2.addFlags(268435456);
            if (intent2.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent2);
            } else {
                SystemUtils.showToast(Toast.makeText(context.getApplicationContext(), str2, 0));
            }
        } catch (ActivityNotFoundException unused) {
            this.f21386a.debug("GoogleMarket Intent not found", new Object[0]);
        }
    }

    public boolean isGooglePlay(String str) {
        return str.startsWith(MARKET_PREFIX);
    }

    public void startDownload(Context context, UpgradeEntity upgradeEntity, final DownloadListener downloadListener) {
        UpgradeSDK.getInstance().startDownloadFile(context, new UpdateResponse.Builder().apkMD5(upgradeEntity.mApkMD5).apkSize(upgradeEntity.mApkSize).apkUrl(upgradeEntity.mApkUrl).errMsg(upgradeEntity.mErrMsg).errNum(upgradeEntity.mErrNum).ignoreBtn(upgradeEntity.mIgnoreBtn).isForce(upgradeEntity.mIsForce).needUpdate(upgradeEntity.mNeedUpdate).patchMd5(upgradeEntity.mPatchMd5).patchSize(upgradeEntity.mPatchSize).patchUrl(upgradeEntity.mPatchUrl).taskId(upgradeEntity.mTaskId).updateBtn(upgradeEntity.mUpdateBtn).updateDesc(upgradeEntity.mUpdateDesc).updateTitle(upgradeEntity.mUpdateTitle).updateType(upgradeEntity.mUpdateType).version(upgradeEntity.mVersion).versionCode(upgradeEntity.mVersionCode).versionId(upgradeEntity.mVersionId).builder(), new IUpgradeCallback() {
            public void onPatchFailed(int i) {
            }

            public void onPatchStart() {
            }

            public void onPatchSuccess(File file) {
            }

            public void onRequestFailed(int i) {
            }

            public void onRequestSuccess(boolean z, UpdateResponse updateResponse) {
            }

            public void onDownloadStart() {
                DownloadListener downloadListener = downloadListener;
                if (downloadListener != null) {
                    downloadListener.onDownloadStart();
                }
            }

            public void onDownloadProgress(int i) {
                DownloadListener downloadListener = downloadListener;
                if (downloadListener != null) {
                    downloadListener.onDownloadProgress(i);
                }
            }

            public void onDownloadSuccess() {
                DownloadListener downloadListener = downloadListener;
                if (downloadListener != null) {
                    downloadListener.onDownloadSuccess();
                }
            }

            public void onDownloadFailed(int i, String str) {
                DownloadListener downloadListener = downloadListener;
                if (downloadListener != null) {
                    downloadListener.onDownloadFailed(i, str);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public UpgradeEntity m15707a(UpdateResponse updateResponse) {
        if (TextUtils.isEmpty(updateResponse.apkUrl)) {
            return null;
        }
        UpgradeEntity upgradeEntity = new UpgradeEntity();
        upgradeEntity.mErrNum = updateResponse.errNum;
        upgradeEntity.mErrMsg = updateResponse.errMsg;
        upgradeEntity.mApkUrl = updateResponse.apkUrl;
        upgradeEntity.mApkMD5 = updateResponse.apkMD5;
        upgradeEntity.mPatchMd5 = updateResponse.patchMd5;
        upgradeEntity.mNeedUpdate = updateResponse.needUpdate;
        upgradeEntity.mPatchUrl = updateResponse.patchUrl;
        upgradeEntity.mApkSize = updateResponse.apkSize;
        upgradeEntity.mPatchSize = updateResponse.patchSize;
        upgradeEntity.mUpdateDesc = updateResponse.updateDesc;
        upgradeEntity.mVersion = updateResponse.version;
        upgradeEntity.mVersionCode = updateResponse.versionCode;
        upgradeEntity.mUpdateTitle = updateResponse.updateTitle;
        upgradeEntity.mUpdateBtn = updateResponse.updateBtn;
        upgradeEntity.mIgnoreBtn = updateResponse.ignoreBtn;
        upgradeEntity.mUpdateType = updateResponse.updateType;
        upgradeEntity.mIsForce = updateResponse.isForce;
        upgradeEntity.mTaskId = updateResponse.taskId;
        upgradeEntity.mVersionId = updateResponse.versionId;
        return upgradeEntity;
    }
}
