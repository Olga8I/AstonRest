package org.example.service;

import org.example.exception.NotFoundException;
import org.example.servlet.dto.PhoneNumberIncoming;
import org.example.servlet.dto.PhoneNumberOutGoing;
import org.example.servlet.dto.PhoneNumberUpdate;

import java.util.List;

public interface PhoneNumberService {
    PhoneNumberOutGoing save(PhoneNumberIncoming phoneNumber);

    void update(PhoneNumberUpdate phoneNumber) throws NotFoundException;

    PhoneNumberOutGoing findById(Long phoneNumberId) throws NotFoundException;

    List<PhoneNumberOutGoing> findAll();

    boolean delete(Long phoneNumberId);
}
