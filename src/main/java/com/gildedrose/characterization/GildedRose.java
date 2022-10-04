package com.gildedrose.characterization;

class GildedRose {
    ItemDecorator[] items;

    public GildedRose(ItemDecorator[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (ItemDecorator item : items) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.reduceSellIn();
            }

            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.decreaseQuality();
                }
            } else {
                item.increaseQuality();

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 10) {
                        item.increaseQuality();
                    }

                    if (item.sellIn < 5) {
                        item.increaseQuality();
                    }
                }
            }


            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.decreaseQuality();
                        }
                    } else {
                        item.dropQualityToZero();
                    }
                } else {
                    item.increaseQuality();
                }
            }
        }
    }
}