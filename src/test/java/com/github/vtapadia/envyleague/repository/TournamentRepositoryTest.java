package com.github.vtapadia.envyleague.repository;

import com.github.vtapadia.envyleague.domain.Tournament;
import com.github.vtapadia.envyleague.domain.enums.Status;
import com.github.vtapadia.envyleague.domain.enums.TournamentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TournamentRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Test
    public void testPersistence() {
        Tournament t = new Tournament();
        final String name = "Test Tournament";
        t.setName(name);
        t.setStatus(Status.ACTIVE);
        t.setType(TournamentType.FOOTBALL);
        entityManager.persist(t);
        final Tournament tournament = tournamentRepository.findOne(name);
        assertNotNull(tournament);
        assertEquals("Status not persisted", Status.ACTIVE, tournament.getStatus());
        assertEquals("Type not persisted", TournamentType.FOOTBALL, tournament.getType());
    }
}