package com.didi.unifylogin.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.presenter.ConfirmPhonePresenter;
import com.didi.unifylogin.presenter.ability.IConfirmPhonePresenter;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.phone.LoginPhoneTextWatcher;
import com.didi.unifylogin.utils.phone.PhoneUtils;
import com.didi.unifylogin.view.ability.IConfirmPhoneView;
import com.taxis99.R;

public class ConfirmPhoneFragment extends AbsLoginBaseFragment<IConfirmPhonePresenter> implements IConfirmPhoneView {
    protected Button nextBtn;
    protected EditText phoneEt;
    protected TextView retrieveTv;

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_phone, viewGroup, false);
        this.titleTv = (TextView) inflate.findViewById(R.id.tv_title);
        this.subTitleTv = (TextView) inflate.findViewById(R.id.tv_sub_title);
        this.phoneEt = (EditText) inflate.findViewById(R.id.et_phone);
        this.nextBtn = (Button) inflate.findViewById(R.id.btn_next);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_other_way);
        this.retrieveTv = textView;
        textView.setVisibility(8);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        setTitle(this.context.getString(R.string.login_unify_confirm_old_cell_title));
        setSubTitle(this.context.getString(R.string.login_unify_confirm_old_cell_sub_title));
        setTitleBarLeftVisible(true);
        if (!TextUtils.isEmpty(this.messenger.getCell())) {
            this.phoneEt.setText(this.messenger.getCell());
        }
    }

    public void onResume() {
        super.onResume();
        EditText editText = this.phoneEt;
        editText.setText(editText.getText());
        EditText editText2 = this.phoneEt;
        editText2.setSelection(editText2.getText().length());
    }

    public void initListener() {
        this.nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LoginLog.write(ConfirmPhoneFragment.this.TAG + " nextBtn click");
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                ((IConfirmPhonePresenter) ConfirmPhoneFragment.this.presenter).getIdentity();
            }
        });
        this.phoneEt.addTextChangedListener(new LoginPhoneTextWatcher(this.nextBtn));
    }

    public LoginState getNowState() {
        return LoginState.STATE_CONFIRM_PHONE;
    }

    public String getPhone() {
        EditText editText = this.phoneEt;
        if (editText != null) {
            return PhoneUtils.toNormalPhone(editText.getText().toString());
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public IConfirmPhonePresenter bindPresenter() {
        return new ConfirmPhonePresenter(this, this.context);
    }
}
