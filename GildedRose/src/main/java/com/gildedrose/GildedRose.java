package com.gildedrose;

class GildedRose {
	public static final String AGED_BRIE = "Aged Brie";
	public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			switch (item.name) {
				case AGED_BRIE:
					handleBrie(item);
					break;
				case BACKSTAGE:
					handleBackstage(item);
					break;
				case SULFURAS:
					break;
				default:
					handleDefault(item);
					break;
			}
		}
	}

	private void handleBrie(Item item) {
		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}

		item.sellIn = item.sellIn - 1;

		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}
	}

	private void handleBackstage(Item item) {
		if (item.quality < 50) {
			item.quality = item.quality + 1;

			if (item.sellIn < 11) {
				item.quality = item.quality + 1;
			}

			if (item.sellIn < 6) {
				item.quality = item.quality + 1;
			}
		}

		item.sellIn = item.sellIn - 1;

		if (item.sellIn < 0) {
			item.quality = 0;
		}
	}

	private void handleDefault(Item item) {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}

		item.sellIn = item.sellIn - 1;

		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}
	}
}
