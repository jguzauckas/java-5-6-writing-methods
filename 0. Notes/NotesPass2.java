public class NotesPass2 {
    public static void main(String[] args) {
        TempMethods temp = new TempMethods();
        String str = "Hello, World";

        temp.modifyString(str);
        System.out.println(str); // What will this produce?

        Person person1 = new Person("Mr. G", 25);

        temp.modifyPerson(person1);
        System.out.println(person1.getName()); // What will this produce?
    }
}
