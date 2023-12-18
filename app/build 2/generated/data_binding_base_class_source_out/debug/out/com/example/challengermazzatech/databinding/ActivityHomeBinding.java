// Generated by view binder compiler. Do not edit!
package com.example.challengermazzatech.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.challengermazzatech.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityHomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout RecycleView;

  @NonNull
  public final ImageView goBack;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final RecyclerView recycleView;

  @NonNull
  public final EditText textSearch;

  @NonNull
  public final TextView textView;

  private ActivityHomeBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout RecycleView, @NonNull ImageView goBack,
      @NonNull ImageView imageView3, @NonNull RecyclerView recycleView,
      @NonNull EditText textSearch, @NonNull TextView textView) {
    this.rootView = rootView;
    this.RecycleView = RecycleView;
    this.goBack = goBack;
    this.imageView3 = imageView3;
    this.recycleView = recycleView;
    this.textSearch = textSearch;
    this.textView = textView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout RecycleView = (ConstraintLayout) rootView;

      id = R.id.goBack;
      ImageView goBack = ViewBindings.findChildViewById(rootView, id);
      if (goBack == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.recycleView;
      RecyclerView recycleView = ViewBindings.findChildViewById(rootView, id);
      if (recycleView == null) {
        break missingId;
      }

      id = R.id.textSearch;
      EditText textSearch = ViewBindings.findChildViewById(rootView, id);
      if (textSearch == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      return new ActivityHomeBinding((ConstraintLayout) rootView, RecycleView, goBack, imageView3,
          recycleView, textSearch, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}