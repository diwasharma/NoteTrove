package com.example.thenotesapp.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.notesroompractice.R;

public class addnotefragmentDirections {
  private addnotefragmentDirections() {
  }

  @NonNull
  public static NavDirections actionAddNoteFragmentToHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_addNoteFragment_to_homeFragment);
  }
}
