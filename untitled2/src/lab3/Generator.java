package lab3;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Generator extends Thread {
    private static final int [] labsCount  = {10, 20, 100};
    private static final String [] subjectName = {"Math", "OOP", "Physics"};
    private final int maxQueue = 10;
    private ConcurrentLinkedQueue<Student> queue = new ConcurrentLinkedQueue<>();

    void setQueue(ConcurrentLinkedQueue<Student> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run () {
        int n1, n2;

        while (true) {
            if (queue.size() < maxQueue) {
                n1 = (int) (Math.random() * labsCount.length);
                n2 = (int) (Math.random() * subjectName.length);
                Student student = new Student(labsCount[n1], subjectName[n2]);
                queue.add(student);
                System.out.println("Student is trying to pass " + student.labs + " labs in " + student.subject + ".");
            }
        }

    }

}
