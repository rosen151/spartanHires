package com.data;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email{
	/* for email to work add mail.jar in build path as well as tomcat server*/
	public void sendEmail(String fname, String netid, String email){ 
	final String username = "ramyasomisetty@gmail.com";
	final String password = "Umbrela13";

	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");

	Session mail = Session.getInstance(props,
	  new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	  });

	try {

		Message message = new MimeMessage(mail);
		message.setFrom(new InternetAddress("ramyasomisetty@gmail.com"));
		message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(email));
		message.setSubject("MSU NETID");
		message.setText("Dear" + " " + fname + ","
			+ "\n\n Your Michigan State University netid has been created as:" + netid + "\n\n Thanks" + "\n\n MSU Adminstrator");

		Transport.send(message);

	} catch (MessagingException me) {
		throw new RuntimeException(me);
	}
	}

}