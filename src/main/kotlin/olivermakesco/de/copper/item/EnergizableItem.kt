package olivermakesco.de.copper.item

import net.minecraft.item.ItemStack

interface EnergizableItem {
    fun getEnergyTimers(stack:ItemStack): Array<Int>


}