package com.jumio.jvision.jvcorejava.swig;

public class JVCoreJavaJNI {
    static {
        swig_module_init();
    }

    public static final native int Color_getA(long j, Color color);

    public static final native int Color_getB(long j, Color color);

    public static final native int Color_getG(long j, Color color);

    public static final native int Color_getR(long j, Color color);

    public static final native void Color_setA(long j, Color color, int i);

    public static final native void Color_setB(long j, Color color, int i);

    public static final native void Color_setG(long j, Color color, int i);

    public static final native void Color_setR(long j, Color color, int i);

    public static final native String FrameProcessorException_what(long j, FrameProcessorException frameProcessorException);

    public static final native void FrameProcessor_change_ownership(FrameProcessor frameProcessor, long j, boolean z);

    public static final native void FrameProcessor_director_connect(FrameProcessor frameProcessor, long j, boolean z, boolean z2);

    public static final native void FrameProcessor_processFrame(long j, FrameProcessor frameProcessor);

    public static final native void FrameProcessor_processFrameSwigExplicitFrameProcessor(long j, FrameProcessor frameProcessor);

    public static final native void FrameProcessor_pushFrame(long j, FrameProcessor frameProcessor, int i, long j2, ImageSource imageSource);

    public static final native void FrameProcessor_pushFrameSwigExplicitFrameProcessor(long j, FrameProcessor frameProcessor, int i, long j2, ImageSource imageSource);

    public static final native void FrameProcessor_reset(long j, FrameProcessor frameProcessor);

    public static final native void FrameProcessor_resetState(long j, FrameProcessor frameProcessor);

    public static final native void FrameProcessor_resetStateSwigExplicitFrameProcessor(long j, FrameProcessor frameProcessor);

    public static final native void FrameQueue_clear(long j, FrameQueue frameQueue);

    public static final native void FrameQueue_getAllFrames(long j, FrameQueue frameQueue, long j2, ImageSourceVector imageSourceVector);

    public static final native long FrameQueue_getFrameByID(long j, FrameQueue frameQueue, int i);

    public static final native void FrameQueue_getFramesInRange(long j, FrameQueue frameQueue, int i, int i2, long j2, ImageSourceVector imageSourceVector);

    public static final native long FrameQueue_lastFrame(long j, FrameQueue frameQueue);

    public static final native void FrameQueue_pushFrame(long j, FrameQueue frameQueue, int i, long j2, ImageSource imageSource);

    public static final native boolean FrameQueue_removeFrameByID(long j, FrameQueue frameQueue, int i);

    public static final native long FrameQueue_size(long j, FrameQueue frameQueue);

    public static final native int ImageFormat_BGRA_get();

    public static final native int ImageFormat_BGR_get();

    public static final native int ImageFormat_GRAY_get();

    public static final native int ImageFormat_RGBA_get();

    public static final native int ImageFormat_RGB_get();

    public static final native int ImageFormat_YUVNV21_get();

    public static final native int ImageFormat_YUVYV12_get();

    public static final native void ImageSourceVector_add(long j, ImageSourceVector imageSourceVector, long j2, ImageSource imageSource);

    public static final native long ImageSourceVector_capacity(long j, ImageSourceVector imageSourceVector);

    public static final native void ImageSourceVector_clear(long j, ImageSourceVector imageSourceVector);

    public static final native long ImageSourceVector_get(long j, ImageSourceVector imageSourceVector, int i);

    public static final native boolean ImageSourceVector_isEmpty(long j, ImageSourceVector imageSourceVector);

    public static final native void ImageSourceVector_reserve(long j, ImageSourceVector imageSourceVector, long j2);

    public static final native void ImageSourceVector_set(long j, ImageSourceVector imageSourceVector, int i, long j2, ImageSource imageSource);

    public static final native long ImageSourceVector_size(long j, ImageSourceVector imageSourceVector);

    public static final native long ImageSource_CreateFromEncodedByteArray(byte[] bArr);

    public static final native long ImageSource_CreateFromFileSystem(String str);

    public static final native long ImageSource_CreateFromUncompressedByteArray(byte[] bArr, int i, int i2, int i3, int i4);

    public static final native long ImageSource_Crop(long j, ImageSource imageSource, long j2, Rect2i rect2i);

    public static final native long ImageSource_CropRotate(long j, ImageSource imageSource, long j2, Rect2i rect2i, int i);

    public static final native long ImageSource_CropRotateScale(long j, ImageSource imageSource, long j2, Rect2i rect2i, int i, long j3, Size2i size2i);

