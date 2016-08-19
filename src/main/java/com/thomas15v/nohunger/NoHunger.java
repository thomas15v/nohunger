package com.thomas15v.nohunger;

import org.spongepowered.api.data.manipulator.mutable.PotionEffectData;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id="nohunger", name = "NoHunger", version = "0.0.1", authors = {"thomas15v"})
public class NoHunger {

    @Listener
    public void onEntitySpawn(ClientConnectionEvent.Join event){
        PotionEffectData effects = event.getTargetEntity().getOrCreate(PotionEffectData.class).get();
        effects.addElement(PotionEffect.builder().potionType(PotionEffectTypes.SATURATION).particles(false).duration(Integer.MAX_VALUE).amplifier(9999).build());
        event.getTargetEntity().offer(effects);
    }
}
