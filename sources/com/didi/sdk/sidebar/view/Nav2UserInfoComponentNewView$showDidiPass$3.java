package com.didi.sdk.sidebar.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.sidebar.model.SidebarResponse;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/sdk/sidebar/view/Nav2UserInfoComponentNewView$showDidiPass$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Nav2UserInfoComponentNewView.kt */
public final class Nav2UserInfoComponentNewView$showDidiPass$3 implements View.OnClickListener {
    final /* synthetic */ SidebarResponse.GetProfile $didiPass;
    final /* synthetic */ Nav2UserInfoComponentNewView this$0;

    Nav2UserInfoComponentNewView$showDidiPass$3(SidebarResponse.GetProfile getProfile, Nav2UserInfoComponentNewView nav2UserInfoComponentNewView) {
        this.$didiPass = getProfile;
        this.this$0 = nav2UserInfoComponentNewView;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!TextUtils.isEmpty(this.$didiPass.jumpLink)) {
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.url = this.$didiPass.jumpLink;
            webViewModel.isAddCommonParam = true;
            Intent intent = new Intent(this.this$0.context, WebActivity.class);
            intent.putExtra("web_view_model", webViewModel);
            this.this$0.context.startActivity(intent);
            OmegaSDKAdapter.trackEvent("gp_mement1_ck");
        }
    }
}
