package var1.ex2;

/******************************************************************************
 Выполнить задания на основе варианта 1 лабораторной работы 4, контролируя состояние потоков ввода/вывода.
 При возникновении ошибок, связанных с корректностью выполнения математических операций, генерировать и обрабатывать исключительные ситуации.
 Предусмотреть обработку исключений, возникающих при нехватке памяти, отсутствии требуемой записи (объекта) в файле, недопустимом значении поля и т.д.

 Создать класс Cinema (кино) с внутренним классом, с помощью объектов которого можно хранить информацию об адресах кинотеатров, фильмах и времени сеансов.
 *******************************************************************************/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static public void main(String[]args){
        Cinema c = new Cinema();
        c.printSeanses();
    }
}

class Cinema {

    List<Info> seanses = new ArrayList<>();

    public Cinema() {
        seanses.add(new Info("Октябрь", "Железный человек", "25 янв 19:00"));
        seanses.add(new Info("Октябрь", "Джокер", "25 янв 21:30"));
        seanses.add(new Info("КАРО", "1408", "26 янв 00:00"));
        seanses.add(new Info("КАРО", "Ке (2018)", "26 янв 03:00"));
    }

    public void printSeanses() {
        for (Info seanse : seanses) {

            seanse.print();
        }
    }

    public class Info {
        public String k,f,t;

        public Info(String k, String f, String t) {
            try {
                setK(k);
            } catch(Exception e) {
                System.out.println(e.getMessage());
                try {
                    setK("-");
                } catch(Exception ex) {
                }
            }

            try {
                setF(f);
            } catch(Exception e) {
                System.out.println(e.getMessage());
                try {
                    setF("-");
                } catch(Exception ex) {
                }
            }
            setT(t);
        }

        public String getK() {
            return k;
        }
        public void setK(String k) throws Exception{
            List theCinemas = new ArrayList();
            theCinemas.add("Октябрь");
            theCinemas.add("КАРО");
            theCinemas.add("СинемаСтар");
            theCinemas.add("Люксор");
            theCinemas.add("Синематик");
            theCinemas.add("-");
            if (theCinemas.contains(k))
                this.k=k;
            else throw new Exception("Кинотеатра '" + k + "' нет в списке\n");
        }

        public String getF() {
            return f;
        }
        public void setF(String f) throws Exception{
            List theFilms = new ArrayList();
            theFilms.add("Железный человек");
            theFilms.add("Джокер");
            theFilms.add("1408");
            theFilms.add("Игра");
            theFilms.add("Союз спасения");
            theFilms.add("-");
            if (theFilms.contains(f))
                this.f=f;
            else throw new Exception("Фильма '" + f + "' нет в списке прокате\n");
        }

        public String getT(){
            return t;
        }
        public void setT(String t){
            this.t=t;
        }

        public void print(){

            System.out.print("Кинотеатр: "+getK()+"\nФильм: "+getF()+"\nДата и Время сеанса: "+getT()+"\n___________________\n");

        }
    }
}
