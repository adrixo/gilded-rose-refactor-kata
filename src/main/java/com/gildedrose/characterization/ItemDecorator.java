package com.gildedrose.characterization;

public class ItemDecorator extends Item {
    public ItemDecorator(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    void updateQuality() {
        if (name.equals("Sulfuras, Hand of Ragnaros")){
            return;
        } else if (name.equals("Aged Brie")) {
            increaseQuality();
            if (sellIn < 0) {
                increaseQuality();
            }
        } else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (sellIn < 0) {
                dropQualityToZero();
                return;
            }

            increaseQuality();

            if (sellIn < 10) {
                increaseQuality();
            }

            if (sellIn < 5) {
                increaseQuality();
            }
        } else {
            decreaseQuality();
            if (sellIn < 0) {
                decreaseQuality();
            }
        }
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
        if (quality<=0)
            return;
        quality--;
    }

    void increaseQuality() {
        if (quality >= 50)
            return;
        quality++;
    }
}
