package com.gildedrose

import com.gildedrose.GildedRose.updateQuality
import junit.framework.Assert.assertEquals
import org.junit.Test

class NormalItemsUpdateQualityTest {

    @Test
    fun items_degrade_quality_each_update() {
        val item = ItemBuilder.anItem().withSellIn(1)
                .withQuality(20)
                .build()

        updateQuality(arrayOf(item))
        assertEquals(item.quality, 19)
    }

    @Test
    fun when_the_sellIn_date_has_passed_items_degrade_quality_twice() {
        val item = ItemBuilder.anItem().withSellIn(0)
                .withQuality(20)
                .build()

        updateQuality(arrayOf(item))
        assertEquals(item.quality, 18)
    }

    @Test
    fun the_quality_of_an_item_is_never_negative() {
        val item = ItemBuilder.anItem().withQuality(0)
                .build()

        updateQuality(arrayOf(item))
        assertEquals(item.quality, 0)
    }
}