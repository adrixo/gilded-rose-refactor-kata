package com.gildedrose.characterization;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = decreaseQuality(item);
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = increaseQuality(item);

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = increaseQuality(item);
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = increaseQuality(item);
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = reduceSellIn(item);
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = decreaseQuality(item);
                            }
                        }
                    } else {
                        item.quality = dropQualityToZero();
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = increaseQuality(item);
                    }
                }
            }
        }
    }

    private static int reduceSellIn(Item item) {
        return item.sellIn - 1;
    }

    private int dropQualityToZero() {
        return 0;
    }

    private static int decreaseQuality(Item item) {
        return item.quality - 1;
    }

    private static int increaseQuality(Item item) {
        return item.quality + 1;
    }
}