package com.didi.unifylogin.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.presenter.DeleteAccountReasonsPresenter;
import com.didi.unifylogin.presenter.ability.IDeleteAccountReasonsPresenter;
import com.didi.unifylogin.utils.KeyboardChangeListener;
import com.didi.unifylogin.utils.KeyboardHelper;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.customview.LoginAlertDialogFragment;
import com.didi.unifylogin.view.ability.IDeleteAccountReasonsView;
import com.didi.unifylogin.view.adpter.DeleteAccountReasonsAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class DeleteAccountReasonsFragment extends AbsLoginBaseFragment<IDeleteAccountReasonsPresenter> implements KeyboardChangeListener.KeyBoardListener, IDeleteAccountReasonsView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public NestedScrollView f45029a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText f45030b;

    /* renamed from: c */
    private RecyclerView f45031c;

    /* renamed from: d */
    private DeleteAccountReasonsAdapter f45032d;

    /* renamed from: e */
    private KeyboardChangeListener f45033e;
    protected Button nextBtn;
    protected TextView warnTv;

    public boolean canSlide() {
        return false;
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View view;
        LoginOmegaUtil.trackEvent("ibt_delete_account_reason_sw");
        if (LoginPreferredConfig.isUsePassengerUIStyle()) {
            view = layoutInflater.inflate(R.layout.login_unify_fragment_delete_account_reasons_passenger_style, viewGroup, false);
        } else {
            view = layoutInflater.inflate(R.layout.login_unify_fragment_delete_account_reasons, viewGroup, false);
        }
        this.f45029a = (NestedScrollView) view.findViewById(R.id.scroll_container);
        this.f45031c = (RecyclerView) view.findViewById(R.id.rv_delete_account_reasons);
        this.f45030b = (EditText) view.findViewById(R.id.et_other_reason);
        this.titleTv = (TextView) view.findViewById(R.id.tv_title);
        this.nextBtn = (Button) view.findViewById(R.id.btn_next);
        this.warnTv = (TextView) view.findViewById(R.id.tv_warn);
        KeyboardChangeListener keyboardChangeListener = new KeyboardChangeListener(getActivity());
        this.f45033e = keyboardChangeListener;
        keyboardChangeListener.setKeyBoardListener(this);
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
                ((IDeleteAccountReasonsPresenter) DeleteAccountReasonsFragment.this.presenter).deleteAcc();
            }
        });
    }

    public LoginState getNowState() {
        return LoginState.STATE_DELETE_ACCOUNT_REASON;
    }

    /* access modifiers changed from: protected */
    public IDeleteAccountReasonsPresenter bindPresenter() {
        return new DeleteAccountReasonsPresenter(this, this.context);
    }

    public void showWarnDialog() {
        LoginOmegaUtil.trackEvent("ibt_delete_account_reason_delete_ck");
        new LoginAlertDialogFragment.Builder(getActivity()).setTitle(getString(R.string.Global_Driver_drv_delete_account_Delete_confirm_FpNl)).setMessage(getString(R.string.Global_Driver_drv_delete_account_Delete_mRgX)).setCancelable(true).setNegativeButton(getString(R.string.Global_Driver_drv_delete_account_Cancel_tOlt), new LoginAlertDialogFragment.OnClickListener() {
            public void onClick(LoginAlertDialogFragment loginAlertDialogFragment, View view) {
                if (loginAlertDialogFragment != null) {
                    loginAlertDialogFragment.dismiss();
                }
            }
        }).setPositiveButton(getString(R.string.Global_Driver_drv_delete_account_Confirmation_SLAJ), new LoginAlertDialogFragment.OnClickListener() {
            public void onClick(LoginAlertDialogFragment loginAlertDialogFragment, View view) {
                LoginOmegaUtil.trackEvent("ibt_delete_account_reason_delete_confirm_ck");
                if (loginAlertDialogFragment != null) {
                    loginAlertDialogFragment.dismiss();
                }
                ((IDeleteAccountReasonsPresenter) DeleteAccountReasonsFragment.this.presenter).goVerifyCode();
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

    public void updateReasons(List<DeleteAccountReasonsAdapter.DeleteAccountReason> list) {
        if (list != null && list.size() != 0) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
            linearLayoutManager.setOrientation(1);
            this.f45031c.setLayoutManager(linearLayoutManager);
            DeleteAccountReasonsAdapter deleteAccountReasonsAdapter = new DeleteAccountReasonsAdapter(list);
            this.f45032d = deleteAccountReasonsAdapter;
            deleteAccountReasonsAdapter.setOnOtherReasonItemSelectedChangedListener(new DeleteAccountReasonsAdapter.OnOtherReasonItemSelectedChangedListener() {
                public void onOtherReasonItemSelectedChanged(boolean z) {
                    DeleteAccountReasonsFragment.this.f45030b.setVisibility(z ? 0 : 8);
                    if (z) {
                        DeleteAccountReasonsFragment.this.f45030b.post(new Runnable() {
                            public void run() {
                                DeleteAccountReasonsFragment.this.f45029a.fullScroll(130);
                            }
                        });
                    } else {
                        KeyboardHelper.hideInputMethod(DeleteAccountReasonsFragment.this.context, DeleteAccountReasonsFragment.this.f45030b);
                    }
                }
            });
            this.f45031c.setAdapter(this.f45032d);
        }
    }

    public List<String> getSelectedReasons() {
        List<String> arrayList = new ArrayList<>();
        DeleteAccountReasonsAdapter deleteAccountReasonsAdapter = this.f45032d;
        if (deleteAccountReasonsAdapter != null) {
            arrayList = deleteAccountReasonsAdapter.getSelectedReasons();
            String obj = this.f45030b.getText().toString();
            if (this.f45032d.isOtherReasonSelected() && !TextUtil.isEmpty(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public void onKeyboardChange(boolean z, int i) {
        if (z) {
            this.f45029a.fullScroll(130);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f45033e.destroy();
    }
}
