public class TeacherTest {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Mr.", "Guzauckas", "Computer Science", 9, 12);

        System.out.println(teacher1.teachesGrade(8));
        System.out.println(teacher1.teachesGrade(9));
        System.out.println(teacher1.teachesGrade(10));
        System.out.println(teacher1.teachesGrade(11));
        System.out.println(teacher1.teachesGrade(12));
        System.out.println(teacher1.teachesGrade(13));
    }
}
