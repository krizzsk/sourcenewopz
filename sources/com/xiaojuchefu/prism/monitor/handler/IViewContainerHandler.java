package com.xiaojuchefu.prism.monitor.handler;

import android.view.View;

public interface IViewContainerHandler {
    String getContainerSymbol(View view);

    String getContainerUrl(View view);

    boolean handleContainer(View view);
}
