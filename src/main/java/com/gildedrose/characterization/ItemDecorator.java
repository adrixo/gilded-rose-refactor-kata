package com.gildedrose.characterization;

public class ItemDecorator extends Item {
    public ItemDecorator(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    void reduceSellIn() {
        if (name.equals("Sulfuras, Hand of Ragnaros"))
            return;
        sellIn--;
    }

    void dropQualityToZero() {
        quality = 0;
    }

    void decreaseQuality() {
        if (name.equals("Sulfuras, Hand of Ragnaros"))
            return;
        if (quality<=0)
            return;
        quality--;
    }

    void increaseQuality() {
        if (name.equals("Sulfuras, Hand of Ragnaros"))
            return;
        if (quality >= 50)
            return;
        quality++;
    }
}
