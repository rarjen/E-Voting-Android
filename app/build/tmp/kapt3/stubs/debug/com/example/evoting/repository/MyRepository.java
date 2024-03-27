package com.example.evoting.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ%\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\u0011\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\u0013\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\u0014\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ#\u0010\u0016\u001a\u00020\u00172\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ#\u0010\u0019\u001a\u00020\u001a2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ#\u0010\u001b\u001a\u00020\u001c2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ#\u0010\u001d\u001a\u00020\u001c2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J#\u0010(\u001a\u00020)2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010*\u001a\u00020+H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J\u0011\u0010-\u001a\u00020.H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/J#\u00100\u001a\u0002012\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u00102\u001a\u000203H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00104R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/example/evoting/repository/MyRepository;", "", "()V", "apiService", "Lcom/example/evoting/api/APIService;", "authMe", "Lcom/example/evoting/model/AuthMeResponse;", "tokenUser", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "candidatePairNumber", "Lcom/example/evoting/model/CandidateNumberResponse;", "token", "number", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllParties", "Lcom/example/evoting/model/GetAllPartiesResponse;", "getAllPresidential", "Lcom/example/evoting/model/GetAllPresidentialResponse;", "getAllVicePresidential", "getAllVoteResult", "Lcom/example/evoting/model/VotingResultResponse;", "getOneCandidatePairNumber", "Lcom/example/evoting/model/GetOneCandidateNumberResponse;", "id", "getOneParty", "Lcom/example/evoting/model/GetOnePartyResponse;", "getOnePresidential", "Lcom/example/evoting/model/GetBiographyResponse;", "getOneVicePresidential", "loginAuth", "Lcom/example/evoting/model/LoginResponse;", "loginRequest", "Lcom/example/evoting/model/LoginRequest;", "(Lcom/example/evoting/model/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerAuth", "Lcom/example/evoting/model/RegisterResponse;", "registerRequest", "Lcom/example/evoting/model/RegisterRequest;", "(Lcom/example/evoting/model/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPasswordUser", "Lcom/example/evoting/model/ResetPasswordResponse;", "resetPasswordRequest", "Lcom/example/evoting/model/ResetPasswordRequest;", "(Ljava/lang/String;Lcom/example/evoting/model/ResetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "testRouteRepo", "Lcom/example/evoting/model/TestResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "votePost", "Lcom/example/evoting/model/CreateVoteResponse;", "voteRequest", "Lcom/example/evoting/model/VoteRequest;", "(Ljava/lang/String;Lcom/example/evoting/model/VoteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MyRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.evoting.api.APIService apiService = null;
    
    public MyRepository() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object testRouteRepo(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.TestResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object registerAuth(@org.jetbrains.annotations.NotNull
    com.example.evoting.model.RegisterRequest registerRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.RegisterResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object loginAuth(@org.jetbrains.annotations.NotNull
    com.example.evoting.model.LoginRequest loginRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.LoginResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object authMe(@org.jetbrains.annotations.Nullable
    java.lang.String tokenUser, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.AuthMeResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object resetPasswordUser(@org.jetbrains.annotations.Nullable
    java.lang.String token, @org.jetbrains.annotations.NotNull
    com.example.evoting.model.ResetPasswordRequest resetPasswordRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.ResetPasswordResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object candidatePairNumber(@org.jetbrains.annotations.Nullable
    java.lang.String token, @org.jetbrains.annotations.Nullable
    java.lang.String number, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.CandidateNumberResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getOneCandidatePairNumber(@org.jetbrains.annotations.Nullable
    java.lang.String token, @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.GetOneCandidateNumberResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object votePost(@org.jetbrains.annotations.Nullable
    java.lang.String token, @org.jetbrains.annotations.NotNull
    com.example.evoting.model.VoteRequest voteRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.CreateVoteResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAllVoteResult(@org.jetbrains.annotations.Nullable
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.VotingResultResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAllParties(@org.jetbrains.annotations.Nullable
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.GetAllPartiesResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getOneParty(@org.jetbrains.annotations.Nullable
    java.lang.String token, @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.GetOnePartyResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAllPresidential(@org.jetbrains.annotations.Nullable
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.GetAllPresidentialResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getOnePresidential(@org.jetbrains.annotations.Nullable
    java.lang.String token, @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.GetBiographyResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAllVicePresidential(@org.jetbrains.annotations.Nullable
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.GetAllPresidentialResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getOneVicePresidential(@org.jetbrains.annotations.Nullable
    java.lang.String token, @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.GetBiographyResponse> $completion) {
        return null;
    }
}