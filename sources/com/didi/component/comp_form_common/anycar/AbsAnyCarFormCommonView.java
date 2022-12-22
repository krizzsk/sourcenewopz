package com.didi.component.comp_form_common.anycar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.business.data.form.FormStore;
import com.taxis99.R;

public abstract class AbsAnyCarFormCommonView implements IAnyCarFormCommonView {

    /* renamed from: a */
    private ImageView f12219a;

    /* renamed from: b */
    private TextView f12220b;

    /* renamed from: c */
    private View f12221c;
    protected Context mContext;
    protected AbsAnyCarFormCommonPresenter mPresenter;
    protected View mRootView;

    public AbsAnyCarFormCommonView(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.select_passenger, viewGroup, false);
        m8274a();
    }

    public View getView() {
        return this.mRootView;
    }

    public void setPresenter(AbsAnyCarFormCommonPresenter absAnyCarFormCommonPresenter) {
        this.mPresenter = absAnyCarFormCommonPresenter;
    }

    /* renamed from: a */
    private void m8274a() {
        this.f12219a = (ImageView) this.mRootView.findViewById(R.id.anycar_iv_sp_avatar);
        this.f12220b = (TextView) this.mRootView.findViewById(R.id.anycar_tv_sp_text);
        setData(FormStore.getInstance().getSubstituteCallIcon(), FormStore.getInstance().getSubstituteCallText());
    }

    public void setData(String str, String str2) {
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(str).placeholder((int) R.drawable.icon_sc_for_me)).error((int) R.drawable.icon_sc_for_me)).into(this.f12219a);
        this.f12220b.setText(str2);
    }

    public void show() {
        this.mRootView.setVisibility(0);
    }

    public void hide() {
        this.mRootView.setVisibility(8);
    }
}
