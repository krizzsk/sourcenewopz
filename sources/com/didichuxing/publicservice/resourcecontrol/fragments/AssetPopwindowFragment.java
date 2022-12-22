package com.didichuxing.publicservice.resourcecontrol.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource;
import com.didichuxing.publicservice.resourcecontrol.utils.AssetWindowUtil;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;
import com.didichuxing.publicservice.resourcecontrol.view.AssetPopwindowLayout;
import com.taxis99.R;

public class AssetPopwindowFragment extends AssetBasicFragment {
    private AssetPopwindowLayout assetPopwindowLayout;
    private Bundle bundle;
    private ImageView imgClose;
    private DPopResource resource;

    public static AssetPopwindowFragment newInstance(Bundle bundle2) {
        AssetPopwindowFragment assetPopwindowFragment = new AssetPopwindowFragment();
        assetPopwindowFragment.setArguments(bundle2);
        return assetPopwindowFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle2) {
        View inflate = layoutInflater.inflate(R.layout.asset_frag_popowindow_layout, viewGroup, false);
        Bundle arguments = getArguments();
        this.bundle = arguments;
        this.resource = (DPopResource) arguments.getSerializable(ConstantUtils.EXTRA_RESOURCE_STR);
        AssetPopwindowLayout assetPopwindowLayout2 = (AssetPopwindowLayout) inflate.findViewById(R.id.popwindowLayout);
        this.assetPopwindowLayout = assetPopwindowLayout2;
        assetPopwindowLayout2.setFragment(this);
        this.assetPopwindowLayout.initView(this.resource);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.popClose);
        this.imgClose = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AssetPopwindowFragment.this.getActivity().finish();
            }
        });
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle2) {
        super.onViewCreated(view, bundle2);
        if (ResourceManager.getManager().getApplication() != null) {
            AssetWindowUtil.resizeRecursively(view);
        }
    }
}