    public static final native int ImageSource_Height(long j, ImageSource imageSource);

    public static final native int ImageSource_Length(long j, ImageSource imageSource);

    public static final native long ImageSource_Rotate(long j, ImageSource imageSource, int i);

    public static final native int ImageSource_Stride(long j, ImageSource imageSource);

    public static final native long ImageSource_Warp__SWIG_0(long j, ImageSource imageSource, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, long j2, Size2i size2i);

    public static final native long ImageSource_Warp__SWIG_1(long j, ImageSource imageSource, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j2, Size2i size2i);

    public static final native int ImageSource_Width(long j, ImageSource imageSource);

    public static final native boolean ImageSource_empty(long j, ImageSource imageSource);

    public static final native long ImageSource_getGray(long j, ImageSource imageSource);

    public static final native long ImageSource_getImage(long j, ImageSource imageSource);

    public static final native long ImageSource_getRGB(long j, ImageSource imageSource);

    public static final native int Image_channelDepth(long j, Image image);

    public static final native int Image_channels(long j, Image image);

    public static final native boolean Image_empty(long j, Image image);

    public static final native int Image_format(long j, Image image);

    public static final native void Image_getBytes(long j, Image image, byte[] bArr);

    public static final native int Image_height(long j, Image image);

    public static final native int Image_length(long j, Image image);

    public static final native int Image_stride(long j, Image image);

    public static final native int Image_width(long j, Image image);

    public static final native float KeyPoint_angle_get(long j, KeyPoint keyPoint);

    public static final native void KeyPoint_angle_set(long j, KeyPoint keyPoint, float f);

    public static final native int KeyPoint_class_id_get(long j, KeyPoint keyPoint);

    public static final native void KeyPoint_class_id_set(long j, KeyPoint keyPoint, int i);

    public static final native int KeyPoint_octave_get(long j, KeyPoint keyPoint);

    public static final native void KeyPoint_octave_set(long j, KeyPoint keyPoint, int i);

    public static final native long KeyPoint_pt_get(long j, KeyPoint keyPoint);

    public static final native void KeyPoint_pt_set(long j, KeyPoint keyPoint, long j2, Point2f point2f);

    public static final native float KeyPoint_response_get(long j, KeyPoint keyPoint);

    public static final native void KeyPoint_response_set(long j, KeyPoint keyPoint, float f);

    public static final native float KeyPoint_size_get(long j, KeyPoint keyPoint);

    public static final native void KeyPoint_size_set(long j, KeyPoint keyPoint, float f);

    public static final native long Line_getP1(long j, Line line);

    public static final native long Line_getP2(long j, Line line);

    public static final native void Line_setP1(long j, Line line, long j2, Point2f point2f);

    public static final native void Line_setP2(long j, Line line, long j2, Point2f point2f);

    public static final native float Point2f_getX(long j, Point2f point2f);

    public static final native float Point2f_getY(long j, Point2f point2f);

    public static final native void Point2f_setX(long j, Point2f point2f, float f);

    public static final native void Point2f_setY(long j, Point2f point2f, float f);

    public static final native int Point2i_getX(long j, Point2i point2i);

    public static final native int Point2i_getY(long j, Point2i point2i);

    public static final native void Point2i_setX(long j, Point2i point2i, int i);

    public static final native void Point2i_setY(long j, Point2i point2i, int i);

    public static final native long Quadrangle_getBottomLeft(long j, Quadrangle quadrangle);

    public static final native long Quadrangle_getBottomRight(long j, Quadrangle quadrangle);

    public static final native long Quadrangle_getTopLeft(long j, Quadrangle quadrangle);

    public static final native long Quadrangle_getTopRight(long j, Quadrangle quadrangle);

    public static final native void Quadrangle_setBottomLeft(long j, Quadrangle quadrangle, long j2, Point2f point2f);

    public static final native void Quadrangle_setBottomRight(long j, Quadrangle quadrangle, long j2, Point2f point2f);

    public static final native void Quadrangle_setTopLeft(long j, Quadrangle quadrangle, long j2, Point2f point2f);

    public static final native void Quadrangle_setTopRight(long j, Quadrangle quadrangle, long j2, Point2f point2f);

    public static final native int Rect2i_area(long j, Rect2i rect2i);

    public static final native int Rect2i_getHeight(long j, Rect2i rect2i);

    public static final native int Rect2i_getWidth(long j, Rect2i rect2i);

    public static final native int Rect2i_getX(long j, Rect2i rect2i);

    public static final native int Rect2i_getY(long j, Rect2i rect2i);

