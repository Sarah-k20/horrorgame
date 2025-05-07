package com.example.horrorgame;

import java.util.ArrayList;

public class Inventory {
    //atribut
    ArrayList<Item> inv1 = new ArrayList<Item>();
    ArrayList<Item> inv2 = new ArrayList<Item>();

    // methodes

    public Inventory(ArrayList<Item> inv1,ArrayList<Item> inv2){
        super();
        this.inv1 = inv1;
        this.inv2 = inv2;
    }

    public void addItem(ArrayList<Item> inv, Item obj){
        inv.add(obj);
    }
}
