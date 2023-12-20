# Basics Check

In the `Teacher.java` file, can you add the `teachesGrade` method?

The `teachesGrade` method should be `public`, returns a `boolean` value, and has an `int` parameter. It checks if the `int` parameter is between the `minGradeLevel` and `maxGradeLevel` for the teacher (inclusive), and returns `true` if it is. If the `int` parameter is too high or too low, it returns `false`.

When done correctly, the `TeacherTest.java` file should have no errors and produce the following output when run:

```
false
true
true
true
true
false
```