package com.didichuxing.publicservice.resourcecontrol.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.activities.RControlActivity;
import com.didichuxing.publicservice.resourcecontrol.pojo.Resource;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;
import com.taxis99.R;
import com.tunasashimi.tuna.TunaDownload;
import java.io.PrintStream;

public class AssetCenterImageLayout extends AssetBaseView {
    private static final String TAG = AssetCenterImageLayout.class.getSimpleName();
    /* access modifiers changed from: private */
    public Context mContext;
    private Resource mResource;
    /* access modifiers changed from: private */
    public TunaDownload tunaDownload;

    public AssetCenterImageLayout(Context context) {
        super(context);
        this.mContext = context;
    }

    public AssetCenterImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public AssetCenterImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void cacheLoad() {
        String stringFromPreference = AppUtils.getStringFromPreference(ResourceManager.getManager().getApplication(), "assetCenterCache");
        PrintStream printStream = System.out;
        printStream.println("assetCenterCache==>" + stringFromPreference);
        if (!TextUtils.isEmpty(stringFromPreference)) {
            ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.asset_imageview_layout, this);
            TunaDownload tunaDownload2 = (TunaDownload) findViewById(R.id.tunaDownload);
            this.tunaDownload = tunaDownload2;
            tunaDownload2.setTunaDownloadCacheFolder(ConstantUtils.IMAGE_FILE_URL);
            this.tunaDownload.setTunaDownloadGraphicsSrcURLRequestHeight(250);
            this.tunaDownload.setTunaDownloadGraphicsSrcURLRequestWidth(935);
            this.tunaDownload.init(RControlActivity.tunaDownloadMapList, stringFromPreference);
        }
    }

    public void initView(final Resource resource) {
        post(new Runnable() {
            public void run() {
                ((LayoutInflater) AssetCenterImageLayout.this.mContext.getSystemService("layout_inflater")).inflate(R.layout.asset_imageview_layout, AssetCenterImageLayout.this);
                AssetCenterImageLayout assetCenterImageLayout = AssetCenterImageLayout.this;
                TunaDownload unused = assetCenterImageLayout.tunaDownload = (TunaDownload) assetCenterImageLayout.findViewById(R.id.tunaDownload);
                AssetCenterImageLayout.this.tunaDownload.setTunaDownloadCacheFolder(ConstantUtils.IMAGE_FILE_URL);
                AssetCenterImageLayout.this.tunaDownload.setTunaDownloadGraphicsSrcURLRequestHeight(250);
                AssetCenterImageLayout.this.tunaDownload.setTunaDownloadGraphicsSrcURLRequestWidth(935);
                Resource resource = resource;
                if (resource != null && resource.list != null && resource.list.size() != 0) {
                    final Resource.SingleResource singleResource = resource.list.get(0);
                    AssetCenterImageLayout.this.tunaDownload.init(RControlActivity.tunaDownloadMapList, singleResource.image);
                    AssetCenterImageLayout.this.tunaDownload.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Resource.SingleResource singleResource;
                            AutoTrackHelper.trackViewOnClick(view);
                            if (!ResourceManager.isFastClick() && (singleResource = singleResource) != null && singleResource.link != null && !TextUtils.isEmpty(singleResource.link.trim())) {
                                Bundle bundle = new Bundle();
                                bundle.putString(ConstantUtils.EXTRA_WEBVIEW_URL, singleResource.link);
                                bundle.putInt(ConstantUtils.EXTRA_RESOURCE_TYPE, 1004);
                                AssetCenterImageLayout.this.openView(AssetCenterImageLayout.this.mContext, bundle, true);
                            }
                        }
                    });
                    AppUtils.saveStringToPreference(ResourceManager.getManager().getApplication(), "assetCenterCache", singleResource.image);
                }
            }
        });
    }
}
