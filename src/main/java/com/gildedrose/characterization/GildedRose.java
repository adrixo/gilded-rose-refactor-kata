package com.gildedrose.characterization;

import com.gildedrose.characterization.item.BasicItemDecorator;

class GildedRose {
    BasicItemDecorator[] items;

    public GildedRose(BasicItemDecorator[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (BasicItemDecorator item : items) {
            item.reduceSellIn();
            item.updateQuality();
        }
    }
}