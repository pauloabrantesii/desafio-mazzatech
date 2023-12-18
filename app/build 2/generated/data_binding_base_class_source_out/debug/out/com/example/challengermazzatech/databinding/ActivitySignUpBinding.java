// Generated by view binder compiler. Do not edit!
package com.example.challengermazzatech.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.challengermazzatech.R;
import com.santalu.maskara.widget.MaskEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySignUpBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final EditText Address;

  @NonNull
  public final MaskEditText CPF;

  @NonNull
  public final MaskEditText DATA;

  @NonNull
  public final EditText Sexo;

  @NonNull
  public final EditText TextNome;

  @NonNull
  public final EditText editTextEmail;

  @NonNull
  public final EditText editTextUsername;

  @NonNull
  public final ImageView goback;

  @NonNull
  public final ImageButton imageButton;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final EditText passwordEditText;

  @NonNull
  public final Button signupButton;

  private ActivitySignUpBinding(@NonNull ScrollView rootView, @NonNull EditText Address,
      @NonNull MaskEditText CPF, @NonNull MaskEditText DATA, @NonNull EditText Sexo,
      @NonNull EditText TextNome, @NonNull EditText editTextEmail,
      @NonNull EditText editTextUsername, @NonNull ImageView goback,
      @NonNull ImageButton imageButton, @NonNull ImageView imageView3,
      @NonNull EditText passwordEditText, @NonNull Button signupButton) {
    this.rootView = rootView;
    this.Address = Address;
    this.CPF = CPF;
    this.DATA = DATA;
    this.Sexo = Sexo;
    this.TextNome = TextNome;
    this.editTextEmail = editTextEmail;
    this.editTextUsername = editTextUsername;
    this.goback = goback;
    this.imageButton = imageButton;
    this.imageView3 = imageView3;
    this.passwordEditText = passwordEditText;
    this.signupButton = signupButton;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_sign_up, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySignUpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Address;
      EditText Address = ViewBindings.findChildViewById(rootView, id);
      if (Address == null) {
        break missingId;
      }

      id = R.id.CPF;
      MaskEditText CPF = ViewBindings.findChildViewById(rootView, id);
      if (CPF == null) {
        break missingId;
      }

      id = R.id.DATA;
      MaskEditText DATA = ViewBindings.findChildViewById(rootView, id);
      if (DATA == null) {
        break missingId;
      }

      id = R.id.Sexo;
      EditText Sexo = ViewBindings.findChildViewById(rootView, id);
      if (Sexo == null) {
        break missingId;
      }

      id = R.id.TextNome;
      EditText TextNome = ViewBindings.findChildViewById(rootView, id);
      if (TextNome == null) {
        break missingId;
      }

      id = R.id.editTextEmail;
      EditText editTextEmail = ViewBindings.findChildViewById(rootView, id);
      if (editTextEmail == null) {
        break missingId;
      }

      id = R.id.editTextUsername;
      EditText editTextUsername = ViewBindings.findChildViewById(rootView, id);
      if (editTextUsername == null) {
        break missingId;
      }

      id = R.id.goback;
      ImageView goback = ViewBindings.findChildViewById(rootView, id);
      if (goback == null) {
        break missingId;
      }

      id = R.id.imageButton;
      ImageButton imageButton = ViewBindings.findChildViewById(rootView, id);
      if (imageButton == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.passwordEditText;
      EditText passwordEditText = ViewBindings.findChildViewById(rootView, id);
      if (passwordEditText == null) {
        break missingId;
      }

      id = R.id.signupButton;
      Button signupButton = ViewBindings.findChildViewById(rootView, id);
      if (signupButton == null) {
        break missingId;
      }

      return new ActivitySignUpBinding((ScrollView) rootView, Address, CPF, DATA, Sexo, TextNome,
          editTextEmail, editTextUsername, goback, imageButton, imageView3, passwordEditText,
          signupButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
