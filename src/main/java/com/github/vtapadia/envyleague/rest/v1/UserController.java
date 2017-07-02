package com.github.vtapadia.envyleague.rest.v1;

import com.github.vtapadia.envyleague.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/rest/v1/user")
public class UserController {

    @Autowired
    private AppUserRepo appUserRepo;


}
