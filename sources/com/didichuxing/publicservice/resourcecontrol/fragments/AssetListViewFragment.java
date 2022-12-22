package com.didichuxing.publicservice.resourcecontrol.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.api.ResourceApi;
import com.didichuxing.publicservice.resourcecontrol.pojo.Notices;
import com.didichuxing.publicservice.resourcecontrol.utils.AssetWindowUtil;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;
import com.didichuxing.publicservice.resourcecontrol.view.AssetListViewLayout;
import com.taxis99.R;

public class AssetListViewFragment extends AssetBasicFragment {
    private AssetListViewLayout assetListViewLayout;
    private Bundle bundle;
    private ImageButton closeImgbtn;

    public static AssetListViewFragment newInstance(Bundle bundle2) {
        AssetListViewFragment assetListViewFragment = new AssetListViewFragment();
        assetListViewFragment.setArguments(bundle2);
        return assetListViewFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle2) {
        super.onCreateView(layoutInflater, viewGroup, bundle2);
        View inflate = layoutInflater.inflate(R.layout.asset_frag_listview_layout, viewGroup, false);
        Bundle arguments = getArguments();
        this.bundle = arguments;
        int i = this.bundle.getInt(ConstantUtils.EXTRA_RESOURCE_ID, 0);
        AssetListViewLayout assetListViewLayout2 = (AssetListViewLayout) inflate.findViewById(R.id.assetListviewLayout);
        this.assetListViewLayout = assetListViewLayout2;
        assetListViewLayout2.setFragment(this);
        this.assetListViewLayout.initView((Notices) arguments.getSerializable(ConstantUtils.EXTRA_RESOURCE_STR));
        this.assetListViewLayout.setResouceId(i);
        this.closeImgbtn = (ImageButton) inflate.findViewById(R.id.activeCloseImg);
        if (ResourceManager.getManager().getApplication() != null) {
            AssetWindowUtil.resizeRecursively(this.closeImgbtn);
        }
        this.closeImgbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AssetListViewFragment.this.getActivity().finish();
            }
        });
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ResourceApi.mResourceHandler.sendEmptyMessage(20);
    }
}
