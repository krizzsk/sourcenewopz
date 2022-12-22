package com.didi.unifylogin.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.net.pojo.entity.PromptContent;
import com.didi.unifylogin.base.net.pojo.response.GetDeleteAccountManualResponse;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.presenter.DeleteAccountManualPresenter;
import com.didi.unifylogin.presenter.ability.IDeleteAccountManualPresenter;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.customview.LoginAlertDialogFragment;
import com.didi.unifylogin.view.ability.IDeleteAccountManualView;
import com.didi.unifylogin.view.adpter.DeleteAccountWarningAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class DeleteAccountManualFragment extends AbsLoginBaseFragment<IDeleteAccountManualPresenter> implements IDeleteAccountManualView {

    /* renamed from: a */
    private View f45025a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CheckBox f45026b;

    /* renamed from: c */
    private DeleteAccountWarningAdapter f45027c;

    /* renamed from: d */
    private RecyclerView f45028d;
    protected Button nextBtn;
    protected TextView warnTv;

    public boolean canSlide() {
        return false;
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View view;
        LoginOmegaUtil.trackEvent(LoginOmegaUtil.IBT_DELETE_ACCOUNT_GUIDE_SW);
        if (LoginPreferredConfig.isUsePassengerUIStyle()) {
            view = layoutInflater.inflate(R.layout.login_unify_fragment_delete_account_manual_passenger_style, viewGroup, false);
        } else {
            view = layoutInflater.inflate(R.layout.login_unify_fragment_delete_account_manual, viewGroup, false);
        }
        this.f45028d = (RecyclerView) view.findViewById(R.id.rv_cancel_warning);
        this.nextBtn = (Button) view.findViewById(R.id.btn_next);
        this.titleTv = (TextView) view.findViewById(R.id.tv_title);
        this.subTitleTv = (TextView) view.findViewById(R.id.tv_sub_title);
        this.warnTv = (TextView) view.findViewById(R.id.tv_warn);
        this.f45025a = view.findViewById(R.id.agreement_container);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.cb_agree);
        this.f45026b = checkBox;
        checkBox.setChecked(false);
        return view;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        setTitleBarCenterMsg(getResources().getString(R.string.commonapi_sidebar_menu_25));
        setTitleBarCenterVisible(true);
    }

    public void initListener() {
        this.nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                if (DeleteAccountManualFragment.this.f45026b.isChecked()) {
                    LoginOmegaUtil.trackEvent(LoginOmegaUtil.IBT_DELETE_ACCOUNT_GUIDE_NEXT_CK);
                    ((IDeleteAccountManualPresenter) DeleteAccountManualFragment.this.presenter).deleteAcc();
                    return;
                }
                DeleteAccountManualFragment.this.showError((int) R.string.login_unify_delete_account_write_off);
            }
        });
        this.f45025a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DeleteAccountManualFragment.this.f45026b.setChecked(!DeleteAccountManualFragment.this.f45026b.isChecked());
            }
        });
    }

    public LoginState getNowState() {
        return LoginState.STATE_DELETE_ACCOUNT_MANUAL;
    }

    /* access modifiers changed from: protected */
    public IDeleteAccountManualPresenter bindPresenter() {
        return new DeleteAccountManualPresenter(this, this.context);
    }

    public void updateContents(List<GetDeleteAccountManualResponse.DeleteContent> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (GetDeleteAccountManualResponse.DeleteContent next : list) {
                arrayList.add(new PromptContent().setType(next.getType()).setTag(next.getTag()).setMsg(next.getDesc()));
                for (int i = 0; i < 30; i++) {
                    arrayList.add(new PromptContent().setType(next.getType()).setTag(next.getTag()).setMsg(next.getDesc()));
                }
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
            linearLayoutManager.setOrientation(1);
            this.f45028d.setLayoutManager(linearLayoutManager);
            DeleteAccountWarningAdapter deleteAccountWarningAdapter = new DeleteAccountWarningAdapter(list);
            this.f45027c = deleteAccountWarningAdapter;
            this.f45028d.setAdapter(deleteAccountWarningAdapter);
        }
    }

    public void showWarnDialog() {
        new LoginAlertDialogFragment.Builder(getActivity()).setTitle(getString(R.string.Global_Driver_drv_delete_account_Delete_confirm_FpNl)).setMessage(getString(R.string.Global_Driver_drv_delete_account_Delete_mRgX)).setCancelable(true).setNegativeButton(getString(R.string.Global_Driver_drv_delete_account_Cancel_tOlt), new LoginAlertDialogFragment.OnClickListener() {
            public void onClick(LoginAlertDialogFragment loginAlertDialogFragment, View view) {
                if (loginAlertDialogFragment != null) {
                    loginAlertDialogFragment.dismiss();
                }
            }
        }).setPositiveButton(getString(R.string.Global_Driver_drv_delete_account_Confirmation_SLAJ), new LoginAlertDialogFragment.OnClickListener() {
            public void onClick(LoginAlertDialogFragment loginAlertDialogFragment, View view) {
                if (loginAlertDialogFragment != null) {
                    loginAlertDialogFragment.dismiss();
                }
                ((IDeleteAccountManualPresenter) DeleteAccountManualFragment.this.presenter).goVerifyCode();
            }
        }).create().show(getFragmentManager(), (String) null);
    }

    public void setNextBtn(String str) {
        Button button = this.nextBtn;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setWarnTxt(String str) {
        TextView textView = this.warnTv;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
