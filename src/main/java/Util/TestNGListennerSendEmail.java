package Util;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.testng.IExecutionListener;

public class TestNGListennerSendEmail implements IExecutionListener{


    public void onExecutionStart() {
        System.out.println("发送邮件模式");
    }

    /**
     * Invoked once all the suites have been run.
     */
    public void onExecutionFinish() {
        System.out.println("开始发送邮件");
        HtmlEmail mail = new HtmlEmail();
        mail.setHostName("smtp.163.com");
        mail.setAuthentication("maojessie19@163.com", "1qaz2wsx");
        try {
            mail.setFrom("maojessie19@163.com");
            mail.addTo("1422853714@qq.com");
            mail.setSubject("selenium aotuTest");
            mail.setCharset("UTF-8");
            mail.setHtmlMsg("<a href=\"\"> 测试报告");
            EmailAttachment emailattachment = new EmailAttachment();
            emailattachment.setPath("F:\\Final exercise selenium\\report.html");
            emailattachment.setName("report.html");
            emailattachment.setDescription(EmailAttachment.ATTACHMENT);
            mail.attach(emailattachment);
            mail.send();
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

