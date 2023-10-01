public class Thief implements MailService {
    private final int minCost;
    private int sumStolenPackages = 0;

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage && ((MailPackage) mail).getContent().getPrice() > minCost) {
            sumStolenPackages += ((MailPackage) mail).getContent().getPrice();
            Package newPackage = new Package("stones instead of " + ((MailPackage) mail).getContent().getContent(), 0);
            return new MailPackage(mail.getFrom(), mail.getTo(), newPackage);
        }
        return mail;
    }

    public Thief(int minCost) {
        this.minCost = minCost;
    }

    public int getStolenValue() {
        return sumStolenPackages;
    }
}
