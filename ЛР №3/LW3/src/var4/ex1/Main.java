package var4.ex1;

//Система Конструкторское бюро. Заказчик представляет Техническое Задание (ТЗ) на проектирование многоэтажного Дома.
//Конструктор регистрирует ТЗ, определяет стоимость проектирования и строительства, выставляет Заказчику Счет
//за проектирование и создает Бригаду Конструкторов для выполнения Проекта.

//класс Бригадир, рабочий
class Brigada {
    private double price;  //Стоимость сотрудника
    private int n;      //Число бригадиров

    public Brigada(double price, int n) {
        this.price = price;
        this.n = n;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getN() {
        return n;
    }

    public void setN(double price) {
        this.n = n;
    }

    public double getCost() {
        return n*price;
    }
}

//класс Дом = ТЗ на дом
class House {
    int etaz;    //этажи
    int meters;  //кв. м. этажа

    public House(int etaz, int meters) {
        this.etaz = etaz;
        this.meters = meters;
    }

    public int getEtaz() {
        return etaz;
    }

    public void setEtaz(int etaz) {
        this.etaz = etaz;
    }

    public int getMeter() {
        return meters;
    }

    public void setMeter(int meters) {
        this.meters = meters;
    }

    //расчет метража
    public int getHouseMetrage() {
        return etaz*meters;
    }
}

//класс Заказчик
class Client {
    double money;    //цена за кв. м.
    House house;     //ТЗ

    public Client(double money, House house) {
        this.money = money;
        this.house = house;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}

//класс Конструктор
class Consructor {
    Client client;
    Brigada brig;
    double coef = 0.5; // коэффициент оплаты рабочих

    public Consructor(Client client) {
        this.client = client;
        this.brig = new Brigada(client.money * coef, 5);
    }

    public Client getClient() {
        return client;
    }

    public Brigada getBrigada() {
        return brig;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double countCost() {
        return client.house.getHouseMetrage()*client.getMoney() + brig.getCost();
    }

    public String countCostString() {
        double price1 = client.house.getHouseMetrage()*client.getMoney();
        double price2 = brig.getCost();
        return "Цена дома: " + price1 + "$. Цена работ: " + price2 + "$";
    }
}

public class Main {
    public static void main(String[] args) {
        House house = new House(1, 100);                //Формирование ТЗ
        Client client = new Client(3000, house);        //Утверждение суммы выплаты за кв.м.
        Consructor constr = new Consructor(client);     //Расчёт стоимости работ
        System.out.println(constr.countCostString());   //Отчет
    }
}
