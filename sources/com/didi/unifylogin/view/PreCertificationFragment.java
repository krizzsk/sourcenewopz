package com.didi.unifylogin.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.base.net.pojo.entity.PromptContent;
import com.didi.unifylogin.base.net.pojo.response.ActionResponse;
import com.didi.unifylogin.base.view.AbsLoginBaseFillerFragment;
import com.didi.unifylogin.presenter.PreCertificationPresenter;
import com.didi.unifylogin.presenter.ability.IPreCertificationPresenter;
import com.didi.unifylogin.utils.CertificationController;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.view.adpter.HintDesListAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class PreCertificationFragment extends AbsLoginBaseFillerFragment<IPreCertificationPresenter> {

    /* renamed from: b */
    ListView f45054b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f45055c;
    protected Button nextBtn;

    public boolean canSlide() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_pre_certification, viewGroup, false);
        this.titleTv = (TextView) inflate.findViewById(R.id.tv_title);
        this.f45054b = (ListView) inflate.findViewById(R.id.lv_des);
        this.nextBtn = (Button) inflate.findViewById(R.id.btn_next);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        ActionResponse.Action action = getAction();
        if (action != null) {
            JSONObject jSONObject = action.config;
            LoginLog.write(this.TAG + "updateView() - configJson:" + jSONObject);
            if (jSONObject != null) {
                this.f45055c = jSONObject.optString("url");
                this.titleTv.setText(jSONObject.optString("title"));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("content");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        arrayList.add(new PromptContent().setTag(optJSONObject.optString("tag")).setMsg(optJSONObject.optString("msg")));
                    }
                }
                this.f45054b.setAdapter(new HintDesListAdapter(this.context, arrayList));
            }
        }
    }

    public void initListener() {
        this.nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                ((IPreCertificationPresenter) PreCertificationFragment.this.presenter).openCertification(PreCertificationFragment.this.f45055c);
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (CertificationController.isAlreadyCheck()) {
            ((IPreCertificationPresenter) this.presenter).checkResult();
        }
    }

    public LoginState getNowState() {
        return LoginState.STATE_PRE_CERTIFICATION;
    }

    /* access modifiers changed from: protected */
    public IPreCertificationPresenter bindPresenter() {
        return new PreCertificationPresenter(this, this.context);
    }
}
