package com.example.evoting.view.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0019B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0014\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0018R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\b0\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/evoting/view/adapters/ProfilePresidentialCandidateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/evoting/view/adapters/ProfilePresidentialCandidateAdapter$ViewHolder;", "onItemClick", "Landroid/widget/AdapterView$OnItemClickListener;", "(Landroid/widget/AdapterView$OnItemClickListener;)V", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/evoting/model/DataGetAllPresidentialResponse;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitAllPresidential", "value", "", "ViewHolder", "app_debug"})
public final class ProfilePresidentialCandidateAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.evoting.view.adapters.ProfilePresidentialCandidateAdapter.ViewHolder> {
    @org.jetbrains.annotations.Nullable
    private final android.widget.AdapterView.OnItemClickListener onItemClick = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.evoting.model.DataGetAllPresidentialResponse> diffCallback = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.recyclerview.widget.AsyncListDiffer<com.example.evoting.model.DataGetAllPresidentialResponse> differ = null;
    
    public ProfilePresidentialCandidateAdapter(@org.jetbrains.annotations.Nullable
    android.widget.AdapterView.OnItemClickListener onItemClick) {
        super();
    }
    
    public final void submitAllPresidential(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.evoting.model.DataGetAllPresidentialResponse> value) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.evoting.view.adapters.ProfilePresidentialCandidateAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.evoting.view.adapters.ProfilePresidentialCandidateAdapter.ViewHolder holder, int position) {
    }
    
    public ProfilePresidentialCandidateAdapter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/evoting/view/adapters/ProfilePresidentialCandidateAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/evoting/databinding/CardCandidateBinding;", "(Lcom/example/evoting/view/adapters/ProfilePresidentialCandidateAdapter;Lcom/example/evoting/databinding/CardCandidateBinding;)V", "bind", "", "data", "Lcom/example/evoting/model/DataGetAllPresidentialResponse;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private com.example.evoting.databinding.CardCandidateBinding binding;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.example.evoting.databinding.CardCandidateBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.evoting.model.DataGetAllPresidentialResponse data) {
        }
    }
}