package com.didichuxing.upgrade;

import com.didichuxing.bean.UpdateResponse;
import com.didichuxing.util.UpgradeSp;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didichuxing/upgrade/UpgradeSDK$syncUpdates$1", "Lcom/didichuxing/upgrade/IUpGetInfoCallback;", "onRequestFailed", "", "errorCode", "", "onRequestSuccess", "response", "Lcom/didichuxing/bean/UpdateResponse;", "upgrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: UpgradeSDK.kt */
public final class UpgradeSDK$syncUpdates$1 implements IUpGetInfoCallback {
    final /* synthetic */ UpgradeSDK this$0;

    public void onRequestFailed(int i) {
    }

    UpgradeSDK$syncUpdates$1(UpgradeSDK upgradeSDK) {
        this.this$0 = upgradeSDK;
    }

    public void onRequestSuccess(UpdateResponse updateResponse) {
        if (updateResponse != null) {
            if ((updateResponse.errNum == 0 && updateResponse.needUpdate ? updateResponse : null) != null) {
                UpgradeSDK upgradeSDK = this.this$0;
                String str = updateResponse.updateUrl;
                if (str == null) {
                    str = "";
                }
                upgradeSDK.f49245c = str;
                this.this$0.f49244b.post(new C16518x63136d84(this, updateResponse));
                UpgradeSp instance = UpgradeSp.Companion.getInstance();
                instance.setVersionID(updateResponse.versionId);
                instance.setTaskId(updateResponse.taskId);
                instance.setUpdateType(updateResponse.updateType);
            }
        }
    }
}
