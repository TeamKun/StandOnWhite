package com.bun133.stand_on_white

import org.bukkit.Material
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.plugin.java.JavaPlugin

val whiteBlocks = mutableListOf(
    Material.WHITE_WOOL
)

var isGoing = false

class Stand_on_white : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        getCommand("game")!!.setExecutor(GameCommand())
        server.pluginManager.registerEvents(Listener(),this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}

class Listener : Listener{
    fun onMove(e:PlayerMoveEvent){
        if(isGoing){
            if(e.to.block.type.isAir) return
            if(whiteBlocks.contains(e.to.block.type)){

            }else{
                e.player.sendMessage("You are not on White Block!!!")
                e.player.health = 0.0
            }
        }
    }
}