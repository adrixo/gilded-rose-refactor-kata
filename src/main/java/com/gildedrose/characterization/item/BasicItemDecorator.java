package com.gildedrose.characterization.item;

public class BasicItemDecorator extends Item {

    public final Item superItem;

    public BasicItemDecorator(Item item) {
        super(item.name, item.sellIn, item.quality);
        this.superItem = item;
    }

    public BasicItemDecorator(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.superItem = new Item(name, sellIn, quality);
    }

    public void updateQuality() {
        switch(superItem.name) {
            case "Sulfuras, Hand of Ragnaros":
                // Never degradates properties
                decreaseQuality();
                break;
            case "Aged Brie":
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (superItem.sellIn < 0) {
                    // Extreme degradation with threshold
                    dropQualityToZero();
                    return;
                }
                // Aged properties with threshold
                increaseQuality();

                if (superItem.sellIn < 10) {
                    // Aged properties with threshold
                    increaseQuality();
                }

                if (superItem.sellIn < 5) {
                    // Aged properties with threshold
                    increaseQuality();
                }
                break;
            default:
                if (superItem.sellIn < 0) {
                    // degradation property with threshold
                    decreaseQuality();
                }
        }
    }

    public void reduceSellIn() {
        if (superItem.name.equals("Sulfuras, Hand of Ragnaros"))
            // Never pass properties
            return;
        // Time pass properties
        superItem.sellIn--;
    }

    public int getSellIn() {
        return superItem.sellIn;
    }

    public int getQuality() {
        return superItem.quality;
    }

    void dropQualityToZero() {
        superItem.quality = 0;
    }

    void decreaseQuality() {
        if (superItem.quality<=0)
            return;
        superItem.quality--;
    }

    void increaseQuality() {
        if (superItem.quality >= 50)
            return;
        superItem.quality++;
    }

    public String toString() {
        return superItem.toString();
    }
}
