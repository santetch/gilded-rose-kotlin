package com.gildedrose

import com.gildedrose.GildedRose.updateQuality
import com.gildedrose.ItemBuilder.Companion.anItem
import junit.framework.Assert.assertEquals
import org.junit.Test

class BackstagePassesUpdateQualityTest {

    @Test
    fun increases_quality_as_the_selling_day_aproaches() {
        val backstagePass = aBackstagePass().withQuality(20)
                .withSellIn(15)
                .build()

        updateQuality(arrayOf(backstagePass))
        assertEquals(backstagePass.quality, 21)
    }

    @Test
    fun increases_by_two_if_there_are_betwen_10_and_5_days_to_the_sellin_day() {
        var backstagePass = aBackstagePass().withQuality(20)
                .withSellIn(10)
                .build()

        updateQuality(arrayOf(backstagePass))
        assertEquals(backstagePass.quality, 22)

        backstagePass = aBackstagePass().withQuality(20)
                .withSellIn(6)
                .build()

        updateQuality(arrayOf(backstagePass))
        assertEquals(backstagePass.quality, 22)
    }

    @Test
    fun increases_by_three_if_there_are_betwen_5_and_1_days_to_the_sellin_day() {
        var backstagePass = aBackstagePass().withQuality(20)
                .withSellIn(5)
                .build()

        updateQuality(arrayOf(backstagePass))
        assertEquals(backstagePass.quality, 23)

        backstagePass = aBackstagePass().withQuality(20)
                .withSellIn(1)
                .build()

        updateQuality(arrayOf(backstagePass))
        assertEquals(backstagePass.quality, 23)
    }

    @Test
    fun quality_is_zero_when_the_sold_date_has_passed() {
        val backstagePass = aBackstagePass().withQuality(20)
                .withSellIn(0)
                .build()

        updateQuality(arrayOf(backstagePass))
        assertEquals(backstagePass.quality, 0)
    }

    private fun aBackstagePass(): ItemBuilder {
        return anItem().withName("Backstage passes to a TAFKAL80ETC concert")
    }

}