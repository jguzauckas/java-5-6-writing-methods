# You Do

In the `Student.java` file, can you add an `equals` method?

The `equals` method should `return` a value of the type `boolean`, can be `public`, and should have a `Person` object as a parameter. It will compare the `Person` object being called with the `Person` object in the parameter and determine if the two students are the same (AKA equal).

Two students are considered equal if their `firstName` and `lastName` are equal, and their `gradeLevel` is equal. If any of these things are not `true`, then the students are not equal and the result should be `false`.

When done correctly, the `TestStudentEquals.java` file should have no errors and produce the following output when run:

```
true
false
false
```