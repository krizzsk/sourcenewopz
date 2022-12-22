package com.didi.payment.wallet.global.wallet.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.utils.PayBaseConfigUtil;
import com.didi.payment.base.web.WalletDiminaUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.basemodel.helper.AccountFreezeConfirmDialogHelper;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletCommonContract;
import com.didi.payment.wallet.global.wallet.contract.WalletMainListSettingContract;
import com.didi.payment.wallet.global.wallet.entity.WalletSettingPageInfo;
import com.didi.payment.wallet.global.wallet.presenter.WalletMainListSettingPresenter;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletMainListSettingListAdapter;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.io.Serializable;
import java.util.List;

public class WalletMainListSettingActivity extends WalletBaseActivity implements View.OnClickListener, WalletMainListSettingContract.View {
    public static final int REQ_CODE_FAST_PAY_SETTING = 10001;

    /* renamed from: a */
    WalletSettingPageInfo f32151a = null;

    /* renamed from: b */
    private ImageView f32152b;

    /* renamed from: c */
    private RecyclerView f32153c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WalletMainListSettingListAdapter f32154d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WalletMainListSettingContract.Presenter f32155e;

    public void initLoadingDialog(Activity activity) {
    }

    public void releaseLoadingDialog() {
    }

    public void setListener(WalletCommonContract.NullListener nullListener) {
    }

    public static void startActivity(Context context, WalletSettingPageInfo walletSettingPageInfo) {
        Intent intent = new Intent(context, WalletMainListSettingActivity.class);
        intent.putExtra(WalletExtraConstant.Key.WALLET_SIDEBAR_PAGE_MODEL, walletSettingPageInfo);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_mainlist_setting);
        m22834a(getIntent());
        m22833a();
        WalletMainListSettingPresenter walletMainListSettingPresenter = new WalletMainListSettingPresenter(this, this);
        this.f32155e = walletMainListSettingPresenter;
        walletMainListSettingPresenter.init();
        m22836b();
    }

    /* renamed from: a */
    private void m22834a(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra(WalletExtraConstant.Key.WALLET_SIDEBAR_PAGE_MODEL);
        if (serializableExtra instanceof WalletSettingPageInfo) {
            this.f32151a = (WalletSettingPageInfo) serializableExtra;
        }
    }

    /* renamed from: a */
    private void m22833a() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_left);
        this.f32152b = imageView;
        imageView.setOnClickListener(this);
        this.f32153c = (RecyclerView) findViewById(R.id.rv_mainlist_setting_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.f32153c.setLayoutManager(linearLayoutManager);
        this.f32153c.setItemAnimator(new DefaultItemAnimator());
        ItemDivider itemDivider = new ItemDivider(this, 1);
        itemDivider.setDrawable(ResourcesHelper.getDrawable(this, R.drawable.wallet_balance_history_list_divider));
        this.f32153c.addItemDecoration(itemDivider);
        WalletMainListSettingListAdapter walletMainListSettingListAdapter = new WalletMainListSettingListAdapter(this);
        this.f32154d = walletMainListSettingListAdapter;
        walletMainListSettingListAdapter.setCallback(new WalletMainListSettingListAdapter.Callback() {
            public void onSettingItemClicked(int i, String str, WalletMainListSettingContract.SettingItemModel settingItemModel) {
                if (i == 2 && WalletMainListSettingActivity.this.f32151a != null && WalletMainListSettingActivity.this.f32151a.freezonData != null && WalletMainListSettingActivity.this.f32151a.freezonData.isFrozen()) {
                    if (AccountFreezeConfirmDialogHelper.showAccountFrozenConfirmDialog2(WalletMainListSettingActivity.this, (AccountFreezeData) AccountFreezeData.Builder.from(WalletMainListSettingActivity.this.f32151a.freezonData).btnPos(ResourcesHelper.getString(WalletMainListSettingActivity.this, R.string.GRider_Unfreeze_Details_cscc)).btnNeg(ResourcesHelper.getString(WalletMainListSettingActivity.this, R.string.GRider_Unfreeze_Confirmation_bqam)).putExtra("entrance", -1).build())) {
                        return;
                    }
                }
                WalletSPUtils.setIsShowSettingRedDot(WalletMainListSettingActivity.this.getContext(), settingItemModel.type, true);
                if (WalletMainListSettingActivity.this.f32154d != null) {
                    WalletMainListSettingActivity.this.f32154d.refreshRedDot(settingItemModel.type);
                }
                WalletMainListSettingActivity.this.f32155e.onSettingItemClicked(i, str, settingItemModel.subSetting);
            }
        });
        this.f32153c.setAdapter(this.f32154d);
        initLoadingDialog(this, R.id.layout_title_bar);
    }

    /* renamed from: b */
    private void m22836b() {
        if (PayBaseConfigUtil.isDebugMode()) {
            View findViewById = findViewById(R.id.tv_diminaDebug);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WalletDiminaUtil.INSTANCE.openDebugModel();
                }
            });
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.iv_left) {
            finish();
        }
    }

    public void updateContent(List<WalletMainListSettingContract.SettingItemModel> list) {
        WalletMainListSettingListAdapter walletMainListSettingListAdapter = this.f32154d;
        if (walletMainListSettingListAdapter != null) {
            walletMainListSettingListAdapter.setData(list);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 4) {
            if (i != 10001) {
                return;
            }
        } else if (i2 == -1) {
            finish();
        }
        if (i2 == -1) {
            this.f32155e.requestData();
        }
    }

    public void onUpdate(WalletSettingPageInfo walletSettingPageInfo) {
        this.f32151a = walletSettingPageInfo;
    }

    protected static class ItemDivider extends DividerItemDecoration {
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
            return this.mInnerPaddingLeft;
        }
    }
}
