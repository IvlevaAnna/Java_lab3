package lab3;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.NoSuchElementException;

public class Robot extends Thread {
    private String subjectName;
    ConcurrentLinkedQueue<Student> queue;
    private static Semaphore semaphore = new Semaphore(1, true);
    private boolean isActive = false;

    Robot(String subjectName, ConcurrentLinkedQueue<Student> queue) {
        this.subjectName = subjectName;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {

            try {
                if (isInterrupted() && !queue.isEmpty()) {
                    new Robot(subjectName, queue).start();
                }
                if (!isInterrupted() && !isActive && queue.element().subject.equals(subjectName)) {
                    isActive = true;
                    semaphore.acquire();
                    System.out.println("Robot is checking " + queue.remove().toString());
                    semaphore.release();
                    isActive = false;
                }

            } catch (InterruptedException e){
                e.printStackTrace();
            }
            catch (NoSuchElementException e)
            {
                interrupt();
            }
        }

    }

}


