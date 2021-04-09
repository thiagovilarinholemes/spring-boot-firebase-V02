package com.firebasecrud.controllers;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.mail.javamail.JavaMailSender;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmailSampleController {
	
	@Autowired 
	private JavaMailSender mailSender;
	
	
	String html = "<!DOCTYPE html>\n"
			+ "<html lang=\"en\">\n"
			+ "<head>\n"
			+ "    <meta charset=\"UTF-8\">\n"
			+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
			+ "</head>\n"
			+ "<body>\n"
			+ "    <style type=\"text/css\">\n"
			+ "        html, body{\n"
			+ "            padding: 0;\n"
			+ "            margin: 0;\n"
			+ "        }\n"
			+ "        .header{\n"
			+ "            width: auto; height: auto; background-color: #0373b9; display: flex;\n"
			+ "            padding-left: 20px;\n"
			+ "            color: white;\n"
			+ "        }\n"
			+ "        .img{\n"
			+ "            height: 7rem; \n"
			+ "            background-image: url(./logo.svg);\n"
			+ "        }\n"
			+ "        .main{\n"
			+ "            padding: 50px 50px 20px 50px; text-justify: auto; background-color: rgb(255, 253, 253); height: auto;\n"
			+ "        }\n"
			+ "        .social{\n"
			+ "            display: flex; align-items: center; margin-left: 50px;\n"
			+ "        }\n"
			+ "        .cord{\n"
			+ "            margin-bottom: -10px;\n"
			+ "			   font-weight: bold;"	
			+ "        }\n"
			+ "        .name{\n"
			+ "            margin-bottom: -20px;\n"
			+ "			   font-weight: bold;"	
			+ "        }\n"
			+ "        .job{\n"
			+ "            margin-bottom: -15px;\n"
			+ "			   font-weight: bold;"	
			+ "        }\n"
			+ "        .phone{\n"
			+ "            margin-bottom: -15px; font-size: 14px; color:rgb(85, 85, 85);\n"
			+ "			   font-weight: bold;"	
			+ "        }\n"
			+ "        .email{\n"
			+ "            margin-bottom: -15px; font-size: 15px; color:rgb(85, 85, 85);\n"
			+ "			   font-weight: bold;"	
			+ "        }\n"
			+ "        .website{\n"
			+ "            margin-bottom: -15px; font-size: 15px; color:rgb(85, 85, 85);\n"
			+ "			   font-weight: bold;"	
			+ "        }\n"
			+ " 	   .icon{\n"
			+ "            margin-right: 20px;\n"
			+ "            text-decoration: none;\n"
			+ "            color: black;\n"
			+ "        }"
			+ "\n"
			+ "\n"
			+ "    </style>\n"
			+ "    <div class=\"header\">\n"
			+ "        <h1>Thiago Vilarinho Lemes</h1>\n"
			+ "    </div>\n"
			+ "\n"
			+ "    <main>\n"
			+ "        <div class=\"main\">\n"
			+ "            Olá nameEmail, tudo bem?\n"
			+ "\n"
			+ "            <p>Envio em anexo o meu currículo para participar do processo seletivo para a vaga de jobEmail.<p> \n"
			+ "            <p>Julgo-me em plena capacidade de exercer as funções pertinentes ao cargo oferecido por vossa empresa.<p> \n"
			+ "            <p>Agradeço antecipadamente a apreciação ao meu currículo.<p> \n"
			+ "            <p>Coloco-me desde já a disposição para uma eventual entrevista.<p> \n"
			+ "            <br>\n"
			+ "\n"
			+ "\n"
			+ "            <p class=\"cord\">Cordialmente,</p>\n"
			+ "            <p class=\"name\">Thiago Vilarinho Lemes</p>\n"
			+ "            <p class=\"job\">Analista de Sistema</h4>\n"
			+ "            <p class=\"phone\">Celular/Whats: (63) 9 9292-9774</p>\n"
			+ "            <p class=\"phone\">Celular Recados: (63) 9 9110-2395 - Rosimar</p>\n"
			+ "            <p class=\"email\">Email: lemes_vilarinho@yahoo.com.br | contatothiagolemes@gmail.com</p>\n"
			+ "            <p class=\"website\">Web: <a href=\"https://thiagolemes.tech/\" target=\"_blank\" style=\"color:rgb(85, 85, 85); text-decoration: none;\">thiagolemes.tech</a></p>\n"
			+ "        </div>\n"
			+ "\n"
			+ "        <br>\n"
			+ "\n"
			+ "        \n"
			+ "<div class=\"social\">\n"
			+ "                    <a title=\"Website\" class=\"icon\" href=\"https://thiagolemes.tech/\" target=\"_blank\">Website</a>\n"
			+ "                    <a title=\"linkedIn\" class=\"icon\" href=\"https://www.linkedin.com/in/thiago-vilarinho-lemes-b1232727/\" target=\"_blank\">linkedIn</a>\n"
			+ "                    <a title=\"Facebook\" class=\"icon\" href=\"https://www.facebook.com/thiago.vilarinholemes\" target=\"_blank\">Facebook</a>\n"
			+ "                    <a title=\"Github\" class=\"icon\" href=\"https://github.com/thiagovilarinholemes\" target=\"_blank\">Github</a>\n"
			+ "                </div>"
			+ "           \n"
			+ "    </main>\n"
			+ "</body>\n"
			+ "</html>";		
	
    @GetMapping("/email-send")
    public String sendMail() throws MessagingException{
    	
    	String nameEmail = "Thiago Vilarinho Lemes";
    	String jobEmail = "Dev Java API";
    	String to = "lemes_vilarinho@yahoo.com.br";
    	String from = "contatothiagolemes@gmail.com";
    	String subject = "Dev API";
    	
    		// Mensagem simples
//        	SimpleMailMessage message = new SimpleMailMessage();    
//    		message.setText("Email do Spring Boot");
//      	message.setText(messageHtml);
//      	message.setSubject(subjectEmail);
//      	message.setTo(toEmail);
//      	message.setFrom("wolmirgarbin@gmail.com");
    	
    	
    	// Mensagem com anexo
        String messageHtmlName = html.replace("nameEmail", nameEmail);
        String messageHtml = messageHtmlName.replace("jobEmail", jobEmail);
        String anexo = "./Curriculum_Vitae.pdf";
        
        MimeMessage mimeMessage = mailSender.createMimeMessage();  
        mimeMessage.setSubject(subject, "UTF-8");  

        Address addressFrom = new InternetAddress(from);  
        mimeMessage.setFrom(addressFrom);  
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

        Multipart multipart = new MimeMultipart();  

        // Texto  
        BodyPart messageBodyPart = new MimeBodyPart();  
        messageBodyPart.setContent(messageHtml, "text/html; charset=UTF-8;");  
        multipart.addBodyPart(messageBodyPart);  

        //Anexo  
        File file = new File(anexo);  
        DataSource ds = new FileDataSource(file) {  

            public String getContentType() {  
                return "application/octet-stream";  
            }  
        };  

        BodyPart mbp = new MimeBodyPart();  
        mbp.setDataHandler(new DataHandler(ds));  
        mbp.setFileName(file.getName());  
        mbp.setDisposition(Part.ATTACHMENT);  
        multipart.addBodyPart(mbp);  

        mimeMessage.setContent(multipart);  
        mailSender.send(mimeMessage);
		return "Email enviado com sucesso!";  
       
		

//        try {
//            mailSender.send(message);
//            return "Email enviado com sucesso!";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Erro ao enviar email.";
//        }
    }
}
