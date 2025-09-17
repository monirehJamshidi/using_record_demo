# Java Record Demo

[🇮🇷 فارسی](./README.fa.md) | [🇩🇪 Deutsch](./README.de.md)

This project is a small demo to show how **Records in Java** work.  
Records were introduced in **Java 14 (preview)** and became a standard feature in **Java 16**.

---

## ✨ Features
- Simple definition of data classes
- Auto-generated:
    - `constructor`
    - getters
    - `equals()`, `hashCode()`, `toString()`
- Fields are **immutable** (always `final`)
- Great for **DTOs** and **Value Objects**

---

## 📌 Example

public record Person(String name, int age) { }

class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ali", 30);

        System.out.println(p1.name()); // Ali
        System.out.println(p1.age());  // 30
        System.out.println(p1);        // Person[name=Ali, age=30]
    }
}


## 🚀 Run
1. Make sure you have Java 16+ installed.
2. Clone the repo:

git clone https://github.com/USERNAME/record-demo.git
cd record-demo

3. Compile and run:


javac Main.java
java Main


## 📚 References
- [Oracle Docs – Records](https://docs.oracle.com/en/java/javase/17/language/records.html)
- [Baeldung – Introduction to Java Records](https://www.baeldung.com/java-record-keyword)