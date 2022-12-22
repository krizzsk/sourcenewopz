package com.didi.unifylogin.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.net.pojo.entity.PromptPageData;
import com.didi.unifylogin.base.presenter.ILoginBasePresenter;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.view.adpter.HintDesListAdapter;
import com.taxis99.R;

public abstract class AbsPromptFragment extends AbsLoginBaseFragment {

    /* renamed from: a */
    TextView f45007a;

    /* renamed from: b */
    TextView f45008b;

    /* renamed from: c */
    TextView f45009c;

    /* renamed from: d */
    ListView f45010d;

    /* renamed from: e */
    Button f45011e;

    public boolean canSlide() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_prompt, viewGroup, false);
        this.f45007a = (TextView) inflate.findViewById(R.id.tv_title);
        this.f45008b = (TextView) inflate.findViewById(R.id.tv_sub_title);
        this.f45009c = (TextView) inflate.findViewById(R.id.tv_sub_sencend_title);
        this.f45010d = (ListView) inflate.findViewById(R.id.lv_des);
        this.f45011e = (Button) inflate.findViewById(R.id.btn_next);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        PromptPageData promptPageData = this.messenger.getPromptPageData();
        if (promptPageData != null) {
            this.f45007a.setText(promptPageData.getTitle());
            this.f45008b.setText(promptPageData.getSubTitle());
            if (!TextUtil.isEmpty(promptPageData.getSubSecondTitle())) {
                this.f45009c.setText(promptPageData.getSubSecondTitle());
                this.f45009c.setVisibility(0);
            }
            this.f45010d.setAdapter(new HintDesListAdapter(this.context, promptPageData.getContents()));
            this.f45011e.setText(promptPageData.getBtnStr());
        }
    }

    /* access modifiers changed from: protected */
    public ILoginBasePresenter bindPresenter() {
        return new LoginBasePresenter(this, this.context);
    }
}
