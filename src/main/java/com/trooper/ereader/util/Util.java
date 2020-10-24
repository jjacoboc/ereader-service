/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trooper.ereader.util;

import com.sun.mail.util.MailSSLSocketFactory;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.ResourceBundle;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author root
 */
public class Util {
//    public static void main(String args[]) {
//        String[] to = new String[1];
//        to[0] = "jonatanjacobo@gmail.com";
//        String body = Constants.welcomeBody;
//        body.replace("{1}", "Jonatan").replace("{2}", "10288721").replace("{3}", "sadsd");
//        enviarCorreo(to, "Subject", body);
//    }
    
    /**
     * Envía un correo electrónico a los destinatarios dados.
     * @param to Destinatarios del correo.
     * @param subject Título del correo.
     * @param body Contenido del correo.
     */
    public static void enviarCorreo(String to[], String subject, String body) {

        String mailServer = "";
        String portMail = "";
        String userMail = "";
        String pwdMail = "";
//        String useAuth = "";
        String useSSL = "";
        String from = "";
        try{
            ResourceBundle bundle = ResourceBundle.getBundle("mail");
            mailServer = bundle.getString("mailServer");
            portMail = bundle.getString("portMail");
            userMail = bundle.getString("userMail");
            pwdMail = bundle.getString("pwdMail");
//            useAuth = bundle.getString("useAuth");
            useSSL = bundle.getString("useSSL");
            from = bundle.getString("from");
            
            java.util.Properties props = new java.util.Properties();
            props.put("mail.smtp.host", mailServer);
            props.put("mail.smtp.port", portMail);
            props.put("mail.smtp.starttls.enable", useSSL);
            props.put("mail.smtp.user", userMail);
//            props.setProperty("mail.smtp.auth", useAuth);
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.socketFactory", sf);

            Session session = Session.getDefaultInstance(props);
            session.setDebug(true);

            Address adrss[] = new Address[to.length];
            for(int i=0;i<to.length;i++){
                adrss[i] = new InternetAddress(to[i]);
            }
            
            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart mbp = new MimeBodyPart();
            mbp.setContent(body, "text/html");
            multipart.addBodyPart(mbp);
            
            File file;
            mbp = new MimeBodyPart();
            file = new File(Constants.imageDirectory + "logo_mgp.png");
            mbp.setDataHandler(new DataHandler(new FileDataSource(file)));
            mbp.setHeader("Content-ID", "<logo_mgp>");
            multipart.addBodyPart(mbp);
            
            mbp = new MimeBodyPart();
            file = new File(Constants.imageDirectory + "logo_ajustes.png");
            mbp.setDataHandler(new DataHandler(new FileDataSource(file)));
            mbp.setHeader("Content-ID", "<logo_ajustes>");
            multipart.addBodyPart(mbp);
            
            mbp = new MimeBodyPart();
            file = new File(Constants.imageDirectory + "facebook@2x.png");
            mbp.setDataHandler(new DataHandler(new FileDataSource(file)));
            mbp.setHeader("Content-ID", "<facebook>");
            multipart.addBodyPart(mbp);
            
            mbp = new MimeBodyPart();
            file = new File(Constants.imageDirectory + "twitter@2x.png");
            mbp.setDataHandler(new DataHandler(new FileDataSource(file)));
            mbp.setHeader("Content-ID", "<twitter>");
            multipart.addBodyPart(mbp);
            
            mbp = new MimeBodyPart();
            file = new File(Constants.imageDirectory + "instagram@2x.png");
            mbp.setDataHandler(new DataHandler(new FileDataSource(file)));
            mbp.setHeader("Content-ID", "<instagram>");
            multipart.addBodyPart(mbp);
            
            mbp = new MimeBodyPart();
            file = new File(Constants.imageDirectory + "Logo-Trooper-blanco.png");
            mbp.setDataHandler(new DataHandler(new FileDataSource(file)));
            mbp.setHeader("Content-ID", "<logo_trooper>");
            multipart.addBodyPart(mbp);
            
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(userMail,from));    
            msg.addRecipients(Message.RecipientType.TO, adrss);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setContent(multipart);

            //Transport.send(msg);
            Transport t = session.getTransport("smtp");
            t.connect(userMail,pwdMail);
            t.sendMessage(msg, msg.getAllRecipients());

        }catch(UnsupportedEncodingException | GeneralSecurityException | MessagingException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    /**
     * Devuelve una cadena alfanumérica de seis caracteres.
     * @return clave Clave generada.
     */
    public static String generarClave(){
        String clave = null;
        int max = 0;
        int min = 0;
        int numeroRandom = 0;
        int asciiRandom = 0;
        String letraRandom = null;
        byte[] bytes = new byte[3];
        try{
            max = 99999;
            min = 10000;
            numeroRandom = (int) Math.floor(Math.random()*(max-min+1)+min);

            max = 122;
            min = 97;
            for(int i=0;i<3;i++){
                asciiRandom = (int) Math.floor(Math.random()*(max-min+1)+min);
                bytes[i] = (byte)asciiRandom;
            }
            letraRandom = new String(bytes);
            clave = letraRandom.concat(Integer.toString(numeroRandom));
        }catch(Exception e){
            e.getMessage();
        }
        return clave;
    }
}
