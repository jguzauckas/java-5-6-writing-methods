- non-void with parameters - computes and returns'
- pass by value
    - primitive types are copies
    - objects are aliases
- Only accessing private data of objects of the enclosing class
    - Good practice to not modify mutable objects

# Writing Methods

In order to write methods to accomplish different tasks, there are a lot of minor interactions we need to understand. These minor interactions can have major impacts on programs when not acknowledged, and so are important for us to go through.

---

## Pass by Value

In Unit 5 Section 2, we discussed the idea of **pass by value**, which is a rule Java follows when it uses parameters. When you call a method (or constructor) that has parameters, you provide information for those parameters in the form of values. Java is careful in how it handles this, and it makes copies of these values that you provide to fill in its parameter variables with to try and protect the original information.

To demonstrate the interactions, I have created the `TempMethods` class in the `TempMethods.java` file. Here is one example from the `TempMethods.java` file:

```java
public void modifyInt(int i) {
    i += 1;
    System.out.println(i);
}
```

When we read this method, it is `void`, so it will not `return` any information. Instead, it takes an `int` parameter nicknamed `i`, increments its value by `1`, and then prints out the value. The behavior of this `print` statement is pretty straight-forward: if `i` was `5` originally, it would print out `6`, or if `i` was `15`, it would print out `16`. The interaction we have to be worried about though, is whether this would change the value we used when we called this method. Here is an example from the `NotesPass1.java` file:

```java
TempMethods temp = new TempMethods();
int number = 5;

temp.modifyInt(number);

System.out.println(number); // What will this produce?
```

Here, we make an object out of our class to be able to use it, and we make a variable called `number` to store our sample value in. We know from reading the method above that the call `temp.modifyInt(number)` will initialize `i` with the value `number` has, which is `5`, and so ultimately prints out `6`. The question though, is if the value of `number` was also incremented by `1` in this process. The answer is no, it did not, since `i` is the primitive type `int`, as shown in the output:

```
6
5
```

In Unit 1, when we introduced variables and the primitive types, we made a special point about how primitive types are stored. The value is stored directly in the variable. This means that when Java copies the *value* for a parameter, it copies the data itself. So it made a copy of the value `5` in this example to work with, leaving the original `5` stored in `number` untouched. This interaction is consistent for primitive data type parameters: they will never be able to modify the original because the value was copied.

This copy behavior takes on another form when we discuss objects though. Objects are not stored directly in their variables: instead, their memory location is stored in the variable. This means that if we copy the value of an object from a variable, we will copy its location. This means that the original variable and our new parameter will both point to the same memory location: the original object, making them **aliases** of each other. This means changes made by either one will affect the other!

Here is another method from `TempMethods.java` that will put this to the test:

```java

```









# Mutator Methods

In Unit 5 Section 1, we discussed how both class and instance variables are almost always kept `private` to maintain the security of the values. In Unit 5 Section 4 we dove into the world of **accessor methods** to give the user a way of accessing information. Importantly though, we hadn't given them a way to modify these variables, which is where **mutator methods** come into play. This section dives into what mutator methods are and do.

---

## Method Information

Since mutator methods are **methods**, we need to generally understand methods in order to understand mutator methods. Here is a general header for a method that helps us to see the components:

```java
public/private type methodName(parameter1type parameter1, parameter2type parameter2, etc.) {
    // Not shown.
}
```

In this header, we have a few components, which we can break down:
- `public/private` --> Each method can be assigned either `public` or `private` (never both), indicating how accessible it is. Mutator methods will always be `public`.
- `type` --> This is where we designate **`return` type**, essentially preemptively stating what kind of information the method is going to send back when it is done, if any. This can be any of our data types like `int`, `double`, `boolean`, or `String`, or it can send no information back, in which case we write the keyword `void` in that spot. Mutator methods will have no `return` type for the most part, since they change the value, not get the value like accessor methods did. Due to this, we will be using the keyword `void` instead of a type.
- `methodName` --> This is the nickname to refer to this method by (like `substring`). The general rule for mutator methods, since they **set** information, is to call them `setVariableName`, so if the variable was `age`, we would call it `setAge`.
- `(parameter1type parameter1, parameter2type parameter2, etc.)` --> Inside the parentheses, we have the **parameter list**. This is how a user sends information for the method to use (kind of like when you send a starting and ending index for `substring`). You are essentially declaring variables for this, so each needs a data type and a nickname to be referred to as, and would be separated by commas. You can have zero, one, or many parameters, as many as you need. Since mutator methods are trying to update a variable's value, we will use the parameter list to have the user give us a value. This means we will need a parameter that shares the same type as the variable we are working on (if we want to modify an `int` variable, we would need to have our parameter be an `int`).

---

## Basic Mutator Methods

By definition, a mutator method changes the values of instance variables or class variables. Here is an example of a mutator method from the `Person.java` file:

```java
public void setName(String n) {
    name = n;
}

```

This mutator method is working on the `name` instance variable in our `Person` class. It takes in a `String` value as a parameter and gives is the nickname `n`, so when we are inside the method, we can set our instance variable `name` to whatever value `n` represents with `name = n`. This is the simplest kind of mutator method, as it just takes the new value and replaces the old one.

Here are a few examples of using this mutator from the `NotesMutator1.java` file, where we use the accessor `getName` to print out `name` and watch what happens to it:

```java
Person person1 = new Person("Mr. G", 25);
System.out.println(person1.getName());

person1.setName("John");
System.out.println(person1.getName());

person1.setName("Guzauckas");
System.out.println(person1.getName());
```

This prints out each `name` over time, producing the following output:

```
Mr. G
John
Guzauckas
```

---

## Restrictive Mutator Methods

Sometimes though, we should be more restrictive. Names can be anything, but can an age be any number? Negative numbers wouldn't make sense for an age, and neither would numbers that are too large (the oldest living person ever verified was 122 years old). So we can say that age should be limited between 0 and 125, inclusive, to be safe. A good mutator method for `age` then, would check the value it is being provided to decide if it is appropriate to save to the variable, and skip over saving the information if it is not. Here is an example of the mutator for `age` from the `Person.java` file:

```java
public void setAge(int a) {
    if (a >= 0 && a <= 125) {
        age = a;
    }
}
```

The `if` statement is set up using the user input parameter `a` to check if it is appropriate (is it both greater than or equal to 0 and less than or equal to 125). If it meets those criteria, it sets the variable. Otherwise, it just doesn't, and the old value is maintained. This is a silent process!

We can see this in action from the `NotesMutator2.java` file, where we use the accessor `getAge` to print out `age` and watch what happens to it:

```java
Person person1 = new Person("Mr. G", 25);
System.out.println(person1.getAge());

person1.setAge(26);
System.out.println(person1.getAge());

person1.setAge(-5);
System.out.println(person1.getAge());

person1.setAge(130);
System.out.println(person1.getAge());

person1.setAge(25);
System.out.println(person1.getAge());
```

Here, we can expect the `age` to change from `25` to `26`, but then fail to change to `-5` and `130` (and therefore will continue to print the most recent age of `26`), and then finally get changed back to `25`:

```
25
26
26
26
25
```

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
