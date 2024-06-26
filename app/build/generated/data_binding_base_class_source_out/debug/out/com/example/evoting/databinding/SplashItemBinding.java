// Generated by view binder compiler. Do not edit!
package com.example.evoting.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.evoting.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SplashItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ImageView ivsplashImage;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView tvsplashDesk;

  private SplashItemBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView imageView,
      @NonNull ImageView ivsplashImage, @NonNull TextView textView,
      @NonNull TextView tvsplashDesk) {
    this.rootView = rootView;
    this.imageView = imageView;
    this.ivsplashImage = ivsplashImage;
    this.textView = textView;
    this.tvsplashDesk = tvsplashDesk;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SplashItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SplashItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.splash_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SplashItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.ivsplash_image;
      ImageView ivsplashImage = ViewBindings.findChildViewById(rootView, id);
      if (ivsplashImage == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.tvsplash_desk;
      TextView tvsplashDesk = ViewBindings.findChildViewById(rootView, id);
      if (tvsplashDesk == null) {
        break missingId;
      }

      return new SplashItemBinding((ConstraintLayout) rootView, imageView, ivsplashImage, textView,
          tvsplashDesk);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
