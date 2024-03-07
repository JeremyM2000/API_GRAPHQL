package org.rygn.first_graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private ClubDao clubDao;

    public PlayerController() {

    }

    @QueryMapping
    public List<Player> getAllPlayer() {
        return this.playerDao.getAllPlayer();
    }

    @SchemaMapping(typeName = "Player", field = "club")
    public Club club(Player player) {
        return this.clubDao.getById(player.getClubId());
    }

}
