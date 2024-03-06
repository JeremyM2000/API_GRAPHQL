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
        clubs.add(new Club("0", "ASSE", "SAINT-ETIENNE", "LIGUE 2"));
        clubs.add(new Club("1", "OL", "LYON", "LIGUE 1"));
        clubs.add(new Club("2", "PSG", "PARIS", "LIGUE 1"));

        return new ClubDao(clubs);
    }
}
