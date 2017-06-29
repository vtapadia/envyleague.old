package com.github.vtapadia.envyleague.repository;

import com.github.vtapadia.envyleague.domain.Team;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


/**
 * Team Repository test class
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TeamRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TeamRepo teamRepo;

    @Test
    public void teamRepository() {
        Team t = new Team();
        final String name = "Test team";
        t.setName(name);
        t.setImage(null);
        entityManager.persist(t);
        final Team team = teamRepo.findOne(name);
        assertNotNull(team);
        assertNull("Status not persisted", team.getImage());
    }

}