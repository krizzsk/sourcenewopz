package com.didi.onekeyshare.view.fragment;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.onekeyshare.ShareConfig;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.util.ShareUtil;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShareFragmentView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private List<OneKeyShareInfo> f29828a;

    /* renamed from: b */
    private IShareListener f29829b;

    /* renamed from: c */
    private boolean f29830c;
    protected View mAnimBgContainer;
    protected View mBottomContainer;
    protected LinearLayout mContainerRow;
    protected LinearLayout mContainerRowSecond;
    protected Context mContext;
    protected int mPageIndex;
    protected View mRootContainer;
    protected Map<Integer, ShareFragmentItemView> mShareItemMaps;
    protected int max_share_count;
    protected int max_single_row_share_count;

    public interface IShareListener {
        void onCancel();

        void onClickPlatform(OneKeyShareInfo oneKeyShareInfo);
    }

    /* access modifiers changed from: protected */
    public void doInit(View view) {
    }

    public ShareFragmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.max_share_count = 8;
        this.max_single_row_share_count = 4;
        this.mShareItemMaps = new HashMap();
        this.mContext = context;
        init();
    }

    public ShareFragmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.max_share_count = 8;
        this.max_single_row_share_count = 4;
        this.mShareItemMaps = new HashMap();
        this.mContext = context;
        init();
    }

    public ShareFragmentView(Context context) {
        super(context);
        this.max_share_count = 8;
        this.max_single_row_share_count = 4;
        this.mShareItemMaps = new HashMap();
        this.mContext = context;
        init();
    }

    public ShareFragmentView(Context context, boolean z, int i) {
        this(context, z, i, 8, 4);
    }

    protected ShareFragmentView(Context context, boolean z, int i, int i2, int i3) {
        super(context);
        this.max_share_count = 8;
        this.max_single_row_share_count = 4;
        this.mShareItemMaps = new HashMap();
        this.mContext = context;
        this.f29830c = z;
        this.mPageIndex = i;
        if (z) {
            this.max_share_count = 12;
            this.max_single_row_share_count = 6;
        } else {
            this.max_single_row_share_count = 4;
            if (ShareConfig.Nation.CHINA.equals(ShareConfig.getConfig().getNation())) {
                this.max_share_count = 8;
            } else {
                this.max_share_count = 12;
            }
        }
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_share, this);
        View findViewById = inflate.findViewById(R.id.tone_share_root);
        this.mRootContainer = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = inflate.findViewById(R.id.tone_share_bottom_container);
        this.mBottomContainer = findViewById2;
        findViewById2.setOnClickListener(this);
        this.mAnimBgContainer = inflate.findViewById(R.id.tone_share_anim_bg);
        this.mContainerRow = (LinearLayout) inflate.findViewById(R.id.share_ll_row_first);
        this.mContainerRowSecond = (LinearLayout) inflate.findViewById(R.id.share_ll_row_second);
        doInit(inflate);
    }

    public void setShareInfo(List<OneKeyShareInfo> list) {
        this.f29828a = list;
        m20927a(list);
    }

    public List<OneKeyShareInfo> getShareInfo() {
        return this.f29828a;
    }

    public void setShareListener(IShareListener iShareListener) {
        this.f29829b = iShareListener;
    }

    /* renamed from: a */
    private void m20927a(List<OneKeyShareInfo> list) {
        if (list != null) {
            this.mShareItemMaps.clear();
            int i = 0;
            for (OneKeyShareInfo next : list) {
                if (!(next == null || next.platform == null || next.customName == null || this.mShareItemMaps.get(Integer.valueOf(next.platform.platformId() + next.customName.hashCode())) != null)) {
                    ShareFragmentItemView createShareItemView = createShareItemView(next);
                    createShareItemView.setOnClickListener(this);
                    if (list.size() == 2 && i == 1 && this.mPageIndex == 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) createShareItemView.getLayoutParams();
                        layoutParams.leftMargin = ShareUtil.dip2px(getContext(), 55.0f);
                        if (Build.VERSION.SDK_INT >= 17) {
                            layoutParams.setMarginStart(layoutParams.leftMargin);
                        }
                        createShareItemView.setLayoutParams(layoutParams);
                    } else if (list.size() == 3 && i > 0 && this.mPageIndex == 0) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) createShareItemView.getLayoutParams();
                        layoutParams2.leftMargin = ShareUtil.dip2px(getContext(), 75.0f);
                        if (Build.VERSION.SDK_INT >= 17) {
                            layoutParams2.setMarginStart(layoutParams2.leftMargin);
                        }
                        createShareItemView.setLayoutParams(layoutParams2);
                    }
                    if (list.size() == 2 || (list.size() == 3 && this.mPageIndex == 0)) {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) createShareItemView.getLayoutParams();
                        layoutParams3.weight = 0.0f;
                        createShareItemView.setLayoutParams(layoutParams3);
                    }
                    if (this.mPageIndex == 1 && (list.size() == 2 || list.size() == 3)) {
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) createShareItemView.getLayoutParams();
                        layoutParams4.weight = 1.0f;
                        createShareItemView.setLayoutParams(layoutParams4);
                    }
                    addShareItemShow(createShareItemView);
                    this.mShareItemMaps.put(Integer.valueOf(next.platform.platformId() + next.customName.hashCode()), createShareItemView);
                    i++;
                }
            }
            addEmptyView();
        }
    }

    /* access modifiers changed from: protected */
    public void addShareItemShow(ShareFragmentItemView shareFragmentItemView) {
        if (shareFragmentItemView != null && this.mShareItemMaps.size() < this.max_share_count) {
            if (this.mShareItemMaps.size() < this.max_single_row_share_count) {
                this.mContainerRow.setVisibility(0);
                this.mContainerRow.addView(shareFragmentItemView);
            } else {
                this.mContainerRowSecond.setVisibility(0);
                this.mContainerRowSecond.addView(shareFragmentItemView);
                findViewById(R.id.empty_view2).setVisibility(0);
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
        if (this.mShareItemMaps.size() > this.max_single_row_share_count || this.mPageIndex != 0) {
            for (int size = this.mShareItemMaps.size(); size < this.max_share_count; size++) {
                ShareFragmentItemView createShareItemView = createShareItemView(new OneKeyShareInfo());
                createShareItemView.setOnClickListener(this);
                addShareItemShow(createShareItemView);
                this.mShareItemMaps.put(Integer.valueOf(createShareItemView.hashCode() + size), createShareItemView);
            }
        }
    }

    /* access modifiers changed from: protected */
    public ShareFragmentItemView createShareItemView(OneKeyShareInfo oneKeyShareInfo) {
        ShareFragmentItemView shareFragmentItemView = new ShareFragmentItemView(getContext());
        shareFragmentItemView.setShareInfo(oneKeyShareInfo);
        shareFragmentItemView.setLayoutParams(getDefaultShareItemParams());
        return shareFragmentItemView;
    }

    private LinearLayout.LayoutParams getDefaultShareItemParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ShareUtil.dip2px(getContext(), 60.0f), ShareUtil.dip2px(getContext(), 76.0f));
        layoutParams.gravity = 16;
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.share_cancel || id == R.id.tone_share_root) {
            m20925a();
            return;
        }
        ShareFragmentItemView shareFragmentItemView = this.mShareItemMaps.get(Integer.valueOf(id));
        if (shareFragmentItemView != null && this.f29829b != null) {
            m20926a(shareFragmentItemView.getShareInfo());
        }
    }

    /* renamed from: a */
    private void m20925a() {
        IShareListener iShareListener = this.f29829b;
        if (iShareListener != null) {
            iShareListener.onCancel();
        }
    }

    public void enterAnimation() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.tone_share_bg_slide_in);
        this.mBottomContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.tone_share_footer_slide_in));
        this.mAnimBgContainer.startAnimation(loadAnimation);
    }

    public void exitAnimation(Animation.AnimationListener animationListener) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.tone_share_bg_slide_out);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.tone_share_footer_slide_out);
        loadAnimation2.setAnimationListener(animationListener);
        this.mBottomContainer.startAnimation(loadAnimation2);
        this.mAnimBgContainer.startAnimation(loadAnimation);
    }

    /* renamed from: a */
    private void m20926a(OneKeyShareInfo oneKeyShareInfo) {
        IShareListener iShareListener = this.f29829b;
        if (iShareListener != null) {
            iShareListener.onClickPlatform(oneKeyShareInfo);
        }
    }
}
