package com.didi.onekeyshare.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShareView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private static final int f29791a = 8;

    /* renamed from: b */
    private static final int f29792b = 4;

    /* renamed from: c */
    private TextView f29793c;

    /* renamed from: d */
    private List<OneKeyShareInfo> f29794d;

    /* renamed from: e */
    private IShareListener f29795e;

    /* renamed from: f */
    private Map<Integer, ShareItemView> f29796f = new HashMap();
    protected View mAnimBgContainer;
    protected View mBottomContainer;
    protected LinearLayout mContainerRow;
    protected LinearLayout mContainerRowSecond;
    protected Context mContext;
    protected View mRootContainer;

    public interface IShareListener {
        void onCancel();

        void onClickPlatform(OneKeyShareInfo oneKeyShareInfo);
    }

    public ShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        m20905a();
    }

    public ShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        m20905a();
    }

    public ShareView(Context context) {
        super(context);
        this.mContext = context;
        m20905a();
    }

    /* renamed from: a */
    private void m20905a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.tone_share, this);
        View findViewById = inflate.findViewById(R.id.tone_share_root);
        this.mRootContainer = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = inflate.findViewById(R.id.tone_share_bottom_container);
        this.mBottomContainer = findViewById2;
        findViewById2.setOnClickListener(this);
        this.mAnimBgContainer = inflate.findViewById(R.id.tone_share_anim_bg);
        this.mContainerRow = (LinearLayout) inflate.findViewById(R.id.share_ll_row_first);
        this.mContainerRowSecond = (LinearLayout) inflate.findViewById(R.id.share_ll_row_second);
        TextView textView = (TextView) inflate.findViewById(R.id.share_cancel);
        this.f29793c = textView;
        textView.setOnClickListener(this);
    }

    public void setShareInfo(List<OneKeyShareInfo> list) {
        this.f29794d = list;
        m20907a(list);
    }

    public List<OneKeyShareInfo> getShareInfo() {
        return this.f29794d;
    }

    public void setShareListener(IShareListener iShareListener) {
        this.f29795e = iShareListener;
    }

    /* renamed from: a */
    private void m20907a(List<OneKeyShareInfo> list) {
        if (list != null) {
            this.f29796f.clear();
            for (OneKeyShareInfo next : list) {
                if (this.f29796f.get(Integer.valueOf(next.platform.platformId())) == null) {
                    ShareItemView a = m20904a(next);
                    a.setOnClickListener(this);
                    m20906a(a);
                    this.f29796f.put(Integer.valueOf(next.platform.platformId()), a);
                }
            }
            m20908b();
        }
    }

    /* renamed from: a */
    private void m20906a(ShareItemView shareItemView) {
        if (shareItemView != null && this.f29796f.size() < 8) {
            if (this.f29796f.size() < 4) {
                this.mContainerRow.setVisibility(0);
                this.mContainerRow.addView(shareItemView);
            } else {
                this.mContainerRowSecond.setVisibility(0);
                this.mContainerRowSecond.addView(shareItemView);
            }
            SharePlatform platform = shareItemView.getPlatform();
            if (platform == null || platform == SharePlatform.UNKNOWN) {
                shareItemView.setVisibility(4);
            } else {
                shareItemView.setVisibility(0);
            }
        }
    }

    /* renamed from: b */
    private void m20908b() {
        if (this.f29796f.size() > 4 && this.f29796f.size() < 8) {
            for (int size = this.f29796f.size(); size < 8; size++) {
                ShareItemView a = m20904a(new OneKeyShareInfo());
                a.setOnClickListener(this);
                m20906a(a);
            }
        }
    }

    /* renamed from: a */
    private ShareItemView m20904a(OneKeyShareInfo oneKeyShareInfo) {
        ShareItemView shareItemView = new ShareItemView(getContext());
        shareItemView.setShareInfo(oneKeyShareInfo);
        shareItemView.setLayoutParams(getDefaultShareItemParams());
        return shareItemView;
    }

    private LinearLayout.LayoutParams getDefaultShareItemParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.share_cancel || id == R.id.tone_share_root) {
            m20910c();
            return;
        }
        ShareItemView shareItemView = this.f29796f.get(Integer.valueOf(id));
        if (shareItemView != null && this.f29795e != null) {
            m20909b(shareItemView.getShareInfo());
        }
    }

    /* renamed from: c */
    private void m20910c() {
        IShareListener iShareListener = this.f29795e;
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

    /* renamed from: b */
    private void m20909b(OneKeyShareInfo oneKeyShareInfo) {
        IShareListener iShareListener = this.f29795e;
        if (iShareListener != null) {
            iShareListener.onClickPlatform(oneKeyShareInfo);
        }
    }

    public void hideCancelView() {
        this.f29793c.setVisibility(8);
    }
}
