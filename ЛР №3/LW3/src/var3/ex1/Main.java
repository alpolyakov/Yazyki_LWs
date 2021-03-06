package var3.ex1;

//Создать объект класса Сутки, используя классы Час, Минута.
//Методы: вывести на консоль текущее время, рассчитать время суток (утро, день, вечер, ночь).


class Minute {
    private int intMin;
    private String strMin;

    //Empty constructor
    public Minute () {
        this.intMin = 0;
        this.strMin = "0";
    }

    //Creates Word from given String and extends charLength of word on number of chars in String
    public Minute (int intMin) {
        this.intMin = intMin;
        this.strMin = String.valueOf(intMin);
    }

    //Getter for body of Word
    public int getBody() {
        return intMin;
    }

    public String getBodyStr() {
        return strMin;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Minute min = (Minute) obj;
        if (intMin == min.intMin%60) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        int result = intMin;
        return result;
    }

    @Override
    public String toString() {
        if (intMin < 60 && intMin >= 0) return strMin + " мин";
        else if (intMin > 0) return String.valueOf(intMin%60) + " мин";
        else return "Отрицательное число мин";
    }
}

class Hour {
    private int intHour;
    //private Minute intMin;
    private String strHour;

    //Empty constructor
    public Hour () {
        this.intHour = 0;
        //this.intMin = new Minute(0);
        this.strHour = "0";
    }

    //Creates Word from given String and extends charLength of word on number of chars in String
    public Hour (int intHour) {
        this.intHour = intHour;
        //this.intMin = intMin;
        this.strHour = String.valueOf(intHour);
    }

    //Getter for body of Word
    public int getBody() {
        return intHour;
    }

    public String getBodyStr() {
        return strHour;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Hour hour = (Hour) obj;
        if (intHour == hour.intHour%24) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        int result = intHour*60;
        return result;
    }

    @Override
    public String toString() {
        if (intHour < 24 && intHour >= 0) return strHour + " час";
        else if (intHour > 0) return String.valueOf(intHour%24) + " час";
        else return "Отрицательное число час";
    }
}

class Day {
    private Minute m;
    private Hour h;
    private int rh;

    //Empty constructor
    public Day () {
        this.h = new Hour(0);
        this.m = new Minute(0);
        this.rh = 0;
    }

    public Day (Hour h, Minute m) {
        this.h = h;
        this.m = m;
        this.rh = (h.getBody() + m.getBody()/60)%24;
    }

    //Getters
    public Hour getHour() {
        return new Hour(rh);
    }

    public Minute getMinute() {
        return m;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Day day = (Day) obj;
        if (h.equals(day.h) && m.equals(day.m) && h.getBody() == day.h.getBody() && m.getBody() == day.m.getBody()) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        int result = h.getBody()*60 + m.getBody();
        return result;
    }

    @Override
    public String toString() {
        int rm = m.getBody()%60;
        String mins = String.valueOf(rm);
        if (rm / 10 == 0 || rm == 0) mins = "0" + mins;
        String hours = String.valueOf(rh);
        if (m.getBody() < 0 || h.getBody() < 0) return "Введены Отрицательные Значенияя!!!!1";
        else return "Время: " + hours + " : " + mins;
    }

    public String getTime() {
        return this.toString();
    }

    public String dayTime() {
        if (rh >= 23 || rh < 5) return "Ночь";
        else if (rh >= 5 && rh < 11) return "Утро";
        else if (rh >= 11 && rh < 17) return "День";
        else return "Вечер";
    }

}

public class Main {
    public static void main(String[] args) {
        Minute min = new Minute(62);
        Hour hour = new Hour(18);
        Day day = new Day(hour, min);
        System.out.println(day.getTime());
        System.out.println(day.dayTime());
    }
}
