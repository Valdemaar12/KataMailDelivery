public class UntrustworthyMailWorker implements MailService {
    private MailService[] mailService;

    private RealMailService realMailService;

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable count = mail;
        for (MailService service : mailService) {
            count = service.processMail(mail);
        }
        return realMailService.processMail(count);
    }

    public UntrustworthyMailWorker(MailService[] mailService) {
        this.mailService = mailService;
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }
}
