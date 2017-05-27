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

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Comportment at 16:07 on 27/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
public class SkyCubeIsland {

    private final Chunk chunk;
    private final Player owner;
    private Set<Player> members;
    private long score;
    private Location spawn;

    public SkyCubeIsland(Chunk chunk, Player owner) {
        this.chunk = chunk;
        this.spawn = chunk.getBlock(6, 6, 64).getLocation();
        this.owner = owner;
        this.members = new HashSet<>();
        this.score = 0;
    }

    public SkyCubeIsland(Chunk chunk, Player owner, Set<Player> allies) {
        this.chunk = chunk;
        this.spawn = chunk.getBlock(6, 6, 64).getLocation();
        this.owner = owner;
        this.members = allies;
        this.score = 0;
    }

    public SkyCubeIsland(Chunk chunk, Player owner, long score) {
        this.chunk = chunk;
        this.spawn = chunk.getBlock(6, 6, 64).getLocation();
        this.owner = owner;
        this.members = new HashSet<>();
        this.score = score;
    }

    public SkyCubeIsland(Chunk chunk, Player owner, Set<Player> allies, long score) {
        this.chunk = chunk;
        this.spawn = chunk.getBlock(6, 6, 64).getLocation();
        this.owner = owner;
        this.members = allies;
        this.score = score;
    }

    public void resetScore() {
        score = 0;
    }

    public void setScore(long amount) {
        score = amount;
    }

    public void removeScore(long amount) {
        score -= amount;
    }

    public void addScore(long amount) {
        score += amount;
    }

    public void addMember(Player player) {
        members.add(player);
    }

    public void addMember(Set<Player> players) {
        members.addAll(players);
    }

    public void removeMember(Player player) {
        members.remove(player);
    }

    public void removeMembers(Set<Player> players) {
        members.removeAll(players);
    }

    public void resetMembers() {
        members = new HashSet<>();
    }

    public boolean hasPlayer(Player player) {
        return this.getOwner().equals(player) || this.getMembers().contains(player);
    }

    public Player getOwner() {
        return owner;
    }

    public Set<Player> getMembers() {
        return members;
    }

    public long getScore() {
        return score;
    }

    public Chunk getChunk() {
        return chunk;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public Location getSpawn() {
        return spawn;
    }
}