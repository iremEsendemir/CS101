public class ProjectApp {
    public static void main(String[] args) {
        Project p1 = new Project("ArcTech Business Solution",18000, 500, 5);
        Project p2 = new Project("SunMarkets POS Implementation",25000, 250, 8);
        System.out.println(p1.toString());
        System.out.println(p2.toString());

        p1.setRatePerHour(1.5);
        p1.setProjectWeeks(8);
        System.out.println(p1.toString());

        p2.deactivateProject();
        System.out.println(p2.toString());





    }
}
