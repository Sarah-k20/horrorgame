package com.example.horrorgame;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Item, Integer> items = new HashMap<>();
    private double poidsMax = 50.0;

    public boolean ajouter(Item item, int quantite) {
        double nouveauPoids = getPoidsTotal() + item.getPoids() * quantite;

        if (nouveauPoids > poidsMax) {
            return false;
        }

        if (item.estEmpilable()) {
            items.put(item, items.getOrDefault(item, 0) + quantite);
        } else {
            for (int i = 0; i < quantite; i++) {
                items.put(item, items.getOrDefault(item, 0) + 1);
            }
        }
        return true;
    }

    public boolean retirer(Item item, int quantite) {
        if (!items.containsKey(item)) return false;
        int actuelle = items.get(item);
        if (quantite >= actuelle) {
            items.remove(item);
        } else {
            items.put(item, actuelle - quantite);
        }
        return true;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public double getPoidsTotal() {
        double total = 0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPoids() * entry.getValue();
        }
        return total;
    }

    public double getPoidsMax() {
        return poidsMax;
    }
}