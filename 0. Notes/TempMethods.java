public class TempMethods {
    public TempMethods() {

    }

    public void modifyInt(int i) {
        i += 1;
        System.out.println(i);
    }

    public void modifyString(String s) {
        s += "!";
        System.out.println(s);
    }

    public void modifyPerson(Person p) {
        p.setName("New Name");
        System.out.println(p.getName());
    }

    public int addNumbers(int a, int b) {
        return a + b;
    }
}