package com.github.vtapadia.envyleague;

import com.github.vtapadia.envyleague.domain.Tournament;
import com.github.vtapadia.envyleague.domain.enums.Status;
import com.github.vtapadia.envyleague.domain.enums.TournamentType;
import com.github.vtapadia.envyleague.repository.TournamentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EnvyLeagueApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	TournamentRepository tournamentRepository;

	@Before
	public void setup() {
		Tournament t = new Tournament();
		t.setName("t1");
		t.setType(TournamentType.FOOTBALL);
		t.setStatus(Status.ACTIVE);
		tournamentRepository.saveAndFlush(t);
	}

	@Test
	public void contextLoads() {
        System.out.println(restTemplate.getForObject("/rest/v1/tournament?name=t1", Tournament.class));
//		Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

}
