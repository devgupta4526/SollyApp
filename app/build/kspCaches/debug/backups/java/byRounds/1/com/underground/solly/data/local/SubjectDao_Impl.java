package com.underground.solly.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.EntityUpsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.underground.solly.domain.model.Subject;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Float;
import java.lang.Integer;
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
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class SubjectDao_Impl implements SubjectDao {
  private final RoomDatabase __db;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSubject;

  private final EntityUpsertionAdapter<Subject> __upsertionAdapterOfSubject;

  private final ColorListConverter __colorListConverter = new ColorListConverter();

  public SubjectDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__preparedStmtOfDeleteSubject = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Subject WHERE subjectId = ?";
        return _query;
      }
    };
    this.__upsertionAdapterOfSubject = new EntityUpsertionAdapter<Subject>(new EntityInsertionAdapter<Subject>(__db) {
      @Override
      public String createQuery() {
        return "INSERT INTO `Subject` (`name`,`goalHours`,`colors`,`subjectId`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Subject value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        stmt.bindDouble(2, value.getGoalHours());
        final String _tmp = __colorListConverter.fromColorList(value.getColors());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
        if (value.getSubjectId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getSubjectId());
        }
      }
    }, new EntityDeletionOrUpdateAdapter<Subject>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE `Subject` SET `name` = ?,`goalHours` = ?,`colors` = ?,`subjectId` = ? WHERE `subjectId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Subject value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        stmt.bindDouble(2, value.getGoalHours());
        final String _tmp = __colorListConverter.fromColorList(value.getColors());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
        if (value.getSubjectId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getSubjectId());
        }
        if (value.getSubjectId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getSubjectId());
        }
      }
    });
  }

  @Override
  public Object deleteSubject(final int subjectId, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSubject.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, subjectId);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteSubject.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object upsertSubject(final Subject subject,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfSubject.upsert(subject);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<Integer> getTotalSubjectCount() {
    final String _sql = "SELECT COUNT(*) FROM SUBJECT";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"SUBJECT"}, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final int _tmp;
            _tmp = _cursor.getInt(0);
            _result = _tmp;
          } else {
            _result = 0;
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
  public Flow<Float> getTotalGoalHours() {
    final String _sql = "SELECT SUM(goalHours) FROM SUBJECT";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"SUBJECT"}, new Callable<Float>() {
      @Override
      public Float call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Float _result;
          if(_cursor.moveToFirst()) {
            final float _tmp;
            _tmp = _cursor.getFloat(0);
            _result = _tmp;
          } else {
            _result = 0f;
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
  public Object getSubjectById(final int subjectId,
      final Continuation<? super Subject> continuation) {
    final String _sql = "SELECT * FROM Subject WHERE subjectId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, subjectId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Subject>() {
      @Override
      public Subject call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfGoalHours = CursorUtil.getColumnIndexOrThrow(_cursor, "goalHours");
          final int _cursorIndexOfColors = CursorUtil.getColumnIndexOrThrow(_cursor, "colors");
          final int _cursorIndexOfSubjectId = CursorUtil.getColumnIndexOrThrow(_cursor, "subjectId");
          final Subject _result;
          if(_cursor.moveToFirst()) {
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final float _tmpGoalHours;
            _tmpGoalHours = _cursor.getFloat(_cursorIndexOfGoalHours);
            final List<Integer> _tmpColors;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfColors)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfColors);
            }
            _tmpColors = __colorListConverter.toColorList(_tmp);
            final Integer _tmpSubjectId;
            if (_cursor.isNull(_cursorIndexOfSubjectId)) {
              _tmpSubjectId = null;
            } else {
              _tmpSubjectId = _cursor.getInt(_cursorIndexOfSubjectId);
            }
            _result = new Subject(_tmpName,_tmpGoalHours,_tmpColors,_tmpSubjectId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<Subject>> getAllSubjects() {
    final String _sql = "SELECT * FROM Subject";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"Subject"}, new Callable<List<Subject>>() {
      @Override
      public List<Subject> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfGoalHours = CursorUtil.getColumnIndexOrThrow(_cursor, "goalHours");
          final int _cursorIndexOfColors = CursorUtil.getColumnIndexOrThrow(_cursor, "colors");
          final int _cursorIndexOfSubjectId = CursorUtil.getColumnIndexOrThrow(_cursor, "subjectId");
          final List<Subject> _result = new ArrayList<Subject>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Subject _item;
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final float _tmpGoalHours;
            _tmpGoalHours = _cursor.getFloat(_cursorIndexOfGoalHours);
            final List<Integer> _tmpColors;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfColors)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfColors);
            }
            _tmpColors = __colorListConverter.toColorList(_tmp);
            final Integer _tmpSubjectId;
            if (_cursor.isNull(_cursorIndexOfSubjectId)) {
              _tmpSubjectId = null;
            } else {
              _tmpSubjectId = _cursor.getInt(_cursorIndexOfSubjectId);
            }
            _item = new Subject(_tmpName,_tmpGoalHours,_tmpColors,_tmpSubjectId);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
