package ru.mironov.tokengenerator.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mironov.tokengenerator.model.TokenRequest;
import ru.mironov.tokengenerator.model.TokenResponse;
import ru.mironov.tokengenerator.service.TokenService;

@Service
@RequiredArgsConstructor
public class TokenFacade {
    private final TokenService tokenService;

    public TokenResponse getToken(TokenRequest request) {
        return tokenService.getToken(request.applicationName(), request.login(), request.password())
                .map(tokenModel -> new TokenResponse(tokenModel.token())).orElse(TokenResponse.empty());
    }
}
