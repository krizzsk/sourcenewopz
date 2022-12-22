package com.yanzhenjie.permission.install;

import com.yanzhenjie.permission.Boot;
import com.yanzhenjie.permission.source.Source;

public class NRequestFactory implements Boot.InstallRequestFactory {
    public InstallRequest create(Source source) {
        return new C20707b(source);
    }
}
