public class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            if (((MailPackage) mail).getContent().getContent().contains("weapons") ||
                    ((MailPackage) mail).getContent().getContent().contains("banned substance")) {
                throw new IllegalPackageException();
            }
            if (((MailPackage) mail).getContent().getContent().contains("stones")) {
                throw new StolenPackageException();
            }
        }
        return mail;
    }

}
