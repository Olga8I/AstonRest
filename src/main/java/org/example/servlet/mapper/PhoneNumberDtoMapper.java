package org.example.servlet.mapper;

import org.example.model.PhoneNumber;
import org.example.servlet.dto.PhoneNumberIncoming;
import org.example.servlet.dto.PhoneNumberOutGoing;
import org.example.servlet.dto.PhoneNumberUpdate;

import java.util.List;

public interface PhoneNumberDtoMapper {
    PhoneNumber map(PhoneNumberIncoming phoneNumberIncomingDto);

    PhoneNumberOutGoing map(PhoneNumber phoneNumber);

    List<PhoneNumberOutGoing> map(List<PhoneNumber> phoneNumberList);

    List<PhoneNumber> mapUpdateList(List<PhoneNumberUpdate> phoneNumberUpdateList);

    PhoneNumber map(PhoneNumberUpdate phoneNumberIncomingDto);
}
