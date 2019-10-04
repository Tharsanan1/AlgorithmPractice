package DesignPattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class ObjectPool<T> {
  private ArrayList<T> availableObjects;
  private ArrayList<T> lockedObjects;
  private int maxObjectCount;
  private int optimumObjectCount;
  public ObjectPool(int max, int optimum){
    availableObjects = new ArrayList<>();
    lockedObjects = new ArrayList<>();
    this.maxObjectCount = max;
    this.optimumObjectCount = optimum;
  }

  public T getObject() throws InterruptedException, SQLException {
    synchronized (this){
      if(availableObjects.size() > 0){
        T objectToAllocate = availableObjects.remove(0);
        lockedObjects.add(objectToAllocate);
        return objectToAllocate;
      }
      else{
        if(lockedObjects.size() == maxObjectCount){
          while (lockedObjects.size() == maxObjectCount){
            this.wait();
          }
          T objectToAllocate = availableObjects.remove(0);
          lockedObjects.add(objectToAllocate);
          return objectToAllocate;
        }
        else{
          T objectToAllocate = create();
          lockedObjects.add(objectToAllocate);
          return objectToAllocate;
        }
      }
    }
  }

  protected void cleanObjects(){
    synchronized (this){
      int size = availableObjects.size();
      if(size > optimumObjectCount){
        for(int i = 0; i < size - optimumObjectCount; i++){
          availableObjects.remove(0);
        }
      }
    }
  }

  public void freeThisObject(T object){
    synchronized (this){
      if(refresh(object) && lockedObjects.remove(object)){
        availableObjects.add(object);
        this.notifyAll();
      }
    }
  }

  abstract boolean refresh(T object);

  abstract T create() throws SQLException;

}

class SqlConnectionPool extends ObjectPool<Connection>{
  private String dsn, usr, pwd;
  public SqlConnectionPool(int max, int optimum, String dsn, String usr, String pwd) {
    super(max, optimum);
    TimerTask timerTask = new TimerTask() {
      @Override
      public void run() {
        cleanObjects();
      }
    };
    Timer timer = new Timer();
    timer.schedule(timerTask, 20000, 20000);
    this.dsn = dsn;
    this.usr = usr;
    this.pwd = pwd;
  }

  @Override
  boolean refresh(Connection object) {
    try {
      object.close();
      return true;
    } catch (SQLException e) {
      return false;
    }
  }

  @Override
  Connection create() throws SQLException {
    return DriverManager.getConnection(dsn, usr, pwd);
  }
}
