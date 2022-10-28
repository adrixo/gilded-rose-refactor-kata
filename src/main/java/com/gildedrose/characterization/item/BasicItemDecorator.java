package com.gildedrose.characterization.item;

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

    public void updateQuality() {
    }

    public void reduceSellIn() {
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
