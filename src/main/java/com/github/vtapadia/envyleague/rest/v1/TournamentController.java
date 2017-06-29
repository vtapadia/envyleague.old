package com.github.vtapadia.envyleague.rest.v1;

import com.github.vtapadia.envyleague.domain.Tournament;
import com.github.vtapadia.envyleague.repository.TournamentRepo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

/**
 * Tournament Controller providing tournament related information.
 */
@RestController
@RequestMapping("/rest/v1/tournament")
public class TournamentController {

    @Autowired
    private TournamentRepo tournamentRepo;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<?> getAllTournaments(@RequestParam(required = false) String name) {
        return Optional
                .ofNullable(name)
                .map(tournamentRepo::findOne)
                .map(Lists::newArrayList)
                .map(ResponseEntity::ok)
                .orElse(Optional.ofNullable(tournamentRepo.findAll()).map(Lists::newArrayList).map(ResponseEntity::ok)
                        .orElse(ResponseEntity.noContent().build()));
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<?> addTournament(@Validated @RequestBody Tournament tournament) {
        return Optional
                .ofNullable(tournament)
                .map(tournamentRepo::save)
                .map(t -> ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentContextPath().queryParam("name", tournament.getName()).build().toUri()).build())
                .orElse(ResponseEntity.badRequest().build());
    }
}
