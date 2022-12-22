package com.didi.sdk.global.indexbar.Decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.sdk.global.indexbar.utils.ViewUtil;
import java.util.List;

@Deprecated
public class GroupItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private static final int f36171a = -789259;

    /* renamed from: b */
    private static final int f36172b = -16777216;

    /* renamed from: c */
    private int f36173c;

    /* renamed from: d */
    private int f36174d;

    /* renamed from: e */
    private Paint f36175e;

    /* renamed from: f */
    private TextPaint f36176f;

    /* renamed from: g */
    private Context f36177g;

    /* renamed from: h */
    private List<String> f36178h;

    public GroupItemDecoration(Context context, List<String> list) {
        this.f36177g = context;
        this.f36178h = list;
        this.f36173c = ViewUtil.dip2px(context, 28.0f);
        this.f36174d = ViewUtil.dip2px(context, 18.0f);
        Paint paint = new Paint();
        this.f36175e = paint;
        paint.setAntiAlias(true);
        this.f36175e.setColor(f36171a);
        TextPaint textPaint = new TextPaint();
        this.f36176f = textPaint;
        textPaint.setAntiAlias(true);
        this.f36176f.setColor(-16777216);
        this.f36176f.setTextSize((float) ViewUtil.sp2px(context, 14.0f));
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        List<String> list = this.f36178h;
        if (list != null && !list.isEmpty()) {
            if (!(recyclerView.getLayoutManager() instanceof LinearLayoutManager) || ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation() == 1) {
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                if (childAdapterPosition == 0 || !this.f36178h.get(childAdapterPosition).equals(this.f36178h.get(childAdapterPosition - 1))) {
                    rect.set(0, this.f36173c, 0, 0);
                }
            }
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        List<String> list = this.f36178h;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < recyclerView.getChildCount(); i++) {
                View childAt = recyclerView.getChildAt(i);
                int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                String str = this.f36178h.get(childAdapterPosition);
                if (childAdapterPosition == 0 || !str.equals(this.f36178h.get(childAdapterPosition - 1))) {
                    m25556a(canvas, recyclerView, childAt, str);
                }
            }
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDrawOver(canvas, recyclerView, state);
        List<String> list = this.f36178h;
        if (list != null && !list.isEmpty()) {
            int findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            View view = recyclerView.findViewHolderForAdapterPosition(findFirstVisibleItemPosition).itemView;
            String str = this.f36178h.get(findFirstVisibleItemPosition);
            boolean z = false;
            int i = findFirstVisibleItemPosition + 1;
            if (i < this.f36178h.size() && !str.equals(this.f36178h.get(i)) && view.getBottom() <= this.f36173c) {
                canvas.save();
                canvas.translate(0.0f, (float) ((view.getHeight() + view.getTop()) - this.f36173c));
                z = true;
            }
            m25557a(canvas, recyclerView, str);
            if (z) {
                canvas.restore();
            }
        }
    }

    /* renamed from: a */
    private void m25556a(Canvas canvas, RecyclerView recyclerView, View view, String str) {
        m25555a(canvas, m25554a(recyclerView, view), str);
    }

    /* renamed from: a */
    private void m25557a(Canvas canvas, RecyclerView recyclerView, String str) {
        m25555a(canvas, m25553a(recyclerView), str);
    }

    /* renamed from: a */
    private void m25555a(Canvas canvas, Rect rect, String str) {
        canvas.drawRect(rect, this.f36175e);
        canvas.drawText(str, (float) (rect.left + this.f36174d), (float) (rect.top + ((this.f36173c + ViewUtil.getTextHeight(this.f36176f, str)) / 2)), this.f36176f);
    }

    /* renamed from: a */
    private Rect m25554a(RecyclerView recyclerView, View view) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int top = view.getTop() - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
        return new Rect(paddingLeft, top - this.f36173c, width, top);
    }

    /* renamed from: a */
    private Rect m25553a(RecyclerView recyclerView) {
        return new Rect(recyclerView.getPaddingLeft(), 0, recyclerView.getWidth() - recyclerView.getPaddingRight(), this.f36173c);
    }
}
