package vod.repository.mem;

import vod.model.Tanker;
import vod.model.Platoon;
import vod.model.Tank;

import java.util.ArrayList;
import java.util.List;

class SampleData {

    static List<Tanker> tankers = new ArrayList<>();

    static List<Platoon> platoons = new ArrayList<>();

    static List<Tank> tanks = new ArrayList<>();

    static {
        Platoon Torpeda74 = new Platoon(1, "Torpeda74");
        Platoon PodwodniPomorzanie = new Platoon(2, "PodwodniPomorzanie");
        Platoon BatalionSwMateusza = new Platoon(3, "BatalionSwMateusza");
        Platoon OlkuscyGornicy = new Platoon(4, "OlkuscyGornicy");


        Tank tiger = new Tank(1, "Tiger", Torpeda74);
        Tank maus = new Tank(2, "Maus", Torpeda74);
        Tank panter = new Tank(3, "Panter", Torpeda74);

        Tank is7 = new Tank(4, "IS-7", Torpeda74);
        Tank is3 = new Tank(5, "IS-3", Torpeda74);
        Tank t3485 = new Tank(6, "T 34-85", Torpeda74);
        Tank t10 = new Tank(7, "T-10", Torpeda74);

        Tank m103 = new Tank(7, "M103", Torpeda74);
        Tank t110E5 = new Tank(8, "T110E5", Torpeda74);
        Tank t49 = new Tank(9, "T49", Torpeda74);
        Tank t110E3 = new Tank(10, "T110E3", Torpeda74);

        Tank fochB = new Tank(11, "Foch B", Torpeda74);
        Tank bc25t = new Tank(12, "B-C 25t", Torpeda74);


        bind(tiger, Torpeda74);
        bind(maus, Torpeda74);
        bind(panter, Torpeda74);

        bind(is7, PodwodniPomorzanie);
        bind(is3, PodwodniPomorzanie);
        bind(t3485, PodwodniPomorzanie);
        bind(t10, PodwodniPomorzanie);

        bind(m103, BatalionSwMateusza);
        bind(t110E5, BatalionSwMateusza);
        bind(t49, BatalionSwMateusza);
        bind(t110E3, BatalionSwMateusza);

        bind(fochB, OlkuscyGornicy);
        bind(bc25t, OlkuscyGornicy);


        Tanker JohnSmith = new Tanker(1, "John", "Smith");
        Tanker MichaelJohnson = new Tanker(2, "Michael", "Johnson");
        Tanker WilliamBrown = new Tanker(3, "William", "Brown");
        Tanker JamesDavis = new Tanker(4, "James", "Davis");
        Tanker RobertMiller = new Tanker(5, "Robert", "Miller");
        Tanker DavidWilson = new Tanker(6, "David", "Wilson");
        Tanker RichardMoore = new Tanker(7, "Richard", "Moore");
        Tanker JosephTaylor = new Tanker(8, "Joseph", "Taylor");
        Tanker CharlesAnderson = new Tanker(9, "Charles", "Anderson");
        Tanker ThomasJackson = new Tanker(10, "Thomas", "Jackson");
        Tanker GeorgeWalker = new Tanker(11, "George", "Walker");
        Tanker HenryScott = new Tanker(12, "Henry", "Scott");
        Tanker EdwardHarris = new Tanker(13, "Edward", "Harris");
        Tanker ChristopherClark = new Tanker(14, "Christopher", "Clark");
        Tanker DanielLewis = new Tanker(15, "Daniel", "Lewis");
        Tanker PaulRobinson = new Tanker(16, "Paul", "Robinson");
        Tanker MarkMartinez = new Tanker(17, "Mark", "Martinez");
        Tanker StevenWhite = new Tanker(18, "Steven", "White");
        Tanker AndrewThompson = new Tanker(19, "Andrew", "Thompson");
        Tanker JoshuaGarcia = new Tanker(20, "Joshua", "Garcia");
        Tanker AnthonyMartinez = new Tanker(21, "Anthony", "Martinez");
        Tanker BrianHernandez = new Tanker(22, "Brian", "Hernandez");
        Tanker KevinLopez = new Tanker(23, "Kevin", "Lopez");
        Tanker MatthewGonzalez = new Tanker(24, "Matthew", "Gonzalez");
        Tanker DonaldWilson = new Tanker(25, "Donald", "Wilson");
        Tanker JeffreySanchez = new Tanker(26, "Jeffrey", "Sanchez");

        bind(JohnSmith, tiger);
        bind(MichaelJohnson, tiger);
        bind(WilliamBrown, maus);
        bind(JamesDavis, maus);
        bind(RobertMiller, maus);
        bind(DavidWilson, panter);
        bind(RichardMoore, is7);
        bind(JosephTaylor, is7);
        bind(CharlesAnderson, is7);
        bind(ThomasJackson, is3);
        bind(GeorgeWalker, is3);
        bind(HenryScott, t3485);
        bind(EdwardHarris, t10);
        bind(ChristopherClark, t10);
        bind(DanielLewis, t10);

        bind(PaulRobinson, m103);
        bind(MarkMartinez, m103);
        bind(StevenWhite, t110E5);
        bind(AndrewThompson, t110E5);
        bind(JoshuaGarcia, t110E5);
        bind(AnthonyMartinez, t49);
        bind(BrianHernandez, t110E3);
        bind(KevinLopez, t110E3);
        bind(MatthewGonzalez, fochB);
        bind(DonaldWilson, fochB);
        bind(JeffreySanchez, bc25t);

        tanks.add(tiger);
        tanks.add(maus);
        tanks.add(panter);
        tanks.add(is7);
        tanks.add(is3);
        tanks.add(t3485);
        tanks.add(t10);
        tanks.add(m103);
        tanks.add(t110E5);
        tanks.add(t49);
        tanks.add(t110E3);
        tanks.add(fochB);
        tanks.add(bc25t);


        tankers.add(JohnSmith);
        tankers.add(MichaelJohnson);
        tankers.add(WilliamBrown);
        tankers.add(JamesDavis);
        tankers.add(RobertMiller);
        tankers.add(DavidWilson);
        tankers.add(RichardMoore);
        tankers.add(JosephTaylor);
        tankers.add(CharlesAnderson);
        tankers.add(ThomasJackson);
        tankers.add(GeorgeWalker);
        tankers.add(HenryScott);
        tankers.add(EdwardHarris);
        tankers.add(ChristopherClark);
        tankers.add(DanielLewis);
        tankers.add(PaulRobinson);
        tankers.add(MarkMartinez);
        tankers.add(StevenWhite);
        tankers.add(AndrewThompson);
        tankers.add(JoshuaGarcia);
        tankers.add(AnthonyMartinez);
        tankers.add(BrianHernandez);
        tankers.add(KevinLopez);
        tankers.add(MatthewGonzalez);
        tankers.add(DonaldWilson);
        tankers.add(JeffreySanchez);
    }

    private static void bind(Tanker c, Tank m) {
        c.addTank(m);
        m.addTanker(c);
    }

    private static void bind(Tank m, Platoon d) {
        d.addTanks(m);
        m.setPlatoon(d);
    }
}