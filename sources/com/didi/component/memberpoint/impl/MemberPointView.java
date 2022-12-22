package com.didi.component.memberpoint.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.StringUtil;
import com.didi.component.memberpoint.AbsMemberPointPresenter;
import com.didi.component.memberpoint.IMemberPointView;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.taxis99.R;

public class MemberPointView implements IMemberPointView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AbsMemberPointPresenter f14581a;

    /* renamed from: b */
    private View f14582b;

    /* renamed from: c */
    private Context f14583c;

    /* renamed from: d */
    private TextView f14584d = ((TextView) this.f14582b.findViewById(R.id.tv_global_memberpoint_label));

    /* renamed from: e */
    private ImageView f14585e;

    public void setMemberpoint(String str) {
    }

    public MemberPointView(Context context, ViewGroup viewGroup) {
        this.f14583c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_memberpoint_select, viewGroup, false);
        this.f14582b = inflate;
        this.f14585e = (ImageView) inflate.findViewById(R.id.iv_global_memberpoint_icon);
        this.f14582b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MemberPointView.this.f14581a.onMemberpointClick();
            }
        });
    }

    public View getView() {
        return this.f14582b;
    }

    public void setPresenter(AbsMemberPointPresenter absMemberPointPresenter) {
        this.f14581a = absMemberPointPresenter;
    }

    public void setIcon(String str) {
        if (!StringUtil.isNullOrEmpty(str) && this.f14585e != null) {
            Glide.with(this.f14583c.getApplicationContext()).load(str).into(this.f14585e);
        }
    }

    public void setLabel(String str) {
        TextView textView = this.f14584d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bindRichInfo(GlobalRichInfo globalRichInfo) {
        if (this.f14584d != null && !TextUtils.isEmpty(globalRichInfo.getContent())) {
            globalRichInfo.bindTextView(this.f14584d);
        }
    }
}
