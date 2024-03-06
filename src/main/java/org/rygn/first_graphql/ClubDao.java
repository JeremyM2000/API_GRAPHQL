package org.rygn.first_graphql;

import java.util.List;
import java.util.Objects;

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

    public Club postOneClub(Club club) {
        this.clubs.add(club);
        return club;
    }

    public List<Club> deleteAllClub()
    {
        this.clubs.clear();
        return this.clubs;
    }

    public List<Club> deleteOneClubById(String id)
    {
        this.clubs.removeIf(club -> Objects.equals(club.id, id));
        return this.clubs;
    }

    public Club putOneClub(Club club) {
        for (Club c : this.clubs) {
            if(c.id.equals(club.id))
            {
                this.clubs.set(this.clubs.indexOf(c), club);
                break;
            }
        }

        return club;
    }
}
