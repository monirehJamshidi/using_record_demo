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
- record قراره در آینده جایگزین ساختار Entity شود.
-  یا می تواند جایگزین DTO ها هم شود ( معادل یک سطر دیتابیس است)
-  record یک چیزی بین constructor کلاس و خود ساختار کلاس است.

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
## ✨ توضیحات
- نکات
-  را همه جا می شود تعریف کرد که در مثال بالا record یک موجودیت standalone تعریف شده
- اما record را میتوانیم به صورت embeded  داخل یک کلاس یا داخل یک متد تعریف کنیم که فقط همان متد یا همان کلاس به آن دسترسی داشته باشد

public class Main {
public static void main(String[] args) {

        record Person(String name, String family){}

        Person person = new Person("Monireh", "Jamshidi");
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

## 📌 امکانات اضافه
- می‌توان متد یا constructor اضافی هم تعریف کرد:

public record Rectangle(int width, int height) {
public int area() {
return width * height;
}

    // canonical constructor
    public Rectangle {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Invalid size");
        }
    }
}

## 📌 محدودیت ها
1. فیلدها همیشه final هستند.
2. نمی‌شود به طور معمول setter تعریف کرد.
3. record ها final هستند و نمی‌توان از آن‌ها ارث‌بری کرد.

## 🎯 فواید استفاده از record در جاوا
## 1. کد کمتر (Boilerplate Reduction)

وقتی یک کلاس داده‌ای (Data Class) می‌نویسی، معمولاً باید کلی کد تکراری بزنی:

- فیلدها (private final ...)

- Constructor

- Getterها

- متدهای equals(), hashCode(), toString()

با record همه اینا به صورت خودکار ساخته میشه.

👉 یعنی فقط با یک خط می‌تونی همون کاری رو بکنی که قبلاً با ده‌ها خط می‌کردی.

## 2. Immutable بودن
تمام فیلدهای record به صورت final هستند → یعنی بعد از ساخت شیء، داده‌ها تغییر نمی‌کنن.
این باعث میشه:
- امنیت بیشتر در کدنویسی همزمان (Thread safety)
- جلوگیری از باگ‌های تغییر ناخواسته

## 3. مناسب برای DTO و Value Object
خیلی جاها نیاز داری فقط داده رو از جایی به جایی منتقل کنی (مثل REST API DTO یا Value Object در DDD) → record دقیقاً برای همین ساخته شده.

## 4. پشتیبانی کامل از ویژگی‌های کلاس
با اینکه record ساده‌ست، ولی هنوز می‌تونی:
- متد اضافه کنی
- Constructor سفارشی بذاری (برای Validation)
- Interface پیاده‌سازی کنی


## 👉 خلاصه
record برای DTOها (Data Transfer Objects)، Value Objects و هر جایی که فقط نیاز به نگه‌داشتن داده بدون منطق پیچیده باشد عالی است.