    public static final native void Rect2i_setHeight(long j, Rect2i rect2i, int i);

    public static final native void Rect2i_setWidth(long j, Rect2i rect2i, int i);

    public static final native void Rect2i_setX(long j, Rect2i rect2i, int i);

    public static final native void Rect2i_setY(long j, Rect2i rect2i, int i);

    public static final native int Size2i_getHeight(long j, Size2i size2i);

    public static final native int Size2i_getWidth(long j, Size2i size2i);

    public static final native void Size2i_setHeight(long j, Size2i size2i, int i);

    public static final native void Size2i_setWidth(long j, Size2i size2i, int i);

    public static void SwigDirector_FrameProcessor_processFrame(FrameProcessor frameProcessor) {
        frameProcessor.processFrame();
    }

    public static void SwigDirector_FrameProcessor_pushFrame(FrameProcessor frameProcessor, int i, long j) {
        frameProcessor.pushFrame(i, new ImageSource(j, false));
    }

    public static void SwigDirector_FrameProcessor_resetState(FrameProcessor frameProcessor) {
        frameProcessor.resetState();
    }

    public static final native long channelsCount(int i);

    public static final native void delete_Color(long j);

    public static final native void delete_FrameProcessor(long j);

    public static final native void delete_FrameProcessorException(long j);

    public static final native void delete_FrameQueue(long j);

    public static final native void delete_Image(long j);

    public static final native void delete_ImageSource(long j);

    public static final native void delete_ImageSourceVector(long j);

    public static final native void delete_KeyPoint(long j);

    public static final native void delete_Line(long j);

    public static final native void delete_Point2f(long j);

    public static final native void delete_Point2i(long j);

    public static final native void delete_Quadrangle(long j);

    public static final native void delete_Rect2i(long j);

    public static final native void delete_Size2i(long j);

    public static final native long new_Color__SWIG_0();

    public static final native long new_Color__SWIG_1(int i, int i2, int i3, int i4);

    public static final native long new_FrameProcessor(int i);

    public static final native long new_FrameProcessorException__SWIG_0(String str);

    public static final native long new_FrameQueue(long j);

    public static final native long new_Image();

    public static final native long new_ImageSourceVector__SWIG_0();

    public static final native long new_ImageSourceVector__SWIG_1(long j);

    public static final native long new_ImageSource__SWIG_0();

    public static final native long new_ImageSource__SWIG_1(long j, ImageSource imageSource);

    public static final native long new_KeyPoint__SWIG_0();

    public static final native long new_KeyPoint__SWIG_1(long j, Point2f point2f, float f, float f2, float f3, int i, int i2);

    public static final native long new_KeyPoint__SWIG_10(float f, float f2, float f3);

    public static final native long new_KeyPoint__SWIG_2(long j, Point2f point2f, float f, float f2, float f3, int i);

    public static final native long new_KeyPoint__SWIG_3(long j, Point2f point2f, float f, float f2, float f3);

    public static final native long new_KeyPoint__SWIG_4(long j, Point2f point2f, float f, float f2);

    public static final native long new_KeyPoint__SWIG_5(long j, Point2f point2f, float f);

    public static final native long new_KeyPoint__SWIG_6(float f, float f2, float f3, float f4, float f5, int i, int i2);

    public static final native long new_KeyPoint__SWIG_7(float f, float f2, float f3, float f4, float f5, int i);

    public static final native long new_KeyPoint__SWIG_8(float f, float f2, float f3, float f4, float f5);

    public static final native long new_KeyPoint__SWIG_9(float f, float f2, float f3, float f4);

    public static final native long new_Line__SWIG_0();

    public static final native long new_Line__SWIG_1(long j, Point2f point2f, long j2, Point2f point2f2);

    public static final native long new_Point2f__SWIG_0();

    public static final native long new_Point2f__SWIG_1(float f, float f2);

    public static final native long new_Point2i__SWIG_0();

    public static final native long new_Point2i__SWIG_1(int i, int i2);

    public static final native long new_Quadrangle__SWIG_0();

    public static final native long new_Quadrangle__SWIG_1(long j, Point2f point2f, long j2, Point2f point2f2, long j3, Point2f point2f3, long j4, Point2f point2f4);

    public static final native long new_Rect2i__SWIG_0();

    public static final native long new_Rect2i__SWIG_1(int i, int i2, int i3, int i4);

    public static final native long new_Size2i__SWIG_0();

    public static final native long new_Size2i__SWIG_1(int i, int i2);

    public static final native void swig_module_init();
}
