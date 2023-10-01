public class UntrustworthyMailWorker implements MailService {
    public MailService[] mailService;

    public RealMailService realMailService;

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable count = mail;
        for (MailService service : mailService) {
            count = service.processMail(mail);
        }
        return realMailService.processMail(count);
    }

    UntrustworthyMailWorker(MailService[] mailService) {
        this.mailService = mailService;
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }
}
