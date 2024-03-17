package org.rygn.first_graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ClubController {

    @Autowired
    private ClubDao clubDao;

    public ClubController() {

    }

    @QueryMapping
    public List<Club> allClub() {

        return this.clubDao.getAllClub();
    }

    @QueryMapping
    public Club clubById(@Argument String id) {
        return this.clubDao.getById(id);
    }

    @MutationMapping
    public Club postOneClub(@Argument String id, @Argument String name, @Argument String city, @Argument String league) {
        Club club = new Club(id, name, city, league);
        return this.clubDao.postOneClub(club);
    }

    @MutationMapping
    public List<Club> deleteAllClub() {
        return this.clubDao.deleteAllClub();
    }

    @MutationMapping
    public List<Club> deleteOneClubById(@Argument String id){
        return this.clubDao.deleteOneClubById(id);
    }

    @MutationMapping
    public Club putOneClub(@Argument String id, @Argument String name, @Argument String city, @Argument String league) {
        Club club = new Club(id, name, city, league);
        return this.clubDao.putOneClub(club);
    }
}
