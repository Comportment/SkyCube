/*
 * Copyright 2017 Comportment | comportment@diax.me
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.diax.comportment.skycube.command.commands;

import me.diax.comportment.skycube.command.SkyCubeCommand;
import me.diax.comportment.skycube.island.IslandManager;
import me.diax.comportment.skycube.island.SkyCubeIsland;
import org.bukkit.entity.Player;

/**
 * Created by Comportment at 16:51 on 27/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
public class HomeCommand extends SkyCubeCommand {

    public HomeCommand(Player player, String string) {
        super(player, string);
        SkyCubeIsland island = IslandManager.getIslandContaining(player);
        if (island == null) {
            player.sendMessage("You don't have an island!");
            return;
        }
        player.teleport(island.getSpawn());
        player.sendMessage("You have been teleported to your island!");
    }
}