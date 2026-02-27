package com.loan.notification_service.service;

import com.loan.notification_service.dto.NotificationRequestDTO;
import com.loan.notification_service.entity.NotificationLog;
import com.loan.notification_service.entity.NotificationTemplate;
import com.loan.notification_service.repository.NotificationLogRepository;
import com.loan.notification_service.repository.NotificationTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final TemplateProcessor templateProcessor;
    private final NotificationTemplateRepository notificationTemplateRepository;
    private final NotificationLogRepository notificationLogRepository;
    private final SesEmailService sesEmailService;

    public void sendNotification(NotificationRequestDTO request){
        NotificationLog log= new NotificationLog();
        log.setEventCode(request.getEventCode());
        log.setRecipient(request.getRecipient());
        log.setChannel(request.getChannel());

        try{
            NotificationTemplate template= notificationTemplateRepository.findByEventCodeAndChannel(
                    request.getEventCode(), request.getChannel()).orElseThrow(()->new RuntimeException(" Template  not found"));


            String processSubject= templateProcessor.processTemplate(template.getSubject(), request.getPlaceholders());

            String processBody= templateProcessor.processTemplate(template.getBody(), request.getPlaceholders());


//            System.out.println(" Sending Email to: "+request.getRecipient());
//            System.out.println("Subject : "+template.getSubject());
//            System.out.println("Body: "+processBody);

            sesEmailService.sendEmail(
                    request.getRecipient(),processSubject,processBody
            );

            log.setStatus("Success");
            notificationLogRepository.save(log);
        }catch(Exception e){
            log.setStatus("Failed");
            log.setErrorMessage(e.getMessage());
            notificationLogRepository.save(log);

            throw  new RuntimeException("Notification failed ",e);
        }
    }
}
