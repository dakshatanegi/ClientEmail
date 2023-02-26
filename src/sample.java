/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientemail;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author 91838
 */
public class sample {
    public static void check(String host,String storeType, String user,String password){
        try{
                 Properties propt=new Properties();
                 propt.put("mail.pop3.host",host);
                 propt.put("mail.pop3.port",995);
                 propt.put("mail.pop3.starttls.enable","true");
                 Session email=Session.getDefaultInstance(propt);
                 Store st=email.getStore("pop3s");
                 st.connect(host,user,password);
                 Folder fold=st.getFolder("INBOX");
                 fold.open(Folder.READ_ONLY);
                 
                 Message msg[]=fold.getMessages();
                 
                 int i= ((msg.length-1));
                 Message msg1=msg[i];
                 
                 
                 System.out.println("Email Number: "+(i+1));
                 System.out.println("Subject: "+msg1.getSubject());
                 System.out.println("From: "+msg1.getFrom()[0]);
                 

                 
                 fold.close(true);
                 st.close();
             }catch(NoSuchProviderException e){
             }catch(MessagingException e){
             }catch(Exception e){
             }
    }
        public static void main(String[] args){
            String host="pop.gmail.com";
    String mailStoreType="pop3";
    String username="negidakshata@gmail.com";
    String password="jsipcgocunjdmbde";
    check(host,mailStoreType,username,password);
        }
}
    
           
            

