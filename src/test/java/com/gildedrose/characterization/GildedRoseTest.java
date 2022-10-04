package com.gildedrose.characterization;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test void
    reduce_non_passed_item_quality_once_each_day() {
        String itemName = "A item";
        ItemDecorator[] items = new ItemDecorator[] { new ItemDecorator(itemName, 3, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].toString()).isEqualTo(itemName+", 2, 2");
    }

    @Test public void
    reduce_passed_item_quality_twice_each_day() {
        String itemName = "A item";
        ItemDecorator[] items = new ItemDecorator[] { new ItemDecorator(itemName, -1, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].toString()).isEqualTo(itemName+", -2, 1");
    }

    @ParameterizedTest
    @CsvSource({
            "3, 0, '2, 0'",
            "-1, 0, '-2, 0'",
            "-1, 1, '-2, 0'",
    })
    public void
    avoid_to_reduce_quality_below_zero(int sellIn, int quality, String expected) {
        String itemName = "A item";
        ItemDecorator[] items = new ItemDecorator[] { new ItemDecorator(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].toString()).isEqualTo(itemName+", " + expected);
    }

    @Test public void
    increase_aged_brie_quality_over_time() {
        String itemName = "Aged Brie";
        ItemDecorator[] items = new ItemDecorator[] { new ItemDecorator(itemName, 3, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].toString()).isEqualTo(itemName+", 2, 4");
    }

    @Test public void
    increase_passed_aged_brie_quality_over_time_twice() {
        String itemName = "Aged Brie";
        ItemDecorator[] items = new ItemDecorator[] { new ItemDecorator(itemName, -1, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].toString()).isEqualTo(itemName+", -2, 5");
    }

    @ParameterizedTest
    @CsvSource({
            "3, 50, '2, 50'",
            "-1, 50, '-2, 50'",
            "-1, 49, '-2, 50'",
    })
    public void
    avoid_increase_quality_over_50(int sellIn, int quality, String expected) {
        String itemName = "Aged Brie";
        ItemDecorator[] items = new ItemDecorator[] { new ItemDecorator(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].toString()).isEqualTo(itemName+", " + expected);
    }

    @ParameterizedTest
    @CsvSource({
            "12, 3, '11, 4'",
            "11, 3, '10, 4'",
    })
    public void
    increase_backstage_passes_normally_when_are_10_days_or_more(int sellIn, int quality, String expected) {
        String itemName = "Backstage passes to a TAFKAL80ETC concert";
        ItemDecorator[] items = new ItemDecorator[]{new ItemDecorator(itemName, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].toString()).isEqualTo(itemName + ", " + expected);
    }


    @ParameterizedTest
    @CsvSource({
            "10, 3, '9, 5'",
            "6, 3, '5, 5'",
    })
    public void
    increase_backstage_passes_twice_when_are_10_days_or_less(int sellIn, int quality, String expected) {
        String itemName = "Backstage passes to a TAFKAL80ETC concert";
        ItemDecorator[] items = new ItemDecorator[] { new ItemDecorator(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].toString()).isEqualTo(itemName+", " + expected);
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, '4, 6'",
            "1, 3, '0, 6'",
    })
    public void
    increase_backstage_passes_trice_when_are_5_days_or_less(int sellIn, int quality, String expected) {
        String itemName = "Backstage passes to a TAFKAL80ETC concert";
        ItemDecorator[] items = new ItemDecorator[] { new ItemDecorator(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].toString()).isEqualTo(itemName+", " + expected);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 3, '-1, 0'",
            "-1, 3, '-2, 0'",
    })
    public void
    decrease_to_zero_backstage_once_sellIn_passes(int sellIn, int quality, String expected) {
        String itemName = "Backstage passes to a TAFKAL80ETC concert";
        ItemDecorator[] items = new ItemDecorator[] { new ItemDecorator(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].toString()).isEqualTo(itemName+", " + expected);
    }


    @Test
    public void
    maintain_sulfuras_legendary_item_sellIn_and_quality() {
        String itemName = "Sulfuras, Hand of Ragnaros";
        ItemDecorator[] items = new ItemDecorator[] { new ItemDecorator(itemName, 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].toString()).isEqualTo(itemName+", 0, 80");
    }
}
