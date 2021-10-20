package com.gustavoVictorio.integrations.services;

import com.gustavoVictorio.integrations.dto.EmailDTO;

public interface EmailService {

	void sendEmail(EmailDTO dto);

}
