package org.rygn.first_graphql;

import java.util.List;

public class ClubDao {

    private List<Club> clubs;

    public ClubDao(List<Club> clubs) { this.clubs = clubs; }

    public List<Club> getAllClub()
    {
        return this.clubs;
    }

    public Club getById(String id) {
        return this.clubs.stream().filter(club -> club.id.equals(id)).findFirst().orElse(null);
    }
}
