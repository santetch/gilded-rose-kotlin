package com.gildedrose.items

import com.gildedrose.GildedRoseKata
import com.gildedrose.Item
import com.gildedrose.doubles.ItemBuilder
import org.junit.Assert.*
import org.junit.Test

class CommonItemShould {
    private lateinit var commonItem: Item
    private lateinit var gildedRose: GildedRoseKata

    @Test
    fun `decrease sell in when update gilded`() {
        commonItem = ItemBuilder()
                .withSellIn(2)
                .build()

        givenAGildedRose()

        whenUpdateQuality(commonItem)

        thenDecreaseSellIn()
    }

    @Test
    fun `decrease quality in 1 when sell in greater than 0`() {
        commonItem = ItemBuilder()
                .withSellIn(2)
                .withQuality(2)
                .build()

        givenAGildedRose()

        whenUpdateQuality(commonItem)

        thenDecreaseQualityInOne()
    }

    @Test
    fun `not decrease quality in 1 when sell in greater than 0 and quality is 0`() {
        commonItem = ItemBuilder()
                .withSellIn(2)
                .withQuality(0)
                .build()

        givenAGildedRose()

        whenUpdateQuality(commonItem)

        thenQualityDoesNotChange()
    }

    @Test
    fun `decrease quality in 2 when sell in lower than 0`() {
        commonItem = ItemBuilder()
                .withSellIn(0)
                .withQuality(2)
                .build()

        givenAGildedRose()

        whenUpdateQuality(commonItem)

        thenDecreaseQualityInTwo()
    }

    @Test
    fun `not decrease quality in 2 when sell in lower than 0 and quality is 0`() {
        commonItem = ItemBuilder()
                .withSellIn(0)
                .withQuality(0)
                .build()

        givenAGildedRose()

        whenUpdateQuality(commonItem)

        thenQualityDoesNotChange()
    }

    private fun thenDecreaseQualityInTwo() {
        assertEquals(0, commonItem.quality)
    }

    private fun thenQualityDoesNotChange() {
        assertEquals(0, commonItem.quality)
    }

    private fun givenAGildedRose() {
        gildedRose = GildedRoseKata()
    }

    private fun whenUpdateQuality(commonItem: Item) {
        gildedRose.updateQuality(arrayOf(commonItem))
    }

    private fun thenDecreaseSellIn() {
        assertEquals(1, commonItem.sellIn)
    }

    private fun thenDecreaseQualityInOne() {
        assertEquals(1, commonItem.quality)
    }
}
