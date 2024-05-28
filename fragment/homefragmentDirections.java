package com.example.thenotesapp.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.notesroompractice.R;
import com.example.thenotesapp.model.NOTE;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class homefragmentDirections {
  private homefragmentDirections() {
  }

  @NonNull
  public static NavDirections actionHomeFragmentToAddNoteFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_addNoteFragment);
  }

  @NonNull
  public static ActionHomeFragmentToEditNoteFragment actionHomeFragmentToEditNoteFragment(
      @Nullable NOTE Note) {
    return new ActionHomeFragmentToEditNoteFragment(Note);
  }

  public static class ActionHomeFragmentToEditNoteFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionHomeFragmentToEditNoteFragment(@Nullable NOTE Note) {
      this.arguments.put("Note", Note);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionHomeFragmentToEditNoteFragment setNote(@Nullable NOTE Note) {
      this.arguments.put("Note", Note);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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

    @Override
    public int getActionId() {
      return R.id.action_homeFragment_to_editNoteFragment;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public NOTE getNote() {
      return (NOTE) arguments.get("Note");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionHomeFragmentToEditNoteFragment that = (ActionHomeFragmentToEditNoteFragment) object;
      if (arguments.containsKey("Note") != that.arguments.containsKey("Note")) {
        return false;
      }
      if (getNote() != null ? !getNote().equals(that.getNote()) : that.getNote() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getNote() != null ? getNote().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionHomeFragmentToEditNoteFragment(actionId=" + getActionId() + "){"
          + "Note=" + getNote()
          + "}";
    }
  }
}
