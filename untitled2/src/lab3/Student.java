package lab3;

public class Student {
    int labs;
    String subject;

    Student (int labs, String subject) {
        this.labs = labs;
        this.subject = subject;
    }
    
    @Override
    public String toString() {
        return labs + " labs in " + subject + ".";
    }
}

