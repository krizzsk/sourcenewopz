package com.rider.rlab_im_map_plugin.engine;

import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;
import com.google.android.libraries.navigation.NavigationView;
import com.google.android.libraries.navigation.Navigator;

@ServiceProviderInterface
public interface ImNavServiceProvider {
    void setNavView(NavigationView navigationView);

    void setNavigator(Navigator navigator);
}
