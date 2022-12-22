package com.didichuxing.publicservice.resourcecontrol.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.activities.RControlActivity;
import com.didichuxing.publicservice.resourcecontrol.pojo.Notices;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;
import com.taxis99.R;
import com.tunasashimi.tuna.TunaDownload;
import com.tunasashimi.tuna.TunaView;
import java.util.HashMap;

public class AssetListViewLayout extends AssetBaseView {
    private ListView assetListview;
    /* access modifiers changed from: private */
    public Context mContext;
    private int resouceId;

    public int getResouceId() {
        return this.resouceId;
    }

    public void setResouceId(int i) {
        this.resouceId = i;
    }

    public AssetListViewLayout(Context context) {
        super(context);
    }

    public AssetListViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public void initView(Notices notices) {
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.asset_listview_layout, this);
        if (notices != null && notices.list != null && notices.list.size() != 0) {
            ListView listView = (ListView) findViewById(R.id.assetListview);
            this.assetListview = listView;
            listView.setAdapter(new TunaDownloadTestAdapter(this.mContext, notices));
        }
    }

    public class TunaDownloadTestAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;
        private Notices notices;
        private HashMap<Integer, View> tunaDownloadMap = new HashMap<>();

        public long getItemId(int i) {
            return (long) i;
        }

        public TunaDownloadTestAdapter(Context context, Notices notices2) {
            this.layoutInflater = LayoutInflater.from(context);
            this.notices = notices2;
        }

        public int getCount() {
            Notices notices2 = this.notices;
            if (notices2 == null || notices2.list == null) {
                return 0;
            }
            return this.notices.list.size();
        }

        public Object getItem(int i) {
            return this.notices.list.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            Integer num = new Integer(i);
            if (i == this.notices.list.size()) {
                View inflate = this.layoutInflater.inflate(R.layout.asset_listview_itembottem, (ViewGroup) null);
                this.tunaDownloadMap.put(num, inflate);
                return inflate;
            }
            if (this.tunaDownloadMap.get(num) == null) {
                final Notices.Notice notice = this.notices.list.get(i);
                View inflate2 = this.layoutInflater.inflate(R.layout.asset_listview_item, (ViewGroup) null);
                final TunaDownload tunaDownload = (TunaDownload) inflate2.findViewById(R.id.tunaDownloadItem);
                tunaDownload.setTunaDownloadCacheFolder(ConstantUtils.IMAGE_FILE_URL);
                TextView textView = (TextView) inflate2.findViewById(R.id.assetListviewItemTile);
                TunaView tunaView = (TunaView) inflate2.findViewById(R.id.assetListviewItemContent);
                LinearLayout linearLayout = (LinearLayout) inflate2.findViewById(R.id.assetListviewTextLayout);
                boolean z = notice.visited == 0;
                if (TextUtils.isEmpty(notice.title)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(AssetListViewLayout.getFixedLengthString(11, notice.title));
                }
                if (TextUtils.isEmpty(notice.desc)) {
                    tunaView.setVisibility(8);
                } else {
                    tunaView.setTunaTextValue(AssetListViewLayout.getFixedLengthString(49, notice.desc));
                }
                if (!TextUtils.isEmpty(notice.title) || !TextUtils.isEmpty(notice.desc)) {
                    linearLayout.setVisibility(0);
                } else {
                    tunaDownload.setTunaDownloadRadiusLeftBottom(1, 5.0f);
                    tunaDownload.setTunaDownloadRadiusRightBottom(1, 5.0f);
                    linearLayout.setVisibility(8);
                }
                tunaDownload.setTunaDownloadGraphicsSrcURLRequestHeight(264);
                tunaDownload.setTunaDownloadGraphicsSrcURLRequestWidth(710);
                tunaDownload.init(RControlActivity.tunaDownloadMapList, notice.image, z);
                tunaDownload.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (!ResourceManager.isFastClick() && !TextUtils.isEmpty(notice.link)) {
                            Bundle bundle = new Bundle();
                            bundle.putString(ConstantUtils.EXTRA_WEBVIEW_URL, notice.link);
                            bundle.putString(ConstantUtils.EXTRA_WEBVIEW_TITLE, notice.title);
                            bundle.putInt(ConstantUtils.EXTRA_RESOURCE_TYPE, 1004);
                            AssetListViewLayout.this.openView(AssetListViewLayout.this.mContext, bundle, false);
                            notice.visited = 1;
                            tunaDownload.setTunaDownloadMark(false);
                        }
                    }
                });
                this.tunaDownloadMap.put(num, inflate2);
            }
            return this.tunaDownloadMap.get(num);
        }
    }

    public static String getFixedLengthString(int i, String str) {
        if (str == null) {
            return " ";
        }
        if (str.length() <= i) {
            return str;
        }
        return str.substring(0, i) + "...";
    }
}
