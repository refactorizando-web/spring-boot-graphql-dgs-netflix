package com.refactorizando.samples.dgs.fetcher.query;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.context.DgsContext;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import com.refactorizando.samples.dgs.context.CustomContext;
import com.refactorizando.samples.dgs.context.CustomContextBuilder;
import com.refactorizando.samples.dgs.domain.User;
import com.refactorizando.samples.dgs.repository.UserRepository;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@DgsComponent
@RequiredArgsConstructor
public class UserQuery {

    private final UserRepository userRepository;

    private final CustomContextBuilder contextBuilder;

    @DgsData(parentType = "QueryResolver", field = "users")
    public Iterable<User> findAll(DgsDataFetchingEnvironment dfe) {

        var users = (List<User>) userRepository.findAll();

        contextBuilder.customContext(users, null, null).build();

        return users;
    }

    @DgsData(parentType = "QueryResolver", field = "user")
    public User findById(@InputArgument("id") String id, DataFetchingEnvironment dfe) {

        CustomContext customContext = DgsContext.getCustomContext(dfe);

        var users = customContext.getUsers();


        if (null != users) {
            var user = users.stream().filter(u -> u.getId().equals(UUID.fromString(id))).findFirst();

            return user.orElseGet(() -> userRepository.findById(UUID.fromString(id)).orElseThrow(DgsEntityNotFoundException::new));

        } else {

            return userRepository.findById(UUID.fromString(id)).orElseThrow(DgsEntityNotFoundException::new);
        }

    }
}
