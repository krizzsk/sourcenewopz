package com.didi.soda.customer.repo;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.foundation.rpc.entity.LoginModel;

public class LoginRepo extends Repo<LoginModel> {
    public LoginModel getValue() {
        LoginModel loginModel = (LoginModel) super.getValue();
        return loginModel == null ? LoginModel.newInstance() : loginModel;
    }
}
