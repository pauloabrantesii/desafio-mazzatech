// Generated by view binder compiler. Do not edit!
package com.example.challengermazzatech.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.challengermazzatech.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText TextPassword;

  @NonNull
  public final EditText TextTextEmailAddress;

  @NonNull
  public final Button buttonAcessar;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView textView1;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView textViewN;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull EditText TextPassword,
      @NonNull EditText TextTextEmailAddress, @NonNull Button buttonAcessar,
      @NonNull ImageView imageView, @NonNull TextView textView1, @NonNull TextView textView2,
      @NonNull TextView textView3, @NonNull TextView textView5, @NonNull TextView textView6,
      @NonNull TextView textViewN) {
    this.rootView = rootView;
    this.TextPassword = TextPassword;
    this.TextTextEmailAddress = TextTextEmailAddress;
    this.buttonAcessar = buttonAcessar;
    this.imageView = imageView;
    this.textView1 = textView1;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView5 = textView5;
    this.textView6 = textView6;
    this.textViewN = textViewN;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.TextPassword;
      EditText TextPassword = ViewBindings.findChildViewById(rootView, id);
      if (TextPassword == null) {
        break missingId;
      }

      id = R.id.TextTextEmailAddress;
      EditText TextTextEmailAddress = ViewBindings.findChildViewById(rootView, id);
      if (TextTextEmailAddress == null) {
        break missingId;
      }

      id = R.id.buttonAcessar;
      Button buttonAcessar = ViewBindings.findChildViewById(rootView, id);
      if (buttonAcessar == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.textView1;
      TextView textView1 = ViewBindings.findChildViewById(rootView, id);
      if (textView1 == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.textViewN;
      TextView textViewN = ViewBindings.findChildViewById(rootView, id);
      if (textViewN == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, TextPassword,
          TextTextEmailAddress, buttonAcessar, imageView, textView1, textView2, textView3,
          textView5, textView6, textViewN);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
