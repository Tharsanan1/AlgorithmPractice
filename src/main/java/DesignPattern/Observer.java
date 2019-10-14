package DesignPattern;

import java.util.ArrayList;

public interface Observer {
  void notifyMe();
}

interface Subject<T extends State> {
  void notifyAllObservers();

  T getState();

  void setState(T state);

  void addObserver(Observer observer);
}

interface State {
  String getStringRep();
}

abstract class AbstractObserver<T extends State> implements Observer {
  Subject subject;

  public abstract void notifyMe();
}

class ObserverImpl extends AbstractObserver<State> {

  public ObserverImpl(Subject subject) {
    this.subject = subject;
    subject.addObserver(this);
  }

  @Override
  public void notifyMe() {
    State state = subject.getState();
    System.out.println("notified at : " + state.getStringRep());
  }
}

class SubjectImpl<T extends State> implements Subject {
  T state;
  ArrayList<Observer> observerList;

  public SubjectImpl(T state) {
    this.state = state;
    observerList = new ArrayList<>();
  }

  public static void main(String[] args) {
    SubjectImpl<State> subject = new SubjectImpl<>(null);
    ObserverImpl observer = new ObserverImpl(subject);
    subject.setState(new State() {
      @Override
      public String getStringRep() {
        return Long.toString(System.currentTimeMillis());
      }
    });
  }

  @Override
  public void addObserver(Observer observer) {
    observerList.add(observer);
  }

  @Override
  public T getState() {
    return state;
  }

  @Override
  public void setState(State state) {

  }

  @Override
  public void notifyAllObservers() {
    for (Observer o : observerList) {
      o.notifyMe();
    }
  }
}
