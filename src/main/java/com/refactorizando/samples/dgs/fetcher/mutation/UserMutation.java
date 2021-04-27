package com.refactorizando.samples.dgs.fetcher.mutation;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.refactorizando.samples.dgs.domain.User;
import com.refactorizando.samples.dgs.domain.input.UserInput;
import com.refactorizando.samples.dgs.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class UserMutation {

    private final UserRepository userRepository;

    @DgsData(parentType = "MutationResolver", field = "createUser")
    public User createUser(@InputArgument("user") UserInput user) {
        return userRepository.save(new User(null, user.getFirstName(), user.getLastName(), user.getAge(), user.getAddress(), user.getCountry(), user.getCity(), null, null));
    }

}
