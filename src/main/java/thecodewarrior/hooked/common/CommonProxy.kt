package thecodewarrior.hooked.common

import com.teamwizardry.librarianlib.common.network.PacketHandler
import net.minecraft.entity.EntityLivingBase
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.relauncher.Side
import thecodewarrior.hooked.common.block.ModBlocks
import thecodewarrior.hooked.common.items.ModItems
import thecodewarrior.hooked.common.items.ModRecipes
import thecodewarrior.hooked.common.network.*

/**
 * Created by TheCodeWarrior
 */
open class CommonProxy {
    open fun pre(e: FMLPreInitializationEvent) {
        ModBlocks
        ModItems
        network()
        HookTickHandler
    }

    open fun init(e: FMLInitializationEvent) {
        ModRecipes
    }

    open fun post(e: FMLPostInitializationEvent) {
    }

    fun network() {
        PacketHandler.register(PacketFireHook::class.java, Side.SERVER)
        PacketHandler.register(PacketRetractHook::class.java, Side.SERVER)
        PacketHandler.register(PacketRetractHooks::class.java, Side.SERVER)
        PacketHandler.register(PacketUpdateWeights::class.java, Side.SERVER)

        PacketHandler.register(PacketHookCapSync::class.java, Side.CLIENT)
    }

    open fun  setAutoJump(entityLiving: EntityLivingBase, value: Boolean) {
    }
}
