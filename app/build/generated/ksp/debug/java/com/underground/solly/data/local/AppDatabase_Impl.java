package com.underground.solly.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile SubjectDao _subjectDao;

  private volatile TaskDao _taskDao;

  private volatile SessionDao _sessionDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Subject` (`name` TEXT NOT NULL, `goalHours` REAL NOT NULL, `colors` TEXT NOT NULL, `subjectId` INTEGER PRIMARY KEY AUTOINCREMENT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Session` (`relatedToSubject` TEXT NOT NULL, `date` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `sessionSubjectId` INTEGER NOT NULL, `sessionId` INTEGER PRIMARY KEY AUTOINCREMENT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Task` (`title` TEXT NOT NULL, `description` TEXT NOT NULL, `dueDate` INTEGER NOT NULL, `priority` INTEGER NOT NULL, `relatedToSubject` TEXT NOT NULL, `isComplete` INTEGER NOT NULL, `taskSubjectId` INTEGER NOT NULL, `taskId` INTEGER PRIMARY KEY AUTOINCREMENT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '87ec37274ea9fdb3ca40ae52ccd46a71')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Subject`");
        _db.execSQL("DROP TABLE IF EXISTS `Session`");
        _db.execSQL("DROP TABLE IF EXISTS `Task`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsSubject = new HashMap<String, TableInfo.Column>(4);
        _columnsSubject.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubject.put("goalHours", new TableInfo.Column("goalHours", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubject.put("colors", new TableInfo.Column("colors", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubject.put("subjectId", new TableInfo.Column("subjectId", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSubject = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSubject = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSubject = new TableInfo("Subject", _columnsSubject, _foreignKeysSubject, _indicesSubject);
        final TableInfo _existingSubject = TableInfo.read(_db, "Subject");
        if (! _infoSubject.equals(_existingSubject)) {
          return new RoomOpenHelper.ValidationResult(false, "Subject(com.underground.solly.domain.model.Subject).\n"
                  + " Expected:\n" + _infoSubject + "\n"
                  + " Found:\n" + _existingSubject);
        }
        final HashMap<String, TableInfo.Column> _columnsSession = new HashMap<String, TableInfo.Column>(5);
        _columnsSession.put("relatedToSubject", new TableInfo.Column("relatedToSubject", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSession.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSession.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSession.put("sessionSubjectId", new TableInfo.Column("sessionSubjectId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSession.put("sessionId", new TableInfo.Column("sessionId", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSession = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSession = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSession = new TableInfo("Session", _columnsSession, _foreignKeysSession, _indicesSession);
        final TableInfo _existingSession = TableInfo.read(_db, "Session");
        if (! _infoSession.equals(_existingSession)) {
          return new RoomOpenHelper.ValidationResult(false, "Session(com.underground.solly.domain.model.Session).\n"
                  + " Expected:\n" + _infoSession + "\n"
                  + " Found:\n" + _existingSession);
        }
        final HashMap<String, TableInfo.Column> _columnsTask = new HashMap<String, TableInfo.Column>(8);
        _columnsTask.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("dueDate", new TableInfo.Column("dueDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("priority", new TableInfo.Column("priority", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("relatedToSubject", new TableInfo.Column("relatedToSubject", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("isComplete", new TableInfo.Column("isComplete", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("taskSubjectId", new TableInfo.Column("taskSubjectId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("taskId", new TableInfo.Column("taskId", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTask = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTask = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTask = new TableInfo("Task", _columnsTask, _foreignKeysTask, _indicesTask);
        final TableInfo _existingTask = TableInfo.read(_db, "Task");
        if (! _infoTask.equals(_existingTask)) {
          return new RoomOpenHelper.ValidationResult(false, "Task(com.underground.solly.domain.model.Task).\n"
                  + " Expected:\n" + _infoTask + "\n"
                  + " Found:\n" + _existingTask);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "87ec37274ea9fdb3ca40ae52ccd46a71", "08f6a62529a4de91538db5f2f41c65cc");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Subject","Session","Task");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Subject`");
      _db.execSQL("DELETE FROM `Session`");
      _db.execSQL("DELETE FROM `Task`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(SubjectDao.class, SubjectDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TaskDao.class, TaskDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SessionDao.class, SessionDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public SubjectDao subjectDao() {
    if (_subjectDao != null) {
      return _subjectDao;
    } else {
      synchronized(this) {
        if(_subjectDao == null) {
          _subjectDao = new SubjectDao_Impl(this);
        }
        return _subjectDao;
      }
    }
  }

  @Override
  public TaskDao taskDao() {
    if (_taskDao != null) {
      return _taskDao;
    } else {
      synchronized(this) {
        if(_taskDao == null) {
          _taskDao = new TaskDao_Impl(this);
        }
        return _taskDao;
      }
    }
  }

  @Override
  public SessionDao sessionDao() {
    if (_sessionDao != null) {
      return _sessionDao;
    } else {
      synchronized(this) {
        if(_sessionDao == null) {
          _sessionDao = new SessionDao_Impl(this);
        }
        return _sessionDao;
      }
    }
  }
}
