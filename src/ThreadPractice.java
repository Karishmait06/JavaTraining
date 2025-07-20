

class MyThread extends Thread{
  public void run () {
      int i = 0;
      while(i < 5) {
      try {
          Thread.sleep(200);
      } catch (Exception e) {
          System.out.println("e: " +e);
      }
          System.out.println("Good Morning and hello");
          i++;
      }
  }
}

class MyThread2 extends Thread{
  public void run() {
      int i = 0;
      while(i < 5) {
          try {
              Thread.sleep(500);
          } catch (Exception e) {
              System.out.println("e: " +e);
          }
          System.out.println("Welcome to the Java Threads");
          i++;
      }
  }
}

public class ThreadPractice {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread2 t2 = new MyThread2();
        t1.setPriority(1);
        t2.setPriority(8);
        t1.start();
        try {
            t1.join();
        } catch (Exception e){
            System.out.println("Error in waiting : " +e);
        }
        t2.start();
        System.out.println("Thread 1 Name : " +t1.getName());
        System.out.println("Thread 2 Name : " +t1.getName());
        System.out.println("Thread 1 Priority : " +t1.getPriority());
        System.out.println("Thread 2 Priority : " +t2.getPriority());
        System.out.println("State : " +Thread.currentThread().getState());
        System.out.println("Current Thread : " +Thread.currentThread());
    }
}
