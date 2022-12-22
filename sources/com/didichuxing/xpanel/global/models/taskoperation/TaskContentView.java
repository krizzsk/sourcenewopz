package com.didichuxing.xpanel.global.models.taskoperation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.taxis99.R;
import java.util.ArrayList;

public class TaskContentView extends FrameLayout {

    /* renamed from: a */
    private int f49520a;

    /* renamed from: b */
    private Context f49521b;

    /* renamed from: c */
    private ArrayList<View> f49522c;

    /* renamed from: d */
    private View f49523d;

    /* renamed from: e */
    private int f49524e;

    /* renamed from: f */
    private int f49525f;

    /* renamed from: g */
    private int f49526g;

    public TaskContentView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TaskContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TaskContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f49522c = new ArrayList<>();
        m35752a(context);
    }

    /* renamed from: a */
    private void m35752a(Context context) {
        this.f49521b = context;
        this.f49520a = getResources().getDimensionPixelSize(R.dimen._2dp);
        m35753b();
        this.f49524e = getResources().getDimensionPixelSize(R.dimen.oc_x_panel_task_tag_image_width);
        this.f49525f = getResources().getDimensionPixelSize(R.dimen.oc_x_panel_task_tag_image_height);
    }

    /* renamed from: b */
    private void m35753b() {
        this.f49523d = new View(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f49520a);
        this.f49523d.setBackgroundResource(R.drawable.oc_x_panel_task_progress_default);
        addView(this.f49523d, layoutParams);
    }

    private class TaskViewTag {
        public View dot;
        public View imgTag;
        public View take_bg;
        public View ticket_bg;

        private TaskViewTag() {
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e2, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo121636a(com.didichuxing.xpanel.global.models.taskoperation.ResourceGetter r14, com.didichuxing.xpanel.global.models.taskoperation.TaskOperationData r15) {
        /*
            r13 = this;
            monitor-enter(r13)
            int r0 = r15.finishCount     // Catch:{ all -> 0x00e3 }
            r13.f49526g = r0     // Catch:{ all -> 0x00e3 }
            java.util.List<com.didichuxing.xpanel.global.models.taskoperation.TaskOperationData$Task> r0 = r15.tasks     // Catch:{ all -> 0x00e3 }
            if (r0 != 0) goto L_0x000b
            monitor-exit(r13)
            return
        L_0x000b:
            int r1 = r13.f49526g     // Catch:{ all -> 0x00e3 }
            int r2 = r0.size()     // Catch:{ all -> 0x00e3 }
            if (r1 <= r2) goto L_0x0015
            monitor-exit(r13)
            return
        L_0x0015:
            r1 = 0
            if (r0 != 0) goto L_0x001a
            r2 = 0
            goto L_0x001e
        L_0x001a:
            int r2 = r0.size()     // Catch:{ all -> 0x00e3 }
        L_0x001e:
            if (r2 != 0) goto L_0x0027
            java.util.ArrayList<android.view.View> r14 = r13.f49522c     // Catch:{ all -> 0x00e3 }
            r14.clear()     // Catch:{ all -> 0x00e3 }
            goto L_0x00e1
        L_0x0027:
            java.util.ArrayList<android.view.View> r3 = r13.f49522c     // Catch:{ all -> 0x00e3 }
            int r3 = r3.size()     // Catch:{ all -> 0x00e3 }
            r4 = 1
            if (r3 == r2) goto L_0x0064
            if (r3 <= r2) goto L_0x0048
            int r3 = r3 - r4
        L_0x0033:
            if (r3 < r2) goto L_0x0064
            java.util.ArrayList<android.view.View> r5 = r13.f49522c     // Catch:{ all -> 0x00e3 }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x00e3 }
            android.view.View r5 = (android.view.View) r5     // Catch:{ all -> 0x00e3 }
            r13.removeView(r5)     // Catch:{ all -> 0x00e3 }
            java.util.ArrayList<android.view.View> r5 = r13.f49522c     // Catch:{ all -> 0x00e3 }
            r5.remove(r3)     // Catch:{ all -> 0x00e3 }
            int r3 = r3 + -1
            goto L_0x0033
        L_0x0048:
            if (r2 <= r3) goto L_0x0064
        L_0x004a:
            if (r3 >= r2) goto L_0x0064
            android.view.View r5 = r13.mo121635a()     // Catch:{ all -> 0x00e3 }
            java.util.ArrayList<android.view.View> r6 = r13.f49522c     // Catch:{ all -> 0x00e3 }
            r6.add(r5)     // Catch:{ all -> 0x00e3 }
            android.widget.FrameLayout$LayoutParams r6 = new android.widget.FrameLayout$LayoutParams     // Catch:{ all -> 0x00e3 }
            int r7 = r13.f49524e     // Catch:{ all -> 0x00e3 }
            int r8 = r13.f49525f     // Catch:{ all -> 0x00e3 }
            r6.<init>(r7, r8)     // Catch:{ all -> 0x00e3 }
            r13.addView(r5, r6)     // Catch:{ all -> 0x00e3 }
            int r3 = r3 + 1
            goto L_0x004a
        L_0x0064:
            r3 = 0
        L_0x0065:
            if (r3 >= r2) goto L_0x00e1
            java.util.ArrayList<android.view.View> r5 = r13.f49522c     // Catch:{ all -> 0x00e3 }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x00e3 }
            android.view.View r5 = (android.view.View) r5     // Catch:{ all -> 0x00e3 }
            java.lang.Object r6 = r0.get(r3)     // Catch:{ all -> 0x00e3 }
            com.didichuxing.xpanel.global.models.taskoperation.TaskOperationData$Task r6 = (com.didichuxing.xpanel.global.models.taskoperation.TaskOperationData.Task) r6     // Catch:{ all -> 0x00e3 }
            int r7 = r15.finishCount     // Catch:{ all -> 0x00e3 }
            if (r3 >= r7) goto L_0x007b
            r7 = 1
            goto L_0x007c
        L_0x007b:
            r7 = 0
        L_0x007c:
            java.lang.Object r5 = r5.getTag()     // Catch:{ all -> 0x00e3 }
            com.didichuxing.xpanel.global.models.taskoperation.TaskContentView$TaskViewTag r5 = (com.didichuxing.xpanel.global.models.taskoperation.TaskContentView.TaskViewTag) r5     // Catch:{ all -> 0x00e3 }
            int r8 = r6.showStyle     // Catch:{ all -> 0x00e3 }
            r9 = 3
            r10 = 2
            if (r8 == r4) goto L_0x00aa
            if (r8 == r10) goto L_0x0097
            if (r8 == r9) goto L_0x008d
            goto L_0x00b3
        L_0x008d:
            android.view.View r8 = r5.ticket_bg     // Catch:{ all -> 0x00e3 }
            int r11 = r14.mo121631f()     // Catch:{ all -> 0x00e3 }
            r8.setBackgroundResource(r11)     // Catch:{ all -> 0x00e3 }
            goto L_0x00b3
        L_0x0097:
            android.view.View r8 = r5.take_bg     // Catch:{ all -> 0x00e3 }
            int r11 = r2 + -1
            if (r3 != r11) goto L_0x00a2
            int r11 = r14.mo121629d()     // Catch:{ all -> 0x00e3 }
            goto L_0x00a6
        L_0x00a2:
            int r11 = r14.mo121628c()     // Catch:{ all -> 0x00e3 }
        L_0x00a6:
            r8.setBackgroundResource(r11)     // Catch:{ all -> 0x00e3 }
            goto L_0x00b3
        L_0x00aa:
            android.view.View r8 = r5.dot     // Catch:{ all -> 0x00e3 }
            int r11 = r14.mo121630e()     // Catch:{ all -> 0x00e3 }
            r8.setBackgroundResource(r11)     // Catch:{ all -> 0x00e3 }
        L_0x00b3:
            android.view.View r8 = r5.dot     // Catch:{ all -> 0x00e3 }
            int r11 = r6.showStyle     // Catch:{ all -> 0x00e3 }
            r12 = 8
            if (r11 != r4) goto L_0x00bd
            r11 = 0
            goto L_0x00bf
        L_0x00bd:
            r11 = 8
        L_0x00bf:
            r8.setVisibility(r11)     // Catch:{ all -> 0x00e3 }
            android.view.View r8 = r5.ticket_bg     // Catch:{ all -> 0x00e3 }
            int r11 = r6.showStyle     // Catch:{ all -> 0x00e3 }
            if (r11 != r9) goto L_0x00ca
            r9 = 0
            goto L_0x00cc
        L_0x00ca:
            r9 = 8
        L_0x00cc:
            r8.setVisibility(r9)     // Catch:{ all -> 0x00e3 }
            android.view.View r8 = r5.take_bg     // Catch:{ all -> 0x00e3 }
            int r6 = r6.showStyle     // Catch:{ all -> 0x00e3 }
            if (r6 != r10) goto L_0x00d6
            r12 = 0
        L_0x00d6:
            r8.setVisibility(r12)     // Catch:{ all -> 0x00e3 }
            android.view.View r5 = r5.imgTag     // Catch:{ all -> 0x00e3 }
            r5.setSelected(r7)     // Catch:{ all -> 0x00e3 }
            int r3 = r3 + 1
            goto L_0x0065
        L_0x00e1:
            monitor-exit(r13)
            return
        L_0x00e3:
            r14 = move-exception
            monitor-exit(r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.global.models.taskoperation.TaskContentView.mo121636a(com.didichuxing.xpanel.global.models.taskoperation.ResourceGetter, com.didichuxing.xpanel.global.models.taskoperation.TaskOperationData):void");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            int size = this.f49522c.size();
            if (size > 0) {
                int measuredHeight = this.f49523d.getMeasuredHeight();
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int i5 = i3 - i;
                if (size > 2) {
                    int round = Math.round((((float) (((i5 - paddingLeft) - paddingRight) - (this.f49524e * size))) * 1.0f) / ((float) (size - 1)));
                    int i6 = paddingLeft;
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < size) {
                        View view = this.f49522c.get(i7);
                        int measuredWidth = view.getMeasuredWidth() + i6;
                        int i9 = measuredWidth + round;
                        view.layout(i6, 0, measuredWidth, view.getMeasuredHeight() + 0);
                        if (i8 == 0) {
                            TaskViewTag taskViewTag = (TaskViewTag) view.getTag();
                            i8 = taskViewTag.imgTag.getBottom() - (taskViewTag.imgTag.getMeasuredHeight() / 2);
                        }
                        i7++;
                        i6 = i9;
                    }
                    this.f49523d.layout(paddingLeft + (this.f49524e / 2), i8 - (measuredHeight / 2), i5 - (this.f49524e / 2), i8 + (measuredHeight / 2));
                } else if (size == 2) {
                    int i10 = (((i5 - paddingLeft) - paddingRight) - (this.f49524e * size)) / size;
                    View view2 = this.f49522c.get(1);
                    int i11 = i5 - paddingRight;
                    int measuredHeight2 = view2.getMeasuredHeight() + 0;
                    view2.layout(i11 - view2.getMeasuredWidth(), 0, i11, measuredHeight2);
                    TaskViewTag taskViewTag2 = (TaskViewTag) view2.getTag();
                    int bottom = taskViewTag2.imgTag.getBottom() - (taskViewTag2.imgTag.getMeasuredHeight() / 2);
                    View view3 = this.f49522c.get(0);
                    int i12 = i10 + paddingLeft;
                    view3.layout(i12, 0, view3.getMeasuredWidth() + i12, measuredHeight2);
                    this.f49523d.layout(paddingLeft, bottom - (measuredHeight / 2), (i5 - (this.f49524e / 2)) - paddingRight, bottom + (measuredHeight / 2));
                } else {
                    View view4 = this.f49522c.get(0);
                    int i13 = i5 - paddingRight;
                    view4.layout(i13 - view4.getMeasuredWidth(), 0, i13, view4.getMeasuredHeight() + 0);
                    TaskViewTag taskViewTag3 = (TaskViewTag) view4.getTag();
                    int bottom2 = taskViewTag3.imgTag.getBottom() - (taskViewTag3.imgTag.getMeasuredHeight() / 2);
                    this.f49523d.layout(paddingLeft, bottom2 - (measuredHeight / 2), (i5 - (this.f49524e / 2)) - paddingRight, bottom2 + (measuredHeight / 2));
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo121635a() {
        View inflate = LayoutInflater.from(this.f49521b).inflate(R.layout.oc_x_panel_task_item, (ViewGroup) null);
        TaskViewTag taskViewTag = new TaskViewTag();
        taskViewTag.take_bg = inflate.findViewById(R.id.oc_x_panel_item_take_bg);
        taskViewTag.imgTag = inflate.findViewById(R.id.oc_x_panel_item_tag);
        taskViewTag.ticket_bg = inflate.findViewById(R.id.oc_x_panel_item_ticket_bg);
        taskViewTag.dot = inflate.findViewById(R.id.oc_x_panel_item_img_dot);
        inflate.setTag(taskViewTag);
        return inflate;
    }
}
