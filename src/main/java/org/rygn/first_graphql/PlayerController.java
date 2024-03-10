package org.rygn.first_graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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

    @SchemaMapping(typeName = "Player", field = "club")
    public Club club(Player player) {
        return this.clubDao.getById(player.getClubId());
    }

    @QueryMapping
    public List<Player> getAllPlayer() {
        return this.playerDao.getAllPlayer();
    }

    @QueryMapping
    public Player getPlayerById(@Argument String id) {
        return this.playerDao.getPlayerById(id);
    }

    @MutationMapping
    public Player postOnePlayer(@Argument String id, @Argument String firstName, @Argument String lastName,
                                @Argument String position, @Argument int number, @Argument String clubId) {
        Player player = new Player(id, firstName, lastName, position, number, clubId);
        return this.playerDao.postOnePlayer(player);
    }

    @MutationMapping
    public List<Player> deleteAllPlayer() {
        return this.playerDao.deleteAllPlayer();
    }

    @MutationMapping
    public List<Player> deleteOnePlayerById(@Argument String id) {
        return this.playerDao.deleteOnePlayerById(id);
    }

    @MutationMapping
    public Player putOnePlayer(@Argument String id, @Argument String firstName, @Argument String lastName,
                               @Argument String position, @Argument int number, @Argument String clubId) {
        Player player = new Player(id, firstName, lastName, position, number, clubId);
        return this.playerDao.putOnePlayer(player);
    }

}
