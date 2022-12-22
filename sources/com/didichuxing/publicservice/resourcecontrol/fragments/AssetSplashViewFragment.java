package com.didichuxing.publicservice.resourcecontrol.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.pojo.DSplashResource;
import com.didichuxing.publicservice.resourcecontrol.view.AssetSplashViewLayout;
import com.taxis99.R;

public class AssetSplashViewFragment extends AssetBasicFragment {
    public static final int SPLASH_FRAGMENT_CLOSE = 101;
    private AssetSplashViewLayout assetSplashViewLayout;
    private ImageView closeSplash;
    private Handler handler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 101) {
                AssetSplashViewFragment.this.finishActivity();
            }
        }
    };

    /* access modifiers changed from: private */
    public void finishActivity() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            Intent intent = new Intent("com.didi.home");
            intent.setPackage(getActivity().getPackageName());
            intent.setFlags(268435456);
            getActivity().startActivity(intent);
            getActivity().finish();
        }
    }

    public static AssetSplashViewFragment newInstance(Bundle bundle) {
        AssetSplashViewFragment assetSplashViewFragment = new AssetSplashViewFragment();
        assetSplashViewFragment.setArguments(bundle);
        return assetSplashViewFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.asset_frag_splashview_layout, viewGroup, false);
        AssetSplashViewLayout assetSplashViewLayout2 = (AssetSplashViewLayout) inflate.findViewById(R.id.assetSplashLayout);
        this.assetSplashViewLayout = assetSplashViewLayout2;
        assetSplashViewLayout2.setActivity(this.mActivity);
        this.assetSplashViewLayout.showSplashComercial((DSplashResource) getArguments().getSerializable(ConstantUtils.EXTRA_RESOURCE_STR), this.handler);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.handler.sendEmptyMessageDelayed(101, 3000);
    }
}
