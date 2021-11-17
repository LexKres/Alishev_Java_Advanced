package Adv_ArrayList;

// разбираемся с Java Collection Framework   (Добавил Джошуа Блох)
// https://ru.wikipedia.org/wiki/Java_Collections_Framework

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://habr.com/ru/post/237043/
// альтернативой этой коллекции являются
// Google Guava
// Commons Collections  (от Apache)
/*
    интерфейс java.util.Collection , который наледуется от интерфейса java.lang.Iterable
    методы add() и remove()
    метод toArray() возвращает массив, состоящий тз элементов данной коллекции
    метод contains() проверяет, содержится ли данный элемент в коллекции

    В JCF списки реализуются через интерфейс java.util.List,
    которой имплементируют два класса:
    java.util.ArrayList - список на основе массива
    java.util.LinkedList - двусвязный список

    В JCF множства реализуются через интерфейс java.util.Set
    Множество не может содержать двух одинаковых элементов и не устанавливает порядок
    Множество имплементируют
    java.util.HashSet
    java.util.LinkedHashSet
    java.util.TreeSet
 */
public class Adv_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        // ArrayList<int> =   SH  ха-ха, а так нельзя!  Т.е. ArrayList создается на объектах, а не на простых типах

        // с Java 7 можно писать сокращеннее
        // ArrayList<Integer> arrayList = new ArrayList<>();

        // Еще, конвенция предлагает использовать при создании класса ArrayList ссылку не на ArrayList, а на
        // интерфейс List, который он реализует:
        // List<Integer> arrayList = new ArrayList<>()

        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList);

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(7));

        System.out.println(arrayList.size());

        for (Integer x : arrayList)
            System.out.println(x);

        // еще один способ пройтись по элементам ArrayList - это лямбда-функции, но об этом не здесь, а там, где
        // про лямбда-функции

        // еще один метод для работы с ArrayList
        //удаляет 6-ой элемент
        arrayList.remove(5);   // но метод remove() не очень эффективный при удалении элемента с середины или где-то в начала
        // все элементы справа потом переностся влево
        /*
            [0,1,2,3,4]
            удалем 2
            [0,1, ,3,4]
            потом правые элементы переносятся влево
            [0,1,3, ,4]
            [0,1,3,4]    и массив сокращается
         */
        System.out.println(arrayList);


        // если наш arrayList создавался как
        // List<Integer> arrayList = new ArrayList<>()
        // то тогда, например, когда нам надо провести много удалений из него, то
        List<Integer> list = new LinkedList<>();
        // переносим объекты из arrayList в list
        // и удаляем.... (SH  пример конечно гениальный....  :-)  )



    }
}



//  https://javarush.ru/groups/posts/klass-arraylist
/*
И раз уж вспомнили о Arrays: в Java можно легко “переключаться” между массивом и ArrayList, то есть преобразовывать одно к другому. В классе Arrays для этого есть метод Arrays.asList(). С его помощью мы получаем содержимое массива в виде списка и передаем его в конструктор нашего ArrayList:

public static void main(String[] args) {

   Cat thomas = new Cat("Томас");
   Cat behemoth = new Cat("Бегемот");
   Cat philipp = new Cat("Филипп Маркович");
   Cat pushok = new Cat("Пушок");

   Cat[] catsArray = {thomas, behemoth, philipp, pushok};

   ArrayList<Cat> catsList = new ArrayList<>(Arrays.asList(catsArray));
   System.out.println(catsList);
}


Вывод:

[Cat{name='Томас'}, Cat{name='Бегемот'}, Cat{name='Филипп Маркович'}, Cat{name='Пушок'}]


Можно сделать и наоборот — получить массив из объекта ArrayList. Для этого используется метод toArray():

public static void main(String[] args) {

   ArrayList<Cat> cats = new ArrayList<>();

   Cat thomas = new Cat("Томас");
   Cat behemoth = new Cat("Бегемот");
   Cat philipp = new Cat("Филипп Маркович");
   Cat pushok = new Cat("Пушок");

   cats.add(thomas);
   cats.add(behemoth);
   cats.add(philipp);
   cats.add(pushok);

   Cat[] catsArray = cats.toArray(new Cat[0]);

   System.out.println(Arrays.toString(catsArray));
}


Обрати внимание: в метод toArray() мы передали пустой массив. Это не ошибка. Внутри класса ArrayList данный метод реализован таким образом, что передача пустого массива увеличивает его производительность. Пока просто запомни это на будущее (но передать какой-то конкретный размер тоже можно, будет работать).
 */