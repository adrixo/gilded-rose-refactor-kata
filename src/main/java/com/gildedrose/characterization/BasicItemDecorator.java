package com.gildedrose.characterization;

public class BasicItemDecorator extends Item {

    public final Item item;

    public BasicItemDecorator(Item item) {
        super(item.name, item.sellIn, item.quality);
        this.item = item;
    }

    public BasicItemDecorator(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.item = new Item(name, sellIn, quality);
    }

    void updateQuality() {
        switch(item.name) {
            case "Sulfuras, Hand of Ragnaros":
                // Never degradates properties
                break;
            case "Aged Brie":
                // Aged properties
                increaseQuality();
                if (item.sellIn < 0) {
                    // Aged properties with threshold
                    increaseQuality();
                }
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.sellIn < 0) {
                    // Extreme degradation with threshold
                    dropQualityToZero();
                    return;
                }
                // Aged properties with threshold
                increaseQuality();

                if (item.sellIn < 10) {
                    // Aged properties with threshold
                    increaseQuality();
                }

                if (item.sellIn < 5) {
                    // Aged properties with threshold
                    increaseQuality();
                }
                break;
            default:
                // degradation property
                decreaseQuality();
                if (item.sellIn < 0) {
                    // degradation property with threshold
                    decreaseQuality();
                }
        }
    }

    void reduceSellIn() {
        if (item.name.equals("Sulfuras, Hand of Ragnaros"))
            // Never pass properties
            return;
        // Time pass properties
        item.sellIn--;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    public int getQuality() {
        return item.quality;
    }

    void dropQualityToZero() {
        item.quality = 0;
    }

    void decreaseQuality() {
        if (item.quality<=0)
            return;
        item.quality--;
    }

    void increaseQuality() {
        if (item.quality >= 50)
            return;
        item.quality++;
    }

    public String toString() {
        return item.toString();
    }
}
