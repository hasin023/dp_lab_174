import Concretes.Threads;
import Facades.SocialMediaFacade;

public class App {
    public static void main(String[] args) throws Exception {
        SocialMediaFacade socialMediaFacade = new SocialMediaFacade();

        System.out.println(socialMediaFacade.getAllNotifications());

        socialMediaFacade.addSocialMediaPlatform("Threads", new Threads());

        System.out.println(socialMediaFacade.getAllNotifications());
    }
}
