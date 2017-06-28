package com.github.vtapadia.envyleague.service;

import com.github.vtapadia.envyleague.domain.PersistentToken;
import com.github.vtapadia.envyleague.repository.AppUserRepository;
import com.github.vtapadia.envyleague.repository.PersistentTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

/**
 *
 */
@Repository
public class PersistentTokenRepoService implements PersistentTokenRepository {
    @Autowired
    private PersistentTokenRepo persistentTokenRepo;

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        Optional.ofNullable(token).map(p -> {
            PersistentToken pt = new PersistentToken();
            pt.setLastUsed(LocalDateTime.ofInstant(token.getDate().toInstant(), ZoneId.systemDefault()));
            pt.setTokenValue(token.getTokenValue());
            pt.setSeries(token.getSeries());
            pt.setAppUser(appUserRepository.getOne(token.getUsername()));
            return pt;
        }).map(persistentTokenRepo::save);
    }

    @Override
    @Transactional
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        Optional.ofNullable(series).map(persistentTokenRepo::findOne).map(pt -> {
            pt.setTokenValue(tokenValue);
            pt.setLastUsed(LocalDateTime.ofInstant(lastUsed.toInstant(), ZoneId.systemDefault()));
            return pt;
        }).map(persistentTokenRepo::save);
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        return Optional.ofNullable(persistentTokenRepo.findOne(seriesId))
                .map(p -> new PersistentRememberMeToken(p.getAppUser().getLogin(),p.getSeries(),p.getTokenValue(),Date.from(p.getLastUsed().atZone(ZoneId.systemDefault()).toInstant())))
                        .orElse(null);
    }

    @Override
    public void removeUserTokens(String username) {
        Optional.ofNullable(username).map(persistentTokenRepo::deleteByAppUser_Login);
    }
}
