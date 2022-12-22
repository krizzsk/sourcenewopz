package com.didi.onekeyshare.view.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.taxis99.R;

public class GlobalShareFragmentView extends ShareFragmentView implements View.OnClickListener {
    protected LinearLayout mContainerRowThird;

    public GlobalShareFragmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    public GlobalShareFragmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public GlobalShareFragmentView(Context context) {
        super(context);
        this.mContext = context;
    }

    public GlobalShareFragmentView(Context context, boolean z, int i) {
        super(context, z, i, 9, 3);
    }

    /* access modifiers changed from: protected */
    public void doInit(View view) {
        this.mContainerRowThird = (LinearLayout) view.findViewById(R.id.share_ll_row_third);
    }

    /* access modifiers changed from: protected */
    public void addShareItemShow(ShareFragmentItemView shareFragmentItemView) {
        if (shareFragmentItemView != null && this.mShareItemMaps.size() < this.max_share_count) {
            if (this.mShareItemMaps.size() < this.max_single_row_share_count) {
                this.mContainerRow.setVisibility(0);
                this.mContainerRow.addView(shareFragmentItemView);
            } else if (this.mShareItemMaps.size() < this.max_single_row_share_count * 2) {
                this.mContainerRowSecond.setVisibility(0);
                this.mContainerRowSecond.addView(shareFragmentItemView);
                findViewById(R.id.empty_view2).setVisibility(0);
            } else if (this.mShareItemMaps.size() < this.max_single_row_share_count * 3) {
                this.mContainerRowThird.setVisibility(0);
                this.mContainerRowThird.addView(shareFragmentItemView);
                findViewById(R.id.empty_view3).setVisibility(0);
            }
            SharePlatform platform = shareFragmentItemView.getPlatform();
            if (platform == null || platform == SharePlatform.UNKNOWN) {
                shareFragmentItemView.setVisibility(4);
            } else {
                shareFragmentItemView.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addEmptyView() {
        if (this.mShareItemMaps.size() <= this.max_single_row_share_count && this.mPageIndex == 0) {
            return;
        }
        if (this.mPageIndex == 0) {
            int size = this.mShareItemMaps.size();
            while (this.mShareItemMaps.size() % this.max_single_row_share_count != 0) {
                ShareFragmentItemView createShareItemView = createShareItemView(new OneKeyShareInfo());
                createShareItemView.setOnClickListener(this);
                addShareItemShow(createShareItemView);
                this.mShareItemMaps.put(Integer.valueOf(createShareItemView.hashCode() + size), createShareItemView);
                size++;
            }
            return;
        }
        for (int size2 = this.mShareItemMaps.size(); size2 < this.max_share_count; size2++) {
            ShareFragmentItemView createShareItemView2 = createShareItemView(new OneKeyShareInfo());
            createShareItemView2.setOnClickListener(this);
            addShareItemShow(createShareItemView2);
            this.mShareItemMaps.put(Integer.valueOf(createShareItemView2.hashCode() + size2), createShareItemView2);
        }
    }
}
