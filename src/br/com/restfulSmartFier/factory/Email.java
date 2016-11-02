package br.com.restfulSmartFier.factory;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.restfulSmartFier.model.Estacao;

public class Email {

	public void enviarEmail(Estacao  estacao){
		Properties props = new Properties();
		
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
		"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator(){
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new javax.mail.PasswordAuthentication("smartfier.smart@gmail.com", "smartfier1");

			}
		});
		
		session.setDebug(true);
		
		try{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("smartfier.smart@gmail.com"));
			Address [] toUser = InternetAddress.parse(estacao.getFuncionario().getEmail());
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Enviando email para teste do smartfier");
			message.setText("Enviei este email utilizando JAVAMAIL com minha conta gmail");
			System.out.println("gsjhgahjghjsagjhasghjasgh");
			Transport.send(message);
			System.out.println("metodo finalizado");
		}catch(MessagingException e){
			throw new RuntimeException(e);
			
		}
		
	}
	
	public static void main(String[] args) {
//		new Email().enviarEmail();
	}
	
}
