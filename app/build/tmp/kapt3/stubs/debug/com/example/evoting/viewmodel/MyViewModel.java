package com.example.evoting.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u00062\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u00062\b\u0010\r\u001a\u0004\u0018\u00010\nJ$\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u00062\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\nJ\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00070\u00062\u0006\u0010\u0015\u001a\u00020\u0016J\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00070\u00062\u0006\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00070\u0006J$\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00070\u00062\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/evoting/viewmodel/MyViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/evoting/repository/MyRepository;", "(Lcom/example/evoting/repository/MyRepository;)V", "authMeAuth", "Landroidx/lifecycle/LiveData;", "Lcom/example/evoting/util/Resource;", "Lcom/example/evoting/model/AuthMeResponse;", "tokenUser", "", "candidateNumber", "Lcom/example/evoting/model/CandidateNumberResponse;", "token", "getAllResult", "Lcom/example/evoting/model/VotingResultResponse;", "getOneCandidateNumber", "Lcom/example/evoting/model/GetOneCandidateNumberResponse;", "id", "login", "Lcom/example/evoting/model/LoginResponse;", "loginRequest", "Lcom/example/evoting/model/LoginRequest;", "register", "Lcom/example/evoting/model/RegisterResponse;", "registerRequest", "Lcom/example/evoting/model/RegisterRequest;", "testRoute", "Lcom/example/evoting/model/TestResponse;", "vote", "Lcom/example/evoting/model/CreateVoteResponse;", "voteRequest", "Lcom/example/evoting/model/VoteRequest;", "app_debug"})
public final class MyViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.evoting.repository.MyRepository repository = null;
    
    public MyViewModel(@org.jetbrains.annotations.NotNull
    com.example.evoting.repository.MyRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.evoting.util.Resource<com.example.evoting.model.TestResponse>> testRoute() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.evoting.util.Resource<com.example.evoting.model.RegisterResponse>> register(@org.jetbrains.annotations.NotNull
    com.example.evoting.model.RegisterRequest registerRequest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.evoting.util.Resource<com.example.evoting.model.LoginResponse>> login(@org.jetbrains.annotations.NotNull
    com.example.evoting.model.LoginRequest loginRequest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.evoting.util.Resource<com.example.evoting.model.AuthMeResponse>> authMeAuth(@org.jetbrains.annotations.Nullable
    java.lang.String tokenUser) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.evoting.util.Resource<com.example.evoting.model.CandidateNumberResponse>> candidateNumber(@org.jetbrains.annotations.Nullable
    java.lang.String token) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.evoting.util.Resource<com.example.evoting.model.GetOneCandidateNumberResponse>> getOneCandidateNumber(@org.jetbrains.annotations.Nullable
    java.lang.String token, @org.jetbrains.annotations.NotNull
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.evoting.util.Resource<com.example.evoting.model.CreateVoteResponse>> vote(@org.jetbrains.annotations.Nullable
    java.lang.String token, @org.jetbrains.annotations.NotNull
    com.example.evoting.model.VoteRequest voteRequest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.evoting.util.Resource<com.example.evoting.model.VotingResultResponse>> getAllResult(@org.jetbrains.annotations.Nullable
    java.lang.String token) {
        return null;
    }
}