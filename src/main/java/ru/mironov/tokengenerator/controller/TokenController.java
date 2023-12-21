package ru.mironov.tokengenerator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mironov.tokengenerator.facade.TokenFacade;
import ru.mironov.tokengenerator.model.TokenRequest;
import ru.mironov.tokengenerator.model.TokenResponse;

@RestController
@RequestMapping("api/token-generator")
@RequiredArgsConstructor
public class TokenController {

    private final TokenFacade tokenFacade;
    @PostMapping()
    public TokenResponse getToken(@RequestBody TokenRequest request){
        return tokenFacade.getToken(request);
    }
}
