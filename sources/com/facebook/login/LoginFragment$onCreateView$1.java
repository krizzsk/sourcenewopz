package com.facebook.login;

import android.view.View;
import com.facebook.login.LoginClient;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo175978d2 = {"com/facebook/login/LoginFragment$onCreateView$1", "Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "onBackgroundProcessingStarted", "", "onBackgroundProcessingStopped", "facebook-common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LoginFragment.kt */
public final class LoginFragment$onCreateView$1 implements LoginClient.BackgroundProcessingListener {
    final /* synthetic */ View $progressBar;

    LoginFragment$onCreateView$1(View view) {
        this.$progressBar = view;
    }

    public void onBackgroundProcessingStarted() {
        this.$progressBar.setVisibility(0);
    }

    public void onBackgroundProcessingStopped() {
        this.$progressBar.setVisibility(8);
    }
}
