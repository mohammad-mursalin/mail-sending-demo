package com.mursalin.MailSenderDemo.repository;

import com.mursalin.MailSenderDemo.model.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation, Long> {
}
