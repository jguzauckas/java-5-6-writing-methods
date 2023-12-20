public class TestStudentEquals {
    public static void main(String[] args) {
        Student student1 = new Student("John", "Guzauckas", 123456, 18);
        Student student2 = new Student("John", "Guzauckas", 123456, 12);
        Student student3 = new Student("Sam", "L", 654321, 22);

        System.out.println(student1.equals(student2));
        System.out.println(student2.equals(student3));
        System.out.println(student1.equals(student3));
    }
}
