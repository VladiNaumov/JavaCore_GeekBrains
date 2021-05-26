package com.naumDeveloper.javaCore3.unit_1.homework.array;

import fi.lahti.unit_1.homework.array.IArray;

import java.util.ArrayList;

public class MyArray implements IArray<ArrayList<Integer>> {
    @Override
    public ArrayList setArrayList(int[] array) {
        return  new ArrayList();
    }
}
