package com.didi.payment.kycservice.key.list;

import android.content.Intent;
import android.os.Bundle;
import com.didi.payment.kycservice.key.create.PixKeyCreateActivity;
import com.didi.payment.kycservice.key.detail.PixKeyDetailActivity;
import com.didi.payment.kycservice.key.list.adaper.PixKeyListAdapter;
import com.didi.payment.kycservice.key.list.response.PixKeyListResp;
import com.didi.payment.kycservice.kyc.SignUpPageScene;
import com.didi.payment.kycservice.utils.KycRegisterUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/kycservice/key/list/PixKeyListActivity$rvAdapter$1", "Lcom/didi/payment/kycservice/key/list/adaper/PixKeyListAdapter$IItemClickListener;", "onItemClick", "", "item", "Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$KeyItem;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyListActivity.kt */
public final class PixKeyListActivity$rvAdapter$1 implements PixKeyListAdapter.IItemClickListener {
    final /* synthetic */ PixKeyListActivity this$0;

    PixKeyListActivity$rvAdapter$1(PixKeyListActivity pixKeyListActivity) {
        this.this$0 = pixKeyListActivity;
    }

    public void onItemClick(PixKeyListResp.KeyItem keyItem) {
        String str;
        String str2;
        String subTitle;
        Intrinsics.checkNotNullParameter(keyItem, "item");
        if (keyItem.getStatus() == 99) {
            KycRegisterUtils.INSTANCE.go2TargetPage(this.this$0, SignUpPageScene.CHOOSE_KEY_TYPE.getSceneTag(), "3");
            PixKeyListResp.Data value = PixKeyListActivity.access$getVm(this.this$0).getPixKeyListData().getValue();
        } else if (keyItem.getStatus() == 0) {
            Intent intent = new Intent(this.this$0, PixKeyDetailActivity.class);
            intent.putExtra("param_key_type", keyItem.getType());
            intent.putExtra("param_key_val", keyItem.getValue());
            this.this$0.startActivity(intent);
        } else if (keyItem.getStatus() == 2 && keyItem.getDefaultDetail() != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("param_key_type", keyItem.getType());
            PixKeyListResp.Detail defaultDetail = keyItem.getDefaultDetail();
            String str3 = "";
            if (defaultDetail == null || (str = defaultDetail.getDefaultValue()) == null) {
                str = str3;
            }
            bundle.putString("param_key_val", str);
            PixKeyListResp.Detail defaultDetail2 = keyItem.getDefaultDetail();
            if (defaultDetail2 == null || (str2 = defaultDetail2.getTitle()) == null) {
                str2 = str3;
            }
            bundle.putString(PixKeyCreateActivity.PARAM_KEY_TITLE, str2);
            PixKeyListResp.Detail defaultDetail3 = keyItem.getDefaultDetail();
            if (!(defaultDetail3 == null || (subTitle = defaultDetail3.getSubTitle()) == null)) {
                str3 = subTitle;
            }
            bundle.putString(PixKeyCreateActivity.PARAM_KEY_SUBTITLE, str3);
            Intent intent2 = new Intent(this.this$0.getApplicationContext(), PixKeyCreateActivity.class);
            intent2.putExtras(bundle);
            this.this$0.startActivity(intent2);
        }
    }
}
