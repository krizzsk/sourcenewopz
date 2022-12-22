package com.didiglobal.enginecore.template.temp;

import android.content.Context;
import android.view.View;
import com.didiglobal.enginecore.template.temp.IXEViewModel;

public interface IXEView<Model extends IXEViewModel> {
    void bindData(Model model);

    View getView();

    void initView(Context context);
}
