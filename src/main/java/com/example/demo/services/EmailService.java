package com.example.demo.services;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
		@Autowired
	    private JavaMailSender mailSender;
	      
	    @Autowired
	    private SimpleMailMessage preConfiguredMessage;
	  
	    /**
	     * This method will send compose and send the message 
	     * */
	  
	    
	    
	    public void sendMailOrder(String to, String subject) 
	    {
	        MimeMessage msg = mailSender.createMimeMessage();
	        String body = "votre commande a etait passe";
	        		
	        MimeMessageHelper helper;
			try {
				helper = new MimeMessageHelper(msg, true);
				helper.setTo(to);
				helper.setSubject(subject);
				helper.setText(body,true);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
	        
	        
	        mailSender.send(msg);
	    }
	    
	    
	
	    
	    
	    
	  
	    /**
	     * This method will send a pre-configured message
	     * */
	    public void sendPreConfiguredMail(String message) 
	    {
	        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
	        mailMessage.setText(message);
	        mailSender.send(mailMessage);
	    }

}
