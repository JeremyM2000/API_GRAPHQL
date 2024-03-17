package org.rygn.first_graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public ClubDao clubDao() {
        List<Club> clubs = new ArrayList<>();
        clubs.add(new Club("club-1", "ASSE", "SAINT-ETIENNE", "LIGUE 2"));
        clubs.add(new Club("club-2", "OL", "LYON", "LIGUE 1"));
        clubs.add(new Club("club-3", "PSG", "PARIS", "LIGUE 1"));

        return new ClubDao(clubs);
    }

    @Bean
    public PlayerDao playerDao() {
        List<Player> players = new ArrayList<>();
        players.add(
                new Player("player-0",
                "Jeremy",
                "Morel",
                "Attaquant",
                7,
                "club-1" )
        );

        return new PlayerDao(players);
    }
}
