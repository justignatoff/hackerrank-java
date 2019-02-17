package Introduction;

import java.util.*;
import java.util.stream.Collectors;
/*
 * Create the Student and Priorities classes here.
 *
 *
 */

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student student) {
        return Comparator.comparingDouble(Student::getCgpa).reversed()
                .thenComparing(Student::getName)
                .thenComparing(Student::getId)
                .compare(this, student);
    }
}

class Priorities {
    List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> students = new PriorityQueue<>();
        for (String s : events) {
            String[] parts = s.split(" ");
            if ("ENTER".equals(parts[0])) {
                Student student = new Student(
                        Integer.parseInt(parts[3]),
                        parts[1],
                        Double.parseDouble(parts[2]));
                students.add(student);
            } else {
                students.poll();
            }
        }

        return students.stream().sorted().collect(Collectors.toList());
    }
}

public class JavaPrioritiesQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}