package olivermakesco.de.copper.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack

val energizedCopperIngot = EnergizedCopperIngot(FabricItemSettings().group(ItemGroup.MATERIALS))

class EnergizedCopperIngot(settings: Settings) : Item(settings) {
    override fun hasGlint(stack: ItemStack?): Boolean {
        return true
    }
}