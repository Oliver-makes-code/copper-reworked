package olivermakesco.de.copper.item

import net.minecraft.item.Items
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient

class CopperToolMaterial : ToolMaterial {
    override fun getDurability(): Int {
        return 250
    }

    override fun getMiningSpeedMultiplier(): Float {
        return 6f
    }

    override fun getAttackDamage(): Float {
        return 2f
    }

    override fun getMiningLevel(): Int {
        return 3
    }

    override fun getEnchantability(): Int {
        return 0
    }

    override fun getRepairIngredient(): Ingredient {
        return Ingredient.ofItems(Items.COPPER_INGOT)
    }
}