package com.didi.component.operationpanel.impl.newui.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.view.GlobalTipsContainer;
import com.didi.component.common.view.GlobalTipsView;
import com.didi.component.core.IViewContainer;
import com.didi.component.operationpanel.AbsOperationPanelPresenter;
import com.didi.component.operationpanel.IOperationPanelView;
import com.didi.component.operationpanel.OperationPanelItemModel;
import com.didi.component.operationpanel.impl.newui.OperationPanelAdapterV2;
import com.didi.component.operationpanel.impl.view.OperationPanelAdapter;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.tips.TipsView;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OperationPanelViewV2 implements IViewContainer, IOperationPanelView {

    /* renamed from: a */
    private OperationPanelAdapterV2 f14792a;

    /* renamed from: b */
    private LinearLayoutManager f14793b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RecyclerView f14794c;

    /* renamed from: d */
    private GlobalTipsContainer f14795d;

    /* renamed from: e */
    private AbsOperationPanelPresenter f14796e;

    /* renamed from: f */
    private Activity f14797f;

    /* renamed from: g */
    private View.OnClickListener f14798g;

    /* renamed from: h */
    private View f14799h;

    /* renamed from: i */
    private TextView f14800i;

    public void addItem(OperationPanelItemModel operationPanelItemModel, int i) {
    }

    public void removeItem(OperationPanelItemModel operationPanelItemModel) {
    }

    public OperationPanelViewV2(Context context, ViewGroup viewGroup) {
        this.f14797f = (Activity) context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_operation_panel_new_layout, viewGroup, false);
        this.f14799h = inflate;
        this.f14800i = (TextView) inflate.findViewById(R.id.operation_panel_title);
        RecyclerView recyclerView = (RecyclerView) this.f14799h.findViewById(R.id.global_operation_panel_rv);
        this.f14794c = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f14797f);
        this.f14793b = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.f14794c.addItemDecoration(new RowDividerDecoration(context));
        this.f14794c.setLayoutManager(this.f14793b);
        OperationPanelAdapterV2 operationPanelAdapterV2 = new OperationPanelAdapterV2(this.f14797f);
        this.f14792a = operationPanelAdapterV2;
        this.f14794c.setAdapter(operationPanelAdapterV2);
    }

    public View getView() {
        return this.f14799h;
    }

    public void setPresenter(AbsOperationPanelPresenter absOperationPanelPresenter) {
        this.f14796e = absOperationPanelPresenter;
        OperationPanelAdapterV2 operationPanelAdapterV2 = this.f14792a;
        if (operationPanelAdapterV2 != null) {
            operationPanelAdapterV2.setPresenter(absOperationPanelPresenter);
        }
    }

    public void showItems(ArrayList<OperationPanelItemModel> arrayList) {
        if ((!CollectionUtil.isEmpty((Collection<?>) arrayList) ? arrayList.size() : 0) == 0) {
            this.f14794c.setVisibility(8);
            return;
        }
        this.f14794c.setVisibility(0);
        this.f14792a.setData(arrayList);
    }

    public void updateItem(OperationPanelItemModel operationPanelItemModel) {
        if (operationPanelItemModel != null && this.f14792a.getData() != null) {
            List<OperationPanelItemModel> data = this.f14792a.getData();
            int indexOf = data.indexOf(operationPanelItemModel);
            if (indexOf != -1) {
                data.remove(operationPanelItemModel);
                data.add(indexOf, operationPanelItemModel);
            }
            this.f14792a.notifyDataSetChanged();
        }
    }

    public void update(ArrayList<OperationPanelItemModel> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            List<OperationPanelItemModel> data = this.f14792a.getData();
            if (data != null) {
                data.clear();
            }
            this.f14792a.setData(arrayList);
            this.f14794c.setVisibility(0);
        }
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        AbsOperationPanelPresenter absOperationPanelPresenter = this.f14796e;
        if (absOperationPanelPresenter != null) {
            absOperationPanelPresenter.setComponentCreator(iComponentCreator);
        }
    }

    public void setVisible(boolean z) {
        View view = this.f14799h;
        if (view == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void setTitle(GlobalRichInfo globalRichInfo) {
        if (globalRichInfo != null) {
            globalRichInfo.bindTextView(this.f14800i);
        }
    }

    private class RowDividerDecoration extends RecyclerView.ItemDecoration {
        private static final float DEFAULT_DIVIDER_WIDTH_HEIGHT_DP = 0.5f;
        private Context mContext;
        private float mDividerHeight;
        private Paint mPaint = new Paint();

        public int getSpanCount() {
            return 1;
        }

        public RowDividerDecoration(Context context) {
            this.mContext = context;
            this.mPaint.setColor(Color.parseColor("#0D0A121A"));
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mDividerHeight = getPX(0.5f);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.top = (int) Math.ceil((double) this.mDividerHeight);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int spanCount = getSpanCount();
            int childCount = recyclerView.getChildCount();
            int i = childCount / spanCount;
            if (childCount % spanCount > 0) {
                i++;
            }
            if (i != 0 && spanCount != 0) {
                for (int i2 = 1; i2 < i; i2++) {
                    View childAt = recyclerView.getChildAt(i2 * spanCount);
                    RectF rectF = new RectF();
                    rectF.left = (float) UIUtils.dip2pxInt(this.mContext, 66.0f);
                    rectF.top = (float) (childAt.getTop() - linearLayoutManager.getTopDecorationHeight(childAt));
                    rectF.right = (float) (recyclerView.getWidth() - recyclerView.getPaddingRight());
                    rectF.bottom = rectF.top + this.mDividerHeight;
                    canvas.drawRect(rectF, this.mPaint);
                }
            }
        }

        private float getPX(float f) {
            return TypedValue.applyDimension(1, f, this.mContext.getResources().getDisplayMetrics());
        }
    }

    public void showPopup(OperationPanelItemModel operationPanelItemModel, String str) {
        showPopup(operationPanelItemModel, str, (View.OnClickListener) null);
    }

    public void showPopup(OperationPanelItemModel operationPanelItemModel, String str, View.OnClickListener onClickListener) {
        showPopup(operationPanelItemModel, str, 1, 0, onClickListener);
    }

    public void showPopup(OperationPanelItemModel operationPanelItemModel, String str, int i, int i2, View.OnClickListener onClickListener) {
        this.f14798g = onClickListener;
        int a = m10588a(operationPanelItemModel);
        RecyclerView.ViewHolder a2 = m10590a(a);
        if (a == -1 || a2 != null) {
            View b = m10596b(a);
            if (!b.isShown() || b.getMeasuredHeight() == 0 || b.getMeasuredWidth() == 0) {
                m10594a(b, str, i, i2);
            } else {
                m10597b(b, str, i, i2);
            }
        } else {
            m10592a(a, str, i, i2);
        }
    }

    /* renamed from: a */
    private int m10588a(OperationPanelItemModel operationPanelItemModel) {
        List<OperationPanelItemModel> data;
        OperationPanelAdapterV2 operationPanelAdapterV2 = this.f14792a;
        if (operationPanelAdapterV2 == null || (data = operationPanelAdapterV2.getData()) == null) {
            return -1;
        }
        return data.indexOf(operationPanelItemModel);
    }

    /* renamed from: a */
    private RecyclerView.ViewHolder m10590a(int i) {
        if (i != -1) {
            return this.f14794c.findViewHolderForAdapterPosition(i);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public View m10596b(int i) {
        RecyclerView.ViewHolder a = m10590a(i);
        if (a == null) {
            return null;
        }
        try {
            if (a instanceof OperationPanelAdapter.OperationPanelCommonVH) {
                return ((OperationPanelAdapter.OperationPanelCommonVH) a).mIconView;
            }
            return a.itemView;
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private void m10592a(int i, String str, int i2, int i3) {
        final int i4 = i;
        final String str2 = str;
        final int i5 = i2;
        final int i6 = i3;
        this.f14794c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                final View a = OperationPanelViewV2.this.m10596b(i4);
                if (a != null) {
                    UiThreadHandler.postDelayed(new Runnable() {
                        public void run() {
                            OperationPanelViewV2.this.m10597b(a, str2, i5, i6);
                        }
                    }, 500);
                    OperationPanelViewV2.this.f14794c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
    }

    /* renamed from: a */
    private void m10594a(View view, String str, int i, int i2) {
        final View view2 = view;
        final String str2 = str;
        final int i3 = i;
        final int i4 = i2;
        this.f14794c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                UiThreadHandler.postDelayed(new Runnable() {
                    public void run() {
                        OperationPanelViewV2.this.m10597b(view2, str2, i3, i4);
                    }
                }, 500);
                OperationPanelViewV2.this.f14794c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    /* renamed from: a */
    private void m10593a(View view, String str) {
        m10597b(view, str, 1, 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10597b(View view, String str, int i, int i2) {
        if (this.f14795d == null) {
            this.f14795d = new GlobalTipsContainer(this.f14797f);
        }
        GlobalTipsView globalTipsView = new GlobalTipsView(this.f14797f);
        globalTipsView.setTips(str);
        globalTipsView.setId(view.hashCode());
        globalTipsView.setCloseListener(this.f14798g);
        this.f14795d.showWithLocationBinded((TipsView) globalTipsView, view, i, i2, i2 == 2 ? -view.getMeasuredWidth() : 0, -ResourcesHelper.getDimensionPixelSize(this.f14797f, R.dimen._12dip));
    }

    public void dismissPopup() {
        GlobalTipsContainer globalTipsContainer = this.f14795d;
        if (globalTipsContainer != null) {
            globalTipsContainer.clearAllTips();
            this.f14798g = null;
        }
    }

    public void onRemove() {
        OperationPanelAdapterV2 operationPanelAdapterV2 = this.f14792a;
        if (operationPanelAdapterV2 != null) {
            operationPanelAdapterV2.onRemove();
        }
    }
}
