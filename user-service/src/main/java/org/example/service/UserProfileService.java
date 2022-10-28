package org.example.service;


import org.example.dto.request.NewCreateUserDto;
import org.example.mapper.IUserMapper;
import org.example.repository.IUserProfileRepository;
import org.example.repository.entity.UserProfile;
import org.example.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService extends ServiceManager<UserProfile, Long> {

    private final IUserProfileRepository userProfileRepository;

    public UserProfileService(IUserProfileRepository userProfileRepository) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile create(NewCreateUserDto dto) {

        return save(IUserMapper.INSTANCE.toUserProfile(dto));
    }

}
