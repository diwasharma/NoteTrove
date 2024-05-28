package com.example.notesroompractice;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.notesroompractice.databinding.ActivityMainBindingImpl;
import com.example.notesroompractice.databinding.FragmentAddnotefragmentBindingImpl;
import com.example.notesroompractice.databinding.FragmentEditnotefragmentBindingImpl;
import com.example.notesroompractice.databinding.FragmentHomefragmentBindingImpl;
import com.example.notesroompractice.databinding.NoteLayoutBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_FRAGMENTADDNOTEFRAGMENT = 2;

  private static final int LAYOUT_FRAGMENTEDITNOTEFRAGMENT = 3;

  private static final int LAYOUT_FRAGMENTHOMEFRAGMENT = 4;

  private static final int LAYOUT_NOTELAYOUT = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.notesroompractice.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.notesroompractice.R.layout.fragment_addnotefragment, LAYOUT_FRAGMENTADDNOTEFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.notesroompractice.R.layout.fragment_editnotefragment, LAYOUT_FRAGMENTEDITNOTEFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.notesroompractice.R.layout.fragment_homefragment, LAYOUT_FRAGMENTHOMEFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.notesroompractice.R.layout.note_layout, LAYOUT_NOTELAYOUT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTADDNOTEFRAGMENT: {
          if ("layout/fragment_addnotefragment_0".equals(tag)) {
            return new FragmentAddnotefragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_addnotefragment is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTEDITNOTEFRAGMENT: {
          if ("layout/fragment_editnotefragment_0".equals(tag)) {
            return new FragmentEditnotefragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_editnotefragment is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOMEFRAGMENT: {
          if ("layout/fragment_homefragment_0".equals(tag)) {
            return new FragmentHomefragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_homefragment is invalid. Received: " + tag);
        }
        case  LAYOUT_NOTELAYOUT: {
          if ("layout/note_layout_0".equals(tag)) {
            return new NoteLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for note_layout is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/activity_main_0", com.example.notesroompractice.R.layout.activity_main);
      sKeys.put("layout/fragment_addnotefragment_0", com.example.notesroompractice.R.layout.fragment_addnotefragment);
      sKeys.put("layout/fragment_editnotefragment_0", com.example.notesroompractice.R.layout.fragment_editnotefragment);
      sKeys.put("layout/fragment_homefragment_0", com.example.notesroompractice.R.layout.fragment_homefragment);
      sKeys.put("layout/note_layout_0", com.example.notesroompractice.R.layout.note_layout);
    }
  }
}
