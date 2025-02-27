package servlet.mapper.impl;

import org.example.model.PhoneNumber;
import org.example.model.User;
import org.example.servlet.dto.PhoneNumberIncoming;
import org.example.servlet.dto.PhoneNumberOutGoing;
import org.example.servlet.dto.PhoneNumberUpdate;
import org.example.servlet.mapper.PhoneNumberDtoMapper;
import org.example.servlet.mapper.impl.PhoneNumberDtoMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PhoneNumberDtoMapperImplTest {
    private PhoneNumberDtoMapper phoneNumberDtoMapper;

    @BeforeEach
    void setUp() {
        phoneNumberDtoMapper = PhoneNumberDtoMapperImpl.getInstance();
    }

    @DisplayName("PhoneNumber map(PhoneNumberIncomingDto")
    @Test
    void mapIncoming() {
        PhoneNumberIncoming dto = new PhoneNumberIncoming("+1 111 232 1234");

        PhoneNumber result = phoneNumberDtoMapper.map(dto);
        Assertions.assertNull(result.getId());
        Assertions.assertEquals(dto.getNumber(), result.getNumber());
    }

    @DisplayName("PhoneNumberOutGoingDto map(PhoneNumber")
    @Test
    void testMapOutgoing() {
        PhoneNumber phone = new PhoneNumber(
                100L,
                "+1 123 123 1234",
                new User(3L,
                        "f1",
                        "f2",
                        null,
                        List.of(),
                        List.of())
        );

        PhoneNumberOutGoing result = phoneNumberDtoMapper.map(phone);

        Assertions.assertEquals(phone.getId(), result.getId());
        Assertions.assertEquals(phone.getNumber(), result.getNumber());
    }

    @DisplayName("List<PhoneNumberOutGoingDto> map(List<PhoneNumber>")
    @Test
    void testMapList() {
        List<PhoneNumber> phoneList = List.of(
                new PhoneNumber(
                        100L,
                        "+1 123 123 1234",
                        new User(3L,
                                "f1",
                                "f2",
                                null,
                                List.of(),
                                List.of())
                ),
                new PhoneNumber(
                        101L,
                        "+1 222 333 1234",
                        new User(4L,
                                "f3",
                                "f4",
                                null,
                                List.of(),
                                List.of())
                )

        );

        List<PhoneNumberOutGoing> result = phoneNumberDtoMapper.map(phoneList);

        Assertions.assertEquals(phoneList.size(), result.size());
    }

    @DisplayName("List<PhoneNumber> mapUpdateList(List<PhoneNumberUpdateDto>")
    @Test
    void mapUpdateList() {
        List<PhoneNumberUpdate> updateDtoList = List.of(
                new PhoneNumberUpdate(
                        100L,
                        "+1 123 123 1234", 1L
                ),
                new PhoneNumberUpdate(
                        101L,
                        "+1 222 333 1234",
                        2L
                )
        );

        List<PhoneNumber> result = phoneNumberDtoMapper.mapUpdateList(updateDtoList);

        Assertions.assertEquals(updateDtoList.size(), result.size());
    }

    @DisplayName("PhoneNumber map(PhoneNumberUpdateDto ")
    @Test
    void testMapUpdate() {
        PhoneNumberUpdate dto = new PhoneNumberUpdate(
                100L,
                "+1 123 123 1234",
                1L
        );

        PhoneNumber result = phoneNumberDtoMapper.map(dto);

        Assertions.assertEquals(dto.getId(), result.getId());
        Assertions.assertEquals(dto.getNumber(), result.getNumber());
    }
}