package com.gildedrose.characterization.item;

import com.gildedrose.characterization.threshold.NullThreshold;
import com.gildedrose.characterization.threshold.ThresholdI;

public class ImprovementDecorator extends BasicItemDecorator {

    private final BasicItemDecorator superItem;
    public ThresholdI sellInThreshold = new NullThreshold();
    public ThresholdI qualityThreshold = new NullThreshold();

    public ImprovementDecorator(BasicItemDecorator item) {
        super(item.name, item.sellIn, item.quality);
        this.superItem = item;
    }

    @Override
    public void reduceSellIn() {
        superItem.reduceSellIn();
    }

    @Override
    public void updateQuality() {
        if (qualityThreshold.belongs(superItem.getQuality()))
            superItem.increaseQuality();
        superItem.updateQuality();
    }

    @Override
    public int getSellIn() {
        return superItem.getSellIn();
    }

    @Override
    public int getQuality() {
        return superItem.getSellIn();
    }

    @Override
    public String toString() {
        return superItem.toString();
    }

    @Override
    public void decreaseQuality() {
        superItem.decreaseQuality();
    }

    @Override
    public void increaseQuality() {
        superItem.increaseQuality();
    }
}
