package com.didichuxing.xpanel.global.models.taskoperation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.xpanel.models.AbsXPanelAgentModelView;
import com.taxis99.R;

public class TaskOperationView extends AbsXPanelAgentModelView<TaskOperationData> {

    /* renamed from: a */
    private TextView f49528a;

    /* renamed from: b */
    private TaskContentView f49529b;

    /* renamed from: c */
    private LinearLayout f49530c;

    /* renamed from: d */
    private TextView f49531d;

    /* renamed from: e */
    private TextView f49532e;

    /* renamed from: f */
    private TaskBottomView f49533f;

    /* renamed from: g */
    private ResourceGetter f49534g;

    public boolean contain(float f, float f2) {
        return false;
    }

    public int getMarginLeft() {
        return 0;
    }

    public int getMarginRight() {
        return 0;
    }

    public void initView() {
        this.f49534g = new ResourceGetter(TaskParseHelper.isGlobal(this.mContext));
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        this.f49530c = linearLayout;
        linearLayout.setOrientation(1);
        this.f49530c.setBackgroundColor(this.mContext.getResources().getColor(R.color.oc_color_FFFFFF));
        ViewGroup.LayoutParams layoutParams = this.f49530c.getLayoutParams();
        if (!(layoutParams instanceof RecyclerView.LayoutParams)) {
            this.f49530c.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        } else if (layoutParams.width != -1) {
            layoutParams.width = -1;
            this.f49530c.setLayoutParams(layoutParams);
        }
        LayoutInflater.from(this.mContext).inflate(R.layout.oc_x_panel_task_view, this.f49530c);
        this.f49528a = (TextView) this.f49530c.findViewById(R.id.oc_x_panel_title_txt);
        this.f49529b = (TaskContentView) this.f49530c.findViewById(R.id.oc_x_pane_task_content);
        this.f49533f = (TaskBottomView) this.f49530c.findViewById(R.id.oc_x_pane_task_bottom);
        TextView textView = (TextView) this.f49530c.findViewById(R.id.oc_x_panel_task_detail_btn);
        this.f49531d = textView;
        textView.setBackgroundResource(this.f49534g.mo121626a());
        this.f49531d.setTextColor(ContextCompat.getColor(this.mContext, this.f49534g.mo121627b()));
        this.f49532e = (TextView) this.f49530c.findViewById(R.id.oc_x_panel_task_description);
    }

    public View getView() {
        return createBgContainer(this.f49530c);
    }

    public int halfHeight() {
        return this.f49530c.getMeasuredHeight() / 2;
    }

    public void bind(final TaskOperationData taskOperationData) {
        if (!TextUtils.isEmpty(taskOperationData.mainTitle)) {
            this.f49528a.setText(taskOperationData.mainTitle);
        } else {
            this.f49528a.setText("");
        }
        if (TextUtils.isEmpty(taskOperationData.linkTitle) || TextUtils.isEmpty(taskOperationData.link)) {
            this.f49531d.setVisibility(8);
        } else {
            this.f49531d.setText(taskOperationData.linkTitle);
            this.f49531d.setVisibility(0);
        }
        if (!TextUtils.isEmpty(taskOperationData.title)) {
            this.f49532e.setText(taskOperationData.title);
            this.f49532e.setVisibility(0);
        } else {
            this.f49532e.setVisibility(8);
        }
        this.f49531d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TaskOperationView.this.mListener != null && !TextUtils.isEmpty(taskOperationData.link) && !TaskOperationView.this.mListener.dispatchClickUri(taskOperationData.link, TaskOperationView.this.mCardData, "button_0")) {
                    TaskOperationView.this.mListener.clickUri(taskOperationData.link, TaskOperationView.this.mCardData);
                }
                TaskOperationView.this.clickButtonOmega();
            }
        });
        this.f49530c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TaskOperationView.this.mListener != null && !TaskOperationView.this.mListener.dispatchClickUri("", TaskOperationView.this.mCardData, "card")) {
                    TaskOperationView.this.mListener.clickUri("", TaskOperationView.this.mCardData);
                }
                TaskOperationView.this.clickCardOmega();
            }
        });
        this.f49529b.mo121636a(this.f49534g, taskOperationData);
        this.f49533f.mo121633a(this.f49534g, taskOperationData);
    }

    public void destroy() {
        super.destroy();
    }
}
