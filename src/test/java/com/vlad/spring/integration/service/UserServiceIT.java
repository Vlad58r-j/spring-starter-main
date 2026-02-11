package com.vlad.spring.integration.service;

import com.vlad.spring.database.entity.Role;
import com.vlad.spring.dto.UserCreateEditDto;
import com.vlad.spring.integration.IntegrationTestBase;
import com.vlad.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserServiceIT extends IntegrationTestBase {

    private static final Long USER_1 = 1L;
    private static final Integer COMPANY_1 = 1;

    private final UserService userService;

    @Test
    void findAll() {
        var result = userService.findAll();
        assertThat(result).hasSize(5);
    }

    @Test
    void findById() {
        var maybeUser = userService.findById(USER_1);
        assertTrue(maybeUser.isPresent());
        maybeUser.ifPresent(user -> assertEquals("ivan@gmail.com", user.getUsername()));
    }

    @Test
    void create() {
        var userDto = new UserCreateEditDto(
                "test@test.com",
                LocalDate.now(),
                "Test",
                "Test",
                Role.ADMIN,
                COMPANY_1
        );
        var createEntity = userService.create(userDto);
        assertEquals(userDto.getUsername(), createEntity.getUsername());
        assertEquals(userDto.getBirthDate(), createEntity.getBirthDate());
        assertEquals(userDto.getFirstname(), createEntity.getFirstname());
        assertEquals(userDto.getLastname(), createEntity.getLastname());
        assertSame(userDto.getRole(), createEntity.getRole());
    }

    @Test
    void update() {
        var userDto = new UserCreateEditDto(
                "test@test.com",
                LocalDate.now(),
                "Test",
                "Test",
                Role.ADMIN,
                COMPANY_1
        );
        var updatingEntity = userService.update(USER_1, userDto);
        assertTrue(updatingEntity.isPresent());

        updatingEntity.ifPresent(user -> {
            assertEquals(userDto.getUsername(), user.getUsername());
            assertEquals(userDto.getBirthDate(), user.getBirthDate());
            assertEquals(userDto.getFirstname(), user.getFirstname());
            assertEquals(userDto.getLastname(), user.getLastname());
            assertSame(userDto.getRole(), user.getRole());
        });
    }

    @Test
    void delete() {
        assertFalse(userService.delete(-123L));
        assertTrue(userService.delete(USER_1));
    }
}
