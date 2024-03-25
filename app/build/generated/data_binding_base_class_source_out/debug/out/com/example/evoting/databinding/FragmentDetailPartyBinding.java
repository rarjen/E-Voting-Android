// Generated by view binder compiler. Do not edit!
package com.example.evoting.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.evoting.R;
import com.google.android.material.divider.MaterialDivider;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDetailPartyBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final ImageView partyImg;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final MaterialDivider separator1;

  @NonNull
  public final MaterialDivider separator2;

  @NonNull
  public final TextView tvDesc;

  @NonNull
  public final TextView tvFullName;

  @NonNull
  public final TextView tvNama;

  @NonNull
  public final TextView tvValueDesc;

  @NonNull
  public final TextView tvValueFullNamaPartai;

  @NonNull
  public final TextView tvValueNamaPartai;

  private FragmentDetailPartyBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView ivBack,
      @NonNull ImageView partyImg, @NonNull ProgressBar progressBar,
      @NonNull MaterialDivider separator1, @NonNull MaterialDivider separator2,
      @NonNull TextView tvDesc, @NonNull TextView tvFullName, @NonNull TextView tvNama,
      @NonNull TextView tvValueDesc, @NonNull TextView tvValueFullNamaPartai,
      @NonNull TextView tvValueNamaPartai) {
    this.rootView = rootView;
    this.ivBack = ivBack;
    this.partyImg = partyImg;
    this.progressBar = progressBar;
    this.separator1 = separator1;
    this.separator2 = separator2;
    this.tvDesc = tvDesc;
    this.tvFullName = tvFullName;
    this.tvNama = tvNama;
    this.tvValueDesc = tvValueDesc;
    this.tvValueFullNamaPartai = tvValueFullNamaPartai;
    this.tvValueNamaPartai = tvValueNamaPartai;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDetailPartyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDetailPartyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_detail_party, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDetailPartyBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ivBack;
      ImageView ivBack = ViewBindings.findChildViewById(rootView, id);
      if (ivBack == null) {
        break missingId;
      }

      id = R.id.partyImg;
      ImageView partyImg = ViewBindings.findChildViewById(rootView, id);
      if (partyImg == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.separator1;
      MaterialDivider separator1 = ViewBindings.findChildViewById(rootView, id);
      if (separator1 == null) {
        break missingId;
      }

      id = R.id.separator2;
      MaterialDivider separator2 = ViewBindings.findChildViewById(rootView, id);
      if (separator2 == null) {
        break missingId;
      }

      id = R.id.tvDesc;
      TextView tvDesc = ViewBindings.findChildViewById(rootView, id);
      if (tvDesc == null) {
        break missingId;
      }

      id = R.id.tvFullName;
      TextView tvFullName = ViewBindings.findChildViewById(rootView, id);
      if (tvFullName == null) {
        break missingId;
      }

      id = R.id.tvNama;
      TextView tvNama = ViewBindings.findChildViewById(rootView, id);
      if (tvNama == null) {
        break missingId;
      }

      id = R.id.tvValueDesc;
      TextView tvValueDesc = ViewBindings.findChildViewById(rootView, id);
      if (tvValueDesc == null) {
        break missingId;
      }

      id = R.id.tvValueFullNamaPartai;
      TextView tvValueFullNamaPartai = ViewBindings.findChildViewById(rootView, id);
      if (tvValueFullNamaPartai == null) {
        break missingId;
      }

      id = R.id.tvValueNamaPartai;
      TextView tvValueNamaPartai = ViewBindings.findChildViewById(rootView, id);
      if (tvValueNamaPartai == null) {
        break missingId;
      }

      return new FragmentDetailPartyBinding((ConstraintLayout) rootView, ivBack, partyImg,
          progressBar, separator1, separator2, tvDesc, tvFullName, tvNama, tvValueDesc,
          tvValueFullNamaPartai, tvValueNamaPartai);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}