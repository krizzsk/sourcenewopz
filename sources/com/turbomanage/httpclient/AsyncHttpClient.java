package com.turbomanage.httpclient;

public class AsyncHttpClient extends AbstractHttpClient {
    private static final String ACCEPT_ENCODING = "Accept-Encoding";
    private static final String GZIP = "gzip";
    static int[] fib = new int[20];
    protected final AsyncRequestExecutorFactory execFactory;
    private int maxRetries;

    static {
        int i = 0;
        while (i < 20) {
            int[] iArr = fib;
            iArr[i] = i < 2 ? i : iArr[i - 2] + iArr[i - 1];
            i++;
        }
    }

    public AsyncHttpClient(AsyncRequestExecutorFactory asyncRequestExecutorFactory) {
        this(asyncRequestExecutorFactory, "");
    }

    public AsyncHttpClient(AsyncRequestExecutorFactory asyncRequestExecutorFactory, String str) {
        this(asyncRequestExecutorFactory, str, new BasicRequestHandler() {
        });
    }

    public AsyncHttpClient(AsyncRequestExecutorFactory asyncRequestExecutorFactory, String str, RequestHandler requestHandler) {
        super(str, requestHandler);
        this.maxRetries = 3;
        this.execFactory = asyncRequestExecutorFactory;
    }

    public void head(String str, ParameterMap parameterMap, AsyncCallback asyncCallback) {
        executeAsync(new HttpHead(str, parameterMap), asyncCallback);
    }

    public void get(String str, ParameterMap parameterMap, AsyncCallback asyncCallback) {
        this.requestHeaders.put("Accept-Encoding", GZIP);
        executeAsync(new HttpGet(str, parameterMap), asyncCallback);
    }

    public void post(String str, ParameterMap parameterMap, AsyncCallback asyncCallback) {
        executeAsync(new HttpPost(str, parameterMap), asyncCallback);
    }

    public void post(String str, String str2, byte[] bArr, AsyncCallback asyncCallback) throws Exception {
        executeAsync(new HttpPost(str, (ParameterMap) null, str2, bArr), asyncCallback);
    }

    public void put(String str, String str2, byte[] bArr, AsyncCallback asyncCallback) {
        executeAsync(new HttpPut(str, (ParameterMap) null, str2, bArr), asyncCallback);
    }

    public void delete(String str, ParameterMap parameterMap, AsyncCallback asyncCallback) {
        executeAsync(new HttpDelete(str, parameterMap), asyncCallback);
    }

    /* access modifiers changed from: protected */
    public void executeAsync(HttpRequest httpRequest, AsyncCallback asyncCallback) {
        this.execFactory.getAsyncRequestExecutor(this, asyncCallback).execute(httpRequest);
    }

    public HttpResponse tryMany(HttpRequest httpRequest) throws HttpRequestException {
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        while (i < this.maxRetries) {
            try {
                setConnectionTimeout(getNextTimeout(i));
                if (this.requestLogger.isLoggingEnabled()) {
                    RequestLogger requestLogger = this.requestLogger;
                    requestLogger.log((i + 1) + "of" + this.maxRetries + ", trying " + httpRequest.getPath());
                }
                currentTimeMillis = System.currentTimeMillis();
                HttpResponse doHttpMethod = doHttpMethod(httpRequest.getPath(), httpRequest.getHttpMethod(), httpRequest.getContentType(), httpRequest.getContent());
                if (doHttpMethod != null) {
                    return doHttpMethod;
                }
                i++;
            } catch (HttpRequestException e) {
                if (isTimeoutException(e, currentTimeMillis) && i < this.maxRetries - 1) {
                    continue;
                } else if (!this.requestHandler.onError(e) || i >= this.maxRetries - 1) {
                    throw e;
                } else {
                    try {
                        Thread.sleep((long) this.connectionTimeout);
                    } catch (InterruptedException unused) {
                        throw e;
                    }
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getNextTimeout(int i) {
        return fib[i + 2] * 1000;
    }

    public void setMaxRetries(int i) {
        if (i < 1 || i > 18) {
            throw new IllegalArgumentException("Maximum retries must be between 1 and 18");
        }
        this.maxRetries = i;
    }
}
