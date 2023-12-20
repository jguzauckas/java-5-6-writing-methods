public class NotesPrivate1 {
    public static void main(String[] args) {
        Person person1 = new Person("Mr. G", 25);
        Person person2 = new Person("Sam", 34);
        System.out.println(person1);
        System.out.println(person2);
        System.out.println();

        person1.copyName(person2);

        System.out.println(person1);
        System.out.println(person2);
    }
}
