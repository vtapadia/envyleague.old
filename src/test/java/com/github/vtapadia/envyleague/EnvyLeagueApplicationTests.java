package com.github.vtapadia.envyleague;

import com.github.vtapadia.envyleague.domain.AppUser;
import com.github.vtapadia.envyleague.domain.Tournament;
import com.github.vtapadia.envyleague.domain.enums.Roles;
import com.github.vtapadia.envyleague.domain.enums.Status;
import com.github.vtapadia.envyleague.domain.enums.TournamentType;
import com.github.vtapadia.envyleague.repository.AppUserRepo;
import com.github.vtapadia.envyleague.repository.TournamentRepo;
import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EnvyLeagueApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private TournamentRepo tournamentRepo;
	@Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

	@Before
	public void init() {
        AppUser user = new AppUser();
        user.setName("Admin User");
        user.setLogin("user");
        user.setPassword(passwordEncoder.encode("password"));
        user.setActivated(true);
        user.setRoles(Sets.newHashSet(Roles.ADMIN));
        appUserRepo.saveAndFlush(user);
		Tournament t1 = new Tournament();
		t1.setName("t1");
		t1.setType(TournamentType.FOOTBALL);
		t1.setStatus(Status.ACTIVE);
		tournamentRepo.saveAndFlush(t1);
		Tournament t2 = new Tournament();
		t2.setName("t1");
		t2.setType(TournamentType.FOOTBALL);
		t2.setStatus(Status.ACTIVE);
		tournamentRepo.saveAndFlush(t2);
	}

    /**
     * WithMockUser users user/password as the user and it for some reasons fetches the user from db.
     * TODO Need to investigate that part more.
     */
	@Test
    @WithMockUser
    public void contextLoads() {
        final Tournament[] tournaments = restTemplate.withBasicAuth("user", "password").getForObject("/rest/v1/tournament?name=t1", Tournament[].class);
        Assert.assertNotNull(tournaments);
        Assert.assertEquals(1, tournaments.length);
        Assert.assertEquals(TournamentType.FOOTBALL, tournaments[0].getType());
        Assert.assertEquals(Status.ACTIVE, tournaments[0].getStatus());
    }

}
