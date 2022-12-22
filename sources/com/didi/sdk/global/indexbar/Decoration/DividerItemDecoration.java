package com.didi.sdk.global.indexbar.Decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.sdk.global.indexbar.utils.ViewUtil;
import java.util.List;

@Deprecated
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private static final int f36164a = 1;

    /* renamed from: b */
    private static final int f36165b = -1710619;

    /* renamed from: c */
    private Context f36166c;

    /* renamed from: d */
    private List<String> f36167d;

    /* renamed from: e */
    private Paint f36168e;

    /* renamed from: f */
    private int f36169f;

    /* renamed from: g */
    private int f36170g;

    public DividerItemDecoration(Context context) {
        this.f36166c = context;
        this.f36169f = ViewUtil.dip2px(context, 18.0f);
        this.f36170g = 0;
        Paint paint = new Paint();
        this.f36168e = paint;
        paint.setAntiAlias(true);
        this.f36168e.setColor(f36165b);
    }

    public DividerItemDecoration(Context context, List<String> list) {
        this(context);
        this.f36167d = list;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager) || 1 == ((LinearLayoutManager) layoutManager).getOrientation()) {
            List<String> list = this.f36167d;
            if (list == null || list.isEmpty()) {
                rect.set(0, 0, 0, 1);
                return;
            }
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = childAdapterPosition + 1;
            if (i < this.f36167d.size() && this.f36167d.get(childAdapterPosition).equals(this.f36167d.get(i))) {
                rect.set(0, 0, 0, 1);
            }
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager) || 1 == ((LinearLayoutManager) layoutManager).getOrientation()) {
            for (int i = 0; i < recyclerView.getChildCount(); i++) {
                View childAt = recyclerView.getChildAt(i);
                List<String> list = this.f36167d;
                if (list == null || list.isEmpty()) {
                    m25552a(canvas, recyclerView, childAt);
                } else {
                    int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                    int i2 = childAdapterPosition + 1;
                    if (i2 < this.f36167d.size() && this.f36167d.get(childAdapterPosition).equals(this.f36167d.get(i2))) {
                        m25552a(canvas, recyclerView, childAt);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m25552a(Canvas canvas, RecyclerView recyclerView, View view) {
        int paddingLeft = this.f36169f + recyclerView.getPaddingLeft();
        int bottom = view.getBottom() + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
        canvas.drawRect((float) paddingLeft, (float) bottom, (float) (recyclerView.getWidth() - this.f36170g), (float) (bottom + 1), this.f36168e);
    }

    public DividerItemDecoration setDevideColor(int i) {
        this.f36168e.setColor(i);
        return this;
    }
}
