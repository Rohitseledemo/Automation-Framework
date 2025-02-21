package utilities.email.newDemoEmail;

import utilities.constants.NewDemoFrameworkConstants;
import utilities.email.EmailAttachmentsSender;

import javax.mail.MessagingException;

import java.text.SimpleDateFormat;
import java.util.Date;

import static utilities.constants.NewDemoFrameworkConstants.REPORT_TITLE;
import static utilities.email.newDemoEmail.NewDemoEmailConfig.*;

public class NewDemoEmailSender {

    private NewDemoEmailSender() {
        super();
    }

    public static void sendEmail(int count_totalTCs, int count_passedTCs, int count_failedTCs, int count_skippedTCs) {

        assert NewDemoFrameworkConstants.SEND_EMAIL_TO_USERS != null;
        if (NewDemoFrameworkConstants.SEND_EMAIL_TO_USERS.trim().equalsIgnoreCase(NewDemoFrameworkConstants.YES)) {
            System.out.println("****************************************");
            System.out.println("Send Email - START");
            System.out.println("****************************************");

            System.out.println("File name: " + NewDemoFrameworkConstants.getNewDemoExtentReportFilePath());
            String timestamp = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

            String messageBody = "<html>"
                    + "<body>"
                    + "<p>Hi Team,</p>"
                    + "<p>This is an auto-generated email to share the results of the latest test automation run for (NewDemo Portal) dated - "+timestamp+".<br>"
                    + "For a detailed breakdown of the test results, please review the attached HTML report.</p>"
                    + "<p><b>Note:</b><br>"
                    + "This email is auto-generated. If you have any questions or require further details, feel free to contact the QA.</p>"
                    + "<p>Best Regards,<br>"
                    + "Rohit Kumar</p>"
                    + "</body>"
                    + "</html>"+getTestCasesCountInFormat(count_totalTCs, count_passedTCs, count_failedTCs,count_skippedTCs);

            String attachmentFile_ExtentReport = NewDemoFrameworkConstants.getNewDemoExtentReportFilePath();

            try {
                EmailAttachmentsSender.sendEmailWithAttachments(SMTP_SERVER, SMTP_PORT, USERNAME, PASSWORD, TO, SUBJECT, messageBody,
                        attachmentFile_ExtentReport);

                System.out.println("****************************************");
                System.out.println("Email sent successfully.");
                System.out.println("Send Email - END");
                System.out.println("****************************************");
            } catch (MessagingException e) {
                e.printStackTrace();
            }

        }

    }

    private static String getTestCasesCountInFormat(int count_totalTCs, int count_passedTCs, int count_failedTCs,
                                                    int count_skippedTCs) {
        System.out.println("count_totalTCs: " + count_totalTCs);
        System.out.println("count_passedTCs: " + count_passedTCs);
        System.out.println("count_failedTCs: " + count_failedTCs);
        System.out.println("count_skippedTCs: " + count_skippedTCs);

        return "<html>\r\n" + "\r\n" + " \r\n" + "\r\n"
                + "        <body> \r\n<table class=\"container\" align=\"center\" style=\"padding-top:20px\">\r\n<tr align=\"center\"><td colspan=\"4\"><h2>"
                + REPORT_TITLE + "</h2></td></tr>\r\n<tr><td>\r\n\r\n"
                + "       <table style=\"background:#67c2ef;width:120px\" >\r\n"
                + "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
                + count_totalTCs + "</td></tr>\r\n"
                + "                     <tr><td align=\"center\">Total</td></tr>\r\n" + "       \r\n"
                + "                </table>\r\n" + "                </td>\r\n" + "                <td>\r\n"
                + "               \r\n" + "                 <table style=\"background:#79c447;width:120px\">\r\n"
                + "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
                + count_passedTCs + "</td></tr>\r\n"
                + "                     <tr><td align=\"center\">Passed</td></tr>\r\n" + "       \r\n"
                + "                </table>\r\n" + "                </td>\r\n" + "                <td>\r\n"
                + "                <table style=\"background:#ff5454;width:120px\">\r\n"
                + "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
                + count_failedTCs + "</td></tr>\r\n"
                + "                     <tr><td align=\"center\">Failed</td></tr>\r\n" + "       \r\n"
                + "                </table>\r\n" + "                \r\n" + "                </td>\r\n"
                + "                <td>\r\n" + "                <table style=\"background:#fabb3d;width:120px\">\r\n"
                + "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
                + count_skippedTCs + "</td></tr>\r\n"
                + "                     <tr><td align=\"center\">Skipped/Retried</td></tr>\r\n" + "       \r\n"
                + "                </table>\r\n" + "                \r\n" + "                </td>\r\n"
                + "                </tr>\r\n" + "               \r\n" + "                \r\n"
                + "            </table>\r\n" + "       \r\n" + "    </body>\r\n" + "</html>";
    }
}
