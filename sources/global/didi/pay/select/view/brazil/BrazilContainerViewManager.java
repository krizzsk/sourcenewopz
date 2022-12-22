package global.didi.pay.select.view.brazil;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifiedPay.util.UIUtils;
import global.didi.pay.select.model.PayMethodGroupInfo;
import global.didi.pay.select.model.PayMethodItemInfo;
import global.didi.pay.select.model.PayMethodPageInfo;
import global.didi.pay.select.view.base.ICardViewController;
import global.didi.pay.select.view.base.IPayMethodPageEventListener;
import java.util.ArrayList;

public class BrazilContainerViewManager {
    private ICardViewController mCardViewControl;
    private Context mContext;
    /* access modifiers changed from: private */
    public IPayMethodPageEventListener mPayMethodPageEventListener;

    public BrazilContainerViewManager(Context context, ICardViewController iCardViewController) {
        this.mContext = context;
        this.mCardViewControl = iCardViewController;
    }

    public void insertPayMethodView(LinearLayout linearLayout, PayMethodPageInfo payMethodPageInfo, String str) {
        if (payMethodPageInfo != null && linearLayout != null && payMethodPageInfo.groupList != null && payMethodPageInfo.payMethodList != null) {
            removeCardViews(linearLayout);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            PayMethodGroupInfo payMethodGroupInfo = null;
            if (!(payMethodPageInfo.groupList == null || payMethodPageInfo.groupList.size() <= 0 || (payMethodGroupInfo = payMethodPageInfo.groupList.get(0)) == null || payMethodGroupInfo.channelIds == null || payMethodGroupInfo.channelIds.size() <= 0)) {
                for (Integer intValue : payMethodGroupInfo.channelIds) {
                    int intValue2 = intValue.intValue();
                    for (PayMethodItemInfo next : payMethodPageInfo.payMethodList) {
                        if (intValue2 == next.channelId) {
                            arrayList2.add(next);
                        }
                    }
                }
                for (PayMethodItemInfo next2 : payMethodPageInfo.payMethodList) {
                    if (!payMethodGroupInfo.channelIds.contains(Integer.valueOf(next2.channelId))) {
                        arrayList.add(next2);
                    }
                }
            }
            if (payMethodGroupInfo != null) {
                PayMethodItemInfo payMethodItemInfo = new PayMethodItemInfo();
                payMethodItemInfo.title = payMethodGroupInfo.name;
                payMethodItemInfo.titleStyle = 3;
                payMethodItemInfo.iconUrl = payMethodGroupInfo.icon;
                payMethodItemInfo.style = 4;
                addCardView(linearLayout, payMethodItemInfo);
                addLineView(linearLayout);
                for (int i = 0; i < arrayList2.size(); i++) {
                    PayMethodItemInfo payMethodItemInfo2 = (PayMethodItemInfo) arrayList2.get(i);
                    int size = arrayList2.size() - 1;
                    payMethodItemInfo2.iconUrl = "";
                    if (payMethodItemInfo2.channelId == 190 && payMethodItemInfo2.style == 2) {
                        payMethodItemInfo2.style = 3;
                    }
                    if (payMethodItemInfo2.channelId == 150) {
                        if (!TextUtils.isEmpty(payMethodItemInfo2.cardIndex)) {
                            addCardView(linearLayout, payMethodItemInfo2);
                        }
                        if (i == size) {
                            addMatchParentLineView(linearLayout);
                            addBindCardView(linearLayout, payMethodPageInfo.headInfo == null || payMethodPageInfo.headInfo.addCardEnable, str);
                            addWideLineView(linearLayout);
                        } else {
                            addLineView(linearLayout);
                        }
                    } else {
                        addCardView(linearLayout, payMethodItemInfo2);
                        addLineView(linearLayout);
                    }
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    PayMethodItemInfo payMethodItemInfo3 = (PayMethodItemInfo) arrayList.get(i2);
                    if (i2 == arrayList.size() - 1) {
                        addCardView(linearLayout, payMethodItemInfo3);
                    } else {
                        addCardView(linearLayout, payMethodItemInfo3);
                        addLineView(linearLayout);
                    }
                }
            }
        }
    }

    public void setPayMethodPageEventListener(IPayMethodPageEventListener iPayMethodPageEventListener) {
        this.mPayMethodPageEventListener = iPayMethodPageEventListener;
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

    private void addMatchParentLineView(LinearLayout linearLayout) {
        if (linearLayout != null) {
            View view = new View(this.mContext);
            view.setBackgroundColor(Color.parseColor("#0A000000"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
            layoutParams.setMargins(0, 0, 0, 0);
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

    private void addBindCardView(LinearLayout linearLayout, boolean z, String str) {
        if (linearLayout != null) {
            BrazilAddCardView brazilAddCardView = new BrazilAddCardView(this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            brazilAddCardView.setTag("add_card");
            brazilAddCardView.setEnable(z);
            brazilAddCardView.showInstallment(str);
            brazilAddCardView.setAddCardClickListener(z ? new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (BrazilContainerViewManager.this.mPayMethodPageEventListener != null) {
                        BrazilContainerViewManager.this.mPayMethodPageEventListener.onPageClickEvent(view, null);
                    }
                }
            } : null);
            linearLayout.addView(brazilAddCardView, layoutParams);
        }
    }
}
