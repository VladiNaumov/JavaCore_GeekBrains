package com.naumDeveloper.javaCore2.unit_8.SingleLinkingList;

public interface GBIterator {

    //итерация (Iterator) - это проход одного элемента
    //проверка следующего элемента на наличие в коллекции
    //например в нашей коллекции три элемента то итератор говорит есть ли в коллекции следующий элемен
    boolean hasNext();

    //возвращает текущий элемент из коллекции
      String next();
}
