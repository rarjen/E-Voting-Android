package com.example.evoting.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/example/evoting/api/APIClient;", "", "()V", "BASE_URL", "", "client", "Lokhttp3/OkHttpClient;", "instance", "Lcom/example/evoting/api/APIService;", "getInstance", "()Lcom/example/evoting/api/APIService;", "instance$delegate", "Lkotlin/Lazy;", "logging", "Lokhttp3/logging/HttpLoggingInterceptor;", "getLogging", "()Lokhttp3/logging/HttpLoggingInterceptor;", "createRetrofit", "Lretrofit2/Retrofit;", "getRetrofitBuilder", "getUrlBase", "app_debug"})
public final class APIClient {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String BASE_URL = "http://10.0.2.2:3000/api/v1/";
    @org.jetbrains.annotations.NotNull
    private static final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy instance$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.evoting.api.APIClient INSTANCE = null;
    
    private APIClient() {
        super();
    }
    
    private final okhttp3.logging.HttpLoggingInterceptor getLogging() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUrlBase() {
        return null;
    }
    
    private final retrofit2.Retrofit createRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final retrofit2.Retrofit getRetrofitBuilder() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.evoting.api.APIService getInstance() {
        return null;
    }
}