package com.gildedrose.characterization;

public class ItemDecorator extends Item {
    public ItemDecorator(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    void updateQuality() {
        if (name.equals("Sulfuras, Hand of Ragnaros")){
            // Never degradates properties
            return;
        } else if (name.equals("Aged Brie")) {
            // Aged properties
            increaseQuality();
            if (sellIn < 0) {
                // Aged properties with threshold
                increaseQuality();
            }
        } else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (sellIn < 0) {
                // Extreme degradation with threshold
                dropQualityToZero();
                return;
            }
            // Aged properties with threshold
            increaseQuality();

            if (sellIn < 10) {
                // Aged properties with threshold
                increaseQuality();
            }

            if (sellIn < 5) {
                // Aged properties with threshold
                increaseQuality();
            }
        } else {
            // degradation property
            decreaseQuality();
            if (sellIn < 0) {
                // degradation property with threshold
                decreaseQuality();
            }
        }
    }

    void reduceSellIn() {
        if (name.equals("Sulfuras, Hand of Ragnaros"))
            // Never pass properties
            return;
        // Time pass properties
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
