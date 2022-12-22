package global.didi.pay.select.view.brazil;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import global.didi.pay.select.model.PayMethodItemInfo;
import global.didi.pay.select.model.PayMethodPageHeadInfo;
import global.didi.pay.select.model.PayMethodPageInfo;
import global.didi.pay.select.view.base.BasePayMethodPageView;
import global.didi.pay.select.view.base.ICardViewController;
import global.didi.pay.select.view.base.IPayMethodPageEventListener;
import java.util.ArrayList;
import java.util.List;

public class BrazilPayMethodPageView extends BasePayMethodPageView<PayMethodPageInfo> implements View.OnClickListener, ICardViewController<PayMethodItemInfo> {
    private View iv_close;
    private LinearLayout ll_content;
    private LinearLayout ll_empty;
    private ViewStub ll_header;
    private LinearLayout ll_paymethod_container;
    private String mAddCardInstallment;
    private BrazilContainerViewManager mCardViewManager;
    /* access modifiers changed from: private */
    public IPayMethodPageEventListener mPayMethodPageEventListener;
    private PayMethodPageInfo mPayMethodPageInfo;
    /* access modifiers changed from: private */
    public List<BrazilPayMethodCardView> mPayMethodViewList;

    public BrazilPayMethodPageView(Context context) {
        super(context);
        init(context);
    }

    public BrazilPayMethodPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_global_v_99_paymethod_list_select, this, true);
        this.mTitleBarId = R.id.title_bar;
        this.ll_paymethod_container = (LinearLayout) findViewById(R.id.ll_paymethod_container);
        this.ll_header = (ViewStub) findViewById(R.id.vs_payment_method_head);
        this.ll_empty = (LinearLayout) findViewById(R.id.ll_empty);
        this.ll_content = (LinearLayout) findViewById(R.id.ll_content);
        this.iv_close = findViewById(R.id.iv_close);
        this.ll_empty.setOnClickListener(this);
        this.iv_close.setOnClickListener(this);
        this.mPayMethodViewList = new ArrayList();
        this.mCardViewManager = new BrazilContainerViewManager(context, this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        IPayMethodPageEventListener iPayMethodPageEventListener = this.mPayMethodPageEventListener;
        if (iPayMethodPageEventListener != null) {
            iPayMethodPageEventListener.onPageClickEvent(view, this.mPayMethodPageInfo);
        }
    }

    public void showFrozenContent(final PayMethodPageHeadInfo payMethodPageHeadInfo) {
        if (payMethodPageHeadInfo != null) {
            View inflate = this.ll_header.inflate();
            ((TextView) inflate.findViewById(R.id.tv_paymethod_head_title)).setText(payMethodPageHeadInfo.content);
            inflate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (BrazilPayMethodPageView.this.mPayMethodPageEventListener != null && !TextUtils.isEmpty(payMethodPageHeadInfo.link)) {
                        BrazilPayMethodPageView.this.mPayMethodPageEventListener.onFrozenTitleClick(payMethodPageHeadInfo.link);
                    }
                }
            });
            inflate.findViewById(R.id.tv_paymethod_head_arrow).setVisibility(TextUtils.isEmpty(payMethodPageHeadInfo.link) ? 8 : 0);
        }
    }

    public void showEmptyView() {
        this.ll_content.setVisibility(8);
        this.ll_empty.setVisibility(0);
    }

    public void showContentView() {
        this.ll_content.setVisibility(0);
        this.ll_empty.setVisibility(8);
    }

    public void updateContentView(PayMethodPageInfo payMethodPageInfo, String str) {
        this.mPayMethodPageInfo = payMethodPageInfo;
        this.mAddCardInstallment = str;
        if (payMethodPageInfo == null || payMethodPageInfo.payMethodList == null || payMethodPageInfo.payMethodList.size() == 0) {
            showEmptyView();
            return;
        }
        showContentView();
        this.mCardViewManager.insertPayMethodView(this.ll_paymethod_container, payMethodPageInfo, this.mAddCardInstallment);
    }

    public void setPayMethodPageEventListener(IPayMethodPageEventListener iPayMethodPageEventListener) {
        this.mPayMethodPageEventListener = iPayMethodPageEventListener;
        this.mCardViewManager.setPayMethodPageEventListener(iPayMethodPageEventListener);
    }

    public void addCardView(ViewGroup viewGroup, PayMethodItemInfo payMethodItemInfo) {
        if (viewGroup != null && payMethodItemInfo != null) {
            BrazilPayMethodCardView brazilPayMethodCardView = new BrazilPayMethodCardView(this.mContext);
            brazilPayMethodCardView.setPayMethodItemInfo(payMethodItemInfo);
            brazilPayMethodCardView.setMethodClickListener(new PayMethodCardViewClickListener(payMethodItemInfo));
            viewGroup.addView(brazilPayMethodCardView);
            this.mPayMethodViewList.add(brazilPayMethodCardView);
        }
    }

    public void removeAllCardViews(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        List<BrazilPayMethodCardView> list = this.mPayMethodViewList;
        if (list != null && list.size() > 0) {
            this.mPayMethodViewList.clear();
        }
    }

    private class PayMethodCardViewClickListener implements View.OnClickListener {
        public PayMethodItemInfo mItemInfo;

        public PayMethodCardViewClickListener(PayMethodItemInfo payMethodItemInfo) {
            this.mItemInfo = payMethodItemInfo;
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            PayMethodItemInfo payMethodItemInfo = this.mItemInfo;
            if (payMethodItemInfo != null && payMethodItemInfo.isEnabled && BrazilPayMethodPageView.this.mPayMethodViewList != null && BrazilPayMethodPageView.this.mPayMethodViewList.size() != 0) {
                if (this.mItemInfo.style == 2) {
                    doClickEvent(view);
                } else if (this.mItemInfo.style == 3) {
                    doClickEvent(view);
                } else {
                    doSelectEvent(view);
                }
            }
        }

        private void doSelectEvent(View view) {
            if (BrazilPayMethodPageView.this.mPayMethodPageEventListener != null) {
                BrazilPayMethodPageView.this.mPayMethodPageEventListener.onPayMethodSelectEvent(view, this.mItemInfo);
            }
        }

        private void doClickEvent(View view) {
            if (BrazilPayMethodPageView.this.mPayMethodPageEventListener != null) {
                BrazilPayMethodPageView.this.mPayMethodPageEventListener.onPayMethodClickEvent(view, this.mItemInfo);
            }
        }
    }
}
