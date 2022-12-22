package com.didi.sdk.app;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.PopupWindow;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import java.io.Serializable;

public interface INavigation extends Serializable {
    public static final String BUNDLE_KEY_ALLOW_COVER_PAGE = "BUNDLE_KEY_ALLOW_COVER_PAGE";
    public static final String BUNDLE_KEY_BACKSTACK = "BUNDLE_KEY_BACKSTACK";
    public static final String BUNDLE_KEY_BOTTOM_NEED = "BUNDLE_KEY_BOTTOM_NEED";
    public static final String BUNDLE_KEY_CLEAR_TASK = "BUNDLE_KEY_REPLACE_PAGE";
    public static final String BUNDLE_KEY_FRAGMENT_NAME = "BUNDLE_KEY_FRAGMENT_NAME";
    public static final String BUNDLE_KEY_MAP_NEED = "BUNDLE_KEY_MAP_NEED";
    public static final String BUNDLE_KEY_SET_REORDERING_ALLOWED = "BUNDLE_KEY_SET_REORDERING_ALLOWED";
    public static final String BUNDLE_KEY_TITLE_BAR_NEED = "BUNDLE_KEY_TOP_NEED";
    public static final String BUNDLE_KEY_TRASACTION_ADD = "BUNDLE_KEY_TRASACTION_ADD";
    public static final int FLAG_PAGE_POP_BACK_CLEAR_STACK = 2;
    public static final int FLAG_PAGE_POP_BACK_EXCLUSIVE = 0;
    public static final int FLAG_PAGE_POP_BACK_EXIT_APP = 4;
    public static final int FLAG_PAGE_POP_BACK_FINISH_ACTIVITY = 3;
    public static final int FLAG_PAGE_POP_BACK_ON_ROOT = 1;
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    public static final int VIEW_TYPE_NAVIGATION_BAR = 2;
    public static final int VIEW_TYPE_TITLE_BAR = 1;

    void dismissDialog(DialogFragment dialogFragment);

    String getFragmentName(Fragment fragment);

    void popBackStack();

    void popBackStack(int i);

    void popBackStack(int i, Bundle bundle);

    void popBackStack(Bundle bundle);

    void popBackStack(String str, int i);

    void popBackStack(String str, int i, Bundle bundle);

    void registerFilter(IntentFilter intentFilter, Class<? extends Fragment> cls);

    void showDialog(DialogFragment dialogFragment);

    void showPopupWindow(int i, PopupWindow popupWindow, int i2, int i3, int i4);

    void transition(BaseBusinessContext baseBusinessContext, Intent intent);

    void transition(BaseBusinessContext baseBusinessContext, Intent intent, TransactionAnimation transactionAnimation);

    public static class TransactionAnimation {
        public static final TransactionAnimation DEFAULT = new TransactionAnimation(0, 0, 0, 0);
        int enter;
        int exit;
        int popEnter;
        int popExit;

        public TransactionAnimation(int i, int i2, int i3, int i4) {
            this.enter = i;
            this.exit = i2;
            this.popEnter = i3;
            this.popExit = i4;
        }
    }
}
