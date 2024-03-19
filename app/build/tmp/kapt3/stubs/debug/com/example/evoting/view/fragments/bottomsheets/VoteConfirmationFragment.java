package com.example.evoting.view.fragments.bottomsheets;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\tH\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006#"}, d2 = {"Lcom/example/evoting/view/fragments/bottomsheets/VoteConfirmationFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "_binding", "Lcom/example/evoting/databinding/FragmentVoteConfirmationBinding;", "binding", "getBinding", "()Lcom/example/evoting/databinding/FragmentVoteConfirmationBinding;", "id", "", "pref", "Lcom/example/evoting/util/SharedPreferenceHelper;", "viewModel", "Lcom/example/evoting/viewmodel/MyViewModel;", "getViewModel", "()Lcom/example/evoting/viewmodel/MyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "fetchOneCandidateNumberCoroutines", "", "token", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "postVoteCoroutines", "setId", "showData", "data", "Lcom/example/evoting/model/GetOneCandidateNumberResponse;", "app_debug"})
public final class VoteConfirmationFragment extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    @org.jetbrains.annotations.Nullable
    private com.example.evoting.databinding.FragmentVoteConfirmationBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable
    private java.lang.String id;
    private com.example.evoting.util.SharedPreferenceHelper pref;
    
    public VoteConfirmationFragment() {
        super();
    }
    
    private final com.example.evoting.databinding.FragmentVoteConfirmationBinding getBinding() {
        return null;
    }
    
    private final com.example.evoting.viewmodel.MyViewModel getViewModel() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void fetchOneCandidateNumberCoroutines(java.lang.String token, java.lang.String id) {
    }
    
    private final void postVoteCoroutines(java.lang.String token, java.lang.String id) {
    }
    
    private final void showData(com.example.evoting.model.GetOneCandidateNumberResponse data) {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
}