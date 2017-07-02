package com.github.vtapadia.envyleague.rest.v1;

import com.github.vtapadia.envyleague.domain.League;
import com.github.vtapadia.envyleague.repository.LeagueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Optional.ofNullable;

/**
 * League Controller
 */
@RestController
@RequestMapping("/rest/v1/league")
public class LeagueController {

    @Autowired
    private LeagueRepo leagueRepo;

    @GetMapping
    public ResponseEntity<?> getLeague(@RequestParam(required = false) String name) {
        return ofNullable(name).map(n -> {
            League l = new League();
            l.setName(n);
            return Example.of(l);
        }).map(e -> leagueRepo.findAll(e))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok(leagueRepo.findAll()));
    }

    @PostMapping
    public ResponseEntity<?> createLeague(@RequestBody @Validated League league, Authentication authentication) {
        leagueRepo.saveAndFlush(league);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<?> updateLeague(@RequestBody @Validated League league) {
        return ofNullable(league)
                .filter(l -> leagueRepo.exists(l.getName()))
                .map(l -> leagueRepo.saveAndFlush(l))
                .map(l -> ResponseEntity.ok().build())
                .orElse(ResponseEntity.notFound().build());
    }
}
