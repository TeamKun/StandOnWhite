package com.bun133.stand_on_white

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class GameCommand() : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        return if (sender is Player) {
            if (sender.isOp) {
                run(sender, command, label, args)
            } else {
                sender.sendMessage("You don't have enough permissions!")
                true
            }
        } else {
            run(sender, command, label, args)
        }
    }

    fun run(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.size != 1) {
            return false
        } else {
            return when (args[0]) {
                "start" -> {
                    isGoing = true
                    true
                }
                "stop" -> {
                    isGoing = false
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}