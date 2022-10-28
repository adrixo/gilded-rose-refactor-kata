package com.gildedrose.characterization.item;

import com.gildedrose.characterization.threshold.Threshold;

public class ItemFactory {
    public static BasicItemDecorator create(String name, int sellIn, int quality) {
        BasicItemDecorator base = new BasicItemDecorator(name, sellIn, quality);

        switch(name) {
            case "Sulfuras, Hand of Ragnaros":
                return new NonDegradable(base);

            case "Aged Brie":
                BasicItemDecorator constantImprove = new ImprovementDecorator(base);
                BasicItemDecorator belowZeroImprove = new ImprovementDecorator(constantImprove);
                ((ImprovementDecorator) belowZeroImprove).qualityThreshold = new Threshold(0, ">");
                return belowZeroImprove;

            case "Backstage passes to a TAFKAL80ETC concert":
                BasicItemDecorator constantImproves = new ImprovementDecorator(base);
                BasicItemDecorator below10Improve = new ImprovementDecorator(constantImproves);
                ((ImprovementDecorator) below10Improve).qualityThreshold = new Threshold(10, ">");
                BasicItemDecorator below5Improve = new ImprovementDecorator(below10Improve);
                ((ImprovementDecorator) below5Improve).qualityThreshold = new Threshold(5, ">");
                BasicItemDecorator extremeDegradation = new ExtremeDegradation(below5Improve);
                ((ExtremeDegradation) extremeDegradation).qualityThreshold = new Threshold(0, ">");
                return extremeDegradation;

            default:
                BasicItemDecorator belowZeroDegradation = new DegradationDecorator(base);
                BasicItemDecorator constantDegradation = new DegradationDecorator(belowZeroDegradation);
                ((DegradationDecorator) belowZeroDegradation).qualityThreshold = new Threshold(0, ">=");
                return constantDegradation;
        }
    }
}
