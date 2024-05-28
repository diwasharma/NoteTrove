package com.example.thenotesapp.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.example.thenotesapp.model.NOTE;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class editnotefragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private editnotefragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private editnotefragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings({
      "unchecked",
      "deprecation"
  })
  public static editnotefragmentArgs fromBundle(@NonNull Bundle bundle) {
    editnotefragmentArgs __result = new editnotefragmentArgs();
    bundle.setClassLoader(editnotefragmentArgs.class.getClassLoader());
    if (bundle.containsKey("Note")) {
      NOTE Note;
      if (Parcelable.class.isAssignableFrom(NOTE.class) || Serializable.class.isAssignableFrom(NOTE.class)) {
        Note = (NOTE) bundle.get("Note");
      } else {
        throw new UnsupportedOperationException(NOTE.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("Note", Note);
    } else {
      throw new IllegalArgumentException("Required argument \"Note\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static editnotefragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    editnotefragmentArgs __result = new editnotefragmentArgs();
    if (savedStateHandle.contains("Note")) {
      NOTE Note;
      Note = savedStateHandle.get("Note");
      __result.arguments.put("Note", Note);
    } else {
      throw new IllegalArgumentException("Required argument \"Note\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public NOTE getNote() {
    return (NOTE) arguments.get("Note");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("Note")) {
      NOTE Note = (NOTE) arguments.get("Note");
      if (Parcelable.class.isAssignableFrom(NOTE.class) || Note == null) {
        __result.putParcelable("Note", Parcelable.class.cast(Note));
      } else if (Serializable.class.isAssignableFrom(NOTE.class)) {
        __result.putSerializable("Note", Serializable.class.cast(Note));
      } else {
        throw new UnsupportedOperationException(NOTE.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("Note")) {
      NOTE Note = (NOTE) arguments.get("Note");
      if (Parcelable.class.isAssignableFrom(NOTE.class) || Note == null) {
        __result.set("Note", Parcelable.class.cast(Note));
      } else if (Serializable.class.isAssignableFrom(NOTE.class)) {
        __result.set("Note", Serializable.class.cast(Note));
      } else {
        throw new UnsupportedOperationException(NOTE.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    editnotefragmentArgs that = (editnotefragmentArgs) object;
    if (arguments.containsKey("Note") != that.arguments.containsKey("Note")) {
      return false;
    }
    if (getNote() != null ? !getNote().equals(that.getNote()) : that.getNote() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getNote() != null ? getNote().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "editnotefragmentArgs{"
        + "Note=" + getNote()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull editnotefragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@Nullable NOTE Note) {
      this.arguments.put("Note", Note);
    }

    @NonNull
    public editnotefragmentArgs build() {
      editnotefragmentArgs result = new editnotefragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setNote(@Nullable NOTE Note) {
      this.arguments.put("Note", Note);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public NOTE getNote() {
      return (NOTE) arguments.get("Note");
    }
  }
}
