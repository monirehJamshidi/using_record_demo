# Java Record Demo


[🇬🇧 English](./README.md) | [🇩🇪 Deutsch](./README.de.md)

این پروژه یک نمونه‌ی کوچک برای نمایش قابلیت **Record در Java** است.  
ویژگی Record ابتدا در **Java 14** (به صورت پیش‌نمایش) معرفی شد و از **Java 16** به طور رسمی اضافه گردید.

---

## ✨ ویژگی‌ها
- تعریف ساده کلاس‌های داده‌ای
- تولید خودکار:
  - `constructor`
  - متدهای getter
  - `equals()`، `hashCode()`، `toString()`
- فیلدها همیشه **immutable** (نهایی و تغییرناپذیر) هستند
- مناسب برای **DTO**‌ها و **Value Object**‌ها

---

## 📌 مثال

[//]: # (```java)
public record Person(String name, int age) { }

class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ali", 30);

        System.out.println(p1.name()); // Ali
        System.out.println(p1.age());  // 30
        System.out.println(p1);        // Person[name=Ali, age=30]
    }
}

## نکته

public record Person(String name, int age) { }

معادل همین کد در کلاس معمولی تقریباً چنین می‌شد:

public final class Person {
private final String name;
private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String name() { return name; }
    public int age() { return age; }

    @Override
    public boolean equals(Object o) { /*...*/ }

    @Override
    public int hashCode() { /*...*/ }

    @Override
    public String toString() { /*...*/ }
}
