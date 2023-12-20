public class TestStudent {
    public static void main(String[] args) {
        Student student1 = new Student("John", "Guzauckas", 123456, 18);

        System.out.println(student1.gradeNextYear());
        student1.sayFullName();
    }
}
