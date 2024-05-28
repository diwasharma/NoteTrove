package com.example.thenotesapp.database;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.thenotesapp.model.NOTE;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class noteDao_Impl implements noteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<NOTE> __insertionAdapterOfNOTE;

  private final EntityDeletionOrUpdateAdapter<NOTE> __deletionAdapterOfNOTE;

  private final EntityDeletionOrUpdateAdapter<NOTE> __updateAdapterOfNOTE;

  public noteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNOTE = new EntityInsertionAdapter<NOTE>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `notes` (`id`,`noteTitle`,`noteDesc`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NOTE entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getNoteTitle());
        statement.bindString(3, entity.getNoteDesc());
      }
    };
    this.__deletionAdapterOfNOTE = new EntityDeletionOrUpdateAdapter<NOTE>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `notes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NOTE entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfNOTE = new EntityDeletionOrUpdateAdapter<NOTE>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `notes` SET `id` = ?,`noteTitle` = ?,`noteDesc` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NOTE entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getNoteTitle());
        statement.bindString(3, entity.getNoteDesc());
        statement.bindLong(4, entity.getId());
      }
    };
  }

  @Override
  public Object insertNote(final NOTE note, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNOTE.insert(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteNote(final NOTE note, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfNOTE.handle(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateNote(final NOTE note, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfNOTE.handle(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<NOTE>> getAllNotes() {
    final String _sql = "SELECT * FROM NOTES ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"NOTES"}, false, new Callable<List<NOTE>>() {
      @Override
      @Nullable
      public List<NOTE> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNoteTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "noteTitle");
          final int _cursorIndexOfNoteDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "noteDesc");
          final List<NOTE> _result = new ArrayList<NOTE>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final NOTE _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNoteTitle;
            _tmpNoteTitle = _cursor.getString(_cursorIndexOfNoteTitle);
            final String _tmpNoteDesc;
            _tmpNoteDesc = _cursor.getString(_cursorIndexOfNoteDesc);
            _item = new NOTE(_tmpId,_tmpNoteTitle,_tmpNoteDesc);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<NOTE>> searchNote(final String query) {
    final String _sql = "SELECT * FROM NOTES WHERE noteTitle LIKE ? OR noteDesc LIKE ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"NOTES"}, false, new Callable<List<NOTE>>() {
      @Override
      @Nullable
      public List<NOTE> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNoteTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "noteTitle");
          final int _cursorIndexOfNoteDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "noteDesc");
          final List<NOTE> _result = new ArrayList<NOTE>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final NOTE _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNoteTitle;
            _tmpNoteTitle = _cursor.getString(_cursorIndexOfNoteTitle);
            final String _tmpNoteDesc;
            _tmpNoteDesc = _cursor.getString(_cursorIndexOfNoteDesc);
            _item = new NOTE(_tmpId,_tmpNoteTitle,_tmpNoteDesc);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
