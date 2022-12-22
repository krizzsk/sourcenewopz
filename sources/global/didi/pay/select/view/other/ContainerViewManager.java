package global.didi.pay.select.view.other;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifiedPay.util.UIUtils;
import global.didi.pay.select.model.PayMethodItemInfo;
import global.didi.pay.select.view.base.ICardViewController;
import java.util.List;

public class ContainerViewManager {
    private ICardViewController mCardViewControl;
    private Context mContext;
    private View.OnClickListener mExpandShrinkClickListener;
    /* access modifiers changed from: private */
    public boolean mIsExpanded = false;
    /* access modifiers changed from: private */
    public LinearLayout mPayMethodContainer;
    /* access modifiers changed from: private */
    public List<PayMethodItemInfo> mPayMethodList;

    public ContainerViewManager(Context context, ICardViewController iCardViewController) {
        this.mContext = context;
        this.mCardViewControl = iCardViewController;
        this.mExpandShrinkClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ContainerViewManager containerViewManager = ContainerViewManager.this;
                boolean unused = containerViewManager.mIsExpanded = !containerViewManager.mIsExpanded;
                ContainerViewManager containerViewManager2 = ContainerViewManager.this;
                containerViewManager2.insertPayMethodView(containerViewManager2.mPayMethodContainer, ContainerViewManager.this.mPayMethodList);
            }
        };
    }

    public void insertPayMethodView(LinearLayout linearLayout, List<PayMethodItemInfo> list) {
        List<PayMethodItemInfo> list2;
        this.mPayMethodList = list;
        this.mPayMethodContainer = linearLayout;
        removeCardViews(linearLayout);
        if (this.mPayMethodContainer != null && (list2 = this.mPayMethodList) != null && list2.size() != 0) {
            int maxDisplayCardIndex = ExpandShrinkViewHelper.getMaxDisplayCardIndex(list, this.mIsExpanded);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).channelId != 150) {
                    addCardView(linearLayout, list.get(i));
                    if (i < list.size() - 1) {
                        addWideLineView(linearLayout);
                    }
                } else if (i <= maxDisplayCardIndex) {
                    addCardView(linearLayout, list.get(i));
                    if (i == maxDisplayCardIndex) {
                        if (ExpandShrinkViewHelper.isShowSwitchView(list)) {
                            addLineView(linearLayout);
                            View addExpandShrinkView = addExpandShrinkView(linearLayout, this.mIsExpanded);
                            if (addExpandShrinkView != null) {
                                addExpandShrinkView.setOnClickListener(this.mExpandShrinkClickListener);
                            }
                        }
                        if (i < list.size() - 1) {
                            addWideLineView(linearLayout);
                        }
                    } else {
                        addLineView(linearLayout);
                    }
                }
            }
        }
    }

    private void addCardView(LinearLayout linearLayout, PayMethodItemInfo payMethodItemInfo) {
        ICardViewController iCardViewController = this.mCardViewControl;
        if (iCardViewController != null && linearLayout != null && payMethodItemInfo != null) {
            iCardViewController.addCardView(linearLayout, payMethodItemInfo);
        }
    }

    private void removeCardViews(LinearLayout linearLayout) {
        ICardViewController iCardViewController = this.mCardViewControl;
        if (iCardViewController != null && linearLayout != null) {
            iCardViewController.removeAllCardViews(linearLayout);
        }
    }

    private void addLineView(LinearLayout linearLayout) {
        if (linearLayout != null) {
            View view = new View(this.mContext);
            view.setBackgroundColor(Color.parseColor("#0A000000"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
            layoutParams.setMargins(UIUtils.dip2pxInt(this.mContext, 18.0f), 0, 0, 0);
            linearLayout.addView(view, layoutParams);
        }
    }

    private void addWideLineView(LinearLayout linearLayout) {
        if (linearLayout != null) {
            View view = new View(this.mContext);
            view.setBackgroundColor(Color.parseColor("#f3f4f5"));
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, UIUtils.dip2pxInt(this.mContext, 10.0f)));
        }
    }

    private View addExpandShrinkView(LinearLayout linearLayout, boolean z) {
        if (linearLayout == null) {
            return null;
        }
        ExpandShrinkView expandShrinkView = new ExpandShrinkView(this.mContext);
        expandShrinkView.setIsExpand(z);
        linearLayout.addView(expandShrinkView);
        return expandShrinkView;
    }
}
