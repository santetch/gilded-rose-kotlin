package com.gildedrose

import com.gildedrose.GildedRose.updateQuality
import junit.framework.Assert.assertEquals
import org.junit.Test

class SulfurasUpdateQualityTest {

    @Test
    fun never_has_to_be_sold() {
        val sulfuras = sulfuras()

        updateQuality(arrayOf(sulfuras))
        assertEquals(sulfuras.sellIn, 0)
    }

    @Test
    fun never_decreases_quality() {
        val sulfuras = sulfuras()

        updateQuality(arrayOf(sulfuras))
        assertEquals(sulfuras.quality, 80)
    }

    private fun sulfuras(): Item {
        return ItemBuilder.anItem().withName("Sulfuras, Hand of Ragnaros")
                .withSellIn(0)
                .withQuality(80)
                .build()
    }
}
