package com.gildedrose

class ItemBuilder {

    private var sellIn = 0
    private var quality = 0
    private var name = "some item"

    internal fun withSellIn(sellIn: Int): ItemBuilder {
        this.sellIn = sellIn
        return this
    }

    internal fun withQuality(quality: Int): ItemBuilder {
        this.quality = quality
        return this
    }

    internal fun withName(name: String): ItemBuilder {
        this.name = name
        return this
    }

    internal fun build(): Item {
        return Item(name, sellIn, quality)
    }

    companion object {

        fun anItem(): ItemBuilder {
            return ItemBuilder()
        }
    }
}