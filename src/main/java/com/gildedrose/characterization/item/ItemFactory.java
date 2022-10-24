package com.gildedrose.characterization.item;

import com.gildedrose.characterization.threshold.Threshold;

public class ItemFactory {
    public static BasicItemDecorator create(String name, int sellIn, int quality) {
        BasicItemDecorator base = new BasicItemDecorator(name, sellIn, quality);

        switch(name) {
            case "Sulfuras, Hand of Ragnaros":
                return new NonDegradable(base);
            case "Aged Brie":
                return base;
            case "Backstage passes to a TAFKAL80ETC concert":
                return base;
            default:
                BasicItemDecorator belowZeroDegradation = new DegradationDecorator(base);

                BasicItemDecorator constantDegradation = new DegradationDecorator(belowZeroDegradation);
                ((DegradationDecorator) belowZeroDegradation).qualityThreshold = new Threshold(0, ">=");
                return constantDegradation;
        }
    }
}
