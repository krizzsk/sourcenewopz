package com.didichuxing.publicservice.resourcecontrol.dialogfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.publicservice.resourcecontrol.api.ResourceApi;
import com.didichuxing.publicservice.resourcecontrol.pojo.Notices;
import com.didichuxing.publicservice.resourcecontrol.utils.AssetWindowUtil;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;
import com.didichuxing.publicservice.resourcecontrol.view.AssetListViewLayout;
import com.taxis99.R;

public class AssetListViewDialogFragment extends BaseDialogFragment {
    public static String TAG = AssetListViewDialogFragment.class.getSimpleName();
    private AssetListViewLayout assetListViewLayout;
    private ImageButton closeImgbtn;

    public static AssetListViewDialogFragment newInstance(Bundle bundle) {
        AssetListViewDialogFragment assetListViewDialogFragment = new AssetListViewDialogFragment();
        assetListViewDialogFragment.setArguments(bundle);
        return assetListViewDialogFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.Asset_Notices);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AssetListViewLayout assetListViewLayout2 = (AssetListViewLayout) layoutInflater.inflate(R.layout.asset_frag_listview_layout, this.rootContainer, true).findViewById(R.id.assetListviewLayout);
        this.assetListViewLayout = assetListViewLayout2;
        assetListViewLayout2.setUsedInSDKFragment(true);
        this.assetListViewLayout.initView((Notices) this.serializable);
        this.assetListViewLayout.setResouceId(this.resouceId);
        this.closeImgbtn = (ImageButton) this.assetListViewLayout.findViewById(R.id.activeCloseImg);
        if (ResourceManager.getManager().getApplication() != null) {
            AssetWindowUtil.resizeRecursively(this.closeImgbtn);
        }
        this.closeImgbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AssetListViewDialogFragment.this.dismiss();
            }
        });
        return onCreateView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ResourceApi.mResourceHandler.sendEmptyMessage(20);
    }
}
