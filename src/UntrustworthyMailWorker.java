public class UntrustworthyMailWorker implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        return null;
    }

    UntrustworthyMailWorker(MailService[] mailService) {

    }
}
