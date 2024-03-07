package org.rygn.first_graphql;

import java.util.List;

public class PlayerDao {

    private List<Player> players;

    public PlayerDao(List<Player> players) {
        this.players = players;
    }

    public List<Player> getAllPlayer()
    {
        return this.players;
    }
}
