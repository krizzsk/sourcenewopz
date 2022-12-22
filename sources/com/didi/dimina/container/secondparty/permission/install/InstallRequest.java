package com.didi.dimina.container.secondparty.permission.install;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;
import java.io.File;

public interface InstallRequest {
    InstallRequest file(File file);

    InstallRequest onDenied(Action<File> action);

    InstallRequest onGranted(Action<File> action);

    InstallRequest rationale(Rationale<File> rationale);

    void start();
}
