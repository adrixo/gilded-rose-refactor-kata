package com.gildedrose.characterization;

import com.gildedrose.characterization.GildedRose;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test void
    reduce_non_passed_item_quality_once_each_day() {
        String itemName = "A item";
        Item[] items = new Item[] { new Item(itemName, 3, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].toString()).isEqualTo(itemName+", 2, 2");
    }

}
