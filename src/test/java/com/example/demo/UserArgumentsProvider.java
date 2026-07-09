package com.example.demo;

import com.example.demo.entites.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.UUID;
import java.util.stream.Stream;

public class UserArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
               Arguments.of (User.builder().username("shyam_"+ UUID.randomUUID()).password("shyam").build()),
                Arguments.of(User.builder().username("sapna_"+UUID.randomUUID()).password("sapna").build())
        );
    }
}
