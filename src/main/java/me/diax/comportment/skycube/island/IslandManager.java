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

package me.diax.comportment.skycube.island;

import me.diax.comportment.skycube.Main;
import org.bukkit.Chunk;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Comportment at 16:17 on 27/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
public class IslandManager {

    private final Set<SkyCubeIsland> islands;
    private final Main plugin;

    public IslandManager(Main plugin) {
        this.plugin = plugin;
        this.islands = new HashSet<>();
    }

    public IslandManager(Main plugin, Set<SkyCubeIsland> islands) {
        this.plugin = plugin;
        this.islands = islands;
    }

    public SkyCubeIsland getIslandOwnedBy(Player owner) {
        return getIslands().stream().filter(sci -> sci.getOwner().equals(owner)).findAny().orElse(null);
    }

    public SkyCubeIsland getIslandContaining(Player player) {
        return getIslands().stream().filter(sci -> sci.getMembers().contains(player)).findAny().orElse(getIslandOwnedBy(player));

    }

    public Set<Chunk> getUsedChunks() {
        return getIslands().stream().map(SkyCubeIsland::getChunk).collect(Collectors.toSet());
    }

    public Set<SkyCubeIsland> getIslands() {
        return islands;
    }

    public boolean assignIslandTo(Player player) {
        plugin.getServer().getWorld("");
        return false;
    }
}