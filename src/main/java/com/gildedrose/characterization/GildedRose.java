package com.gildedrose.characterization;

class GildedRose {
    ItemDecorator[] items;

    public GildedRose(ItemDecorator[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (ItemDecorator item : items) {
            item.reduceSellIn();

            if (item.name.equals("Aged Brie")) {
                item.increaseQuality();
                if (item.sellIn < 0) {
                    item.increaseQuality();
                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn < 0) {
                    item.dropQualityToZero();
                    continue;
                }

                item.increaseQuality();

                if (item.sellIn < 10) {
                    item.increaseQuality();
                }

                if (item.sellIn < 5) {
                    item.increaseQuality();
                }
            } else {
                item.decreaseQuality();
                if (item.sellIn < 0) {
                    item.decreaseQuality();
                }
            }


        }
    }
}