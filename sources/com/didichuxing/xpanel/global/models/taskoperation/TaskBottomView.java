package com.didichuxing.xpanel.global.models.taskoperation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.taxis99.R;
import java.util.ArrayList;

public class TaskBottomView extends FrameLayout {

    /* renamed from: a */
    private Context f49515a;

    /* renamed from: b */
    private ArrayList<TextView> f49516b;

    /* renamed from: c */
    private int f49517c;

    /* renamed from: d */
    private int f49518d;

    /* renamed from: e */
    private int f49519e;

    public TaskBottomView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TaskBottomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TaskBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f49516b = new ArrayList<>();
        m35750a(context);
    }

    /* renamed from: a */
    private void m35750a(Context context) {
        this.f49515a = context;
        this.f49518d = getResources().getDimensionPixelSize(R.dimen.oc_x_panel_task_tag_image_width);
        this.f49519e = getResources().getDimensionPixelSize(R.dimen.oc_x_panel_task_bottom_text_margin);
        setClipToPadding(false);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a1, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo121633a(com.didichuxing.xpanel.global.models.taskoperation.ResourceGetter r9, com.didichuxing.xpanel.global.models.taskoperation.TaskOperationData r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r10.finishCount     // Catch:{ all -> 0x00a2 }
            r8.f49517c = r0     // Catch:{ all -> 0x00a2 }
            java.util.List<com.didichuxing.xpanel.global.models.taskoperation.TaskOperationData$Task> r0 = r10.tasks     // Catch:{ all -> 0x00a2 }
            if (r0 != 0) goto L_0x000b
            monitor-exit(r8)
            return
        L_0x000b:
            int r1 = r8.f49517c     // Catch:{ all -> 0x00a2 }
            int r2 = r0.size()     // Catch:{ all -> 0x00a2 }
            if (r1 <= r2) goto L_0x0015
            monitor-exit(r8)
            return
        L_0x0015:
            r1 = 0
            if (r0 != 0) goto L_0x001a
            r2 = 0
            goto L_0x001e
        L_0x001a:
            int r2 = r0.size()     // Catch:{ all -> 0x00a2 }
        L_0x001e:
            if (r2 != 0) goto L_0x0027
            java.util.ArrayList<android.widget.TextView> r9 = r8.f49516b     // Catch:{ all -> 0x00a2 }
            r9.clear()     // Catch:{ all -> 0x00a2 }
            goto L_0x00a0
        L_0x0027:
            java.util.ArrayList<android.widget.TextView> r3 = r8.f49516b     // Catch:{ all -> 0x00a2 }
            int r3 = r3.size()     // Catch:{ all -> 0x00a2 }
            r4 = 1
            if (r3 == r2) goto L_0x007d
            if (r3 <= r2) goto L_0x0048
            int r3 = r3 - r4
        L_0x0033:
            if (r3 < r2) goto L_0x007d
            java.util.ArrayList<android.widget.TextView> r9 = r8.f49516b     // Catch:{ all -> 0x00a2 }
            java.lang.Object r9 = r9.get(r3)     // Catch:{ all -> 0x00a2 }
            android.view.View r9 = (android.view.View) r9     // Catch:{ all -> 0x00a2 }
            r8.removeView(r9)     // Catch:{ all -> 0x00a2 }
            java.util.ArrayList<android.widget.TextView> r9 = r8.f49516b     // Catch:{ all -> 0x00a2 }
            r9.remove(r3)     // Catch:{ all -> 0x00a2 }
            int r3 = r3 + -1
            goto L_0x0033
        L_0x0048:
            if (r2 <= r3) goto L_0x007d
        L_0x004a:
            if (r3 >= r2) goto L_0x007d
            android.widget.TextView r5 = new android.widget.TextView     // Catch:{ all -> 0x00a2 }
            android.content.Context r6 = r8.f49515a     // Catch:{ all -> 0x00a2 }
            r5.<init>(r6)     // Catch:{ all -> 0x00a2 }
            r6 = 1094713344(0x41400000, float:12.0)
            r5.setTextSize(r6)     // Catch:{ all -> 0x00a2 }
            android.content.res.Resources r6 = r8.getResources()     // Catch:{ all -> 0x00a2 }
            int r7 = r9.mo121632g()     // Catch:{ all -> 0x00a2 }
            android.content.res.ColorStateList r6 = r6.getColorStateList(r7)     // Catch:{ all -> 0x00a2 }
            r5.setTextColor(r6)     // Catch:{ all -> 0x00a2 }
            int r6 = r8.f49519e     // Catch:{ all -> 0x00a2 }
            r5.setPadding(r1, r1, r1, r6)     // Catch:{ all -> 0x00a2 }
            java.util.ArrayList<android.widget.TextView> r6 = r8.f49516b     // Catch:{ all -> 0x00a2 }
            r6.add(r5)     // Catch:{ all -> 0x00a2 }
            android.view.ViewGroup$LayoutParams r6 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x00a2 }
            r7 = -2
            r6.<init>(r7, r7)     // Catch:{ all -> 0x00a2 }
            r8.addView(r5, r6)     // Catch:{ all -> 0x00a2 }
            int r3 = r3 + 1
            goto L_0x004a
        L_0x007d:
            r9 = 0
        L_0x007e:
            if (r9 >= r2) goto L_0x00a0
            java.util.ArrayList<android.widget.TextView> r3 = r8.f49516b     // Catch:{ all -> 0x00a2 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ all -> 0x00a2 }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ all -> 0x00a2 }
            java.lang.Object r5 = r0.get(r9)     // Catch:{ all -> 0x00a2 }
            com.didichuxing.xpanel.global.models.taskoperation.TaskOperationData$Task r5 = (com.didichuxing.xpanel.global.models.taskoperation.TaskOperationData.Task) r5     // Catch:{ all -> 0x00a2 }
            int r6 = r10.finishCount     // Catch:{ all -> 0x00a2 }
            if (r9 >= r6) goto L_0x0094
            r6 = 1
            goto L_0x0095
        L_0x0094:
            r6 = 0
        L_0x0095:
            java.lang.String r5 = r5.bottom     // Catch:{ all -> 0x00a2 }
            r3.setText(r5)     // Catch:{ all -> 0x00a2 }
            r3.setSelected(r6)     // Catch:{ all -> 0x00a2 }
            int r9 = r9 + 1
            goto L_0x007e
        L_0x00a0:
            monitor-exit(r8)
            return
        L_0x00a2:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.global.models.taskoperation.TaskBottomView.mo121633a(com.didichuxing.xpanel.global.models.taskoperation.ResourceGetter, com.didichuxing.xpanel.global.models.taskoperation.TaskOperationData):void");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            int size = this.f49516b.size();
            if (size > 0) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int i5 = i3 - i;
                if (size > 2) {
                    int i6 = size - 1;
                    int round = Math.round((((float) (((i5 - paddingLeft) - paddingRight) - (this.f49518d * size))) * 1.0f) / ((float) i6));
                    int i7 = 0;
                    while (i7 < size) {
                        View view = this.f49516b.get(i7);
                        int measuredHeight = view.getMeasuredHeight();
                        int measuredWidth = view.getMeasuredWidth();
                        int i8 = this.f49518d + paddingLeft;
                        int i9 = i8 + round;
                        int i10 = measuredHeight + 0;
                        if (i7 == 0) {
                            if (measuredWidth < this.f49518d) {
                                int i11 = paddingLeft + i8;
                                view.layout((i11 - measuredWidth) / 2, 0, (i11 + measuredWidth) / 2, i10);
                            } else {
                                view.layout(paddingLeft, 0, measuredWidth + paddingLeft, i10);
                            }
                        } else if (i7 != i6) {
                            int i12 = paddingLeft + i8;
                            view.layout((i12 - measuredWidth) / 2, 0, (i12 + measuredWidth) / 2, i10);
                        } else if (measuredWidth < this.f49518d) {
                            int i13 = paddingLeft + i8;
                            view.layout((i13 - measuredWidth) / 2, 0, (i13 + measuredWidth) / 2, i10);
                        } else {
                            view.layout(i8 - measuredWidth, 0, i8, i10);
                        }
                        i7++;
                        paddingLeft = i9;
                    }
                } else if (size == 2) {
                    int i14 = (((i5 - paddingLeft) - paddingRight) - (this.f49518d * size)) / size;
                    View view2 = this.f49516b.get(1);
                    int i15 = i5 - paddingRight;
                    int i16 = i15 - this.f49518d;
                    int measuredHeight2 = view2.getMeasuredHeight() + 0;
                    int measuredWidth2 = view2.getMeasuredWidth();
                    if (measuredWidth2 < this.f49518d) {
                        int i17 = i16 + i15;
                        view2.layout((i17 - measuredWidth2) / 2, 0, (i17 + measuredWidth2) / 2, measuredHeight2);
                    } else {
                        view2.layout(i15 - measuredWidth2, 0, i15, measuredHeight2);
                    }
                    View view3 = this.f49516b.get(0);
                    int i18 = paddingLeft + i14;
                    int i19 = i18 + this.f49518d + i18;
                    view3.layout((i19 - view3.getMeasuredWidth()) / 2, 0, (i19 + view3.getMeasuredWidth()) / 2, measuredHeight2);
                } else {
                    View view4 = this.f49516b.get(0);
                    int i20 = i5 - paddingRight;
                    int measuredHeight3 = view4.getMeasuredHeight() + 0;
                    int measuredWidth3 = view4.getMeasuredWidth();
                    int i21 = i20 - this.f49518d;
                    if (measuredWidth3 < this.f49518d) {
                        int i22 = i21 + i20;
                        view4.layout((i22 - measuredWidth3) / 2, 0, (i22 + measuredWidth3) / 2, measuredHeight3);
                        return;
                    }
                    view4.layout(i20 - measuredWidth3, 0, i20, measuredHeight3);
                }
            }
        } catch (Exception unused) {
        }
    }
}
