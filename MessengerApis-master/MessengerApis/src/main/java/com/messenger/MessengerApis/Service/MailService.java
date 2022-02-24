package com.messenger.MessengerApis.Service;

import org.springframework.stereotype.Service;

import com.messenger.MessengerApis.Entity.Mail;

public interface MailService {

	public void sendEmail(Mail mail);
}
