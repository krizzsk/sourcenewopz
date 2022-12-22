package com.didi.dimina.container.secondparty.citydata;

import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.secondparty.bundle.util.PmEncryptUtils;
import com.didi.dimina.container.service.NetworkService;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, mo175978d2 = {"com/didi/dimina/container/secondparty/citydata/CityDataManager$updateCityData$1", "Lcom/didi/dimina/container/service/NetworkService$ITaskCallback;", "onFailure", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "response", "Lorg/json/JSONObject;", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CityDataManager.kt */
public final class CityDataManager$updateCityData$1 extends NetworkService.ITaskCallback {
    final /* synthetic */ String $filePath;
    final /* synthetic */ int $newVersion;
    final /* synthetic */ String $url;

    CityDataManager$updateCityData$1(String str, String str2, int i) {
        this.$url = str;
        this.$filePath = str2;
        this.$newVersion = i;
    }

    public void onFailure(Exception exc) {
        Intrinsics.checkParameterIsNotNull(exc, "exception");
        LogUtil.iRelease("CityDataManager", "downloadFile onFailure " + exc);
        Map hashMap = new HashMap();
        hashMap.put("message", exc.toString());
        hashMap.put("url", this.$url);
        OmegaSDKAdapter.trackEvent("tech_saga_province_load_error", (Map<String, Object>) hashMap);
    }

    public void onSuccess(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "response");
        boolean checkMd5Valid = FileUtil.checkMd5Valid(PmEncryptUtils.encryptMD5File2String(new File(this.$filePath)), CityDataManager.INSTANCE.m12679d());
        LogUtil.iRelease("CityDataManager", "updateCityData downloadFile onSuccess checkMd5Valid: " + checkMd5Valid);
        if (checkMd5Valid) {
            MMKVUtil.getInstance().save("province_version", Integer.valueOf(this.$newVersion));
            return;
        }
        FileUtil.delete(this.$filePath);
        MMKVUtil.getInstance().remove("province_version");
    }
}
