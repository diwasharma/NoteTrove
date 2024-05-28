package com.example.thenotesapp.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.notesroompractice.R;

public class editnotefragmentDirections {
  private editnotefragmentDirections() {
  }

  @NonNull
  public static NavDirections actionEditNoteFragmentToHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_editNoteFragment_to_homeFragment);
  }
}
