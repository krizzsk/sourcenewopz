package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.view.webview.WalletWebActivity;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.wallet.global.wallet.contract.WalletNewPayMethodListContract;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletNewPayMethodAdapter;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.unifiedPay.util.UIUtils;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.taxis99.R;

public class WalletNewPayMethodListView extends LinearLayout implements WalletNewPayMethodListContract.View {

    /* renamed from: a */
    private TextView f32445a;

    /* renamed from: b */
    private RoundedLinearLayout f32446b;

    /* renamed from: c */
    private TextView f32447c;

    /* renamed from: d */
    private RecyclerView f32448d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WalletNewPayMethodAdapter f32449e;

    /* renamed from: f */
    private TextView f32450f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Context f32451g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public WalletNewPayMethodListContract.Listener f32452h;

    public WalletNewPayMethodListView(Context context) {
        super(context);
        m23017a(context);
    }

    public WalletNewPayMethodListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m23017a(context);
    }

    public WalletNewPayMethodListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m23017a(context);
    }

    /* renamed from: a */
    private void m23017a(Context context) {
        this.f32451g = context;
        LayoutInflater.from(context).inflate(R.layout.wallet_global_new_paymethod_list, this);
        this.f32445a = (TextView) findViewById(R.id.tv_paymethod_title);
        this.f32446b = (RoundedLinearLayout) findViewById(R.id.rll_paymethod_list_container);
        this.f32447c = (TextView) findViewById(R.id.tv_paymethod_list_top_tips);
        this.f32448d = (RecyclerView) findViewById(R.id.rv_paymethod_list);
        this.f32450f = (TextView) findViewById(R.id.transaction_entrance);
        m23020b(context);
    }

    /* renamed from: b */
    private void m23020b(Context context) {
        this.f32451g = context;
        setOrientation(1);
        this.f32446b.setRectAdius((float) UIUtil.dip2px(this.f32451g, 20.0f));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        this.f32448d.setLayoutManager(linearLayoutManager);
        this.f32448d.setItemAnimator(new DefaultItemAnimator());
        ItemDivider itemDivider = new ItemDivider(this.f32451g, 1);
        itemDivider.setDrawable(ResourcesHelper.getDrawable(this.f32451g, R.drawable.wallet_balance_history_list_divider));
        this.f32448d.addItemDecoration(itemDivider);
        this.f32448d.setNestedScrollingEnabled(false);
        WalletNewPayMethodAdapter walletNewPayMethodAdapter = new WalletNewPayMethodAdapter(context);
        this.f32449e = walletNewPayMethodAdapter;
        walletNewPayMethodAdapter.setCallback(new WalletNewPayMethodAdapter.Callback() {
            public void onItemClicked(int i) {
                if (WalletNewPayMethodListView.this.f32452h != null) {
                    WalletNewPayMethodListView.this.f32452h.onNewPayMethodItemClicked(i);
                }
            }

            public void onItemRightLabelClicked(int i) {
                WalletNewPayMethodListContract.ItemModel itemModel = WalletNewPayMethodListView.this.f32449e.getData().get(i);
                if (itemModel != null && !TextUtils.isEmpty(itemModel.rightClickLink)) {
                    DRouter.build(itemModel.rightClickLink).start((Context) null);
                } else if (WalletNewPayMethodListView.this.f32452h != null) {
                    WalletNewPayMethodListView.this.f32452h.onNewPayMethodItemRightLabelClicked(i);
                }
            }
        });
        this.f32448d.setAdapter(this.f32449e);
    }

    public void setStyle(int i) {
        if (i == 1) {
            m23019b();
        } else if (i == 2) {
            m23016a();
        }
    }

    /* renamed from: a */
    private void m23016a() {
        this.f32445a.setTextSize(19.0f);
        this.f32449e.setItemBgSelector(R.drawable.one_payment_base_common_item_bg_selector);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        if (marginLayoutParams != null) {
            int dip2px = UIUtils.dip2px(this.f32451g, 18.0f);
            marginLayoutParams.rightMargin = dip2px;
            marginLayoutParams.leftMargin = dip2px;
            marginLayoutParams.setMarginStart(dip2px);
            marginLayoutParams.setMarginEnd(dip2px);
            setLayoutParams(marginLayoutParams);
        }
        this.f32448d.setBackgroundColor(-1);
    }

    /* renamed from: b */
    private void m23019b() {
        this.f32449e.setItemBgSelector(R.drawable.wallet_global_home_pay_method_item_bg_selector);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = UIUtils.dip2px(this.f32451g, 18.0f);
            marginLayoutParams.leftMargin = UIUtils.dip2px(this.f32451g, 18.0f);
            setLayoutParams(marginLayoutParams);
        }
        this.f32448d.setBackgroundColor(ResourcesHelper.getColor(this.f32451g, R.color.wallet_color_F8F9FA));
    }

    public void updateContent(final WalletNewPayMethodListContract.Model model) {
        int i = 8;
        if (model == null) {
            setVisibility(8);
            return;
        }
        this.f32445a.setVisibility(TextUtils.isEmpty(model.title) ? 8 : 0);
        this.f32445a.setText(model.title);
        if (TextUtils.isEmpty(model.transEntrance)) {
            this.f32450f.setVisibility(8);
        } else {
            this.f32450f.setVisibility(0);
            this.f32450f.setText(model.transEntrance);
        }
        TextView textView = this.f32447c;
        if (!TextUtils.isEmpty(model.topTips)) {
            i = 0;
        }
        textView.setVisibility(i);
        this.f32447c.setText(model.topTips);
        if (model.topTipsTextColor != 0) {
            this.f32447c.setTextColor(ResUtils.getColor(model.topTipsTextColor));
        }
        if (model.topTipsBgColor != 0) {
            this.f32447c.setBackgroundResource(model.topTipsBgColor);
        }
        if (!TextUtils.isEmpty(model.faqLink)) {
            this.f32447c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WebBrowserUtil.startInternalWebActivity(WalletNewPayMethodListView.this.f32451g, model.faqLink, "");
                }
            });
        }
        if (!TextUtils.isEmpty(model.entranceLink)) {
            this.f32450f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WalletWebActivity.launch(WalletNewPayMethodListView.this.f32451g, "", model.entranceLink);
                }
            });
        }
        this.f32449e.setData(model.items);
    }

    public void setListener(WalletNewPayMethodListContract.Listener listener) {
        this.f32452h = listener;
    }

    private static class ItemDivider extends DividerItemDecoration {
        private final Rect mBounds = new Rect();
        private Drawable mDivider;
        private int mInnerPaddingLeft;

        public ItemDivider(Context context, int i) {
            super(context, i);
            this.mInnerPaddingLeft = UIUtils.dip2px(context, 54.0f);
        }

        public void setDrawable(Drawable drawable) {
            super.setDrawable(drawable);
            this.mDivider = drawable;
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            int i;
            int i2;
            if (recyclerView.getLayoutManager() != null && this.mDivider != null) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    i = recyclerView.getPaddingLeft();
                    i2 = recyclerView.getWidth() - recyclerView.getPaddingRight();
                    canvas.clipRect(i, recyclerView.getPaddingTop(), i2, recyclerView.getHeight() - recyclerView.getPaddingBottom());
                } else {
                    i2 = recyclerView.getWidth();
                    i = 0;
                }
                int childCount = recyclerView.getChildCount();
                for (int i3 = 0; i3 < childCount - 1; i3++) {
                    View childAt = recyclerView.getChildAt(i3);
                    recyclerView.getDecoratedBoundsWithMargins(childAt, this.mBounds);
                    int round = this.mBounds.bottom + Math.round(childAt.getTranslationY());
                    this.mDivider.setBounds(getPaddingLeftByPosition(i3, childCount) + i, round - this.mDivider.getIntrinsicHeight(), i2, round);
                    this.mDivider.draw(canvas);
                }
                canvas.restore();
            }
        }

        private int getPaddingLeftByPosition(int i, int i2) {
            if (i == i2 - 2) {
                return 0;
            }
            return this.mInnerPaddingLeft;
        }
    }
}
