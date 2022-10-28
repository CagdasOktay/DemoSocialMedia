package org.example.service;


import org.example.dto.request.RegisterRequestDto;
import org.example.manager.IUserManager;
import org.example.mapper.IAuthMapper;
import org.example.repository.AuthRepository;
import org.example.repository.entity.Auth;
import org.example.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final AuthRepository authRepository;
    private final IUserManager userManager;

    public AuthService(AuthRepository authRepository, IUserManager userManager) {
        super(authRepository);
        this.authRepository = authRepository;
        this.userManager = userManager;
    }

    public Auth register(RegisterRequestDto dto) {

        Auth auth = IAuthMapper.INSTANCE.toAuth(dto);
        save(auth);

        userManager.create(IAuthMapper.INSTANCE.toNewCreateUserDto(auth));

        return auth;
    }
}
