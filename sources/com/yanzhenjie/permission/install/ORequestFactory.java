package com.yanzhenjie.permission.install;

import com.yanzhenjie.permission.Boot;
import com.yanzhenjie.permission.source.Source;

public class ORequestFactory implements Boot.InstallRequestFactory {
    public InstallRequest create(Source source) {
        return new C20708c(source);
    }
}
