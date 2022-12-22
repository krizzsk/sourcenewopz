package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.unifiedPay.component.model.DownGradeInfo;
import com.didi.unifiedPay.component.model.PayChannelItem;
import com.didi.unifiedPay.component.widget.SingleSelectionListView;
import com.didi.unifiedPay.util.LogUtil;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class PayMethodView extends LinearLayout implements View.OnClickListener {
    private static final String TAG = "PayMethodView";
    /* access modifiers changed from: private */
    public boolean isClick = false;
    private boolean isSelected;
    private SingleSelectionListView.Adapter<PayChannelItem> mAdapter;
    private boolean mCanCancel;
    private int mChangeItemMode;
    protected Context mContext;
    private SingleSelectionListView.OnSelectListener mListener;

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.oc_unified_pay_channel_item;
    }

    public PayMethodView(Context context) {
        super(context);
        init(context);
    }

    public PayMethodView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    public void setOnSelectionListener(SingleSelectionListView.OnSelectListener onSelectListener) {
        this.mListener = onSelectListener;
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setOnClickListener(this);
        }
    }

    public PayChannelItem getSelection() {
        SingleSelectionListView.Adapter<PayChannelItem> adapter = this.mAdapter;
        if (adapter == null || adapter.getSelection() == -1) {
            return null;
        }
        SingleSelectionListView.Adapter<PayChannelItem> adapter2 = this.mAdapter;
        return adapter2.getItem(adapter2.getSelection());
    }

    public void onItemClick(int i, boolean z) {
        this.mAdapter.onItemClick(i, this.mChangeItemMode, z);
        this.isSelected = z;
        notifyDataUpdate();
    }

    public void setSelection(int i) {
        this.mAdapter.setSelection(i);
        notifyDataUpdate();
    }

    private void notifyDataUpdate() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setOnClickListener((View.OnClickListener) null);
        }
        removeAllViews();
        for (int i2 = 0; i2 < this.mAdapter.getCount(); i2++) {
            View view = this.mAdapter.getView(i2, (View) null, (ViewGroup) null);
            view.setOnClickListener(this);
            addView(view);
        }
    }

    public int getItemCount() {
        SingleSelectionListView.Adapter<PayChannelItem> adapter = this.mAdapter;
        if (adapter != null) {
            return adapter.getCount();
        }
        return 0;
    }

    public void setItemChangeMode(boolean z) {
        if (z) {
            this.mChangeItemMode = 1;
        } else {
            this.mChangeItemMode = 0;
        }
    }

    public void setCancelable(boolean z) {
        this.mCanCancel = z;
    }

    public void setData(List<PayChannelItem> list, boolean z, boolean z2) {
        this.mCanCancel = z2;
        if (z) {
            this.mChangeItemMode = 1;
        } else {
            this.mChangeItemMode = 0;
        }
        setData(list);
        setDownGradleClick(list);
    }

    public void setData(List<PayChannelItem> list) {
        if (this.mAdapter == null) {
            this.mAdapter = new SingleSelectionListView.Adapter<PayChannelItem>(getContext()) {
                /* access modifiers changed from: protected */
                public View getView(LayoutInflater layoutInflater) {
                    return layoutInflater.inflate(PayMethodView.this.getLayoutResId(), (ViewGroup) null);
                }

                /* access modifiers changed from: protected */
                public void bindView(View view, PayChannelItem payChannelItem) {
                    ((TextView) view.findViewById(R.id.oc_tv_pay_title)).setText(payChannelItem.payName);
                    loadIcon((ImageView) view.findViewById(R.id.oc_iv_pay_icon), payChannelItem);
                    initPromotionView(view, payChannelItem);
                    if (payChannelItem.isHide) {
                        view.setVisibility(8);
                    } else {
                        view.setVisibility(0);
                    }
                }

                private void loadIcon(ImageView imageView, PayChannelItem payChannelItem) {
                    if (!TextUtils.isEmpty(payChannelItem.iconUrl)) {
                        try {
                            GlideUtils.with2load2into(PayMethodView.this.getContext(), payChannelItem.iconUrl, imageView);
                        } catch (Exception e) {
                            e.printStackTrace();
                            loadLocalIcon(imageView, payChannelItem);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            loadLocalIcon(imageView, payChannelItem);
                        }
                    } else {
                        loadLocalIcon(imageView, payChannelItem);
                    }
                }

                private void loadLocalIcon(ImageView imageView, PayChannelItem payChannelItem) {
                    if (payChannelItem.channelId == 127 || payChannelItem.channelId == 133 || payChannelItem.channelId == 173 || payChannelItem.channelId == 171) {
                        imageView.setImageResource(R.mipmap.pay_icon_wechat);
                    } else if (payChannelItem.channelId == 128 || payChannelItem.channelId == 134 || payChannelItem.channelId == 172 || payChannelItem.channelId == 170) {
                        imageView.setImageResource(R.mipmap.pay_icon_alipay);
                    } else if (payChannelItem.channelId == 121) {
                        imageView.setImageResource(R.mipmap.pay_icon_company);
                    } else if (payChannelItem.channelId == 132 || payChannelItem.channelId == 144) {
                        imageView.setImageResource(R.mipmap.pay_icon_qqwallet);
                    } else if (payChannelItem.channelId == 136 || payChannelItem.channelId == 135) {
                        imageView.setImageResource(R.mipmap.pay_icon_yiwangtong);
                    } else if (payChannelItem.channelId == 9100) {
                        imageView.setImageResource(R.mipmap.pay_icon_lovepay);
                    } else if (payChannelItem.channelId == 150) {
                        imageView.setImageResource(R.mipmap.pay_icon_visa);
                    } else if (payChannelItem.channelId == 161) {
                        imageView.setImageResource(R.mipmap.pay_icon_dd_credit);
                    } else if (payChannelItem.channelId == 162) {
                        imageView.setImageResource(R.mipmap.pay_icon_zhift);
                    } else if (payChannelItem.channelId == 180) {
                        imageView.setImageResource(R.mipmap.pay_icon_change);
                    } else if (payChannelItem.channelId == 166) {
                        imageView.setImageResource(R.mipmap.pay_icon_dd_pay);
                    }
                }

                private void initPromotionView(View view, PayChannelItem payChannelItem) {
                    TextView textView = (TextView) view.findViewById(R.id.oc_tv_pay_promotion);
                    if (!UnipayTextUtil.isEmpty(payChannelItem.selfInputDetail)) {
                        textView.setVisibility(0);
                        textView.setText(payChannelItem.selfInputDetail);
                    } else if (!UnipayTextUtil.isEmpty(payChannelItem.detail)) {
                        textView.setVisibility(0);
                        textView.setText(PayMethodView.this.mContext.getResources().getString(R.string.oc_pay_detail_str, new Object[]{payChannelItem.detail}));
                    } else {
                        textView.setVisibility(8);
                    }
                }

                /* access modifiers changed from: protected */
                public void onSelectChange(final View view, int i, boolean z) {
                    view.setTag(Integer.valueOf(i));
                    handleItemSelected(view).setSelected(z);
                    if (view instanceof RelativeLayoutAccessibleForCheck) {
                        RelativeLayoutAccessibleForCheck relativeLayoutAccessibleForCheck = (RelativeLayoutAccessibleForCheck) view;
                        relativeLayoutAccessibleForCheck.setCheck(z);
                        relativeLayoutAccessibleForCheck.setCheckEnable(true);
                        if (PayMethodView.this.isClick) {
                            view.postDelayed(new Runnable() {
                                public void run() {
                                    view.sendAccessibilityEvent(128);
                                }
                            }, 60);
                        }
                    }
                }

                private View handleItemSelected(View view) {
                    View findViewById = view.findViewById(R.id.oc_iv_pay_checkbox);
                    ((ProgressBar) view.findViewById(R.id.oc_pb_pay_item_loading)).setVisibility(8);
                    findViewById.setVisibility(0);
                    return findViewById;
                }

                /* access modifiers changed from: protected */
                public void onBlockSelectChange(View view, int i, boolean z) {
                    super.onBlockSelectChange(view, i, z);
                    view.setTag(Integer.valueOf(i));
                    View findViewById = view.findViewById(R.id.oc_iv_pay_checkbox);
                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.oc_pb_pay_item_loading);
                    findViewById.setVisibility(8);
                    progressBar.setVisibility(0);
                    boolean z2 = view instanceof RelativeLayoutAccessibleForCheck;
                    if (z2) {
                        ((RelativeLayoutAccessibleForCheck) view).setCheckEnable(true);
                    }
                    if (z) {
                        findViewById.setVisibility(8);
                        progressBar.setVisibility(0);
                        if (z2) {
                            ((RelativeLayoutAccessibleForCheck) view).setCheckEnable(false);
                        }
                    } else if (i == getLastSelected()) {
                        handleItemSelected(view).setSelected(false);
                        if (z2) {
                            ((RelativeLayoutAccessibleForCheck) view).setCheck(false);
                        }
                    } else if (i == getSelection()) {
                        progressBar.setVisibility(8);
                        findViewById.setVisibility(0);
                        findViewById.setSelected(true);
                        if (z2) {
                            ((RelativeLayoutAccessibleForCheck) view).setCheck(true);
                        }
                    } else {
                        progressBar.setVisibility(8);
                        findViewById.setVisibility(0);
                        findViewById.setSelected(false);
                        if (z2) {
                            ((RelativeLayoutAccessibleForCheck) view).setCheck(false);
                        }
                    }
                }

                /* access modifiers changed from: protected */
                public void handleDownGradle(View view, int i, boolean z) {
                    PayChannelItem payChannelItem = (PayChannelItem) getItem(i);
                    initDownGradleText(view, payChannelItem);
                    if (!z) {
                        if (payChannelItem.downGradeInfo == null || payChannelItem.downGradeInfo.type != DownGradeInfo.DownGrade.NOT_USEABLE) {
                            view.setEnabled(true);
                            view.setAlpha(1.0f);
                        } else {
                            view.findViewById(R.id.oc_pb_pay_item_loading).setVisibility(8);
                            view.setEnabled(false);
                            view.setAlpha(0.4f);
                        }
                        if (payChannelItem.downGradeInfo != null && !UnipayTextUtil.isEmpty(payChannelItem.downGradeInfo.url)) {
                            view.setEnabled(true);
                            view.setAlpha(1.0f);
                        }
                    }
                }

                private void initDownGradleText(View view, PayChannelItem payChannelItem) {
                    View view2;
                    TextView textView = (TextView) view.findViewById(R.id.oc_tv_pay_downgradle);
                    if (payChannelItem.downGradeInfo == null || payChannelItem.downGradeInfo.type == DownGradeInfo.DownGrade.NORMAL || UnipayTextUtil.isEmpty(payChannelItem.downGradeInfo.text)) {
                        textView.setVisibility(8);
                    } else if (payChannelItem.downGradeInfo.type == DownGradeInfo.DownGrade.NOT_STABLE || payChannelItem.downGradeInfo.type == DownGradeInfo.DownGrade.NOT_USEABLE) {
                        textView.setText(payChannelItem.downGradeInfo.text);
                        textView.setVisibility(0);
                        if (payChannelItem.downGradeInfo.type != DownGradeInfo.DownGrade.NOT_USEABLE || TextUtils.isEmpty(payChannelItem.downGradeInfo.url)) {
                            view2 = null;
                        } else {
                            view2 = view.findViewById(R.id.oc_iv_platform_know_more);
                            view2.setVisibility(0);
                        }
                        if (view2 == null || view2.getVisibility() != 0) {
                            textView.setTextColor(PayMethodView.this.mContext.getResources().getColor(R.color.oc_color_999999));
                        } else {
                            textView.setTextColor(PayMethodView.this.mContext.getResources().getColor(R.color.orange));
                        }
                    }
                }
            };
        }
        this.mAdapter.setChangeMode(this.mChangeItemMode);
        this.mAdapter.setList(list);
        notifyDataUpdate();
    }

    public void onClick(View view) {
        SingleSelectionListView.Adapter<PayChannelItem> adapter;
        PayChannelItem item;
        AutoTrackHelper.trackViewOnClick(view);
        Integer num = (Integer) view.getTag();
        SingleSelectionListView.Adapter<PayChannelItem> adapter2 = this.mAdapter;
        if (adapter2 == null || (item = adapter2.getItem(num.intValue())) == null || item.downGradeInfo == null || UnipayTextUtil.isEmpty(item.downGradeInfo.url)) {
            PayChannelItem selection = getSelection();
            if (selection == null || (adapter = this.mAdapter) == null || num.intValue() != adapter.getIndex(selection)) {
                this.isClick = true;
                onItemClick(num.intValue(), true);
                SingleSelectionListView.OnSelectListener onSelectListener = this.mListener;
                if (onSelectListener != null) {
                    onSelectListener.onSelect(num.intValue(), this.mAdapter.getItem(num.intValue()));
                }
            } else if (this.mCanCancel) {
                onItemClick(num.intValue(), false);
                SingleSelectionListView.OnSelectListener onSelectListener2 = this.mListener;
                if (onSelectListener2 != null) {
                    onSelectListener2.unSelect(num.intValue(), this.mAdapter.getItem(num.intValue()));
                }
            }
        } else {
            SingleSelectionListView.OnSelectListener onSelectListener3 = this.mListener;
            if (onSelectListener3 != null) {
                onSelectListener3.itemClicked(num.intValue(), item);
            }
        }
    }

    public void onItemClick(PayChannelItem payChannelItem) {
        SingleSelectionListView.Adapter<PayChannelItem> adapter = this.mAdapter;
        if (adapter != null) {
            onItemClick(adapter.getIndex(payChannelItem), true);
        }
    }

    public void setBlockChangeResult(boolean z) {
        if (this.isSelected) {
            if (z) {
                setSelection(this.mAdapter.getBlockItemIndex());
            } else {
                setSelection(this.mAdapter.getLastSelected());
            }
        } else if (z) {
            setSelection(-1);
        } else {
            setSelection(this.mAdapter.getBlockItemIndex());
        }
    }

    public boolean hasHidePayItem() {
        if (this.mAdapter != null) {
            for (int i = 0; i < this.mAdapter.getCount(); i++) {
                PayChannelItem item = this.mAdapter.getItem(i);
                if (item != null && item.isHide) {
                    return true;
                }
            }
        }
        return false;
    }

    public void showAllPayItem(boolean z) {
        LogUtil.m31684d(TAG, "showAllPayItem canClick:" + z);
        SingleSelectionListView.Adapter<PayChannelItem> adapter = this.mAdapter;
        if (adapter != null && adapter.getCount() > 0) {
            int count = this.mAdapter.getCount();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < count; i++) {
                PayChannelItem item = this.mAdapter.getItem(i);
                if (item != null && item.isHide) {
                    item.isHide = false;
                }
                arrayList.add(item);
            }
            this.mAdapter.setList(arrayList);
        }
        notifyDataUpdate();
        setItemEnable(z);
    }

    public boolean hasLoadingStateItem() {
        SingleSelectionListView.Adapter<PayChannelItem> adapter = this.mAdapter;
        return adapter != null && adapter.getBlockItemIndex() >= 0;
    }

    public void setItemEnable(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                childAt.setEnabled(z);
            }
        }
        if (z) {
            SingleSelectionListView.Adapter<PayChannelItem> adapter = this.mAdapter;
            setDownGradleClick(adapter != null ? adapter.getList() : null);
        }
    }

    private void setDownGradleClick(List<PayChannelItem> list) {
        View childAt;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                PayChannelItem payChannelItem = list.get(i);
                if (!(payChannelItem == null || payChannelItem.downGradeInfo == null || payChannelItem.downGradeInfo.type != DownGradeInfo.DownGrade.NOT_USEABLE || !UnipayTextUtil.isEmpty(payChannelItem.downGradeInfo.url) || (childAt = getChildAt(i)) == null)) {
                    childAt.setEnabled(false);
                }
            }
        }
    }
}
