package com.didi.soda.search.component.header;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import butterknife.BindView;
import com.didi.soda.customer.animation.transitions.compat.SearchSharedElementCompat;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.search.component.header.Contract;
import com.didi.soda.search.repo.SearchWordRepo;
import com.taxis99.R;

public class SearchHeaderView extends Contract.AbsSearchHeaderView {

    /* renamed from: a */
    private boolean f43693a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f43694b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f43695c = true;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f43696d = false;
    @BindView(18463)
    View mBackIv;
    @BindView(19238)
    View mPlaceHolder;
    @BindView(18107)
    SearchView mSearchEt;

    public void setFilterIvVisibility(int i) {
    }

    public void setSortViewVisible(int i) {
    }

    public View getLoadingView() {
        return this.mPlaceHolder;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mSearchEt.getEditView().setHint(str);
        }
    }

    public void setResultViewVisible(int i) {
        this.f43696d = i == 0;
        ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).mIsResultViewVisible = this.f43696d;
    }

    public void showOrHideSuggestionLoading(boolean z) {
        this.mSearchEt.showOrHideLoading(z);
    }

    public void setSearchTag(String str) {
        this.f43695c = false;
        this.mSearchEt.getEditView().setText(str);
        this.f43695c = true;
        this.mSearchEt.getEditView().setSelection(str.length());
    }

    public void resetIsFirstInputShow() {
        this.f43693a = false;
    }

    public void showSoftInput() {
        KeyboardUtils.showSoftInput(getContext(), this.mSearchEt.getEditView());
    }

    public void hideSoftInput() {
        this.mSearchEt.getEditView().clearFocus();
        KeyboardUtils.hideSoftInput(getContext(), this.mSearchEt.getEditView());
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m31013b();
        m31010a();
        m31015c();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.f43693a) {
            KeyboardUtils.showSoftInput(getContext(), this.mSearchEt.getEditView());
            this.f43693a = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        KeyboardUtils.hideSoftInput(getContext(), this.mSearchEt.getEditView());
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_search_header_ab_layout, viewGroup, true);
    }

    /* renamed from: a */
    private void m31010a() {
        this.mSearchEt.getEditView().addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SearchHeaderView.this.showOrHideSuggestionLoading(false);
                if (charSequence.length() == 0) {
                    ((Contract.AbsSearchHeaderPresenter) SearchHeaderView.this.getPresenter()).onSearchTagClear();
                    SearchHeaderView.this.setFilterIvVisibility(8);
                    boolean unused = SearchHeaderView.this.f43694b = true;
                    KeyboardUtils.showSoftInput(SearchHeaderView.this.getContext(), SearchHeaderView.this.mSearchEt.getEditView());
                } else if (SearchHeaderView.this.f43695c) {
                    ((Contract.AbsSearchHeaderPresenter) SearchHeaderView.this.getPresenter()).onSearchSuggestion(charSequence.toString());
                }
            }
        });
        this.mSearchEt.getEditView().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsSearchHeaderPresenter) SearchHeaderView.this.getPresenter()).onSearchEditViewClick();
            }
        });
        this.mSearchEt.getEditView().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    KeyboardUtils.showSoftInput(SearchHeaderView.this.getContext(), view);
                    if (!SearchHeaderView.this.f43694b) {
                        ((Contract.AbsSearchHeaderPresenter) SearchHeaderView.this.getPresenter()).onSearchEditViewClick();
                    }
                    boolean unused = SearchHeaderView.this.f43694b = false;
                    SearchHeaderView.this.mSearchEt.visibleAllRightView();
                    return;
                }
                KeyboardUtils.hideSoftInput(SearchHeaderView.this.getContext(), view);
                SearchHeaderView.this.mSearchEt.goneAllRightView();
            }
        });
        this.mSearchEt.getEditView().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3) {
                    return false;
                }
                String obj = SearchHeaderView.this.mSearchEt.getEditView().getText().toString();
                SearchHeaderView.this.showOrHideSuggestionLoading(false);
                ((Contract.AbsSearchHeaderPresenter) SearchHeaderView.this.getPresenter()).onSearchClicked(obj);
                return true;
            }
        });
    }

    /* renamed from: b */
    private void m31013b() {
        this.mSearchEt.getSearchButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsSearchHeaderPresenter) SearchHeaderView.this.getPresenter()).onSearchClicked(SearchHeaderView.this.mSearchEt.getEditView().getText().toString());
            }
        });
        if (SearchSharedElementCompat.supportSharedElementTransition(getScopeContext())) {
            ViewCompat.setTransitionName(this.mSearchEt, getScopeContext().getBundle().getString(Const.PageParams.TRANSITION_NAMES));
        }
    }

    /* renamed from: c */
    private void m31015c() {
        this.mBackIv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                KeyboardUtils.hideSoftInput(SearchHeaderView.this.getContext(), SearchHeaderView.this.mSearchEt.getEditView());
                SearchHeaderView.this.mSearchEt.visibleAllRightView();
                ((Contract.AbsSearchHeaderPresenter) SearchHeaderView.this.getPresenter()).onBack(Boolean.valueOf(SearchHeaderView.this.f43696d));
                SearchHeaderView.this.setResultViewVisible(8);
            }
        });
    }

    public void goneAllSearchRightView() {
        this.mSearchEt.goneAllRightView();
    }
}
