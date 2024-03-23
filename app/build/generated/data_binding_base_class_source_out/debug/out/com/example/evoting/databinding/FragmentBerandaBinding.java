// Generated by view binder compiler. Do not edit!
package com.example.evoting.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.evoting.R;
import com.google.android.material.tabs.TabLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentBerandaBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageBanner;

  @NonNull
  public final ProgressBar progressBarCapres;

  @NonNull
  public final ProgressBar progressBarCawapres;

  @NonNull
  public final ProgressBar progressBarParties;

  @NonNull
  public final RecyclerView rvCapres;

  @NonNull
  public final RecyclerView rvCawapres;

  @NonNull
  public final RecyclerView rvPartai;

  @NonNull
  public final TabLayout tabLayout;

  @NonNull
  public final TabLayout tabLayoutNomerUrut;

  private FragmentBerandaBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView imageBanner,
      @NonNull ProgressBar progressBarCapres, @NonNull ProgressBar progressBarCawapres,
      @NonNull ProgressBar progressBarParties, @NonNull RecyclerView rvCapres,
      @NonNull RecyclerView rvCawapres, @NonNull RecyclerView rvPartai,
      @NonNull TabLayout tabLayout, @NonNull TabLayout tabLayoutNomerUrut) {
    this.rootView = rootView;
    this.imageBanner = imageBanner;
    this.progressBarCapres = progressBarCapres;
    this.progressBarCawapres = progressBarCawapres;
    this.progressBarParties = progressBarParties;
    this.rvCapres = rvCapres;
    this.rvCawapres = rvCawapres;
    this.rvPartai = rvPartai;
    this.tabLayout = tabLayout;
    this.tabLayoutNomerUrut = tabLayoutNomerUrut;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentBerandaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentBerandaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_beranda, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentBerandaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageBanner;
      ImageView imageBanner = ViewBindings.findChildViewById(rootView, id);
      if (imageBanner == null) {
        break missingId;
      }

      id = R.id.progressBarCapres;
      ProgressBar progressBarCapres = ViewBindings.findChildViewById(rootView, id);
      if (progressBarCapres == null) {
        break missingId;
      }

      id = R.id.progressBarCawapres;
      ProgressBar progressBarCawapres = ViewBindings.findChildViewById(rootView, id);
      if (progressBarCawapres == null) {
        break missingId;
      }

      id = R.id.progressBarParties;
      ProgressBar progressBarParties = ViewBindings.findChildViewById(rootView, id);
      if (progressBarParties == null) {
        break missingId;
      }

      id = R.id.rvCapres;
      RecyclerView rvCapres = ViewBindings.findChildViewById(rootView, id);
      if (rvCapres == null) {
        break missingId;
      }

      id = R.id.rvCawapres;
      RecyclerView rvCawapres = ViewBindings.findChildViewById(rootView, id);
      if (rvCawapres == null) {
        break missingId;
      }

      id = R.id.rvPartai;
      RecyclerView rvPartai = ViewBindings.findChildViewById(rootView, id);
      if (rvPartai == null) {
        break missingId;
      }

      id = R.id.tabLayout;
      TabLayout tabLayout = ViewBindings.findChildViewById(rootView, id);
      if (tabLayout == null) {
        break missingId;
      }

      id = R.id.tabLayoutNomerUrut;
      TabLayout tabLayoutNomerUrut = ViewBindings.findChildViewById(rootView, id);
      if (tabLayoutNomerUrut == null) {
        break missingId;
      }

      return new FragmentBerandaBinding((ConstraintLayout) rootView, imageBanner, progressBarCapres,
          progressBarCawapres, progressBarParties, rvCapres, rvCawapres, rvPartai, tabLayout,
          tabLayoutNomerUrut);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
