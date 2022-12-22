package com.didi.soda.order.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.passenger.C10448R;
import com.didi.soda.customer.foundation.p164im.ImMessageHelper;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.widget.CircleImageView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.order.view.OrderCardBannerView;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class OrderCardBannerView extends RecyclerView {

    /* renamed from: a */
    private RecyclerView.ItemDecoration f43549a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f43550b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<OrderCardBannerModel> f43551c;

    /* renamed from: d */
    private boolean f43552d;
    public int mEndDecorationWidth;
    public int mFirstDecorationWidth;
    public int mMidDecorationWidth;

    public static class OrderCardBannerModel {
        public int contactRole;
        public String mBannerContent;
        public int mBannerDefalutIcon;
        public String mBannerIcon;
        public String mBannerName;
        public int mBannerNameMaxLines;
        public String mBusinessUid;
        public OrderContactListener mContactListener;
        public boolean mNeedContactMessage;
        public boolean mNeedContactPhone;
        public boolean mPhoneProtected;
        public String mRiderUid;
    }

    public interface OrderContactListener {
        void contactMessage(int i);

        void contactPhone(int i);
    }

    public OrderCardBannerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public OrderCardBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OrderCardBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f43551c = new ArrayList();
        this.f43552d = true;
        m30870a(context, attributeSet);
        m30869a(context);
    }

    public void setDatas(List<OrderCardBannerModel> list, int i) {
        if (list != null && !list.isEmpty()) {
            this.f43551c.clear();
            this.f43551c.addAll(list);
            setAdapter(new OrderCardBannerAdapter(this, this.f43551c));
            if (getOnFlingListener() == null) {
                new CardSnapHelper().attachToRecyclerView(this);
            }
            m30871a(list);
            if (!this.f43552d || i != 1) {
                scrollToPosition(this.f43550b);
                return;
            }
            smoothScrollToPosition(i);
            this.f43550b = i;
            this.f43552d = false;
        }
    }

    /* renamed from: a */
    private void m30870a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RvBanner);
        this.mFirstDecorationWidth = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.mMidDecorationWidth = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.mEndDecorationWidth = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m30869a(Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
        setNestedScrollingEnabled(false);
        setLayoutManager(linearLayoutManager);
        if (this.f43549a == null) {
            C141491 r3 = new RecyclerView.ItemDecoration() {
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    int viewAdapterPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
                    if (viewAdapterPosition == 0) {
                        if (OrderCardBannerView.this.f43551c.isEmpty() || OrderCardBannerView.this.f43551c.size() <= 1) {
                            rect.set(OrderCardBannerView.this.mFirstDecorationWidth, 0, OrderCardBannerView.this.mEndDecorationWidth, 0);
                        } else {
                            rect.set(OrderCardBannerView.this.mFirstDecorationWidth, 0, OrderCardBannerView.this.mMidDecorationWidth / 2, 0);
                        }
                    } else if (OrderCardBannerView.this.f43551c.isEmpty() || viewAdapterPosition != OrderCardBannerView.this.f43551c.size() - 1) {
                        rect.set(OrderCardBannerView.this.mMidDecorationWidth / 2, 0, OrderCardBannerView.this.mMidDecorationWidth / 2, 0);
                    } else {
                        rect.set(OrderCardBannerView.this.mMidDecorationWidth / 2, 0, OrderCardBannerView.this.mEndDecorationWidth, 0);
                    }
                }
            };
            this.f43549a = r3;
            addItemDecoration(r3);
        }
    }

    /* renamed from: a */
    private void m30871a(List<OrderCardBannerModel> list) {
        if (list.size() == 1) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = -2;
            setLayoutParams(layoutParams);
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.width = -1;
        setLayoutParams(layoutParams2);
    }

    private class CardSnapHelper extends PagerSnapHelper {
        private CardSnapHelper() {
        }

        public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
            int viewAdapterPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
            if (!(viewAdapterPosition == OrderCardBannerView.this.f43550b || viewAdapterPosition >= OrderCardBannerView.this.f43551c.size() || OrderCardBannerView.this.f43551c.get(viewAdapterPosition) == null)) {
                int unused = OrderCardBannerView.this.f43550b = viewAdapterPosition;
            }
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        }
    }

    private class OrderCardBannerAdapter extends RecyclerView.Adapter<ItemViewHolder> {
        private final WeakReference<OrderCardBannerView> mBanner;
        List<OrderCardBannerModel> mBannerRvModelList;

        OrderCardBannerAdapter(OrderCardBannerView orderCardBannerView, List<OrderCardBannerModel> list) {
            ArrayList arrayList = new ArrayList();
            this.mBannerRvModelList = arrayList;
            arrayList.clear();
            this.mBannerRvModelList.addAll(list);
            this.mBanner = new WeakReference<>(orderCardBannerView);
        }

        public int getItemCount() {
            return this.mBannerRvModelList.size();
        }

        public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
            final OrderCardBannerModel orderCardBannerModel = this.mBannerRvModelList.get(i);
            FlyImageLoader.loadImageUnspecified(OrderCardBannerView.this.getContext(), orderCardBannerModel.mBannerIcon).placeholder(orderCardBannerModel.mBannerDefalutIcon).into((ImageView) itemViewHolder.mBannerImage);
            itemViewHolder.mBannerName.setText(orderCardBannerModel.mBannerName);
            if (orderCardBannerModel.mBannerNameMaxLines > 0) {
                itemViewHolder.mBannerName.setMaxLines(orderCardBannerModel.mBannerNameMaxLines);
                itemViewHolder.mBannerName.setEllipsize(TextUtils.TruncateAt.END);
            }
            if (!TextUtils.isEmpty(orderCardBannerModel.mBannerContent)) {
                itemViewHolder.mBannerContent.setVisibility(0);
                itemViewHolder.mBannerContent.setText(orderCardBannerModel.mBannerContent);
            } else {
                itemViewHolder.mBannerContent.setVisibility(8);
                if (i == 0) {
                    itemViewHolder.mBannerName.setTextColor(OrderCardBannerView.this.getResources().getColor(R.color.rf_color_gery_1_0_000000));
                } else {
                    itemViewHolder.mBannerName.setTextColor(OrderCardBannerView.this.getResources().getColor(R.color.rf_color_gery_3_60_999999));
                }
            }
            if (orderCardBannerModel.mNeedContactMessage) {
                itemViewHolder.mBannerMessage.setVisibility(0);
                itemViewHolder.mBannerMessageDot.setVisibility(8);
                if (orderCardBannerModel.contactRole == 2) {
                    ImMessageHelper.getInstance().setRiderMessageUnreadCountListener(orderCardBannerModel.mRiderUid, "rider", new IMSessionUnreadCallback() {
                        public final void unReadCount(int i) {
                            OrderCardBannerView.OrderCardBannerAdapter.lambda$onBindViewHolder$0(OrderCardBannerView.OrderCardBannerAdapter.ItemViewHolder.this, i);
                        }
                    });
                }
                if (orderCardBannerModel.contactRole == 1) {
                    ImMessageHelper.getInstance().setMerchantMessageUnreadCountListener(orderCardBannerModel.mBusinessUid, "merchant", new IMSessionUnreadCallback() {
                        public final void unReadCount(int i) {
                            OrderCardBannerView.OrderCardBannerAdapter.lambda$onBindViewHolder$1(OrderCardBannerView.OrderCardBannerAdapter.ItemViewHolder.this, i);
                        }
                    });
                }
                itemViewHolder.mBannerMessage.setOnClickListener(new View.OnClickListener(itemViewHolder) {
                    public final /* synthetic */ OrderCardBannerView.OrderCardBannerAdapter.ItemViewHolder f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        OrderCardBannerView.OrderCardBannerAdapter.lambda$onBindViewHolder$2(OrderCardBannerView.OrderCardBannerModel.this, this.f$1, view);
                    }
                });
            } else {
                itemViewHolder.mBannerMessage.setVisibility(8);
                itemViewHolder.mBannerMessageDot.setVisibility(8);
                itemViewHolder.mBannerMessage.setOnClickListener((View.OnClickListener) null);
            }
            if (orderCardBannerModel.mNeedContactPhone) {
                itemViewHolder.mBannerPhone.setVisibility(0);
                if (orderCardBannerModel.mPhoneProtected) {
                    itemViewHolder.mBannerPhone.setText(OrderCardBannerView.this.getResources().getString(R.string.customer_common_icon_number_protection));
                } else {
                    itemViewHolder.mBannerPhone.setText(OrderCardBannerView.this.getResources().getString(R.string.customer_common_icon_telephone));
                }
                itemViewHolder.mBannerPhone.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (orderCardBannerModel.mContactListener != null) {
                            orderCardBannerModel.mContactListener.contactPhone(orderCardBannerModel.contactRole);
                        }
                    }
                });
                return;
            }
            itemViewHolder.mBannerPhone.setVisibility(8);
            itemViewHolder.mBannerPhone.setOnClickListener((View.OnClickListener) null);
        }

        static /* synthetic */ void lambda$onBindViewHolder$0(ItemViewHolder itemViewHolder, int i) {
            if (i <= 0 || itemViewHolder.mBannerMessageDot.getWindowVisibility() != 0) {
                itemViewHolder.mBannerMessageDot.setVisibility(8);
            } else {
                itemViewHolder.mBannerMessageDot.setVisibility(0);
            }
        }

        static /* synthetic */ void lambda$onBindViewHolder$1(ItemViewHolder itemViewHolder, int i) {
            if (i <= 0 || itemViewHolder.mBannerMessageDot.getWindowVisibility() != 0) {
                itemViewHolder.mBannerMessageDot.setVisibility(8);
            } else {
                itemViewHolder.mBannerMessageDot.setVisibility(0);
            }
        }

        static /* synthetic */ void lambda$onBindViewHolder$2(OrderCardBannerModel orderCardBannerModel, ItemViewHolder itemViewHolder, View view) {
            if (orderCardBannerModel.mContactListener != null) {
                orderCardBannerModel.mContactListener.contactMessage(orderCardBannerModel.contactRole);
                itemViewHolder.mBannerMessageDot.setVisibility(8);
            }
        }

        public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_item_order_card_banner, viewGroup, false);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            if (this.mBannerRvModelList.size() == 1) {
                layoutParams.width = ((CustomerSystemUtil.getScreenWidth(viewGroup.getContext()) - ((OrderCardBannerView) this.mBanner.get()).mFirstDecorationWidth) - ((OrderCardBannerView) this.mBanner.get()).mEndDecorationWidth) - (OrderCardBannerView.this.getResources().getDimensionPixelOffset(R.dimen.customer_16px) * 2);
            } else {
                layoutParams.width = (((CustomerSystemUtil.getScreenWidth(viewGroup.getContext()) - ((OrderCardBannerView) this.mBanner.get()).mFirstDecorationWidth) - ((OrderCardBannerView) this.mBanner.get()).mEndDecorationWidth) - (((OrderCardBannerView) this.mBanner.get()).mMidDecorationWidth * 2)) - (OrderCardBannerView.this.getResources().getDimensionPixelOffset(R.dimen.customer_16px) * 2);
            }
            inflate.setLayoutParams(layoutParams);
            return new ItemViewHolder(inflate);
        }

        class ItemViewHolder extends RecyclerView.ViewHolder {
            /* access modifiers changed from: private */
            public final TextView mBannerContent;
            /* access modifiers changed from: private */
            public final CircleImageView mBannerImage;
            /* access modifiers changed from: private */
            public IconTextView mBannerMessage;
            /* access modifiers changed from: private */
            public ImageView mBannerMessageDot;
            /* access modifiers changed from: private */
            public final TextView mBannerName;
            /* access modifiers changed from: private */
            public IconTextView mBannerPhone;

            ItemViewHolder(View view) {
                super(view);
                this.mBannerImage = (CircleImageView) view.findViewById(R.id.customer_custom_banner_icon);
                this.mBannerName = (TextView) view.findViewById(R.id.customer_tv_banner_name);
                this.mBannerContent = (TextView) view.findViewById(R.id.customer_tv_banner_content);
                this.mBannerMessage = (IconTextView) view.findViewById(R.id.customer_iv_message);
                this.mBannerPhone = (IconTextView) view.findViewById(R.id.customer_iv_phone);
                this.mBannerMessageDot = (ImageView) view.findViewById(R.id.customer_iv_message_dot);
            }
        }
    }
}
