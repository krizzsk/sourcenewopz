package com.didi.unifylogin.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.thirdpartylogin.base.ThirdPartyLoginManager;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.net.pojo.response.AuthListResponse;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.presenter.ThirdPartySetPresenter;
import com.didi.unifylogin.presenter.ability.IThirdPartySetIPresenter;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.view.ability.IThirdPartySetView;
import com.didi.unifylogin.view.adpter.ThirdPartyListAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class ThirdPartySetFragment extends AbsLoginBaseFragment<IThirdPartySetIPresenter> implements IThirdPartySetView {

    /* renamed from: a */
    ListView f45065a;

    /* renamed from: b */
    List<ThirdPartyListAdapter.ItemData> f45066b;

    public boolean canSlide() {
        return false;
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_third_party, viewGroup, false);
        this.f45065a = (ListView) inflate.findViewById(R.id.lv_third_party_list);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        setTitleBarCenterVisible(true);
        String thirdPartyTitlebar = LoginPreferredConfig.getTextAdapter(this.messenger).getThirdPartyTitlebar(this.context);
        if (!TextUtils.isEmpty(thirdPartyTitlebar)) {
            setTitleBarCenterMsg(thirdPartyTitlebar);
        } else {
            setTitleBarCenterMsg(getString(R.string.login_unify_str_third_set_title));
        }
        ((IThirdPartySetIPresenter) this.presenter).loadThirdPartys();
    }

    public void initListener() {
        this.f45065a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                ThirdPartyListAdapter.ItemData itemData = ThirdPartySetFragment.this.f45066b.get(i);
                if (itemData != null) {
                    if (itemData.isBind) {
                        new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LINK_SOCIALUNLINK_CK, itemData.thirdPartyLogin).send();
                        ((IThirdPartySetIPresenter) ThirdPartySetFragment.this.presenter).unBind(itemData.thirdPartyLogin);
                        return;
                    }
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LINK_SOCIALLINK_CK, itemData.thirdPartyLogin).send();
                    ((IThirdPartySetIPresenter) ThirdPartySetFragment.this.presenter).bind(itemData.thirdPartyLogin);
                }
            }
        });
    }

    public void updateListView(List<AuthListResponse.Auth> list) {
        if (ThirdPartyLoginManager.getThirdPartyLogins() == null) {
            LoginLog.write(this.TAG + "getThirdPartyLogins() is null ");
        } else if (list != null && list.size() > 0) {
            LoginLog.write(this.TAG + "updateListView : auths size " + list.size());
            this.f45066b = new ArrayList();
            for (AuthListResponse.Auth next : list) {
                AbsThirdPartyLoginBase impByChannel = ThirdPartyLoginManager.getImpByChannel(next.getAuthChannel());
                if (impByChannel != null && impByChannel.isSupport()) {
                    List<ThirdPartyListAdapter.ItemData> list2 = this.f45066b;
                    boolean z = true;
                    if (next.getState() != 1) {
                        z = false;
                    }
                    list2.add(new ThirdPartyListAdapter.ItemData(impByChannel, z));
                }
            }
            ThirdPartyListAdapter thirdPartyListAdapter = new ThirdPartyListAdapter(this.f45066b, this.context);
            this.f45065a.setAdapter(thirdPartyListAdapter);
            thirdPartyListAdapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    public IThirdPartySetIPresenter bindPresenter() {
        return new ThirdPartySetPresenter(this, this.context);
    }

    public LoginState getNowState() {
        return LoginState.STATE_THIRD_PARTY_SET;
    }
}
