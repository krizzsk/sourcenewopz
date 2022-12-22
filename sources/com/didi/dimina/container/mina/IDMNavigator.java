package com.didi.dimina.container.mina;

import com.didi.dimina.container.bean.NavigateConfig;
import com.didi.dimina.container.page.IPageHost;
import java.util.List;

public interface IDMNavigator extends Cloneable {
    IDMNavigator clone() throws CloneNotSupportedException;

    boolean closeDimina();

    IPageHost getCurrentPage();

    List<IPageHost> getCurrentPages();

    IPageHost getPage(int i);

    IPageHost getPage(String str);

    boolean hideLaunchView(int i);

    boolean launch(int i, int i2, NavigateConfig navigateConfig);

    boolean navigateBack(int i, int i2, int i3);

    boolean navigateTo(int i, int i2, NavigateConfig navigateConfig);

    boolean reLaunch(int i, int i2, NavigateConfig navigateConfig);

    boolean redirectTo(int i, int i2, NavigateConfig navigateConfig);

    boolean showLaunchView(int i);

    boolean switchTab(int i, int i2, NavigateConfig navigateConfig);
}
