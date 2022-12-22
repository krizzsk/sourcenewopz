package com.didi.unifylogin.base.net;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.didichuxing.foundation.p188io.AbstractDeserializer;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

public class BitmapDeserializer extends AbstractDeserializer<BitmapWapper> {
    public BitmapDeserializer(Type type) {
        super(type);
    }

    /* JADX INFO: finally extract failed */
    public BitmapWapper deserialize(InputStream inputStream) throws IOException {
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (Exception unused) {
            inputStream.close();
            bitmap = null;
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
        if (bitmap == null) {
            return new BitmapWapper(BitmapWapper.TYPE_NULL, (Bitmap) null);
        }
        return new BitmapWapper(BitmapWapper.TYPE_NORMAL, bitmap);
    }

    public static class BitmapWapper {
        public static int TYPE_NORMAL = 1;
        public static int TYPE_NULL;
        private Bitmap mBitmap;
        private int mType;

        public BitmapWapper() {
        }

        public BitmapWapper(int i, Bitmap bitmap) {
            this.mType = i;
            this.mBitmap = bitmap;
        }

        public int getmType() {
            return this.mType;
        }

        public void setmType(int i) {
            this.mType = i;
        }

        public Bitmap getmBitmap() {
            return this.mBitmap;
        }

        public void setmBitmap(Bitmap bitmap) {
            this.mBitmap = bitmap;
        }
    }
}
