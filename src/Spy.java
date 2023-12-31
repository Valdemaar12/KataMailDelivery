import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {

    private final Logger loggerSpy;

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            if (mail.getFrom().equals(Main.AUSTIN_POWERS) || mail.getTo().equals(Main.AUSTIN_POWERS)) {
                loggerSpy.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new Object[]{mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
            } else {
                loggerSpy.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                        new Object[]{mail.getFrom(), mail.getTo()});
            }
        }
        return mail;
    }


    public Spy(Logger logger) {
        loggerSpy = logger;
    }
}
