package com.underground.solly.data.local;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.underground.solly.domain.model.Session;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
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
public final class SessionDao_Impl implements SessionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Session> __insertionAdapterOfSession;

  private final EntityDeletionOrUpdateAdapter<Session> __deletionAdapterOfSession;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSessionsBySubjectId;

  public SessionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSession = new EntityInsertionAdapter<Session>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Session` (`relatedToSubject`,`date`,`duration`,`sessionSubjectId`,`sessionId`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Session value) {
        if (value.getRelatedToSubject() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getRelatedToSubject());
        }
        stmt.bindLong(2, value.getDate());
        stmt.bindLong(3, value.getDuration());
        stmt.bindLong(4, value.getSessionSubjectId());
        if (value.getSessionId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getSessionId());
        }
      }
    };
    this.__deletionAdapterOfSession = new EntityDeletionOrUpdateAdapter<Session>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Session` WHERE `sessionId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Session value) {
        if (value.getSessionId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getSessionId());
        }
      }
    };
    this.__preparedStmtOfDeleteSessionsBySubjectId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Session WHERE sessionSubjectId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertSession(final Session session,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSession.insert(session);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteSession(final Session session,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfSession.handle(session);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public void deleteSessionsBySubjectId(final int subjectId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSessionsBySubjectId.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, subjectId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSessionsBySubjectId.release(_stmt);
    }
  }

  @Override
  public Flow<List<Session>> getAllSessions() {
    final String _sql = "SELECT * FROM Session";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"Session"}, new Callable<List<Session>>() {
      @Override
      public List<Session> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRelatedToSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "relatedToSubject");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfSessionSubjectId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionSubjectId");
          final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
          final List<Session> _result = new ArrayList<Session>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Session _item;
            final String _tmpRelatedToSubject;
            if (_cursor.isNull(_cursorIndexOfRelatedToSubject)) {
              _tmpRelatedToSubject = null;
            } else {
              _tmpRelatedToSubject = _cursor.getString(_cursorIndexOfRelatedToSubject);
            }
            final long _tmpDate;
            _tmpDate = _cursor.getLong(_cursorIndexOfDate);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpSessionSubjectId;
            _tmpSessionSubjectId = _cursor.getInt(_cursorIndexOfSessionSubjectId);
            final Integer _tmpSessionId;
            if (_cursor.isNull(_cursorIndexOfSessionId)) {
              _tmpSessionId = null;
            } else {
              _tmpSessionId = _cursor.getInt(_cursorIndexOfSessionId);
            }
            _item = new Session(_tmpRelatedToSubject,_tmpDate,_tmpDuration,_tmpSessionSubjectId,_tmpSessionId);
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
  public Flow<List<Session>> getRecentSessionsForSubject(final int subjectId) {
    final String _sql = "SELECT * FROM Session WHERE sessionSubjectId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, subjectId);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"Session"}, new Callable<List<Session>>() {
      @Override
      public List<Session> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRelatedToSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "relatedToSubject");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfSessionSubjectId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionSubjectId");
          final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
          final List<Session> _result = new ArrayList<Session>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Session _item;
            final String _tmpRelatedToSubject;
            if (_cursor.isNull(_cursorIndexOfRelatedToSubject)) {
              _tmpRelatedToSubject = null;
            } else {
              _tmpRelatedToSubject = _cursor.getString(_cursorIndexOfRelatedToSubject);
            }
            final long _tmpDate;
            _tmpDate = _cursor.getLong(_cursorIndexOfDate);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpSessionSubjectId;
            _tmpSessionSubjectId = _cursor.getInt(_cursorIndexOfSessionSubjectId);
            final Integer _tmpSessionId;
            if (_cursor.isNull(_cursorIndexOfSessionId)) {
              _tmpSessionId = null;
            } else {
              _tmpSessionId = _cursor.getInt(_cursorIndexOfSessionId);
            }
            _item = new Session(_tmpRelatedToSubject,_tmpDate,_tmpDuration,_tmpSessionSubjectId,_tmpSessionId);
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
  public Flow<Long> getTotalSessionsDuration() {
    final String _sql = "SELECT SUM(duration) FROM Session";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"Session"}, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if(_cursor.moveToFirst()) {
            final long _tmp;
            _tmp = _cursor.getLong(0);
            _result = _tmp;
          } else {
            _result = 0L;
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
  public Flow<Long> getTotalSessionsDurationBySubject(final int subjectId) {
    final String _sql = "SELECT SUM(duration) FROM Session WHERE sessionSubjectId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, subjectId);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"Session"}, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if(_cursor.moveToFirst()) {
            final long _tmp;
            _tmp = _cursor.getLong(0);
            _result = _tmp;
          } else {
            _result = 0L;
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
