package com.duyanhggg.blockminer;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockMinerMod implements ModInitializer {
	public static final String MOD_ID = "blockminer";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Register the custom mining tool item
	public static final Item BLOCK_MINER_ITEM = Registry.register(
		Registries.ITEM,
		Identifier.of(MOD_ID, "block_miner"),
		new BlockMinerItem(new Item.Settings().maxDamage(500))
	);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing BlockMiner mod");

		// Add item to creative inventory
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
			content.add(BLOCK_MINER_ITEM);
		});

		// Register block break event handler
		PlayerBlockBreakEvents.BEFORE.register(this::onBlockBreak);

		LOGGER.info("BlockMiner mod initialized successfully");
	}

	/**
	 * Event handler for block breaking
	 * This is called before a block is broken by a player
	 */
	private boolean onBlockBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity) {
		// Check if player is using the Block Miner tool
		ItemStack heldItem = player.getMainHandStack();
		
		if (heldItem.getItem() instanceof BlockMinerItem) {
			// Additional processing can be added here
			// For now, we just let the BlockMinerItem handle the mining bonus
			if (!world.isClient) {
				LOGGER.debug("Player {} is mining block at {} with Block Miner", 
					player.getName().getString(), pos);
			}
		}
		
		// Return true to allow the block to be broken
		return true;
	}
}
