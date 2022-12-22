package rui.config.loader;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

public final class AssetsFileLoader {
    private AssetsFileLoader() {
    }

    public static String load(Context context, String str) throws IOException {
        InputStream open = context.getAssets().open(str);
        byte[] bArr = new byte[open.available()];
        open.read(bArr);
        open.close();
        return new String(bArr);
    }
}
