package com.example.evoting.view.fragments;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0012\u0010\"\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010#H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006$"}, d2 = {"Lcom/example/evoting/view/fragments/BerandaFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/evoting/databinding/FragmentBerandaBinding;", "binding", "getBinding", "()Lcom/example/evoting/databinding/FragmentBerandaBinding;", "pref", "Lcom/example/evoting/util/SharedPreferenceHelper;", "viewModel", "Lcom/example/evoting/viewmodel/MyViewModel;", "getViewModel", "()Lcom/example/evoting/viewmodel/MyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "authMe", "", "token", "", "fetchParties", "fetchPresidential", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "showParties", "data", "Lcom/example/evoting/model/GetAllPartiesResponse;", "showPresidential", "Lcom/example/evoting/model/GetAllPresidentialResponse;", "app_debug"})
public final class BerandaFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.example.evoting.databinding.FragmentBerandaBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private com.example.evoting.util.SharedPreferenceHelper pref;
    
    public BerandaFragment() {
        super();
    }
    
    private final com.example.evoting.databinding.FragmentBerandaBinding getBinding() {
        return null;
    }
    
    private final com.example.evoting.viewmodel.MyViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void fetchParties(java.lang.String token) {
    }
    
    private final void fetchPresidential(java.lang.String token) {
    }
    
    private final void authMe(java.lang.String token) {
    }
    
    private final void showParties(com.example.evoting.model.GetAllPartiesResponse data) {
    }
    
    private final void showPresidential(com.example.evoting.model.GetAllPresidentialResponse data) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}