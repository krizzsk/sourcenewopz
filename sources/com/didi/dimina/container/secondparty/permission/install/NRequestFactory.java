package com.didi.dimina.container.secondparty.permission.install;

import com.didi.dimina.container.secondparty.permission.Boot;
import com.didi.dimina.container.secondparty.permission.source.Source;

public class NRequestFactory implements Boot.InstallRequestFactory {
    public InstallRequest create(Source source) {
        return new C7595b(source);
    }
}
