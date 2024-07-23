package org.example.servlet.mapper.impl;

import org.example.model.PhoneNumber;
import org.example.model.User;
import org.example.servlet.dto.PhoneNumberIncoming;
import org.example.servlet.dto.PhoneNumberOutGoing;
import org.example.servlet.dto.PhoneNumberUpdate;
import org.example.servlet.dto.UserSmallOutGoingDto;
import org.example.servlet.mapper.PhoneNumberDtoMapper;

import java.util.List;

public class PhoneNumberDtoMapperImpl implements PhoneNumberDtoMapper {
    private static PhoneNumberDtoMapper instance;

    private PhoneNumberDtoMapperImpl() {
    }

    public static synchronized PhoneNumberDtoMapper getInstance() {
        if (instance == null) {
            instance = new PhoneNumberDtoMapperImpl();
        }
        return instance;
    }

    @Override
    public PhoneNumber map(PhoneNumberIncoming phoneDto) {
        return new PhoneNumber(
                null,
                phoneDto.getNumber(),
                null
        );
    }

    @Override
    public PhoneNumberOutGoing map(PhoneNumber phoneNumber) {
        return new PhoneNumberOutGoing(
                phoneNumber.getId(),
                phoneNumber.getNumber(),
                phoneNumber.getUser() == null ?
                        null :
                        new UserSmallOutGoingDto(
                                phoneNumber.getUser().getId(),
                                phoneNumber.getUser().getFirstName(),
                                phoneNumber.getUser().getLastName()
                        )
        );
    }

    @Override
    public List<PhoneNumberOutGoing> map(List<PhoneNumber> phoneNumberList) {
        return phoneNumberList.stream().map(this::map).toList();
    }

    @Override
    public List<PhoneNumber> mapUpdateList(List<PhoneNumberUpdate> phoneNumberUpdateList) {
        return phoneNumberUpdateList.stream().map(this::map).toList();
    }

    @Override
    public PhoneNumber map(PhoneNumberUpdate phoneDto) {
        return new PhoneNumber(
                phoneDto.getId(),
                phoneDto.getNumber(),
                new User(
                        phoneDto.getUserId(),
                        null,
                        null,
                        null,
                        List.of(),
                        List.of()
                )
        );
    }
}
