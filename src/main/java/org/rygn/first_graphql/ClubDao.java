package org.rygn.first_graphql;

import java.util.List;

public class ClubDao {

    private List<Club> clubs;

    public ClubDao(List<Club> clubs) { this.clubs = clubs; }

    public Club getById(String id) {
        Club _club = this.clubs.stream().filter(club -> club.id.equals(id)).findFirst().orElse(null);
        System.out.println(_club.getCity());
        return _club;
    }
}
