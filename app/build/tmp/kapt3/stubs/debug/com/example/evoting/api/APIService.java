package com.example.evoting.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\n\u001a\u00020\u000b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\'\u0010\f\u001a\u00020\r2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u0012\u001a\u00020\u0017H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\u001aH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\'\u0010\u001c\u001a\u00020\u001d2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u001eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/example/evoting/api/APIService;", "", "authMeEndpoint", "Lcom/example/evoting/model/AuthMeResponse;", "tokenUser", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPairNumberEndpoint", "Lcom/example/evoting/model/CandidateNumberResponse;", "token", "getAllVotingResultEndpoint", "Lcom/example/evoting/model/VotingResultResponse;", "getOnePairNumberEndpoint", "Lcom/example/evoting/model/GetOneCandidateNumberResponse;", "id", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginEndpoint", "Lcom/example/evoting/model/LoginResponse;", "request", "Lcom/example/evoting/model/LoginRequest;", "(Lcom/example/evoting/model/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerEndpoint", "Lcom/example/evoting/model/RegisterResponse;", "Lcom/example/evoting/model/RegisterRequest;", "(Lcom/example/evoting/model/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "testRoute", "Lcom/example/evoting/model/TestResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "voteEndpoint", "Lcom/example/evoting/model/CreateVoteResponse;", "Lcom/example/evoting/model/VoteRequest;", "(Ljava/lang/String;Lcom/example/evoting/model/VoteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface APIService {
    
    @retrofit2.http.GET(value = "test")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object testRoute(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.TestResponse> $completion);
    
    @retrofit2.http.POST(value = "auth/register")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object registerEndpoint(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.evoting.model.RegisterRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.RegisterResponse> $completion);
    
    @retrofit2.http.POST(value = "auth/login")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object loginEndpoint(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.evoting.model.LoginRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.LoginResponse> $completion);
    
    @retrofit2.http.GET(value = "auth/whoami")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object authMeEndpoint(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.Nullable
    java.lang.String tokenUser, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.AuthMeResponse> $completion);
    
    @retrofit2.http.GET(value = "pair-number")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllPairNumberEndpoint(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.Nullable
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.CandidateNumberResponse> $completion);
    
    @retrofit2.http.GET(value = "pair-number/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getOnePairNumberEndpoint(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.Nullable
    java.lang.String token, @retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.GetOneCandidateNumberResponse> $completion);
    
    @retrofit2.http.POST(value = "vote")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object voteEndpoint(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.Nullable
    java.lang.String token, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.evoting.model.VoteRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.CreateVoteResponse> $completion);
    
    @retrofit2.http.GET(value = "voting-result")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllVotingResultEndpoint(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.Nullable
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evoting.model.VotingResultResponse> $completion);
}