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
import com.underground.solly.domain.model.Task;
import java.lang.Class;
import java.lang.Exception;
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
public final class TaskDao_Impl implements TaskDao {
  private final RoomDatabase __db;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTask;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTasksBySubjectId;

  private final EntityUpsertionAdapter<Task> __upsertionAdapterOfTask;

  public TaskDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__preparedStmtOfDeleteTask = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Task WHERE taskId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteTasksBySubjectId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Task WHERE taskSubjectId = ?";
        return _query;
      }
    };
    this.__upsertionAdapterOfTask = new EntityUpsertionAdapter<Task>(new EntityInsertionAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "INSERT INTO `Task` (`title`,`description`,`dueDate`,`priority`,`relatedToSubject`,`isComplete`,`taskSubjectId`,`taskId`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        if (value.getTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescription());
        }
        stmt.bindLong(3, value.getDueDate());
        stmt.bindLong(4, value.getPriority());
        if (value.getRelatedToSubject() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRelatedToSubject());
        }
        final int _tmp = value.isComplete() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        stmt.bindLong(7, value.getTaskSubjectId());
        if (value.getTaskId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getTaskId());
        }
      }
    }, new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE `Task` SET `title` = ?,`description` = ?,`dueDate` = ?,`priority` = ?,`relatedToSubject` = ?,`isComplete` = ?,`taskSubjectId` = ?,`taskId` = ? WHERE `taskId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        if (value.getTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescription());
        }
        stmt.bindLong(3, value.getDueDate());
        stmt.bindLong(4, value.getPriority());
        if (value.getRelatedToSubject() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRelatedToSubject());
        }
        final int _tmp = value.isComplete() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        stmt.bindLong(7, value.getTaskSubjectId());
        if (value.getTaskId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getTaskId());
        }
        if (value.getTaskId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getTaskId());
        }
      }
    });
  }

  @Override
  public Object deleteTask(final int taskId, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTask.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, taskId);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteTask.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteTasksBySubjectId(final int subjectId,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTasksBySubjectId.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, subjectId);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteTasksBySubjectId.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object upsertTask(final Task task, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfTask.upsert(task);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getTaskById(final int taskId, final Continuation<? super Task> continuation) {
    final String _sql = "SELECT * FROM Task WHERE taskId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, taskId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Task>() {
      @Override
      public Task call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfRelatedToSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "relatedToSubject");
          final int _cursorIndexOfIsComplete = CursorUtil.getColumnIndexOrThrow(_cursor, "isComplete");
          final int _cursorIndexOfTaskSubjectId = CursorUtil.getColumnIndexOrThrow(_cursor, "taskSubjectId");
          final int _cursorIndexOfTaskId = CursorUtil.getColumnIndexOrThrow(_cursor, "taskId");
          final Task _result;
          if(_cursor.moveToFirst()) {
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final int _tmpPriority;
            _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            final String _tmpRelatedToSubject;
            if (_cursor.isNull(_cursorIndexOfRelatedToSubject)) {
              _tmpRelatedToSubject = null;
            } else {
              _tmpRelatedToSubject = _cursor.getString(_cursorIndexOfRelatedToSubject);
            }
            final boolean _tmpIsComplete;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsComplete);
            _tmpIsComplete = _tmp != 0;
            final int _tmpTaskSubjectId;
            _tmpTaskSubjectId = _cursor.getInt(_cursorIndexOfTaskSubjectId);
            final Integer _tmpTaskId;
            if (_cursor.isNull(_cursorIndexOfTaskId)) {
              _tmpTaskId = null;
            } else {
              _tmpTaskId = _cursor.getInt(_cursorIndexOfTaskId);
            }
            _result = new Task(_tmpTitle,_tmpDescription,_tmpDueDate,_tmpPriority,_tmpRelatedToSubject,_tmpIsComplete,_tmpTaskSubjectId,_tmpTaskId);
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
  public Flow<List<Task>> getTasksForSubject(final int subjectId) {
    final String _sql = "SELECT * FROM Task WHERE taskSubjectId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, subjectId);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"Task"}, new Callable<List<Task>>() {
      @Override
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfRelatedToSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "relatedToSubject");
          final int _cursorIndexOfIsComplete = CursorUtil.getColumnIndexOrThrow(_cursor, "isComplete");
          final int _cursorIndexOfTaskSubjectId = CursorUtil.getColumnIndexOrThrow(_cursor, "taskSubjectId");
          final int _cursorIndexOfTaskId = CursorUtil.getColumnIndexOrThrow(_cursor, "taskId");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Task _item;
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final int _tmpPriority;
            _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            final String _tmpRelatedToSubject;
            if (_cursor.isNull(_cursorIndexOfRelatedToSubject)) {
              _tmpRelatedToSubject = null;
            } else {
              _tmpRelatedToSubject = _cursor.getString(_cursorIndexOfRelatedToSubject);
            }
            final boolean _tmpIsComplete;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsComplete);
            _tmpIsComplete = _tmp != 0;
            final int _tmpTaskSubjectId;
            _tmpTaskSubjectId = _cursor.getInt(_cursorIndexOfTaskSubjectId);
            final Integer _tmpTaskId;
            if (_cursor.isNull(_cursorIndexOfTaskId)) {
              _tmpTaskId = null;
            } else {
              _tmpTaskId = _cursor.getInt(_cursorIndexOfTaskId);
            }
            _item = new Task(_tmpTitle,_tmpDescription,_tmpDueDate,_tmpPriority,_tmpRelatedToSubject,_tmpIsComplete,_tmpTaskSubjectId,_tmpTaskId);
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
  public Flow<List<Task>> getAllTasks() {
    final String _sql = "SELECT * FROM Task";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"Task"}, new Callable<List<Task>>() {
      @Override
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfRelatedToSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "relatedToSubject");
          final int _cursorIndexOfIsComplete = CursorUtil.getColumnIndexOrThrow(_cursor, "isComplete");
          final int _cursorIndexOfTaskSubjectId = CursorUtil.getColumnIndexOrThrow(_cursor, "taskSubjectId");
          final int _cursorIndexOfTaskId = CursorUtil.getColumnIndexOrThrow(_cursor, "taskId");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Task _item;
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final int _tmpPriority;
            _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            final String _tmpRelatedToSubject;
            if (_cursor.isNull(_cursorIndexOfRelatedToSubject)) {
              _tmpRelatedToSubject = null;
            } else {
              _tmpRelatedToSubject = _cursor.getString(_cursorIndexOfRelatedToSubject);
            }
            final boolean _tmpIsComplete;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsComplete);
            _tmpIsComplete = _tmp != 0;
            final int _tmpTaskSubjectId;
            _tmpTaskSubjectId = _cursor.getInt(_cursorIndexOfTaskSubjectId);
            final Integer _tmpTaskId;
            if (_cursor.isNull(_cursorIndexOfTaskId)) {
              _tmpTaskId = null;
            } else {
              _tmpTaskId = _cursor.getInt(_cursorIndexOfTaskId);
            }
            _item = new Task(_tmpTitle,_tmpDescription,_tmpDueDate,_tmpPriority,_tmpRelatedToSubject,_tmpIsComplete,_tmpTaskSubjectId,_tmpTaskId);
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
