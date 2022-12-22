package com.didi.unifylogin.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.unifylogin.base.net.pojo.entity.PromptContent;
import com.didi.unifylogin.base.net.pojo.response.DeleteAccountResponse;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.presenter.CancelPresenter;
import com.didi.unifylogin.presenter.ability.ICancelPresenter;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.view.ability.ICancelView;
import com.didi.unifylogin.view.adpter.HintDesListAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CancelFragment extends AbsLoginBaseFragment<ICancelPresenter> implements ICancelView {
    protected HintDesListAdapter adapter;
    protected ListView cancelWarningLv;
    protected Button nextBtn;
    protected TextView warnTv;

    public boolean canSlide() {
        return false;
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_cancel, viewGroup, false);
        this.cancelWarningLv = (ListView) inflate.findViewById(R.id.ls_des);
        this.nextBtn = (Button) inflate.findViewById(R.id.btn_next);
        this.subTitleTv = (TextView) inflate.findViewById(R.id.tv_sub_title);
        this.warnTv = (TextView) inflate.findViewById(R.id.tv_warn);
        return inflate;
    }

    public void initListener() {
        this.nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                ((ICancelPresenter) CancelFragment.this.presenter).deleteAcc();
            }
        });
    }

    public LoginState getNowState() {
        return LoginState.STATE_CANCEL;
    }

    /* access modifiers changed from: protected */
    public ICancelPresenter bindPresenter() {
        return new CancelPresenter(this, this.context);
    }

    public void updateContents(List<DeleteAccountResponse.DeleteContent> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (DeleteAccountResponse.DeleteContent next : list) {
                arrayList.add(new PromptContent().setType(next.getType()).setTag(next.getTag()).setMsg(next.getDesc()));
            }
            HintDesListAdapter hintDesListAdapter = new HintDesListAdapter(this.context, arrayList);
            this.adapter = hintDesListAdapter;
            this.cancelWarningLv.setAdapter(hintDesListAdapter);
            this.adapter.notifyDataSetChanged();
        }
    }

    public void showWarnDialog() {
        new AlertDialogFragment.Builder(getActivity()).setPositiveButtonDefault().setIcon(AlertController.IconType.INFO).setMessage(getString(R.string.login_unify_str_confirm_cancel)).setCancelable(true).setNegativeButton((CharSequence) getString(R.string.login_unify_str_cancel_btn), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                if (alertDialogFragment != null) {
                    alertDialogFragment.dismiss();
                }
            }
        }).setPositiveButton((CharSequence) getString(R.string.login_unify_str_dialog_delete_btn), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                if (alertDialogFragment != null) {
                    alertDialogFragment.dismiss();
                }
                ((ICancelPresenter) CancelFragment.this.presenter).goVerifyCode();
            }
        }).create().show(getFragmentManager(), (String) null);
    }

    public void setNextBtn(CharSequence charSequence) {
        Button button = this.nextBtn;
        if (button != null) {
            button.setText(charSequence);
        }
    }

    public void setWarnTxt(CharSequence charSequence) {
        TextView textView = this.warnTv;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
