package var3.ex2;

//Создать объект класса Простая дробь, используя класс Число.
//Методы: вывод на экран, сложение, вычитание, умножение, деление.

class Numb {
    private int numBody;
    private String strBody;

    //Empty constructor
    public Numb () {
        this.numBody = 0;
        this.strBody = "";
    }

    //Creates Word from given String and extends charLength of word on number of chars in String
    public Numb (int numBody) {
        this.numBody = numBody;
        this.strBody = String.valueOf(numBody);
    }

    //Getter for body of Word
    public int getBody() {
        return numBody;
    }

    public String getBodyStr() {
        return strBody;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Numb number = (Numb) obj;
        if (numBody == number.numBody) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        int result = numBody;
        return result;
    }

    @Override
    public String toString() {
        return strBody;
    }
}

class Fraction {
    private Numb chisl;
    private Numb znam;

    //Empty constructor
    public Fraction () {
        this.chisl = new Numb(0);
        this.znam = new Numb(1);
    }

    //Creates Word from given String and extends charLength of word on number of chars in String
    public Fraction (Numb chisl, Numb znam) {
        this.chisl = chisl;
        this.znam = znam;
    }

    public Numb getChisl() {
        return chisl;
    }

    public Numb getZnam() {
        return znam;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Fraction fraction = (Fraction) obj;
        if (chisl.equals(fraction.chisl) && znam.equals(fraction.znam)) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        int result = chisl.hashCode() * znam.hashCode();
        return result;
    }

    //поиск НОД для упрощения дроби
    public int gcd() {
        int a = Math.abs(chisl.getBody());
        int b = Math.abs(znam.getBody());

        if (a == 0)
            return b;

        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }

        return a;
    }

    //поиск НОК для умножения дробей
    public int lcm(int a, int b) {
        return a / gcd() * b;
    }

    @Override
    public String toString() {
        if (znam.getBody() == 0) {
            if (chisl.getBody() > 0) return "[+ inf]";
            else if (chisl.getBody() < 0) return "[- inf]";
            else return "[0]";
        }
        if (chisl.getBody() == 0) return "[0]";
        else
            return "[" + chisl.getBody()/gcd() + " / " + znam.getBody()/gcd() + "]";
    }

    //Сложение
    public Fraction summ(Fraction fraction) {
        int a = fraction.getChisl().getBody();
        int b = fraction.getZnam().getBody();

        Numb zn = new Numb(lcm(znam.getBody(), b));
        Numb ch = new Numb(chisl.getBody()*b + a*znam.getBody());

        Fraction result = new Fraction(ch, zn);
        return result;
    }

    //Вычитание
    public Fraction dec(Fraction fraction) {
        int a = fraction.getChisl().getBody();
        int b = fraction.getZnam().getBody();

        Numb zn = new Numb(lcm(znam.getBody(), b));
        Numb ch = new Numb(chisl.getBody()*b - a*znam.getBody());

        Fraction result = new Fraction(ch, zn);
        return result;
    }

    //Умножение
    public Fraction mult(Fraction fraction) {
        int a = fraction.getChisl().getBody();
        int b = fraction.getZnam().getBody();

        Numb zn = new Numb(znam.getBody()* b);
        Numb ch = new Numb(chisl.getBody()* a);

        Fraction result = new Fraction(ch, zn);
        return result;
    }

    //Деление
    public Fraction del(Fraction fraction) {
        int a = fraction.getChisl().getBody();
        int b = fraction.getZnam().getBody();

        Numb zn = new Numb(znam.getBody()* a);
        Numb ch = new Numb(chisl.getBody()* b);

        Fraction result = new Fraction(ch, zn);
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Numb number11 = new Numb(-3);
        Numb number12 = new Numb(5);
        Fraction fraction1 = new Fraction(number11, number12);
        System.out.println("Дробь 1: " + fraction1.toString());

        Numb number21 = new Numb(4);
        Numb number22 = new Numb(12);
        Fraction fraction2 = new Fraction(number21, number22);
        System.out.println("Дробь 2: " + fraction2.toString());

        //Сложение дробей
        Fraction summa = fraction1.summ(fraction2);
        System.out.println("Сумма дробей: " + summa.toString());

        //Вычитание дробей
        Fraction decr = fraction1.dec(fraction2);
        System.out.println("Разность дробей: " + decr.toString());

        //Умножение дробей
        Fraction delen = fraction1.del(fraction2);
        System.out.println("Частное дробей: " + delen.toString());
    }
}
