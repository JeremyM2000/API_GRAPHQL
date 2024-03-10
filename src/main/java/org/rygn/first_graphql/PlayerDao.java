package org.rygn.first_graphql;

import java.util.List;
import java.util.Objects;

public class PlayerDao {

    private List<Player> players;

    public PlayerDao(List<Player> players) {
        this.players = players;
    }

    public List<Player> getAllPlayer()
    {
        return this.players;
    }

    public Player getPlayerById(String id)
    {
        return this.players.stream().filter(player -> player.id.equals(id)).findFirst().orElse(null);
    }

    public Player postOnePlayer(Player player)
    {
        this.players.add(player);
        return player;
    }

    public List<Player> deleteAllPlayer()
    {
        this.players.clear();
        return this.players;
    }

    public List<Player> deleteOnePlayerById(String id)
    {
        this.players.removeIf(player -> Objects.equals(player.id, id));
        return this.players;
    }

    public Player putOnePlayer(Player player)
    {
        for(Player p : this.players) {
            if(p.id.equals(player.id))
            {
                this.players.set(this.players.indexOf(p), player);
                break;
            }
        }

        return player;
    }
}
