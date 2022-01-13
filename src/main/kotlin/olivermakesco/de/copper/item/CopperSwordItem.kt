package olivermakesco.de.copper.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import kotlin.random.Random

val copperSword = CopperSwordItem(FabricItemSettings().maxCount(1).group(ItemGroup.COMBAT))

class CopperSwordItem(settings: Settings) : SwordItem(CopperToolMaterial(), 3, -2.4f, settings), OxidizableItem {

    override fun addOxidization(stack: ItemStack, amount: Int) {
        val nbt = stack.orCreateNbt
        var oxidization = if (nbt.contains("oxidization")) nbt.getInt("oxidization") else 0
        oxidization += amount
        nbt.putInt("oxidization", oxidization);
    }

    override fun getOxidization(stack: ItemStack): Int {
        val nbt = stack.orCreateNbt
        return if (nbt.contains("oxidization")) nbt.getInt("oxidization") else 0
    }

    override fun setOxidization(stack: ItemStack, amount: Int) {
        val nbt = stack.orCreateNbt
        nbt.putInt("oxidization", amount)
    }

    override fun postHit(stack: ItemStack?, target: LivingEntity?, attacker: LivingEntity?): Boolean {
        if (stack != null)
            addOxidization(stack, 1)
        return true
    }

    override fun isDamageable(): Boolean {
        return false
    }
}