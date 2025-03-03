package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
	@Test
	void quality_decrease() {
        Item[] items = new Item[]{new Item("foo", 0, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

	@Test
	void quality_min() {
		Item[] items = new Item[]{new Item("foo", 0, 0)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0, app.items[0].quality);
	}

	@Test
	void quality_double() {
		Item[] items = new Item[]{new Item("foo", 0, 2)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0, app.items[0].quality);
	}

	@Test
	void aged_brie_quality() {
		Item[] items = new Item[]{new Item("Aged Brie", 0, 49)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(50, app.items[0].quality);
	}

	@Test
	void aged_brie_quality_max() {
		Item[] items = new Item[]{new Item("Aged Brie", 0, 50)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(50, app.items[0].quality);
	}

	@Test
	void aged_brie_quality_double() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

	@Test
	void sulfuras() {
		Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 100, 50)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(50, app.items[0].quality);
		assertEquals(100, app.items[0].sellIn);
	}

	@Test
	void backstage_passes_normal() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
	}

	@Test
	void backstage_passes_10() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(2, app.items[0].quality);
	}

	@Test
	void backstage_passes_5() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(3, app.items[0].quality);
	}

	@Test
	void backstage_passes_0() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0, app.items[0].quality);
	}

	@Test
	void backstage_passes_50() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(50, app.items[0].quality);
	}
}
