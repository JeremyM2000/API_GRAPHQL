package org.rygn.first_graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ClubController {

    @Autowired
    private ClubDao clubDao;

    public ClubController() {

    }

    @QueryMapping
    public Club clubById(@Argument String id) {

        return this.clubDao.getById(id);
    }
}
