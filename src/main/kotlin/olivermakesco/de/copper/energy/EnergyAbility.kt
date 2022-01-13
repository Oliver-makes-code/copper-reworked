package olivermakesco.de.copper.energy

import net.minecraft.block.BlockState
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.util.ActionResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

interface EnergyAbility {
    fun onBlockUse(context: ItemUsageContext): ActionResult
    fun onBlockBreak(stack: ItemStack, world: World, state: BlockState, pos: BlockPos, entity: LivingEntity): Boolean
    fun onEntityHit(stack: ItemStack, target: LivingEntity, attacker: LivingEntity): Boolean

}